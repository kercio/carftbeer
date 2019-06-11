package com.beerhouse.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.beerhouse.dao.BeerDAO;
import com.beerhouse.erro.BeerException;
import com.beerhouse.model.Beer;


/**
 * Classe que contém toda a regra de negocio da API cartfbeer
 * 
 * @author klisboa
 *
 */
@Service
public class BeerApiService {

	@Autowired
    private BeerDAO beerDAO;
	
	private static final Logger log = LoggerFactory.getLogger(BeerApiService.class);
	
	public Iterable<Beer> findAllBeers() throws Exception{
		return this.beerDAO.findAll();
	}
	
	public Beer findBeerById(String id) throws NumberFormatException, EmptyResultDataAccessException {
		
		Long beerId = Long.valueOf(id);
    	Beer beer = this.beerDAO.findOne(beerId);
    	if (beer != null) {
    		return beer;
    	} else {
    		throw new EmptyResultDataAccessException(1);
    	}
	}
	
	
	public void deleteBeerById(String id) throws NumberFormatException, EmptyResultDataAccessException {
		
		Long beerId = Long.valueOf(id);
		this.beerDAO.delete(beerId);

	}
	
	
	public void saveBeer(Beer beer) throws EmptyResultDataAccessException, BeerException {

		validateBeer(beer);
		if (beer.getId() != null) {
			Beer beerToSave = this.beerDAO.findOne(beer.getId());
	    	if (beerToSave == null) {
	    		this.beerDAO.save(beerToSave);  	
	    	} else {
	    		throw new EmptyResultDataAccessException(1);
	    	}
		} else {
			this.beerDAO.save(beer);
		}
	}
	
	public void updateBeer(Beer beer) throws EmptyResultDataAccessException, BeerException {
		
		Beer beerToSave = this.beerDAO.findOne(beer.getId());
    	if (beerToSave != null) {
    		validateBeer(beer);
    		this.beerDAO.save(beerToSave);
    	} else {
    		throw new BeerException("");
    	}
	}
	
	public void updatePriceBeerById(Long beerId, BigDecimal price) throws EmptyResultDataAccessException, BeerException {

		Beer beer = this.beerDAO.findOne(beerId);
    	if (beer != null) {
    		beer.setPrice(price);
    		validateBeer(beer);
    		this.beerDAO.save(beer);
    	} else {
    		throw new EmptyResultDataAccessException(1);
    	}
	}
	
	public void updateNameBeerById(Long beerId, String name) throws EmptyResultDataAccessException, BeerException {

		Beer beer = this.beerDAO.findOne(beerId);
    	if (beer != null) {
    		beer.setName(name);
    		validateBeer(beer);
    		this.beerDAO.save(beer);
    	} else {
    		throw new EmptyResultDataAccessException(1);
    	}
	}
	
	private Beer validateBeer(Beer beer) throws BeerException {
		
		if (beer.getName().isEmpty()) {
			throw new BeerException("Nome não pode ser Vazio."); 
		} else if (beer.getAlcoholContent().isEmpty()) {
			throw new BeerException("Teor alcoólico não pode ser Vazio."); 
		} else if (beer.getIngredients().isEmpty()) {
			throw new BeerException("Ingredientes não pode ser Vazio."); 
		} else if (beer.getCategory().isEmpty()) {
			throw new BeerException("Categoria não pode ser Vazio."); 
		} else if (beer.getPrice().signum() <= 0) {
			throw new BeerException("Preço não pode ser Zero ou Negativo."); 
		}
		return beer;
	}
	
	

}
