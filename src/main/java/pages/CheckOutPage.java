package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutPage {

    private WebDriver driver;

    public  CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueCTA = By.id("continue");
    private By finishCTA = By.id("finish");

    public void fillDetails(String Firstname, String LastName, String ZipCode){

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(Firstname);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(LastName);

        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(ZipCode);

    }

    public void clickOnContinueCTA(){
        driver.findElement(continueCTA).submit();
    }

    public void clickOnFinishButton(){
        driver.findElement(finishCTA).click();
    }

    public void verifyCompletePage(String expected){

        String actualText = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        Assert.assertEquals(actualText, expected, "complete order verification fail");

    }
}
