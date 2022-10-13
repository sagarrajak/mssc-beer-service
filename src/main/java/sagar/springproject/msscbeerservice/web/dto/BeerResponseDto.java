package sagar.springproject.msscbeerservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerResponseDto {
    private Integer version;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
    private UUID id;

    public  BeerResponseDto(Beer beer) {
        this.version = beer.getVersion();
        this.beerName = beer.getBeerName();
        this.upc = beer.getUpc();
        this.price = beer.getPrice();
        this.quantityOnHand = beer.getQuantityOnHand();
        this.beerStyle = beer.getBeerStyle();
        this.id = beer.getId();
    }
}
