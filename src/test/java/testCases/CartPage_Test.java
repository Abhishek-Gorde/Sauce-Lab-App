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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CartPage_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
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
	}
	@Test
	public void verifyShoppingCartPageTest()
	{
		String exp="https://www.saucedemo.com/cart.html";
		String act=cart.verifyShoppingCartPage();
		Assert.assertEquals(exp, act);
		Reporter.log("Shopping Cart Page Link is: " + act);	
	}
	@Test
	public void verifyLogoOfShoppingCartPageTest()
	{
		String expLogo="Swag Labs";
		String actLogo=cart.verifyLogoOfShoppingCartPage();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Shopping Cart Page Logo is:" + actLogo);
	}
	@Test
	public void verifyShoppingCartPageTitleTest()
	{
		String expTitle="Your Cart";
		String actTitle=cart.verifyShoppingCartPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Shopping Cart Page Title is: " + actTitle);
	}
	@Test
	public void verifyCartQuantityLabelTest() 
	{
		String expLogo="QTY";
		String actLogo=cart.verifycartQuantityLabel();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Cart Quantity Label is:" + actLogo);
	}
	@Test
	public void verifyCartDescLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLogo= ReadData.readExcel(0, 8);   //(0,8) Description"
		String actLogo=cart.verifycartDescLabel();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Cart Description Label is:" + actLogo);
	}
	@Test
	public void verifyContinueShoppingBtnTest() throws InterruptedException
	{
		String exp = "https://www.saucedemo.com/inventory.html";
		String act = cart.verifyContinueShoppingBtn();
		Assert.assertEquals(exp, act);
		Reporter.log("After clicking on Continue Shopping Btn URL is : " + act);
	}
	@Test
	public void verifyCheckoutButtonTest() throws InterruptedException 
	{
		String exp = "https://www.saucedemo.com/checkout-step-one.html";
		String act = cart.verifyCheckoutButton();
		Assert.assertEquals(exp, act);
		Reporter.log("After clicking on Checkout Btn URL is : " + act);
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
