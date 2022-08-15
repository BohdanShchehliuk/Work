package airport.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
@Data
@AllArgsConstructor
public class UserNotFoundException extends Exception implements Supplier<Object> {
    private String exceptionMassage;


    @Override
    public Object get() {
        return new UserNotFoundException(exceptionMassage);
    }
}
