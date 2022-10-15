package lessons.lesson22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class firstTest {

//    @Test
//    public void currentTest(){
//        WebDriver driver = new ChromeDriver();
//       // driver.manage().timeouts().implicitlyWait(Duration.ofDays(1000));
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get("https://www.google.com.ua/");
//        driver.findElement(By.xpath("search")).click();


//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.google.com.ua/");
//        WebElement elementSearch = (new WebDriverWait(driver, Duration.ofSeconds(5)).
//                until(ExpectedConditions.presenceOfElementLocated(By.className("search"))));
//        elementSearch.click();;
//
//        driver.findElement(By.xpath("search")).click();


    @Test
    public void currentTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.google.com.ua/");
        WebElement elementSearch = wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("search")));
        elementSearch.click();

    }
}
