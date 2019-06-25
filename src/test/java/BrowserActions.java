import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BrowserActions {
    public static void main(String[] args) throws InterruptedException {
        //set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //navigate to specific URL
        driver.get("");
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='nav__link nav__link--2' and text()='Get a quote']"))).build().perform();
        driver.findElement(By.xpath("//a[@class='nav__link nav__link--3' and text()='Tariff rates']")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
