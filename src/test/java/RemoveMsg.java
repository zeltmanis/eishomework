import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RemoveMsg {

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
     * 5. Select e-mail
     * 6. Click delete
     * 7. Check that delete msg is visible
     * */

    @Test
    public void removeMsgTest(){
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        InboxPage inboxPage = new InboxPage(driver);
        loginPage.enterEmail();
        loginPage.clickNext();
        loginPage.enterPassword();
        loginPage.clickPasswordNext();
        inboxPage.checkPageBanner();
        inboxPage.findMsg();
        inboxPage.deleteMsg();
        inboxPage.confirmMsgDeleted();
    }

    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
