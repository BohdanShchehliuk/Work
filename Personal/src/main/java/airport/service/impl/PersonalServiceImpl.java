package airport.service.impl;

import airport.entity.Personal;
import airport.exception.CustomException;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.repository.PersonalRepository;
import airport.service.PersonalService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonalServiceImpl implements PersonalService {
    private ModelMapper mapperToDTO = new ModelMapper();
    @Autowired
    public PersonalRepository personalRepository;

    @Override
    public Personal addPersonal(Personal personal) throws UserAlreadyExistException {
        log.info("Service / Personal addPersonal/ started work");
        Optional<String> name = Optional.ofNullable(personal.getName());
        if (name.isEmpty())
            throw new CustomException("Check Name");
        if (!personalRepository.findAll()
                .stream()
                .filter(p -> p.getName().equals(personal.getName()))
                .findFirst().isEmpty()) {
            throw new UserAlreadyExistException(personal.getId(), "Passenger " + personal.getName() + " already exists");
        }
        return personalRepository.save(personal);
    }

    @Override
    public List<Personal> getAll() throws UserNotFoundException {
        log.info("Service /List<Personal> getAll()/ started work");
        List<Personal> list = personalRepository.findAll();
        if (list.isEmpty()) {
            throw new UserNotFoundException("List of Passengers is empty");
        }
        return list;
    }

    @Override
    public Personal getPersonalByNumbPhone(int numbPhone) throws UserNotFoundException {
        log.info("Service /Personal getPersonalByNumbPhone(String numbPhone) / started work");
        Optional<Personal> personal = Optional.ofNullable(personalRepository.findByNumbPhone(numbPhone));
        if (personal.isEmpty()) {
            throw new UserNotFoundException("Personal with numbPhone " + numbPhone + "is absent");
        }
        return personal.get();
    }

    @Override
    public String delete(String name) throws Exception {
        log.info("Service / String delete(String name)/ started work");
        if (personalRepository.findAll()
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().isEmpty()) {
            throw new UserNotFoundException("Personal with such name dose not exist");
        }
        personalRepository.delete(personalRepository.findByName(name));
        return "Personal " + name + " successfully deleted";
    }

    @Override
    public List<Personal> getPersonalByGate(int numberOfgate) throws UserNotFoundException {
        log.info("Service /List<Passenger> getPassengerByFlightNumb/ started work");
        if (numberOfgate <= 0) throw new CustomException("Type numberOfgate again");
        List<Personal> list = personalRepository.getPersonalByGate(numberOfgate);
        if (list.isEmpty()) {
            throw new UserNotFoundException("There are no personal in Gate with  numberOfgate " +  numberOfgate);
        }
        return list;
    }
}
