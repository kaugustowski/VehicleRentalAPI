package pl.wizyg.VehicleRental.rentals;

import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {

    Rental getRental(int id) throws RentalNotFoundException;

    List<Rental> getAllRentals();

    Rental addRental(RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalsOverlapException;

    List<Rental> getOverlappingRentals(Rental rental);

    List<Rental> getCustomerRentals(int id, CustomerRentalQuery query);

    List<Rental> getCustomerRentals(String email);

    List<Rental> getVehicleRentals(int vehicleId);

    List<Rental> getRentalsByStartDate(LocalDate startDate);

    List<Rental> getRentalsByEndDate(LocalDate endDate);

    Rental getRentalByCustomerIdAndStartDate(int id, LocalDate startDate) throws RentalNotFoundException;

    Rental getRentalByCustomerIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException;

    void deleteRental(int rentalId) throws RentalNotFoundException;

    Rental updateRental(int rentalId, RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalNotFoundException;
}
