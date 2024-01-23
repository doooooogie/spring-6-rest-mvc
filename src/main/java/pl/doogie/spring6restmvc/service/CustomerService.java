package pl.doogie.spring6restmvc.service;

import pl.doogie.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    Optional<CustomerDTO> updateCustomerById(UUID id, CustomerDTO customer);

    Boolean deleteCustomerById(UUID id);

    Optional<CustomerDTO> patchById(UUID id, CustomerDTO customer);
}
