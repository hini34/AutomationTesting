package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.CartPage;
import PageObject.CheckoutPage;
import PageObject.LoginPage;
import PageObject.ProductPage;

public class CheckoutTest extends BaseClass {
	
	@Test(groups = {"Sanity","Regression", "Master"})
	public void verify_checkout() {
		
		logger.info("******* Staring CkeckoutTest *******");
		try {
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
		
		Assert.assertTrue(cp.isProductPresent(p.getProperty("ProductName")),"Product is not present in cart");
		
		cp.clickCheckout();
		
		//Checkout Page
        CheckoutPage ckp = new CheckoutPage(driver);
        
        ckp.enterCustomerDetails(p.getProperty("firstName"),
					             p.getProperty("lastName"),
					             p.getProperty("postalCode"));
        
        ckp.clickContinue();
        
        Assert.assertEquals(
                ckp.getSummaryTitle(),
                "Checkout: Overview",
                "Checkout summary page is not displayed"
        );

        // 11. Finish Order
        ckp.clickFinish();

        // 12. Verify Order Confirmation
        Assert.assertEquals(
                ckp.getConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message is incorrect"
        );
		}catch(Exception e) {
			e.printStackTrace();

	        Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		
		logger.info("******* Finishing CkeckoutTest *******");
        
	}

}
