package com.brite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.brite.utilities.Driver;


public class CalendarPage {

    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement accountName;

    @FindBy(xpath = "//button[.='Day']")
    public WebElement dayButton;

    @FindBy(xpath = "(//table//table//th[2])")
    public WebElement dayHeader;

    @FindBy(xpath = "((//td[@class='fc-axis fc-widget-content'])[2])")
    public WebElement timeColumn;


    @FindBy(xpath = "//span[normalize-space(text())='Calendar']")
    public WebElement calendarModule;


    @FindBy(xpath = "//div[@class='fc-row fc-widget-header']")
    public WebElement daysOfTheWeek;

    @FindBy(xpath = "//button[.='Week']")
    public WebElement weekModule;


    @FindBy(xpath = "//thead[@class='fc-head']")
    public WebElement daysOfTheWeekInMonth;

    @FindBy(xpath = "//div[@class='fc-day-grid fc-unselectable']")
    // @FindBy(xpath = "//tbody[@class='fc-body']")
    public WebElement datesOfTheMonthTable;

    @FindBy(xpath = "//button[.='Month']")
    public WebElement monthButton;

    @FindBy(xpath = "//table//tbody//tr[19]//td[2]")
    public WebElement event;

    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement popUpWindow;


    @FindBy(xpath = "//input[@name='name']")
    public WebElement eventCreateInputBox;

    @FindBy(xpath = "//span[normalize-space()='Create']")
    public WebElement eventCreateButtonclick;

    @FindBy(xpath = "//div[@class='fc-content']")
    public WebElement existingEvent;

    @FindBy(xpath = "(//td[contains(@class,'today')])[2]")
    public WebElement todayDay;


    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement eventCreatedWindow;


    @FindBy(xpath = "(//table)[7]//td[5]//a")
    public WebElement createdEvent;


    @FindBy(xpath = "(//table//td[1]/label[text()='Starting at'])[2] ")
    public WebElement eventDetails;

    @FindBy(xpath = "//h4")
    public WebElement eventBoxTitle;

    @FindBy(xpath = "//table[@class=\"ui-datepicker-calendar\"]//td[contains(.,'19')]")
    public WebElement day;

    @FindBy(xpath = "//tr[contains(@data-time,'09:00:00')]")
    public WebElement time;

}


