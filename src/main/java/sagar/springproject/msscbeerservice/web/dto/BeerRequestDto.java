package sagar.springproject.msscbeerservice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
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
    @NotNull
    private Long upc;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    private BigDecimal price;

    @NotNull
    @Positive
    private Integer quantityOnHand;

    @Null
    private UUID id;
}
