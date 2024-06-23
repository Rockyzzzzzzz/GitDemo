package rahulshettyacademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents 
{
	WebDriver driver;

	public AbstractComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cardHeader;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement orderHeader;
	

	public void waitForElementToAppear(By findBy) 
	{
         WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5)); 
		 w.until(ExpectedConditions.visibilityOfElementLocated(findBy)); 

	}
	
	public void waitForWebElementToAppear(WebElement findBy) 
	{
         WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5)); 
		 w.until(ExpectedConditions.visibilityOf(findBy)); 

	}
	
	public void waitForElementToDisappear(WebElement ele) 
	{
         WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5)); 
         w.until(ExpectedConditions.invisibilityOf(ele));
       
	}
	
	public CartPage goToCartPage()
	{
		cardHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}

}
