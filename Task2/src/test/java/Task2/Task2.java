package Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {

    @Test
    public void AmaysimTest() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver with the options
        WebDriver driver = new ChromeDriver();

        Actions action = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://www.amaysim.com.au/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Your test code here
        String title = driver.getTitle();
        System.out.print(title);

        driver.findElement(By.xpath("(//span[contains(text(),'SIM plans')])")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//a[@class='btn no-icon btn-orange'][normalize-space()='Buy now'])[11]")).click();

        Thread.sleep(15000);
        driver.findElement(By.xpath("//span[@class='css-15xa8x'][normalize-space()='pick a new number']")).click();
        driver.findElement(By.xpath("//div[@class='css-1vy9u2m']//div[@class='css-ikyri5']//*[name()='svg']//*[name()='path' and contains(@d,'M8.97358 2')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='css-1tisfka'])")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='css-166c2yt']//label[1]//div[1]//*[name()='svg']")).click();
        driver.findElement(By.xpath("(//input[@id='field-input--4'])")).sendKeys("Test");
        driver.findElement(By.xpath("(//input[@id='field-input--5'])")).sendKeys("Test");
        driver.findElement(By.xpath("(//input[@id='field-input--6'])")).sendKeys("21111988");
        driver.findElement(By.xpath("(//input[@id='field-input--7'])")).sendKeys("jefferson.oquendo09@gmail.com");
        driver.findElement(By.xpath("(//input[@id='field-input--8'])")).sendKeys("test@12345");
        driver.findElement(By.xpath("(//input[@id='field-input--9'])")).sendKeys("0412345678");
        driver.findElement(By.xpath("(//input[@id='field-input--16'])")).sendKeys("Level 6, 17-19 Bridge St, SYDNEY NSW 2000");
        driver.findElement(By.xpath("(//li[@id='react-autowhatever-1--item-0'])")).click();

        WebElement paymentHeader = driver.findElement(By.id("payments-header-name"));
        jse.executeScript("arguments[0].scrollIntoView(true);", paymentHeader);
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='payment-element']//iframe")));
        driver.findElement(By.xpath("(//div[@aria-label='Payment Methods'])//button")).click();
        driver.findElement(By.xpath("(//input[@id='Field-numberInput'])")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.xpath("(//input[@id='Field-expiryInput'])")).sendKeys("0127");
        driver.findElement(By.xpath("(//input[@id='Field-cvcInput'])")).sendKeys("123");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//div[@class='css-c5g9lg']//div[@class='css-1417z9a']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='pay now']")).click();

        //Assert - Credit Card payment failed
        WebElement ErrorMessage = driver.findElement(By.xpath("//span[contains(text(),'Your attempt to pay via Credit Card has failed.')]"));
        String ExpectedErrorMessage = "Your attempt to pay via Credit Card has failed. Please ensure you have enough funds and try again or use another credit card.";
        Assert.assertEquals(ErrorMessage.getText(),ExpectedErrorMessage);
        System.out.println(ErrorMessage.getText());
        System.out.println(ExpectedErrorMessage);

        // Close the browser
        //driver.quit();
    }
}
