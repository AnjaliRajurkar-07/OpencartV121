package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//constructor to initialize the driver
public class AccountRegistrationPage extends BasePage {
	
		
		public AccountRegistrationPage(WebDriver driver)
		{
			super(driver);
		}
	
	//locating elements
@FindBy (xpath="//input[@id='input-firstname']")
WebElement txtfirstname;

@FindBy (xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy (xpath="//input[@id='input-email']")
WebElement txtEMail;

@FindBy (xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy (xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy (xpath="//input[@id='input-confirm']")
WebElement txtConfirmPassword;
	
@FindBy (xpath="//input[@name='agree']")
WebElement chkPolicy;

@FindBy (xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

//test methods
public void setFirstName(String fName)
{
	txtfirstname.sendKeys(fName);
}
	
public void setLastName(String lName)
{
	txtLastname.sendKeys(lName);
}
	

public void setEmail(String Email)
{
	txtEMail.sendKeys(Email);
}

public void setMoNo (String MoNo)
{
	txtTelephone.sendKeys(MoNo);
}

public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);	
}

public void setConfPassword (String pwd)
{
	txtConfirmPassword.sendKeys(pwd);	
}

public void policy ()
{
	chkPolicy.click();
}

public void clickContinue()
{
	btnContinue.click();
}


public String getConfirmMessage ()
{
	try {
	return (msgConfirmation.getText());
	}
	catch (Exception e)
	{
		return (e.getMessage());
	}
}












}
