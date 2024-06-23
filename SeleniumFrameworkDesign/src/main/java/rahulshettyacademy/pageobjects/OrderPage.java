package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents
{
	WebDriver driver;
	public OrderPage(WebDriver driver) 
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> productNames;
	

	public Boolean verifyOrderDisplay(String productName )
	{
		Boolean match = null;
		for(int i=0;i<productNames.size();i++)
		{
		    String name= productNames.get(i).getText();
		    match=name.contains(productName);
		    if(match==true)     //contains(Charsequence seq)  boolean
			{
				break;
				
			}
		    
		}
		System.out.println(match);
		return match;
	}
		
		
	
}
