package Programme2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
	    driver.findElement(By.xpath("//a[@value='BLR']")).click();
	    Thread.sleep(2000);
	    
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	    //to avoid indexes we use below parent child relationship xpath
	    driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	    
	    //select the current date in calender
	    driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
	    
	    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	 
	    //validate return date is enabled after selecting radio button
	    System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()); 
	  //output should be false but displaying true bcz on disable mode the return date is allowing user click manually to enable
	    
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // select round trip
	   // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
	    
	    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
	    
	    //as the above approach for isenabled is not working and return false we can use below approach 
	    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	    
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("isenabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

	}

	}


