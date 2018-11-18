package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TicketsPage extends AttendizeBasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/div/div[2]/h1")
    private WebElement noTicket;
    
    //@FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/div/div[2]/button")
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div/button")
    private WebElement createTicketButton;
    
    @FindBy(xpath = "//*[@id=\"title\"]")
    private WebElement titleTicket;
    
    @FindBy(xpath = "//*[@id=\"price\"]")
    private WebElement priceTicket;
    
    @FindBy(xpath = "//*[@id=\"quantity_available\"]")
    private WebElement quantityTicket;
    
    @FindBy(xpath = "/html/body/div[3]/form/div/div/div[2]/div/div[2]/a")
    private WebElement moreOptions;
    
    private Select maximumTickets;
    
    @FindBy(xpath = "/html/body/div[3]/form/div/div/div[3]/input")
    private WebElement saveTicketButton;
    
    @FindBy(xpath = "/html/body/div[2]")
    private WebElement confirmMessage;
    
    public TicketsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getNoTicketMessage(){
        return noTicket.getText();
    }
    
    public TicketsPage clickCreateTicket(){
        clickAwaiter(createTicketButton);
        return this;
    }
    
    public TicketsPage fillTitleTicket(String title){
        fillElement(titleTicket, title);
        return this;
    }
    
    public TicketsPage fillPriceTicket(String price){
        fillElement(priceTicket, price);
        return this;
    }
    
    public TicketsPage fillQuantityTicket(String quantity){
        fillElement(quantityTicket, quantity);
        return this;
    }
    
    public TicketsPage clickMoreOptions(){
        clickAwaiter(moreOptions);
        return this;
    }
    
    public TicketsPage changeMaximumTickets(String value) throws InterruptedException{
        Thread.currentThread().sleep(2000);
        maximumTickets = new Select(driver.findElement(By.xpath("//*[@id=\"max_per_person\"]")));
        Thread.currentThread().sleep(2000);
        maximumTickets.selectByVisibleText(value);
        return this;
    }
    
    public TicketsPage clickSaveTicket(){
        clickAwaiter(saveTicketButton);
        return this;
    }
    
    public String getConfirmMessage() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        return confirmMessage.getText();
    }
}
