package sagar.springproject.msscbeerservice.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.mapper.BeerRequestMapper;
import sagar.springproject.msscbeerservice.web.repository.BeerRepository;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerRequestMapper beerRequestMapper;

    @Override
    public Beer getBeerById(UUID beerId) throws Exception {
        return this.beerRepository.findById(beerId).orElseThrow(() ->
                new Exception("Bad request")
        );
    }

    @Override
    public Beer createBeer(BeerRequestDto beerRequestDto) {
        return this.beerRepository.save(this.beerRequestMapper.beerDtoToBeer(beerRequestDto));
    }

    @Override
    public Beer updateBeer(BeerRequestDto beerRequestDto, UUID uuid) throws Exception {
        Beer beer = this.beerRepository.findById(uuid).orElseThrow(() ->
            new Exception("bad Request")
        );
        Beer beerUpdated = this.beerRequestMapper.beerDtoToBeer(beerRequestDto);
        return beerUpdated;
    }

    @Override
    public void deleteBeer(UUID bearId) {
        this.beerRepository.deleteById(bearId);
    }
}
