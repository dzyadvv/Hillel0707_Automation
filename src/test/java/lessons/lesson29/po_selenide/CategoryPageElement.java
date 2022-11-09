package lessons.lesson29.po_selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPageElement {
    SelenideElement laptop = $(By.xpath("//ul[contains(@class,'grid_type_1_6')][1]//li[1]"));
}
