package com.crm.step_definitions;

import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class GeneralStepDefs {
    @When("user switches to next page with {string}")
    public void user_switchs_to_next_page(String title) {
        BrowserUtils.switchToWindow(title);
    }

}
