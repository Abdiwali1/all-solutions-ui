package com.brite.step_definition;

import com.brite.pages.*;
import io.cucumber.java.en.Then;
import org.junit.*;

public class US13_AccessMainModules {

    InBoxPage inBoxPage = new InBoxPage();

    @Then("user should be able to access {int} modules")
    public void user_should_be_able_to_access_modules(int menuCount) {
        Assert.assertEquals(menuCount,inBoxPage.mainMenus.size());
    }

}