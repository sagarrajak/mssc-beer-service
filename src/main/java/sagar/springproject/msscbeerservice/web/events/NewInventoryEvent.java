package sagar.springproject.msscbeerservice.web.events;

import lombok.NoArgsConstructor;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvents {
    public NewInventoryEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
