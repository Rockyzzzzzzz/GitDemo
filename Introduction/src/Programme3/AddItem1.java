package Programme3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItem1 
{

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(products.size());
		for(int i=0;i<products.size();i++)
		{
			
			String name=products.get(i).getText();  // name=  Brocolli - 1 Kg, Cucumber - 1 Kg
			if(name.contains("Cucumber"))   //Cucumber -1kg.contains("Cucumber")  //contains(Charsequence seq)  boolean
			{
				//click on add to cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
				
			}
			
	
	    }

	}
}
