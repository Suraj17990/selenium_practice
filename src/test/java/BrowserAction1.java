import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAction1 {
    public static void main(String[] args) {
        //set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        //navigate to specific URL
        driver.get("https://www.ultimateqa.com/automation/");
        System.out.println("Current URL :"+driver.getCurrentUrl());
        System.out.println("Title:"+driver.getTitle());
        System.out.println("Page Source ");
        System.out.println(driver.getPageSource());
        driver.findElement(By.linkText("Automation Exercises")).click();
        driver.close();
    }
}
