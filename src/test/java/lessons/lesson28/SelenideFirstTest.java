package lessons.lesson28;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstTest {

    @BeforeMethod
    public void before(){
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest(){
        $(By.name("search"))
                .setValue("Mac")
                .pressEnter();
        sleep(5000);
    }
}
