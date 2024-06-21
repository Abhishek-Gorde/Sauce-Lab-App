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
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

//TestCases
public class LoginPage_Test extends TestBase
{
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login= new LoginPage();
	} 
	@Test
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 0);    //https://www.saucedemo.com/inventory.html(0,0)
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Login Successful:" + actURL);
	}
	@Test
	public void verifyURLOFApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 1);      //https://www.saucedemo.com/(0,1)
		String actURL=login.verifyURLOFApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Application:" + actURL);
	}
	@Test
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 2);    //Swag Labs(0,2)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Application:" + actTitle);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		report.flush();
		driver.close();
	}
}


