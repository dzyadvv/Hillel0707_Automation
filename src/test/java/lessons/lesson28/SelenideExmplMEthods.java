package lessons.lesson28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideExmplMEthods {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        //  Configuration.timeout = 6000;
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest(){
        SelenideElement findBtn = $(byXpath("//button[contains(@class, 'button_color_green')]"));
        String textFromFindBtn = findBtn.text();
      //  String textFromFindBtn2 = findBtn.getText();
        System.out.println(textFromFindBtn);

        String formActionAttrFromFindBtn = findBtn.attr("formAction");
        System.out.println(formActionAttrFromFindBtn);

        String backGroundFromFindBtn = findBtn.getCssValue("background-color");
        System.out.println(backGroundFromFindBtn);
    }
}