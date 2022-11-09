package lessons.lesson29.po_selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    MainPageLogic mainPageLogic = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.headless = true;
        // 1. Открыть https://rozetka.com.ua/
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest() {
        mainPageLogic
                .checkCategoryQuantity(16)
                .clickOnCategory(mainPageLogic.compAndLaptopCategory)
                .clickOnCategory(new CategoryPageLogic().laptop)
                .checkProductQuantity(60);

    }
}
