import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends Utils {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    private static final String EMAIL_BOX = "identifierId";
    //Xpath used, because gmail has now some security measures and it does not work properly with id.
    private static final String PASSWORD_BOX = "//*[@id='password']/div[1]/div/div[1]/input";
    private static final String NEXT_BUTTON = "identifierNext";
    private static final String PASSWORD_NEXT_BUTTON = "passwordNext";

    @FindBy(id = EMAIL_BOX)
    private WebElement email_box;

    @FindBy(xpath = PASSWORD_BOX)
    private WebElement password_box;

    @FindBy(id = NEXT_BUTTON)
    private WebElement next_button;

    @FindBy(id = PASSWORD_NEXT_BUTTON)
    private WebElement password_next_button;


    public void enterEmail() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(EMAIL_BOX)));
        email_box.sendKeys(USERNAME);
    }

    public void enterPassword() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PASSWORD_BOX)));
        password_box.sendKeys(PASSWORD);
    }

    public void clickNext() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.id(NEXT_BUTTON)));
        next_button.click();
    }

    public void clickPasswordNext() {
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(PASSWORD_NEXT_BUTTON)));
        password_next_button.click();
    }
}
