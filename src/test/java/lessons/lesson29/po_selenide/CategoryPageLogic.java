package lessons.lesson29.po_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CategoryPageLogic extends CategoryPageElement{
    public SearchPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return  Selenide.page(SearchPageLogic.class);
    }
}