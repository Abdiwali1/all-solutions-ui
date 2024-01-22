package com.crm.step_definitions;

import com.crm.pages.CompanyPage;
import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CompanyStepDefs {
    CompanyPage companyPage=new CompanyPage();
    @Then("user should be able to see following {int} modules in the Company page")
    public void userShouldBeAbleToSeeFollowingModulesInTheCompanyPage(int expectedModuleNumbers, List<String>expectedModules) {

        List<String> actualModules = BrowserUtils.getElementsText(companyPage.modules);
        Assert.assertEquals(expectedModuleNumbers, actualModules.size());
        Assert.assertEquals(expectedModules, actualModules);

    }
}
