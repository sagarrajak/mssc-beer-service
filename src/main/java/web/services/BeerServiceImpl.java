package web.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.models.BeerDto;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return null;
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
