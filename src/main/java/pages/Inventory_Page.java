package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown_List;

public class Inventory_Page extends TestBase 
{
	//object repository
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath = "//button[@data-test='remove-sauce-labs-backpack']") private WebElement removeProductBackPack;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath = "//button[@data-test='remove-sauce-labs-bike-light']") private WebElement removeProductBikeLight;
	
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productFleeceJacket;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productBoltTShirt;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productTShirtRed;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement productOnesie;
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement appLogo;
	@FindBy(xpath = "//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement openMenuDropDown;
	//@FindBy(xpath = "//a[@id='logout_sidebar_link']") private WebElement logOutOption;
	
	//calling
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String verifyAppLogo()
	{
		return appLogo.getText();
	}
	public String verifyPageTitle() 
	{
		return pageTitle.getText();
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifyLinkedInLogo()
	{
		return linkedinLogo.isDisplayed();
	}
	public String verifyFooterText()
	{
		return footerText.getText();
	}
	public String add6Products() throws InterruptedException 
	{
		//Select s= new Select(dropDown);
		//s.selectByVisibleText("Price (high to low)");
		HandleDropDown_List.handleSelect(dropDown, "Price (low to high)");
		Thread.sleep(2000);
		productBackpack.click();
		productBikeLight.click();
		productFleeceJacket.click();
		productBoltTShirt.click();
		productTShirtRed.click();
		productOnesie.click();
		return cartIcon.getText(); 
	}
	public String remove2Products() throws InterruptedException
	{
		add6Products();    //calling add method
		Thread.sleep(2000);
		removeProductBackPack.click();
		removeProductBikeLight.click();
		return cartCount.getText();	
	} 
	public void clickOnCart()
	{
		cartIcon.click();
	}
	public void TwitterLogo()
	{
		twitterLogo.click();
	}
	public void FacebookLogo()
	{
		facebookLogo.click();
	}
	public void LinkedInLogo()
	{
		linkedinLogo.click();
	}
	public void FooterText()
	{
		footerText.getText();
	}
}