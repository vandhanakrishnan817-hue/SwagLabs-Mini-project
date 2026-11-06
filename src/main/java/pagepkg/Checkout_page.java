package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page 
{
 WebDriver driver;                                                          //carticon
 @FindBy(xpath = "//div[@id='shopping_cart_container']")
 WebElement carticon;
 
 @FindBy(xpath = "//*[@id=\"checkout\"]")                                  //checkoutbtn
 WebElement Checkoutbutton;
 
@FindBy(xpath = "//*[@id=\"first-name\"]")                                //firstname
 WebElement firstname;
 
 @FindBy(xpath = "//*[@id=\"last-name\"]")                               //lastname
 WebElement lastname;
 
 @FindBy(xpath = "//*[@id=\"postal-code\"]")                            //zip
 WebElement zipcode;
 
 @FindBy(xpath = "//*[@id=\"continue\"]")                               //continue
 WebElement continuebutton;
 
 @FindBy(xpath = "//*[@id=\"finish\"]")                                 //finishbtn
 WebElement finishbutton;
 
 @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")                   //menu
 WebElement Menu;
 
 @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")                     //logout
 WebElement logout;
 
 
 public Checkout_page(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 public void Cart()
 {
	 carticon.click();
 }
 public void checkout()
 {
	 Checkoutbutton.click();
 }
 public void setvalues(String fname,String lname,String zip)
 {
	 firstname.sendKeys(fname);
	 lastname.sendKeys(lname);
	 zipcode.sendKeys(zip);
	 continuebutton.click();
 }
 public void finish()
 {
	 finishbutton.click();
 }
 public void Menu()
 {
	 Menu.click();
 }
 public void logout()
 {
	 logout.click();
 }

	
 }

