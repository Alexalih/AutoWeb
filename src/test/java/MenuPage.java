import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends AbstractPage{
    @FindBy(xpath =".//*[@data-qa=\"closeAutodetectRegion\"]")
    private WebElement closeSelectRegion;

    @FindBy(xpath ="//span[@data-pop-up-name=\"region-delivery\"]")
    private WebElement regionDelivery;

    @FindBy(xpath = "//span[@data-region-code=\"23\"]")
    private WebElement region23;

    @FindBy(id = "js-site-search-input")
    private WebElement fieldSearch;

    @FindBy(xpath = ".//*[@data-qa=\"icon-cart\"]")
    private  WebElement cartLink;


    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegionDelivery() {
        return regionDelivery;
    }

    public void closeSelectRegion(){
        this.closeSelectRegion.click();
    }

    public void changeRegion() {
        Actions changeRegion = new Actions(getDriver());
        changeRegion
                .click(regionDelivery)
                .click(region23)
                .build()
                .perform();
    }

    public void search(String searchQuery){
        this.fieldSearch.click();
        this.fieldSearch.sendKeys("tom");
//        Actions search = new Actions(getDriver());
//        search
//                .click(fieldSearch)
//                .sendKeys(searchQuery)
//                .build()
//                .perform();
    }

    public void goToCart (){
        this.cartLink.click();
    }




}
