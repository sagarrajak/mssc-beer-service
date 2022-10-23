package sagar.springproject.msscbeerservice.web.services.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sagar.springproject.msscbeerservice.web.dto.BeerInventoryDto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BeerInventoryRestTemplateImpl implements BeerInventoryService {
    private final String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";

    private  String beerInventoryServiceHost;
    private final RestTemplate restTemplate;

    public BeerInventoryRestTemplateImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    public Integer getOnHandInventory(UUID beerId) {
        ResponseEntity<List<BeerInventoryDto>> beers = restTemplate.exchange(beerInventoryServiceHost + INVENTORY_PATH, HttpMethod.GET, null, new ParameterizedTypeReference<List<BeerInventoryDto>>() {
        }, (Object) beerId);

        int sum = Objects.requireNonNull(beers.getBody()).stream().mapToInt(beer -> beer.getQuantityOnHand()).sum();
        return sum;
    }

    public void setBeerInventoryServiceHost(String beerInventoryServiceHost) {
        this.beerInventoryServiceHost = beerInventoryServiceHost;
    }
}
