package sagar.springproject.msscbeerservice.web.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import sagar.springproject.models.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerResponseMapperDecorator.class)
public interface BeerResponseMapper {
    BeerResponseDto beerToBeerDto(Beer beer);

    BeerResponseDto beerToBeerDtoWithInventory(Beer beer);
    Beer beerDtoToBeer(BeerResponseDto beer);
}
