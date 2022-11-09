package lessons.lesson29;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SelenideMethodsExample {
    @BeforeMethod
    public void before() {
        Configuration.headless = true;
        // 1. Открыть https://rozetka.com.ua/
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void example(){
        String currentUrl = url();
        System.out.println(currentUrl);

        String source = source();
        System.out.println(source);
    }

}
