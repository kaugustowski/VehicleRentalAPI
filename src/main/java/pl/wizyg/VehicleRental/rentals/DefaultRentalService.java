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
    public Rental getRental(int id) {
        return rentalRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental addRental(RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException {
        Rental rental = new Rental(rentalDTO.getStartDate(),
                rentalDTO.getEndDate(),
                rentalDTO.getWithTransport(),
                customerService.getCustomer(rentalDTO.getCustomerId()),
                vehicleService.getVehicle(rentalDTO.getVehicleId()));

        return rentalRepository.save(rental);
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
    public List<Rental> getVehicleRentals(int id) {
        return rentalRepository.findAllByVehicle_Id(id);
    }

    @Override
    public List<Rental> getVehicleRentals(String licensePlate) {
        return null;
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
    public Rental getRentalByClientIdAndStartDate(int id, LocalDate startDate) throws RentalNotFoundException {
        return rentalRepository.findByCustomer_IdAndStartDate(id, startDate).orElseThrow(RentalNotFoundException::new);
    }

    @Override
    public Rental getRentalByClientIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException {
        return rentalRepository.findByCustomer_IdAndEndDate(id, endDate).orElseThrow(RentalNotFoundException::new);
    }

    @Override
    public void deleteRental(int rentalId) {
        Rental rental = getRental(rentalId);
        rentalRepository.delete(rental);
    }

    @Override
    public Rental updateRental(int rentalId, RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException {

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
}
