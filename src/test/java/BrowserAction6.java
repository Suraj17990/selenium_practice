import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserAction6 {
    public static void main(String[] args) throws InterruptedException {
        //set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        //maximize the browser
        driver.manage().window().maximize();
        //give implicit timeout
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //navigate to URL
        driver.get("");
        //open a new tab
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

        ((JavascriptExecutor)driver).executeScript("window.open()");

        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        Thread.sleep(3000);
        //driver.close();
        driver.quit();
    }
}
