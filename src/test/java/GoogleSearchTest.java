import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Sử dụng WebDriverManager để thiết lập trình điều khiển Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        // Tìm hộp tìm kiếm bằng thuộc tính name
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Chờ tiêu đề của trang thay đổi
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Kiểm tra tiêu đề của trang kết quả tìm kiếm
        String title = driver.getTitle();
        assertTrue("Title should start with 'Selenium WebDriver - Google Search'", title.startsWith("Selenium WebDriver"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
