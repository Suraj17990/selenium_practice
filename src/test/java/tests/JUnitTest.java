package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest {
    WebDriver driver;
    @Before
    public void beforeTest(){
        //set the driver path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //create the driver instance
         driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test(){

    }

    @After
    public void afterTest(){
        driver.close();
    }
}
