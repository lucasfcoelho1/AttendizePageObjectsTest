/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SurveysPage extends AttendizeBasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/div/div[2]/h1")
    private WebElement centralText;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div[1]/button")
    private WebElement createQuestionButton;

    @FindBy(xpath = "//*[@id=\"question-title\"]")
    private WebElement questionTitle;

    @FindBy(xpath = "//*[@id=\"question-options\"]/table/tbody/tr/td[1]/input")
    private WebElement firstQuestion;

    @FindBy(xpath = "//*[@id=\"question-options\"]/table/tbody/tr[2]/td[1]/input")
    private WebElement secondQuestion;

    @FindBy(xpath = "//*[@id=\"add-question-option\"]")
    private WebElement addAnotherOptionButton;
    
    @FindBy(xpath = "//*[@id=\"edit-question-form\"]/div/div/div[2]/div[4]/div/label")
    private WebElement requiredCheckbox;
    
    @FindBy(xpath = "//*[@id=\"edit-question-form\"]/div/div/div[3]/input")
    private WebElement saveQuestionButton;

    public SurveysPage(WebDriver driver) {
        super(driver);
    }

    public SurveysPage changeComboboxTo(String value) throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"question-type\"]")));
        Thread.sleep(2000);
        select.selectByVisibleText(value);
        return this;
    }

    public SurveysPage clickAddAnotherOption() {
        clickAwaiter(addAnotherOptionButton);
        return this;
    }

    public SurveysPage fillFirstQuestion(String firstQuestion) {
        fillElement(this.firstQuestion, firstQuestion);
        return this;
    }

    public SurveysPage fillSecondQuestion(String seconQuestion) {
        fillElement(this.secondQuestion, seconQuestion);
        return this;
    }

    public SurveysPage clickRequiredQuestionCheckbox() {
        clickAwaiter(requiredCheckbox);
        return this;
    }
    
    public SurveysPage clickSaveQuestion(){
        clickAwaiter(saveQuestionButton);
        return this;
    }

    public SurveysPage fillQuestionTitle(String questionTitle) {
        fillElement(this.questionTitle, questionTitle);
        return this;
    }

    public String getCentralText() {
        return centralText.getText();
    }

    public SurveysPage clickCreateQuestion() {
        clickAwaiter(createQuestionButton);
        return this;
    }
    
    public boolean isSurveyQuestionVisible(){
        return driver.getPageSource().contains("Gostou do evento?");
    }
}
