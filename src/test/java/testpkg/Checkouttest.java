package testpkg;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basepkg.base_class;
import pagepkg.Checkout_page;
import pagepkg.Loginpage;
import pagepkg.Product_page;
public class Checkouttest extends base_class
{
	Loginpage log;
    Product_page pdt;
    Checkout_page check;
	@Test
    public void Checkout() throws InterruptedException 
	{
        Loginpage log = new Loginpage(driver);
        Product_page pdt = new Product_page(driver);
        Checkout_page check = new Checkout_page(driver);
        
        test = extent.createTest("Checkout Process Test");
        
       
        log.setvalue("standard_user","secret_sauce");
        log.Buttontext();
        Thread.sleep(3000);
        
        pdt.logoverification();
        pdt.additems();
        
        
        List<WebElement> detail = pdt.Productdetails();
        Thread.sleep(3000);
        System.out.println("Total Number of Products: " + detail.size());
        test.pass("Total Number of Products added: " + detail.size());
        for(WebElement product : detail) 
        {
            System.out.println(product.getText());
        }
      
//        pdt.Menu();
//        test.pass("Menu clicked successfully");
//        Thread.sleep(3000);
//        
        pdt.CartIcon();
        test.pass("Navigated to Cartpage successfully");
        Thread.sleep(3000);
        
        check.Cart();
        Thread.sleep(3000);
        
        check.checkout();
        Thread.sleep(3000);
        
        Thread.sleep(3000);
        check.setvalues("vandhana", "krishnan", "691551");
        Thread.sleep(3000);
        
       
        check.finish();
        Thread.sleep(3000);
   
        check.Menu();
        Thread.sleep(3000);
        
       
        check.logout();
        Thread.sleep(3000);
        
        test.pass("Checkout process successfully completed");
    }


        
        
}
