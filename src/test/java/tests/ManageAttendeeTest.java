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
import po.AttendeesPage;
import po.CheckinPage;
import po.DashboardPage;
import po.LoginPage;
import po.TicketsPage;

/**
 *
 * @author Coelho
 */
public class ManageAttendeeTest {
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
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
    public void testCT06InviteAtendee() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        
        DashboardPage dashboardPage = loginPage
                .setEmailTextField("teste@teste.com")
                .setPasswordPasswordField("utfpr")
                .clickLoginButton();
        
        assertEquals("UTFPR Dashboard", dashboardPage.getTitle());
        
        TicketsPage ticketsPage = dashboardPage
                .getMenu()
                .goToEventPage()
                .createEvent()
                .fillEventTitle("UTFWARE 2018 ID:"+ dashboardPage.GenerateEventId())
                .fillEventDescription("Evento de tecnologia")
                .fillEventStartDate("20", "09", "2018", "18", "40")
                .fillEventEndDate("25", "11", "2019", "22", "30")
                .fillVenueName("Conélio Procópio - PR, Brasil")
                .clickSaveEventButton();
        
        ticketsPage = dashboardPage
                .getMenu()
                .goBackToDashboardPage()
                .getMenu()
                .goToEventPage()
                .changeComboboxTo("Creation Date")
                .manageEventClick("UTFWARE 2018 ID:"+ dashboardPage.GetEventId())
                .getMenu()
                .goToTicketsPage();
        
        ticketsPage.clickCreateTicket()
                .fillTitleTicket("Inteira")
                .fillPriceTicket("20")
                .fillQuantityTicket("100")
                .clickMoreOptions()
                .changeMaximumTickets("3")
                .clickSaveTicket();
        
        AttendeesPage attendeesPage = dashboardPage
                .getMenu()
                .goToAttendeesPage()
                .clickInviteAttendee()
                .fillFirstName("Lucas")
                .fillLastName("Coelho")
                .fillEmail("lucasfcoelho@gmail.com")
                .clickSaveButton();
        
        assertEquals("Attendee Successfully Invited!", attendeesPage.getConfitmMessage());
    }
    
    @Test
    public void testCT07RegistryAttendeeEntrance() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        
        DashboardPage dashboardPage = loginPage
                .setEmailTextField("teste@teste.com")
                .setPasswordPasswordField("utfpr")
                .clickLoginButton();
        
        assertEquals("UTFPR Dashboard", dashboardPage.getTitle());
        
        TicketsPage ticketsPage = dashboardPage
                .getMenu()
                .goToEventPage()
                .createEvent()
                .fillEventTitle("UTFWARE 2018 ID:"+ dashboardPage.GenerateEventId())
                .fillEventDescription("Evento de tecnologia")
                .fillEventStartDate("20", "09", "2018", "18", "40")
                .fillEventEndDate("25", "11", "2019", "22", "30")
                .fillVenueName("Conélio Procópio - PR, Brasil")
                .clickSaveEventButton();
        
        ticketsPage = dashboardPage
                .getMenu()
                .goBackToDashboardPage()
                .getMenu()
                .goToEventPage()
                .changeComboboxTo("Creation Date")
                .manageEventClick("UTFWARE 2018 ID:"+ dashboardPage.GetEventId())
                .getMenu()
                .goToTicketsPage();
        
        ticketsPage.clickCreateTicket()
                .fillTitleTicket("Inteira")
                .fillPriceTicket("20")
                .fillQuantityTicket("100")
                .clickMoreOptions()
                .changeMaximumTickets("3")
                .clickSaveTicket();
        
        AttendeesPage attendeesPage = ticketsPage
                .getMenu()
                .goToAttendeesPage()
                .clickInviteAttendee()
                .fillFirstName("Lucas")
                .fillLastName("Coelho")
                .fillEmail("lucasfcoelho@gmail.com")
                .clickSaveButton();
        
        CheckinPage checkinPage = attendeesPage
                .getMenu()
                .goBackToDashboardPage()
                .getMenu()
                .goToEventPage()
                .changeComboboxTo("Creation Date")
                .manageEventClick("UTFWARE 2018 ID:"+ dashboardPage.GetEventId())
                .getMenu()
                .goToCheckinPage()
                .clickRegistryAttendeeEntrance();
        
        assertEquals("rgba(230, 255, 231, 1)", checkinPage.checkColor());
        
    }
    
}
