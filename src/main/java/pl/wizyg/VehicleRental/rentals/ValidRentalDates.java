package pl.wizyg.VehicleRental.rentals;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {RentalValidator.class})
public @interface ValidRentalDates {
    String message() default "Invalid rental dates";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
