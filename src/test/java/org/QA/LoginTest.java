package org.QA;

import org.Base_Setup.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.PropertiesUtils;
import utils.ScreenshotUtils;

import java.time.Duration;

public class LoginTest extends Base {

    @Test
    public void testValidLogin() throws Exception{

        String filePath = "src/main/resources/testData.properties";

        //Read from properties
        String username = PropertiesUtils.getProperty(filePath,"username");
        String password = PropertiesUtils.getProperty(filePath, "password");
        String firstName = PropertiesUtils.getProperty(filePath, "firstName");
        String lastName = PropertiesUtils.getProperty(filePath, "lastName");
        String zip = PropertiesUtils.getProperty(filePath, "zip");

        LoginPage login = new LoginPage(driver);
        AddToCartPage cart = new AddToCartPage(driver);
        CheckOutPage checkout = new CheckOutPage(driver);

        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        //Accept Alert
//        String alertMessage = handleAlertIfPresent();
//        System.out.println("Captured alert message: " + alertMessage);

        //Validate URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl, "URL validation failed!");
        // Validate Title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle, "Title validation failed");


        // Add cart
        cart.ClickOnCart();
        cart.clickAddCart();
        cart.clickOnCheckout();

        // Checkout
        checkout.fillDetails(firstName,lastName,zip);
        checkout.clickOnContinueCTA();
        ScreenshotUtils.capture(driver, "Order-Details");
        checkout.clickOnFinishButton();
        checkout.verifyCompletePage("Thank you for your order!");


    }
}
