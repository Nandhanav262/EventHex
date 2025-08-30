package eventhex;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContributeAlbum {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream");

	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
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
            driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/contribute-album");
            
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
             
             driver.get("https://68abf3eec54d5f0247378640.eventhex.ai/instasnap/contribute");
             
             //image upload
             WebElement uploadInput = wait.until(
            	        ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
             
            	    // Provide your local file path here
             String filePath1 = "C:\\Users\\USER\\Downloads\\images.jpeg";
             String filePath2 = "C:\\Users\\USER\\Downloads\\download.jpeg";
            	    uploadInput.sendKeys(filePath1 + "\n" + filePath2);
            	    
            	    WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Upload')]")));
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadBtn);
            	    	uploadBtn.click();
            	    	System.out.println("contribute photos uploaded sucessfully");
            	    	
            	    	for (String handle : driver.getWindowHandles()) {
            	    	    driver.switchTo().window(handle);
            	    	}
            	    	driver.get("https://app.eventhex.ai/event/68abf3eec54d5f0247378640/insta-snap/contribute-album");
            	    	System.out.println("Navigate back to Contribute Album");
            	    	
            	    	WebElement pending = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Pending']")));
                	    pending.click();
                	    
                	 // Get all pending photos
                	    List<WebElement> pendingPhotos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'grid')]//img"))
);


                	    // Validate
                	    if (pendingPhotos.size() > 0) {
                	        System.out.println(pendingPhotos.size() + " photos are present in Pending list.");
                	        for (WebElement photo : pendingPhotos) {
                	            System.out.println("photos found in Pending list");
                	        }
                	    } else {
                	        System.out.println("No photos found in Pending list!");
                	    }
            	    	
            	    	
            	    	
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred in Partners Spotlight automation!");
            } finally {
            //driver.quit();
        }
    }
}