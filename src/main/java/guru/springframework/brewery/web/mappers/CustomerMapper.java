package guru.springframework.brewery.web.mappers;

import guru.springframework.brewery.domain.Customer;
import guru.springframework.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);

}
