package pl.wizyg.VehicleRental.rentals;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findAllByStartDate(LocalDate startDate);

    List<Rental> findAllByEndDate(LocalDate endDate);

    List<Rental> findAllByCustomer_Id(Integer customerId);

    List<Rental> findAllByVehicle_Id(Integer vehicleId);

    List<Rental> findAllByCustomer_Email(String email);

    Optional<Rental> findByCustomer_IdAndStartDate(Integer customerId, LocalDate startDate);

    Optional<Rental> findByCustomer_IdAndEndDate(Integer customerId, LocalDate endDate);

    List<Rental> findByCustomer_IdAndStartDateAfter(Integer customerId, LocalDate startDate);

    List<Rental> findByCustomer_IdAndEndDateAfter(Integer customerId, LocalDate endDate);

    List<Rental> findByCustomer_IdAndStartDateBefore(Integer customerId, LocalDate startDate);

    List<Rental> findByCustomer_IdAndEndDateBefore(Integer customerId, LocalDate endDate);

    List<Rental> findAllByVehicle_IdAndStartDateBeforeAndEndDateAfter(Integer vehicle_id, @NotNull LocalDate startDate, LocalDate endDate);

//    @Query("Select r from Rental r Where r.vehicle instanceof RoadVehicle type(RoadVehicle.class) like :lic")
//    List<Rental> findRentalsByLicPlate(@Param("lic") String licPlate);

}
