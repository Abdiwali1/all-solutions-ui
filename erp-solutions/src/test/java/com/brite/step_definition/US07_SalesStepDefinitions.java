package com.brite.step_definition;

import com.brite.pages.*;
import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US07_SalesStepDefinitions {

    LoginPage loginPage=new LoginPage();
    SalesPage salesPage=new SalesPage();
    InBoxPage inBoxPage=new InBoxPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

   /* @Given("user is on the login page")
   public void userIsOnTheLoginPage() {Driver.getDriver().get(ConfigurationReader.getProperty("url"));
created duplicated step definition exception
}*/

    @When("User enters {string} on the SearchBox")
    public void userEntersOnTheSearchBox(String searchQuote) {
        salesPage.SearchBox.sendKeys(searchQuote+ Keys.ENTER);
    }

    @When("user enters POS manager credentials and login")
    public void userEntersPOSManagerCredentialsAndLogin() {
        loginPage.login(ConfigurationReader.getProperty("posmanager_username"), ConfigurationReader.getProperty("posmanager_password"));
          }

    @When("User is on the sales page")
    public void userIsOnTheSalesPage() {

        inBoxPage.SalesLinkBtn.click();

        wait.until(ExpectedConditions.titleIs("Quotations - Odoo"));

    }


    @When("user enters  sales manager credentials and login")
    public void userEntersSalesManagerCredentialsAndLogin() {
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));

    }
    @Then("User should be able to see {int} columns of the quotations")
    public void userShouldBeAbleToSeeColumnsOfTheQuotations(int arg0) {

        Assert.assertEquals(arg0,salesPage.QoutesTableColumns.size());

    }


    @Then("User should be able to see the result on the list with the {string}")
    public void userShouldBeAbleToSeeTheResultOnTheListWithThe(String searchQuote) {

        wait.withTimeout(Duration.ofSeconds(5));
        String ActualResult= salesPage.searchedOrderNumber.getText();
        Assert.assertEquals(searchQuote,ActualResult);


    }
}
