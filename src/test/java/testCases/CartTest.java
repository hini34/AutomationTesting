package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.ProductPage;

public class CartTest extends BaseClass{

	@Test(groups = {"Sanity","Regression", "Master"})
	public void verify_cartItem() {
		
		logger.info("******* Staring CartTest *******");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(p.getProperty("username"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//ProductPage
		ProductPage pdp = new ProductPage(driver);
		pdp.addProductToCart(p.getProperty("ProductName"));
		
		//CartPage
		CartPage cp = new CartPage(driver);
		cp.clickCart();
		
		
		// Verify cart item count
        Assert.assertEquals(cp.getCartItemCount(),1,"Cart should contain one product");
        
        // Verify product
        Assert.assertTrue(cp.isProductPresent(p.getProperty("ProductName")), "Product is not present in cart");
        
        // Remove product
        cp.removeProduct(p.getProperty("ProductName"));

        // Verify cart is empty
        Assert.assertEquals(cp.getCartItemCount(),0, "Product was not removed from cart");
        
       // Continue Shopping only when cart is empty
        if (cp.getCartItemCount() == 0) {
            cp.clickContinueShopping();
        }
        
        logger.info("******* Finishing CartTest *******");
        
        
	}
}
