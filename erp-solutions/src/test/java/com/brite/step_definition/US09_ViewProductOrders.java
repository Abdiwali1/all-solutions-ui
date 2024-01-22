package com.brite.step_definition;

import com.brite.pages.InBoxPage;
import com.brite.pages.LoginPage;
import com.brite.pages.OrdersPage;
import com.brite.utilities.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class US09_ViewProductOrders {
    LoginPage loginPage = new LoginPage();
    OrdersPage ordersPage = new OrdersPage();
    InBoxPage inBoxPage = new InBoxPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @When("User clicks POS module")
    public void userClicksPOSModule() {
        inBoxPage.popUp.click();
        inBoxPage.POSlinkBtn.click();
        wait.until(ExpectedConditions.titleIs("Point of Sale - Odoo"));
    }

    @When("User clicks Orders menu in the POS page")
    public void userClicksOrdersMenuInThePOSPage() {
        ordersPage.ordersLinkBtn.click();
    }

    @When("User checks the Order Reference checkbox")
    public void userChecksTheOrderReferenceCheckbox() {
        ordersPage.recordSelectCheckbox.click();

    }



    @Then("User should be able to see below options")
    public void user_should_be_able_to_see_below_options(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(ordersPage.actionList);
        Assert.assertEquals(expectedOptions,actualOptions);
    }


}
