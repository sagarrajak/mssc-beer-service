package sagar.springproject.msscbeerservice.web.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sagar.springproject.msscbeerservice.web.dto.BeerPagedList;
import sagar.springproject.msscbeerservice.web.dto.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.mapper.BeerRequestMapper;
import sagar.springproject.msscbeerservice.web.mapper.BeerResponseMapper;
import sagar.springproject.msscbeerservice.web.services.BeerService;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/api/v1")
@RestController
@AllArgsConstructor
public class BeerController extends BaseController {

    private BeerService beerService;

    private BeerResponseMapper beerResponseMapper;


    @GetMapping("/beer")
    public ResponseEntity<BeerPagedList> listBeer(
            @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "beerName", required = false) String beerName,
            @RequestParam(value = "beerStyle", required = false) String beerStyle

    ) {
        if (showInventoryOnHand == null)
                showInventoryOnHand = false;
        PageRequest pagedParams = this.getPagedParams(pageNumber, pageSize);
        BeerPagedList<BeerResponseDto> list =  beerService.listBeer(beerName, beerStyle, showInventoryOnHand, pagedParams);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/beer/{beerId}")
    public ResponseEntity<BeerResponseDto> getBeerById(
            @PathVariable UUID beerId,
            @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand
    ) throws Exception {
        if (showInventoryOnHand == null)
            showInventoryOnHand = false;
        if (showInventoryOnHand)
            return new ResponseEntity(this.beerResponseMapper.beerToBeerDtoWithInventory(this.beerService.getBeerById(beerId)), HttpStatus.OK);
        else
            return new ResponseEntity(this.beerResponseMapper.beerToBeerDto(this.beerService.getBeerById(beerId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerResponseDto> createBeer(@Valid @RequestBody BeerRequestDto beerRequestDto) {
        Beer beer = this.beerService.createBeer(beerRequestDto);
        return new ResponseEntity(this.beerResponseMapper.beerToBeerDto(beer), HttpStatus.CREATED);
    }

    @PutMapping("/beer/{beerId}")
    public ResponseEntity<BeerResponseDto> updateBeer(@Valid @RequestBody BeerRequestDto beerRequestDto, @PathVariable UUID bearId) throws Exception {
        Beer beerUpdated = this.beerService.updateBeer(beerRequestDto, bearId);
        return new ResponseEntity(this.beerResponseMapper.beerToBeerDto(beerUpdated), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/beer/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable UUID bearId) {
        this.beerService.deleteBeer(bearId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/beer/beerUpc/{upc}")
    public ResponseEntity getBeerByUpc(@PathVariable String upc, @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null)
            showInventoryOnHand = false;
        Beer beer = this.beerService.getBeersByUpc(upc);
        BeerResponseDto beerResponseDtosList;
        if (showInventoryOnHand) {
            beerResponseDtosList = beerResponseMapper.beerToBeerDtoWithInventory(beer);
        } else {
            beerResponseDtosList = beerResponseMapper.beerToBeerDto(beer);
        }
        return new ResponseEntity(beerResponseDtosList, HttpStatus.OK);
    }
}
