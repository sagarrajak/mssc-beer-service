package sagar.springproject.msscbeerservice.web.services;

import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID beerId);

    Beer createBeer(BeerRequestDto beerRequestDto);

    Beer updateBeer(BeerRequestDto beerRequestDto);
}
