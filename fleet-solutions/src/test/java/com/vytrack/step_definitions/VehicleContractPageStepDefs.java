package com.vytrack.step_definitions;

import com.vytrack.pages.VehicleContractPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.vytrack.utilities.BrowserUtils.sleep;

public class VehicleContractPageStepDefs {

    VehicleContractPage vehicleContractPage = new VehicleContractPage();

    @Then("the user should be able to see message as {string}")
    public void the_user_should_be_able_to_see_message_as(String expectedMessage) {
        vehicleContractPage.waitUntilLoaderScreenDisappear();
        String actualMessage = vehicleContractPage.txt_message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

}
