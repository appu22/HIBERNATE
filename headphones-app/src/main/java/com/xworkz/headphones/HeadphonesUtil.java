package com.xworkz.headphones;

import java.io.IOException;
import java.util.List;

import com.xworkz.headphones.dao.HeadPhonesDAO;
import com.xworkz.headphones.dao.HeadPhonesDAOImple;
import com.xworkz.headphones.dto.HeadPhoneDTO;
import com.xworkz.headphones.readfromexcelsheet.ReadFromExcelSheet;

public class HeadphonesUtil {
	private static final String NAME = "/F://javaWorkSpace/database.xlsx";

	public static void main(String[] args) throws IOException {

		System.out.println("********Program Start********");
//		HeadPhoneDTO dto = new HeadPhoneDTO("SAMSUNG", 2500.0, "Wiereless", "White", false);

		HeadPhonesDAO dao = new HeadPhonesDAOImple();
		ReadFromExcelSheet excelSheet = new ReadFromExcelSheet();
		List<HeadPhoneDTO> fromExcel = excelSheet.ReadFromExcel();

		for (HeadPhoneDTO headPhoneDTO : fromExcel) {
			dao.saveHeadphoneData(headPhoneDTO);
			System.out.println(headPhoneDTO);
		}

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
//		dao.fecthHeadPhonePriceByName("SAMSUNG");
//		dao.fecthHeadPhoneColorAndNameById(2);

		System.out.println("********Program End********");
	}

}
