package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

//Logic
public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passWordTxtBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Lab Application");
		userTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		logger.log(Status.INFO,"UserName is entered");
		passWordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO,"Password is entered");
		loginBtn.click();
		logger.log(Status.INFO,"Login button is clicked");
		logger.log(Status.INFO,"Login Successful");
		return driver.getCurrentUrl();
	}
	public String verifyMultiCredentials(String un, String pass)
	{
		userTxtBox.sendKeys(un);
		passWordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyURLOFApplication()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
}