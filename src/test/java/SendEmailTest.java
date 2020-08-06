import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SendEmailTest {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    /*Sent e-mail test
     * 1. Go to Gmail html version
     * 2. Enter username
     * 3. Enter password
     * 4. Check that page is opened and banner is visible
     * 5. Click compose
     * 6. Enter e-mail address
     * 7. Enter subject
     * 8. Enter text in body
     * 9. Click send
     * 10. Check that message send msg is visible.
     * */

    @Test
    public void sendEmailTest() {
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        InboxPage inboxPage = new InboxPage(driver);
        ComposePopUPPage composePopUpPage = new ComposePopUPPage(driver);
        loginPage.enterEmail();
        loginPage.clickNext();
        loginPage.enterPassword();
        loginPage.clickPasswordNext();
        inboxPage.checkPageBanner();
        inboxPage.clickCompose();
        composePopUpPage.enterReceiver();
        composePopUpPage.enterSubject();
        composePopUpPage.enterText();
        composePopUpPage.clickSend();
        composePopUpPage.confirmSent();
    }

    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
