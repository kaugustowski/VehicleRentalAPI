package pl.wizyg.VehicleRental.rentals;

import org.springframework.stereotype.Service;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.customers.CustomerService;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultRentalService implements RentalService {

    final
    RentalRepository rentalRepository;

    final VehicleService vehicleService;

    final CustomerService customerService;

    public DefaultRentalService(RentalRepository rentalRepository, VehicleService vehicleService, CustomerService customerService) {
        this.rentalRepository = rentalRepository;
        this.vehicleService = vehicleService;
        this.customerService = customerService;
    }

    @Override
    public Rental getRental(int id) throws RentalNotFoundException {
        return rentalRepository.findById(id).orElseThrow(() -> new RentalNotFoundException("Rental with id:" + id + " not found"));
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental addRental(RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalsOverlapException {
        Rental rental = new Rental(rentalDTO.getStartDate(),
                rentalDTO.getEndDate(),
                rentalDTO.getWithTransport(),
                customerService.getCustomer(rentalDTO.getCustomerId()),
                vehicleService.getVehicle(rentalDTO.getVehicleId()));

        List<Rental> rentals = getOverlappingRentals(rental);

        if (rentals.isEmpty())
            return rentalRepository.save(rental);
        else
            throw new RentalsOverlapException("Rental overlaps with existing one!");
    }

    public List<Rental> getOverlappingRentals(Rental rental) {
        return rentalRepository.findAllByVehicle_IdAndStartDateBeforeAndEndDateAfter(rental.getVehicle().getId(),
                rental.getEndDate(),
                rental.getStartDate());
    }

    @Override
    public List<Rental> getCustomerRentals(int id) {
        return rentalRepository.findAllByCustomer_Id(id);
    }

    @Override
    public List<Rental> getCustomerRentals(String email) {
        return rentalRepository.findAllByCustomer_Email(email);
    }

    @Override
    public List<Rental> getVehicleRentals(int vehicleId) {
        return rentalRepository.findAllByVehicle_Id(vehicleId);
    }

    @Override
    public List<Rental> getRentalsByStartDate(LocalDate startDate) {
        return rentalRepository.findAllByStartDate(startDate);
    }

    @Override
    public List<Rental> getRentalsByEndDate(LocalDate endDate) {
        return rentalRepository.findAllByEndDate(endDate);
    }

    @Override
    public Rental getRentalByCustomerIdAndStartDate(int id, LocalDate startDate) throws RentalNotFoundException {
        return rentalRepository.findByCustomer_IdAndStartDate(id, startDate).orElseThrow(RentalNotFoundException::new);
    }

    @Override
    public Rental getRentalByCustomerIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException {
        return rentalRepository.findByCustomer_IdAndEndDate(id, endDate).orElseThrow(RentalNotFoundException::new);
    }

    @Override
    public void deleteRental(int rentalId) throws RentalNotFoundException {
        Rental rental = getRental(rentalId);
        rentalRepository.delete(rental);
    }

    @Override
    public Rental updateRental(int rentalId, RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalNotFoundException {

        Rental rental = getRental(rentalId);

        if (rentalDTO.getCustomerId() != null)
            rental.setCustomer(customerService.getCustomer(rentalDTO.getCustomerId()));
        if (rentalDTO.getVehicleId() != null)
            rental.setVehicle(vehicleService.getVehicle(rentalDTO.getVehicleId()));
        if (rentalDTO.getStartDate() != null)
            rental.setStartDate(rentalDTO.getStartDate());
        if (rentalDTO.getEndDate() != null)
            rental.setEndDate(rentalDTO.getEndDate());
        if (rentalDTO.getWithTransport() != null)
            rental.setWithTransport(rentalDTO.getWithTransport());

        return rental;
    }

    @Override
    public List<Rental> getRentalsByCustomerIdAndStartDateAfter(int customerId, LocalDate startDate) {
        return rentalRepository.findByCustomer_IdAndStartDateAfter(customerId, startDate);
    }

    @Override
    public List<Rental> getRentalsByCustomerIdAndEndDateAfter(int customerId, LocalDate endDate) {
        return rentalRepository.findByCustomer_IdAndEndDateAfter(customerId, endDate);
    }

    @Override
    public List<Rental> getRentalsByCustomerIdAndStartDateBefore(int customerId, LocalDate startDate) {
        return rentalRepository.findByCustomer_IdAndStartDateBefore(customerId, startDate);
    }

    @Override
    public List<Rental> getRentalsByCustomerIdAndEndDateBefore(int customerId, LocalDate endDate) {
        return rentalRepository.findByCustomer_IdAndEndDateBefore(customerId, endDate);
    }
}
