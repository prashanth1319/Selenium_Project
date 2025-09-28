package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddToCartPage {

    private WebDriver driver;

    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private By addcart = By.xpath("//button[text()='Add to cart']");

    private By cart = By.xpath("//a[@class='shopping_cart_link']");
    private By checkOut = By.xpath("//button[@name='checkout']");
    //private By checkOut = By.id("checkout");


    public void clickAddCart() {
        List<WebElement> elements = driver.findElements(addcart);
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    }

    public void ClickOnCart(){
        driver.findElement(cart).isDisplayed();
        driver.findElement(cart).click();
    }

    public void clickOnCheckout(){
        driver.findElement(checkOut).isDisplayed();
        driver.findElement(checkOut).click();
    }

}


