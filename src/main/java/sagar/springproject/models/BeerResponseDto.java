package sagar.springproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sagar.springproject.msscbeerservice.web.dto.LocalDateDeserializer;
import sagar.springproject.msscbeerservice.web.dto.LocalDateSerializer;
import sagar.springproject.enums.BeerStyleEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerResponseDto implements Serializable {
    private static final long serialVersionUID = 8097086126314990997L;
    private Integer version;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private Integer minOnHand;
    private UUID id;

//    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime modifiedDate;

//    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate mylLocalDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer quantityOnHand;
}
