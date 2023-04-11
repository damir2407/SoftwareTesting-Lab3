

import org.example.Util;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;


import java.io.IOException;
import java.util.*;


public class MobileSignInTest {
    private Map<String, Object> vars;
    private JavascriptExecutor js;
    private final long timeout = 2;

    @BeforeClass
    public static void init() {
        Util.prepareDrivers();
    }

    @Test
    public void mobileSignInTest() throws IOException, InterruptedException {
        List<WebDriver> drivers = Util.getDrivers();
        for (WebDriver driver : drivers) {
            js = (JavascriptExecutor) driver;
            vars = new HashMap<>();

            driver.get("https://simpleswap.io/");
            driver.manage().window().setSize(new Dimension(393, 851));
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[3]/div")).click();
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[4]/div/div[7]/a[2]")).click();
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/div[5]/div/div/div[2]/input")).sendKeys("ivandolgihcapt@gmail.com");
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/div[7]/div/div/div[2]/input")).sendKeys("Itmotpotest1");
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/button")).click();
            Util.waitTime(timeout);

            vars.put("pageurl", js.executeScript("return window.location.href;"));
            assertEquals(vars.get("pageurl").toString(), "https://simpleswap.io/customer-account/overview");
            driver.quit();
        }

    }
}
