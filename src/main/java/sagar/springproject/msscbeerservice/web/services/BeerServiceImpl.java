package sagar.springproject.msscbeerservice.web.services;


import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sagar.springproject.msscbeerservice.web.dto.BeerPagedList;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.dto.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.mapper.BeerRequestMapper;
import sagar.springproject.msscbeerservice.web.mapper.BeerResponseMapper;
import sagar.springproject.msscbeerservice.web.repository.BeerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerRequestMapper beerRequestMapper;

    @Autowired
    BeerResponseMapper beerResponseMapper;

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

    @Override
    public BeerPagedList<BeerResponseDto> listBeer(String beerName, String beerStyle, PageRequest pagedParams) {
        BeerPagedList<BeerResponseDto> beerPagedResponse;
        Page<Beer> beers;

        if (!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
            beers = this.beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pagedParams);
        } else if (!StringUtils.isEmpty(beerName) && StringUtils.isEmpty(beerStyle)) {
            beers = this.beerRepository.findAllByBeerName(beerName, pagedParams);
        } else if (StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
            beers = this.beerRepository.findAllByBeerStyle(beerStyle, pagedParams);
        } else {
            beers = this.beerRepository.findAll(pagedParams);
        }

        List<BeerResponseDto> collect = beers.getContent().stream().map(beer -> {
                    return beerResponseMapper.beerToBeerDto(beer);
                })
                .collect(Collectors.toList());
        return new BeerPagedList<BeerResponseDto>(collect, pagedParams, beers.getTotalElements());
    }
}
