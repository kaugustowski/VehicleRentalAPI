package pl.wizyg.VehicleRental.rentals;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;

import java.time.LocalDate;
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

    @GetMapping("/customers/{customerId}")
    List<Rental> getAllCustomerRentals(@PathVariable int customerId) {
        return rentalService.getCustomerRentals(customerId);
    }

    @GetMapping("/customers/email")
    List<Rental> getCustomerRentalsByEmail(@RequestParam String email) {
        return rentalService.getCustomerRentals(email);
    }

    @GetMapping("/vehicles/{vehicleId}")
    List<Rental> getCustomerRentalsByEmail(@PathVariable int vehicleId) {
        return rentalService.getVehicleRentals(vehicleId);
    }

    @GetMapping(value = "/startDate", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    List<Rental> getRentalsByStartDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return rentalService.getRentalsByStartDate(date);
    }

    @GetMapping(value = "/endDate", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    List<Rental> getRentalsByEndDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return rentalService.getRentalsByEndDate(date);
    }

    @GetMapping(value = "/customers/{customerId}/endDateAfter/", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    List<Rental> getRentalsByCustomerIdAndEndDateAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int customerId) {
        return rentalService.getRentalsByCustomerIdAndEndDateAfter(customerId, date);
    }

    @GetMapping(value = "/customers/{customerId}/endDateBefore", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    List<Rental> getRentalsByCustomerIdEndDateBefore(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int customerId) {
        return rentalService.getRentalsByCustomerIdAndEndDateBefore(customerId, date);
    }

    @GetMapping(value = "/customers/{customerId}/startDateAfter", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    List<Rental> getRentalsByCustomerIdAndStartDateAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int customerId) {
        return rentalService.getRentalsByCustomerIdAndStartDateAfter(customerId, date);
    }

    @GetMapping(value = "/customers/{customerId}/startDateBefore", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    List<Rental> getRentalsByCustomerIdStartDateBefore(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int customerId) {
        return rentalService.getRentalsByCustomerIdAndStartDateBefore(customerId, date);
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Rental addRental(@RequestBody RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException {
        return rentalService.addRental(rentalDTO);
    }

    @DeleteMapping(value = "/{rentalId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    void deleteRental(@PathVariable int rentalId) {
        rentalService.deleteRental(rentalId);
    }

    @PatchMapping(value = "/{rentalId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    Rental updateRental(@PathVariable int rentalId, @RequestBody RentalDTO rentalDTO) throws CustomerNotFoundException, VehicleNotFoundException {
        return rentalService.updateRental(rentalId, rentalDTO);
    }
}
