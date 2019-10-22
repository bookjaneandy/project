package com.bookJane.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookJane.pageObjects.DashboardPage;
import com.bookJane.pageObjects.HomePage;
import com.bookJane.pageObjects.LoginPage;
import com.bookJane.utilities.XLUtils;

public class TC_BKJ_012 extends BaseClass{
	
	@Test (dataProvider="LoginData")
	public void createShiftTest(String user) throws Exception {
		driver.get(homeUrl);
    	logger.info("Getting url");
    	
    	HomePage hp = new HomePage(driver);
    	logger.info("initialising home page");
    	 
    	hp.clickLogin();
    	logger.info("clicking on login button");
    			
    	LoginPage lp = new LoginPage(driver);
    	logger.info("initialising login page");
    	
    	lp.setEmail(user);
    	logger.info("entering username");
    	
    	lp.setPass(txtPswd3);
    	logger.info("entering password");
    	
    	lp.loginBtn();
    	logger.info("login button clicked");
    	
    	DashboardPage db = new DashboardPage(driver);
		logger.info("initialising dashboard");
		Thread.sleep(10000);
		
		db.clickCreateShift();
		Thread.sleep(10000);
		logger.info("test passed");
		
	}

	 @DataProvider(name="LoginData")
     public static Object[][] credentials() throws IOException {
     String path=System.getProperty("user.dir")+"/src/test/java/com/bookJane/testData/LoginData.xlsx";
     String user = XLUtils.getCellData(path,"Login", 1, 1);
     
         return new Object[][] { { user}};
      
       }
	
}
