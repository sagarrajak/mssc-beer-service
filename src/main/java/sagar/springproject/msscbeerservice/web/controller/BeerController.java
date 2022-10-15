package sagar.springproject.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sagar.springproject.msscbeerservice.web.dto.BeerResponseDto;
import sagar.springproject.msscbeerservice.web.entity.Beer;
import sagar.springproject.msscbeerservice.web.services.BeerService;
import sagar.springproject.msscbeerservice.web.dto.BeerRequestDto;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerResponseDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity(new BeerResponseDto(this.beerService.getBeerById(beerId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerResponseDto> createBeer(@RequestBody BeerRequestDto beerRequestDto) {
        Beer beer = this.beerService.createBeer(beerRequestDto);
        return new ResponseEntity(new BeerResponseDto(beer), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<BeerResponseDto> updateBeer(@RequestBody BeerRequestDto beerRequestDto) {
        Beer beerUpdated = this.beerService.updateBeer(beerRequestDto);
        return new ResponseEntity(new BeerResponseDto(beerUpdated), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable UUID bearId) {
        this.beerService.deleteBeer(bearId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
