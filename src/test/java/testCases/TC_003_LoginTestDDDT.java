package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.baseClass;
import utilities.DataProviders;

public class TC_003_LoginTestDDDT extends baseClass{

	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void Verify_LoginDDT(String Email, String Passwrd, String Exp) throws InterruptedException {
		
		
		logger.info("***********Starting TC_002_Verify_Login**********");
		
	    HomePage homep=new HomePage(driver);
     	homep.clickMyAccount();
    	logger.info("clicked on myaccount link on the home page..");

     	homep.ClickLogin();
     	Thread.sleep(3000);
	
    	logger.info("clicked on login link under myaccount..");
	
	    LoginPage Lp=new LoginPage(driver);
	    Lp.SetUsername(Email);
	    Lp.SetPassword(Passwrd);
        logger.info("Entering valid email and password..");
    	Lp.LoginBtn();
	    logger.info("clicked on login button..");
	
	
        MyAccount myacc=new MyAccount(driver);
        boolean targetpage=myacc.isMyAccountPageExists();
	
        if(Exp.equalsIgnoreCase("Valid"))
        { 
        	if(targetpage==true)
        	{
        	myacc.clickLogout();
        	Assert.assertTrue(true);
        	}
        else
        	{
        	Assert.assertTrue(false);
        	}
        }
        
        if(Exp.equalsIgnoreCase("Invalid"))
        {
        	if(targetpage==true)
    	    {
    	     myacc.clickLogout();
    	     Assert.assertTrue(false);
           	}
        }
        else {
        	Assert.assertTrue(true);
        }
	
	}
	
	
	
	
	
	
	
}
