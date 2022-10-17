package sagar.springproject.msscbeerservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Currency;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerRequestDto {
    @NotNull
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    @Positive
    @Positive
    private Long upc;
    @Positive
    @NotNull
    private BigDecimal price;
    @NotNull
    @Positive
    private Integer quantityOnHand;

    @Null
    private UUID id;
}
