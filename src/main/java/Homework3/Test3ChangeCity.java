package Homework3;

import Homework3.Test1LogIn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test3ChangeCity {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.gloria-jeans.ru");

        Test1LogIn.CloseSelectRegion(driver);

        WebElement regionDelivery = driver.findElement(By.xpath("//span[@data-pop-up-name=\"region-delivery\"]"));
        regionDelivery.click();
        WebElement region23 = driver.findElement(By.xpath("//span[@data-region-code=\"23\"]"));
        region23.click();
        //driver.quit();
    }
}
