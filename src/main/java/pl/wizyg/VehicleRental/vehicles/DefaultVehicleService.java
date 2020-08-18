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
}
