package com.bookJane.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookJane.pageObjects.DashboardPage;
import com.bookJane.pageObjects.HomePage;
import com.bookJane.pageObjects.LoginPage;
import com.bookJane.pageObjects.createShiftPage;
import com.bookJane.utilities.XLUtils;

import junit.framework.Assert;

public class TC_BKJ_017 extends BaseClass{
	
	@Test (dataProvider="LoginData", priority =1)// invocationCount =3)
	public void createShiftTest(String user) throws Exception {
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(homeUrl);
		//driver.get(stageEntUrl);
    	logger.info("Getting url");
    	
      	HomePage hp = new HomePage(driver);
    	logger.info("initialising home page");
    	createShiftPage cs = new createShiftPage(driver);
		logger.info("initialising create shift page");
         LoginPage lp = new LoginPage(driver);
    	logger.info("initialising login page");
		DashboardPage db = new DashboardPage(driver);
		logger.info("initialising dashboard");
		 
		
		hp.clickLogin();
    	logger.info("clicking on login button");
    	
        lp.setEmail(user);
    	logger.info("entering username");
    
     	lp.setPass(txtPswd3);
    	logger.info("entering password");
  
     	lp.loginBtn();
    	logger.info("login button clicked");
    
    	db.clickCreateShift();
		logger.info("clicked on create shift");
	
		cs.locations2();
		
		
		//cs.locations();
		//logger.info("click location drop down and selecting an option");
	
		
		cs.dateBtnClick(); //cs.loadTime(); 
		cs.datePicker2(); //cs.loadTime();
		//  cs.positions(); 
		  //logger.info("position selected"); //cs.loadTime();
		 // cs.roomClick(); //cs.loadTime(); 
		  //cs.rooms(); 
		  //logger.info("room  selected");
		 // cs.loadTime(); 
		//  cs.clickJane(); 
		 // logger.info("research janes");
		 // cs.loadTime(); 
		 // cs.JanepopUp(); 
		 // logger.info("jane selected");
		  //cs.loadTime(); 
		 // cs.submitShift(); 
		 // logger.info("clicked submit button");
		 
		//cs.loadTime();
	    logger.info("test passed");
		 
		
	}

	 @DataProvider(name="LoginData")
     public static Object[][] credentials() throws IOException {
     String path=System.getProperty("user.dir")+"/src/test/java/com/bookJane/testData/LoginData.xlsx";
     String user = XLUtils.getCellData(path,"Login", 2, 1); // development login
     //String user = XLUtils.getCellData(path, "Login", 4, 1); // staging login
     
         return new Object[][] { { user}};
      
       }
	 
	 @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	    	if(result.getStatus() == ITestResult.FAILURE) {
	    		captureScreen(driver,result.getName());
	    	}
	    }

}
