package pl.wizyg.VehicleRental.customers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Customer getName(@PathVariable int customerId) throws CustomerNotFoundException {
        return customerService.getCustomer(customerId);
    }

    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer addClient(@RequestBody Customer newCustomer) {
        return customerService.addCustomer(newCustomer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteClient(@PathVariable int customerId) throws CustomerNotFoundException {
        customerService.deleteCustomer(customerId);
    }

    @PatchMapping(value = "/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer newCustomer) throws CustomerNotFoundException {
        return customerService.updateCustomer(customerId, newCustomer);
    }

    @RequestMapping
    public List<Customer> getClients() {

        return customerService.getCustomers();
    }


}
