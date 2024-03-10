package pl.doogie.spring6restmvc.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.doogie.spring6restmvc.entities.Customer;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer customer = customerRepository.save(Customer.builder()
                .name("Klient John")
                .build());

        customerRepository.flush();

        assertThat(customer).isNotNull();
        assertThat(customer.getId()).isNotNull();
    }
}