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
import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/beer")
@RestController
@AllArgsConstructor
public class BeerController extends BaseController {

    private BeerService beerService;

    private BeerResponseMapper beerResponseMapper;


    @GetMapping(produces = {"application/json"})
    public ResponseEntity<BeerPagedList> listBeer(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "beerName", required = false) String beerName,
            @RequestParam(value = "beerStyle", required = false) String beerStyle

    ) {
        PageRequest pagedParams = this.getPagedParams(pageNumber, pageSize);
        BeerPagedList<BeerResponseDto> list =  beerService.listBeer(beerName, beerStyle, pagedParams);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerResponseDto> getBeerById(@PathVariable UUID beerId) throws Exception {
        return new ResponseEntity(this.beerResponseMapper.beerToBeerDto(this.beerService.getBeerById(beerId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerResponseDto> createBeer(@Valid @RequestBody BeerRequestDto beerRequestDto) {
        Beer beer = this.beerService.createBeer(beerRequestDto);
        return new ResponseEntity(this.beerResponseMapper.beerToBeerDto(beer), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerResponseDto> updateBeer(@Valid @RequestBody BeerRequestDto beerRequestDto, @PathVariable UUID bearId) throws Exception {
        Beer beerUpdated = this.beerService.updateBeer(beerRequestDto, bearId);
        return new ResponseEntity(this.beerResponseMapper.beerToBeerDto(beerUpdated), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable UUID bearId) {
        this.beerService.deleteBeer(bearId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
