package pl.wizyg.VehicleRental.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;


    @GetMapping("/details")
    public Vehicle getVehicle(@RequestParam int vehicleId) {
        return vehicleRepository.findById(vehicleId).get();
    }

}
