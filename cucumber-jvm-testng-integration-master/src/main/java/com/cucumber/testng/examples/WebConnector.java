package com.cucumber.testng.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnector {

	//initialize properties ifle
	// logging 
 
	Properties OR=null;
	Properties QACONFIG=null;
    WebDriver driver;
	public WebConnector(){
		
	 if (OR==null){
		
		 // initialize OR
		 OR=new Properties();
		 try {
		 FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\configurations\\OR.properties");
			OR.load(fs);
			//OR.getProperty("testEnv");
		 
			//initialize CONFIG to corresponding env.
			
			QACONFIG=new Properties();
			fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\configurations\\QA_env.properties");
			QACONFIG.load(fs);
		 }
		  catch (IOException e) {
			 System.out.println("Error on initalizing properties files");
 
		}
		 
	 }
		
	}
	
	// selenium layer.... (
    //Opening Browser
	public void openBrowser(String brname){
				
	 if(brname.equals("IE")){
				
			System.out.println("IE Launching");
		    System.setProperty("webdriver.ie.driver", 
			"C:/Users/Sravya/AppiumTraniningProject/Driverexes/IEDriverexe/IEDriverServer.exe"); 
			driver=new InternetExplorerDriver();
	} else if(brname.equals("chrome")){
				
 
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\neslavath\\Downloads\\RajSeleniumCucumber\\RajSeleniumCucumber\\driver\\chromedriver.exe");
		driver=new ChromeDriver(); 
		
	 
	}else if(brname.equals("Firefox")){
		
		driver=new FirefoxDriver();
	}
	else{
		System.out.println(brname +"::Specified browser is not defined to launch");
	}
 
	 
	
		
	}
	
	//navigate to a URL
	public void navigateURL(String URL){
		
     driver.get(QACONFIG.getProperty(URL));
     // window max
     driver.manage().window().maximize();
	}
	//Click on on any object
	public void click(String locator){
		
   // driver.findElement(By.id(OR.getProperty(locator))).click();
    
   WebElement element= checkFindElement(locator);
   element.click();
	}
	public void enterText(String locator,String datatxt){
		
		//driver.findElement(By.id(OR.getProperty(locator))).sendKeys(datatxt);
	    
		   WebElement element= checkFindElement(locator);
		   element.sendKeys(datatxt);
	}
	 
	
	public void closeBr(){
		
		driver.close();
	}
	
	public WebElement  checkFindElement(String locator){
		
		WebElement element =null;
		if(locator.endsWith(Constant.id)){
			
			element=driver.findElement(By.id(OR.getProperty(locator)));
		}
		else if(locator.endsWith(Constant.name)){
			element=driver.findElement(By.name(OR.getProperty(locator)));

		}
		else if(locator.endsWith(Constant.linktxt)){
			element=driver.findElement(By.linkText(OR.getProperty(locator)));

		}  
		else if(locator.endsWith(Constant.tagname)){
			element=driver.findElement(By.tagName(OR.getProperty(locator)));

		}  
		  
		else if(locator.endsWith(Constant.classname)){
			element=driver.findElement(By.className(OR.getProperty(locator)));

		}  
		  
		else if(locator.endsWith(Constant.xpath)){
			element=driver.findElement(By.xpath(OR.getProperty(locator)));

			} 
		else if(locator.endsWith(Constant.csselctor)){
			element=driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} 
		else if(locator.endsWith(Constant.plinktxt)){
			element=driver.findElement(By.partialLinkText((OR.getProperty(locator))));

		}
		return element; 
 
 
	}
	
	public boolean isElementPresent(String locator){
		boolean b=false;
		try{
			
			 WebElement element= checkFindElement(locator);
			if(element!=null){
			b=true;
			}
		}catch(Exception e){
			
		}
		return b;
		
	}
	public boolean verifyText (String message){
		boolean b=false;
		WebElement element= checkFindElement(message);
		String actual_value=element.getText();
		if (message.equals(actual_value)){
			b=true;
		}
		return b;
	}

	public boolean verifyText2 (String errormessage){
		boolean b=false;
		WebElement element= checkFindElement("loginerrormsg_xpath");
		String actual_value=element.getText();
		if (errormessage.equals(actual_value)){
			b=true;
		}
		return b;
	}
	
	public String getTitle(){
	/*    String pgTitle=driver.getTitle();
	       return pgTitle;	    */
	    
	    return driver.getTitle();
		
	}
	
	public void takeScreenShot(String location){
		
		// Selenium code
	}
	public static void main(String[] args) {
	 

	}

}
