package pl.wizyg.VehicleRental.vehicles;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    final
    VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping(value = "/{vehicleId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Vehicle getVehicle(@PathVariable int vehicleId) throws VehicleNotFoundException {
        return vehicleService.getVehicle(vehicleId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @PatchMapping(value = "/{vehicleId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable int vehicleId) throws VehicleNotFoundException {
        return vehicleService.updateVehicle(vehicleId, vehicle);
    }


}
