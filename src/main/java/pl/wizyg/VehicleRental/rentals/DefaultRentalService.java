package pl.wizyg.VehicleRental.rentals;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultRentalService implements RentalService {

    final
    RentalRepository rentalRepository;

    public DefaultRentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public List<Rental> getClientRentals(int id) {
        return rentalRepository.findAllByClient_Id(id);
    }

    @Override
    public List<Rental> getClientRentals(String email) {
        return rentalRepository.findAllByClient_Email(email);
    }

    @Override
    public List<Rental> getVehicleRentals(int id) {
        return rentalRepository.findAllByVehicle_Id(id);
    }

    @Override
    public List<Rental> getVehicleRentals(String licensePlate) {
        return rentalRepository.findAllByVehicle_LicensePlate(licensePlate);
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
        return rentalRepository.findByClient_IdAndStartDate(id, startDate).orElseThrow(() -> new RentalNotFoundException());
    }

    @Override
    public Rental getRentalByClientIdAndEndDate(int id, LocalDate endDate) throws RentalNotFoundException {
        return rentalRepository.findByClient_IdAndEndDate(id, endDate).orElseThrow(() -> new RentalNotFoundException());
    }
}
