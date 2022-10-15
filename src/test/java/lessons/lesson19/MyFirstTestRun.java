package lessons.lesson19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MyFirstTestRun {
    private WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void firstRun() {

//        driver.get("https://www.google.com/");
//        WebElement buttonSearch = driver.findElement(By.name("btnK"));
//        buttonSearch.click();

        driver.get("https://rozetka.com.ua/");
        //List<WebElement> buttonSearch = driver.findElements(By.name("//h4"));

        WebElement logoRozetkaCss = driver.findElement(By.cssSelector("a.header__logo"));
        WebElement buttonSearcgCss = driver.findElement(By.cssSelector("form > button"));
        WebElement userButtonCss = driver.findElement(By.cssSelector("rz-user > button"));

        WebElement logoRztkXpath = driver.findElement(By.xpath("//a[@class=\"header__logo\"]"));
        WebElement buttonSearcXpath = driver.findElement(By.xpath("//form/button"));
        WebElement userButtonXpath = driver.findElement(By.xpath("//rz-user/button"));

    }
}
