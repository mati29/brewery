package guru.springframework.brewery.web.controller;

import guru.springframework.brewery.services.CustomerService;
import guru.springframework.brewery.web.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable UUID customerId) {
        return customerService.getCustomerById(customerId);
    }

}
