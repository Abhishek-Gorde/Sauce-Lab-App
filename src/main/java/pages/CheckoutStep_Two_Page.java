package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutStep_Two_Page extends TestBase
{
	@FindBy(xpath = "//input[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstName1TxtBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastName2TxtBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCode3TxtBox;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement check2PageLogo;
	@FindBy(xpath = "//span[@class='title']") private WebElement check2PageTitle;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement check2openMenuBtn;
	@FindBy(xpath = "//div[text()='SauceCard #31337']") private WebElement paymentInfoLabel; 
	@FindBy(xpath = "//div[text()='Free Pony Express Delivery!']") private WebElement shippingInfoLabel;
	@FindBy(xpath = "//div[text()='Item total: $']") private WebElement priceInfoLabel;
	@FindBy(xpath = "//div[@data-test='total-label']") private WebElement totalLable;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement check2CancelBtn;
	@FindBy(xpath = "//button[@name='finish']") private WebElement finishBtn;
	@FindBy(xpath = "//div[text()='QTY']") private WebElement check2QtyLabel;
	@FindBy(xpath = "//div[text()='Description']") private WebElement check2DescLabel;
	
	public CheckoutStep_Two_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheck2PageLogo()
	{
		return check2PageLogo.getText();
	}
	public String verifyCheck2PageTitle()
	{
		return check2PageTitle.getText();
	}
	public boolean verifyCheck2openMenuBtn() 
	{
		check2openMenuBtn.click();
		return check2openMenuBtn.isDisplayed();
	} 
	public String verifyPaymentInfoLabel()
	{
		return paymentInfoLabel.getText();
	}
	public String verifyShippingInfoLabel()
	{
		return shippingInfoLabel.getText();
	}
	public String verifyPriceInfoLabel()
	{
		return priceInfoLabel.getText();
	}
	public String verifyTotalLable()
	{
		return totalLable.getText();
	}
	public String verifyCheck2CancelBtn()
	{
		check2CancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyFinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyCheck2QtyLabel()
	{
		return check2QtyLabel.getText();
	}
	public String verifyCheck2DescLabel()
	{
		return check2DescLabel.getText();
	}
}