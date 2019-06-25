import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DriverCommandsExample {
    public static void main(String[] args) throws InterruptedException {
        //set the driver path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Launch Website
        driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
        // Fetch the text "This is sample text." and print it on console
        // Use the class name of the div to locate it and then fetch text using getText() method
        String sampleText = driver.findElement(By.className("col-md-12")).getText();
        System.out.println(sampleText);
        // Use the linkText locator method to find the link and perform click using click() method
        driver.findElement(By.linkText("This is a link")).click();
        //come back to original URL
        driver.navigate().back();
        // Click on the textbox and send value
        driver.findElement(By.id("fname")).sendKeys("JavaTpoint");
        // Clear the text written in the textbox
        driver.findElement(By.id("fname")).clear();
        // Click on the Submit button using click() command
        driver.findElement(By.id("idOfButton")).click();
        // Locate the radio button by id and check it using click() function
        driver.findElement(By.id("male")).click();
        // Locate the checkbox by cssSelector and check it using click() function
        driver.findElement(By.cssSelector("input.Automation")).click();
        // Use Select class for selecting value from dropdown
        Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
        dropdown.selectByVisibleText("Automation Testing");
        Thread.sleep(2000);
        //scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 4500)");
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("sourceImage"))).moveToElement(driver.findElement(By.id("targetDiv"))).release().build().perform();
        Thread.sleep(2000);
        js.executeScript("scrollBy(0, -1000)");
        Thread.sleep(2000);
        // Close the Browser
        driver.close();
    }
}
