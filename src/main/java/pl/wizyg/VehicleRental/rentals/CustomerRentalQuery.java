package pl.wizyg.VehicleRental.rentals;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class CustomerRentalQuery {

    public static final LocalDate DEFAULT_MIN_DATE = LocalDate.of(1970, 1, 1);
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDateAfter;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDateBefore;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDateAfter;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDateBefore;


    public LocalDate getStartDateAfter() {
        return Objects.requireNonNullElse(startDateAfter, DEFAULT_MIN_DATE);
    }

    public LocalDate getStartDateBefore() {
        return Objects.requireNonNullElse(startDateBefore, getDefaultMaxDate());
    }

    public LocalDate getEndDateAfter() {
        return Objects.requireNonNullElse(endDateAfter, DEFAULT_MIN_DATE);
    }

    public LocalDate getEndDateBefore() {
        return Objects.requireNonNullElse(endDateBefore, getDefaultMaxDate());
    }

    private LocalDate getDefaultMaxDate() {
        return LocalDate.now().plusYears(1000);
    }
}
