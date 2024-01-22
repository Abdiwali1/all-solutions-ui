package com.crm.step_definitions;

import com.crm.pages.HomePage;
import com.crm.pages.ProfilePage;
import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfilePageStepDefs {
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    @When("user clicks profile dropdown")
    public void user_clicks_profile_dropdown() {
        homePage.userProfileDropdown.click();
    }

    @When("user clicks {string} option from profile options")
    public void user_clicks_option_from_profile_options(String option) {
        homePage.clickProfileOptionWithText(option);
    }

    @When("user click navigate back button")
    public void user_click_navigate_back_button() {
        BrowserUtils.navigateToBack();
    }

    @Then("user should be able to see {int} options under the profile name")
    public void user_should_be_able_to_see_options_under_the_profile_name(int expectedOptionNumber, List<String> expectedOptions) {

        Assert.assertEquals(expectedOptionNumber, homePage.userProfileDropdownOptions.size());

        Assert.assertEquals(expectedOptions, BrowserUtils.getElementsText(homePage.userProfileDropdownOptions));


    }

    @Then("user should be able to see the following options on My Profile page like {string}")
    public void user_should_be_able_to_see_the_following_options_on_my_profile_page_like(String options) {
        String[] optionArray = options.split(", ");
        List<String> expectedOptions = Arrays.stream(optionArray).collect(Collectors.toList());
        List<String> actualOptions = BrowserUtils.getElementsText(profilePage.userProfileOptions);
        Assert.assertEquals(expectedOptions, actualOptions);

    }

    @Then("user should be able to see the email {string} under the General tab is the same as the user’s account.")
    public void user_should_be_able_to_see_the_email_under_the_general_tab_is_the_same_as_the_user_s_account(String expectedEmail) {
        String actualEmail = profilePage.userEmail.getText();
        Assert.assertEquals(expectedEmail, actualEmail);


    }

}
