import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test7 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
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
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm edit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='product_price']")).clear();
        driver.findElement(By.xpath("//input[@name='product_price']")).sendKeys("30000.0");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='product_color']")).sendKeys("Violet");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='product_size']")).sendKeys("XL");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='product_quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='product_quantity']")).sendKeys("50");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='product_img']")).sendKeys("W:\\FPT University\\5-Summer24\\SWT301\\lab3\\Shop\\src\\main\\webapp\\images\\A1.png");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-save']")).click();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
