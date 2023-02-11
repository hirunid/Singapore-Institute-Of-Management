package testCaseRun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjects.Filters;
import pageObjects.ProgrammeListingPage;

import java.time.Duration;

public class FiltersRun {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        ProgrammeListingPage programmeList= new ProgrammeListingPage(driver);
        Filters filter = new Filters(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.sim.edu.sg");
        driver.manage().window().maximize();
        programmeList.clickButton();

        Thread.sleep(3000);
        programmeList.clickDegreesDiploma();


        programmeList.selectProgramme("Programmes");
        programmeList.selectProgrammeListing("Programme Listing");
        Thread.sleep(5000);

        filter.clickChatCloseButton();
        Thread.sleep(3000);

        filter.selectAcademicLevel("Bachelor's Degree");
        Thread.sleep(1000);

        filter.selectProgrammeType("Full-time");
        Thread.sleep(1000);
        filter.selectProgrammeType("Part-time");
        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(1000);
        filter.selectLearningMode("Campus Learning");

        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        filter.selectDiscipline("IT & Computer Science");


        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        filter.selectDegreeOrDiplomaProgramme("Information Technology");

        Thread.sleep(3000);
        filter.selectUniversityPartner("Australia");

        Thread.sleep(1000);
        filter.textOnPage();
        filter.numberOfUniversities();

        Thread.sleep(2000);
        filter.selectClearFilter();
        Thread.sleep(1000);
        filter.textOnPage();

        Thread.sleep(1000);
        driver.quit();


    }
}
