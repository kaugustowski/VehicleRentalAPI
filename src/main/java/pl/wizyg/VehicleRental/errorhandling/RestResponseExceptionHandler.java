package pl.wizyg.VehicleRental.errorhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.rentals.RentalNotFoundException;
import pl.wizyg.VehicleRental.rentals.RentalsOverlapException;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestResponseExceptionHandler {

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(value = RentalsOverlapException.class)
    public ExceptionResponse handleRentalOverlapException(RentalsOverlapException e) {
        return new ExceptionResponse(e.getMessage(), System.currentTimeMillis());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(value = {CustomerNotFoundException.class, VehicleNotFoundException.class, RentalNotFoundException.class})
    public ExceptionResponse handleException(Exception e) {
        return new ExceptionResponse(e.getMessage(), System.currentTimeMillis());
    }


}
