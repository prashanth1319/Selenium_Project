package org.QA;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.Base_Setup.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import utils.CSVUtils;
import utils.ExtentManager;
import utils.PropertiesUtils;
import utils.ScreenshotUtils;

import java.util.List;

public class CsvLoginTest extends Base {

    @Test
    public void testValidLogincsv() throws Exception{
        ExtentReports extent = ExtentManager.getReporter();
        ExtentTest test = extent.createTest("Valid Login Test csv");

        test.info("Starting test");
        test.pass("Login successful");
        extent.flush();  // generates the report

        // Robust - No Hardcoded Path
        String filePath = getClass().getClassLoader().getResource("testData.csv").getPath();
        List<String[]> csvData = CSVUtils.readCSV(filePath);

        for(String[] row: csvData) {
            String username = row[0];
            String password = row[1];
            String firstName = row[2];
            String lastName = row[3];
            String zip = row[4];


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

            // Checkout page
            checkout.fillDetails(firstName, lastName, zip);
            checkout.clickOnContinueCTA();
            ScreenshotUtils.capture(driver, "Order-Details");
            checkout.clickOnFinishButton();
            checkout.verifyCompletePage("Thank you for your order!");
        }

    }
}
