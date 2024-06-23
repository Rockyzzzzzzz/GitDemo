package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;

	public Boolean verifyProductDisplay(String productName )
	{
		Boolean match = null;
		for(int i=0;i<cartProducts.size();i++)
		{
		    String name= cartProducts.get(i).getText();
		    match=name.contains(productName);
		    if(match==true)     //contains(Charsequence seq)  boolean
			{
				break;
				
			}
		    
		}
		System.out.println(match);
		return match;
	}
		
		
	public CheckOutpage goToCheckOut()
	{
	   checkOutEle.click();
	   //CheckOutpage checkOutPage= new CheckOutpage(driver);
	  // return checkOutPage;
	   return new CheckOutpage(driver);
	}
		
	
}
