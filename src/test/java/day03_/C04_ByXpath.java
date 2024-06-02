package day03_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ByXpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1- https://testotomasyonu.com/addremove/ adresine gidin

        driver.get("https://www.testotomasyonu.com/addremove/");
        //2- Add Element butonuna basin

       // WebElement addButonu=driver.findElement(By.xpath("////button[@id='sub-btn']"));
        driver.findElement(By.xpath("//button[@id='sub-btn']")).click();
        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu=driver.findElement(By.xpath("//button[@class='remove-btn']"));
        //4- Remove tusuna basin
        if (removeButonu.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("PASSED");
        }
        removeButonu.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveyazielementi=driver.findElement(By.tagName("h2"));
        if (addRemoveyazielementi.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }


        Thread.sleep(3000);

        driver.quit();
    }
}
