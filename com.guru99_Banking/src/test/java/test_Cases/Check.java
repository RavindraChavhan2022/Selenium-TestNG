package test_Cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Check {

	public static void main(String[] args) throws IOException {
		File excelFile = new File(System.getProperty("user.dir") + ".\\src\\main\\java\\test_Data\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("LoginDetails");
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);

	}

}
