package pl.wizyg.VehicleRental.rentals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RentalValidator implements ConstraintValidator<ValidRentalDates, Rental> {

    @Override
    public void initialize(ValidRentalDates constraintAnnotation) {

    }

    @Override
    public boolean isValid(Rental value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return !value.getEndDate().isBefore(value.getStartDate());
    }
}
