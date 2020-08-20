package pl.wizyg.VehicleRental.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findAllByMake(String make);

    List<Vehicle> findAllByModel(String model);

    List<Vehicle> findAllByProductionYear(int productionYear);

}
