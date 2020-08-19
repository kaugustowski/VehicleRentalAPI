package pl.wizyg.VehicleRental.vehicles;

import pl.wizyg.VehicleRental.vehicles.industrial.IndustrialVehicle;
import pl.wizyg.VehicleRental.vehicles.road.RoadVehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getVehicle(int id) throws VehicleNotFoundException;

    RoadVehicle getVehicle(String licPlate);

    List<Vehicle> getVehicles();

    List<RoadVehicle> getRoadVehicles();

    List<IndustrialVehicle> getIndustrialVehicles();

    Vehicle addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(int vehicleId, Vehicle vehicle) throws VehicleNotFoundException;
}
