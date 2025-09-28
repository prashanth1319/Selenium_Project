package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExcelUtils;

import java.time.Duration;

public class LoginPage {


    private WebDriver driver;

    private By userNameField = By.id("user-name");
    private By password = By.id("password");
    private By loginCTA = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public  void enterUserName(String userName){

        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(userName);

    }
    public  void enterPassword(String Password){

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(Password);
    }
    public  void clickLoginButton()throws  Exception{

        driver.findElement(loginCTA).click();
        Thread.sleep(2000);
//        Alert clickAlert = driver.switchTo().alert();
//        System.out.println(clickAlert.getText());
//        Thread.sleep(2000);
//        clickAlert.accept();
//        Thread.sleep(2000);

    }
}