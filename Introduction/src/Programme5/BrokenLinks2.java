package Programme5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class BrokenLinks2 
{

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    
		//Broken link is nothing but broken url
	    //Step1:- Get all the urls tied up to the links using selenium
	    //Step2:- Java methods will call URL'S and gets you the status code
	    //step3:- If status code>400 then that url is not working---> i.e link which is tied to url is broken
	    
	    //write common xpath to get all the links
	     List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
	     for(WebElement link:links)
	     {
	    	 String url=link.getAttribute("href");

	 	    HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
	 	    conn.setRequestMethod("HEAD");
	 	    conn.connect();
	 	    int responseCode= conn.getResponseCode();
	 	    System.out.println(responseCode);
	 	    if(responseCode>400)                         
	 	    {
	 	    	System.out.println("The link with text "+link.getText()+" is broken with code "+responseCode);
	 	    
	 	    	Assert.assertTrue(false);   
	 	    //In this programme by validating through hard assertion after getting the broken link appium the script fails to check remaining links so to achieve this we go for soft assertion
	 	    }
	 	    
	 	   
	 	    }

	     }
	   
	   
	}


