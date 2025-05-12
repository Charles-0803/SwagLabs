package basetests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSetup {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected OverviewPage overviewPage;
    protected ConfirmationPage confirmationPage;

    @BeforeEach
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-site-isolation-trials");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-features=IsolateOrigins,site-per-process");
        
        // Set binary location if needed
        // options.setBinary("/usr/bin/google-chrome");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        // Initialize page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error closing WebDriver: " + e.getMessage());
            }
            driver = null;
        }
    }
}
