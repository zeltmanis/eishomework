import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInTest {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    /*Log In Test
    * 1. Go to Gmail html version
    * 2. Enter username
    * 3. Enter password
    * 4. Check that page is opened and banner is visible
    * Did not used pageTitle to verify, because all pages are called "Gmail"
    * */
    @Test
    public void logInTest() {
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        InboxPage inboxPage = new InboxPage(driver);
        loginPage.enterEmail();
        loginPage.clickNext();
        loginPage.enterPassword();
        loginPage.clickPasswordNext();
        inboxPage.checkPageBanner();
    }

    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
