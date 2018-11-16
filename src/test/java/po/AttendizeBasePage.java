/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Coelho
 */
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
    
}
