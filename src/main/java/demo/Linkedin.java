package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class Linkedin {
    ChromeDriver driver;
    public Linkedin()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        //Navigate to linkedin
        driver.get("https://in.linkedin.com/");
        //Enter username "abc@gmail.com" Using Locator "XPath" //input[@id='session_key'] | sendkeys("abc@gmail.com")
        WebElement username = driver.findElement(By.xpath("//input[@id='session_key']"));
        username.sendKeys("sachin.164519@gmail.com");
        // Enter password "123456" Using Locator "XPath" //input[@id='session_password'] | sendkeys("123456")
        WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
        password.sendKeys("S@ch@164");
        // Click on sign in Using Locator "XPath" //button[contains(text(),'Sign in')]
        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signInBtn.click();
        Thread.sleep(3000);
        // Click on profile "Sachin Sahu" Using Locator "XPath" //div[contains(@class,'t-16')]
        WebElement profile = driver.findElement(By.xpath("//div[contains(@class,'t-16')]"));
        profile.click();
        // Validate number of profile view Using Locator "XPath" //span[contains(text(),'profile view')] | getText()
        WebElement profileView = driver.findElement(By.xpath("//span[contains(text(),'profile view')]"));
        System.out.println(profileView.getText());
        Thread.sleep(3000);
        // Click on home button Using Locator "Link Text" ("https://www.linkedin.com/feed/?nis=true")
        WebElement homeBtn = driver.findElement(By.xpath("//a[@class='app-aware-link '][1]"));
        homeBtn.click();
        // Select on start a post and enter text "Hello" Using Locator "XPath" //button[@id='ember1314'] | Hello
        WebElement post = driver.findElement(By.xpath("//button[contains(@class,'share-box-feed-entry__trigger')]"));
        post.click();
        Thread.sleep(2000);
        WebElement visiblity = driver.findElement(By.xpath("//button[contains(@class,'share-unified-settings-entry-button')]"));
        visiblity.click();
        Thread.sleep(2000);
        WebElement selOptions = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']"));
        selOptions.click();
        WebElement doneBtn = driver.findElement(By.xpath("//button[contains(@class,'share-box-footer__primary-btn')]"));
        doneBtn.click();
        Thread.sleep(2000);
        WebElement sendText = driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]"));
        sendText.sendKeys("Hello");
        Thread.sleep(2000);
        // Click on post Using Locator "XPath" //button[@id='ember1567']
        WebElement postBtn = driver.findElement(By.xpath("//button[contains(@class,'share-actions__primary-action')]"));
        postBtn.click();
        Thread.sleep(2000);
        // Validate the post in home page Using Locator "XPath" //span[contains(text(),'Hello')] | isDisplayed()
        WebElement verifyStatus = driver.findElement(By.xpath("//span[contains(text(),'Hello')]"));
        System.out.println("Status is present :"+verifyStatus.isDisplayed());

    }
}
