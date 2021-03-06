package pl.wizyg.VehicleRental.rentals;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class RentalDTO {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private Boolean withTransport;

    private Integer customerId;

    private Integer vehicleId;

    private int numberOfRentalDays;

    private int totalCost;

    private int transportCost;

    private int rentalCost;

    @Builder
    public RentalDTO(LocalDate startDate, LocalDate endDate, Integer customerId, Integer vehicleId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
    }

    public RentalDTO(Rental rental) {
        this.startDate = rental.getStartDate();
        this.endDate = rental.getEndDate();
        this.withTransport = rental.getWithTransport();
        this.customerId = rental.getCustomer().getId();
        this.vehicleId = rental.getVehicle().getId();
        this.numberOfRentalDays = rental.getNumberOfRentalDays();
        this.totalCost = rental.getTotalCost();
        this.transportCost = rental.getTransportCost();
        this.rentalCost = rental.getRentalCost();
    }
}
