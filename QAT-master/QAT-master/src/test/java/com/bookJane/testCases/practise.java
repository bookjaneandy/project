package com.bookJane.testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookJane.pageObjects.DashboardPage;
import com.bookJane.pageObjects.HomePage;
import com.bookJane.pageObjects.LoginPage;
import com.bookJane.pageObjects.createShiftPage;
import com.bookJane.pageObjects.createShiftPage2;
import com.bookJane.utilities.XLUtils;

public class practise extends BaseClass{
	
	@Test(dataProvider="LoginData", priority =1)//invocationCount =3)
	public void createShiftTest(String user) throws Exception {
		
		
		driver.get(homeUrl);
    	logger.info("Getting url");
    	
      	HomePage hp = new HomePage(driver);
    	logger.info("initialising home page");
    	createShiftPage2 cs = new createShiftPage2(driver);
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
		
		cs.locClick();
		cs.dateBtnClick();
		cs.posClick();
		cs.roomClick();
		cs.janeClick();
		cs.submitClick();
		cs.confirmClick();
		//cs.confirmAlert();
		db.clickLogout();
		logger.info("logging out of the account");
		logger.info("Test passed");
		

	}

	 @DataProvider(name="LoginData")
     public static Object[][] credentials() throws IOException {
     String path=System.getProperty("user.dir")+"/src/test/java/com/bookJane/testData/LoginData.xlsx";
     String user = XLUtils.getCellData(path,"Login", 2, 1); // development login
        
         return new Object[][] { { user}};
      
       }
	 
	 @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	    	if(result.getStatus() == ITestResult.FAILURE) {
	    		captureScreen(driver,result.getName());
	    	}
	    }

}
