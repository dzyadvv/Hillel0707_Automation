package homework.homework27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class homework27 {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Перейти на https://rozetka.com.ua/
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws IOException, InterruptedException {

        //  Проверить, что в блоке Акционные предложения отображается 6 товаров
        List<WebElement> promoGoods = driver.findElements(By.xpath("//*[text()=' Акційні пропозиції ']/../ul/*"));
        int countOfGoods = promoGoods.size();
        assertEquals(countOfGoods, 6, "quantity doesn't match");

        //  Сохранить цену первого товара
        WebElement priceOfFirstProduct = driver.findElement(By.xpath("//*[text()=' Акційні пропозиції ']/../ul/li[1]//span[@class='tile__price-value']"));
        String priceOfFirstProductValue = priceOfFirstProduct.getAttribute("innerText").trim();

        //  Перейти на продуктовую первого товара и проверить, что цена совпадает с сохраненной
        WebElement goToFirstProduct = driver.findElement(By.xpath("//*[text()=' Акційні пропозиції ']/../ul/li[1]"));
        goToFirstProduct.click();

        WebElement priceOfProduct = driver.findElement(By.xpath("//p[1][contains(@class, 'product-prices')][1]"));
        String priceOfProductValue = priceOfProduct.getText().replace("₴", "");
        Assert.assertEquals(priceOfProductValue, priceOfFirstProductValue, "prices don't match");

        //  Вернуться на главную страницу (проверка URL)
        driver.navigate().back();
        String urlOfPage = driver.getCurrentUrl();
        // System.out.println(urlOfPage);
        Assert.assertEquals(urlOfPage, "https://rozetka.com.ua/ua/", "url doesn't match");

        //  Проверить, что в блоке Акционные предложения отображается 6 товаров
        assertEquals(countOfGoods, 6, "quantity after returning doesn't match");

    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}

