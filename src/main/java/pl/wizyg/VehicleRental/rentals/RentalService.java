package pl.wizyg.VehicleRental.rentals;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {

    List<Rental> getAllRentals();

    List<Rental> getClientRentals(int id);

    List<Rental> getClientRentals(String email);

    List<Rental> getVehicleRentals(int id);

    List<Rental> getVehicleRentals(String licensePlate);

    List<Rental> getRentalsByStartDate(LocalDate startDate);

    List<Rental> getRentalsByEndDate(LocalDate endDate);

    Rental getRentalByClientIdAndStartDate(int id, LocalDate startDate) throws RentalNotFoundException;

    Rental getRentalByClientIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException;

}
