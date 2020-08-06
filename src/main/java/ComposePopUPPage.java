import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePopUPPage extends Utils {

    WebDriver driver;
    WebDriverWait wait;

    public ComposePopUPPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    private static final String RECEIVER = "to";
    private static final String SUBJECT = "subject";
    private static final String SEND_BUTTON = "nvp_bu_send";
    private static final String TEXT_BOX = "body";
    private static final String CONFIRMATION_MSG = "/html/body/table[1]/tbody/tr[3]/td/table/tbody/tr/td";
    private static final String SUBJECT_TEXT = "Test Email";


    @FindBy(id = RECEIVER)
    private WebElement receiver;

    @FindBy(name = SUBJECT)
    private WebElement subject;

    @FindBy(name = SEND_BUTTON)
    private WebElement send_button;

    @FindBy(name = TEXT_BOX)
    private WebElement text_box;

    @FindBy(xpath = CONFIRMATION_MSG)
    private WebElement confirmation_msg;

    public void enterReceiver() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(RECEIVER)));
        receiver.sendKeys(USERNAME);
    }

    public void enterSubject() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(SUBJECT)));
        subject.sendKeys(SUBJECT_TEXT);
    }

    public void enterText() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(TEXT_BOX)));
        text_box.sendKeys("Some text");
    }

    public void clickSend() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.name(SEND_BUTTON)));
        send_button.click();
    }

    public void confirmSent() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CONFIRMATION_MSG)));
        boolean confirmation_msg = driver.findElement(By.xpath(CONFIRMATION_MSG)).isDisplayed();
    }
}
