package com.brite.step_definition;

import com.brite.pages.DocumentationPage;
import com.brite.utilities.*;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.*;

public class US10_AccessDocumentationPage {

    DocumentationPage documentationPage = new DocumentationPage();
    WebDriver driver = Driver.getDriver();


    @Then("user lands on Odoo Documentations Page")
    public void userLandsOnOdooDocumentationsPage() {
        documentationPage.userIcon.click();
        documentationPage.docLink.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Odoo Documentation")) {
                break;
            }

        }
    }

    @Then("user should see {string} in header")
    public void user_should_see_in_header(String header) {
        Assert.assertEquals(documentationPage.OdooDocsMessage.getText().strip(), header);
    }

    @Then("user should see below document topics")
    public void user_should_see_below_document_topics(List<String> expectedResult) {
        List<String> actualResult = BrowserUtils.getElementsText(documentationPage.documentTopics);
        Assert.assertEquals(expectedResult,actualResult);
    }


}
