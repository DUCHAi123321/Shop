import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDetailsTest {

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
    public void testViewProductDetails() {
        // Mở trang chủ
        driver.get("http://localhost:8080/OnlineShopping_war_exploded/");

        // Nhấp vào sản phẩm cụ thể (giả định sản phẩm có ID là 'product-1')
        WebElement productLink = driver.findElement(By.cssSelector("a[href='product?action=view&id=1']"));
        productLink.click();

        // Kiểm tra xem trang chi tiết sản phẩm có được tải thành công hay không
        String currentUrl = driver.getCurrentUrl();
        assertTrue("URL không đúng, phải chứa 'product?action=view&id=1'", currentUrl.contains("product?action=view&id=1"));

        // Kiểm tra tên sản phẩm
        WebElement productName = driver.findElement(By.id("product-name"));
        assertEquals("Tên sản phẩm không đúng", "Tên sản phẩm mẫu", productName.getText());

        // Kiểm tra giá sản phẩm
        WebElement productPrice = driver.findElement(By.id("product-price"));
        assertEquals("Giá sản phẩm không đúng", "1000 VND", productPrice.getText());

        // Kiểm tra mô tả sản phẩm
        WebElement productDescription = driver.findElement(By.id("product-description"));
        assertTrue("Mô tả sản phẩm không đúng", productDescription.getText().contains("Mô tả sản phẩm mẫu"));

        // Kiểm tra hình ảnh sản phẩm
        WebElement productImage = driver.findElement(By.id("product-image"));
        assertTrue("Hình ảnh sản phẩm không được hiển thị đúng", productImage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
