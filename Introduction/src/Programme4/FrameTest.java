package Programme4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) 
	{

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//to know how many no of frames
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//switch to iframe using index
		//driver.switchTo().frame(0);
		//System.out.println(driver.findElement(By.id("draggable")).isDisplayed());
		
		
		//switch to iframe using webelement
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		System.out.println(driver.findElement(By.id("draggable")).isDisplayed());
		
		Actions a =new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//to come out of frame
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Accept']")).click();		

	}

}
