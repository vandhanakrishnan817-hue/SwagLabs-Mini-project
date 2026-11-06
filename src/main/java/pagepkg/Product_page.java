package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Product_page 
{
	WebDriver driver;

	@FindBy(xpath = "//div[@class='app_logo']")     //logo
    public WebElement Logo;

	@FindBy(xpath = "//button[text()='Add to cart']")     //cartbutton
	List<WebElement> Cart;
    
    @FindBy(xpath = "//div[@class='inventory_item']")     //productdetails
    List<WebElement> Productdetail;
 
    @FindBy(xpath = "//select[@class='product_sort_container']")   //sorting
    WebElement sortDropdown;

//    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")       //menu
//    WebElement Menu; 

    @FindBy(xpath = "//a[@class='shopping_cart_link']")            //carticon
    WebElement CartIcon;

    public Product_page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement logoverification() 
    {
        return Logo;
    }

    public void additems() throws InterruptedException 
    {
        for (WebElement items : Cart) 
        {
            Thread.sleep(2000);
            items.click();
        }
    }

    public List<WebElement> Productdetails() 
    {
        return Productdetail;
    }
 
    public void Sorting() 
    {
    	sortDropdown.click();
        Select select = new Select(sortDropdown);
        select.selectByValue("hilo");
    }

    public void CartIcon() 
    {
        CartIcon.click();
    }

	
		
	}

	
 
 
	
 

