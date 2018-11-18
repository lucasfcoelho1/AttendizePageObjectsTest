
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttendizeBasePage extends BasePage{
    
    @FindBy(tagName = "h1")
    WebElement title;
    
    Menu menu; 
    
    public AttendizeBasePage(WebDriver driver) {
        super(driver);
        menu = new Menu(driver);
    }
    
    public Menu getMenu(){
        return menu;
    }
    
    public String getTitle(){
        return title.getText();
    }
    
    public void fillElement(WebElement element, String content) {
        element.click();
        element.sendKeys(content);
    }
    
    public void clickAwaiter(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(element) );
        element.click();
    }
    
}
