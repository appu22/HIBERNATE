package com.xworkz.app.service;

import com.xworkz.app.DTO.PizzaDTO;

public class PizzaServiceImple implements PizzaService {

	public PizzaServiceImple() {
		System.out.println("invoking PizzaServiceImple ** ");
	}

	@Override
	public boolean validPizzaData(PizzaDTO pizzaDTO) {
		System.out.println("inside service imple  validPizzaData()...");

		if (pizzaDTO.getName() != null && pizzaDTO.getName().length() >= 4)
//			System.out.println("true");
			return true;
		if (pizzaDTO.getPrice() != 0)
			return true;
		if (pizzaDTO.getType() != null && pizzaDTO.getType().length() >= 2)
			return true;
		if (pizzaDTO.getLocation() != null && pizzaDTO.getLocation().length() >= 3)
			return true;

		return true;

	}

}
