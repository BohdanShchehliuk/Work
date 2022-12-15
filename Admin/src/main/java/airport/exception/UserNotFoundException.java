package airport.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserNotFoundException extends Exception {
    private String exceptionMassage;
}
