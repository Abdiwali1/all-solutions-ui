package com.brite.step_definition;

import com.brite.pages.CalendarPage;
import com.brite.pages.LoginPage;
import com.brite.utilities.BrowserUtils;
import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US03_ViewCalendar {
    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();

    @Given("user is on the login page of the Brite ERP application")
    public void user_is_on_the_login_page_of_the_brite_erp_application() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        loginPage.emailInputBox.sendKeys(email);
        loginPage.passWordInputBox.sendKeys(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }


    @Then("User should see {string} on the page")
    public void user_should_see_on_the_page(String expectedName) {
        String actualName = calendarPage.accountName.getText();
        Assert.assertEquals(actualName, expectedName);
    }


    @When("User clicks on calendar module")
    public void user_clicks_on_calendar_module() {
        BrowserUtils.waitForClickablility(calendarPage.calendarModule,10);
        calendarPage.calendarModule.click();
    }

    @Then("User should be able to see Day module")
    public void user_should_be_able_to_see_day_module() {
        BrowserUtils.verifyElementDisplayed(calendarPage.dayButton);
    }

    @When("User clicks on Day module")
    public void user_clicks_on_day_module() {
        calendarPage.dayButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    @Then("User should be able to see Day header")
    public void user_should_be_able_to_see_day_header() {
        //BrowserUtils.sleep(6);
        BrowserUtils.verifyElementDisplayed(calendarPage.dayHeader);
    }

    @Then("User should be able to see time column")
    public void user_should_be_able_to_see_time_column() {
        //BrowserUtils.sleep(6);
        BrowserUtils.verifyElementDisplayed(calendarPage.timeColumn);
    }


    @Then("User should be able to see Week module")
    public void user_should_be_able_to_see_week_module() {
        BrowserUtils.verifyElementDisplayed(calendarPage.weekModule);
    }

    @Then("User should be able to see Days of the Week")
    public void user_should_be_able_to_see_days_of_the_week() {
        BrowserUtils.verifyElementDisplayed(calendarPage.daysOfTheWeek);
    }


    @Then("User should be able to see Month module")
    public void userShouldBeAbleToSeeMonthModule() {
        BrowserUtils.verifyElementDisplayed(calendarPage.monthButton);
    }

    @When("User clicks on Month module")
    public void userClicksOnMonthModule() {
        calendarPage.monthButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    }

    @Then("User should be able to see Days of the month")
    public void userShouldBeAbleToSeeDaysOfTheMonth() {
        BrowserUtils.verifyElementDisplayed(calendarPage.daysOfTheWeekInMonth);


    }

    @And("User should be able to see Dates of the month in a table")
    public void userShouldBeAbleToSeeDatesOfTheMonthInATable() {
        BrowserUtils.verifyElementDisplayed(calendarPage.datesOfTheMonthTable);
    }
}




