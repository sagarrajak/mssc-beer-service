package sagar.springproject.msscbeerservice.web.mapper;

import org.mapstruct.Mapper;
import sagar.springproject.models.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;

@Mapper(uses = {DateMapper.class})
public interface BeerRequestMapper {
    BeerRequestDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerRequestDto beer);
}
