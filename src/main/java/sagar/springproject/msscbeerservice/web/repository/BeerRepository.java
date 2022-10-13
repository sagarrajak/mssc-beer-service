package sagar.springproject.msscbeerservice.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sagar.springproject.msscbeerservice.web.entity.Beer;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
