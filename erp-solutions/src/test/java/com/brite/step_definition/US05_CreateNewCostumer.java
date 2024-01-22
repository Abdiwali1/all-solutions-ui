package com.brite.step_definition;

import com.brite.pages.*;
import com.brite.utilities.*;
import io.cucumber.java.en.*;

import java.util.*;

public class US05_CreateNewCostumer {

    SalesPage salesPage = new SalesPage();

    @When("user clicks any customer module")
    public void user_clicks_any_customer_module() {
        Random random = new Random();
        int randomNumber = random.nextInt(salesPage.customerList.size());
        BrowserUtils.clickWithJS(salesPage.customerList.get(randomNumber));
    }
    @Then("user able to click edit button")
    public void user_able_to_click_edit_button() {
        BrowserUtils.verifyElementDisplayed(salesPage.editButton);
    }
}
