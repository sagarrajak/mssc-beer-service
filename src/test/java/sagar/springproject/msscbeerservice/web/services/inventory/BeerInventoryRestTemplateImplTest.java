package sagar.springproject.msscbeerservice.web.services.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sagar.springproject.msscbeerservice.web.bootstrap.BeerLoader;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Disabled // utility for manual testing
@SpringBootTest
class BeerInventoryRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getOnhandInventory() {
//        todo evolve to use UPC
          Integer qoh = beerInventoryService.getOnHandInventory(UUID.fromString(BeerLoader.BEER_1_UUID));
            System.out.println(qoh);
    }
}