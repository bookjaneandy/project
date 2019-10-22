package com.bookJane.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookJane.pageObjects.HomePage;
import com.bookJane.pageObjects.LoginPage;
import com.bookJane.pageObjects.RegistrationPage;
import com.bookJane.utilities.XLUtils;

public class TC_BKJ_001 extends BaseClass{
    
	
    @Test (dataProvider="RegData")
    public void registrationTest(String org, String fname,String lname, String phone, String email, String loc) throws IOException, InterruptedException {
    	//driver.get(baseURL);
    	driver.get(homeUrl);
    	logger.info("Getting url");
    	
    	HomePage hp = new HomePage(driver);
    	logger.info("initialising page");
       	RegistrationPage rp = new RegistrationPage(driver);
    	logger.info("initialising registration page");
    	LoginPage lp = new LoginPage(driver);
    	logger.info("initialising login page");
    	
    	hp.clickReg();
    	logger.info("clicking on registration button");
    	rp.setOrg(org);
    	logger.info("entering organisation name");
    	rp.setFname(fname);
    	logger.info("entering first name");
    	rp.setLname(lname);
    	logger.info("entering last name");
    	rp.setPhone(phone);
    	logger.info("entering phone");
    	rp.setEmail(email);
    	logger.info("entering email");
    	rp.setPswd(txtPswd);
    	logger.info("entering password");
    	rp.setPswd2(txtPswd2);
    	logger.info("re-entering password");
    	rp.setLocation(loc);
    	logger.info("entering location name");
    	rp.setLocAdd2(txtLocAddress);
    	//ex
    	Thread.sleep(10000);
    	logger.info("entering location address");
    	rp.locAddressNext();
    	Thread.sleep(10000);
    	logger.info("autocomplete option selection done");
    	//rp.setLocAddress(txtLocAddress);
    	rp.tryCheckboxBill();
    	logger.info("clicking on check box for billing info");
    	rp.tryCheckBoxTerms2();
    	logger.info("clicking on checkbox for terms");
    	rp.tryCheckBoxPrivacy();
    	logger.info("clicking on checkbox for privacy");
    	rp.clickSub();
    	logger.info("clicking on register button");
    	Thread.sleep(10000);
    	logger.info("checking for Alert");
    	rp.popUp();
    	logger.info("Confirm alert pops up to await approval and click on 'get started'");
    	lp.nextStepConfirm();
        logger.info("after clicking 'get started' in alert, you are directed to log in page");
        logger.info("This test has been completed successfully");
    	
		   	
    }
    
    @DataProvider(name="RegData")
    public static Object[][] credentials() throws IOException {
    String path=System.getProperty("user.dir")+"/src/test/java/com/bookJane/testData/LoginData.xlsx";
    String org = XLUtils.getCellData(path,"Register", 1, 0);
    String fname = XLUtils.getCellData(path, "Register", 1, 1);
    String lname = XLUtils.getCellData(path, "Register", 1, 2);
    String ph = XLUtils.getCellData(path, "Register", 1, 3);
    String email = XLUtils.getCellData(path, "Register", 1, 4);
    String loc = XLUtils.getCellData(path, "Register", 1, 5);
              return new Object[][] { { org,fname,lname,ph,email,loc }};
     
      }
	
    
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	if(result.getStatus() == ITestResult.FAILURE) {
    		captureScreen(driver,result.getName());
    	}
    }
}
