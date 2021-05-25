package com.xworkz.sewing;

import com.xworkz.sewing.dao.SewingDAO;
import com.xworkz.sewing.dao.SewingDAOImple;
import com.xworkz.sewing.dto.SewingDTO;
import com.xworkz.sewing.service.SewingService;
import com.xworkz.sewing.service.SewingServiceImple;

public class SewingTester {

	public static void main(String[] args) {
		System.out.println("******* Program Start ******");
		SewingDTO dto = new SewingDTO("asha", "white", "A4562", 5500.0, false);

		SewingService service = new SewingServiceImple();
		SewingDAO dao = new SewingDAOImple();
//		dao.updatSewing();
		dao.deleteSewingData();
//		service.validateSewingDetails(dto);
//		service.validateFetchData();

		System.out.println(" ******* Program  Ended ***********");

	}

}
