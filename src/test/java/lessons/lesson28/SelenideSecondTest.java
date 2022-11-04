package lessons.lesson28;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSecondTest {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
      //  Configuration.timeout = 6000;
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest() {
        $(By.name("search"))
                .setValue("Mac");
        // на странице
        // в доме
        // невидимый
        $(By.xpath("//button[contains(@class, 'button_color_green')]"))
                .shouldBe(visible) // на странице
                .shouldBe(exist) // в доме
                .shouldBe(disappear) // невидимый
                .shouldHave(text("Найти"), Duration.ofSeconds(10))
                .shouldNotHave(text("Alex"))
                .shouldNotHave(value("Поиск в Google"))
                .shouldHave(type("Checkbox"))
                .shouldHave(attribute("required"))
                .click();
        sleep(5000);
    }
}
