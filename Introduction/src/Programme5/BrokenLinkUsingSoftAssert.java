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
import org.testng.asserts.SoftAssert;

public class BrokenLinkUsingSoftAssert 
{

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    //driver.get("http://www.deadlinkcity.com/");
	    
		//Broken link is nothing but broken url
	    //Step1:- Get all the urls tied up to the links using selenium
	    //Step2:- Java methods will call URL'S and gets you the status code
	    //step3:- If status code>400 then that url is not working---> i.e link which is tied to url is broken
	    
	    //write common xpath to get all the links
	     List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
	     SoftAssert a= new  SoftAssert();
	     
	   /*  for(WebElement link:links)
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
	 	    
	 	    	a.assertTrue(false);      //after failing/getting the broken link the script will not stop it continues with all the links and validates them
	 	   
	 	    }
	 	    
	 	    
	 	   }

               a.assertAll();*/
	     for(WebElement link:links)
	     {
	    	 String url=link.getAttribute("href");

	 	    HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
	 	    conn.setRequestMethod("HEAD");
	 	    conn.connect();
	 	    int responseCode= conn.getResponseCode();
	 	    System.out.println(responseCode);
	 	    a.assertTrue(responseCode<400,"The link with text "+link.getText()+" is broken with code "+responseCode);
	 	   
	 	   }

               a.assertAll();
	     
	}

}
