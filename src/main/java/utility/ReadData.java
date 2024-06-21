package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\Abhishek\\eclipse-workspace\\Selenium_Framework\\src\\main\\java\\config\\config.properties");
		prop.load(file);
		
		return prop.getProperty(value);
	}//congif.properties
	public static String readExcel(int row, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\Abhishek\\eclipse-workspace\\Selenium_Framework\\TestData\\ReadExcelData.xlsx");
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = es.getRow(row).getCell(column).getStringCellValue();
		System.out.println(value);
		return value;
	}
}