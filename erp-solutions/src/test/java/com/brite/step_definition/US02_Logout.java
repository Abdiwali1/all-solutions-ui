package com.brite.step_definition;

import com.brite.pages.*;
import com.brite.utilities.*;
import io.cucumber.java.en.*;
import org.junit.*;

public class US02_Logout {

    LoginPage loginPage = new LoginPage();
    InBoxPage inBoxPage = new InBoxPage();

    @Given("user is logged in")
    public void user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login("posmanager75@info.com","posmanager");

    }

    @When("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        inBoxPage.userMenu.click();
        inBoxPage.logoutBtn.click();
    }

    @Then("validate user is on the login page")
    public void validate_user_is_on_the_login_page() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigurationReader.getProperty("url");
        Assert.assertEquals(expectedUrl,actualUrl);
    }

}
