package sagar.springproject.msscbeerservice.web.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.dto.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerResponseMapperDecorator.class)
public interface BeerResponseMapper {
    BeerResponseDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerResponseDto beer);
}
