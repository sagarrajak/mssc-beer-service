package sagar.springproject.msscbeerservice.web.dto;

import lombok.val;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BeerResponseTest {
    public BeerResponseDto getBeerResponseDto() {
        val some_beer = BeerResponseDto.builder()
                .beerName("Some beer")
                .beerStyle(BeerStyleEnum.ALE)
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .modifiedDate(OffsetDateTime.now())
                .price(new BigDecimal(10.22))
                .mylLocalDate(LocalDate.now())
                .upc(String.valueOf(12384938877834L))
                .build();
        return some_beer;
    }
}
