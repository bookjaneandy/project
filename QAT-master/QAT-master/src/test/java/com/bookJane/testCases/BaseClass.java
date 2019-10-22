package com.bookJane.testCases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.bookJane.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getRegistrationURL();
    public String txtOrg;// = readconfig.getOrganisation();
    public String txtFname; //= readconfig.getFname();
    public String txtLname; //= readconfig.getLname();
    public String txtPhone; //= readconfig.getPhone();
    public String txtEmail; //= readconfig.getEmail();
    public String txtPswd = readconfig.getPassword();
    public String txtPswd2 = readconfig.getPassword2();
    public String txtLocation;// = readconfig.getLocation();
    public String txtLocAddress = readconfig.getLocAddress();
    public boolean checkboxBill;
    public String txtFnameB;
    public String txtLnameB;
    public String txtPhoneB;
    public boolean checkBoxTerms;
    public boolean checkBoxPrivacy;
    
    public String loginURL = readconfig.getLogUrl();
    public String txtUser3;// = readconfig.getLogUser();
    public String txtPswd3 = readconfig.getLogPswd();
    
    
    public String homeUrl = readconfig.getHomeUrl();
    public String dashUrl = readconfig.getDashUrl();
    
    public String stageEntUrl = readconfig.getStageEntUrl();
    
    public String sandHomeUrl = readconfig.getSandHomeUrl();
    
    public static WebDriver driver;
    
    public static Logger logger;
    
    
  /*  public void setup()
    {   
//    	logger=Logger.getLogger("BookJane");
//    	PropertyConfigurator.configure("Log4j.properties");
//    	
//    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers/chromedriver.exe");
//    	driver = new ChromeDriver();
    }*/
    
    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
	{
		logger = Logger.getLogger("BookJane"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		if (br.equals("firefox")) {
			// Firefox Browser
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			// opens the browser
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            logger.info("clearing browser cache");
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("start-maximized");
			logger.info("maximising window");
			opts.addArguments("--incognito");
			logger.info("cognito mode");
			capabilities.setCapability(ChromeOptions.CAPABILITY, opts);

			//WebDriver driver = new ChromeDriver(capabilities);
			driver = new ChromeDriver(capabilities);
			driver.manage().deleteAllCookies();
		}
		
		else if (br.equals("ie")) {
			// opens the browser
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
	
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	  @AfterClass 
	  public void tearDown() { 
		  driver.quit(); 
		  }
	 
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
		     
		    File directory = new File("Screenshots");
		    directory.mkdir();
		    
		
		  Date d = new Date(); 
		  String filename = d.toString().replace(":", "_").replace(" ", "_");
		  String sname = tname+filename;
		 
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + sname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
}
