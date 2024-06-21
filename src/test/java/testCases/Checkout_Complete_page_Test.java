package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutStep_Two_Page;
import pages.Checkout_Complete_page;
import pages.Checkout_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Checkout_Complete_page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	Checkout_Step_One_Page checkstep1;
	CheckoutStep_Two_Page checkstep2;
	Checkout_Complete_page complete;
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
		checkstep2.verifyFinishBtn();
		complete= new Checkout_Complete_page();
	}
	@Test
	public void verifyCompletePageLogoTest()
	{
		String expLogo="Swag Labs";
		String actLogo=complete.verifyCompletePageLogo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Complete Page Logo is:" + actLogo);
	}
	@Test
	public void verifyCompletePageMenuBtnTest()
	{
		boolean result = complete.verifyCompletePageMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Complete Page Open Menu Btn is present: " + result);
	}
	@Test
	public void verifyCompletePageTitleTest()
	{
		String expTitle="Checkout: Complete!";
		String actTitle=complete.verifyCompletePageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Complete Page Title is:" + actTitle);
	}
	@Test
	public void verifyCartIconTest()
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL=complete.verifyCartIcon();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Clicking on Cart Icon the URL is:" + actURL);
	}
	@Test
	public void verifyCompleteImgTest()
	{
		boolean result = complete.verifyCompleteImg();
		Assert.assertEquals(result, true);
		Reporter.log("Complete Page Img is present: " + result);
	}
	@Test
	public void verifyThankuhforYourOrderTextTest()
	{
		String expText="Thank you for your order!";
		String actText=complete.verifyThankuhforYourOrderText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Text is:" + actText);
	}
	@Test
	public void verifyCompleteTextTest()
	{
		String expText="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actText=complete.verifyCompleteText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Complete Text is: " + actText);
	}
	@Test
	public void verifyBackHomeBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=complete.verifyBackHomeBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Back Home URL is: " + actURL);
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
