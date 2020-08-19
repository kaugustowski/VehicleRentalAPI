package pl.wizyg.VehicleRental.vehicles;

import org.springframework.stereotype.Service;
import pl.wizyg.VehicleRental.vehicles.industrial.IndustrialVehicle;
import pl.wizyg.VehicleRental.vehicles.industrial.IndustrialVehicleRepository;
import pl.wizyg.VehicleRental.vehicles.road.RoadVehicle;
import pl.wizyg.VehicleRental.vehicles.road.RoadVehicleRepository;

import java.util.List;

@Service
public class DefaultVehicleService implements VehicleService {

    final
    VehicleRepository vehicleRepository;
    final
    IndustrialVehicleRepository industrialVehicleRepository;
    final
    RoadVehicleRepository roadVehicleRepository;

    public DefaultVehicleService(VehicleRepository vehicleRepository,
                                 IndustrialVehicleRepository industrialVehicleRepository,
                                 RoadVehicleRepository roadVehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.industrialVehicleRepository = industrialVehicleRepository;
        this.roadVehicleRepository = roadVehicleRepository;
    }

    @Override
    public Vehicle getVehicle(int id) throws VehicleNotFoundException {
        return vehicleRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle with id: " + id + " not found"));
    }


    @Override
    public RoadVehicle getVehicle(String licPlate) {
        return roadVehicleRepository.findByLicensePlate(licPlate).orElseThrow();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<RoadVehicle> getRoadVehicles() {
        return roadVehicleRepository.findAll();
    }

    @Override
    public List<IndustrialVehicle> getIndustrialVehicles() {
        return industrialVehicleRepository.findAll();
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(int vehicleId, Vehicle vehicle) throws VehicleNotFoundException {
        Vehicle veh = getVehicle(vehicleId);

        if (vehicle.getMake() != null)
            veh.setMake(vehicle.getMake());
        if (vehicle.getModel() != null)
            veh.setModel(vehicle.getModel());
        if (vehicle.getDailyRentalPrice() != null)
            veh.setDailyRentalPrice(vehicle.getDailyRentalPrice());
        if (vehicle.getProductionYear() != null)
            veh.setProductionYear(vehicle.getProductionYear());


        return vehicleRepository.save(veh);
    }
}
