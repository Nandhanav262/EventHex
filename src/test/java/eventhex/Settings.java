package eventhex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
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
	            
	            //Navigate to InstaSnap Settings
	            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/insta-snap-settings");

	            // Wait for the label with text "Everyone"
	            WebElement everyoneOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@role='radio']")));

	            // Click it using JavaScript (safer for custom UI widgets)
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", everyoneOption);
	            System.out.println("Clicked 'Everyone' option");


	            //Verify
	            WebElement everyoneRadio1 = driver.findElement( By.xpath("//label[@role='radio']"));
	            if (everyoneRadio1.isSelected()) {
	                System.out.println("Confirmed : 'Everyone' is selected");
	            } else {
	                System.out.println("'Attendees' is still selected");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error occurred");
	        } finally {
	            //driver.quit();
	        }
	    }
	}
	    
