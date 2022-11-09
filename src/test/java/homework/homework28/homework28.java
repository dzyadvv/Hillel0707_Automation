package homework.homework28;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class homework28 {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        // 1. Открыть https://rozetka.com.ua/
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void bucketTest() {

        // 2. Перейти в раздел «Компьютеры и ноутбуки»
        $(byXpath("//ul[contains(@class, 'menu-categories_')]/li[1]/a")).click();

        // 3. Перейти в раздел « Ноутбуки»
        $(byXpath("//*[contains(@href, 'c80004')]")).click();

        // 4. Добавить первый товар в корзину
        SelenideElement productTitle = $(byXpath("//li[1]//span[@class='goods-tile__title']"));
        String textOfProductTitle = productTitle.text();

        $(byXpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]//button[contains(@class, 'buy-button')]")).click();

        // 5. Проверить что в корзину добавился один товар
        $(byXpath("//span[contains(@class,'counter--green')]")).shouldHave(text("1"));
        sleep(3000);

        // 6. Перейти в корзину и проверить, что добавился правильный товар
        $(byXpath("//li[contains(@class,'item--cart')]")).click();
        $(byXpath("//a[contains(@class,'cart-product__title')]")).shouldHave(text(textOfProductTitle));
        sleep(3000);

        ElementsCollection elements = $$(By.name(""));
        elements.shouldHave(CollectionCondition.size(3));

        elements.filterBy(Condition.text("цена"));
        elements.get(0).click();
        elements.filterBy(Condition.text("88.0"));


    }
}
