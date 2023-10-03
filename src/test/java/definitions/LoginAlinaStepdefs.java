package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bouncycastle.crypto.tls.ContentType.alert;
import static support.TestContext.getDriver;
public class LoginAlinaStepdefs {


    @And("I should see page title")
    public void iShouldSeePageTitle() {
        System.out.println(getDriver().getTitle());
    }

    @Then("user name 'Max Smith' is present")
    public void userNameMaxSmithIsPresent() {
        getDriver().findElement(By.xpath("//h3[contains(text(),'Max Smith')]"));

    }

    @Then("user role 'TEACHER' is present")
    public void userRoleTEACHERIsPresent() {
        getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]"));
    }

    @Then("user name 'Name Lastname' is present")
    public void userNameNameLastnameIsPresent() {
        getDriver().findElement(By.xpath("//h3[contains(text(),'Name Lastname')]"));

    }

    @Then("user role 'STUDENT' is present")
    public void userRoleSTUDENTIsPresent() {
        getDriver().findElement(By.xpath("//p[contains(text(),'STUDENT')]"));
    }

    @And("I get allert {string}")
    public void iGetAllert(String arg0) {
        getDriver().getWindowHandles().contains(alert);

    }

    @Then("I verify that password field is masked")
    public void iVerifyThatPassworedFieledIsMasked() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type").equals("password")).isTrue();

    }

    @Then("element with xpath {string} should be disabled")
    public void elementWithXpathShouldBeDisabled(String arg0) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String arg0, String arg1) {
        String actualText = getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).getText();
        assertThat(actualText).isEqualTo("Should be a valid email address");
    }



}

