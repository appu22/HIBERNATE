package com.xworkz.sewing.service;

import com.xworkz.sewing.dao.SewingDAO;
import com.xworkz.sewing.dao.SewingDAOImple;
import com.xworkz.sewing.dto.SewingDTO;

public class SewingServiceImple implements SewingService {

	SewingDAO daoImple = new SewingDAOImple();

	public SewingServiceImple() {
		System.out.println("invoking   Sewing Service Imple");
	}

	public void validateSewingDetails(SewingDTO dto) {

		boolean validate = true;
		if (dto.getName() == null || dto.getName().length() < 3) {
			System.out.println("Invalid Name ");
			validate = false;

		}
		if (dto.getColor() == null || dto.getColor().length() < 2) {
			System.out.println("Invalid Color ");
			validate = false;
		}
		if (dto.getModel() == null || dto.getModel().length() < 4) {
			System.out.println("Invalid model number ");
			validate = false;
		}
		if (dto.getPrice() == 0 || dto.getPrice() < 1000) {
			System.out.println("Invalid Price ");
			validate = false;
		}
		if (validate) {
			daoImple.save(dto);

		}
	}

	public void validateFetchData() {
		System.out.println("Inside validate Fetch Data ");
		daoImple.getSewingData();
	}

}
