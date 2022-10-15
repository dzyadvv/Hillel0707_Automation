package lessons.lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RozetkaFirstTest {

    final String EXPECTED_TITLE = "Комп'ютер Apple Mac Studio M1 Ultra/48 ядер GPU/64GB/1TB";

    private WebDriver driver;

//    @BeforeTest
//    public void setUpTest(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest(){

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement buttonSearch = driver.findElement(By.xpath
                ("//button[contains(@class, 'button_color_green')]"));
        buttonSearch.click();

        WebElement firstProduct = driver.findElement(By.xpath
                ("//span[@class='goods-tile__title']"));
        String titleOfFirstProduct = firstProduct.getText().trim();

        Assert.assertEquals(titleOfFirstProduct, EXPECTED_TITLE, "title doesn't contains Mac");


//        if (titleOfFirstProduct.contains("Mac")){
//            System.out.println("Success");
//        } else {
//            Assert.fail("title doesn't contains Mac");
//        }

    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}
