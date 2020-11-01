package com.automationlabs.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;

	private static String Test_Data_Path = "./src/main/java/com/automationlabs/testData/NaveenAutomationLabs.xlsx";

	public static Object[][] getTestData(String SheetName) {

		Object[][] data = null;

		try {
			FileInputStream ip = new FileInputStream(Test_Data_Path);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(SheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				for (int y = 0; y < sheet.getRow(0).getLastCellNum(); y++) {

					data[i][y] = sheet.getRow(i + 1).getCell(y).toString();

				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
