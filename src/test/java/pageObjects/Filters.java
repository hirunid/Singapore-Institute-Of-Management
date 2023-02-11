package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Filters {

    WebDriver driver;

    public Filters(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//button[@class='hide-pop-card']")
    @CacheLookup
    WebElement chatCloseButton;

    @FindBy(xpath = "//label[contains(@for,'AcademicLevelItems')]")
    @CacheLookup
    List<WebElement> academicLevel;

    @FindBy(xpath = "//label[contains(@for,'ProgrammeTypeItems')]")
    @CacheLookup
    List<WebElement> programmeType;

    @FindBy(id = "LearningModeItems_0__IsChecked")
    @CacheLookup
    WebElement campusLearning;

    @FindBy(id = "LearningModeItems_0__IsChecked")
    @CacheLookup
    WebElement onlineLearning;

    @FindBy(xpath = "//p[contains(@data-bs-target,'#plFilterDisciplineItems')]//span")
    @CacheLookup
    List<WebElement> discipline;

    @FindBy(xpath = "//label[contains(@for,'DisciplineItems')]")
    @CacheLookup
    List<WebElement> stream;

    @FindBy(xpath = "//div[contains(@data-bs-target,'#plFilterUniversityItems')]//label")
    @CacheLookup
    List<WebElement> universityPartners;

    @FindBy(xpath = "//div[@class='pl-filter-results pl-filter-results-text']")
    @CacheLookup
    WebElement pageText;

    @FindBy(xpath = "//div[@class='listing-card']")
    @CacheLookup
    List<WebElement> universities;

    @FindBy(id = "plClearAllFilters")
    @CacheLookup
    WebElement clear;

    public void clickChatCloseButton() {
        chatCloseButton.click();
    }

    public void selectAcademicLevel(String selection) {
        for (WebElement listItem : academicLevel) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (listItem.getText().equals(selection)) {
                js.executeScript("arguments[0].click();", listItem);
                System.out.println("After selecting Academic Level, page "+pageText.getText());
                break;
            }
        }
    }
    public void selectProgrammeType(String selection) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement listItem : programmeType) {
            if (listItem.getText().equals(selection)) {
                js.executeScript("arguments[0].click();", listItem);
                System.out.println("After selecting Programme Type, page "+pageText.getText());
                break;
            }
        }
    }

    public void selectLearningMode(String mode){
        if (mode.equals("Campus Learning")) {
            campusLearning.click();
        }
            else{
             onlineLearning.click();
            }
        System.out.println("After selecting Learning Mode, page "+pageText.getText());
        }


    public void selectDiscipline(String selection) {
        for (WebElement listItem : discipline) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (listItem.getText().equals(selection)) {
                js.executeScript("arguments[0].click();", listItem);
                System.out.println("After selecting Discipline, page "+pageText.getText());
                break;
            }
        }
    }

    public void selectDegreeOrDiplomaProgramme(String selection) {
        for (WebElement listItem : stream) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (listItem.getText().equals(selection)) {
                js.executeScript("arguments[0].click();", listItem);
                System.out.println("After selecting Degree & Diploma, page "+pageText.getText());
                break;
            }
        }
    }
    public void selectUniversityPartner(String selection) {
        for (WebElement listItem : universityPartners) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (listItem.getText().equals(selection)) {
                js.executeScript("arguments[0].click();", listItem);
                System.out.println("After selecting University Partners, page "+pageText.getText());
                break;
            }
        }
    }
    public void textOnPage(){
        System.out.println("Page "+pageText.getText());
    }

    public void numberOfUniversities(){
        System.out.println("Number of Universities showing on a page- "+universities.size());
    }

    public void selectClearFilter(){
        clear.click();
    }

}