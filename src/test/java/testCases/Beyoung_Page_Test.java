package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase_beyoung;
import pages.Beyoung_Page;


public class Beyoung_Page_Test extends TestBase_beyoung
{
	Beyoung_Page beyoung;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		beyoung= new Beyoung_Page();
	} 
	@Test 
	public void verifyLoginBtnTest() throws InterruptedException
	{
		String exp="https://www.beyoung.in/";
		String act=beyoung.verifyLoginBtn();
		Assert.assertEquals(exp, act);
		Reporter.log(act);
	}
	@Test
	public void verifyMensClothingTest() throws InterruptedException
	{
		String expURL="https://www.beyoung.in/mens-clothing";
		String actURL=beyoung.verifyMensClothing();
		Assert.assertEquals(expURL, actURL);
		Reporter.log(actURL);
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
