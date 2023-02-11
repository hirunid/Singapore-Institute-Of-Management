package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProgrammeListingPage {

    WebDriver driver;

    public ProgrammeListingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Accept & continue']")
    @CacheLookup
    WebElement button;

    @FindBy(xpath = "//div[@id='header_navWrapper'] //a[normalize-space()='Degrees & Diplomas']")
    @CacheLookup
    WebElement DegreesDiploma;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/div[@class='mega-menu-column']//ul[@data-mega-menu-level='1']/li")
    @CacheLookup
    List<WebElement> listA;

    @FindBy(xpath = "//div[@class='next-level active']//ul[@data-mega-menu-level='2']/li")
    @CacheLookup
    List<WebElement> listB;

    @FindBy(xpath = "//div[@class='listing-card']")
    @CacheLookup
    List<WebElement> universities;

    @FindBy(xpath = "//div[@class='pl-filter-results pl-filter-results-text']")
    @CacheLookup
    WebElement pageText;

    @FindBy(xpath = "//li[@class='page-item active']//a")
    @CacheLookup
    WebElement activePage;

    public void clickButton(){
        button.click();
    }

    public void clickDegreesDiploma(){
        DegreesDiploma.click();
    }

    public void selectProgramme(String selection){
        for(WebElement listItem:listA) {
            if(listItem.getText().equals(selection)){
                listItem.click();
                break;
            }
        }
    }
    public void selectProgrammeListing(String selection){
        for(WebElement listItem:listB) {
            if(listItem.getText().equals(selection)){
                listItem.click();
                break;
            }
        }
    }
    public void noOfUniversitiesOnPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int i = 15;
        for (int p=1;p<=i; p++){
            try {
                System.out.println("Page number "+activePage.getText());
            }
            catch(StaleElementReferenceException e){
             WebElement activePage= driver.findElement(By.xpath("//li[@class='page-item active']//a"));
             System.out.println("Page number "+activePage.getText());
            }
            try {
                System.out.println(pageText.getText());
            }
            catch (StaleElementReferenceException e){
                WebElement pageText= driver.findElement(By.xpath("//div[@class='pl-filter-results pl-filter-results-text']"));
                System.out.println(pageText.getText());
            }
            System.out.println("Number of Universities on page "+universities.size());
            js.executeScript("window.scrollBy(0,3550)");
            String pNo=Integer.toString(p+1);
            WebElement page=driver.findElement(By.xpath( "//li[@class='page-item ']//a[text()='"+pNo+"']"));
            js.executeScript("arguments[0].click();", page);
            Thread.sleep(5000);
        }

    }
}
