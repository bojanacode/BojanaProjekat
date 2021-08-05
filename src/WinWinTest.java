import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class WinWinTest {

    public String NotificationsAndHover = "https://www.winwin.rs";
    public String SelectBelaTehnika = "https://www.winwin.rs/bela-tehnika.html";
    public String SelectVesMasina = "https://www.winwin.rs/bela-tehnika/ves-masine.html";
    public String SelectItemInCart = "https://www.winwin.rs/bela-tehnika/ves-masine/masine-za-pranje-vesa.html";
    public String SelectedItemForm = "https://www.winwin.rs/checkout/onepage/";
    public String setupUrl;
    public String takeScreenshot;
    private Object LogInForm;
    public String LogInInvalid;
    public String ValidEmailInvalidPassword;

    public WinWinTest() {

    }

// Test case : Verify the products menu dropbox while user hover on
// Test steps: 1. Navigate to www.winwin.rs
//             2. Select the drop down menu "Proizvodi"
//             3. Select „TV, Audio, video“
// Expected result:
// Successful selection and navigation, letters in products dropbox changes color while selected


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


    // Test case : Verify correct products images are shown when selected category
// Test steps: 1. Navigate to www.winwin.rs
//             2. Select the drop down menu "Proizvodi"
//             3. Select „Bela tehnika“
//             4.Select " veš mašine"
//             5.Select " Mašine za pranje veša"
//
// Expected result:
// Products images are shown
    @Test

    public void SelectBelaTehnika() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SelectBelaTehnika);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a/span[1]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a/span")).click();
        String URL = driver.getCurrentUrl();
        if (URL.contains("masine-za-pranje-vesa")) {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        } else {
            System.out.println("Landed in wrong URL");

        }
        driver.quit();
    }


    //    Test case : Verify the chosen product is in the shopping cart
//    Test steps: 1. Navigate to www.winwin.rs
//            2. Select the drop down menu "Proizvodi"
//            3. Select „Bela tehnika“
//            4.Select " veš mašine"
//            5.Select " Mašine za pranje veša"
//            6.Click first item image
//            7.Click "dodaj u korpu" button
//Expected result:
//   Chosen item is in the shopping cart
    @Test

    public void SelectItemInCart() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SelectItemInCart);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        driver.findElement(By.cssSelector("#mm-0 > div > div.main-container.col2-left-layout > div > div.main > div.col-main > div.seg-reco-wrapper.seg-clear > div > div > div.owl-stage-outer > div > div:nth-child(9) > div > h3 > a")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();
        String URL = driver.getCurrentUrl();
        if (URL.contains("cart")) {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        } else {
            System.out.println("Landed in wrong URL");

        }

        driver.quit();

    }

//   Test case : Verify the registration form or log in option is shown
//   Test steps: 1. Navigate to www.winwin.rs
//               2. Select the drop down menu "Proizvodi"
//               3. Select „Bela tehnika“
//               4.Select " veš mašine"
//               5.Select " Mašine za pranje veša"
//               6.Click first item image
//               7.Click "dodaj u korpu" button
//               8.Click "idi na kasu" button
//
//   Expected result:
//   Registration form or log in option blank fields to choose and fill in are displayed


    @Test

    public void SelectItemForm() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SelectItemInCart);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        driver.findElement(By.cssSelector("#mm-0 > div > div.main-container.col2-left-layout > div > div.main > div.col-main > div.seg-reco-wrapper.seg-clear > div > div > div.owl-stage-outer > div > div:nth-child(9) > div > h3 > a")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();
        driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div/div[2]/div/div/div[1]/div[2]/div[1]/ul/li/button")).click();
        String URL = driver.getCurrentUrl();

        if (URL.contains("onepage")) {
            System.out.println("Landed in correct URL" +
                    "" + URL);

        } else {
            System.out.println("Landed in wrong URL");

        }
        driver.quit();

    }

    //   Test case : Customer log in form using valid credentials
//   Test steps: 1. Navigate to www.winwin.rs/customer/account/login
//               2. Filling in username field
//               3. Filling in password field
//               4. Clicks on submit button
//               5. Navigates to user account page
// Expected result:
// User is logged in  and user account page is visible
    @Test

    public void LogIn() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.winwin.rs/customer/account/login/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        //closes push notification
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        //fills in username and password fields
        driver.findElement(By.cssSelector("#email")).sendKeys("bojanasav@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("12345Kako");
        //clicks on submit button
        driver.findElement(By.cssSelector("#send2")).click();
        String location = driver.getCurrentUrl();

        Assert.assertEquals("https://www.winwin.rs/customer/account/", location);
        driver.quit();

    }



//   Test case : Customer log in form using invalid credentials
//   Test steps: 1. Navigate to www.winwin.rs/customer/account/login
//               2. Enter random text in username field
//               3. Enter  random text in password field
//               4. Clicks on submit button
//               5. Navigates to user account page
// Expected result:
// User is not logged in  and error message is shown

    @Test

    public void LogInInvalid  () {

    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.winwin.rs/customer/account/login/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.manage().window().maximize();
    //closes push notification
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
    //fills in username and password fields
    driver.findElement(By.cssSelector("#email")).sendKeys("salala@gmail.com");
    driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
    //clicks on submit button
    driver.findElement(By.cssSelector("#send2")).click();
        String location = driver.getCurrentUrl();

        Assert.assertEquals("https://www.winwin.rs/customer/account/login/", location);
    driver.quit();
}

//   Test case : Customer log in form using valid email address and invalid password
//   Test steps: 1. Navigate to www.winwin.rs/customer/account/login
//               2. Filling in username field
//               3. Enter random text in password field
//               4. Clicks on submit button
//               5. Navigates to user account page
// Expected result:
// User is not logged in  and error message is shown

    @Test

    public void ValidEmailInvalidPassword  () {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.winwin.rs/customer/account/login/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        //closes push notification
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/button[2]")).click();
        //fills in username and password fields
        driver.findElement(By.cssSelector("#email")).sendKeys("bojanasav@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        //clicks on submit button
        driver.findElement(By.cssSelector("#send2")).click();
        String location = driver.getCurrentUrl();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        Assert.assertEquals("https://www.winwin.rs/customer/account/login/", location);
        driver.quit();
    }
}


















