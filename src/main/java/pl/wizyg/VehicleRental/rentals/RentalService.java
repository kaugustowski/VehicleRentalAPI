package pl.wizyg.VehicleRental.rentals;

import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {

    Rental getRental(int id);

    List<Rental> getAllRentals();

    Rental addRental(RentalDTO rentalDTO) throws CustomerNotFoundException;

    List<Rental> getCustomerRentals(int id);

    List<Rental> getCustomerRentals(String email);

    List<Rental> getVehicleRentals(int id);

    List<Rental> getVehicleRentals(String licensePlate);

    List<Rental> getRentalsByStartDate(LocalDate startDate);

    List<Rental> getRentalsByEndDate(LocalDate endDate);

    Rental getRentalByClientIdAndStartDate(int id, LocalDate startDate) throws RentalNotFoundException;

    Rental getRentalByClientIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException;

}
