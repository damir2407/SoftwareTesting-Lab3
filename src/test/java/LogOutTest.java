import org.example.Util;
import org.junit.BeforeClass;
import org.junit.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.*;

public class LogOutTest {
    private final long timeout = 2;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeClass
    public static void init() {
        Util.prepareDrivers();
    }

    @Test
    public void logOutTest() throws IOException, InterruptedException {
        List<WebDriver> drivers = Util.getDrivers();
        for (WebDriver driver : drivers) {
            js = (JavascriptExecutor) driver;
            vars = new HashMap<>();
            driver.get("https://simpleswap.io/");
            driver.manage().window().setSize(new Dimension(1536, 826));
            Util.login(driver);
            Util.waitTime(timeout);
            {
                List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[2]/div[2]/div[2]"));
                assert (elements.size() > 0);
            }
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[2]/div[2]/div[2]/div[2]")).click();
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[2]/div[2]/div[2]/div[4]/button")).click();
            Util.waitTime(timeout);
            {
                List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div[2]/div[2]/div[2]"));
                assert (elements.size() == 0);
            }
            driver.quit();
        }
    }
}
