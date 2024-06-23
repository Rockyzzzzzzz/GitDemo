package rahulshettyacademy.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest 
{

	public static void main(String[] args) 
	{
		String productName= "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("rakeshvijayh33@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rakesh@94");
		driver.findElement(By.id("login")).click();
		
		 WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5)); 
		 
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));   //wait in cases products rae not loaded
		
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		System.out.println(products.size());
		for(int i=0;i<products.size();i++)
		{
			WebElement product= products.get(i);
			//String name= product.findElement(By.xpath("//h5/b")).getText();  //using xpath parent child traverse
			String name= product.findElement(By.cssSelector("b")).getText();    //using css parent child traverse
			System.out.println(name); //ZARA COAT 3
			if(name.contains(productName))     //contains(Charsequence seq)  boolean
			{
				//click on add to cart
				driver.findElements(By.xpath("//button[text()=' Add To Cart']")).get(i).click();
				break;
				
			}
		}
		
		 
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		 
		// w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));  //this is loading late and creating performance issue
		 w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));  //this makes faster
		 
		 driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		 
		 List<WebElement> cartProducts= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		 for(int i=0;i<cartProducts.size();i++)
			{
			    String name= cartProducts.get(i).getText();
				if(name.contains(productName))     //contains(Charsequence seq)  boolean
				{
					Assert.assertTrue(true);
					
				}
			}
		 
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		 
		 Actions a =new Actions(driver);
		 a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform(); 
		 
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]")));
		  
		 driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		 
		 driver.findElement(By.cssSelector(".action__submit")).click();
		 
		 String confirmedMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
		// Assert.assertEquals(confirmedMessage, " Thankyou for the order. ");
		 Assert.assertTrue(confirmedMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));       
		        
		 
	}

}
