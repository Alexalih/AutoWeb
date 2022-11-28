import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test4Search {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.gloria-jeans.ru");

        Test1LogIn.CloseSelectRegion(driver);

        WebElement searchField = driver.findElement(By.xpath(".//*[@id=\"js-site-search-input\"]"));
        searchField.click();
        searchField.sendKeys("пижамы");
        WebElement lookMore = driver.findElement(By.xpath(".//button[@class=\"digi-ac-find__button\"]"));
        lookMore.click();

        // driver.quit();
    }
}
