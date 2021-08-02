import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SnimciEkrana extends WinWinTest {
    @BeforeTest
    public void setupUrl() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.winwin.rs/");
        TakesScreenshot screenshot =((TakesScreenshot)driver);
        this.takeScreenshot(driver,"C:\\Users\\PC\\Desktop\\SnimciWinWin" ) ;
    }

    @Test
    public void NotificationsAndHover() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.winwin.rs/");
        driver.manage().window().maximize();
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
        if (URL.contains("winwin")) {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        } else {
            System.out.println("Landed in wrong URL");

        }
        driver.quit();

    }


    @AfterTest
    public void takeScreenshot(ChromeDriver driver, String s) throws IOException, InterruptedException {
        //take screenshot of the page

        TakesScreenshot screenshot =((TakesScreenshot)driver);
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            File DestFile=new File("C:\\Users\\PC\\Desktop\\SnimciWinWin");
            FileUtils.copyFile(src, new File("C:\\Users\\PC\\Desktop\\SnimciWinWin"));
        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("Screenshot is captured");
            driver.quit();
        }     }


}
