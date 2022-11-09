package homework.homework29;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainHomeworkRun {

    MainPageLogic mainPageLogic = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        // 1. Открыть https://rozetka.com.ua/
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void runTest(){
        mainPageLogic
                .clickOnCategory(mainPageLogic.compAndLaptopCategory)
                .clickOnCategory(new CategoryPageLogic().laptops)
                .clickBuyButton(new ProductPageLogic().buyButton)
                .productTitle(new ProductPageLogic().productTitle)
                .checkBasketIcon("1")
                .openBasket(new ProductPageLogic().basket)
                .checkTitle(new BasketLogic().titleOfProduct);
        Assert.assertEquals(BasketLogic.titleOfProductTextInBasket, ProductPageLogic.productTitleText);
    }
}
