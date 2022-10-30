package sagar.springproject.models.events;

import lombok.*;
import sagar.springproject.models.BeerRequestDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvents implements Serializable {
    public final Long serialVersionUID = -234893948L;
    private BeerRequestDto beerDto;
}
