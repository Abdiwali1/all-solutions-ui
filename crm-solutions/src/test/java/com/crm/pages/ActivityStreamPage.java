package com.crm.pages;

import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

import static com.crm.utilities.BrowserUtils.*;
import static com.crm.utilities.CRMUtils.getFakeMessage;

public class ActivityStreamPage extends BasePage {

    @FindBy(xpath = "//div[@class='feed-post-text-block']/div/div")
    public List<WebElement> messages;

    @FindBy(className = "vote-checkbox")
    public WebElement checkBox_allowMultiple;

    @FindBy(css = ".feed-post-text-block a")
    private List<WebElement> linksInMessages;
    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageBoxFrame;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBox;

    @FindBy(xpath = "//div[@id='feed-add-post-form-notice-blockblogPostForm']//span[2]")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement toSend;

    @FindBy(xpath = "//tr[contains(@id,'disk-edit-attachn')]/td[1]/span/span[1]")
    public WebElement uploadedFile;

    @FindBy(xpath = "//tr[contains(@id,'disk-edit-attachn')]")
    public List<WebElement> uploadedFileList;


    @FindBy(xpath = "//div[@id='feed-add-post-form-tab']/span/span[1]")
    public List<WebElement> tabOptions;

    @FindBy(xpath = "//span[@id='feed-add-post-form-link-more']/span[@class='feed-add-post-form-link']")
    public List<WebElement> moreOptions;




    @FindBy(xpath = "//input[@name='bxu_files[]']")
    private WebElement btn_uploadedFile;

    @FindBy(xpath = "//img")
    private WebElement picture;


    public void selectActivity(String activity) {
        String locator = "(//div[@class='microblog-top-tabs-visible']//span[contains(.,'" + activity + "')])[1]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    public void uploadFile(String fileName) {
        String fileSeparator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + fileSeparator + "src/test/resources/files" + fileSeparator + fileName;
        btn_uploadedFile.sendKeys(path);

    }


    public String getNthMessage(int indexOfMessage) {
        return messages.get(indexOfMessage - 1).getText();
    }

    public String getFirstMessage() {
        return messages.get(0).getText();
    }

    public WebElement getFirstLink() {
        waitFor(5);
        return linksInMessages.get(0);
    }


    public String sendMessage(String message) {

        String expectedSentMessage = getFakeMessage(message);
        switchToFrame(messageBoxFrame);
        messageBox.clear();
        messageBox.sendKeys(expectedSentMessage);
        switchToDefaultContent();
        return expectedSentMessage;
    }


    public String getMessageContent() {
        switchToFrame(messageBoxFrame);
        String message=messageBox.getText();
        switchToDefaultContent();
        return message;
    }

    public String getPictureSrcFromMessage() {
        switchToFrame(messageBoxFrame);
        BrowserUtils.waitFor(5);
        String source=picture.getAttribute("src");
        switchToDefaultContent();
        return source;
    }


    public void selectMoreOption(String option){
        String locator="(//span[contains(.,'"+option+"')])[2]/..";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        element.click();
    }
}
