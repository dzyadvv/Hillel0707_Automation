package homework.homework26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class homework26 {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1. Перейти на https://rozetka.com.ua/
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws IOException {

        //2. В сайд меню перейти в раздел Ноутбуки и компьютеры
        WebElement categoryNote = driver.findElement(By.xpath("//ul[contains(@class, 'menu-categories_')]/li[1]/a"));
        categoryNote.click();

        //3. Перейти в категорию Ноутбуки
        WebElement titleNotebook = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
        titleNotebook.click();

       // 4. На странице поисковой выдачи собрать все тайтлы(название товаров) и цены товаров. (60 штук)
        List<WebElement> titleOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        int countOfGoods = titleOfGoods.size();
        assertEquals(countOfGoods, 60);
        List<String> titles = new ArrayList<>();
        for (WebElement element : titleOfGoods){
            titles.add(element.getText());
        }

        List<WebElement> pricesOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int countOfGoodsPrices = pricesOfGoods.size();
        assertEquals(countOfGoodsPrices, 60);
        List<String> prices = new ArrayList<>();
        for (WebElement element : pricesOfGoods){
            prices.add(element.getText());
        }

       // 5. Записать их в Map.
        Map<String, String> listOfGoods = new HashMap<>();
        for (int i = 0; i<titleOfGoods.size()-1; i++) {
            listOfGoods.put(titles.get(i), prices.get(i));
        }

       // 6. С помощью FileWriter записать данные с Map в файл rozetkaTest.txt
        FileWriter fileOfGoods = new FileWriter("rozetkaTest.txt");
        for (Map.Entry<String, String> entry : listOfGoods.entrySet()){
            fileOfGoods.write(entry.getKey() + " - " + entry.getValue()+ "\n");
        }
        fileOfGoods.close();

    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}

