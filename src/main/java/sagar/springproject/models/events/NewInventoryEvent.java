package sagar.springproject.models.events;

import lombok.NoArgsConstructor;
import sagar.springproject.models.BeerRequestDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvents {
    public NewInventoryEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
