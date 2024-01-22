package com.brite.step_definition;

import com.brite.pages.*;
import com.brite.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.*;

public class US06_AddProducts {

    public US06_AddProducts(){};


    SalesPage salesPage = new SalesPage();
    InventoryPage inventoryPage = new InventoryPage();
    RepairsPage repairsPage = new RepairsPage();
    OrdersPage ordersPage = new OrdersPage();
    CalendarPage calendarPage = new CalendarPage();

    String checkBox;


    @When("user clicks sales button")
    public void user_clicks_sales_button() {
        BrowserUtils.waitForClickablility(salesPage.salesButton, 10);
        salesPage.salesButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user clicks customer button")
    public void user_clicks_customer_button() {
        BrowserUtils.waitForClickablility(salesPage.customerButton, 10);
        salesPage.customerButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("user clicks {string} button")
    public void user_clicks_button(String button) {
        WebElement buttonToClick;
        this.checkBox = button;
        switch (button) {
            case "Calendar":
                buttonToClick = calendarPage.calendarModule;
                break;
            case "create":
                buttonToClick = inventoryPage.createButton;
                break;
            case "Products":
                buttonToClick = inventoryPage.productsLink;
                break;
            case "Repairs":
                buttonToClick = repairsPage.repairsLink;
                break;
            case "Repair Reference checkbox":
                buttonToClick = repairsPage.repairReferenceCheckbox;
                break;
            case "Point of Sale":
                buttonToClick = ordersPage.POSLink;
                break;
            case "Orders":
                buttonToClick = ordersPage.ordersLinkBtn;
                break;
            case "Order Ref Checkbox":
                buttonToClick = ordersPage.recordSelectCheckbox;
                break;
            case "save":
                buttonToClick = inventoryPage.saveButton;
                break;
            case "edit":
                buttonToClick = inventoryPage.editButton;
                break;
            case "inventory":
                buttonToClick = inventoryPage.inventoryLink;
                break;
            case "test product":
                buttonToClick = inventoryPage.testProduct;
                break;
            case "Sales":
                buttonToClick = salesPage.salesButton;
                break;
            case "Quotation Number checkbox":
                buttonToClick = salesPage.quotationNumberCheckbox;
                break;
            case "customer":
                buttonToClick = salesPage.customerButton;
                break;
            default:
                buttonToClick = inventoryPage.inventoryLink;
        }
        BrowserUtils.clickWithJS(buttonToClick);
        BrowserUtils.waitFor(5);


    }

    @Then("user should see {string} on product box")
    public void user_should_see_on_product_box(String productTitle) {
        Assert.assertEquals(inventoryPage.productName.getText(),productTitle);
    }

    @Then("user writes his name on name box")
    public void user_writes_his_name_on_name_box() {
        BrowserUtils.waitForVisibility(salesPage.nameInputBox,10);
        salesPage.nameInputBox.sendKeys("Test");
        BrowserUtils.waitFor(3);
    }


    @When("user types {string} on name bar")
    public void user_types_on_name_bar(String productName) {
        inventoryPage.nameBar.clear();
        inventoryPage.nameBar.sendKeys(productName);

    }

    @Then("All the checkboxes should be checked")
    public void allTheCheckboxesShouldBeChecked() {
        List<WebElement> checkBoxList = new ArrayList<>();
        switch (checkBox){
            case "Repair Reference checkbox":
                checkBoxList = repairsPage.checkboxes;
                break;
            case "Order Ref Checkbox":
                checkBoxList = ordersPage.checkboxes;
                break;
            case "Quotation Number checkbox":
                checkBoxList = salesPage.quotationNumberCheckBoxes;
                break;
            default:
                System.out.println("There is no checkbox");
        }
        for (int i = 3; i < checkBoxList.size(); i++) {
            Assert.assertTrue(checkBoxList.get(i).isSelected());
        }
//        for (WebElement checkbox : ordersPage.checkboxes) {
//            Assert.assertTrue(checkbox.isSelected());
//        }
    }


}
