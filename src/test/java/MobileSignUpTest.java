
import org.example.Util;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import java.io.IOException;
import java.util.*;

public class MobileSignUpTest {

    private final long timeout = 2;

    @BeforeClass
    public static void init() {
        Util.prepareDrivers();
    }

    @Test
    public void mobileSignUpTest() throws IOException, InterruptedException {
        List<WebDriver> drivers = Util.getDrivers();
        for (WebDriver driver : drivers) {
            driver.get("https://simpleswap.io/");
            driver.manage().window().setSize(new Dimension(393, 851));
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[3]/div/div[3]")).click();
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'__next\']/div/header/div/div/div[4]/div/div[7]/a")).click();
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/div[5]/div/div/div[2]/input")).sendKeys("ivandolgihcapt@gmail.com");
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/div[7]/div/div/div[2]/input")).sendKeys("Itmotpotest1");
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/div[10]/label/span")).click();
            Util.waitTime(timeout);
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/div[10]/label[2]/span")).click();
            driver.findElement(By.xpath("//div[@id=\'root\']/div/div/div/div/div/form/div/button")).click();
            Util.waitTime(timeout);
            assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/form/div/div[5]/div[2]/div")).getText(), "Email is already registered");
            driver.quit();
        }

    }
}
