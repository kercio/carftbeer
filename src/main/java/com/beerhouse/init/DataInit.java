package com.beerhouse.init;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.beerhouse.dao.BeerDAO;
import com.beerhouse.model.Beer;

@Component
public class DataInit  implements ApplicationRunner {

	private BeerDAO beerDAO;
	
	@Autowired
	public DataInit(BeerDAO beerDAO) {
		this.beerDAO = beerDAO;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = beerDAO.count();

		if (count == 0) {
			Beer beer = new Beer();
			beer.setName("Colorado Nassau 600ml");
			beer.setAlcoholContent("5.8%");
			beer.setIngredients("Água, malte, cereais não maltados e lúpulo.");
			beer.setCategory("Pilsen");
			beer.setPrice(new BigDecimal(13.50));
			
			Beer beer2 = new Beer();
			beer2.setName("Skol Pilsen 600ml");
			beer2.setAlcoholContent("4.7%");
			beer2.setIngredients("Água, malte, cereais não maltados e lúpulo. Estabilizante INS 405.");
			beer2.setCategory("Pilsen");
			beer2.setPrice(new BigDecimal(4.50));

			Beer beer3 = new Beer();
			beer3.setName("Skol Hops 600ml");
			beer3.setAlcoholContent("4.1%");
			beer3.setIngredients("Água, malte e quatro tipos de lúpulo.");
			beer3.setCategory("American Lager");
			beer3.setPrice(new BigDecimal(4.50));
			
			beerDAO.save(beer);
			beerDAO.save(beer2);
			beerDAO.save(beer3);
		}

	}


}
