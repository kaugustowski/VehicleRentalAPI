package pl.wizyg.VehicleRental.vehicles;

import pl.wizyg.VehicleRental.vehicles.industrial.IndustrialVehicle;
import pl.wizyg.VehicleRental.vehicles.road.RoadVehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getVehicle(int id);

    Vehicle getVehicle(String licPlate);

    List<Vehicle> getVehicles();

    List<RoadVehicle> getRoadVehicles();

    List<IndustrialVehicle> getIndustrialVehicles();

}
