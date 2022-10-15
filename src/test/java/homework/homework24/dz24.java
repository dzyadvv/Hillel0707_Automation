package homework.homework24;

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

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class dz24 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1. Перейти на https://rozetka.com.ua/
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {

        //2. В сайд меню перейти в раздел Ноутбуки и компьютеры
        WebElement categoryNote = driver.findElement(By.xpath("//ul/li[1]/a[@class='menu-categories__link']"));
        categoryNote.click();

        //3. Перейти в категорию Ноутбуки
        WebElement titleNotebook = driver.findElement(By.xpath("//a[@title='Ноутбуки']"));
        titleNotebook.click();

        //4. Примерить фильтр "Продавец" Rozetka
        WebElement chooseBayer = wait.
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-id='Rozetka']")));
        chooseBayer.click();

        //5. Примерить фильтр "Цена" установть цену до - 100000
        WebElement maxPrice = wait.
                until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='max']")));
        maxPrice.click(); // через раз срабатывает
        maxPrice.clear(); // через раз срабатывает
        maxPrice.sendKeys("100000");
        WebElement buttonOk = driver.findElement(By.xpath("//button[contains(@class, 'button_color_gray')]"));
        buttonOk.click();

        //6.Перейти на продуктовую первого товара с плашкой " ТОП ПРОДАЖІВ"
        WebElement topSells = driver.findElement(By.xpath("//span[contains(@class, 'promo-label_type_popularity')]//..//.."));
        topSells.click();

        //7. Проверить что на продуктовой странице отображается плашка " ТОП ПРОДАЖІВ"
        WebElement labelPromoTop = driver.findElement(By.xpath("//span[contains(@class, \"promo-label_type_popularity\")]"));
        assertTrue(labelPromoTop.isDisplayed(), "LabelPromoTop doesn't appeared.");

    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}
