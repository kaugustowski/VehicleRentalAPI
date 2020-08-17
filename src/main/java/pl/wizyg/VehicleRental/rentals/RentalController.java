package pl.wizyg.VehicleRental.rentals;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    final
    RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/customer/{customerId}")
    List<Rental> getAllCustomerRentals(@PathVariable int customerId) {
        return rentalService.getCustomerRentals(customerId);
    }

    @GetMapping("/list")
    List<Rental> getCustomerRentalsByEmail(@RequestParam String email) {
        return rentalService.getCustomerRentals(email);
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Rental addRental(@RequestBody RentalDTO rentalDTO) throws CustomerNotFoundException {
        return rentalService.addRental(rentalDTO);
    }


}
