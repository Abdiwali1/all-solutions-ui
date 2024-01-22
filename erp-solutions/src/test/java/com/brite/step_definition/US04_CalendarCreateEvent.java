package com.brite.step_definition;

import com.brite.pages.CalendarPage;
import com.brite.pages.LoginPage;
import com.brite.utilities.BrowserUtils;
import com.brite.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class US04_CalendarCreateEvent {
    CalendarPage calendarPage = new CalendarPage();

    @Then("User should see {string} in the title")
    public void user_should_see_in_the_title(String expectedInTitle) {
        BrowserUtils.waitForTitleContains(expectedInTitle);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedInTitle, actualTitle);
    }

    @When("User clicks on desire time and day cell from the table")
    public void user_clicks_on_desire_time_and_day_cell_from_the_table() {
        calendarPage.day.click();
        BrowserUtils.waitFor(3);
        calendarPage.time.click();
    }

    @When("User should be able to type in desire message")
    public void user_should_be_able_to_type_in_desire_message() {
        calendarPage.eventCreateInputBox.sendKeys("meeting");
    }

    @When("User clicks on create button")
    public void user_clicks_on_create_button() {
        calendarPage.eventCreateButtonclick.click();

    }

    @Then("User should be able to see created event in the calendar")
    public void user_should_be_able_to_see_created_event_in_the_calendar() {
        BrowserUtils.waitForClickablility(calendarPage.existingEvent,10);
        calendarPage.existingEvent.click();
        Assert.assertTrue(calendarPage.eventBoxTitle.getText().contains("meeting"));

    }


    @Then("User should see the pop-up window")
    public void userShouldSeeThePopUpWindow() {
        BrowserUtils.verifyElementDisplayed(calendarPage.popUpWindow);

    }

    @Then("User should be able to see the event")
    public void user_should_be_able_to_see_the_event() {
        BrowserUtils.verifyElementDisplayed(calendarPage.createdEvent);

    }

    @When("User clicks on the event")
    public void user_clicks_on_the_event() {
        calendarPage.createdEvent.click();
    }

    @Then("User should see new window was created")
    public void user_should_see_new_window_was_created() {
        BrowserUtils.verifyElementDisplayed(calendarPage.eventCreatedWindow);
    }

    @Then("User should see the details about event")
    public void user_should_see_the_details_about_event() {
        String actualEventText = calendarPage.eventDetails.getText();
        String expectedEventText = "Starting at";
        Assert.assertTrue(actualEventText.contains(expectedEventText));

    }


}
