
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicEventPage extends AttendizeBasePage {
    
    public PublicEventPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(className = "tax-amount text-muted text-smaller")
    private WebElement tax;
    
    public String getTaxText(){
        return tax.getText();
    }
}
