package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesCostPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclesCostPageStepDefs {

    VehiclesCostPage vehiclesCostPage=new VehiclesCostPage();

    @Then("the user should be able to see Vehicle Costs columns message as {string}")
    public void the_user_should_be_able_to_see_vehicle_costs_columns_message_as(String expectedColumns) {

        List<String> expectedColumnsList = Arrays.stream(expectedColumns.split(",")).collect(Collectors.toList());

        List<String> actualColumnsList = BrowserUtils.getElementsText(vehiclesCostPage.tableColumnNames).stream().map(k -> k.toUpperCase()).collect(Collectors.toList());
        actualColumnsList.removeIf(k->k.isEmpty());

        Assert.assertEquals(expectedColumnsList,actualColumnsList);

    }

}
