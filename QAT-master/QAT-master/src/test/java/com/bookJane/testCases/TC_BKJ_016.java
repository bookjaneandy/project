package com.bookJane.testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookJane.pageObjects.DashboardPage;
import com.bookJane.pageObjects.HomePage;
import com.bookJane.pageObjects.LoginPage;
import com.bookJane.utilities.XLUtils;

public class TC_BKJ_016 extends BaseClass{
	
	@Test (dataProvider="LoginData")
	public void loginTest(String user) {
		
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
		
		db.clickLocation();
		logger.info("clicking on location");
		
		db.locationSelect();
		logger.info("selecting 1st location");
		logger.info("test passed");
    	
		/*
		 * lp.nextStepConfirm(); logger.info("login test passed");
		 */
	}
     
     @DataProvider(name="LoginData")
     public static Object[][] credentials() throws IOException {
     String path=System.getProperty("user.dir")+"/src/test/java/com/bookJane/testData/LoginData.xlsx";
     String user = XLUtils.getCellData(path,"Login", 1, 1);
     
         return new Object[][] { { user}};
      
       }
	/*
	 * @Test(priority=2) public void LocationTest() {
	 * 
	 * driver.get(dashUrl); logger.info("getting dashboard url");
	 * 
	 * DashboardPage db = new DashboardPage(driver);
	 * logger.info("initialising dashboard");
	 * 
	 * db.clickLocation(); logger.info("clicking on location");
	 * 
	 * db.locationSelect(); logger.info("selecting 1st location");
	 * logger.info("test passed");
	 * 
	 * }
	 */
	
	 @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	    	if(result.getStatus() == ITestResult.FAILURE) {
	    		captureScreen(driver,result.getName());
	    	}
	    }

}
