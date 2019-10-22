package com.bookJane.pageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import com.bookJane.testCases.BaseClass;

import junit.framework.Assert;


public class createShiftPage extends BaseClass {
	public WebDriver ldriver;
    //constructor
    public createShiftPage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
    
    //@FindBy(xpath="//body/div[@id='app']/main/div[@class='wrapper']/div[@class='content']/div[@class='fadeIn animated sc-lhVmIH kKSbIA']/div[@class='ui basic segment pushable']/div[@class='pusher']/div[@class='ui basic segment']/div[@class='sc-bYSBpT ipKwBl']/div[1]/div[3]")
    //@FindBy(xpath="//div[@class='ui active visible fluid search selection dropdown']")
    @FindBy(xpath="//div[@class='ui fluid search selection dropdown']//i[@class='dropdown icon']")
    WebElement LocDrop;
    
    @FindBy(xpath="//div[@class='ui fluid search selection dropdown']//i[@class='dropdown icon']")
    List<WebElement> LocDropList;
    
    //@FindBy(xpath="//button[@class='ui button sc-hEsumM caHeZw']")
    @FindBy(xpath="//button[contains(text(),'SET DATES')]")
    WebElement dateBtn;
    
    @FindBy(xpath="//div[@class='pusher']//div[2]//div[1]//input[1]")
    WebElement fromTime;
    
    @FindBy(xpath="//body/div[@id='app']/main/div[@class='wrapper']/div[@class='content']/div[@class='fadeIn animated sc-lhVmIH kKSbIA']/div[@class='ui basic segment pushable']/div[@class='pusher']/div[@class='ui basic segment']/div[@class='sc-bYSBpT ipKwBl']/div[@class='sc-jtRfpW fZupaZ']/div[@class='sc-dfVpRl jAHpVn']/div[@class='sc-bbmXgH jQRRLE']/div[3]/div[1]")
    WebElement toTime;
    
    //@FindBy(xpath="//div[@class='ui active visible fluid search selection dropdown']")
    @FindBy(xpath="//div[6]//div[3]//div[1]//i[1]")
    WebElement positionDrop;
    
    @FindBy(xpath="//div[@class='react-switch']")
    WebElement trainSwitch;
    
    @FindBy(xpath="//div[@class='ui fluid input']//input")
    WebElement resId;
    
    //@FindBy(xpath="//div[@class='ui fluid selection dropdown']")
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[3]/div[1]/i[1]")
    WebElement roomDrop;
    
    //@FindBy(xpath="//button[contains(text(),'SEARCH JANES')]")
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[9]/div[3]/button[1]")
    WebElement searchJane;
    
    @FindBy(xpath="//textarea[@placeholder='Notes']")
    WebElement notes;
    
    @FindBy (xpath="//button[@class='ui button sc-ktHwxA gMxqLw']")
    WebElement subBtn;
    
    @FindBy(xpath="//div[@class='visible menu transition']")
    List<WebElement> locations;
    
    @FindBy (xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement nxtMonth;
        
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
    WebElement Dropdown;
    
    @FindBy (xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/i[1]")
    WebElement dateExit;
    
    @FindBy (xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--prev'] ")
    WebElement prevMonth;
    
    @FindBy(xpath ="/html[1]/body[1]/div[5]/div[1]/div[2]/h3[1]/span[1]")
    WebElement available;
    @FindBy(partialLinkText ="qa")
    WebElement jane;
    
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
    List<WebElement> months;
    
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]")
    List<WebElement> weeks;
    
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]")
    List<WebElement> days;
    
    @FindBy(className="DayPicker-Day DayPicker-Day--today")
    WebElement today2;
    
    @FindBy(xpath="//div[contains(text(),'18')]")
    WebElement date18;
    
    @FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[3]/div[1]/div[2]/div[1]/span[1]")
    WebElement infantRoom;
    
    //create a function to select a location from drop down
   
    
	/*
	 * public void locSelect2() { //WebDriverWait wait=new WebDriverWait(driver, 5);
	 * //wait.until(ExpectedConditions.visibilityOfAllElements(LocDrop));
	 * LocDrop.click(); //LocDrop.sendKeys(Keys.ARROW_DOWN);
	 * //LocDrop.sendKeys(Keys.ENTER); }
	 */
    
    public void locations() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	WebElement location;
    	wait.until(ExpectedConditions.elementToBeClickable(LocDrop));
    	Actions act = new Actions(ldriver);
    	act.moveToElement(LocDrop).click().perform();
        act.sendKeys(Keys.ARROW_DOWN).click().perform();
        
       // assert.ass
    
    }
    
    @FindBy(id="52")
    WebElement locSel;
    
   public void locations2() throws Exception {
	   WebDriverWait wait = new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.elementToBeClickable(LocDrop));
	   
	   LocDrop.click();
	   logger.info("Location drop down has been clicked");
	   //Thread.sleep(5000);
	   
