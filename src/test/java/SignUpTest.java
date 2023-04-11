import org.example.Util;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.*;


public class SignUpTest {
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private final long timeout = 2;

    @BeforeClass
    public static void init() {
        Util.prepareDrivers();
    }

    @Test
    public void signUpTest() throws IOException, InterruptedException {
        List<WebDriver> drivers = Util.getDrivers();
        for (WebDriver driver : drivers) {
            js = (JavascriptExecutor) driver;
            vars = new HashMap<>();

            driver.get("https://simpleswap.io/");

            driver.manage().window().setSize(new Dimension(1536, 826));
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[2]/div[2]/a[2]/div")).click();
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[5]/div/div/div[2]/input")).click();
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[5]/div/div/div[2]/input")).sendKeys("dbaltabaev8708@gmail.com");
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[7]/div/div/div[2]/input")).click();
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[7]/div/div/div[2]/input")).sendKeys("Fhashshs1");
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[10]/label[2]/span")).click();
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[10]/label/span")).click();
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/button")).click();
            Util.waitTime(timeout);
            assertThat(driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div[2]/div/form/div/div[5]/div[2]/div")).getText(), is("Email is already registered"));
            driver.quit();
        }
    }

}
