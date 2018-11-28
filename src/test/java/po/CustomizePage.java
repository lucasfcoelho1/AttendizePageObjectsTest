package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizePage extends AttendeesPage {

    public CustomizePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"tax_id\"]")
    private WebElement taxId;

    @FindBy(xpath = "//*[@id=\"tax_name\"]")
    private WebElement taxName;

    @FindBy(xpath = "//*[@id=\"tax_value\"]")
    private WebElement taxValue;
    
    
    @FindBy(xpath = "//*[@id=\"organiserSettings\"]/form/div[9]/input")
    private WebElement saveOrganizerButton;

    public CustomizePage fillTaxId(String value) {
        taxId.click();
        taxId.clear();
        taxId.sendKeys(value);
        return this;
    }

    public CustomizePage fillTaxName(String value) {
        taxName.click();
        taxName.clear();
        taxName.sendKeys(value);
        return this;
    }

    public CustomizePage fillTaxValue(String value) {
        taxValue.click();
        taxValue.clear();
        taxValue.sendKeys(value);
        return this;
    }
    
    public CustomizePage clickSaveOrganiser() {
        clickAwaiter(saveOrganizerButton);
        return this;
    }

}
