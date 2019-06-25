package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        //set the driver path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void test(){
        //navigate to specific URL
        driver.get("");
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //locate the element
        WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("edit-name"))));
        //enter the username
        userNameField.sendKeys("");
        //click on next button
        driver.findElement(By.id("edit-submit--2")).click();
        //enter password
        WebElement passwordField = driver.findElement(By.name("customer_pwd"));
        passwordField.sendKeys("");
        //click on login button
        driver.findElement(By.id("customer_login")).click();
        //wait for some element to be displayed
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Get energy healthy")));
        //get title
        String title = driver.getTitle();
        //verify title
        Assert.assertTrue(title.equalsIgnoreCase(""),"Title does not match");
    }

    @Test
    public void verifyChangeTraiff(){
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement changeTariifLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=\"menu clearfix\"] li:nth-child(3)")));
        changeTariifLink.click();
        WebElement yourTariffs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='Your tariffs']")));
        Assert.assertEquals("Your tariffs",yourTariffs.getText());
    }
}
