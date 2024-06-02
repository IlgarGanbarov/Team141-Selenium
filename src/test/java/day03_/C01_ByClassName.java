package day03_;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        // 1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("Wewbdriver.chrome.driver","resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



      // 2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com");
      // 3- arama kutusuna phone yazip aratin
        WebElement aramakutusu=driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone"+ Keys.ENTER);

      // 4- Category bolumunde 8 element oldugunu test edin

        List<WebElement>categoryElementlerList=driver.findElements(By.className("panel-list"));

        // 5- Category isimlerini yazdirin
        //System.out.println(categoryElementlerList);

        for (WebElement eachElement:categoryElementlerList){
            System.out.println(eachElement.getText());
        }

        //arama sonucunda bulunan elementlerin ismini yazdirin

       // List<WebElement> urunisimElementlerListes=driver.findElements( By.className("prod-title mb-3"));
        //System.out.println(urunisimElementlerListes);



      // 6- Sayfayi kapatin
        Thread.sleep(300);
        driver.quit();
    }
}
