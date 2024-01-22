package com.crm.step_definitions;

import com.crm.pages.DrivePage;
import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class DrivePageStepDefs {
    DrivePage drivePage=new DrivePage();
    @Then("user should be able to see following {int} modules in the Drive page")
    public void userShouldBeAbleToSeeFollowingModulesInTheDrivePage(int expectedModuleNumbers, List<String>expectedModules) {
        List<String> actualModules = BrowserUtils.getElementsText(drivePage.allModulesOfDrivePage);
        Assert.assertEquals(expectedModuleNumbers, actualModules.size());
        Assert.assertEquals(expectedModules, actualModules);

    }
}
