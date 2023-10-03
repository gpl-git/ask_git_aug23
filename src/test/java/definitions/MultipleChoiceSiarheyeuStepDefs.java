package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;


public class MultipleChoiceSiarheyeuStepDefs {
    @Given("I open the {string} page")
    public void iOpenPage(String url) {
        if (url.contains("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.contains("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This url: " + url + " is not supported.");
        }
    }

    @When("I type {string} into email")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click on button {string}")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @And("I click on {string} menu item")
    public void iClickMenuItem(String Item) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + Item + "')]")).click();
    }

    @When("I type {string} into quiz title")
    public void iTypeIntoQuizTitleField(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @Then("I add the question")
    public void AddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I click on {string} question type in {string}")
    public void SelectQuestionTypeIn(String questionType, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::*[contains(text(),'" + questionType + "')]")).click();
    }

    @Then("I should see {int} options in the question")
    public void iShouldSeeOptionsInTheQuestion(int expectedOptionsCount) {
        WebElement optionsContainer = getDriver().findElement(By.className("options"));
        List<WebElement> options = optionsContainer.findElements(By.className("option-row"));
        assertEquals(expectedOptionsCount, options.size());
    }

    @When("I click on {string} button until {int} options reached")
    public void iClickOnButtonUntilOptionsReached(String button, int expectedOptionsCount) {
        while (getNumberOfOptions() < expectedOptionsCount) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + button + "')]")).click();
        }
    }

    private int getNumberOfOptions() {
        WebElement optionsContainer = getDriver().findElement(By.cssSelector(".options"));
        List<WebElement> options = optionsContainer.findElements(By.cssSelector(".option-row"));
        return options.size();
    }

    @Then("I select {string} as a correct option in {string}")
    public void SelectCorrectOption(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']/preceding::mat-checkbox")).click();
    }

    @And("I type {string} into {string} field of {string} question")
    public void FillOutQuestion(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']")).sendKeys(optionText);
    }

    @And("I click on {string} in {string}")
    public void iClickOnIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']")).click();
    }

    @Then("I should see an {string} error in {string} in {string}")
    public void iShouldSeeAnError(String errortext, String optionNum, String questionNum) {
        String actualText = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']/following::mat-error")).getText();
        assertThat(actualText).containsIgnoringCase(errortext);
    }

    @When("I type {string} into field of {string}")
    public void iTypeIntoQuestionFieldOf(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @Then("title {string} is displayed on the list of quizzes")
    public void TitleIsDisplayed(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title : titles) {
            if (title.getText().contains(quizTitle)) {
                assertThat(title.isDisplayed()).isTrue();
            }
        }
    }

    @And("I delete {string} from the list of quizzes")
    public void iDeleteQuizFromTheListOfQuizzes(String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/following::span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation/descendant::span[contains(text(),'Delete')]")).click();
    }


    @When("I click on Settings icon and delete {string} in {string}")
    public void iDeleteIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']/../../../../..//mat-icon")).click();
        WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'Delete Option')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }



    @Then("I verify that there only {int} options")
    public void iVerifyThatThereOnlyQuestionsLeft(int expectedQuestionCount) {
        List<WebElement> options = getDriver().findElements(By.cssSelector(".options .option-row"));
        int actualOptionCount = options.size();
        assertThat(actualOptionCount).isEqualTo(expectedQuestionCount);
    }


    @When("I click on Settings icon and {string} {string} in {string}")
    public void iMoveUp(String funct,String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']/../../../../..//mat-icon")).click();
        WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'"+ funct +"')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("{string} should contain {string} in the {string} question")
    public void shouldContainInTheQuestion(String optionNum, String text, String questionNum) {
        WebElement textarea = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"  + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']"));
        String textInsideTextarea = textarea.getAttribute("value");
        assertEquals(text, textInsideTextarea);

    }


    @And("I type {int} characters into {string} field of {string} question")
    public void iTypeCharactersIntoFieldOfQuestion(int num, String optionNum, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String genString = RandomStringUtils.random(num, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::textarea[@placeholder='" + optionNum + "*']")).sendKeys(genString);
    }

    @And("I add upp to {int} options in {string}")
    public void iAddUppToOptionsIn(int num, String questionNum) {
        for (int i= 3; i <= num; i++){
            getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNum+"')]/following::*[contains(text(),'Add Option')]")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='Option "+i+"*']")).sendKeys("Option " +i);

        }
    }

    @Then("I should see an {string} error in {string}")
    public void iShouldSeeAnErrorIn(String errortext, String questionNum) {
        String actualText = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/following::mat-error")).getText();
        assertThat(actualText).containsIgnoringCase(errortext);
    }
}


