package airport.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Data
@AllArgsConstructor
public class UserNotFoundException extends Exception {
    private String exceptionMassage;
}
