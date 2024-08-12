package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage (WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy (xpath="//span[normalize-space()='My Account']")
WebElement lkMyAccount;

@FindBy (xpath="//a[normalize-space()='Register']")
WebElement lkRegister;

@FindBy(linkText = "Login")
WebElement Login;


public void clickMyAccount()
{
	lkMyAccount.click();
}
	
public void clickRegister()
{
	lkRegister.click();
}
	
public void ClickLogin()
{
  Login.click();
  
  //Multiple click methods
//sol1 
	//btnContinue.click();
	
	//sol2 
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//Sol 5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
  
  
}
	
}
