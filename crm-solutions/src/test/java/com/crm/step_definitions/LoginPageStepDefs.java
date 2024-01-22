package com.crm.step_definitions;

import com.crm.pages.LoginPage;
import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

        System.out.println("DONE IN HOOKS");

    }

    @When("user logs in as {string}")
    public void user_logs_in_as(String userType) {
        loginPage.login(userType);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldLandOnHomePageWith(String title) {
        BrowserUtils.verifyTitleContains(title);
    }

    @When("user logged in with username as {string} and password as {string}")
    public void user_logged_in_with_username_as_and_password_as(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should be able to see error message {string}")
    public void user_should_be_able_to_see_error_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.errMessage.getText());
    }

    @Then("user should be able to see remember me box")
    public void user_should_be_able_to_see_remember_me_box() {
        Assert.assertTrue(loginPage.checkBox_rememberMe.isDisplayed());
    }

    @When("user clicks Remember me checkbox")
    public void user_click_checkbox_with_text() {
        loginPage.checkBox_rememberMe.click();
    }

    @Then("user should be able to see Remember me checkbox clicked")
    public void user_should_be_able_to_see_checkbox_clicked() {
        Assert.assertTrue(loginPage.checkBox_rememberMe.isSelected());
    }


    @Then("user should be able to see password is in bullet signs by default")
    public void user_should_be_able_to_see_password_is_in_bullet_signs_by_default() {
       Assert.assertEquals("password",BrowserUtils.getAttributeValue(loginPage.txtBox_password,"type"));
    }
}
