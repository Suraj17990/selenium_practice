import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {
    public static void main(String[] args) {
        //set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to specific URL
        driver.get("");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("edit-name"))));
        element.sendKeys("");
        driver.close();
    }
}
