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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase 
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login= new LoginPage();
		invent= new Inventory_Page();
		login.loginToApplication();
	}
	@Test
	public void verifyAppLogoTest()
	{
		String expLogo="Swag Labs";
		String actLogo=invent.verifyAppLogo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("App Logo is:" + actLogo);
	}
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException 
	{
		String expTitle=ReadData.readExcel(0, 5);   //Products(0,5)
		String actTitle=invent.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Inventory Page Title: " + actTitle);
	}
	@Test
	public void add6Products() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 3);    //6(0,3);
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products added to the cart: " + actCount);
	}
	@Test
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 4);    //4(0,4)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products after removed to the cart: " + actCount);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present: " + result);
	}
	@Test
	public void verifyFacebookLogoTset()
	{
		boolean result = invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Facebook logo is present: " + result);
	}
	@Test
	public void verifyLinkedInLogoTest()
	{
		boolean result = invent.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		Reporter.log("LinkedIn logo is present: " + result);
	}
	@Test
	public void verifyFooterTextTest()
	{
		String expTitle="© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actTitle=invent.verifyFooterText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Copyright Text: " + actTitle);
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