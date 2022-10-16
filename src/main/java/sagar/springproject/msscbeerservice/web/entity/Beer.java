package sagar.springproject.msscbeerservice.web.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beer {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "varchar")
    private UUID id;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp modifiedDate;

    @Column(name = "beer_name")
    private String beerName;

    @Column(name = "beer_style")
    private BeerStyleEnum beerStyle;

    private Long upc;
    private BigDecimal price;

    @Column(name = "quantity_on_hand")
    private Integer quantityOnHand;

    public  Beer(BeerRequestDto beerRequestDto) {
        this.beerName = beerRequestDto.getBeerName();
        this.beerStyle = beerRequestDto.getBeerStyle();
        this.upc = beerRequestDto.getUpc();
        this.price = beerRequestDto.getPrice();
        this.quantityOnHand = beerRequestDto.getQuantityOnHand();
    }
}
