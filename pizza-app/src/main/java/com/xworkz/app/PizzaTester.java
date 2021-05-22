package com.xworkz.app;

import com.xworkz.app.DTO.PizzaDTO;

import com.xworkz.app.dao.PizzaDAO;
import com.xworkz.app.dao.PizzaDAOImple;
import com.xworkz.app.service.PizzaService;
import com.xworkz.app.service.PizzaServiceImple;

public class PizzaTester {

	public static void main(String[] args) {
		System.out.println("*************** Program start ***************************");
		PizzaDTO pizzaDTO = new PizzaDTO("Hot Pizza", 500, "Dharawad", true, "non-veg");

		PizzaDAO daoImple = new PizzaDAOImple();
		PizzaService pizzaServiceImple = new PizzaServiceImple();
		boolean validPizzaData = pizzaServiceImple.validPizzaData(pizzaDTO);
		if (validPizzaData == true) {
			daoImple.save(pizzaDTO);
			System.out.println("inside validate data ..."+validPizzaData);
		}else {
			System.out.println("Please enter valid data ......");
		}
		daoImple.getPizza();
		System.out.println("*************** Program end ***************************");
	}

}
