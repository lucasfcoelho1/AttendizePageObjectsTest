
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckinPage extends AttendizeBasePage{
    
    @FindBy(xpath = "//*[@id=\"attendee_list\"]/li[1]")
    private WebElement attendee;
    
    public CheckinPage(WebDriver driver) {
        super(driver);
    }
    
    public CheckinPage clickRegistryAttendeeEntrance(){
        clickAwaiter(attendee);
        return this;
    }
    
    public String checkColor(){
        return attendee.getCssValue("background-clor");
    }
    
}
