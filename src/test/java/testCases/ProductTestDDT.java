package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.ProductPage;
import utilities.DataProviders;

public class ProductTestDDT extends BaseClass{
	
	@Test(dataProvider = "ProductData", dataProviderClass = DataProviders.class, groups = {"Regression", "Master"})
	public void verify_products( String product1,String product2, String product3, String product4) {
		
		logger.info("******* Staring ProductDDTTest *******");
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(p.getProperty("username"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		// ProductPage
        ProductPage pdp = new ProductPage(driver);
        
     // Verify Page Title
        Assert.assertEquals(
                pdp.getPageTitle(),
                "Products",
                "Products page title is incorrect"
        );

        // Verify Product Count
        Assert.assertEquals(
                pdp.getProductCount(),
                6,
                "Product count is incorrect"
        );

        // Sort Price Low to High
        pdp.sortProducts("lohi");

        // Multiple Products
        String[] products = { product1, product2, product3, product4};

        // Add Products to Cart
        for (String product : products) {

            pdp.addProductToCart(product);
        }

        // Click Cart
        pdp.clickCart();

        // CartPage
        CartPage cp = new CartPage(driver);

        // Verify Products
        for (String product : products) {

            Assert.assertTrue(
                    cp.isProductPresent(product),
                    product + " was not added to cart"
            );
        }
        
        logger.info("******* Finishing ProductDDTTest *******");
    }
	

}
