package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Step_One_Page extends TestBase
{
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement check1PageLogo;
	@FindBy(xpath = "//span[@class='title']") private WebElement check1PageTitle;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCodeTxtBox;
	@FindBy(xpath = "//input[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium cart_cancel_link']") private WebElement check1cancelBtn;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement openMenuBtn;
	
	public Checkout_Step_One_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheck1PageLogo()
	{
		return check1PageLogo.getText();
	}
	public String verifyCheck1PageTitle()
	{
		return check1PageTitle.getText();
	}
	public String enterInformation()
	{
		firstNameTxtBox.sendKeys("Abhishek");
		lastNameTxtBox.sendKeys("Gorde");
		postalCodeTxtBox.sendKeys("423107");
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyCheck1CancelBtn() 
	{
		check1cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public boolean verifyOpenMenuBtn() 
	{
		openMenuBtn.click();
		return openMenuBtn.isDisplayed();
	}
	public void verifyEnterInfo()
	{
		firstNameTxtBox.sendKeys("Abhishek");
		lastNameTxtBox.sendKeys("Gorde");
		postalCodeTxtBox.sendKeys("423107");
		continueBtn.click();
	}
	public void verifyCheck2ContinueBtn()
	{
		continueBtn.click();
	}
}
