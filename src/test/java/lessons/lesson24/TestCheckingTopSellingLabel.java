package lessons.lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestCheckingTopSellingLabel {


    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws InterruptedException {
        WebElement laptopsAndComp = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a"));
        laptopsAndComp.click();

        WebElement laptops = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
        laptops.click();

        By rozetkaSeller = By.xpath("//a[@data-id='Rozetka']");
        wait.until(ExpectedConditions.elementToBeClickable(rozetkaSeller));
        myClick(rozetkaSeller);

        WebElement rozetkaSellerLabel = driver.findElement(By.xpath("//a[@class='catalog-selection__link']"));
        wait.until(ExpectedConditions.elementToBeClickable(rozetkaSellerLabel));

        WebElement maxCost = driver.findElement(By.xpath("//div[@class='slider-filter__inner']/input[2]"));
        wait.until(ExpectedConditions.visibilityOf(maxCost));
        maxCost.clear();
        maxCost.sendKeys("100000");
        WebElement btnOk = driver.findElement(By.xpath("//div[@class='slider-filter__inner']/button"));
        btnOk.click();

        driver.navigate().refresh();

        By firstTopProduct = By.xpath("//span[contains(@class, 'promo-label_type_popularity')]/../a");
        wait.until(ExpectedConditions.elementToBeClickable(firstTopProduct));
        String urlOfFirstTopProduct  = driver.findElement(firstTopProduct)
                .getAttribute("href");
        myClick(firstTopProduct);

        wait.until(ExpectedConditions.urlToBe(urlOfFirstTopProduct));
        WebElement topLabelOnProductPage = driver.findElement(By.xpath("//span[contains(@class, 'promo-label_type_popularity')]"));
        Assert.assertTrue(topLabelOnProductPage.isDisplayed());
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

    public void myClick(By element) {
        try {
            driver.findElement(element).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.print("HERE " + element);
            driver.findElement(element).click();
        }
    }
}

