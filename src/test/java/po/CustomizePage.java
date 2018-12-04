package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizePage extends AttendizeBasePage {

    public CustomizePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"intro\"]")
    private WebElement colorTitle;

    @FindBy(xpath = "//*[@id=\"tax_id\"]")
    private WebElement taxId;

    @FindBy(xpath = "//*[@id=\"tax_name\"]")
    private WebElement taxName;

    @FindBy(xpath = "//*[@id=\"tax_value\"]")
    private WebElement taxValue;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/ul/li[2]/a")
    private WebElement otherCustomizationOptions;

    @FindBy(xpath = "//*[@id=\"page_header_bg_color\"]")
    private WebElement colorEvent;

    @FindBy(id = "charge_yes")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//*[@id=\"OrganiserPageDesign\"]/form/div[2]/input")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//*[@id=\"organiserSettings\"]/form/div[9]/input")
    private WebElement saveOrganizerButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[1]/li[2]/a")
    private WebElement viewOrganizerPage;

    public CustomizePage changeColorEvent(String hexColor) {
        colorEvent.click();
        colorEvent.clear();
        colorEvent.sendKeys(hexColor);
        return this;
    }

    public CustomizePage viewOrganizerPage() throws InterruptedException {
        clickAwaiter(viewOrganizerPage);
        Thread.sleep(2000);
        driver.get("http://192.168.100.71/o/1");
        Thread.sleep(2000);
        return this;
    }

    public CustomizePage clickYesToTaxEvents() throws InterruptedException {
        WebElement yes = driver.findElement(By.name("charge_tax"));
        Thread.sleep(2000);
        yes.click();
        Thread.sleep(2000);
        return this;
    }

    public String checkColorTitle() {
        String url = driver.getCurrentUrl();
        return colorTitle.getCssValue("background-color");
    }

    public CustomizePage showOtherCustomizationOptions() {
        clickAwaiter(otherCustomizationOptions);
        return this;
    }

    public CustomizePage clickSaveOptions() {
        clickAwaiter(saveChangesButton);
        return this;
    }

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
