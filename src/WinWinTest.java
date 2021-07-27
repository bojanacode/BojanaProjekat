import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.x509.URIName;

import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import static org.checkerframework.checker.units.UnitsTools.mm;
import static org.junit.Assert.assertEquals;


public class WinWinTest {
    public String NotificationsAndHover = "https://www.winwin.rs";
    public String SelectBelaTehnika = "https://www.winwin.rs/bela-tehnika.html";
    public String SelectVesMasina = "https://www.winwin.rs/bela-tehnika/ves-masine.html";
    public String SelectItemInCart = "https://www.winwin.rs/bela-tehnika/ves-masine/masine-za-pranje-vesa.html";
    public String SelectedItemForm = "https://www.winwin.rs/checkout/onepage/";

    public WinWinTest() {

    }
// Ovaj test izvrsava verifikaciju odabira kategorije i promenu boje teksta u selektovanoj podkategoriji, tako sto
// gasi pushup Notifikacije i otvara kategoriju Proizvodi na sajtu, zatim prelazi na Tv, Video i Audio komponentu
// kada se prilikom odabira boja podkategorije na meniju menja

    @Test
    public void NotificationsAndHover() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.winwin.rs/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        String currentURL = driver.getCurrentUrl();

        driver.get("https://www.winwin.rs/");
        driver.findElement(By.cssSelector("#menu > ul > li.menu-item.catalog.overlay-effect > dl > dt > h2")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String URL = driver.getCurrentUrl();
        if(URL.contains("winwin"))
        {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        }else
        {
            System.out.println("Landed in wrong URL");

        }
        driver.quit();

    }

    @Test
    //Ovaj test izvrsava verifikaciju prisustva slike proizvoda iz odabrane kategorije, tako sto iz kategorije proizvoda bira
    // podkategoriju Bela tehnika, gasi push notifikacije, zatim izabira sledecu
    // podkategoriju  Ves masine, iz ove podkategorije izabira sledecu Masine za pranje vesa kada se pravilno prikazuju
    //slike proizvoda
    public void SelectBelaTehnika() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SelectBelaTehnika);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a/span[1]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a/span")).click();
        String URL = driver.getCurrentUrl();
        if(URL.contains("masine-za-pranje-vesa"))
        {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        }else
        {
            System.out.println("Landed in wrong URL");

        }
        driver.quit();
    }





    @Test
    // Ovaj test potvrđuje da se željeni proizvod nalazi u korpi za kupovinu, tako što iz kategorije Masine za pranje
    // vesa vrsi odabir proizvoda, gasi push notifikacije i  proizvod stavlja  u korpu za kupovinu
    public void SelectItemInCart() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SelectItemInCart);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        driver.findElement(By.cssSelector("#mm-0 > div > div.main-container.col2-left-layout > div > div.main > div.col-main > div.seg-reco-wrapper.seg-clear > div > div > div.owl-stage-outer > div > div:nth-child(9) > div > h3 > a")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();
        String URL = driver.getCurrentUrl();
        if(URL.contains("cart"))
        {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        }else
        {
            System.out.println("Landed in wrong URL");

        }

        driver.quit();

    }

    @Test
    //Ovaj test potvrđuje prisustvo formulara za prijavu i registraciju posle odabira željenog artikla i stavljanja u korpu

    public void SelectItemForm (){
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SelectItemInCart);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        driver.findElement(By.cssSelector("#mm-0 > div > div.main-container.col2-left-layout > div > div.main > div.col-main > div.seg-reco-wrapper.seg-clear > div > div > div.owl-stage-outer > div > div:nth-child(9) > div > h3 > a")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();
        driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div/div[2]/div/div/div[1]/div[2]/div[1]/ul/li/button")).click();
        String URL = driver.getCurrentUrl();
        if(URL.contains("onepage"))
        {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        }else
        {
            System.out.println("Landed in wrong URL");

        }

        driver.quit();




    }
}
















