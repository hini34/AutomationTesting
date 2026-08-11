package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.ProductPage;

public class ProductTest extends BaseClass{
	
	@Test(groups = {"Smoke","Regression", "Master"})
	public void verify_product() {
		
		logger.info("******* Staring ProductTest *******");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(p.getProperty("username"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//ProductPage
		ProductPage pdp = new ProductPage(driver);
		
		
		
		 // Verify Page Title	
		 Assert.assertEquals(pdp.getPageTitle(),"Products","Products page title is incorrect");
		 
		 // Verify product count
		 Assert.assertEquals(pdp.getProductCount(), 6, "Product count is incorrect");
		 
		 // Price low to high
		 pdp.sortProducts("lohi");
		 
		 //Adding Product to cart
		 pdp.addProductToCart(p.getProperty("ProductName"));
		 
		 pdp.clickCart();
		 
		 // CartPage
		 CartPage cp = new CartPage(driver);
		 
		 Assert.assertEquals(
		            cp.getProductName(),p.getProperty("ProductName"),"Product was not added to cart");
		 
//		 String productName = "Sauce Labs Backpack";
//
//		 pdp.addProductToCart(productName);
//
//		 CartPage cp = new CartPage(driver);
//
//		 cp.clickCart();
//
//		 Assert.assertTrue(
//		         cp.isProductPresent(productName),
//		         "Product was not added to cart"
//		 );
		 
		 logger.info("******* Finishing LoginTest *******");
	}

}
