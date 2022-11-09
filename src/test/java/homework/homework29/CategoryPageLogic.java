package homework.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic {

    SelenideElement laptops = $(byXpath("//*[contains(@href, 'c80004')]"));

    public ProductPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return page(ProductPageLogic.class);
    }
}
