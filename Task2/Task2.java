package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver with the options
        WebDriver driver = new ChromeDriver();

        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://www.amaysim.com.au/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Your test code here
        String title = driver.getTitle();
        System.out.print(title);

        WebElement SIMPlansButton = driver.findElement(By.xpath("(//span[contains(text(),'SIM plans')])[1]"));
        SIMPlansButton.click();
        WebElement SevenDayBuyButton = driver.findElement(By.xpath("(//a[@class='btn no-icon btn-orange'][normalize-space()='Buy now'])[11]"));
        SevenDayBuyButton.click();

//        //TestCase #2 - forgot password
//        WebElement IAgreeButton = driver.findElement(By.id("cookie-notification-accept"));
//        IAgreeButton.click();
//        WebElement loginButton = driver.findElement(By.xpath("//button[@class='o-button--text o-button--text-login js-modal__trigger']"));
//        loginButton.click();
//        WebElement forgotPasswordButton = driver.findElement(By.xpath("//a[@class='o-button o-button--text o-button--text-password js-modal__trigger']"));
//        forgotPasswordButton.click();
//        WebElement closePasswordButton = driver.findElement(By.xpath("//div[@id='js-modal']//div[@class='c-modal__close']"));
//        closePasswordButton.click();

        //TestCase #3 - register
//        WebElement IAgreeButton = driver.findElement(By.id("cookie-notification-accept"));
//        IAgreeButton.click();
//        WebElement loginButton = driver.findElement(By.xpath("//button[@class='o-button--text o-button--text-login js-modal__trigger']"));
//        loginButton.click();
//        WebElement registerButton = driver.findElement(By.id("registerButton"));
//        registerButton.click();
//        Thread.sleep(2000);
//        WebElement homeButton = driver.findElement(By.xpath("//a[@href='https://smtickets.com/' and @class='o-logo'][1]"));
//        homeButton.click();

        //TestCase #4 - successful login
//        WebElement IAgreeButton = driver.findElement(By.id("cookie-notification-accept"));
//        IAgreeButton.click();
//        WebElement loginButton = driver.findElement(By.xpath("//button[@class='o-button--text o-button--text-login js-modal__trigger']"));
//        loginButton.click();
//        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
//        username.sendKeys("sonson_o.");
//        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("I<3OhmPawat09");
//        WebElement EnterButton = driver.findElement(By.id("loginButton"));
//        EnterButton.click();
//        Thread.sleep(3000);
//        WebElement profileMenu = driver.findElement(By.xpath("//button[@id='js-account']"));
//        action.moveToElement(profileMenu).perform();
//        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='https://smtickets.com/users/logout'][1]"));
//        logoutButton.click();

        //TestCase #5 - login not successful (wrong credentials)
        WebElement IAgreeButton = driver.findElement(By.id("cookie-notification-accept"));
        IAgreeButton.click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='o-button--text o-button--text-login js-modal__trigger']"));
        loginButton.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("test123456");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("test123456");
        WebElement EnterButton = driver.findElement(By.id("loginButton"));
        EnterButton.click();

        // Close the browser
        //driver.quit();
    }
}

//driver.findElement(By.id("name")).click;