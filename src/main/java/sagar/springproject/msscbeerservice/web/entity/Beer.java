package sagar.springproject.msscbeerservice.web.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer implements Serializable {
    private static final long serialVersionUID = 3_248_189_030_448_292_002L;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "varchar")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private Timestamp modifiedDate;

    @Column(name = "beer_name")
    private String beerName;

    @Column(name = "beer_style")
    private String beerStyle;

    private String upc;
    private BigDecimal price;

    @Column(name = "min_on_hand")
    private Integer minOnHand;

    @Column(name="quantity_to_brew")
    private Integer quantityToBrew;

}
