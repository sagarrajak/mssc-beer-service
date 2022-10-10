package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.models.BeerDto;
import web.services.BeerService;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(this.beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createBeer(@RequestBody BeerDto beerDto) {
        BeerDto beer = this.beerService.createBeer(beerDto);
        return new ResponseEntity(beer, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity updateBeer(@RequestBody BeerDto beerDto) {
        BeerDto beerUpdated = this.beerService.updateBeer(beerDto);
        return new ResponseEntity(beerUpdated, HttpStatus.ACCEPTED);
    }
}
