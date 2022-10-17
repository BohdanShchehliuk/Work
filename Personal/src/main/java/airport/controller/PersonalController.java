package airport.controller;


import airport.dto.PersonalDto;
import airport.entity.Personal;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;

import airport.service.impl.PersonalServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonalController {
    final private PersonalServiceImpl personalService;
    final private ModelMapper mapToEntity;
    final private ModelMapper mapToDTO;
    static final String ANSI_RED = "\u001B[31m";


    @PostMapping("/personal/post/")
    public String savePersonal(@RequestBody PersonalDto personalDto) throws UserAlreadyExistException {
        log.info("Controller /passenger/post/ started work");
        personalService.addPersonal(mapToEntity.map(personalDto, Personal.class));
        return "You add a new passenger from Front End";
    }

       @GetMapping("/personal/create/")
    public String create(String name, int numbPhone) throws UserAlreadyExistException {
        log.info("Controller /personal/create/ started work");
        PersonalDto personalDto = PersonalDto.builder()
                .name(name)
                .numbPhone(numbPhone)
                .build();
        return savePersonal(personalDto);
    }

     @GetMapping("/personal/getAll/")
    public String getAll() throws UserNotFoundException {
        log.info("Controller /personal/getAll/ started work");
        return personalService.getAll().toString();
    }
    @GetMapping("/personal/getByPhoneNumber/")
    public String getPersonalByNumbPhone(@RequestParam int NumbPhone) throws UserNotFoundException {
        log.info("Controller /personal/getByPhoneNumber/ started work");
        return personalService.getPersonalByNumbPhone(NumbPhone).toString();
    }
    @GetMapping("/personal/getPersonalByGate/")
    public String getPersonalByGate(@RequestParam int gate) throws UserNotFoundException {
        log.info("Controller /personal/getPersonalByGate/ started work");
        return personalService.getPersonalByGate(gate).toString();
    }
}


