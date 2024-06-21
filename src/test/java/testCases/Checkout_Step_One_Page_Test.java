package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; 

import base.TestBase;
import pages.CartPage;
import pages.Checkout_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Checkout_Step_One_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	Checkout_Step_One_Page checkstep1;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException 
	{
		initialization();
		login= new LoginPage();
		invent= new Inventory_Page();
		cart=new CartPage();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickOnCheckoutBtn();
		checkstep1= new Checkout_Step_One_Page();
		checkstep1.verifyCheck2ContinueBtn();
	}
	@Test
	public void verifyCheck1PageLogoTest()
	{
		String expLogo="Swag Labs";
		String actLogo=checkstep1.verifyCheck1PageLogo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Check Step one Page Logo is:" + actLogo);
	}
	@Test
	public void verifyCheck1PageTitleTest()
	{
		String expTitle="Checkout: Your Information";
		String actTitle=checkstep1.verifyCheck1PageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Check Step one Page T is:" + actTitle);
	}
	@Test
	public void verifyEnterInformationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=checkstep1.enterInformation();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on Continue btn the URL is: " + actURL);
	}
	@Test
	public void verifyCheck1CancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 10); //(0,10) https://www.saucedemo.com/cart.html
		String actURL=checkstep1.verifyCheck1CancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on Cancel btn the URL is: " + actURL);
	}
	@Test
	public void verifyOpenMenuBtnTest()
	{
		boolean result = checkstep1.verifyOpenMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Open Menu Btn is: " + result);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close();
	}
}
