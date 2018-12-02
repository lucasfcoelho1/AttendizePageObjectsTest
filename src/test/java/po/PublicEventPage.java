package po;

import java.util.List;
import static net.bytebuddy.implementation.FixedValue.self;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicEventPage extends AttendizeBasePage {

    public PublicEventPage(WebDriver driver) {
        super(driver);
    }
//    @FindBy(xpath = "//*[@id=\"tickets\"]/form/div/div/div/div/table/tbody/tr[1]/td[2]/div/span[2]")
//*[@id="tickets"]/form/div/div/div/div/table/tbody/tr[1]/td[2]/div/span[2]
    @FindBy(xpath = "//*[@id=\"tickets\"]/form/div/div/div/div/table/tbody/tr[1]/td[2]/div/span[2]")
    private WebElement tax;

    public String getTaxText() {
        return tax.getText();
    }
}
