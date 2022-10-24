package sagar.springproject.msscbeerservice.web.services;

import org.springframework.data.domain.PageRequest;
import sagar.springproject.msscbeerservice.web.dto.BeerPagedList;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.dto.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID beerId) throws Exception;

    Beer createBeer(BeerRequestDto beerRequestDto);

    Beer updateBeer(BeerRequestDto beerRequestDto, UUID uuid) throws Exception;

    void deleteBeer(UUID bearId);

    BeerPagedList<BeerResponseDto> listBeer(String beerName, String beerStyle, Boolean showInventoryOnHand, PageRequest pagedParams);

    Beer getBeersByUpc(String upc);
}
