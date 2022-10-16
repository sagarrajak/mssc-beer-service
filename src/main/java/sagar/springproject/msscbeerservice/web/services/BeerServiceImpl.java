package sagar.springproject.msscbeerservice.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.repository.BeerRepository;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    BeerRepository beerRepository;
    @Override
    public Beer getBeerById(UUID beerId) throws Exception {
        return this.beerRepository.findById(beerId).orElseThrow(() ->
                new Exception("Bad request")
        );
    }

    @Override
    public Beer createBeer(BeerRequestDto beerRequestDto) {
        return this.beerRepository.save(new Beer(beerRequestDto));
    }

    @Override
    public Beer updateBeer(BeerRequestDto beerRequestDto) {
        return null;
    }

    @Override
    public void deleteBeer(UUID bearId) {
        this.beerRepository.deleteById(bearId);
    }
}
