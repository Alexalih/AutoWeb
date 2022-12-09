package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Test1LogIn {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.gloria-jeans.ru");

        CloseSelectRegion(driver);
        logIn(driver);
        //driver.quit();


    }
    public static void CloseSelectRegion (WebDriver driver){
        WebElement elementRegion = driver.findElement(By.xpath(".//*[@data-qa=\"closeAutodetectRegion\"]"));
        elementRegion.click();
    }
    public static void logIn (WebDriver driver){
        WebElement elementLogin = driver.findElement(By.xpath("//*[@data-qa=\"account-link\"]"));
        elementLogin.click();
        WebElement elementLog = driver.findElement(By.xpath("//*[@data-qa=\"loginEmail\"]"));
        elementLog.click();
        elementLog.sendKeys("Lihalexa@yandex.ru");
        WebElement elementPass = driver.findElement(By.xpath("//*[@data-qa=\"loginPassword\"]"));
        elementPass.click();
        elementPass.sendKeys("Mauser12");
        WebElement elementLoginSubmit = driver.findElement(By.xpath("//*[@data-qa=\"loginSubmit\"]"));
        elementLoginSubmit.click();
    }
    public static void CloseAlert(WebDriver driver){
        // WebElement elementAlert = driver.findElement(By.xpath("//*[@data-editro-style=\"button26066\"]"));

        WebElement elementAlert = driver.findElement(By.xpath(".//button[@class=\"close js-close\"]"));
        elementAlert.click();
    }
}
