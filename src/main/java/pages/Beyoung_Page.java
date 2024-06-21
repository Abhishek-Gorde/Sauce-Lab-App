package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase_beyoung;

public class Beyoung_Page extends TestBase_beyoung
{
	@FindBy(xpath = "//a[@id='loginBtn']") private WebElement loginBtn;
	@FindBy(xpath = "//input[@id='login-numbers']") private WebElement loginPhoneNo;
	@FindBy(xpath = "//button[text()='Login with OTP']") private WebElement loginWithOtpBtn;
	@FindBy(xpath = "//input[@maxlength='4']") private WebElement enterOtp;
	@FindBy(xpath = "//button[text()='Verify']") private WebElement verifyBtn;
	@FindBy(xpath = "(//a[@class='menu-title'])[1]") private WebElement menuDropDown;
	@FindBy(xpath = "(//a[text()='Printed T-Shirts'])[1]") private WebElement printedTShirt;
	
	@FindBy(xpath = "(//p[@class='sizevalue-main'])[2]") private WebElement sizeM;
	@FindBy(xpath = "//a[text()='ADD TO CART']") private WebElement addToCart;
	
	public Beyoung_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLoginBtn() throws InterruptedException
	{
		loginBtn.click();
		loginPhoneNo.sendKeys("9130981660");
		loginWithOtpBtn.click();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Otp: ");
		String otp = s.next();
		enterOtp.sendKeys(otp);  //get Otp
		verifyBtn.click();
		Thread.sleep(3000);
		menuDropDown.click();
		Thread.sleep(3000);
		printedTShirt.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	public String verifyMensClothing() throws InterruptedException
	{
		WebElement relaxShirt = driver.findElement(By.linkText("/relax-half-sleeve-t-shirt-for-men"));
		relaxShirt.click();
		Thread.sleep(3000);
		sizeM.click();
		Thread.sleep(3000);
		addToCart.click();
		Thread.sleep(3000);
		return null;
	}
}
