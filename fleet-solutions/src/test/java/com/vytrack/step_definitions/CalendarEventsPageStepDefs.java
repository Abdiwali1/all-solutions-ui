package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.vytrack.utilities.BrowserUtils.click;
import static com.vytrack.utilities.BrowserUtils.sleep;

public class CalendarEventsPageStepDefs {


    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    String expectedDescription;

    @When("the user clicks create calendar event")
    public void the_user_clicks_create_calendar_event() {
calendarEventsPage.waitUntilLoaderScreenDisappear();
       click( calendarEventsPage.link_create_calender_event);

    }

    @When("the user checks Repeat checkbox")
    public void the_user_checks_repeat_checkbox() {
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        click(calendarEventsPage.checkbox_repeat);

    }

    @Then("the user should be able to see the number {int} by default in the Repeat Every input option")
    public void the_user_should_be_able_to_see_the_number_by_default_in_the_repeat_every_input_option(Integer expectedValue) {
        String actualValue = BrowserUtils.getElementAttribute("value", calendarEventsPage.textbox_repeat_every_day);
        Assert.assertEquals(expectedValue+"",actualValue);

    }

    @When("the user delete the default value Calendar event Repeat Every field")
    public void the_user_delete_the_default_value_calendar_event_repeat_every_field() {
        calendarEventsPage.textbox_repeat_every_day.clear();
        calendarEventsPage.textbox_repeat_every_day.click();
    }

    @When("the user enter the value {int} Calendar event Repeat Every field")
    public void the_user_enter_the__value_calendar_event_repeat_every_field(int value) {
        sleep(2);
        calendarEventsPage.textbox_repeat_every_day.clear();
        calendarEventsPage.textbox_repeat_every_day.sendKeys(value+"");
    }
    @Then("the user should be able to see the error message as {string}")
    public void the_user_should_be_able_to_see_the_error_message_as(String expectedMessage) {

        String actualMessage = calendarEventsPage.msg_error_repeat_every_day.getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }


    @When("the user text into Description {string}")
    public void the_user_text_into_description(String description) {
        expectedDescription=description;

        Driver.getDriver().switchTo().frame(calendarEventsPage.iframe_element);
        calendarEventsPage.textarea_description.sendKeys(description);


    }
    @Then("the user should be able to text")
    public void the_user_should_be_able_to_text() {

        String actualDescription = calendarEventsPage.textarea_description.getText();

        Assert.assertEquals(expectedDescription,actualDescription);

    }


}
