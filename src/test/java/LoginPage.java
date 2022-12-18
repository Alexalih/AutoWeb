import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy (xpath = ".//*[@data-qa=\"account-link\"]")
    private WebElement accountLink;

    @FindBy (xpath = ".//*[@data-qa=\"loginEmail\"]")
    private WebElement fieldEmail;

    @FindBy (xpath = ".//*[@data-qa=\"loginPassword\"]")
    private WebElement fieldPassword;

    @FindBy (xpath = ".//*[@data-qa=\"loginSubmit\"]")
    private WebElement loginSubmit;

    public WebElement getAccountLink() {
        return accountLink;
    }

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

    public LoginPage clickLoginButton (){
        this.loginSubmit.click();
        return this;
    }


    public LoginPage clickAccount (){
        this.accountLink.click();
        return this;
    }

    public void login(String email, String pass) {
        Actions login = new Actions(getDriver());
        login
                .click(this.accountLink)
                .click(this.fieldEmail)
                .sendKeys(email)
                .click(this.fieldPassword)
                .sendKeys(pass)
                .click(this.loginSubmit)
                .build()
                .perform();

    }





}
