//package Test;
//
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
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
//import java.io.File;
//import java.nio.file.Files;
//
//public class AddPostTest {
//    private WebDriver driver;
//    private static final String BASE_URL = "http://localhost:8080/WebDienTu";
//    private static final String USERNAME = "thib@gmail.com";
//    private static final String PASSWORD = "123";
//    private WebDriverWait wait;
//    private static final String TEST_IMAGE_PATH = "D:\\anh2.jpg"; // Update this path
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
//        
//        // Verify login success and user session
//        
//        // Navigate to Add Post page
//        driver.get(BASE_URL + "/addPost");
//    }
//
//    @Test(priority = 1)
//    public void testBlogTypeLoading() {
//        try {
//            // Verify blog types are loaded from server
//            Select blogTypeSelect = new Select(driver.findElement(By.name("blogtype")));
//            List<WebElement> options = blogTypeSelect.getOptions();
//            Assert.assertTrue(options.size() > 1, "Blog types should be loaded from server");
//            
//            // Verify default empty option exists
//            Assert.assertEquals(options.get(0).getText(), "Select Blog Type", 
//                    "First option should be 'Select Blog Type'");
//        } catch (Exception e) {
//            Assert.fail("Blog type loading test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 2)
//    public void testInvalidImageFormat() {
//        try {
//            WebElement fileInput = driver.findElement(By.name("blogimage"));
//            String invalidImagePath = "D:\\anh2.jpg"; // Create a non-jpg test file
//            fileInput.sendKeys(invalidImagePath);
//            
//            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//            submitButton.click();
//            
//            // Should stay on same page due to validation
//            Assert.assertTrue(driver.getCurrentUrl().contains("addPost"),
//                    "Should not submit with invalid image format");
//        } catch (Exception e) {
//            Assert.fail("Invalid image format test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 3)
//    public void testCompleteFormSubmission() {
//        try {
//            // Get current date for verification
//            LocalDate currentDate = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            String expectedDate = currentDate.format(formatter);
//            
//            // Fill in all required fields
//            Select blogTypeSelect = new Select(driver.findElement(By.name("blogtype")));
//            blogTypeSelect.selectByIndex(1);
//            
//            String testTitle = "Test Blog Title " + System.currentTimeMillis();
//            WebElement titleInput = driver.findElement(By.name("blogtittle"));
//            titleInput.clear();
//            titleInput.sendKeys(testTitle);
//            
//            WebElement summaryInput = driver.findElement(By.name("blogsummary"));
//            summaryInput.clear();
//            summaryInput.sendKeys("Test Blog Summary");
//            
//            // Handle TinyMCE editor
//            driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area iframe")));
//            WebElement editorBody = driver.findElement(By.tagName("body"));
//            editorBody.clear();
//            editorBody.sendKeys("Test Blog Content");
//            driver.switchTo().defaultContent();
//            
//            // Set status to Published
//            Select statusSelect = new Select(driver.findElement(By.name("blogstatus")));
//            statusSelect.selectByValue("Published");
//            
//            // Upload valid jpg image
//            WebElement fileInput = driver.findElement(By.name("blogimage"));
//            File testImage = new File(TEST_IMAGE_PATH);
//            fileInput.sendKeys(testImage.getAbsolutePath());
//            
//            WebElement imageTitleInput = driver.findElement(By.name("imagetittle"));
//            imageTitleInput.clear();
//            imageTitleInput.sendKeys("Test Image Title");
//            
//            // Set blog flag
//            Select flagSelect = new Select(driver.findElement(By.name("blogflag")));
//            flagSelect.selectByValue("1");
//            
//            // Submit form
//            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//            submitButton.click();
//            
//            // Verify redirect to PostListMKT
//            wait.until(ExpectedConditions.urlContains("PostListMKT"));
//            Assert.assertTrue(driver.getCurrentUrl().contains("PostListMKT"),
//                    "Should redirect to PostListMKT after successful submission");
//            
//            // Verify the new blog post appears in the list
//            WebElement searchInput = driver.findElement(By.name("tittlewrite"));
//            searchInput.sendKeys(testTitle);
//            driver.findElement(By.xpath("//input[@type='submit']")).click();
//            
//            // Verify blog details
//            List<WebElement> blogRows = driver.findElements(By.xpath("//tbody/tr"));
//            boolean found = false;
//            for (WebElement row : blogRows) {
//                if (row.getText().contains(testTitle)) {
//                    Assert.assertTrue(row.getText().contains("Published"), "Blog status should be Published");
//                    Assert.assertTrue(row.getText().contains(expectedDate), "Blog date should be current date");
//                    found = true;
//                    break;
//                }
//            }
//            Assert.assertTrue(found, "Newly created blog should appear in the list");
//            
//        } catch (Exception e) {
//            Assert.fail("Complete form submission test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 4)
//    public void testRequiredFieldValidation() {
//        driver.get(BASE_URL + "/addPost");
//        try {
//            // Try to submit with missing required fields
//            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//            submitButton.click();
//            
//            // Verify form validation for required fields
//            Assert.assertTrue(driver.getCurrentUrl().contains("addPost"),
//                    "Form should not submit with missing required fields");
//            
//            // Verify HTML5 validation messages
//            WebElement titleInput = driver.findElement(By.name("blogtittle"));
//            Assert.assertTrue(titleInput.getAttribute("required") != null,
//                    "Blog title should be required");
//            
//            WebElement summaryInput = driver.findElement(By.name("blogsummary"));
//            Assert.assertTrue(summaryInput.getAttribute("required") != null,
//                    "Blog summary should be required");
//            
//            WebElement imageTitleInput = driver.findElement(By.name("imagetittle"));
//            Assert.assertTrue(imageTitleInput.getAttribute("required") != null,
//                    "Image title should be required");
//            
//        } catch (Exception e) {
//            Assert.fail("Required field validation test failed: " + e.getMessage());
//        }
//    }
//
//
//    @AfterMethod
//    public void handleTestFailure(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("Test failed: " + result.getName());
//            System.out.println("Error: " + result.getThrowable());
//            // Add screenshot capture if needed
//            try {
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                File source = ts.getScreenshotAs(OutputType.FILE);
//                File destination = new File("test-output/screenshots/" + result.getName() + "_failed.png");
//                Files.copy(source.toPath(), destination.toPath());
//                System.out.println("Screenshot saved: " + destination.getAbsolutePath());
//            } catch (Exception e) {
//                System.out.println("Exception while taking screenshot: " + e.getMessage());
//            }
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