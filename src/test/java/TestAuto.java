package web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAuto {
    WebDriver driver = new ChromeDriver();

//
//    // Constants for URLs and credentials
//    private static final String BASE_URL = "http://localhost:8080/EBook_war_exploded/";
//    private static final String VALID_EMAIL = "vudaivillage2k3@gmail.com";
//    private static final String VALID_PASSWORD = "1";
//    private static final String INVALID_EMAIL = "invalidemail@example.com";
//    private static final String INVALID_PASSWORD = "invalidpassword";
//
//    @BeforeMethod
//    public void setUp() {
//        System.out.println("Before Method");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void testValidLogin() {
//        driver.get(BASE_URL);
//
//        WebElement emailInput = driver.findElement(By.name("email"));
//        WebElement passwordInput = driver.findElement(By.name("password"));
//        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        emailInput.sendKeys(VALID_EMAIL);
//        passwordInput.sendKeys(VALID_PASSWORD);
//        loginButton.click();
//
//        try {
//            // Check for successful login message
//            WebElement successMessage = driver.findElement(By.cssSelector(".text-success"));
//            Assert.assertTrue(successMessage.isDisplayed(), "Login successful message should be displayed");
//        } catch (Exception e) {
//            Assert.fail("Success message not found: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void testInvalidLogin() {
//        driver.get(BASE_URL);
//
//        WebElement emailInput = driver.findElement(By.name("email"));
//        WebElement passwordInput = driver.findElement(By.name("password"));
//        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        emailInput.sendKeys(INVALID_EMAIL);
//        passwordInput.sendKeys(INVALID_PASSWORD);
//        loginButton.click();
//
//        try {
//            // Check for failed login message
//            WebElement failedMessage = driver.findElement(By.cssSelector(".text-danger"));
//            Assert.assertTrue(failedMessage.isDisplayed(), "Login failed message should be displayed");
//        } catch (Exception e) {
//            Assert.fail("Failed message not found: " + e.getMessage());
//        }
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        System.out.println("After Method");
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
