package com.bookJane.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Initialising driver		
	public WebDriver ldriver;
		//constructor
		public HomePage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//register button
		@FindBy(xpath="//button[@class='btn btn-default uppercase btn-block sc-gZMcBi htgqSL']")
		WebElement RegBtn;
		
		//login button
		@FindBy (xpath="//button[@class='btn btn-primary uppercase btn-block sc-gqjmRU boBGGn']")
		WebElement LoginBtn;
		
		public void clickReg() {
			RegBtn.click();
		}
		
		public void clickLogin() {
			LoginBtn.click();
		}
}
