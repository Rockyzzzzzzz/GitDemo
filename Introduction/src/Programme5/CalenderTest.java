package Programme5;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest 
{

	public static void main(String[] args) 
	{
		String monthNumber="6";
		String date="15";
		String year="2027";
		String expectedList[]= {monthNumber,date,year}; //for validating using assertion

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
        driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();	
        
        //select the year
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        
        //Select month ....write common xpath for all the elements and then traverse to required month through index using get method
        driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(monthNumber)-1).click();
         //driver.findElement(By.xpath("//abbr[text()='"+monthNumber+"']")).click();  if took  String monthNumber="June";
         
        //select the date
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        
        //System.out.println(driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).getText()); 
       //fails to print as their is no text directly
        
        //Now write a common locator tht matches for month, date and year
        List<WebElement> actualList = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
        
        for(int i=0;i<actualList.size();i++)
        {
        	System.out.println(actualList.get(i).getAttribute("value")); 
        	Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
        //driver.close();
      
        //using cursors
       /* Iterator it=actualList.iterator();
        int i=0;
        while(it.hasNext())
        {
        	WebElement w=(WebElement) it.next();
        	System.out.println(w.getAttribute("value"));
        	if(w.getAttribute("value").equals(expectedList[i]))
        	{
        		Assert.assertTrue(true);
        		i++;
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}*/
        }
	}


