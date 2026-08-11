package PageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
 
	// constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    
    //Locators
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;
    
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;
    
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    
    @FindBy(className = "inventory_item_name")
    List<WebElement> cartItemNames;
    
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;
    
    @FindBy(className = "inventory_item_name")
    WebElement productName;
    
    
    //Actions
    public void clickCart() {
    	cartIcon.click();
    }
    
 // Get number of cart items
    public int getCartItemCount() {
        return cartItems.size();
    }
    
   // Check product exists in cart

    public boolean isProductPresent(String productName) {

        for (WebElement item : cartItems) {

            WebElement itemName =
                    item.findElement(
                            org.openqa.selenium.By.className("inventory_item_name"));

            if (itemName.getText().equals(productName)) {
                return true;
            }
        }

        return false;
    }
    
   // Remove product from cart
    
    public void removeProduct(String productName) {

        for (WebElement item : cartItems) {

            WebElement itemName =
                    item.findElement(
                            org.openqa.selenium.By.className("inventory_item_name"));

            if (itemName.getText().equals(productName)) {

                WebElement removeButton =
                        item.findElement(
                                org.openqa.selenium.By.cssSelector("button[id*='remove']"));

                removeButton.click();

                break;
            }
        }
    }


    // Click checkout

    public void clickCheckout() {
        checkoutButton.click();
    } 
    
    public void clickContinueShopping() {
    	continueShoppingBtn.click();
    }
    

    // getting product name 
    public String getProductName() {
        return productName.getText();
    }
}
