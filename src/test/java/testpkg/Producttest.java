package testpkg;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import basepkg.base_class;
import basepkg.reportgeneration;
import pagepkg.Loginpage;
import pagepkg.Product_page;

public class Producttest extends base_class
{
	Loginpage log;
    Product_page pdt;
    
    @Test(priority = 1)

    public void logo() throws IOException, InterruptedException 
    	{
    log=new Loginpage(driver);
    log.setvalue("standard_user", "secret_sauce");
    log.Buttontext();
    test = extent.createTest("logo validation test");
    pdt=new Product_page(driver);
    WebElement elt = pdt.logoverification();
            
        if(elt.isDisplayed()) 
            {
                test.pass("logo displayed in product page");
            } 
            else 
            {
                String path = reportgeneration.screenshotMethod(driver, "logofailed");
                test.addScreenCaptureFromPath(path);
                test.fail("logo not displayed");
            }
        }

    @Test(priority = 2)
    public void additemstocart() throws InterruptedException {
    test = extent.createTest("Product Page actions & Carttest");
    

    pdt = new Product_page(driver);
    Thread.sleep(5000);
    
    pdt.Sorting();
    test.pass("products sorted by price(low to high)");
    Thread.sleep(3000);
    
    pdt.additems();
    Thread.sleep(5000);
            
    List<WebElement> detail = pdt.Productdetails();
    Thread.sleep(3000);
    System.out.println("Total Number of Products: " + detail.size());
    test.pass("Total Number of Products added: " + detail.size());
    for(WebElement product : detail) 
    {
        System.out.println(product.getText());
    }
  
//    pdt.Menu();
//    test.pass("Menu clicked successfully");
//    Thread.sleep(3000);
//    
    pdt.CartIcon();
    test.pass("Navigated to Cartpage successfully");
    Thread.sleep(3000);
    }}
    
    
    
    	

