package com.bookJane.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
		    
	        
	    public WebDriver ldriver;
	    //constructor
	    public LoginPage(WebDriver rdriver)
	    {
	        ldriver=rdriver;
	    PageFactory.initElements(rdriver, this);
	    }
	    
	      
	    @FindBy(xpath="//input[@placeholder='Enter Your Email']")
	    WebElement emailTxt;
	    
	    @FindBy(xpath="//input[@placeholder='Enter Your Password']")
	    WebElement pswdTxt;

	    @FindBy(xpath="//button[@class='btn btn-primary uppercase btn-block']")
	    WebElement continuebtn;

	   @FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	   WebElement forgotPswd;
	   
	   @FindBy(xpath="//div[contains(text(),'Log In')]")
	   WebElement backBtn;

	    //methods
	    public void setEmail(String em) {
	        emailTxt.sendKeys(em);
	    }
	    public void setPass(String pw) {
	        pswdTxt.sendKeys(pw);
	    }
	    public void loginBtn(){
	        continuebtn.click();
	    }
	    public void clickForgot() {
	        forgotPswd.click();
	    }
	    
	    public void clickBack() {
	    	backBtn.click();
	    }
	    
	    public void nextStepConfirm() {
			String expectedTitle = ldriver.getTitle();
			String actualTitle ="BookJane";
			Assert.assertEquals(actualTitle, expectedTitle);
		}
	    
	/*
	 * public void nextStepConfirm2() { String expectedUrl =
	 * ldriver.getCurrentUrl(); String actualUrl
	 * ="bjk20ui-20190212125305-hostingbucket.s3-website-us-east-1.amazonaws.com/dashboard";
	 * Assert.assertEquals(actualUrl, expectedUrl); }
	 */

}
