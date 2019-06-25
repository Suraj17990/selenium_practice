import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyAccountLogin {
    public static void main(String[] args) throws InterruptedException {
        //set the driver path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        driver.findElement(By.id("customer_login")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Get energy healthy")));
        List<WebElement> list = driver.findElements(By.linkText("Add or change a payment card"));
        try {
            list.get(0).click();
        } catch (Exception ex) {
            ex.printStackTrace();
            list.get(1).click();
        }
        driver.findElement(By.cssSelector("input[value=\"Add a new card\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("txt_CardNumber"))));
        driver.findElement(By.name("txt_CardNumber")).sendKeys("12324 4567 5678 6789");
        Thread.sleep(5000);
        driver.close();
    }
}
