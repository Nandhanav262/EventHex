package eventhex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InstaSnapVisitorPage extends InstaSnapPage {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream");
		

	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            driver.get("https://app.eventhex.ai");

            
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailField.sendKeys("info@eventhex.ai");

            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("Admin@EventHex");

            WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
            loginBtn.click();

            //DashBoard
            wait.until(ExpectedConditions.urlContains("https://app.eventhex.ai/event"));

            // Go to Event
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640");
            
           //go to InstaSnap
            
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/insta-snap-dashboard");
            
            //domain
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/insta-domain"); 
            
         // Visit Link
            WebElement visitLinkBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Visit')]"))
            );
            visitLinkBtn.click();

            // Switch to the new tab 
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Get current URL
            String currentUrl = driver.getCurrentUrl();
            driver.get(currentUrl + "instasnap");
            
            driver.get("https://68abf3eec54d5f0247378640.eventhex.ai/instasnap/start"); 
            
         // click "Take Photo"
         WebElement takePhotoBtn = wait.until(
             ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Take Photo')]"))); 
             takePhotoBtn.click();
             driver.get("https://68abf3eec54d5f0247378640.eventhex.ai/instasnap/publiclogin");
             
             // Enter Phone Number
             WebElement phoneField = wait.until(
                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='phone']"))
             );
             phoneField.sendKeys("9746983352");
            
             // Enter Name
             WebElement nameField = wait.until(
                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']"))
             );
             nameField.sendKeys("Nandhana");

             // Tick the CheckBox
             WebElement termsCheckbox = wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
             termsCheckbox.click();
             
             driver.get("https://68abf3eec54d5f0247378640.eventhex.ai/instasnap/home");
             
             // Check if photos are available
             try {
                 WebElement photoCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                     By.xpath("//span[contains(text(),'Photos')]/preceding-sibling::span")
                 ));
                 
                 String photoCountText = photoCountElement.getText().trim();
                 int photoCount = Integer.parseInt(photoCountText);
                 
                 if (photoCount > 0) {
                     System.out.println(photoCount + " photos are displayed.");
                 } else {
                     System.out.println(" No photos found.Recheck...");
                     WebElement recheckBtn = driver.findElement(By.xpath("//button[contains(text(),'Recheck')]"));
                     recheckBtn.click(); 
                 }
             } catch (Exception e) {
                 System.out.println(" AI couldn't find any photos of you.");
             }
              
         } finally {
             // driver.quit();
         }
	}}

