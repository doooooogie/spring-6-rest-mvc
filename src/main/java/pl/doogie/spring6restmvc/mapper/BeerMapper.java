package pl.doogie.spring6restmvc.mapper;

import org.mapstruct.Mapper;
import pl.doogie.spring6restmvc.entities.Beer;
import pl.doogie.spring6restmvc.model.BeerDTO;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
