import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        //options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.gloria-jeans.ru"), "Страница не доступна");
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeSelectRegion() {
        WebElement elementRegion = driver.findElement(By.xpath(".//*[@data-qa=\"closeAutodetectRegion\"]"));
        elementRegion.click();
    }

    public static void closeAlert() throws InterruptedException {
        Thread.sleep(10000);

//        WebElement email = driver.findElement(By.xpath(".//*[@type=\"email\"]"));
//        email.sendKeys("Lihalexa@yandex.ru");
//        WebElement submit = driver.findElement(By.xpath(".//button[@class=\"button form__submit js-submit\"]"));
//        submit.click();

        WebElement closeAlert = driver.findElement(By.xpath(".//button[@class=\"button js-close\"]"));
        closeAlert.click();
//        WebElement elementAlert = driver.findElement(By.xpath(".//button[@class=\"close js-close\"]"));
//        elementAlert.click();
    }


}
