import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestUserProflie {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viqua\\.cache\\selenium\\chromedriver\\win64\\126.0.6478.126\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/OnlineShopping_war_exploded/home");

        driver.findElement(By.xpath("//img[@src=\"assets/img/bg/banner8.jpg\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-secondary dropdown-toggle\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"dropdown-item\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class=\"top_links\"])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href=\"user?action=login\"])[2]"))).click();
    }

    @After
    public void tearDown() {
        updateUserNamePass("huy", "admin1");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testC1() {
        performLogin("Admin@gmail.com", "admin1");
        updateUserName("huy2");
        verifyUserName("Xin Chào Huy2");
    }

    @Test
    public void testC2() {
        performLogin("Admin@gmail.com", "admin1");
        updateUserName("huy3");
        verifyUserName("Xin Chào Huy3");
    }

    @Test
    public void testC3() {
        performLogin("Admin@gmail.com", "admin1");
        updateUserName("huyyyyyyyyyyyyyyyyyyyyyyyyyy2");
        verifyUserName("Xin Chào huyyyyyyyyyyyyyyyyyyyyyyyyyy2");
    }
    @Test
    public void testC4() {
        performLogin("Admin@gmail.com", "admin1");
        updateUserNamePass("huy3", "123456789  ");
        verifyUserName("Xin Chào Huy3");
    }

    @Test
    public void testC5() {
        performLogin("Admin@gmail.com", "admin1");
        updateUserName("");
        verifyUserName("Xin Chào ");
    }
    @Test

    public void testC6() {
        performLogin("Admin@gmail.com", "ews");
        try {
            // Thực hiện cập nhật tên người dùng và mật khẩu với giá trị null
            updateUserNamePass(null, null);
            // Xác minh tên người dùng
            verifyUserName("Xin Chào");
        } catch (Exception e) {
            // In ra thông tin lỗi và khiến test thất bại nếu có ngoại lệ
            e.printStackTrace();
            fail("Test failed due to exception: " + e.getMessage());
        }
    }

    private void performLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name=\"user_email\"])[1]"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name=\"user_pass\"])[1]"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type=\"submit\"])[3]"))).click();
    }

    private void updateUserName(String newUserName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul/li/ul/li[1]/a"))).click();

        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-details\"]/div/div/div/form/input[1]")));
        textField.clear();
        textField.sendKeys(newUserName);


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-details\"]/div/div/div/form/div/button"))).click();
    }
    private void updateUserNamePass(String newUserName,String pass) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul/li/ul/li[1]/a"))).click();

        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-details\"]/div/div/div/form/input[1]")));
        textField.clear();
        textField.sendKeys(newUserName);
// //*[@id="account-details"]/div/div/div/form/input[3]
        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-details\"]/div/div/div/form/input[3]")));
        passField.clear();
        passField.sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-details\"]/div/div/div/form/div/button"))).click();
    }

    private void verifyUserName(String expectedUserName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul/li/a"))).getText();
        // Kiểm tra độ dài của chuỗi
        if (name.length() < 15&& name.length() > 0) {
            System.out.println("Tên người dùng ngắn hơn 15 ký tự.");
            // Thực hiện hành động fail hoặc log
            assertTrue("Tên ngắn hơn 15 ký tự", name.length() <= 15);
            assertEquals(expectedUserName, name);
        } else {
            System.out.println("Tên người dùng sai quy định.");
            assertFalse("Tên người dùng sai quy định", name.length() <= 15);
        }

    }
}
