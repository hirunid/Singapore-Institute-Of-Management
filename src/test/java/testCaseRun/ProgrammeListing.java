package testCaseRun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjects.ProgrammeListingPage;

import java.time.Duration;

public class ProgrammeListing {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        ProgrammeListingPage programmeList= new ProgrammeListingPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            driver.get("https://www.sim.edu.sg");
            driver.manage().window().maximize();

            programmeList.clickButton();

            Thread.sleep(3000);
            programmeList.clickDegreesDiploma();


            programmeList.selectProgramme("Programmes");
            programmeList.selectProgrammeListing("Programme Listing");
            Thread.sleep(5000);


            js.executeScript("window.scrollBy(0,1000)");
            programmeList.noOfUniversitiesOnPage();

            driver.quit();

    }
}