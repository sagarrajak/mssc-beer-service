package sagar.springproject.msscbeerservice.web.events;

import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;

public class BrewBeerEvent extends BeerEvents {
    public BrewBeerEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
