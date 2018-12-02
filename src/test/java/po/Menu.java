
package po;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
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
    
//    @FindBy(css = "//*[@id=\"nav_event\"]/li[1]")
//    private WebElement checkin;
    
//    @FindBy(linkText = "Check-In")
//    private WebElement checkin;
    
//    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[1]/a")
//    private WebElement checkin;
    
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/a")
    private WebElement cutomize;
    
    
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[1]/li[2]/a")
    private WebElement publicEvent;
    
    @FindBy(xpath = "//*[@id=\"nav_main\"]/li/a")
    private WebElement backToDashboard;
    
    public Menu(WebDriver driver) {
        super(driver);
    }
    
    public EventPage goToEventPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        clickMenuOption(event);
        Thread.currentThread().sleep(2000);
        return new EventPage(driver);
    }
    
    public TicketsPage goToTicketsPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        clickMenuOption(ticket);
        Thread.currentThread().sleep(2000);
        return new TicketsPage(driver);
    }
    
    public AttendeesPage goToAttendeesPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        clickMenuOption(attendees);
        Thread.currentThread().sleep(2000);
        return new AttendeesPage(driver);
    }
    
    public DashboardPage goBackToDashboardPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        clickMenuOption(backToDashboard);
        Thread.currentThread().sleep(2000);
        return new DashboardPage(driver);
    }
    
    public CheckinPage goToCheckinPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"nav_event\"]/li[1]/a"));
        if(elements.size() > 1)
            clickMenuOption(elements.get(1));
        Thread.currentThread().sleep(2000);
        return new CheckinPage(driver);
    }
    
    public CustomizePage goToCustomizePage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        clickMenuOption(cutomize);
        Thread.currentThread().sleep(2000);
        return new CustomizePage(driver);
    }
    
    public PublicEventPage goToPublicEventPage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        clickMenuOption(publicEvent);
        String url = publicEvent.getAttribute("href");
        driver.get(url);
        Thread.currentThread().sleep(2000);
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
