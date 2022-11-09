package homework.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductPageLogic {

    static String productTitleText;
    SelenideElement productTitle = $(byXpath("//li[1]//span[@class='goods-tile__title']"));
    SelenideElement buyButton = $(byXpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]//button[contains(@class, 'buy-button')]"));
    SelenideElement basketIcon = $(byXpath("//span[contains(@class,'counter--green')]"));
    SelenideElement basket = $(byXpath("//li[contains(@class,'item--cart')]"));

    public ProductPageLogic productTitle(SelenideElement title){
        productTitleText = title.text().trim();
        return page(ProductPageLogic.class);
    }

    public ProductPageLogic clickBuyButton(SelenideElement button){
        button.shouldBe(Condition.visible);
        button.click();
        return page(ProductPageLogic.class);
    }

    public ProductPageLogic checkBasketIcon(String basketIconText){
        this.basketIcon.shouldHave(Condition.text(basketIconText));
        return this;
    }

    public BasketLogic openBasket(SelenideElement basketButton){
        basketButton.shouldBe(Condition.visible);
        basketButton.click();
        return page(BasketLogic.class);
    }


}
