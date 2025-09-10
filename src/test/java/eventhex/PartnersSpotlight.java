package eventhex;

import java.io.File;
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

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        try {
            // Login Page
            driver.get("https://app.eventhex.ai");

            // Email + Password
            WebElement emailField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailField.sendKeys("info@eventhex.ai");

            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("Admin@EventHex");

            WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
            loginBtn.click();

            // Dashboard
            wait.until(ExpectedConditions.urlContains("https://app.eventhex.ai/event"));

            // Go to Partners Spotlight
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/partners-spotlights");
            Thread.sleep(3000);
            
            // Click "Add New" button
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='sc-gGarWV cXXlwS']")));
            addBtn.click();

         // Enter Partner Name
            WebElement partnerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Partner Name']")));
            partnerName.sendKeys("Manual Partner Pvt Ltd");

            // Handle file upload (make hidden input visible)
            WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadInput);

            File file1 = new File("C:\\Users\\USER\\Downloads\\images.jpeg");
            uploadInput.sendKeys(file1.getAbsolutePath());

            // Enter Link
            WebElement linkInput = driver.findElement(By.xpath("//input[@placeholder='Link']"));
            linkInput.sendKeys("https://www.manualpartner.com");

            // Now wait for Submit button to be enabled
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Submit')]")));
            submitBtn.click();

            System.out.println("Partner spotlight added successfully");

        } catch (Exception e) {
            System.out.println("Error occurred in Partners Spotlight automation");
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }
}