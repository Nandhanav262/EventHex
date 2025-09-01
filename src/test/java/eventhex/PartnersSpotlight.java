package eventhex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartnersSpotlight {

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
            
            // PartnersSpotlight
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/partners-spotlights");
            
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add New')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
            addBtn.click();
            
            // Enter Partner Name
            WebElement partnerName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Partner Name']")));
            partnerName.sendKeys("Test Partner Pvt Ltd");

            // Upload Logo
            WebElement logoUpload = driver.findElement(By.xpath("//input[@type='file']"));
            logoUpload.sendKeys("C:\\Users\\USER\\Downloads\\download.jpeg");

            // Enter Partner Link
            WebElement partnerLink = driver.findElement(By.xpath("//input[@placeholder='Link']"));
            partnerLink.sendKeys("https://www.testpartner.com");

            //Click Submit
            WebElement submitBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));
            submitBtn.click();
            System.out.println("Partner Spotlight added successfully!");

            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred in Partners Spotlight automation!");
            } finally {
            //driver.quit();
        }
    }
}
	

