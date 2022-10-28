package sagar.springproject.msscbeerservice.web.events;

import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;

public class NewInventoryEvent extends BeerEvents {
    public NewInventoryEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
