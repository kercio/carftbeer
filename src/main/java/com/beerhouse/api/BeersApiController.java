package com.beerhouse.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.beerhouse.erro.BeerException;
import com.beerhouse.model.Beer;
import com.beerhouse.service.BeerApiService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-05T22:58:55.295Z")


@Controller
public class BeersApiController implements BeersApi {

    private static final Logger log = LoggerFactory.getLogger(BeersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private BeerApiService beerApiService;
    
    @org.springframework.beans.factory.annotation.Autowired
    public BeersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Iterable<Beer>> beersGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	return new ResponseEntity<Iterable<Beer>>(this.beerApiService.findAllBeers(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Iterable<Beer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Iterable<Beer>>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<Void> beersIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	this.beerApiService.deleteBeerById(id);
            	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            	
            } catch (EmptyResultDataAccessException ex) {	
            	log.error("Beer not found", ex);
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            } catch (NumberFormatException numberEx) {
            	log.error("Invalid Id", numberEx);
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<Beer> beersIdGet(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	return new ResponseEntity<Beer>(this.beerApiService.findBeerById(id), HttpStatus.OK);

            } catch (EmptyResultDataAccessException emptyEx) {
            	log.error("Beer not found!");
                return new ResponseEntity<Beer>(HttpStatus.NOT_FOUND);	
            } catch (NumberFormatException numberEx) {
            	log.error("Invalid Id", numberEx);
                return new ResponseEntity<Beer>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Beer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Beer>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<Void> beersNameByIdPatch(@ApiParam(value = "",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "name", required = true) String name) {
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	try {

        		this.beerApiService.updateNameBeerById(id, name);
        		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        		
        	} catch (BeerException beerExcep) {
            	log.error(beerExcep.getMessage());
            	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            } catch (EmptyResultDataAccessException emptyEx) {
        		log.error("Beer not found!");
        		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
        	} catch (NumberFormatException numberEx) {
        		log.error("Invalid Id", numberEx);
        		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        	} catch (Exception e) {
        		log.error("Couldn't serialize response for content type application/json", e);
        		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        	}
            	
        }

        return new ResponseEntity<Void>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
    
    public ResponseEntity<Void> beersPut(@ApiParam(value = "",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true)  @Valid @RequestBody Beer body) {
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	try {

        		this.beerApiService.updateBeer(body);
               	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
               	
        	} catch (BeerException beerExcep) {
            	log.error(beerExcep.getMessage());
            	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            } catch (EmptyResultDataAccessException emptyEx) {
        		log.error("Beer not found!");
        		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
        	} catch (NumberFormatException numberEx) {
        		log.error("Invalid Id", numberEx);
        		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        	} catch (Exception e) {
        		log.error("Couldn't serialize response for content type application/json", e);
        		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        }

        return new ResponseEntity<Void>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<Beer> beersPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Beer body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            
        	try {

        		this.beerApiService.saveBeer(body);
            	return new ResponseEntity<Beer>(HttpStatus.CREATED);
            	
        	} catch (BeerException beerExcep) {
            	log.error(beerExcep.getMessage());
            	return new ResponseEntity<Beer>(HttpStatus.BAD_REQUEST);
            } catch (EmptyResultDataAccessException e) {
            	log.error("Invalid Beer", e);
                return new ResponseEntity<Beer>(HttpStatus.BAD_REQUEST);
        	} catch (Exception e) {
        		log.error("Couldn't serialize response for content type application/json", e);
        		return new ResponseEntity<Beer>(HttpStatus.INTERNAL_SERVER_ERROR);
        	}

        }

        return new ResponseEntity<Beer>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
	

}