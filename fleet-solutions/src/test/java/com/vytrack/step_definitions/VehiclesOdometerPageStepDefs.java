package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesOdometerPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VehiclesOdometerPageStepDefs {

    VehiclesOdometerPage vehiclesOdometerPage = new VehiclesOdometerPage();

    @Then("the user should be able to see the default page as {int}")
    public void the_user_should_be_able_to_see_the_default_page_as(Integer expectedValue) {
        String actualValue = BrowserUtils.getElementAttribute("value", vehiclesOdometerPage.input_page_number);

        Assert.assertEquals(expectedValue+"", actualValue);

    }

    @Then("the user should be able to see the View Per Page as {int} by default")
    public void the_user_should_be_able_to_see_the_view_per_page_as_by_default(Integer expectedValue) {

        String actualValue = vehiclesOdometerPage.dropdown_view_per_page.getText().trim();

        Assert.assertEquals(expectedValue+"",actualValue);

    }


}
