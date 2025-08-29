package eventhex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotoAttendee {
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
            
            //go to  photoattendee
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/photo-attendee");
            
            Thread.sleep(5000);

            //Locate table values
            WebElement attendeeName = driver.findElement(By.xpath("//table//tr[1]/td[1]"));
            WebElement mobileNumber = driver.findElement(By.xpath("//table//tr[1]/td[2]"));
            WebElement matchDateTime = driver.findElement(By.xpath("//table//tr[1]/td[4]"));

            //Print values
            System.out.println("Attendee Name: " + attendeeName.getText());
            System.out.println("Mobile Number: " + mobileNumber.getText());
            System.out.println("Match Date & Time: " + matchDateTime.getText());

            //Validate values
            if (attendeeName.getText().equals("Nandhana")) {
                System.out.println("Name verification Failed");
            } else {
                System.out.println("Name verification Passed");
            }

            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred in upload");
        } finally {
            //driver.quit();
        }
    }
}
    
    
   


