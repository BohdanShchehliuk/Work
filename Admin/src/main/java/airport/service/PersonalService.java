package airport.service;

import airport.entity.Personal;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;

import java.util.List;

public interface PersonalService {
    Personal addPersonal(Personal personal) throws UserAlreadyExistException;

    List<Personal > getAll() throws UserNotFoundException;

    Personal  getPersonalByNumbPhone(int numbPhone) throws UserNotFoundException;

    String delete(String name) throws Exception;

    List<Personal > getPersonalByGate(int numberOfgate) throws UserNotFoundException;
}
