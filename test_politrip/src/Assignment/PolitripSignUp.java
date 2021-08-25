package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PolitripSignUp {
    ChromeDriver driver;

    String url = "https://politrip.com/account/sign-up";


    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(url);

        String urlFromWebPage = driver.getCurrentUrl();


        if (urlFromWebPage.equals("https://politrip.com/account/sign-up")) {
            System.out.println("PASS. Driver get current URL ");
        } else {
            System.out.println("FAIL");
        }

    }

    public void SignUp() {

        //This test will verify that Heading of the page is the same that in requirements.

        WebElement SignUpAccountHeading = driver.findElement(By.xpath("//span[text()='Sign up']"));


        if (SignUpAccountHeading.isDisplayed()) {
            System.out.println("PASS. The Heading of the page is the same that in requirements");
        } else
            System.out.println("FAIL");


    }

    public void TestData() throws InterruptedException {

        //This test will verify that the system don't allow the passwords that contains just one symbol.

        driver.findElement(By.id("first-name")).sendKeys("Victoria");
        driver.findElement(By.id("last-name")).sendKeys("Lungu");
        driver.findElement(By.id("email")).sendKeys("victoria99lungu@gmail.com");
        driver.findElement(By.id("sign-up-password-input")).sendKeys("1");
        driver.findElement(By.id("sign-up-confirm-password-input")).sendKeys("1");


        WebElement PasswordAlert = driver.findElement(By.className("form-input-hint"));
        if (PasswordAlert.isDisplayed()) {
            System.out.println("PASS. The application don't allow passwords that contain only one symbol. ");
        } else
            System.out.println("FAIL");

        Thread.sleep(1000);
    }

    public void clearData() {
        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("sign-up-password-input")).clear();
        driver.findElement(By.id("sign-up-confirm-password-input")).clear();
    }

    public void EmptyData() throws InterruptedException {

        //This test will check if the user cannot register with the First Name empty

        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("last-name")).sendKeys("Lungu");

        WebElement FirstNameEmpty = driver.findElement(By.className("form-input-hint"));
        if (FirstNameEmpty.isDisplayed()) {
            System.out.println("PASS. The system don't allow empty First Name");
        } else
            System.out.println("FAIL");

        Thread.sleep(1000);
    }

    public void EmptyData2() throws InterruptedException {

        //This test will check if the user cannot register with the Last Name empty

        Thread.sleep(2000);
        driver.findElement(By.id("first-name")).sendKeys("Victoria");
        driver.findElement(By.id("last-name")).sendKeys("");
        driver.findElement(By.id("email")).sendKeys("victoria99lungu@gmail.com");


        WebElement LastNameEmpty = driver.findElement(By.className("form-input-hint"));

        if (LastNameEmpty.isDisplayed()) {
            System.out.println("PASS. The system don't allow empty Last Name");
        } else
            System.out.println("FAIL");

        Thread.sleep(2000);
        driver.close();

    }


    public static void main(String[] args) throws InterruptedException {
        PolitripSignUp PS = new PolitripSignUp();

            PS.invokeBrowser();
            PS.SignUp();
            PS.TestData();

            PS.clearData();

            PS.EmptyData();

            PS.clearData();

            PS.EmptyData2();
    }
}






//    WebElement AboutUs = driver.findElement(By.id("sign-up-heard-input"));
//    Select AboutUsDropDown = new Select(AboutUs);
//        AboutUsDropDown.selectByVisibleText("Web-Search");
//
//        driver.findElement(By.id("qa_loader-button")).click();