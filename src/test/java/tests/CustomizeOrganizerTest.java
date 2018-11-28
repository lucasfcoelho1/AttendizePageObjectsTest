/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.DashboardPage;
import po.LoginPage;
import po.PublicEventPage;

/**
 *
 * @author Coelho
 */
public class CustomizeOrganizerTest {
    
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void testCT10CustomizeOrganiser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        
        DashboardPage dashboardPage = loginPage
                .setEmailTextField("teste@teste.com")
                .setPasswordPasswordField("utfpr")
                .clickLoginButton();
        
        assertEquals("UTFPR Dashboard", dashboardPage.getTitle());
        
        PublicEventPage publicEventPage = dashboardPage
                .getMenu()
                .goToCustomizePage()
                .fillTaxId("1")
                .fillTaxName("Imposto")
                .fillTaxValue("10")
                .clickSaveOrganiser()
                .getMenu()
                .goToEventPage()
                .manageEventClick()
                .getMenu()
                .goToPublicEventPage();
        
        Thread.currentThread().sleep(2000);
        assertEquals(("+€2.00 Tax"), publicEventPage.getTaxText());
    }
    
}
