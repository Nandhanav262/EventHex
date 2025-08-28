package eventhex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InstaSnapPage {
    public static void main(String[] args) {

        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Open Login Page
            driver.get("https://app.eventhex.ai");

            // Enter Email + Password
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailField.sendKeys("info@eventhex.ai");

            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("Admin@EventHex");

            WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
            loginBtn.click();

            // Wait for DashBoard to load
            wait.until(ExpectedConditions.urlContains("https://app.eventhex.ai/event"));

            // Go to Event
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640");
            
            //go to InstaSnap
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/insta-snap-dashboard");

            // Go directly to Upload Photos
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/upload-photos");
            
            // Upload multiple images
            WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']"))
            );

            fileInput.sendKeys(
            	    "C:\\Users\\USER\\OneDrive\\Desktop\\EventHex\\A.jpg\n" +
            	    "C:\\Users\\USER\\OneDrive\\Desktop\\EventHex\\B.jpg\n" +
            	    "C:\\Users\\USER\\OneDrive\\Desktop\\EventHex\\C.jpg"
            	);


            Thread.sleep(2000);

         // Click Upload button 
            WebElement confirmUploadBtn = wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[3]/div[26]/div/div[2]/div[2]/button"))); 
            confirmUploadBtn.click();



         // Verify upload
            WebElement uploadedImage = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(" //div[@class='sc-eGwCfc gkEhfS']")));
            System.out.println("Uploaded image is visible: " );

            // Go to Manage Photos
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/manage-photos");

            // Verify uploaded image is present in Manage Photos
            WebElement managedPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='text-xs sm:text-sm text-gray-600']")
            ));
            System.out.println("Manage Photos page loaded. Image found");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred in upload/manage photos flow.");
        } finally {
            //driver.quit();
        }
    }
}
    
    
   

