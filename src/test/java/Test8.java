import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test8 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/shop/user?action=login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='user_email']")).sendKeys("Admin@gmail.com");
        driver.findElement(By.xpath("//input[@name='user_pass']")).sendKeys("Admin1");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='btnlogin']")).click();
        Thread.sleep(1000);
        driver.get("http://localhost:8080/shop/dashboard");
        Thread.sleep(2000);
        driver.get("http://localhost:8080/shop/productmanager");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm trash']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
