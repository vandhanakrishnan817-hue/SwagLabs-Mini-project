package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
 WebDriver driver;                                                 //username field
 @FindBy(id = "user-name")
 public WebElement username;
 
 @FindBy(xpath = "//*[@id=\"password\"]")                          //pass field
 public WebElement password;
  
 @FindBy (xpath = "//*[@id=\"login-button\"]")                      //login button
 public WebElement login;
 
 @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")                    //logo verification
 public WebElement logo;
  
 public Loginpage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 public WebElement Logoverification()
 {
	 return logo;
 }
 public WebElement Buttontext()
 {
	 return login;
 }
 public void setvalue(String user,String pass) throws InterruptedException 
 {
	username.sendKeys(user); 
	password.sendKeys(pass); 
	login.click();
	Thread.sleep(3000);
 }
 
	
 }

	
 

	
 

