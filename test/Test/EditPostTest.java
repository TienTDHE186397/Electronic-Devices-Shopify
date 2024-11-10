///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Test;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.testng.ITestResult;
//
//public class EditPostTest {
//
//    private WebDriver driver;
//    private static final String BASE_URL = "http://localhost:8080/WebDienTu";
//    private static final String USERNAME = "thib@gmail.com";
//    private static final String PASSWORD = "123";
//    private WebDriverWait wait;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Zalo saving file\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-popup-blocking");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Login process
//        driver.get(BASE_URL + "/login.jsp");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user"))).sendKeys(USERNAME);
//        driver.findElement(By.name("pass")).sendKeys(PASSWORD);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//    }
//
//   @Test(priority = 1)
//public void testEditBlogType() {
//    try {
//        navigateToEditPost("1");
//
//        Select blogTypeSelect = new Select(driver.findElement(By.name("blogtype")));
//        blogTypeSelect.selectByIndex(1); // Chọn loại blog theo chỉ mục
//
//        submitForm();
//
//        try {
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept(); 
//        } catch (TimeoutException e) {
//        }
//
//        wait.until(ExpectedConditions.urlContains("edit-success")); // Thay thế "edit-success" bằng một phần của URL bạn mong đợi sau khi submit
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("blogtype")));
//
//        String selectedValue = blogTypeSelect.getFirstSelectedOption().getText();  // Lấy giá trị đang được chọn
//        String actualValue = driver.findElement(By.name("blogtype")).getAttribute("value");  // Lấy giá trị thực tế trong form sau khi submit
//
//        Assert.assertEquals(selectedValue, actualValue, "Blog type was not updated correctly");
//
//    } catch (Exception e) {
//        Assert.fail("Edit blog type test failed: " + e.getMessage());
//    }
//}
//
//
//    @Test(priority = 2)
//    public void testEditBlogTitle() {
//        try {
//            navigateToEditPost("1");
//
//            String newTitle = "Updated Test Blog Title " + System.currentTimeMillis();
//            WebElement titleInput = driver.findElement(By.name("blogtittle"));
//            titleInput.clear();
//            titleInput.sendKeys(newTitle);
//
//            submitForm();
//
//            // Verify the change
//            driver.navigate().refresh();
//            Assert.assertEquals(driver.findElement(By.name("blogtittle")).getAttribute("value"),
//                    newTitle, "Blog title was not updated correctly");
//        } catch (Exception e) {
//            Assert.fail("Edit blog title test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 3)
//    public void testEditBlogSummary() {
//        try {
//            navigateToEditPost("1");
//            String newSummary = "Updated Test Blog Summary " + System.currentTimeMillis();
//            WebElement summaryInput = driver.findElement(By.name("blogsummary"));
//            summaryInput.clear();
//            summaryInput.sendKeys(newSummary);
//
//            submitForm();
//
//            // Verify the change
//            driver.navigate().refresh();
//            Assert.assertEquals(driver.findElement(By.name("blogsummary")).getAttribute("value"),
//                    newSummary, "Blog summary was not updated correctly");
//        } catch (Exception e) {
//            Assert.fail("Edit blog summary test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 4)
//    public void testEditBlogDetail() {
//        try {
//            navigateToEditPost("1");
//
//            // Since TinyMCE is used, we need to switch to its iframe
//            driver.switchTo().frame("tinymce_ifr");
//            WebElement editorBody = driver.findElement(By.id("tinymce"));
//            String newDetail = "Updated Test Blog Detail " + System.currentTimeMillis();
//            editorBody.clear();
//            editorBody.sendKeys(newDetail);
//            driver.switchTo().defaultContent();
//
//            submitForm();
//
//            // Verify the change (this might need adjustment based on how your application handles TinyMCE content)
//            driver.navigate().refresh();
//            driver.switchTo().frame("tinymce_ifr");
//            Assert.assertTrue(driver.findElement(By.id("tinymce")).getText().contains(newDetail),
//                    "Blog detail was not updated correctly");
//            driver.switchTo().defaultContent();
//        } catch (Exception e) {
//            Assert.fail("Edit blog detail test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 5)
//    public void testEditBlogStatus() {
//        try {
//            navigateToEditPost("1");
//
//            Select statusSelect = new Select(driver.findElement(By.name("blogstatus")));
//            String newStatus = statusSelect.getOptions().get(1).getText();
//            statusSelect.selectByVisibleText(newStatus);
//
//            submitForm();
//
//            // Verify the change
//            driver.navigate().refresh();
//            Select updatedStatus = new Select(driver.findElement(By.name("blogstatus")));
//            Assert.assertEquals(updatedStatus.getFirstSelectedOption().getText(),
//                    newStatus, "Blog status was not updated correctly");
//        } catch (Exception e) {
//            Assert.fail("Edit blog status test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 6)
//    public void testEditBlogImage() {
//        try {
//            navigateToEditPost("1");
//
//            // Upload new image
//            WebElement fileInput = driver.findElement(By.name("blogimage"));
//            fileInput.sendKeys("C:\\test-image.jpg"); // Ensure this test image exists
//
//            String newImageTitle = "Updated Image Title " + System.currentTimeMillis();
//            WebElement imageTitleInput = driver.findElement(By.name("imagetittle"));
//            imageTitleInput.clear();
//            imageTitleInput.sendKeys(newImageTitle);
//
//            submitForm();
//
//            // Verify the change
//            driver.navigate().refresh();
//            Assert.assertEquals(driver.findElement(By.name("imagetittle")).getAttribute("value"),
//                    newImageTitle, "Blog image title was not updated correctly");
//        } catch (Exception e) {
//            Assert.fail("Edit blog image test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 7)
//    public void testEditBlogFlag() {
//        try {
//            navigateToEditPost("1");
//
//            Select flagSelect = new Select(driver.findElement(By.name("blogflag")));
//            String newFlag = flagSelect.getOptions().get(1).getText();
//            flagSelect.selectByVisibleText(newFlag);
//
//            submitForm();
//
//            // Verify the change
//            driver.navigate().refresh();
//            Select updatedFlag = new Select(driver.findElement(By.name("blogflag")));
//            Assert.assertEquals(updatedFlag.getFirstSelectedOption().getText(),
//                    newFlag, "Blog flag was not updated correctly");
//        } catch (Exception e) {
//            Assert.fail("Edit blog flag test failed: " + e.getMessage());
//        }
//    }
//
//    private void navigateToEditPost(String postId) {
//        driver.get(BASE_URL + "/editPost?id=" + postId);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("form")));
//    }
//
//    private void submitForm() {
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
//    }
//
//    @AfterMethod
//    public void handleTestFailure(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("Test failed: " + result.getName());
//            System.out.println("Error: " + result.getThrowable());
//            // You could add screenshot capture here
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
