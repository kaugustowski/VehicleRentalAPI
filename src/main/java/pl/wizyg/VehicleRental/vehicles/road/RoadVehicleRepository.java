package pl.wizyg.VehicleRental.vehicles.road;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoadVehicleRepository extends JpaRepository<RoadVehicle, Integer> {

    List<RoadVehicle> findAllByMake(String make);

    List<RoadVehicle> findAllByModel(String model);

    List<RoadVehicle> findAllByProductionYear(int productionYear);

    Optional<RoadVehicle> findByLicensePlate(String licPlate);

}
