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
import po.*;

/**
 *
 * @author Coelho
 */
public class LoginTest {
    
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
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
    public void testCT01InvalidLogin() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage
                .setEmailTextField("teste@teste.com")
                .setPasswordPasswordField("123")
                .clickLoginButton();
        
        assertEquals("Your username/password combination was incorrect", loginPage.getErrorMessage());
    }
    
    @Test
    public void testCT02ValidLogin() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        
        DashboardPage dashboardPage = loginPage
                .setEmailTextField("teste@teste.com")
                .setPasswordPasswordField("utfpr")
                .clickLoginButton();

        assertEquals("UTFPR Dashboard", dashboardPage.getTitle());
    }
    
    @Test
    public void testCT03CreateAEvent() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        
        DashboardPage dashboardPage = loginPage
                .setEmailTextField("teste@teste.com")
                .setPasswordPasswordField("utfpr")
                .clickLoginButton();
        
        assertEquals("UTFPR Dashboard", dashboardPage.getTitle());
        
        TicketsPage ticketsPage = 
                dashboardPage.getMenu().goToEventPage().
                createEvent()
                .fillEventTitle("UTFWARE 2018")
                .fillEventDescription("Evento de tecnologia")
                .fillEventStartDate("20", "09" , "2018", "18", "40")
                .fillEventEndDate("25", "11", "2018", "22", "30")
                .fillVenueName("Conélio Procópio - PR, Brasil")
                .clickSaveEventButton();
        
        assertEquals("No Tickets Yet", ticketsPage.getNoTicketMessage());
         
    }
    
}
