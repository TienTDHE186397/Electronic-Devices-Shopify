package Test;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class ProductDetailTest {
    private WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080/WebDienTu";
    private static final String USERNAME = "thib@gmail.com";
    private static final String PASSWORD = "123";
    private static final int ID = 1;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Zalo saving file\\chromedriver-win64\\chromedriver.exe"); // Update the path to your ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Start the browser maximized
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate and login
        driver.get(BASE_URL + "/login.jsp");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user"))).sendKeys(USERNAME);
        driver.findElement(By.name("pass")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get(BASE_URL + "/ProductDetail?ID="+ID); // Navigate to ProductDetail.jsp
    }

    @Test
    public void testEditProductSuccess() {
        try {
            wait.until(ExpectedConditions.urlContains("/ProductDetail?ID="+ID));
            
            // Fill in the product details
            driver.findElement(By.name("title")).clear();
            driver.findElement(By.name("title")).sendKeys("Updated Product Title");

            driver.findElement(By.name("productName")).clear();
            driver.findElement(By.name("productName")).sendKeys("Updated Product Name");

            driver.findElement(By.name("views")).clear();
            driver.findElement(By.name("views")).sendKeys("100");

            driver.findElement(By.name("publisher")).clear();
            driver.findElement(By.name("publisher")).sendKeys("Updated Publisher");

            // Update release date
            driver.findElement(By.name("releaseDate")).clear();
            driver.findElement(By.name("releaseDate")).sendKeys("2024-11-04");

            // Select a category
            Select categoryDropdown = new Select(driver.findElement(By.name("category")));
            categoryDropdown.selectByVisibleText("New Category"); // Update to an existing category name

            // Fill in the remaining details
            driver.findElement(By.name("sale")).clear();
            driver.findElement(By.name("sale")).sendKeys("20");
driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("50");

            driver.findElement(By.name("price")).clear();
            driver.findElement(By.name("price")).sendKeys("299.99");

            driver.findElement(By.name("status")).clear();
            driver.findElement(By.name("status")).sendKeys("Available");

            // Submit the form
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Verify success message or redirection
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            Assert.assertTrue(successMessage.isDisplayed(), "Product submission was not successful.");
        } catch (Exception e) {
            Assert.fail("Unexpected error: " + e.getMessage());
        }
    }

    @Test
    public void testEditProductWithInvalidData() {
        try {
            wait.until(ExpectedConditions.urlContains("/ProductDetail?ID="+ID));

            // Fill in invalid product details
            driver.findElement(By.name("title")).clear();
            driver.findElement(By.name("title")).sendKeys("Updated Product Title");

            driver.findElement(By.name("productName")).clear();
            driver.findElement(By.name("productName")).sendKeys("Updated Product Name");

            driver.findElement(By.name("views")).clear();
            driver.findElement(By.name("views")).sendKeys("InvalidNumber"); // Invalid input for views

            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Verify error message
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message-id")));
            Assert.assertTrue(errorMsg.isDisplayed(), "Expected error message for invalid data not displayed.");
        } catch (Exception e) {
            Assert.fail("Unexpected error: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}