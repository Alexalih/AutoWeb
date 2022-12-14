import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class GloriaJeansTest extends AbstractTest {

    @Test
    void logInTest() throws InterruptedException {
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.closeSelectRegion();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Lihalexa@yandex.ru","Mauser12");

        String textAccount = loginPage.getAccountLink().getText();
        System.out.println(textAccount);
        Assertions.assertEquals(textAccount, "Александра");
        Thread.sleep(10000);


//        closeSelectRegion();
//        WebElement elementLogin = getDriver().findElement(By.xpath("//*[@data-qa=\"account-link\"]"));
//        elementLogin.click();
//        WebElement elementLog = getDriver().findElement(By.xpath("//*[@data-qa=\"loginEmail\"]"));
//        elementLog.click();
//        elementLog.sendKeys("Lihalexa@yandex.ru");
//        WebElement elementPass = getDriver().findElement(By.xpath("//*[@data-qa=\"loginPassword\"]"));
//        elementPass.click();
//        elementPass.sendKeys("Mauser12");
//        WebElement elementLoginSubmit = getDriver().findElement(By.xpath("//*[@data-qa=\"loginSubmit\"]"));
//        elementLoginSubmit.click();
//        WebElement accountLink = getDriver().findElement(By.xpath(".//*[@data-qa=\"account-link\"]"));
//        Assertions.assertTrue(accountLink.getText().contains("Александра"));

    }


    @Test
    void changeCityTest() throws InterruptedException {
        MenuPage  menuPage = new MenuPage(getDriver());
        menuPage.changeRegion();
        menuPage.changeRegion();
        String text = menuPage.getRegionDelivery().getText();
        System.out.println(text);
        Assertions.assertEquals(text, "Краснодар");
//        closeSelectRegion();
//        Thread.sleep(10000);
//        WebElement regionDelivery = getDriver().findElement(By.xpath("//span[@data-pop-up-name=\"region-delivery\"]"));
//        regionDelivery.click();
//        WebElement region23 = getDriver().findElement(By.xpath("//span[@data-region-code=\"23\"]"));
//        region23.click();
//        Thread.sleep(10000);

//        WebElement changeRegionDelivery = getDriver().findElement(By.xpath("//span[@data-pop-up-name=\"region-delivery\"]"));
//        Assertions.assertTrue(changeRegionDelivery.getText().contains("Краснодар"));
    }

    @Test
    void searchTest() {
        MenuPage menuPage =new MenuPage(getDriver());
        menuPage.closeSelectRegion();
        menuPage.search("tom");
//        closeSelectRegion();
//        WebElement searchField = getDriver().findElement(By.xpath(".//*[@id=\"js-site-search-input\"]"));
//        searchField.click();
//        searchField.sendKeys("tom");
        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://www.gloria-jeans.ru/?digiSearch=true&term=tom&params=%7Csort%3DDEFAULT");

    }

    @Test
    void goToCartTest() {
        MenuPage menuPage = new MenuPage(getDriver());
        try {
            menuPage.closeSelectRegion();
        } catch (Exception e){
            e.printStackTrace();
        }
        menuPage.goToCart();
//        WebElement cart = getDriver().findElement(By.xpath(".//*[@data-qa=\"icon-cart\"]"));
//        cart.click();
        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://www.gloria-jeans.ru/cart");

    }

//    @Test
//    void favoriteTest() {
//        closeSelectRegion();
//        WebElement women = getDriver().findElement(By.xpath(".//*[@data-for=\"LadyLink\"][1]"));
//        women.click();
//        WebElement heart = getDriver().findElement(By.xpath("//*[@data-sku-code=\"4660207654480\"][1]"));
//        heart.click();
//
//    }

//    @Test
//    void logOutTest () throws InterruptedException {
//        logInTest();
//        closeAlert();
//        WebElement elementLog =getDriver().findElement(By.xpath("//div[@class=\"modal-account\"]/a[@href=\"/logout\"]"));
//        elementLog.click();
//
//
//    }




}
