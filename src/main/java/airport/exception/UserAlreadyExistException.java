package airport.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
public class UserAlreadyExistException extends Exception {
    private int id;
    private String exceptionMassage;
}
