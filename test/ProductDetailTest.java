//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.util.concurrent.TimeUnit;
//
//public class ProductDetailTest {
//    private WebDriver driver;
//    private static final String BASE_URL = "http://localhost:9999/WebDienTu";
//    private static final String USERNAME = "marketing";
//    private static final String PASSWORD = "123";
//    private WebDriverWait wait;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver-win64\\chromedriver.exe"); // Update the path to your ChromeDriver
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized"); // Start the browser maximized
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
//
//        // Navigate and login
//        driver.get(BASE_URL + "/login.jsp");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user"))).sendKeys(USERNAME);
//        driver.findElement(By.name("pass")).sendKeys(PASSWORD);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.get(BASE_URL + "/ProductDetail?ID=1"); // Navigate to ProductDetail.jsp
//    }
//
//   @Test
//public void testEditProductSuccess() {
//    try {
//        wait.until(ExpectedConditions.urlContains("/ProductDetail?ID=1"));
//
//        // Fill in product details
//        driver.findElement(By.name("title")).clear();
//        driver.findElement(By.name("title")).sendKeys("Updated Product Title");
//
//        // Other fields...
//        // For example, filling out the product name
//        driver.findElement(By.name("productName")).clear();
//        driver.findElement(By.name("productName")).sendKeys("Updated Product Name");
//
//        // Submit the form
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//
//        // Wait for a success message to be displayed
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
//        Assert.assertTrue(successMessage.isDisplayed(), "Product submission was not successful.");
//
//        // After form submission, re-find the dropdown
//        Select categoryDropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("category"))));
//
//        // Debugging print for available categories
//        for (WebElement option : categoryDropdown.getOptions()) {
//            System.out.println("Available category: " + option.getText());
//        }
//
//        // Select a category safely
//        try {
//            categoryDropdown.selectByVisibleText("New Category"); // Ensure this exists
//        } catch (NoSuchElementException e) {
//            Assert.fail("Category 'New Category' does not exist.");
//        }
//    } catch (Exception e) {
//        Assert.fail("Unexpected error: " + e.getMessage());
//    }
//}
//
//    @Test
//    public void testEditProductWithInvalidData() {
//        try {
//            wait.until(ExpectedConditions.urlContains("ProductDetail.jsp"));
//
//            // Fill in invalid product details
//            driver.findElement(By.name("title")).clear();
//            driver.findElement(By.name("title")).sendKeys("Updated Product Title");
//
//            driver.findElement(By.name("productName")).clear();
//            driver.findElement(By.name("productName")).sendKeys("Updated Product Name");
//
//            driver.findElement(By.name("views")).clear();
//            driver.findElement(By.name("views")).sendKeys("InvalidNumber"); // Invalid input for views
//
//            driver.findElement(By.cssSelector("button[type='submit']")).click();
//
//            // Verify error message
//            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message-id")));
//            Assert.assertTrue(errorMsg.isDisplayed(), "Expected error message for invalid data not displayed.");
//        } catch (Exception e) {
//            Assert.fail("Unexpected error: " + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
