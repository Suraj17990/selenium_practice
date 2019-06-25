import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TableTest {
    public static void main(String[] args) {
        try{
            System.out.println("in try");
        }finally {
            System.out.println("Hello");
        }
        //set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        //maximize browser window
        driver.manage().window().maximize();
        //navigate to specific URL
        driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
        //locate table
        WebElement table = driver.findElement(By.id("htmlTableId"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement element:rows) {
            List<WebElement> cols = element.findElements(By.xpath("td"));
            for (WebElement element1:cols) {
                System.out.println(element1.getText());
            }
        }
        driver.close();
    }
}
