package rahulshettyacademy.tests;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
public class ErrorValidationsTest extends  BaseTest
{
	@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void loginErrorValidations() throws IOException 
	{
		String productName= "ZARA COAT 3";
		landingPage.loginApplication("rakeshvijayh33@gmail.com", "Rakesh@");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect emaili or password.");
		
	}
    
    
   
    
    
    
 @Test
public void productErrorValidations() throws IOException 
{
	String productName= "ZARA COAT 3";
	ProductCatalogue productCatalogue=landingPage.loginApplication("deepikavijayh33@gmail.com", "Deepika@94");
	
	//ProductCatalogue productCatalogue= new ProductCatalogue(driver);
	List<WebElement> products= productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage=productCatalogue.goToCartPage();
	
	//CartPage cartPage=new CartPage(driver);
	boolean match=cartPage.verifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);

}
 
}

