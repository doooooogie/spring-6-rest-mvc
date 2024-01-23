package pl.doogie.spring6restmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.doogie.spring6restmvc.entities.Beer;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