	   String actual = locSel.getText();
	   String expected = "QATest";
	  // String expected ="%Stage%";
	   System.out.println(actual);
	   Assert.assertEquals(expected, actual);
	   wait.until(ExpectedConditions.elementToBeClickable(locSel));
	   locSel.isSelected();
	   //Thread.sleep(5000);
	   logger.info("location from the drop down is selected");
   }
 
    public void dateBtnClick() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	//WebElement aboutMe;
    	wait.until(ExpectedConditions.elementToBeClickable(dateBtn));
    	dateBtn.click();
	  	logger.info("date button clicked");
    }
    
    public void loadTime() {
    	long start = System.currentTimeMillis();
    	long finish = System.currentTimeMillis();
    	long totalTime = finish - start; 
    	System.out.println("Total Time for page load - "+totalTime); 
    }
    
    public void JanepopUp() {
		
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
                   // WebDriverWait wait = new WebDriverWait(driver,20);
                	//ldriver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("qa",Keys.ENTER);
                	//wait.until(ExpectedConditions.(search));
                	//search.sendKeys("qa",Keys.ENTER);
                    
                    //availableJanes();
                	try {
						janeSelect();
					} catch (SikuliException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  
                    
			// Closing the Child Window.
                        ldriver.close();		
            }		
        }		
        // Switching to Parent window i.e Main Window.
            ldriver.switchTo().window(MainWindow);				
    }
  
    
    public void availableJanes() {
    	
    	String text = available.getText();
    	Integer num = Integer.parseInt(text);
    	
    	if(num>0) {
    		//look for Jane whose name starts with "QA"
    	     jane.click();
    	}
    }

    
    public void clickToday() {
    	today2.click();
    }
    
     
    public void frame() {
    	
    	 List<WebElement> ele = driver.findElements(By.tagName("frame"));
    	    System.out.println("Number of frames in a page :" + ele.size());
    	    for(WebElement el : ele){
    	      //Returns the Id of a frame.
    	        System.out.println("Frame Id :" + el.getAttribute("id"));
    	      //Returns the Name of a frame.
    	        System.out.println("Frame name :" + el.getAttribute("name"));
    	    }
   
    	    
    }
    
    public void windowHandles() {
    	
    	Set<String> handles = driver.getWindowHandles();

        System.out.println("window handles = " + handles);
    }
    
    public void datePicker() throws FindFailed {
    	String path = System.getProperty("user.dir");
    	Pattern Jan = new Pattern(path +"/Sikuli/january.png");
    	Pattern June = new Pattern(path +"/Sikuli/June.PNG");
    	Pattern next = new Pattern(path +"/Sikuli/nxtMonth.PNG");
    	Pattern fifteen = new Pattern(path +"/Sikuli/fifteen.PNG");
    	Pattern exit = new Pattern(path +"/Sikuli/dateExit.PNG");
    	
    	Screen s=new Screen();
    	
    	s.wait(next,20);
    	s.click(next);
    	s.wait(fifteen,20);
    	s.click(fifteen);
    	s.wait(exit,20);
    	s.click(exit);
    }
   
    public void janeSelect() throws SikuliException {
    	String path = System.getProperty("user.dir");
    	Pattern searchTxt = new Pattern(path+"/Sikuli/search.png");
    	Pattern clickJane = new Pattern(path+"/Sikuli/MaryQ_Jane.png");
    	
    	Screen s = new Screen();
    	
    	s.wait(searchTxt,20);
    	s.type(searchTxt,"qa");
    	availableJanes();
    	s.wait(clickJane,20);
    	s.click(clickJane);
    }
    
    public void datePicker2() {
    	
    	WebDriverWait wait = new WebDriverWait(driver,20);
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
    
    public void location() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", LocDrop);
    	js.executeScript("console.log(arguments[0]", LocDrop);
    }
    //create a function to select a date/time
    
    
    //create a function to adjust the time
    
    
    //create a function to adjust the position type
    
    public void position() {
    	//positionDrop.click();
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(positionDrop));
    	Actions act = new Actions(ldriver);
    	act.moveToElement(positionDrop).click().perform();
    	act.sendKeys(Keys.ARROW_DOWN).click().perform();
    	
    }
    
    //Positions
    @FindBy(id="14")
    WebElement eca; 
    @FindBy(id="25")
    WebElement rece_eca;  //String expected="RECE or ECA - $22.00";
    @FindBy(id="17")
    WebElement psw1;  //String expected="Personal Support Worker (1:1) - $27.00";
    
    
    
    
    public void positions() {
       positionDrop.click();
 	   logger.info("Position drop down has been clicked");
 	   //Thread.sleep(5000);
 	   
 	   String actual = eca.getText();
 	   String expected = "Early Childhood Assistant - $22.00";
 	  
 	   Assert.assertEquals(expected, actual);
 	   eca.isSelected();
 	   //Thread.sleep(5000);
 	   logger.info("position from the drop down is selected");
    	
    }
    //create a function to select room
    public void rooms() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(roomDrop));
    	Actions act = new Actions(ldriver);
    	act.moveToElement(roomDrop).perform();
    	act.sendKeys(Keys.ARROW_DOWN).click().perform();
    }
    
    
    public void roomClick() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(roomDrop));
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", roomDrop);
   
    	logger.info("clicking drop down for room type");
    	
    }
    
   
    
    //create a function to adjust the training switch
    
    //create a function to enter the resident id
    
    //Create a function to click on request jane
    public void clickJane() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(searchJane));
    	Actions act = new Actions(ldriver);
    	act.moveToElement(searchJane).click().perform();
    	//		searchJane.click();
    }
    
    public void submitShift() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(subBtn));
    	subBtn.click();
    }
    //create a function to search a jane in the popup
    
    //create a function to request a jane in the popup
    
    //create a function to navigate the pages
    
    
    
    
    
}
