package web.services;

import org.springframework.http.ResponseEntity;
import web.models.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeer(BeerDto beerDto);
}
