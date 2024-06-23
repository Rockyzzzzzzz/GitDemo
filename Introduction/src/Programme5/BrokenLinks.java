package Programme5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks 
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
	    
	    //Step1:- Get all the urls tied up to the links using selenium 
	     String url= driver.findElement(By.xpath("//a[contains(@href,'brokenlink')]")).getAttribute("href");
	     //String url= driver.findElement(By.xpath("//a[text()='Appium']")).getAttribute("href");
	   
	   
	    //Step2:- Java methods will call URL'S and gets you the status code
	   //step3:- If status code>400 then that url is not working---> i.e link which is tied to url is broken
	    HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
	    conn.setRequestMethod("HEAD");
	    conn.connect();
	    int responseCode= conn.getResponseCode();
	    System.out.println(responseCode);
	  
	    
	    

	}

}
