package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase_beyoung 
{
	public static WebDriver driver;
	public void initialization() throws IOException
	{
		WebDriverManager.chromedriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.beyoung.in/");
	}
}
