/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;

public class PostListMKTTest {

    private WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080/WebDienTu";
    private static final String USERNAME = "thib@gmail.com";
    private static final String PASSWORD = "123";
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Zalo saving file\\chromedriver-win64\\chromedriver.exe");
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize browser window
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-popup-blocking"); // Disable popup blocking
        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Login process
        driver.get(BASE_URL + "/login.jsp");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user"))).sendKeys(USERNAME);
        driver.findElement(By.name("pass")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Navigate to Post List page
        driver.get(BASE_URL + "/PostListMKT");
    }

    @AfterMethod
    public void clearSearchInput() {
        try {
            WebElement titleInput = driver.findElement(By.name("tittlewrite"));
            titleInput.clear();
            WebElement authorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("authorwrite")));
            authorInput.clear();
            Select typeSelect = new Select(driver.findElement(By.name("type")));
            typeSelect.selectByIndex(0);
            Select statusSelect = new Select(driver.findElement(By.name("statusf")));
            statusSelect.selectByIndex(0);

        } catch (NoSuchElementException e) {
            // Nếu không tìm thấy ô tìm kiếm, không cần xóa gì thêm
        }
    }

    @Test(priority = 1)
    public void testSearchByTitle() {
        WebElement titleInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tittlewrite")));
        try {
            // Clear existing search and enter new search term
            titleInput.clear();
            titleInput.sendKeys("Top 5");
            // Submit search
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            // Wait for results and verify
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
            List<WebElement> results = driver.findElements(By.xpath("//tbody/tr"));
            if (!results.isEmpty()) {
                for (WebElement row : results) {
                    Assert.assertTrue(row.getText().contains("Top 5 jd"),
                            "Search result doesn't contain search term");
                }
            }
        } catch (Exception e) {
            Assert.fail("Search by title test failed: " + e.getMessage());
            titleInput.clear();

        }

    }

    @Test(priority = 2)
    public void testSearchByAuthor() {
        try {
            WebElement authorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("authorwrite")));
            authorInput.clear();
            authorInput.sendKeys("Phan Đăng Lưu");
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
            List<WebElement> results = driver.findElements(By.xpath("//tbody/tr"));
            if (!results.isEmpty()) {
                for (WebElement row : results) {
                    Assert.assertTrue(row.getText().contains("Phan Đăng Lưu"),
                            "Search result doesn't contain author name");
                }
            }
        } catch (Exception e) {
            Assert.fail("Search by author test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testFilterByType() {
        try {
            Select typeSelect = new Select(driver.findElement(By.name("type")));
            typeSelect.selectByIndex(1);
            Thread.sleep(1000);
            String selectedType = "Đằng Nhật Nam";
            List<WebElement> typeColumns = driver.findElements(By.xpath("//tbody/tr/td[4]"));
            for (WebElement cell : typeColumns) {
                Assert.assertEquals(cell.getText(), selectedType,
                        "Post type doesn't match selected filter");
                return;
            }
        } catch (Exception e) {
            Assert.fail("Filter by type test failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testFilterByStatus() {
        try {
            Select statusSelect = new Select(driver.findElement(By.name("statusf")));
            statusSelect.selectByIndex(1);
            // Wait for table to refresh
            Thread.sleep(1000);

            List<WebElement> statusColumns = driver.findElements(By.xpath("//tbody/tr/td[7]"));
            for (WebElement cell : statusColumns) {
                Assert.assertEquals(cell.getText().toLowerCase(), "published",
                        "Post status doesn't match selected filter");
            }
        } catch (Exception e) {
            Assert.fail("Filter by status test failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void testSortByViews() {
        try {
            Select sortSelect = new Select(driver.findElement(By.name("sort")));
            sortSelect.selectByValue("viewsd");

            Thread.sleep(1000);

            List<WebElement> viewsColumns = driver.findElements(By.xpath("//tbody/tr/td[6]"));
            int previousViews = Integer.MAX_VALUE;

            for (WebElement cell : viewsColumns) {
                int currentViews = Integer.parseInt(cell.getText());
                Assert.assertTrue(currentViews <= previousViews,
                        "Views are not properly sorted in descending order");
                previousViews = currentViews;
            }
        } catch (Exception e) {
            Assert.fail("Sort by views test failed: " + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void testColumnVisibilityControls() {
        try {
            // Test hiding PostID column
            WebElement idCheckbox = driver.findElement(By.xpath("//input[@type='checkbox'][@value='id']"));
            if (!idCheckbox.isSelected()) {
                idCheckbox.click();
            }

            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(1000);

            // Verify PostID column is hidden
            List<WebElement> headers = driver.findElements(By.xpath("//thead/tr/th"));
            boolean idColumnFound = false;
            for (WebElement header : headers) {
                if (header.getText().equals("PostID")) {
                    idColumnFound = true;
                    break;
                }
            }
            Assert.assertFalse(idColumnFound, "PostID column should be hidden");

        } catch (Exception e) {
            Assert.fail("Column visibility test failed: " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void testPagination() {
        try {
            // Set items per page
            WebElement numberPerPage = driver.findElement(By.name("numberofpage"));
            numberPerPage.clear();
            numberPerPage.sendKeys("5");
            driver.findElement(By.xpath("//input[@type='submit']")).click();

            Thread.sleep(1000);

            // Verify number of items
            List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
            Assert.assertTrue(rows.size() <= 5,
                    "Number of items per page exceeds specified limit");

            // Test pagination if available
            List<WebElement> paginationButtons = driver.findElements(By.xpath("//div[@class='pagination']/button"));
            if (paginationButtons.size() > 1) {
                paginationButtons.get(1).click();
                Thread.sleep(1000);
                Assert.assertTrue(driver.getCurrentUrl().contains("page=2"),
                        "Pagination did not navigate to page 2");
            }
        } catch (Exception e) {
            Assert.fail("Pagination test failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void handleTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed: " + result.getName());
            System.out.println("Error: " + result.getThrowable());
            // You can add screenshot capture here if needed
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
