package LatestFeatures;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWindow 
{

	public static void main(String[] args) throws IOException 
	{
		    WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			
			//opens new blank tab
			//driver.switchTo().newWindow(WindowType.TAB);
			driver.switchTo().newWindow(WindowType.WINDOW);
			
			Set<String> windowIDs= driver.getWindowHandles();
			Iterator<String> it= windowIDs.iterator();
			String parentWindowId= it.next();
			String childWindowId= it.next();
			
			driver.switchTo().window(childWindowId);
			driver.get("https://rahulshettyacademy.com/");
			
			//driver.findElement(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
			//List<WebElement> allCourses =driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]"));
			//String coarseName= allCourses.get(1).getText();
			String coarseName=driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();;
			driver.switchTo().window(parentWindowId);
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(coarseName);
			
			
			//Webelement screen shot using selenium
			WebElement name= driver.findElement(By.xpath("//input[@name='name']"));
			   File file =name.getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(file, new File("logo.png"));
			   
			   
			   
		    //Get Height and Width	   
			   System.out.println(name.getRect().getDimension().getHeight());
			   System.out.println(name.getRect().getDimension().getWidth());
			   
	}		   
	
	
	

}
