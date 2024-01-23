package pl.doogie.spring6restmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.doogie.spring6restmvc.entities.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
