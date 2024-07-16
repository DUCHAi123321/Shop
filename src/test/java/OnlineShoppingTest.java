import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class OnlineShoppingTest {

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
    public void testAccessAndLogin() {
        driver.get("http://localhost:8080/OnlineShopping_war_exploded/");

        // Thử tìm và nhấn vào liên kết "Đăng nhập" nhiều lần nếu gặp lỗi StaleElementReferenceException
        boolean isClicked = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement loginLink = driver.findElement(By.cssSelector("a[href='user?action=login']"));
                loginLink.click();
                isClicked = true;
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        // Kiểm tra xem đã nhấn vào liên kết "Đăng nhập" thành công hay chưa
        assertTrue("Không thể nhấn vào liên kết Đăng nhập", isClicked);

        // Chờ trang đăng nhập tải
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Kiểm tra xem trang đăng nhập có được mở ra hay không
        String currentUrl = driver.getCurrentUrl();
        assertTrue("URL không đúng, phải chứa 'user?action=login'", currentUrl.contains("user?action=login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
