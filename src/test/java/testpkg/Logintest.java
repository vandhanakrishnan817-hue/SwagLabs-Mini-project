package testpkg;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilitiespkg.Excelutil;
import basepkg.base_class;
import basepkg.reportgeneration;
import pagepkg.Loginpage;

public class Logintest extends base_class
{
	Loginpage log;
    
    
    @DataProvider(name="logindata")
    public Object[][]getData() throws IOException
    {
  	  String path="C:\\Users\\VANDHANA K\\Downloads\\swaglab.xlsx";
  	  return Excelutil.getTestData(path, "sheet1");
    }
    
    @Test(dataProvider = "logindata",priority = 1)
    public void loginTest(String user,String pass) throws IOException, InterruptedException 
    {
  	  driver.get("https://www.saucedemo.com/");
  	  
  	  Thread.sleep(3000);
  	  test=extent.createTest("Login Test -" + user);
  	  log=new Loginpage(driver);
  	  log.setvalue( user,pass);
  	  Thread.sleep(3000);
  	  System.out.println("Executed for: " + user);
  	  String currentUrl= driver.getCurrentUrl();
  	  
  	  if(currentUrl.equals("https://www.saucedemo.com/inventory.html"))
  		  
  	  {
  		  Thread.sleep(3000);
  		  test.pass("Login successful for: " +user);
  	  }
  	  
  	  else 
  	  {
//  	      Thread.sleep(3000);
  		  String screenshotName= "Login_Failed " + user;
  		  reportgeneration.screenshotMethod(driver, screenshotName);
  		  test.addScreenCaptureFromPath("screenshot\\" + screenshotName + ".png");
  		  test.fail("Login failed for:" +user);
  		  Assert.fail("Login failed for:" +user);
  		  
  		  
  	  }
    }
   
    
    @Test(priority = 2)
    public void Logoverification() throws IOException
    {
  	  driver.get("https://www.saucedemo.com/");
  	  test=extent.createTest("Logo Validation Test");
  	  log=new Loginpage(driver);
  	  WebElement x=log.Logoverification();
  	  
  	  if(x.isDisplayed())
  	  {
  		  test.pass("Logo displayed");
  	  }
  	  else
  	  {
  		  String screenshotName = "logo validation";
  		  reportgeneration.screenshotMethod(driver, screenshotName);
  		  test.addScreenCaptureFromPath(".\\Reports\\screenshot\\"+ screenshotName+ ".png");
  		  test.fail("Logo not displayed");
  		  Assert.fail("Logo not displayed");
  	  }
  	  
  	  		
  	  
    }
    
    @Test(priority = 3)
    public void buttontextvalidation() throws IOException
    {
  	  driver.get("https://www.saucedemo.com/");
  	  test=extent.createTest("Button Text Validation Test");
  	  log=new Loginpage(driver);
  	  String text=log.Buttontext().getDomAttribute("value");
  	  
  	  if(text.equals("Login"))
  	  {
  		  test.pass("Buttontext verified");
  	  }
  	  
  	  else
  	  {
  		  String screenshotName = "buttontext validation";
  		  reportgeneration.screenshotMethod(driver, screenshotName);
  		  test.addScreenCaptureFromPath(".\\Reports\\screenshot\\"+ screenshotName+ ".png");
  		  test.fail("Buttontext is not correct");
  		  Assert.fail("Button Text is not correct");
  		  
  	  }
  	  
  	  
    }
    
    @Test(priority = 4)
    public void placeholdervalidation() throws IOException
    {
  	  driver.get("https://www.saucedemo.com/");
  	  
        test=extent.createTest("Placeholder validation Test ");
  	  
  	  log=new Loginpage(driver);
  	  String username=log.username.getDomAttribute("placeholder");
	  String password=log.password.getDomAttribute("placeholder");
	  
	  
	  if(username.equals("Username") && password.equals("Password"))
	  {
		  test.pass("placeholder validation passed");
	  }
	  else
	  {
          String screenshotName = "placeholder_validation";
		  reportgeneration.screenshotMethod(driver, screenshotName);
		  test.addScreenCaptureFromPath(".\\Reports\\screenshot\\"+ screenshotName+ ".png");
		  test.fail("Placeholder validation failed");
		  Assert.fail("placeholder validation failed");
	  }
	  
	  
  }
  
}


