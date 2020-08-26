package pl.wizyg.VehicleRental.rentals;

import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {

    Rental getRental(int id);

    List<Rental> getAllRentals();

    Rental addRental(RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalsOverlapException;

    List<Rental> getCustomerRentals(int id);

    List<Rental> getCustomerRentals(String email);

    List<Rental> getVehicleRentals(int vehicleId);

    List<Rental> getRentalsByStartDate(LocalDate startDate);

    List<Rental> getRentalsByEndDate(LocalDate endDate);

    Rental getRentalByCustomerIdAndStartDate(int id, LocalDate startDate) throws RentalNotFoundException;

    Rental getRentalByCustomerIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException;

    List<Rental> getRentalsByCustomerIdAndStartDateAfter(int id, LocalDate startDate);

    List<Rental> getRentalsByCustomerIdAndEndDateAfter(int id, LocalDate endDate);

    List<Rental> getRentalsByCustomerIdAndStartDateBefore(int id, LocalDate startDate);

    List<Rental> getRentalsByCustomerIdAndEndDateBefore(int id, LocalDate endDate);

    void deleteRental(int rentalId);

    Rental updateRental(int rentalId, RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException;
}
