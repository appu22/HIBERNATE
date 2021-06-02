package com.xworkz.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUtil {

	public static void main(String[] args) throws IOException {
//		String excelPath = "F:/javaWorkSpace/test.xlsx";
		System.out.println("program start");

//		FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
		List countries = readFileUsingPOI();
		SessionFactory sessionFactory = null;
		Session session = null;
		for (Object object : countries) {
			System.out.println("NAmes : " + object);
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				session = sessionFactory.openSession();

				session.beginTransaction();
				session.save(object);
				session.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
				sessionFactory.close();

			}

		}
		
		
	}

	public static List readFileUsingPOI() throws IOException {
		System.out.println("read File Using POI");
		List countries = new ArrayList();
		System.out.println("countries : " + countries);
		ClassLoader classLoader = TestUtil.class.getClassLoader();
		String excelFilePath = "F:/javaWorkSpace/test.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
//	 System.out.println(sheet);
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
//	 System.out.println(nextRow);
			// Not creating country object for header
			if (nextRow.getRowNum() == 0)
				continue;

			TestDTO dto = new TestDTO();
//	   System.out.println("object ========"+dto);
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex + 1) {
				case 1:
					dto.setTestName(cell.getStringCellValue());
					break;
				case 2:
					dto.setSubjectName(cell.getStringCellValue());
					break;
				}

			}
			countries.add(dto);
//	   System.out.println("dto adding to list"+dto);

		}

		workbook.close();
		inputStream.close();

		return countries;

	}
}
//	}
//}
