package pl.wizyg.VehicleRental.RESTapi;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.wizyg.VehicleRental.vehicles.Vehicle;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleService;
import pl.wizyg.VehicleRental.vehicles.industrial.IndustrialVehicle;
import pl.wizyg.VehicleRental.vehicles.road.RoadVehicle;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<Vehicle> getVehicle(@PathVariable int vehicleId) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        return EntityModel.of(vehicle,
                linkTo(methodOn(VehicleController.class).getVehicle(vehicleId)).withSelfRel());
    }

    @GetMapping(value = "/road", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RoadVehicle> getRoadVehicles() {
        return vehicleService.getRoadVehicles();
    }

    @GetMapping(value = "/road/{licPlate}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public EntityModel<Vehicle> getRoadVehicleByLicPlate(@PathVariable String licPlate) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.getVehicle(licPlate);
        return EntityModel.of(vehicle,
                linkTo(methodOn(VehicleController.class).getVehicle(vehicle.getId())).withSelfRel());
    }

    @GetMapping(value = "/industrial", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<IndustrialVehicle> getIndustrialVehicles() {
        return vehicleService.getIndustrialVehicles();
    }

    @DeleteMapping(value = "/{vehicleId}")
    public void deleteVehicle(@PathVariable int vehicleId) throws VehicleNotFoundException {
        vehicleService.deleteVehicle(vehicleId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public EntityModel<Vehicle> addVehicle(@RequestBody Vehicle newVehicle) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.addVehicle(newVehicle);
        return EntityModel.of(vehicle,
                linkTo(methodOn(VehicleController.class).getVehicle(vehicle.getId())).withSelfRel());
    }

    @PatchMapping(value = "/{vehicleId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public EntityModel<Vehicle> updateVehicle(@RequestBody Vehicle newVehicle, @PathVariable int vehicleId) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.updateVehicle(vehicleId, newVehicle);
        return EntityModel.of(vehicle,
                linkTo(methodOn(VehicleController.class).getVehicle(vehicle.getId())).withSelfRel());
    }
}