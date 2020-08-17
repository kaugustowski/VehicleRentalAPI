package pl.wizyg.VehicleRental.rentals;

import org.springframework.stereotype.Service;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.customers.CustomerService;
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
    public Rental addRental(RentalDTO rentalDTO) throws CustomerNotFoundException {
        Rental rental = new Rental(rentalDTO.getStartDate(),
                rentalDTO.getEndDate(),
                rentalDTO.isWithTransport(),
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
}
