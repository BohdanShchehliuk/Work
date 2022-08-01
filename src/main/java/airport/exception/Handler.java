package airport.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public CustomException resourceNotFountException(CustomException ex) {
        return ex;
    }
}
