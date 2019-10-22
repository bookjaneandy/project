package com.bookJane.pageObjects;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.google.maps.*;

public class RegistrationPage {
//Initialising driver		
public WebDriver ldriver;
	//constructor
	public RegistrationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//Organisation name
	@FindBy(xpath="//input[@placeholder='Enter Organization Name']")
	WebElement txtOrg;
	
	//first name
	@FindBy(xpath="//div[@class='required field']//input[@placeholder='Enter First Name']")
	WebElement txtFname;
	
	//last name
	@FindBy(xpath="//div[@class='required field']//input[@placeholder='Enter Last Name']")
	WebElement txtLname;
	
	//phone number
	@FindBy(xpath="//div[@class='required field']//input[@placeholder='Enter Phone Number']")
	WebElement txtPhone;
	
	//email
	@FindBy(xpath="//input[@placeholder='Enter Email Address']")
	WebElement txtEmail;
	
	//password
	@FindBy(xpath="//input[@placeholder='Enter Password']")
	WebElement txtPswd;
	
	//re-enter password
	@FindBy(xpath="//input[@placeholder='Re-enter your Password']")
	WebElement txtPswd2;
	
	//location name
	@FindBy(xpath="//div[@class='ui input']//input[@placeholder='Enter Location Name']")
	WebElement txtLocation;
	
	//location address
	@FindBy(xpath="//div[@class='ui input fluid']//input[@placeholder='Enter Location Name']")
	WebElement txtLocAddress;
	
	//checkbox for billing address
	@FindBy(xpath="//label[contains(text(),'Use Primary Contact as Billing Contact for this lo')]")
	WebElement checkboxBill;
	
	//billing FirstName
	@FindBy(xpath="//div[@class='field']//input[@placeholder='Enter First Name']")
	WebElement txtFnameB;
	
	//billing LastName
	@FindBy(xpath="//div[@class='field']//input[@placeholder='Enter Last Name']")
	WebElement txtLnameB;
	
	//billing Phone
	@FindBy(xpath="//div[@class='field']//input[@placeholder='Enter Phone Number']")
	WebElement txtPhoneB;
	
	//check box terms 
	@FindBy (xpath="//div[15]//div[1]//label[1]")
	WebElement checkBoxTerms;
	
	//check box privacy
	@FindBy (xpath="//div[16]//div[1]//label[1]")
	WebElement checkBoxPrivacy;
	
	//Back button
	@FindBy(xpath="//button[contains(text(),'BACK')]")
	WebElement backBtn;
	
	// register button
	@FindBy(xpath="//button[contains(text(),'REGISTER')]")
	WebElement registerBtn;
	
	//values for organisation
	public void setOrg(String organisation) {
		txtOrg.sendKeys(organisation);
	}
	
	public void setFname(String firstName) {
		txtFname.sendKeys(firstName);
	}
	
	public void setLname(String lastName) {
		txtLname.sendKeys(lastName);
	}
	
	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void setEmail(String email) {
		double x = Math.random();
		txtEmail.sendKeys(email+x+"@gmail.com");
	}
	
	public void setPswd(String password) {
		txtPswd.sendKeys(password);
	}
	
	public void setPswd2(String password2) {
		txtPswd2.sendKeys(password2);
	}
	
	public void setLocation(String location) {
		txtLocation.sendKeys(location);
	}
	
	public void setLocAdd(String locAdd) {
		txtLocAddress.sendKeys(locAdd);
	}
	
	public void setLocAdd2(String locAdd) {
		//txtLocAddress.sendKeys(locAdd);
		Actions act = new Actions(ldriver);
		act.sendKeys(txtLocAddress,locAdd).build().perform();
		
	}
	
	public void locAddressNext() {
		Actions act = new Actions(ldriver);
		act.sendKeys(txtLocAddress, Keys.ARROW_DOWN).sendKeys(txtLocAddress,Keys.ENTER).build().perform();
	}
	

	
	public void setFnameB(String firstNameB) {
		txtFnameB.sendKeys(firstNameB);
	}
	
	public void setLnameB(String lastNameB) {
		txtLnameB.sendKeys(lastNameB);
	}
	
	public void setPhoneB(String phoneB) {
		txtPhoneB.sendKeys(phoneB);
	}
	
	public void tryCheckboxBill() {
		checkboxBill.click();
	}
	
	public void tryCheckBoxTerms() {
		Actions action=new Actions(ldriver);
		action.moveToElement(checkBoxTerms).click().perform();
		//checkBoxTerms.click();
	}
	
	public void tryCheckBoxTerms2() {
		checkBoxTerms.click();
	}
	public void tryCheckBoxPrivacy() {
		checkBoxPrivacy.click();
	}
	
	public void clickBack() {
		backBtn.click();
	}
	
	public void clickSub() {
		registerBtn.click();
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
		String alText = "We will contact you shortly after checking your profile. A notification email will be sent to you shortly.";
		String alertMsg = popup.getText();
		if (isAlertPresent()) {
			Assert.assertEquals(alText, alertMsg);
			popup.accept();
		}
	}
		
		public void popUp() {
			
			String MainWindow=ldriver.getWindowHandle();		
    		
	        // To handle all new opened window.				
	            Set<String> s1=ldriver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    ldriver.switchTo().window(ChildWindow);	                                                                                                           
	                    ldriver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
	                                 
				// Closing the Child Window.
	                        ldriver.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            ldriver.switchTo().window(MainWindow);				
	    }
		
	
	
	public void nextStepConfirm() {
		String expectedTitle = ldriver.getTitle();
		String actualTitle ="BookJane";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}
