package ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getExcelData {

	//@Test(dataProvider = "excelTestData")
	@Test
	public static void main() throws IOException {
		
		Object data = getData();
		System.out.println(data);
		System.out.println("Welcome in Ecel driven");
	}
	
	
	@DataProvider(name = "excelTestData")
	public static Object[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream("//home/users//sanjay.bhatt//Documents//Bagisto-TestCase.ods");
		XSSFWorkbook xwb = new XSSFWorkbook(fis);
		XSSFSheet sheet = xwb.getSheetAt(1); 
		int rowCOunt = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		Object data[] [] = new Object[rowCOunt-1][columnCount];
		for (int i=0;i<=rowCOunt-1;i++) {
			row = sheet.getRow(i+1);
			for(int j=0; j<columnCount;j++) {
				XSSFCell XSC = row.getCell(j);
				data[i][j] = XSC;
				//data[i][j] = formatter.formateCellValue(XSC);
			}
		}
		return data;
	}	
}
