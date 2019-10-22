package com.bookJane.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class DashboardPage {

	public WebDriver ldriver;
    //constructor
    public DashboardPage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
    
    //dashboard side panel
    @FindBy(xpath="//a[@class='nav-link dashboard active']")
    WebElement dashboardMenu;
    
    @FindBy(xpath="//a[@class='nav-link create shift']")
    WebElement createShiftMenu;
    
    @FindBy(xpath="//a[@class='nav-link shifts']")
    WebElement shiftsMenu;
    
    @FindBy(xpath="//a[@class='nav-link history']")
    WebElement historyMenu;
    
    @FindBy(xpath="//a[@class='nav-link communications']")
    WebElement commMenu;
    
    @FindBy(xpath="//a[@class='nav-link settings']")
    WebElement settingsMenu;
    
    @FindBy(xpath="//a[@class='nav-link']")
    WebElement logoutMenu;
    
    //dashboard top menu
    @FindBy(xpath="//label[contains(text(),'ACCEPTED')]")
    WebElement acceptedBtn;
    
    @FindBy (xpath="//label[contains(text(),'PENDING')]")
    WebElement pendingBtn;
    
    @FindBy(xpath="//label[contains(text(),'CANCELLED')]")
    WebElement cancelledBtn;
    
    @FindBy(xpath="//button[@class='icon-button btn btn-blue btn-create-shift-header d-none d-sm-block']")
    WebElement createShiftBtn;
    
    @FindBy(xpath="//div[@class='simple-select-value']")
    WebElement locationDrop;
    
    public void clickLocation() {
    	
    	locationDrop.click();
    	
    }
    public void locationSelect() {
    	
    	Actions act = new Actions(ldriver);
    	act.sendKeys(locationDrop, Keys.ARROW_DOWN).click().perform();
    }
    
    public void clickCreateShift() {
    	WebDriverWait wait = new WebDriverWait(ldriver,20);
    	//WebElement aboutMe;
    	wait.until(ExpectedConditions.elementToBeClickable(createShiftMenu));
    	createShiftMenu.click();
    	
    }
    
    public void clickLogout() {
    	WebDriverWait wait = new WebDriverWait(ldriver,20);
    	//WebElement aboutMe;
    	wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
    	logoutMenu.click();
    	
    }
    
}
