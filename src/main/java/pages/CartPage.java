package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//span[@class='title']") private WebElement cartPageTitle; 
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement cartQuantityLabel;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement cartDescLabel;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium']") private WebElement continueShoppingBtn;
	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkoutBtn;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyShoppingCartPage()
	{
		return driver.getCurrentUrl();
	}
	public String verifyLogoOfShoppingCartPage()
	{
		return appLogo.getText();
	}
	public String verifyShoppingCartPageTitle()
	{
		return cartPageTitle.getText();
	}
	public String verifycartQuantityLabel()
	{
		return cartQuantityLabel.getText();
	}
	public String verifycartDescLabel()
	{
		return cartDescLabel.getText();
	}
	public String verifyContinueShoppingBtn() throws InterruptedException
	{
		continueShoppingBtn.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	public String verifyCheckoutButton() throws InterruptedException
	{
		checkoutBtn.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	public void clickOnCheckoutBtn()
	{
		checkoutBtn.click();
	}
}