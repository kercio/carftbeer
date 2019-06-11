package com.beerhouse.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beerhouse.model.Beer;

@Repository
public interface BeerDAO extends CrudRepository<Beer, Long> {

}
