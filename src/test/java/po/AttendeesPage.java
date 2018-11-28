
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttendeesPage extends AttendizeBasePage{
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div[1]/button")
                     //*[@id="main"]/div/div[2]/div/div[1]/div/div[1]/button
    private WebElement inviteAttendeeButton;
    
    @FindBy(xpath = "//*[@id=\"first_name\"]")
    private WebElement first_name;
    
    @FindBy(xpath = "//*[@id=\"last_name\"]")
    private WebElement last_name;
    
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;
    
    @FindBy(xpath = "/html/body/div[3]/form/div/div/div[3]/input")
    private WebElement saveAttendeeButton;
    
    @FindBy(xpath = "/html/body/div[2]")
    private WebElement confirmMessage;
    
    public AttendeesPage(WebDriver driver) {
        super(driver);
    }
    
    public AttendeesPage clickInviteAttendee(){
        clickAwaiter(inviteAttendeeButton);
        return this;
    }
    
    public AttendeesPage fillFirstName(String firstName) throws InterruptedException{
        Thread.currentThread().sleep(1500);
        first_name.sendKeys(firstName);
        return this;
    }
    
    public AttendeesPage fillLastName(String lastName){
        fillElement(last_name, lastName);
        return this;
    }
    
    public AttendeesPage fillEmail(String emailAddress){
        fillElement(email, emailAddress);
        return this;
    }
    
    public AttendeesPage clickSaveButton(){
        clickAwaiter(saveAttendeeButton);
        return this;
    }
    
    public String getConfitmMessage() throws InterruptedException{
        Thread.currentThread().sleep(1500);
        return confirmMessage.getText();
    }
    
}
