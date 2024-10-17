package com.adactinhotelapp.TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	File file;
	FileInputStream inputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	DataFormatter format;
	String[][] stringArray;

	public ExcelHelper(String excelPath, String sheetName) {
		try {
			file = new File(excelPath);
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String findValue(int rowNum, int cellNum) {
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		format = new DataFormatter();
		return format.formatCellValue(cell);
	}

	public int findRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int findCells(int rowNum) {
		return sheet.getRow(rowNum).getPhysicalNumberOfCells();
	}

	public String[][] findValues(int rowCount, int cellCount) {
		stringArray = new String[rowCount][cellCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				row = sheet.getRow(i);
				cell = row.getCell(j);
				format = new DataFormatter();
				String cellValue = format.formatCellValue(cell);
				stringArray[i][j] = cellValue;
			}
		}
		return stringArray;
	}
}
