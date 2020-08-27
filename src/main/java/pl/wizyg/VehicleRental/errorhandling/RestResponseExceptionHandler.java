package pl.wizyg.VehicleRental.errorhandling;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse handleException(Exception e) {
        return new ExceptionResponse(e.getMessage(), System.currentTimeMillis());
    }

}
