package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.baseClass;

public class TC_002_Verify_Login extends baseClass {
	
	@Test (groups= {"Regression", "Master"})
	public void testLogin()
	{logger.info("***********Starting TC_002_Verify_Login**********");
	logger.debug("capturing application debug logs....");
		try {
		
		HomePage homep=new HomePage(driver);
		homep.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
	
		homep.ClickLogin();
		Thread.sleep(3000);
		
		logger.info("clicked on login link under myaccount..");
		
		LoginPage Lp=new LoginPage(driver);
		Lp.SetUsername(p.getProperty("email"));
		Lp.SetPassword(p.getProperty("password"));
		logger.info("Entering valid email and password..");
		Lp.LoginBtn();
		logger.info("clicked on ligin button..");
		
		
	   MyAccount myacc=new MyAccount(driver);

	   boolean targetpage=myacc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "Login Failed"); //Here 3rd parameter is passing, becoz is test failes then "Login Failed" msg will display in console
        
		//myacc.clickLogout();
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
		
	}
	
	
	
	
	
	
	
	
	
	
}
