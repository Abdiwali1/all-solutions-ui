package com.brite.step_definition;

import com.brite.pages.LoginPage;
import com.brite.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;

public class US01_Login {
    LoginPage loginPage = new LoginPage();
    String username;
    String password;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user logs in as {string}")
    public void user_logs_in_as(String userType) {
        loginPage.login(userType);
    }

    @Then("user should see {string} in page title")
    public void user_should_see_in_page_title(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    @When("user logs in with invalid {string},{string}")
    public void user_logs_in_with_invalid(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String errorMsg) {
        Assert.assertEquals(errorMsg, loginPage.errorMessage.getText());
    }

    @When("user logs in with one empty field {string},{string}")
    public void user_logs_in_with_one_empty_field(String username, String password) {
        this.username = username;
        this.password = password;
        loginPage.login(username, password);
    }

    @Then("user should see alert message {string}")
    public void user_should_see_alert_message(String expectedMsg) {
        String actualMsg = "";
        if(username.isBlank()){
            actualMsg = loginPage.emailInputBox.getAttribute("validationMessage");
        }else if(password.isBlank()){
            actualMsg= loginPage.passWordInputBox.getAttribute("validationMessage");
        }
        Assert.assertEquals(expectedMsg, actualMsg);

    }



}