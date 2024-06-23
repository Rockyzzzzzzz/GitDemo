package Ysecit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HRMS 
{

	public static void main(String[] args) throws InterruptedException 
	{
		String date="15";
		String monthNumber="June";
		String year="2025";
		String expectedList[]= {date,monthNumber,year}; //for validating using assertion
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hr.ysecit.in/#/login");
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys("1384");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Rakesh@94");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Leave Application Details')]")).click();
		driver.findElement(By.xpath("(//a[@class='ng-binding'] [text()='Apply Leaves'])[1]")).click();
		Thread.sleep(3000);
		WebElement w= driver.findElement(By.xpath("//select[@id='leavetype']"));
		
		Select s=new Select(w);
		s.selectByVisibleText("Casual Leave");
		
		/*//to write directly in one step
	    //driver.findElement(By.name("fromDate")).sendKeys("03-April-2024");
		
		//to print the date month year and validate using assertion
		WebElement w1= driver.findElement(By.name("fromDate"));
		w1.sendKeys("03-April-2024");
		String s1=w1.getAttribute("value");
		System.out.println(s1);
		Assert.assertEquals(s1, "03-April-2024");*/
		
		
		driver.findElement(By.name("fromDate")).click();
		
		driver.findElement(By.xpath("//span[@class='PPP'][2]")).click();
		
		if(Integer.parseInt(year)<2024)
		{
		
		   driver.findElement(By.xpath("//div[@class='PPP'][1]")).click();
		}
		
		driver.findElement(By.xpath("//li[text()='"+year+"']")).click();
		
		driver.findElement(By.xpath("//span[@class='PPP'][1]")).click();
		
		driver.findElement(By.xpath("//li[text()='"+monthNumber+"']")).click();
		
		driver.findElement(By.xpath("//li[text()='"+date+"']")).click();
		
		System.out.println(driver.findElement(By.name("fromDate")).getAttribute("value"));
		
		String actualvalue=driver.findElement(By.name("fromDate")).getAttribute("value");
		
		Assert.assertEquals(actualvalue, expectedList[0]+"-"+expectedList[1].substring(0, 3)+"-"+expectedList[2]);

	}

}
