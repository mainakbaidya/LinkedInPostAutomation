package linkedinpostautomation;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestCases {
    

    public void endTest(FirefoxDriver driver)
    {
        System.out.println("End Test: TestCases");
        driver.quit();

    }

    
    public  void testCase01(FirefoxDriver driver) throws InterruptedException{

       
       try {

       System.out.println("Start Test case: testCase01");
      

       driver.get("https://www.linkedin.com");
       Thread.sleep(3000);
       Actions actions = new Actions(driver);
       
       //username
       WebElement username = driver.findElement(By.id("session_key"));
       actions.sendKeys(username,"abc@gmail.com").perform();
       Thread.sleep(1000);

       //password
       driver.findElement(By.id("session_password")).sendKeys("abc123");
       Thread.sleep(1000);

       //click on Sign in
       driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
       Thread.sleep(2000);

       //Click on anaylytics and tools
       driver.findElement(By.xpath("//a[contains(@href,'dashboard')]")).click();
       Thread.sleep(3000);

       //Store analytics value in a list
       List<WebElement> analyticsValue = new ArrayList<>();
       analyticsValue = driver.findElements(By.xpath("//div[contains(@class,'pcd-analytics-view-item')]/div/p[contains(@class,'text-body-large-bold t-black')]"));
       Thread.sleep(3000);
       
       //Find postImpression and profileViewer and store them
       String postImpression = analyticsValue.get(0).getText();
       String profileViewer = analyticsValue.get(2).getText();
       System.out.println("Post impressions : "+ postImpression);
       System.out.println("Profile Viewer : " + profileViewer);

       //back to home page
       driver.navigate().back();
       Thread.sleep(2000);

       //click on Start a post
       driver.findElement(By.xpath("//div[contains(@class,'share-box-feed-entry__top-bar')]/button")).click();
       Thread.sleep(2000);

       //Make with Connections only
       driver.findElement(By.xpath("//h2[contains(@id,'share-to-linkedin-modal__header')]/button")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']")).click();
       Thread.sleep(2000);

       //click on Done
       driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]")).click();
       Thread.sleep(2000);

       //send message 
       WebElement message = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
       actions.sendKeys(message, "Ami").perform();
       Thread.sleep(1000);
       driver.findElement(By.xpath("//div[@class='share-box_actions']/button")).click();
       Thread.sleep(3000);

       //confirm if it gets posted
       Boolean status = driver.findElement(By.xpath("//p[@class='artdeco-toast-item__message']")).isDisplayed();
       if(status){
        System.out.println("Successfully posted!!");
        String messageText = driver.findElement(By.xpath("//div[@class='update-components-text relative feed-shared-update-v2__commentary ']/span/span[@dir='ltr']")).getText();
        System.out.println("Message is " + messageText);
       }
       else{
        System.out.println("Message is not sent");
       }
        
       System.out.println("end Test case: testCase01");
        
       } catch (Exception e) {
          e.printStackTrace();
       }
       
        

    }


}
