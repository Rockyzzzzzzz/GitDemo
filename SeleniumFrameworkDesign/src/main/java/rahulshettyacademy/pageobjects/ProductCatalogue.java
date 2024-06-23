package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents
{
    WebDriver driver;
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	 // List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));

	//using PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(xpath="//button[text()=' Add To Cart']")
	List<WebElement> addToCart;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsBy= By.cssSelector(".mb-3");
	By toastMessage= By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	
	public void addProductToCart (String productName)
	{
		for(int i=0;i<products.size();i++)
		{
			WebElement product= products.get(i);
			String name= product.findElement(By.cssSelector("b")).getText();    //using css parent child traverse
			System.out.println(name); //ZARA COAT 3
			if(name.contains(productName))     //contains(Charsequence seq)  boolean
			{
				//click on add to cart
				addToCart.get(i).click();
				break;
				
			}
			
		}
		
		   waitForElementToAppear(toastMessage);
		   waitForElementToDisappear(spinner);
		
	}
	
	
}
	
	
	
	
	
	
	


