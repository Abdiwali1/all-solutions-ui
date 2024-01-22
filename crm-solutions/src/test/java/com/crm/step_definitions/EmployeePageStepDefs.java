package com.crm.step_definitions;

import com.crm.pages.EmployeePage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.CRMUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class EmployeePageStepDefs {
    EmployeePage employeePage = new EmployeePage();

    String expectedDepartmentName;
    @Then("user should be able to see following {int} modules in the Employees page")
    public void user_should_be_able_to_see_following_modules_in_the_employees_page(int expectedModuleNumber, List<String> expectedModules) {

        List<String> actualModules = BrowserUtils.getElementsText(employeePage.employeeModules);
        Assert.assertEquals(expectedModuleNumber, actualModules.size());
        Assert.assertEquals(expectedModules, actualModules);

    }

    @Then("user should be able to see {string} {word} page")
    public void user_should_be_able_to_see_page_page(String expectedPageTitle, String ignoredWord) {
        String actualPageTitle = employeePage.pageTitle.getText();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @When("user add department with name {string}")
    public void user_add_department_with_name(String departmentName) {

        expectedDepartmentName= CRMUtils.getFakeDepartmentName(departmentName);
        employeePage.createDepartment(expectedDepartmentName);
    }

    @Then("user should see created department")
    public void user_should_see_created_department() {
        BrowserUtils.sleep(3);
        List<String> allDeps = BrowserUtils.getElementsText(employeePage.allDepartments);
        Assert.assertTrue(allDeps.contains(expectedDepartmentName));

    }


    @Then("user should not see ADD DEPARTMENT button")
    public void user_should_not_see_add_department_button() {

       Assert.assertTrue(employeePage.btn_addDepartment.isEmpty());

    }

}
