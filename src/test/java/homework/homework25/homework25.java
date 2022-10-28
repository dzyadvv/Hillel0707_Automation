package homework.homework25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class homework25 {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1. Перейти на https://rozetka.com.ua/
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {

        //2. В сайд меню перейти в раздел Ноутбуки и компьютеры
        WebElement categoryNote = driver.findElement(By.xpath("//ul[contains(@class, 'menu-categories_')]/li[1]/a"));
        categoryNote.click();

        //3. Перейти в категорию Ноутбуки
        WebElement titleNotebook = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
        titleNotebook.click();

        // Текст товара
        WebElement firstProduct = driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
        String firstProductTitle = firstProduct.getText();

        //4. Добавить первый товар в корзину
        WebElement buyButton = driver.findElement(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]//button[contains(@class, 'buy-button')]"));
        buyButton.click();

        //5. Проверить что в корзину добавился один товар
        WebElement buyCounter = driver.findElement(By.xpath("//span[contains(@class,'counter--green')]"));
        String buyCounterValue = buyCounter.getAttribute("innerText").trim();

        Assert.assertEquals(buyCounterValue, "1", "There is no goods in cart");

        //6. Перейти в корзину и проверить, что добавился правильный товар
        WebElement cartButton = driver.findElement(By.xpath("//li[contains(@class,'item--cart')]"));
        cartButton.click();

        WebElement cartProduct = driver.findElement(By.xpath("//a[contains(@class,'cart-product__title')]"));
        String cartProductTitle = cartProduct.getText();

        Assert.assertEquals(cartProductTitle, firstProductTitle, "Titles don't match");


    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}

