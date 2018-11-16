package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketsPage extends AttendizeBasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/div/div[2]/h1")
    private WebElement noTicket;
    
    public TicketsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getNoTicketMessage(){
        return noTicket.getText();
    }

}
