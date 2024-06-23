package Programme5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorScrolling 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
		//By selenium will not provide any scrolling techniques so we have to execute javascript as all the browsers is made on java script
		//Now casting the javascript to driver so tht driver is aware and go and execute javascript
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//javascript to scroll
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		//css loacator in javascript to locate table and scroll
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		
		//Get the 4th column values and make a sum of 296
		//List<WebElement> values=driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));
		List<WebElement> values=driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			   //String s=values.get(i).getText();
			  // int i1=Integer.parseInt(s);
			  //System.out.println(i);
			   // System.out.println(Integer.parseInt(values.get(i).getText()));
			sum=sum+Integer.parseInt(values.get(i).getText());
		}
		    System.out.println(sum);
		    
		    //to get expected 296 displayed value from page for validation
		    int total=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		 
		  Assert.assertEquals(sum, total);

	}

}
