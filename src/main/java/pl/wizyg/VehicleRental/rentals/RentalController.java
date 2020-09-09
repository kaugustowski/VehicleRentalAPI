package pl.wizyg.VehicleRental.rentals;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    final
    RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{rentalId}")
    public EntityModel<Rental> getRental(@PathVariable int rentalId) throws RentalNotFoundException {
        Rental rental = rentalService.getRental(rentalId);
        return EntityModel.of(rental,
                linkTo(methodOn(RentalController.class).getRental(rental.getId())).withSelfRel());
    }

    @GetMapping("/customers/{customerId}")
    public List<Rental> getAllCustomerRentals(@PathVariable int customerId, CustomerRentalQuery query) {
        return rentalService.getCustomerRentals(customerId, query);
    }

    @GetMapping("/customers/email")
    public List<Rental> getCustomerRentalsByEmail(@RequestParam String email) {
        return rentalService.getCustomerRentals(email);
    }

    @GetMapping("/vehicles/{vehicleId}")
    public List<Rental> getCustomerRentalsByEmail(@PathVariable int vehicleId) {
        return rentalService.getVehicleRentals(vehicleId);
    }

    @GetMapping(value = "/startDate", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<Rental> getRentalsByStartDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return rentalService.getRentalsByStartDate(date);
    }

    @GetMapping(value = "/endDate", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<Rental> getRentalsByEndDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return rentalService.getRentalsByEndDate(date);
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public EntityModel<Rental> addRental(@RequestBody RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalsOverlapException, RentalNotFoundException {
        Rental rental = rentalService.addRental(rentalDTO);
        return EntityModel.of(rental,
                linkTo(methodOn(RentalController.class).getRental(rental.getId())).withSelfRel());
    }

    @DeleteMapping(value = "/{rentalId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteRental(@PathVariable int rentalId) throws RentalNotFoundException {
        rentalService.deleteRental(rentalId);
    }

    @PatchMapping(value = "/{rentalId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public EntityModel<Rental> updateRental(@PathVariable int rentalId, @RequestBody RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException, RentalNotFoundException {
        Rental rental = rentalService.updateRental(rentalId, rentalDTO);
        return EntityModel.of(rental,
                linkTo(methodOn(RentalController.class).getRental(rental.getId())).withSelfRel());
    }

}
