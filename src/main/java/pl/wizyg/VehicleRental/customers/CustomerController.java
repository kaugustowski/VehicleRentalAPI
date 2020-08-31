package pl.wizyg.VehicleRental.customers;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public EntityModel<Customer> getCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        Customer customer = customerService.getCustomer(customerId);
        return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).getCustomer(customerId)).withSelfRel());
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public EntityModel<Customer> addCustomer(@RequestBody Customer newCustomer) throws CustomerNotFoundException {

        Customer customer = customerService.addCustomer(newCustomer);
        return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withSelfRel());
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        customerService.deleteCustomer(customerId);
    }

    @PatchMapping(value = "/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public EntityModel<Customer> updateCustomer(@PathVariable int customerId, @RequestBody Customer newCustomer) throws CustomerNotFoundException {

        Customer customer = customerService.updateCustomer(customerId, newCustomer);

        return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).getCustomer(customerId)).withSelfRel());
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}