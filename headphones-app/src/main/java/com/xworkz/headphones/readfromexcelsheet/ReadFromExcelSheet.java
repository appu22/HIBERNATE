package com.xworkz.headphones.readfromexcelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xworkz.headphones.dto.HeadPhoneDTO;

public class ReadFromExcelSheet {

	public List<HeadPhoneDTO> ReadFromExcel() throws IOException {

		List list = new ArrayList();
//	ClassLoader classLoader = TestUtil.class.getClassLoader();
		String excelFilePath = "F:/javaWorkSpace/database.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0)
				continue;

			HeadPhoneDTO dto = new HeadPhoneDTO();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex +1) {
				case 1:
					dto.setHeadPhone_Name(cell.getStringCellValue());
					break;
				case 2:
					dto.setHeadPhone_Price(cell.getNumericCellValue());
					break;
				case 3:
					dto.setHeadPhone_Type(cell.getStringCellValue());
					break;
				case 4:
					dto.setHeadPhone_Color(cell.getStringCellValue());
					break;
				case 5:
					dto.setHeadPhone_isWarranty(cell.getBooleanCellValue());
					break;
				}

			}
			list.add(dto);
		}

		workbook.close();
		inputStream.close();
		return list;
	}
}
