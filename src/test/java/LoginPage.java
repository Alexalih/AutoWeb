import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy (xpath = "\"//*[@data-qa=\\\"account-link\\\"]\"")
    private WebElement acountLink;

    @FindBy (xpath = "\"//*[@data-qa=\\\"loginEmail\\\"]\"")
    private WebElement fieldEmail;

    @FindBy (xpath = "\"//*[@data-qa=\\\"loginPassword\\\"]\"")
    private WebElement fieldPassword;

    @FindBy (xpath = "\"//*[@data-qa=\\\"loginSubmit\\\"]\"")
    private WebElement loginSubmit;




    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public LoginPage setLogin (String login) {
        this.fieldEmail.click();
        this.fieldEmail.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String pass){
        this.fieldPassword.click();
        this.fieldPassword.sendKeys(pass);
        return this;
    }


}
