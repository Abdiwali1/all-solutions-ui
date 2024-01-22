package com.vytrack.step_definitions;

import com.vytrack.pages.HelpPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HelpPageStepDefs {

HelpPage helpPage=new HelpPage();
    @Then("the user should be able to see title on home page as {string}")
    public void the_user_should_be_able_to_see_title_on_home_page_as(String expectedText) {
        BrowserUtils.waitForVisibility(helpPage.text_How_To_Use_Pinbar,20);
        String actualText = helpPage.text_How_To_Use_Pinbar.getText().trim();
        Assert.assertEquals(expectedText,actualText);

    }
    @Then("the user should be able to see explanation on home page as {string}")
    public void the_user_should_be_able_to_see_explanation_on_home_page_as(String expectedText) {
        String actualText = helpPage.text_Use_pin_icon_on_the_right_top_corner.getText().trim();
        Assert.assertEquals(expectedText,actualText);
    }

    @Then("the user should be able to see the image with source {string} on the help page")
    public void the_user_should_be_able_to_see_the_image_with_source_on_the_help_page(String expectedSource) {
        String actualSource = helpPage.img_How_To_Use_Pinbar.getAttribute("src");
        Assert.assertTrue(actualSource.endsWith(expectedSource));
    }



}
