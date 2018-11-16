/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Coelho
 */
public class DashboardPage extends AttendizeBasePage{

    private WebDriver driver;

    private int timeout = 15;
    
    @FindBy(className = "title")
    private WebElement title;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    
}
