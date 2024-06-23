package rahulshettyacademy.tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutpage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends  BaseTest
{
	String productName= "ZARA COAT 3";
	
    @Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException 
	{
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
		
		//ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		List<WebElement> products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage=productCatalogue.goToCartPage();
		
		//CartPage cartPage=new CartPage(driver);
		boolean match=cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutpage checkOutPage=cartPage.goToCheckOut();
		checkOutPage.selectCountry("india");
		ConfirmationPage confirmationMessage=checkOutPage.submitOrder();
		String confirmedMessage=confirmationMessage.getConfirmationMessage();
		Assert.assertTrue(confirmedMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); 
		
		System.out.println("SubmitOrderTest");
		
	}
    
    @Test(dependsOnMethods= {"submitOrder"})
   	public void OrderTestHistory()
   	{
   		 
    	ProductCatalogue productCatalogue=landingPage.loginApplication("rakeshvijayh33@gmail.com", "Rakesh@94");
    	OrderPage orderPage=productCatalogue.goToOrdersPage();
    	Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    	System.out.println("OrderTestHistory");
    	
   	}
    
    
   /* @DataProvider
	public Object[][] getData()
	{
		//return new Object[][] {{"rakeshvijayh33@gmail.com","Rakesh@94","ZARA COAT 3"},{"deepikavijayh33@gmail.com","Deepika@94","ADIDAS ORIGINAL"}};
    	Object[][] data= {{"rakeshvijayh33@gmail.com","Rakesh@94","ZARA COAT 3"},{"deepikavijayh33@gmail.com","Deepika@94","ADIDAS ORIGINAL"}};
    	return data;
    	
	}*/
    
    @DataProvider
    public Object[][] getData() throws IOException
    {
    	/* HashMap<String, String> map= new   HashMap<String, String>();
    	 map.put("email", "rakeshvijayh33@gmail.com");
    	 map.put("password", "Rakesh@94");
    	 map.put("productName", "ZARA COAT 3");
    	 
    	 HashMap<String, String> map1= new   HashMap<String, String>();
    	 map1.put("email", "deepikavijayh33@gmail.com");
    	 map1.put("password", "Deepika@94");
    	 map1.put("productName","ADIDAS ORIGINAL");
    	 
   	    // return new Object[][] {{map},{map1}};
   	    Object[][] data={{map},{map1}};
   	    return data;*/
    	
    	List<HashMap<String, String>> data = getJasonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
    	//return new Object[][] {{data.get(0)},{data.get(1)}};
    	Object[][] data1={{data.get(0)},{data.get(1)}};
    	return data1;
    	
    }
    
    
    
    

}



/* public class SubmitOrderTest extends  BaseTest
 {
	String productName= "ZARA COAT 3";
	
    @Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(String email, String password, String productName) throws IOException 
	{
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(email, password);
		
		//ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		List<WebElement> products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();
		
		//CartPage cartPage=new CartPage(driver);
		boolean match=cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutpage checkOutPage=cartPage.goToCheckOut();
		checkOutPage.selectCountry("india");
		ConfirmationPage confirmationMessage=checkOutPage.submitOrder();
		String confirmedMessage=confirmationMessage.getConfirmationMessage();
		Assert.assertTrue(confirmedMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); 
		
	}
    
    @Test(dependsOnMethods= {"submitOrder"})
   	public void OrderTestHistory()
   	{
   		 
    	ProductCatalogue productCatalogue=landingPage.loginApplication("rakeshvijayh33@gmail.com", "Rakesh@94");
    	OrderPage orderPage=productCatalogue.goToOrdersPage();
    	Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    	System.out.println("1");
    	
   	}
    
    
    @DataProvider
	public Object[][] getData()
	{
		//return new Object[][] {{"rakeshvijayh33@gmail.com","Rakesh@94","ZARA COAT 3"},{"deepikavijayh33@gmail.com","Deepika@94","ADIDAS ORIGINAL"}};
    	Object[][] data= {{"rakeshvijayh33@gmail.com","Rakesh@94","ZARA COAT 3"},{"deepikavijayh33@gmail.com","Deepika@94","ADIDAS ORIGINAL"}};
    	return data;
    	
	}
    
    
    

}*/
