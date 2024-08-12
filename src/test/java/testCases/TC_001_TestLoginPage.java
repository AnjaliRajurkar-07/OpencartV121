package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.baseClass;

public class TC_001_TestLoginPage extends baseClass {
	
	
	@Test (groups= {"Sanity", "Master"})
	public void VerifyLogin()
	{
		logger.info("**********Starting TC_001_TestLoginPage***********");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked My Account");
		
		hp.clickRegister();
		logger.info("Clicked Register");
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		logger.info("Providing user details");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString().toUpperCase()+"@mailinator.com");
        regPage.setMoNo(randomNumber());
        
        String pwd=randomAlphaNumeric();
        
        regPage.setPassword(pwd);
        regPage.setConfPassword(pwd);
        regPage.policy();
        regPage.clickContinue();
        
        logger.info("Validate the confirmation message");
       String Confmsg= regPage.getConfirmMessage();
      // Assert.assertEquals(Confmsg, "Your Account Has Been Created!!!");
        if(Confmsg.equals("Your Account Has Been Created!")) 
        {
        	Assert.assertTrue(true);
        }
        else
        {
        	
        	logger.error("Test failed");
			logger.debug("Debugged bug");
			Assert.assertTrue(false);
        }
        
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
	
		logger.info("**********Finish TC_001_TestLoginPage***********");
	}
	
	


}
