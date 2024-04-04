package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel_sheet {
	
	
	@DataProvider(name = "Login")
	public String [][] getTestData() throws IOException {
		
		File excelFile = new File("/com.guru99_Banking/src/main/java/test_Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("LoginDetails");
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		String [][] data = new 	String [rowCount][columnCount];
		
		for(int r=0; r<rowCount; r++) {
			XSSFRow row = sheet.getRow(r+1);
			
			for(int c=0; c<columnCount; c++) {
				XSSFCell cell = row.getCell(c);
			}
			
		}
		return data;
	}

}
