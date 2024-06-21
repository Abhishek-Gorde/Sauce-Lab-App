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
import pages.CheckoutStep_Two_Page;
import pages.Checkout_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckoutStep_Two_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	Checkout_Step_One_Page checkstep1;
	CheckoutStep_Two_Page checkstep2;
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
		checkstep1.verifyEnterInfo();
		checkstep2= new CheckoutStep_Two_Page();
	}
	@Test
	public void verifyCheck2PageLogoTest()
	{
		String expLogo="Swag Labs";
		String actLogo=checkstep2.verifyCheck2PageLogo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Check Step two Page Logo is:" + actLogo);
	}
	@Test
	public void verifyCheck2PageTitleTest()
	{
		String expTitle="Checkout: Overview";
		String actTitle=checkstep2.verifyCheck2PageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Check Step two Page Title is:" + actTitle);
	}
	@Test
	public void verifyCheck2openMenuBtnTest()
	{
		boolean result = checkstep2.verifyCheck2openMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Check 2 Open Menu Btn is: " + result);
	}
	@Test
	public void verifyCheck2QtyLabelTest()
	{
		String expLabel="QTY";
		String actLabel=checkstep2.verifyCheck2QtyLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Check Step two Page Title is:" + actLabel);
	}
	@Test
	public void verifyCheck2DescLabelTest()
	{
		String expLabel="Description";
		String actLabel=checkstep2.verifyCheck2DescLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Check Step two Page Title is:" + actLabel);
	}
	@Test
	public void verifyPaymentInfoLabelTest()
	{
		String expText="SauceCard #31337";
		String actText=checkstep2.verifyPaymentInfoLabel();
		Assert.assertEquals(expText, actText);
		Reporter.log("Payment Information: " + actText);
	}
	@Test
	public void verifyShippingInfoLabelTest()
	{
		String expText="Free Pony Express Delivery!";
		String actText=checkstep2.verifyShippingInfoLabel();
		Assert.assertEquals(expText, actText);
		Reporter.log("Shipping Information: " + actText);
	}
	@Test
	public void verifyPriceInfoLabelTest()
	{
		String expText="Item total: $129.94";
		String actText=checkstep2.verifyPriceInfoLabel();
		Assert.assertEquals(expText, actText);
		Reporter.log("Price Total: " + actText);
	}
	@Test
	public void verifyTotalLableTest()
	{
		String expText="Total: $140.34";
		String actText=checkstep2.verifyTotalLable();
		Assert.assertEquals(expText, actText);
		Reporter.log(actText);
	} 
	@Test
	public void verifyCheck2CancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 9);     //(0,9) https://www.saucedemo.com/inventory.html
		String actURL=checkstep2.verifyCheck2CancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on checkout 2 Cancel Btn URL is: " + actURL);
	}
	@Test
	public void verifyFinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=checkstep2.verifyFinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on checkout 2 Cancel Btn URL is: " + actURL);
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