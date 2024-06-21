package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Complete_page extends TestBase
{
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement completePageLogo;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement completePageMenuBtn;
	@FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement completePageTitle;
	@FindBy(xpath = "//a[@data-test='shopping-cart-link']") private WebElement completecartIcon;
	@FindBy(xpath = "//img[@alt='Pony Express']") private WebElement completeImg;
	@FindBy(xpath = "//h2[@data-test='complete-header']") private WebElement thankuforYourOrderText;
	@FindBy(xpath = "//div[@data-test='complete-text']") private WebElement completeText;
	@FindBy(xpath = "//button[@id='back-to-products']") private WebElement backHomeBtn; 
	
	public Checkout_Complete_page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCompletePageLogo()
	{
		return completePageLogo.getText();
	}
	public boolean verifyCompletePageMenuBtn()
	{
		return completePageMenuBtn.isDisplayed();
	}
	public String verifyCompletePageTitle()
	{
		return completePageTitle.getText();
	}
	public String verifyCartIcon()
	{
		completecartIcon.click();
		return driver.getCurrentUrl();
	}
	public boolean verifyCompleteImg()
	{
		return completeImg.isDisplayed();
	}
	public String verifyThankuhforYourOrderText()
	{
		return thankuforYourOrderText.getText();
	}
	public String verifyCompleteText()
	{
		return completeText.getText();
	}
	public String verifyBackHomeBtn()
	{
		backHomeBtn.click();
		return driver.getCurrentUrl();
	}
	
	
	
	
	
	
	
	
	
	
	
}
