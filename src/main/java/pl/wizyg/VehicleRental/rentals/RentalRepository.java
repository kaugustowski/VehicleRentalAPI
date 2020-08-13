package pl.wizyg.VehicleRental.rentals;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findAllByStartDate(LocalDate startDate);

    List<Rental> findAllByEndDate(LocalDate endDate);

    List<Rental> findAllByCustomer_Id(Integer clientId);

    List<Rental> findAllByVehicle_Id(Integer vehicleId);

    List<Rental> findAllByCustomer_Email(String email);

    Optional<Rental> findByCustomer_IdAndStartDate(Integer id, LocalDate startDate);

    Optional<Rental> findByCustomer_IdAndEndDate(Integer id, LocalDate endDate);

}
