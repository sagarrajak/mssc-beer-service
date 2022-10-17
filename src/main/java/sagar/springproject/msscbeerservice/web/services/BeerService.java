package sagar.springproject.msscbeerservice.web.services;

import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID beerId) throws Exception;

    Beer createBeer(BeerRequestDto beerRequestDto);

    Beer updateBeer(BeerRequestDto beerRequestDto, UUID uuid) throws Exception;

    void deleteBeer(UUID bearId);
}
