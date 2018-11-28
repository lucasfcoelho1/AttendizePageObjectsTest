
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/a/span[2]")
    private WebElement event;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[1]/li[1]/a")
    private WebElement menuButton;
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[2]/a")
    private WebElement ticket;
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[4]/a")
    private WebElement attendees;
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[1]")
    private WebElement checkin;
    
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/a")
    private WebElement cutomize;
    
    
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[1]/li[2]/a")
    private WebElement publicEvent;
    
    public Menu(WebDriver driver) {
        super(driver);
    }
    
    public EventPage goToEventPage(){
        clickMenuOption(event);
        return new EventPage(driver);
    }
    
    public TicketsPage goToTicketsPage(){
        clickMenuOption(ticket);
        return new TicketsPage(driver);
    }
    
    public AttendeesPage goToAttendeesPage(){
        clickMenuOption(attendees);
        return new AttendeesPage(driver);
    }
    
    public CheckinPage goToCheckinPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        checkin.click();
        return new CheckinPage(driver);
    }
    
    public CustomizePage goToCustomizePage(){
        clickMenuOption(cutomize);
        return new CustomizePage(driver);
    }
    
    public PublicEventPage goToPublicEventPage(){
        clickMenuOption(publicEvent);
        return new PublicEventPage(driver);
    }
    
    private void clickMenuOption(WebElement menuOption) {
        //menu hides the options -- responsive page
        if(! menuOption.isDisplayed()) {
            menuButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(menuOption) );
        menuOption.click();
    }
    
}
