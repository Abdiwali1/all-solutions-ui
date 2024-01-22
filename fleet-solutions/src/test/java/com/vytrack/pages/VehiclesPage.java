package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class VehiclesPage extends BasePage {

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//*[@class='launcher-item']//a")
    public List<WebElement> list_Icon;


    @FindBy(xpath = "//tbody//input[@type='checkbox']")
    public List<WebElement> list_checkbox;

    @FindBy(xpath = "(//table//th//input[@type='checkbox'])[1]")
    public WebElement check_all;


    public void checkThreeDots(List<String> expectedOptions) {

        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println("i = " + i);

        String locator = "(//div[@class='dropdown']//*[text()='...'])[" + (i + 1) + "]";
        WebElement eachThreeDot = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.hover(eachThreeDot);

        List<String> actualOptions = BrowserUtils.getElementsTextWithAttribute("title", list_Icon);

        Assert.assertEquals(expectedOptions, actualOptions);

    }

    public void checkAllCheckboxes(String isChecked) {

        boolean res = isChecked.equals("unchecked") ? false : true;

        System.out.println("list_checkbox.size() = " + list_checkbox.size());

        for (WebElement checkbox : new VehiclesPage().list_checkbox) {
            BrowserUtils.hover(checkbox);
            Assert.assertEquals(res, checkbox.isSelected());
        }

    }


    public void selectCar(int row) {
            WebElement car = list_checkbox.get(row - 1);
            BrowserUtils.hoverAndClick(car);

    }

    public void verifyCarIsSelected(int row,String isChecked) {
        boolean res = isChecked.equals("unchecked") ? false : true;

            WebElement car = list_checkbox.get(row - 1);
            Assert.assertEquals(res,car.isSelected());

    }


}
