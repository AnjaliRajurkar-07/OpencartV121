package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

	//constructor
	public LoginPage (WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']") WebElement UserEmail;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement UserPassword;
	
	@FindBy(xpath="//input[@value='Login']") WebElement LoginButton;
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement MyAccount;
	
	
	//Action method
	public void SetUsername (String UserName)
	{
		UserEmail.sendKeys(UserName);
	}
	
	public void SetPassword (String password)
	{
		UserPassword.sendKeys(password);
	}
	
	public void LoginBtn()
	{
		LoginButton.click();
	}
	
	

	
}
