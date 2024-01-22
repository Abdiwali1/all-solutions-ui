package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclesPageStepDefs {
    VehiclesPage vehiclesPage = new VehiclesPage();

    int globalCarRow;
    @Then("the user should be able to see options as {string}")
    public void the_user_should_be_able_to_see_options_as(String options) {

        String[] optionArray = options.split(",");
        List<String> strings = Arrays.stream(optionArray).map(k -> k.substring(0, 1).toUpperCase() + k.substring(1)).collect(Collectors.toList());

        vehiclesPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.sleep(5);
        vehiclesPage.checkThreeDots(strings);


    }


    @Then("the user should be able to see all the checkboxes as {string}")
    public void the_user_should_be_able_to_see_all_the_checkboxes_as_unchecked(String unchecked) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.sleep(5);
     vehiclesPage.checkAllCheckboxes(unchecked);
    }

    @When("the user select the all cars")
    public void the_user_select_the_all_cars() {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(10);
       vehiclesPage.check_all.click();
    }

    @When("the user select any car {int}")
    public void the_user_select_any_car(Integer row) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(10);
        globalCarRow=row;
       vehiclesPage.selectCar(row);
    }
    @Then("the user should be able to see car as {string}")
    public void the_user_should_be_able_to_see_car_as(String isChecked) {

        vehiclesPage.verifyCarIsSelected(globalCarRow,isChecked);

    }

}
