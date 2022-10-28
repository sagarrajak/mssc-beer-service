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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerRequestDto implements Serializable {
    private static final long serialVersionUID = -3612660886693697984L;
    @NotNull
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    private String upc;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    private BigDecimal price;

    @NotNull
    @Positive
    private Integer minOnHand;

    @Null
    private UUID id;

    private Integer quantityOnHand;
}
