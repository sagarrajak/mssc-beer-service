package sagar.springproject.msscbeerservice.web.services;

import sagar.springproject.msscbeerservice.web.models.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeer(BeerDto beerDto);
}
