package pl.doogie.spring6restmvc.service;

import pl.doogie.spring6restmvc.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getCustomers();
    Optional<Customer> getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID id, Customer customer);

    void deleteCustomerById(UUID id);

    void patchById(UUID id, Customer customer);
}
