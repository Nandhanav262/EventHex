package eventhex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Watermark {
	public static void main(String[] args) {

        // Launch Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Login Page
            driver.get("https://app.eventhex.ai");

            // Email + Password
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailField.sendKeys("info@eventhex.ai");

            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("Admin@EventHex");

            WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
            loginBtn.click();

            // DashBoard
            wait.until(ExpectedConditions.urlContains("https://app.eventhex.ai/event"));

            // Go to Event
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640");
            
            //go to InstaSnap
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/insta-snap-dashboard");
            
            // WaterMark
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/watermark");
            
            // Choose File
            WebElement fileInput = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("watermark-upload")));

            fileInput.sendKeys("C:\\Users\\USER\\Downloads\\download.jpeg");
            System.out.println("File uploaded successfully!");

         // Set Opacity and Scale
            WebElement scaleInput = driver.findElement(By.xpath("//input[@type='number']"));
            scaleInput.clear();
            scaleInput.sendKeys("20"); 

            //input box for opacity
         
            WebElement opacityInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='range']")));

            Thread.sleep(1000);
    

            // Save settings
            driver.findElement(By.xpath("//button[contains(.,'Save Watermark Settings')]")).click();

            System.out.println("File uploaded successfully!");
            System.out.println("Opacity set!");
            System.out.println("Scale set!");
            System.out.println("Watermark arranged successfully!");

      
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred before arranging watermark!");
        } finally {
            //driver.quit();
        }
    }
}
	
