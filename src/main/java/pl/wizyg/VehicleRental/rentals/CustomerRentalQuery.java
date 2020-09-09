package pl.wizyg.VehicleRental.rentals;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CustomerRentalQuery {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate startDateAfter;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate startDateBefore;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate endDateAfter;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate endDateBefore;

}
