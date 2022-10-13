package sagar.springproject.msscbeerservice.web.services;

import org.springframework.stereotype.Service;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;
import sagar.springproject.msscbeerservice.web.models.BeerDto;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().beerName("some name").beerStyle(BeerStyleEnum.ALE).id(UUID.randomUUID()).price(new BigDecimal(1000)).build();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public BeerDto updateBeer(BeerDto beerDto) {
        return null;
    }
}
