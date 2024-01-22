package com.crm.pages;

import com.crm.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeePage extends BasePage{
    @FindBy(xpath = "//div[@id='top_menu_id_company']//span[@class='main-buttons-item-text']/span[2]")
    public List<WebElement> employeeModules;

    @FindBy(xpath = "//div[@id='bx_visual_structure']//table[2]/tbody/tr[1]/td/span//a")
    public List<WebElement> allDepartments;


    @FindBy(xpath = "//span[.='Add department']/..")
    public List<WebElement> btn_addDepartment;

    @FindBy(xpath = "//span[.='Add']")
    private WebElement btn_add;


    @FindBy(xpath = "//span[.='Close']")
    public WebElement btn_close;


    @FindBy(css = "input#NAME")
    private WebElement txt_departmentName;

    @FindBy(xpath = "//td[@class='bx-str-last']//a")
    public WebElement txt_lastDepartment;



    public void createDepartment(String departmentName){
        btn_addDepartment.get(0).click();
        txt_departmentName.sendKeys(departmentName);
        btn_add.click();
    }


}
