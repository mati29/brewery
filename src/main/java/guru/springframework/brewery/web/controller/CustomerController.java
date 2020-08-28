package guru.springframework.brewery.web.controller;

import guru.springframework.brewery.services.CustomerService;
import guru.springframework.brewery.web.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping//POST - create new customer
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        //TODO add hostname to url
        headers.add("location", "/api/v1/customer/" + saveDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }

}
