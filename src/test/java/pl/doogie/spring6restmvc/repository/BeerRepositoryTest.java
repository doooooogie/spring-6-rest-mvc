package pl.doogie.spring6restmvc.repository;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.doogie.spring6restmvc.entities.Beer;
import pl.doogie.spring6restmvc.model.BeerStyle;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            beerRepository.save(Beer.builder()
                    .beerName("Baltic Porter BA 01234567890123456789012345678901234567890123456789")
                    .beerStyle(BeerStyle.STOUT)
                    .upc("123123")
                    .price(new BigDecimal("12.99"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("Baltic Porter BA")
                        .beerStyle(BeerStyle.STOUT)
                        .upc("123123")
                        .price(new BigDecimal("12.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}