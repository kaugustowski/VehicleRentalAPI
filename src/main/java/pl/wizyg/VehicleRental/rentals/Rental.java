package pl.wizyg.VehicleRental.rentals;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.wizyg.VehicleRental.customers.Customer;
import pl.wizyg.VehicleRental.vehicles.Vehicle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rental")
@ValidRentalDates(message = "End date must not be before start date")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    @Column(name = "with_transport")
    private boolean withTransport;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Rental(@NotNull LocalDate startDate, LocalDate endDate, boolean withTransport, Customer customer, Vehicle vehicle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.withTransport = withTransport;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public int getNumberOfRentalDays() {
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
        return getNumberOfRentalDays() * vehicle.getDailyRentalPrice();
    }
}
