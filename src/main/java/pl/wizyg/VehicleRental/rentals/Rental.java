package pl.wizyg.VehicleRental.rentals;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.wizyg.VehicleRental.customers.Customer;
import pl.wizyg.VehicleRental.vehicles.Vehicle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@Entity
@Table(name = "rental")
@ValidRentalDates(message = "End date must not be before start date")
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
    @Column(name = "withTransport")
    private boolean withTransport;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Vehicle vehicle;

    public int getRentalDays() {
        return (int) (DAYS.between(startDate, endDate) + 1);
    }

    public int getTotalCost() {
        return getTransportCost() + getRentalCost();
    }

    public int getTransportCost() {
        int transportCost = 0;

        if (withTransport)
            transportCost = vehicle.getTransportCost();
        return transportCost;
    }

    public int getRentalCost() {
        return getRentalDays() * vehicle.getDailyRentalPrice();
    }


}
