package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TestStepDefs {
    @Given("I print {string}")
    public void iPrint(String text) {
        System.out.println("Hello World");
    }

    @Given("I go to {string}")
    public void iGoTo(String url) {
        if(url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }
    }

    @When("I login as a teacher")
    public void iLoginAsATeacher() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys("ask_instr@aol.com");
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys("ABC123");

    }

    @And("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("{string} home page is displayed")
    public void homePageIsDisplayed(String role) {
        String actRole = getDriver().findElement(By.xpath("//*[@class='info']")).getText();
        assertThat(actRole.contains(role)).isTrue();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }
}
