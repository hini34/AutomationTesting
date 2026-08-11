package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{

 

    // Constructor
    public ProductPage(WebDriver driver) {
       super(driver);
    }

    // Locators

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "inventory_item")
    List<WebElement> products;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;
    
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;


    // Get page title
    public String getPageTitle() {
        return pageTitle.getText();
    }


    // Get number of products
    public int getProductCount() {
        return products.size();
    }


    // Get all product names
    public List<WebElement> getProductNames() {
        return productNames;
    }


    // Get all product prices
    public List<WebElement> getProductPrices() {
        return productPrices;
    }


    // Sort products
    public void sortProducts(String option) {

        Select select = new Select(sortDropdown);
        select.selectByValue(option);
    }


    // Add product to cart by product name
    public void addProductToCart(String productName) {

        for (WebElement product : products) {

            WebElement name = product.findElement(
                    org.openqa.selenium.By.className("inventory_item_name"));

            if (name.getText().equals(productName)) {

                WebElement addToCartButton = product.findElement(
                        org.openqa.selenium.By.tagName("button"));

                addToCartButton.click();

                break;
            }
        }
    }
    
    public void clickCart() {
        cartIcon.click();
    }
}