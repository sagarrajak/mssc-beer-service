package sagar.springproject.msscbeerservice.web.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.enums.BeerStyleEnum;
import sagar.springproject.msscbeerservice.web.repository.BeerRepository;

import java.math.BigDecimal;

@AllArgsConstructor
public class Beerloader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        if(beerRepository.count() == 0 ) {
            Beer b1 = Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.IPA)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_1_UPC)
                    .build();

            Beer b2 = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_2_UPC)
                    .build();

            Beer b3 = Beer.builder()
                    .beerName("Pinball Porter")
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_3_UPC)
                    .build();

            beerRepository.save(b1);
            beerRepository.save(b2);
            beerRepository.save(b3);
        }
    }
}
