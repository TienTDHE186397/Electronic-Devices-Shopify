//package SaleController;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.time.Duration;
//
//public class RegisterFormTest {
//
//    private WebDriver driver;
//    private static final String BASE_URL = "http://localhost:8080/WebDienTu";
//    private WebDriverWait wait;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Zalo saving file\\chromedriver-win64\\chromedriver.exe"); // Đường dẫn đến ChromeDriver
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        driver.get(BASE_URL + "/signup.jsp"); // Điều hướng đến trang đăng ký
//    }
//
//    @Test
//    public void testRegisterSuccess() {
//        // Nhập thông tin đăng ký hợp lệ
//        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
//        nameField.sendKeys("Nguyen Van A");
//        driver.findElement(By.name("pass")).sendKeys("password123");
//        driver.findElement(By.name("repass")).sendKeys("password123");
//        driver.findElement(By.name("gender")).sendKeys("Nam");
//        driver.findElement(By.name("date")).sendKeys("2000-01-01");
//        driver.findElement(By.name("email")).sendKeys("nguyenvana@example.com");
//        driver.findElement(By.name("phone")).sendKeys("0123456789");
//        driver.findElement(By.name("address")).sendKeys("123 ABC Street");
//        // Gửi form đăng ký
//        driver.findElement(By.name("submit1")).click();
//        // Kiểm tra điều hướng đến trang thành công hoặc có thông báo thành công
//        Assert.assertTrue(driver.getCurrentUrl().contains("/success"), "Không điều hướng đến trang thành công.");
//    }
//
//    @Test
//    public void testRegisterWithMissingFields() {
//        // Để trống một số trường và gửi form
//        driver.findElement(By.name("name")).sendKeys("");
//        driver.findElement(By.name("pass")).sendKeys("password123");
//        driver.findElement(By.name("repass")).sendKeys("password123");
//        driver.findElement(By.name("email")).sendKeys("invalid@example.com");
//
//        // Gửi form đăng ký
//        driver.findElement(By.name("submit1")).click();
//
//        // Xác minh có thông báo lỗi xuất hiện
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h4")));
//        Assert.assertTrue(errorMessage.getText().contains("Thiếu thông tin"), "Không hiển thị thông báo lỗi khi thiếu trường thông tin.");
//    }
//
//    @Test
//    public void testRegisterWithInvalidEmail() {
//        // Nhập email không hợp lệ
//        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
//        nameField.sendKeys("Nguyen Van A");
//        driver.findElement(By.name("pass")).sendKeys("password123");
//        driver.findElement(By.name("repass")).sendKeys("password123");
//        driver.findElement(By.name("gender")).sendKeys("Nam");
//        driver.findElement(By.name("date")).sendKeys("2000-01-01");
//        driver.findElement(By.name("email")).sendKeys("invalid-email");
//        driver.findElement(By.name("phone")).sendKeys("0123456789");
//        driver.findElement(By.name("address")).sendKeys("123 DEF Street");
//
//        // Gửi form đăng ký
//        driver.findElement(By.name("submit1")).click();
//
//        // Xác minh thông báo lỗi email không hợp lệ xuất hiện
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h4")));
//        Assert.assertTrue(errorMessage.getText().contains("Email không hợp lệ"), "Không hiển thị thông báo lỗi khi email không hợp lệ.");
//    }
//
//    @Test
//    public void testPasswordMismatch() {
//        // Nhập mật khẩu không khớp
//        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
//        nameField.sendKeys("Nguyen Van A");
//        driver.findElement(By.name("pass")).sendKeys("password123");
//        driver.findElement(By.name("repass")).sendKeys("differentPassword");
//        driver.findElement(By.name("gender")).sendKeys("Nữ");
//        driver.findElement(By.name("date")).sendKeys("1999-12-12");
//        driver.findElement(By.name("email")).sendKeys("vancc@example.com");
//        driver.findElement(By.name("phone")).sendKeys("0987654321");
//        driver.findElement(By.name("address")).sendKeys("456 GHI Street");
//
//        // Gửi form đăng ký
//        driver.findElement(By.name("submit1")).click();
//
//        // Xác minh có thông báo lỗi mật khẩu không khớp xuất hiện
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h4")));
//        Assert.assertTrue(errorMessage.getText().contains("Mật khẩu không khớp"), "Không hiển thị thông báo lỗi khi mật khẩu không khớp.");
//    }
//
//    @Test
//    public void testRedirectToLogin() {
//        // Nhấn nút chuyển hướng đến trang đăng nhập
//        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
//
//        // Xác minh điều hướng đến trang đăng nhập
//        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Không điều hướng đến trang đăng nhập.");
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
