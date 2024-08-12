package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount (WebDriver driver)  //constructor
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement MyAccountheading;
	
	@FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Logout;
 	
	//Action method	
	
	public boolean isMyAccountPageExists()
	{
		try {
		return(MyAccountheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		Logout.click();
	}
	
	
}
