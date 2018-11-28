package po;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import po.BasePage;

public class LoginPage extends AttendizeBasePage{
    private Map<String, String> data;
    private int timeout = 15;
    
    @FindBy(xpath = "/html/body/div[2]")
    WebElement errorMessage;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(css = "a.forgotPassword")
    @CacheLookup
    private WebElement forgotPassword;

    @FindBy(css = "button.btn.btn-block.btn-success")
    @CacheLookup
    private WebElement login;

    private final String pageLoadedText = "";

    private final String pageUrl = "/login";

    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://192.168.100.71/login");
    }

    public DashboardPage clickLoginButton() {
        clickAwaiter(login);
        return new DashboardPage(driver);
    }


    public LoginPage setEmailTextField(String emailValue) {
        email.clear();
        email.sendKeys(emailValue);
        return this;
    }

    public LoginPage setPasswordPasswordField(String passwordValue) {
        password.clear();
        password.sendKeys(passwordValue);
        return this;
    }

    public LoginPage submit() {
        clickLoginButton();
        return this;
    }
    
    public String getErrorMessage() throws InterruptedException {
        Thread.currentThread().sleep(1000);
            return errorMessage.getText();
    }

    public LoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public LoginPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}





//body > div.humane.humane-animate