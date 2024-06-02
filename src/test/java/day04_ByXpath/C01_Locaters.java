package day04_ByXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locaters {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/ ");
        //2- Add Element butonuna basin

        driver.findElement(By.xpath("//button[text()='Add']"))
                .click();
        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButtonu= driver.findElement(By.xpath("//*[text()='Remove']"));

        if (removeButtonu.isDisplayed()){
            System.out.println("Remove buttonu testi PASSED");
        }else {
            System.out.println("Remove buttonu testi FAILED");
        }
        //4- Remove tusuna basin

        removeButtonu.click();
        //5- “Add/Remove Element"s” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYazisiElementi=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYazisiElementi.isDisplayed()){
            System.out.println("AddRemove buttonu testi PASSED");
        }else {
            System.out.println("AddRemove buttonu testi FAILED");
        }




        Thread.sleep(3000);

        driver.quit();


    }
}
