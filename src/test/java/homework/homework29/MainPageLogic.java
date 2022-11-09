package homework.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic {

    SelenideElement compAndLaptopCategory = $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a"));

    public CategoryPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return page(CategoryPageLogic.class);
    }

}
