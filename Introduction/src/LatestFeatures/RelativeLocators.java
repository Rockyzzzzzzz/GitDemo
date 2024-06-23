package LatestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) 
	{
		    WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			
			//Above
			WebElement nameEditBox = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
			System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
			//System.out.println(driver.findElement(By.xpath("//label[text()='Name']")).getText());  //other way using xpath directly
			
			//Below
			WebElement dateOfBirth =driver.findElement(By.xpath("//label[@for='dateofBirth']"));
			//driver.findElement(with(By.tagName("input")).below(dateOfBirth)).sendKeys("09/22/2024");   its flex web element and relative locators didnt support so its not identifying
			//driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("09/09/2024"); //other way using xpath directly
			driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
			
			//Left
			WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
			driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
			
			//Right
			WebElement radioButton =driver.findElement(By.id("inlineRadio1"));
			System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
			
	}

}
