package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class PredefinedStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if(url.contains("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.contains("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url: " +url+ " is not supported.");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName +"')]")).click();
    }

    @And("I click {string} menu item")
    public void iClickMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem+"')]")).click();
    }

    @When("I type {string} into quiz title field")
    public void iTypeIntoQuizTitleField(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }



    @And("I select {string} question type in {string}")
    public void iSelectQuestionTypeIn(String questionType, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into question field of {string}")
    public void iTypeIntoQuestionFieldOf(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I type {string} into {string} field of {string}")
    public void iTypeIntoFieldOf(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']")).sendKeys(optionText);
    }

    @When("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']/../../../../..//mat-radio-button")).click();
    }

    @Then("quiz title {string} is displayed on the list of quizzes")
    public void quizTitleIsDisplayedOnTheListOfQuizzes(String quizTitle) {
        List< WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title : titles){
            if (title.getText().contains(quizTitle)){
                assertThat(title.isDisplayed()).isTrue();
            }
        }
    }

    @And("I delete quiz {string} from the list of quizzes")
    public void iDeleteQuizFromTheListOfQuizzes(String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation/..//span[contains(text(),'Delete')]")).click();
    }

}
