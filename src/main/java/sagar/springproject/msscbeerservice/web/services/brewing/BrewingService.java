package sagar.springproject.msscbeerservice.web.services.brewing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sagar.springproject.msscbeerservice.web.config.JmsConfig;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.models.events.BrewBeerEvent;
import sagar.springproject.msscbeerservice.web.mapper.BeerRequestMapper;
import sagar.springproject.msscbeerservice.web.repository.BeerRepository;
import sagar.springproject.msscbeerservice.web.services.inventory.BeerInventoryService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final BeerRequestMapper beerRequestMapper;
    private final JmsConfig jmsConfig;
    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 5000)
    public void findAll() {
        List<Beer> all = this.beerRepository.findAll();
        log.debug("total numbers of beers:", all.size());
        all.stream().forEach(beer -> {
            Integer onHandInventory = beerInventoryService.getOnHandInventory(beer.getId());
            log.debug("min on hand:" + beer.getMinOnHand());
            log.debug("Inventory is:" + onHandInventory);
            if (beer.getMinOnHand() >= onHandInventory) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerRequestMapper.beerToBeerDto(beer)));
            }
        });
    }
}
