package sagar.springproject.msscbeerservice.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sagar.springproject.msscbeerservice.web.entity.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, String beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerStyle(String beerName, Pageable pageable);

    Beer findByUpc(String upc);
}
