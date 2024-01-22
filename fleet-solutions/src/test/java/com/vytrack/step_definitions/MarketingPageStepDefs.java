package com.vytrack.step_definitions;

import com.vytrack.pages.MarketingPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import static com.vytrack.utilities.BrowserUtils.click;

public class MarketingPageStepDefs {

    MarketingPage marketingPage = new MarketingPage();


    @When("the user clicks manage filters button")
    public void the_user_clicks_manage_filters_button() {
        click(marketingPage.button_manage_filters);
    }


    @Then("the user should be able to see all {int} filter options as checked by default")
    public void the_user_should_be_able_to_see_all_filter_options_as_checked_by_default(int expectedFilteredNumber) {



        int actualFilteredNumber =marketingPage.getCheckedFilterNumber();

        Assert.assertEquals(expectedFilteredNumber, actualFilteredNumber);
    }

    @Then("the user should be able to uncheck filter options")
    public void the_user_should_be_able_to_uncheck_filter_options() {

       marketingPage.select_fiter_options.get(0).click();


        int size1 = marketingPage.getCheckedFilterNumber();
        Assert.assertEquals(4, size1);

        marketingPage.select_fiter_options.get(1).click();
        marketingPage.select_fiter_options.get(2).click();


        int size2 = marketingPage.getCheckedFilterNumber();

        Assert.assertEquals(2, size2);
    }
}
