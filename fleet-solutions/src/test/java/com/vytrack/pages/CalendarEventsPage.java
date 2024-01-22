package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends BasePage{

    @FindBy(xpath = "//div[@id='container']//a[contains(.,'Create Calendar event')]")
    public WebElement link_create_calender_event;

    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat')]")
    public WebElement checkbox_repeat;


    @FindBy(xpath = "(//div[@class='recurrence-subview-control__item'])[1]/label/input[3]")
    public WebElement textbox_repeat_every_day;

    @FindBy(xpath = "(//div[@class='recurrence-subview-control__item'])[1]/label/input[3]/../../span")
    public WebElement msg_error_repeat_every_day;


    @FindBy(xpath = "//iframe")
    public WebElement iframe_element;

    @FindBy(xpath = "//p")
    public WebElement textarea_description;





}
