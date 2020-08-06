
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InboxPage {

    WebDriver driver;
    WebDriverWait wait;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    //Xpath used, because gmail has now some security measures and it does not work properly with id.
    private static final String COMPOSE = "/html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[1]";
    private static final String BANNER = "gb";
    private static final String EMAIL = "/html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/a/span";
    private static final String DELETE_BUTTON = "nvp_a_tr";
    private static final String DELETE_MSG = "/html/body/table[1]/tbody/tr[3]/td/table/tbody/tr/td";

    @FindBy(xpath = COMPOSE)
    private WebElement compose;

    @FindBy(id = BANNER)
    private WebElement banner;

    @FindBy(name = DELETE_BUTTON)
    private WebElement delete_button;

    @FindBy(xpath = EMAIL)
    private WebElement email;

    public WebElement checkPageBanner() {
        return banner;
    }

    public void clickCompose() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL)));
        compose.click();

    }

    public void findMsg() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COMPOSE)));
        email.click();
    }

    public void deleteMsg(){
        this.wait.until(ExpectedConditions.elementToBeClickable(By.name(DELETE_BUTTON)));
        delete_button.click();
    }

    public void confirmMsgDeleted(){
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DELETE_MSG)));
        boolean delete_msg = driver.findElement(By.xpath(DELETE_MSG)).isDisplayed();
    }

}
