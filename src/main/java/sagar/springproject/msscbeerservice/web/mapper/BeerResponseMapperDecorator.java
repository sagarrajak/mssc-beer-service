package sagar.springproject.msscbeerservice.web.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import sagar.springproject.msscbeerservice.web.dto.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.services.inventory.BeerInventoryService;

public abstract class BeerResponseMapperDecorator implements BeerResponseMapper {
    @Autowired
    BeerInventoryService beerInventoryService;

    @Autowired
    BeerResponseMapper beerResponseMapper;

    @Override
    public Beer beerDtoToBeer(BeerResponseDto beer) {
        Beer beer1 = beerResponseMapper.beerDtoToBeer(beer);
        return beer1;
    }

    @Override
    public BeerResponseDto beerToBeerDto(Beer beer) {
        BeerResponseDto beerResponseDto = beerResponseMapper.beerToBeerDto(beer);
        return beerResponseDto;
    }

    @Override
    public BeerResponseDto beerToBeerDtoWithInventory(Beer beer) {
        BeerResponseDto beerResponseDto = beerResponseMapper.beerToBeerDto(beer);
        beerResponseDto.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));
        return beerResponseDto;
    }
}
