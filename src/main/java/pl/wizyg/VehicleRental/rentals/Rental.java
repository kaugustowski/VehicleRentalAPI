package pl.wizyg.VehicleRental.rentals;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.wizyg.VehicleRental.clients.Client;
import pl.wizyg.VehicleRental.vehicles.Vehicle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@Entity
@Table(name = "rental")
@ValidRentalDates
public class Rental {

    @NotNull
    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate startDate;
    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate endDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Client client;

    @OneToOne
    private Vehicle vehicle;

    public int getRentalDays() {
        return (int) (DAYS.between(startDate, endDate) + 1);
    }


}
