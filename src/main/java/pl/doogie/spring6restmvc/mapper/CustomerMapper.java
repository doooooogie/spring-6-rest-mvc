package pl.doogie.spring6restmvc.mapper;

import org.mapstruct.Mapper;
import pl.doogie.spring6restmvc.entities.Customer;
import pl.doogie.spring6restmvc.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
