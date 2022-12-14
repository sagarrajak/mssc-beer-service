package sagar.springproject.msscbeerservice.web.services.brewing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sagar.springproject.msscbeerservice.web.config.JmsConfig;
import sagar.springproject.models.BeerRequestDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.models.events.BrewBeerEvent;
import sagar.springproject.models.events.NewInventoryEvent;
import sagar.springproject.msscbeerservice.web.repository.BeerRepository;

import javax.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

import static sagar.springproject.msscbeerservice.web.config.JmsConfig.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {
    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) throws Exception {
        BeerRequestDto beerDto = event.getBeerDto();
        UUID id = beerDto.getId();
        Optional<Beer> byId = beerRepository.findById(id);
        beerDto.setQuantityOnHand(byId.get().getQuantityToBrew());
        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed beer " + byId.get().getQuantityToBrew());
        jmsTemplate.convertAndSend(JMS_INVENTORY_QUEUE, newInventoryEvent);
    }
}
