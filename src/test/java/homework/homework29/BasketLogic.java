package homework.homework29;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasketLogic {
    static String titleOfProductTextInBasket;
    SelenideElement titleOfProduct = $(byXpath("//a[contains(@class,'cart-product__title')]"));

    public BasketLogic checkTitle(SelenideElement title){
        titleOfProductTextInBasket = title.text().trim();
        return page(BasketLogic.class);
    }

}
