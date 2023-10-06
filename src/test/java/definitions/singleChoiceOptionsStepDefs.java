package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import support.TestContext;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class singleChoiceOptionsStepDefs {
    @Then("I verify that name {string} and role {string} are displayed in the home page TC")
    public void iVerifyThatNameAndRoleAreDisplayedInTheHomePageTC(String name, String role) {
        String actualName = getDriver().findElement(By.xpath("//div[@class='info']/h3")).getText();
        assertThat(actualName.equals(name)).isTrue();
        String actualRole = getDriver().findElement(By.xpath("//div[@class='info']/p")).getText();
        assertThat(actualRole.equals(role)).isTrue();
    }


    @Then("{string} field error message {string} is displayed TC")
    public void fieldErrorMessageIsDisplayedTC(String option, String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + option + "')]/../../..//*[contains(text(), '" + expectedError + "')]")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }


    @And("I type {int} character into {string} field of {string} TC")
    public void iTypeCharacterIntoFieldOfTC(int num, String optionNum, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String genString = RandomStringUtils.random(num,useLetters,useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']")).sendKeys(genString);
    }


    @And("{string} field error message is displayed TC")
    public void fieldErrorMessageIsDisplayedTC(String option) {
        assertThat(getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + option + "')]/../../..//mat-error[@role='alert']")).isDisplayed()).isTrue();
    }

    @When("I add up to {int} options to {string} and fill them up TC")
    public void iAddUpToOptionsToAndFillThemUpTC(int num, String questionNum) {
        for(int i=3; i<=num; i++){
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" +questionNum+ "')]/../../..//textarea[@placeholder='Option " + i + "*']")).sendKeys("Option " +i);
        }
    }


    @When("I add option to {string} TC")
    public void iAddOptionToTC(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
    }

    @And("I click gear icon next to {string} field of {string} TC")
    public void iClickGearIconNextToFieldOfTC(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//textarea[contains(@placeholder, '" + optionNum + "')]/../../../../..//mat-icon[contains(text(), 'settings')]")).click();
    }

    @And("I select {string} menu item TC")
    public void iSelectMenuItemTC(String menuItem) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + menuItem + "')]")).click();
    }

    @Then("text {string} is displayed in {int} field TC")
    public void textIsDisplayedInFieldTC(String  expectedText, int num) {
        String actualText = getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content'])[" + num + "]")).getText();
        assertThat(actualText.equals(expectedText)).isTrue();
    }




    @Then("error message is displayed TC")
    public void errorMessageIsDisplayedTC() {
        assertThat(getDriver().findElement(By.xpath("//mat-error")).isDisplayed()).isTrue();
    }

    @Then("radio button in {string} field of {string} is not checked TC")
    public void radioButtonInFieldOfIsNotCheckedTC(String optionNum, String questionNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), 'Q1')]/../../..//textarea[contains(@placeholder, 'Option 1')]/../../../../..//input[@type='radio']")).isSelected()).isFalse();
    }

    @Then("error message {string} is displayed TC")
    public void errorMessageIsDisplayedTC(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//div[contains(text(),'*Choose correct answer')]")).getText();
        assertThat(actualError.contains(expectedError)).isTrue();
    }

    @And("snack-bar error message is displayed in the bottom TC")
    public void snackBarErrorMessageIsDisplayedInTheBottomTC() {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar")).isDisplayed()).isTrue();
    }

    @When("I click down arrow icon of quiz {string} TC")
    public void iClickDownArrowIconOfQuizTC(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]/../../..//span[contains(@class, 'expansion')]")).click();
    }



    @And("I click {string} button of quiz {string} TC")
    public void iClickButtonOfQuizTC(String btn, String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]/../../..//span[contains(text(), '" + btn + "')]")).click();
    }

    @When("I expand the tab TC")
    public void iExpandTheTabTC() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), 'Q1')]/../..//span[contains(@class, 'expansion')]")).click();
    }

    @When("I delete quiz TC")
    public void iDeleteQuizTC() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), \"TA-742-TC9\")]/.. /../..//*[contains(text(), 'Delete')]")).click();
    }

    @And("text {string} is displayed in {string} field TC")
    public void textIsDisplayedInFieldTC(String optionText, String optionNum) {
        assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='" + optionNum + "*']")).getAttribute("value")).isEqualTo(optionText);
    }
}

