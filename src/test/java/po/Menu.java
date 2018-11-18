
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
