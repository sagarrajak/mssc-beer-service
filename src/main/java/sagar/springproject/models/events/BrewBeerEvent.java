package sagar.springproject.models.events;

import lombok.NoArgsConstructor;
import sagar.springproject.models.BeerRequestDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvents {
    public BrewBeerEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
