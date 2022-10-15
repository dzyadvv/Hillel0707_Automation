package lessons.lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TestCheckingGLogo_isDisplayed {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws IOException {

        WebElement logo = driver.findElement(By.xpath("//a[@class='header__logo']"));
        assertTrue(logo.isDisplayed(), "Logo doesn't appeared");
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}
