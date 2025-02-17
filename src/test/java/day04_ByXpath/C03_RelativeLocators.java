package day04_ByXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       /*
            Relative locator selenium 4 ile tanitilan yeni bir ozellik

            EGER
            bir webElement'i gordugumuz ve HTML kodlarina ulastigimiz halde
            locate'imiz calismiyor ve webElement'i kullanamiyorsak

            ve etrafinda kullanabildigimiz baska webElementler varsa

            bu webelementi ulastigimiz bir bilgisi ve
            etrafindaki kullanabildigimiz webElementler sayesinde kullanabiliriz

            WebElement abc = elementin id'si "idAbc" ve suResmin altinda
         */



        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin

        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

        // relative locater'i kullanmak icin
        // A- kullanmak istediginiz webElement'e ait bir locate bilgisi
        //    <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
        //    biz id = "pic7_thumb" kullanalim


        // B- etrafinda kullanilabilecek bir webElement'e ihtiyacimiz var
        WebElement appleKullaklik = driver.findElement(By.xpath("//*[@id='pic6_thumb']"));

        WebElement dslrCamera1 = driver.findElement(
                RelativeLocator.with(By.id("pic7_thumb"))
                        .toRightOf(appleKullaklik)
        );

        dslrCamera1.click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsim = "DSLR Camera";
        String actualisim = urunIsimElementi.getText();

        if (expectedIsim.equals(actualisim)){
            System.out.println("DSLR camera testi PASSED");
        }else  System.out.println("DSLR camera testi FAILED");

        Thread.sleep(3000);

        // ============================
        // geriye donup baska bir komsusuyla bir kere daha locate edelim
        // BatKulakligin altinda diyelim

        driver.get("https://testotomasyonu.com/relativeLocators");

        // relative locator icin 2 bilgiye ihtiyac var

        // A- kullanmak istedigimiz webElementin locate blgisine
        //    biz tagName = 'img' kullanalim

        // B- etrafinda kullanabilecegimiz bir WebElement

        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera2 = driver.findElement(
                RelativeLocator.with(By.tagName("img"))
                        .below(batKulaklik)
        );

        dslrCamera2.click();

        /*
            StaleElementReferenceException

            daha onceden locate edip kullandigimiz bir WebElementi
            baska sayfalara gittikten sonra yeniden kullanmak istedigimizde olusur

            Selenium bize "tamam o elementi locate etmistin ama
            o islemden sonra coook sey degisti, senin locate bayatladi" der
         */
        urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        expectedIsim = "DSLR Camera";
        actualisim = urunIsimElementi.getText();

        if (expectedIsim.equals(actualisim)){
            System.out.println("DSLR camera testi PASSED");
        }else  System.out.println("DSLR camera testi FAILED");







        Thread.sleep(3000);
        driver.quit();
    }

    }

