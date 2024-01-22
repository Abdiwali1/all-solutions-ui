package com.vytrack.step_definitions;

import com.vytrack.pages.VehicleModelPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class VehicleModelPageStepDefs {

    VehicleModelPage vehicleModelPage=new VehicleModelPage();
    @Then("the user should be able to see below column names")
    public void the_user_should_be_able_to_see_below_column_names(List<String> expectedColumnNames) {
        vehicleModelPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(vehicleModelPage.pageSubTitle,30);
        BrowserUtils.waitForClickablility(vehicleModelPage.btnCreateVehiclesModel,30);
        List<String> actualColumnNames = BrowserUtils.getElementsText(vehicleModelPage.tableColumnNames);
        actualColumnNames.removeIf(k->k.isBlank());
        Set<String> set=new LinkedHashSet<>(actualColumnNames);

        Assert.assertEquals(expectedColumnNames,new LinkedList<>(set));

    }
}
