package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;   //this also we need to import for logger
import org.apache.logging.log4j.Logger;   //This we need to import
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {
 
	public Logger logger;
	public static WebDriver driver;
	public Properties p;
	@BeforeClass (groups = { "Master", "Sanity", "Regression" })
	@Parameters ({"os", "browser"})
	public void setUp(String os, String br) throws IOException
	{
		FileReader file=new FileReader("./src/test/resources/config.properties");  //here ./ is represents the current project 
	    p=new Properties();
	    p.load(file);
	    
	    
		//loggers are useful for all the classes so we are keeping it in base class.
		//this.getClass()---> will return the current class, so wherever we use this we can get log for that particular class.
		logger=LogManager.getLogger(this.getClass());  // here LogManager is the class & getLogger is method. 
		                                          //this.getClass()--> will get class name where logger is used.
		
		//when execution_env is remote
		if(p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities (); 
			 
			//set OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			
		  else if (os.equalsIgnoreCase("MAC"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
		  else if (os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
		  else
		  {
			  System.out.println("No such matching OS");
		  }
			
		  //set Browser
			
			switch(br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome"); break;
			case "edge":capabilities.setBrowserName("MicrosoftEgde"); break;
			case "firefox":capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No such matching Browser");
			}
	
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
			
			
			
		}
		
		//when execution_environment is local
		
		if(p.getProperty("execution_env").equals("local"))
		{
		  switch (br.toLowerCase())
		   {
		     case "chrome": driver=new ChromeDriver();break;
		     case "edge": driver=new EdgeDriver();break;
		     default : System.out.println("Invalid browser name entered"); return;
		   }
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL"));  //Reading URL from properties file. 
		
		driver.manage().window().maximize();
			
	}
	
	
	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public  String randomString()
	{
		String GeneratedString=RandomStringUtils.randomAlphabetic(7);
		return GeneratedString;
	}
	
	
	public String randomNumber()
	{
	String GeneratedNum=RandomStringUtils.randomNumeric(10);
		return GeneratedNum;
	}
	
	public String randomAlphaNumeric()
	{
		String GeneratedString=RandomStringUtils.randomAlphabetic(3);
		String GeneratedNum=RandomStringUtils.randomNumeric(3);
		return(GeneratedString+"@"+GeneratedNum);
		
	}
	
	public String captureScreen (String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot= (TakesScreenshot)driver;
		File Source=takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination= ".\\screenshots\\" + tname + "_" + timeStamp + ".png";
                           //System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		return destination;
		
	}
	
	
	
	
	
	
	
	
}
