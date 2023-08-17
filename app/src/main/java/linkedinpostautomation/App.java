/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedinpostautomation;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    public void getGreeting(FirefoxDriver driver) throws InterruptedException {
        TestCases tests = new TestCases(); // Initialize your test class

        
        tests.testCase01(driver);

        //END Tests


        tests.endTest(driver); // End your test by clearning connections and closing browser

    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new App().getGreeting(driver);
    }
}
