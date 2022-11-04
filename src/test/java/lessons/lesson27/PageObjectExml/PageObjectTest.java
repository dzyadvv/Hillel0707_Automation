package lessons.lesson27.PageObjectExml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class PageObjectTest {
//    На главной странице в инпут поиск ввести Мас
//    Сохранить тайтл первого товара в поисковой выдаче
//    Перейти на продуктовую страницу первого товара
//    Проверить, что тайтл на поисковой выдаче соответсвует тайтлу на продктовой странице

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }


//    @Test
//    public void rozetkaTest() throws InterruptedException, IOException {
//        new MainPageLogic(driver, wait)
//                .typeTextToSearchInput("Mac")
//                .clickFindBtn();
//        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);
//        String titleFromSearchPage = searchPageLogic.firstProductTitleText();
//        searchPageLogic.clickOnFirstProduct();
//        String titleTextFromProductPage = new ProductPageLogic(driver, wait).getTitleText();
//
//        assertEquals(titleFromSearchPage, titleTextFromProductPage);
//    }


    @AfterTest
    public void after() {
        driver.quit();
    }

}
