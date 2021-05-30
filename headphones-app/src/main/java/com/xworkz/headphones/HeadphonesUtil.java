package com.xworkz.headphones;

import com.xworkz.headphones.dao.HeadPhonesDAO;
import com.xworkz.headphones.dao.HeadPhonesDAOImple;
import com.xworkz.headphones.dto.HeadPhoneDTO;

public class HeadphonesUtil {

	public static void main(String[] args) {
		System.out.println("********Program Start********");
		HeadPhoneDTO dto = new HeadPhoneDTO("SAMSUNG", 2500.0, "Wiereless", "White", false);

		HeadPhonesDAO dao = new HeadPhonesDAOImple();
//		dao.saveHeadphoneData(dto);
//		dao.fetchHeadphoneData();
//		dao.deleteHeadphoneData();
//		dao.updateHeadphoneData();
//		dao.fetchAllHeadphoneRecords();
//		dao.fecthHeaphoneDeatilsByName("SAMSUNG");
		/*
		 * using createQuery(); This hardcode . this is one of the challenage to over
		 * come this challeange -- hibernate is given namedParameter createNamedQuery()
		 * *
		 */
		dao.fecthHeadPhonePriceByName("SAMSUNG");
//		dao.fecthHeadPhoneColorAndNameById(2);

		System.out.println("********Program End********");

	}

}
