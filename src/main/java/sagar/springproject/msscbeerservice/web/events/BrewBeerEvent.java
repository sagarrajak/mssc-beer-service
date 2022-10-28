package sagar.springproject.msscbeerservice.web.events;

import lombok.NoArgsConstructor;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvents {
    public BrewBeerEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
