
package po;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventPage extends AttendizeBasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div/a")
    @CacheLookup
    private WebElement createEventButton;

    WebElement title;
    
    Select select;
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[4]/div[1]/div/div[3]/ul/li[2]/a")
    WebElement manageEvent;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='|'])[3]/following::div[9]")
    @CacheLookup
    private WebElement description1;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='|'])[3]/following::textarea[1]")
    @CacheLookup
    private WebElement description;

    @FindBy(xpath = "//*[@id=\"start_date\"]")
    @CacheLookup
    private WebElement startDate;

    @FindBy(id = "end_date")
    @CacheLookup
    private WebElement endDate;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='+'])[1]/following::input[1]")
    private WebElement day;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='+'])[2]/following::input[1]")
    private WebElement month;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='+'])[3]/following::input[1]")
    private WebElement year;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='+'])[4]/following::input[1]")
    private WebElement hour;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='+'])[5]/following::input[1]")
    private WebElement minute;

    @FindBy(linkText = "Set")
    private WebElement setButton;
    
    @FindBy(name = "venue_name_full")
    private WebElement venueName;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[3]/input")
    private WebElement saveEventButton;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[2]/div/div/div[1]/div")
    private WebElement titleError;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[2]/div/div/div[2]/div[1]")
    private WebElement descriptionError;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[2]/div/div/div[3]/div[1]/div/div")
    private WebElement startDateError;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[2]/div/div/div[3]/div[2]/div/div")
    private WebElement endDateError;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[2]/div/div/div[5]/div[1]")
    private WebElement venueError;
    
    

    public EventPage(WebDriver driver) {
        super(driver);
    }

    public EventPage createEvent() {
        createEventButton.click();
        return this;
    }

    public EventPage fillEventTitle(String eventTitle) throws InterruptedException {
        Thread.sleep(2000);
        fillElement(title, eventTitle);
        return this;
    }

    public EventPage fillEventDescription(String eventDescription) {
        description1.click();
        description.sendKeys(eventDescription);
        return this;
    }

    public EventPage fillEventStartDate(
            String day,
            String month,
            String year,
            String hour,
            String minute) throws InterruptedException {
        startDate.click();

        fillElement(this.day, day);
        fillElement(this.month, month);
        fillElement(this.year, year);
        fillElement(this.hour, hour);
        fillElement(this.minute, minute);

        setButton.click();
        Thread.sleep(2000);
        return this;
    }

    public EventPage fillEventEndDate(
            String day,
            String month,
            String year,
            String hour,
            String minute) throws InterruptedException{
        
        endDate.click();

        fillElement(this.day, day);
        fillElement(this.month, month);
        fillElement(this.year, year);
        fillElement(this.hour, hour);
        fillElement(this.minute, minute);

        setButton.click();
        Thread.sleep(2000);
        return this;
    }
    
    public EventPage fillVenueName(String eventVenue){
        fillElement(venueName, eventVenue);
        return this;
    }
    
    public TicketsPage clickSaveEventButton(){
        clickAwaiter(saveEventButton);
        return new TicketsPage(driver);
    }
    
    public EventPage clickSaveError(){
        clickAwaiter(saveEventButton);
        return this;
    }
    
    public String getTitleError(){
        return titleError.getText();
    }

    public String getDescriptionError() {
        return descriptionError.getText();
    }

    public String getStartDateError() {
        return startDateError.getText();
    }

    public String getEndDateError() {
        return endDateError.getText();
    }

    public String getVenueError() {
        return venueError.getText();
    }
    
    public EventPage changeComboboxTo(String value) throws InterruptedException{
        Thread.sleep(2000);
        select = new Select(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div[2]/div/select")));
        Thread.sleep(2000);
        select.selectByVisibleText(value);
        return this;
    }
    
    public EventPage manageEventClick(String eventTitle){
        WebElement link = driver.findElement(By.linkText(eventTitle));
        clickAwaiter(link);
        return this;
    }

}
