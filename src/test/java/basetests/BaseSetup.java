package basetests;

import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSetup {
    public static WebDriver driver;

    protected static LoginPage loginPage;
    protected static HomePage homePage;
    protected static ProductPage productPage;
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;
    protected static OverviewPage overviewPage;
    protected static ConfirmationPage confirmationPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        //Ensuring Chrome runs in a clean session
        options.addArguments("--incognito"); // Runs in Incognito mode to prevent user data conflicts
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // Helps with limited memory environments
        options.addArguments("--headless=new"); // Runs in headless mode (newer version)

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
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
        driver.quit();
    }
}
