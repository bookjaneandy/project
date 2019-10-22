package com.bookJane.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import com.bookJane.testCases.BaseClass;

import junit.framework.Assert;

public class createShiftPage2 extends BaseClass{

	public WebDriver ldriver;
    //constructor
    public createShiftPage2(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
    
    // Locators and elements
    
    @FindBy(xpath="//div[@class='ui fluid search selection dropdown']//input[@class='search']")
    WebElement locInput;
    @FindBy(xpath="//div[@id='52']")
    WebElement qatest;
    @FindBy(xpath="//div[@id='100']")
    WebElement hello;
    
    public boolean locClick() {
    	locInput.click();
    	logger.info("location input clicked");
    	qatest.click();
    	logger.info("selecting the location from the drop down");
    	return qatest.isSelected();
    	 
    
    }
    
    public boolean locSandbox() {
    	locInput.click();
    	logger.info("location input clicked");
    	hello.click();
    	logger.info("selecting the location from the drop down");
    	return hello.isSelected();
    	 
      }
    
    @FindBy(xpath="//button[contains(text(),'SET DATES')]")
    WebElement dateBtn;
    @FindBy (xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement nxtMonth;
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
    WebElement Dropdown;
    @FindBy (xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/i[1]")
    WebElement dateExit;
    @FindBy (xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--prev'] ")
    WebElement prevMonth;
    @FindBy(className="DayPicker-Day DayPicker-Day--today")
    WebElement today2;
    @FindBy(xpath="//div[contains(text(),'18')]")
    WebElement date18;
    @FindBy(xpath="//div[contains(text(),'27')]")
    WebElement date27;
    
    public void dateBtnClick() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(dateBtn));
    	dateBtn.click();
	  	logger.info("date button clicked");
	  	
    	wait.until(ExpectedConditions.elementToBeClickable(nxtMonth));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", nxtMonth);
    	logger.info("clicking next month");
    	wait.until(ExpectedConditions.elementToBeClickable(date18));
    	js.executeScript("arguments[0].click();", date18);
    	logger.info("clicking date 18");
    	wait.until(ExpectedConditions.elementToBeClickable(dateExit));
    	js.executeScript("arguments[0].click();", dateExit);
    	logger.info("exiting the calendar");
    }
    
    public void dateBtnSandbox() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(dateBtn));
    	dateBtn.click();
	  	logger.info("date button clicked");
	  	
    	//wait.until(ExpectedConditions.elementToBeClickable(nxtMonth));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();", nxtMonth);
    	//logger.info("clicking next month");
    	wait.until(ExpectedConditions.elementToBeClickable(date27));
    	js.executeScript("arguments[0].click();", date27);
    	logger.info("clicking date 27");
    	wait.until(ExpectedConditions.elementToBeClickable(dateExit));
    	js.executeScript("arguments[0].click();", dateExit);
    	logger.info("exiting the calendar");
    }
    
    @FindBy(xpath="//div[6]//div[3]//div[1]//input[1]")
    WebElement posInput;
    //Positions to be tested
    @FindBy(id="14")
    WebElement eca; 
    @FindBy(id="25")
    WebElement rece_eca;  //String expected="RECE or ECA - $22.00";
    @FindBy(id="17")
    WebElement psw1;  //String expected="Personal Support Worker (1:1) - $27.00";
    
    @FindBy(id="16")
    WebElement companion; 
    
    public boolean posClick() {
    	posInput.click();
    	logger.info("position input clicked");
    	eca.click();
    	logger.info("selecting the ECA from the drop down");
    	return eca.isSelected();
    }
    
    public boolean posSandbox() {
    	posInput.click();
    	logger.info("position input clicked");
    	companion.click();
    	logger.info("selecting the companion from the drop down");
    	return companion.isSelected();
    }
    
    public boolean posClick2() {
    	posInput.click();
    	logger.info("position input clicked");
    	rece_eca.click();
    	logger.info("selecting the RECE or ECA from the drop down");
    	return rece_eca.isSelected();
    }
    
    public boolean posClick3() {
    	posInput.click();
    	logger.info("position input clicked");
    	psw1.click();
    	logger.info("selecting the PSW 1:1 from the drop down");
    	return psw1.isSelected();
    }
    
    
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[3]/div[1]/div[1]")
    WebElement roomInput;
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[3]/div[1]/div[2]/div[1]/span[1]")
    WebElement  infant;
    
    public boolean roomClick() {
    	roomInput.click();
    	logger.info("room input clicked");
    	infant.click();
    	logger.info("selecting the ECA from the drop down");
    	return infant.isSelected();
    }
    
    @FindBy (xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[9]/div[3]/button[1]")
    WebElement searchJane;
    @FindBy (xpath="/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement janeInput;
    @FindBy (xpath="/html[1]/body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/button[1]")
    WebElement request;
       
    public void janeClick() throws Exception {
    	searchJane.click();
    	logger.info("Clicking on search Jane");
    	janeInput.click();
    	logger.info("clicking on jane search input");
    	janeInput.sendKeys("qa");
    	Thread.sleep(5000);
    	request.click();
    	logger.info("requesting a jane");
       	
    }
    
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[12]/div[3]/button[1]")
    WebElement submit;
    
    public void submitClick() {
    	submit.click();
    	logger.info("clicking submit button");
    	
    }
    
    @FindBy(xpath="/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]")
    WebElement confirm;
    
    public void confirmClick() {
    	confirm.click();
    	logger.info("clicking confirm button");
    }
    
    public boolean isAlertPresent() {
		try {
			ldriver.switchTo().alert();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
    
    public void confirmAlert() {
		Alert popup = ldriver.switchTo().alert();
		String alText = "Order created";
		String alertMsg = popup.getText();
		if (isAlertPresent()) {
			Assert.assertEquals(alText, alertMsg);
			popup.accept();
		}
	}
    
    
    
    
    
    
}
