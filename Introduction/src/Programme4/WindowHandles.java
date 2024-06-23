package Programme4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) 
	{
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//body/a[@class='blinkingText']")).click();
		 
		//get the child id to switch
		Set<String>windowids=driver.getWindowHandles();  //[parent id, child id]
		Iterator<String> it=windowids.iterator();
		String parentid=it.next();
		String childid=it.next();
		
		//switch to child window
		driver.switchTo().window(childid);
		
		System.out.println(driver.findElement(By.cssSelector("div p.im-para.red")).getText());
		//String s[]=driver.findElement(By.cssSelector("div p.im-para.red")).getText().split(" ");
		      // System.out.println(s[4]);     //mentor@rahulshettyacademy.com
		//String emailid= driver.findElement(By.cssSelector("div p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		String emailid=driver.findElement(By.cssSelector("div p.im-para.red")).getText().split(" ")[4]; //mentor@rahulshettyacademy.com
		
		//switch to parent window
	    driver.switchTo().window(parentid);
				
		
		driver.findElement(By.id("username")).sendKeys(emailid);
		
	}

}
