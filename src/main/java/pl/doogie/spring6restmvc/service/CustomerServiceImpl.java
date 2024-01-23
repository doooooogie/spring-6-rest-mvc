package pl.doogie.spring6restmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.doogie.spring6restmvc.model.CustomerDTO;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();
        CustomerDTO customer1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Piwosz")
                .version(18)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Smakosz")
                .version(3)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        CustomerDTO newCustomer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(customer.getName())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        this.customerMap.put(newCustomer.getId(), newCustomer);
        return newCustomer;
    }

    @Override
    public Optional<CustomerDTO> updateCustomerById(UUID id, CustomerDTO customer) {
        CustomerDTO existing = customerMap.get(id);
        existing.setName(customer.getName());
        existing.setUpdatedDate(LocalDateTime.now());
        return Optional.of(existing);
    }

    @Override
    public Boolean deleteCustomerById(UUID id) {
        customerMap.remove(id);
        return true;
    }

    @Override
    public Optional<CustomerDTO> patchById(UUID id, CustomerDTO customer) {
        CustomerDTO existing = customerMap.get(id);

        if(StringUtils.hasText(customer.getName())) {
            existing.setName(customer.getName());
        }
        return Optional.of(existing);
    }
}
