import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserAction3 {
    public static void main(String[] args) throws InterruptedException {
        //set the driver path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        //maximize the browser
        driver.manage().window().maximize();
        //give implicit timeout
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //navigate to specific URL
        driver.get("https://www.ultimateqa.com/automation/");
        //click on hyperlink
        driver.findElement(By.linkText("Automation Exercises")).click();
        //click on hyperlink
        driver.findElement(By.linkText("Interactions with simple elements")).click();
        //locate text field and enter some value
        driver.findElement(By.xpath("//input[starts-with(@id,'et_pb_contact_name')]")).sendKeys("Suraj");
        //click on radio button
        driver.findElement(By.xpath("//input[@value='male']")).click();

        List<WebElement> genderList = driver.findElements(By.name("gender"));

        if (genderList.size() == 3)
            System.out.println("Test case Pass");
        else System.out.println("Failed");

        Thread.sleep(2000);
        driver.close();
    }
}
