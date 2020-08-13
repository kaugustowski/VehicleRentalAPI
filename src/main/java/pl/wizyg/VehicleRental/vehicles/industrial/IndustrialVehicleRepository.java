package pl.wizyg.VehicleRental.vehicles.industrial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndustrialVehicleRepository extends JpaRepository<IndustrialVehicle, Integer> {

    List<IndustrialVehicle> findAllByMake(String make);

    List<IndustrialVehicle> findAllByModel(String model);

    List<IndustrialVehicle> findAllByProductionYear(int productionYear);

}
