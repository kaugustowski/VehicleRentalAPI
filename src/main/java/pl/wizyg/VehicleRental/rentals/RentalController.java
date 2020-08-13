package pl.wizyg.VehicleRental.rentals;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {

    final
    RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/list/all")
    List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/list")
    List<Rental> getAllClientRentals(@RequestParam int id) {
        return rentalService.getClientRentals(id);
    }

//    @GetMapping("/list")
//    List<Rental> getAllRentals(@RequestParam String email) {
//        return rentalService.getClientRentals(email);
//    }


}
