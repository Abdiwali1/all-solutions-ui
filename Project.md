# WHAT WE HAVE TO KNOW
<img src="https://drive.google.com/uc?export=view&id=1V7H5Epx7CTYPfOG8vG77h9zAX1nI-oZg">

## Please tell me about your framework?

My framework is BDD(Behavior-Driven Development) cucumber-junit framework and my main language is java with selenium. In that framework I gave two different layer one of them is business layer for non-techinical people and implementation layer for people with technical knowledge.

I have four main packages, one important folder which is features and a file configure.properties in my framework.
packages are :


![folder-structure](https://drive.google.com/uc?export=view&id=1P5Gv26yDGzygG1zrEcC2w9-Gqi5jTFxs)

pages
runners
step_definations
utils

Let me explain the details of my project.

- We used pages package in order to store web elements inside the Java classes then we are using Page Object Model in 
our framework that we are thinking each web page as a class in our framework and its elements as a variable with the locators.

- We used runners package in order to put our CukesRunner and FailedTestRunner classes in order to configure our 
where are my step definations, feature files and run my specific tests.

- We used step_definations in order to put implementation of feature file steps. In here I want to talk about Hooks 
class which we stored before  and after methods in order to repeat that methods before and after for each scenario.

- We used utilities package in order to store reusable methods inside the utility classes such as Driver,
BrowserUtilities,ConfigurationReader.

- Also We created features folder in order to put our feature files with scenarios that are written in gherkin language.

- And last We created configure.properties in order to put credentials in it

This is a summary of my framework if you have any question I can answer.

## How are you using method overloading in your framework?

First I need to explain method overloading in a simple words we can easily say method overloading is same method name with different parameter types or numebr of paremeters.

In my application we have different user types then sometimes I need to login with credentials and sometimes I need to login with different user tpyes because of that reason I created login method inside LoginPage class and one of them taking username and password and the other one is taking usertype as a paremeter.

````java

 public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        btn_submit.click();
        // verification that we logged
    }

 public void login(String role) {

        //based on input enter that user information
        String username = ConfigurationReader.getProperty(role + "_username");

        String password = ConfigurationReader.getProperty(role + "_password");

        login(username, password);

    }
````


## How to use OOP in your framework?

firstly I want to say we have four OOP consept
Encapsulation
Inheritance
Abstraction
Polymorphism

- Let's start with Encapsulation in my framework we are using Driver class with singleton design pattern
in order to implement singleton design pattern we need to control the object creation because of that reason we put one private field and also in order to get the object we create a public method which is getDriver() in order to get object.
also we know the that Encapsulation is private fields with public getter and setters.
````java
package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    //create a private constructor to remove access to this object
    private Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method.
     */
    //private static WebDriver driver; // default value = null

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and then it will always return same instance.
     */
    public static WebDriver getDriver(){

        if(driverPool.get() == null){

            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "headless-chrome":
                   // WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driverPool.get();

    }

    /*
    Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
     */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            driverPool.get().quit();
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
            driverPool.remove();
        }
    }

}


````


- We used inheritance with the page classes we created one BasePage class and we put the common elements and methods 
  in it and we extend that class from the sub classes.


````java
package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa1.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        waitUntilLoaderScreenDisappear();
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";

        Actions actions=new Actions(Driver.getDriver());
        WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
        actions.moveToElement(tabElement).pause(Duration.ofSeconds(2));
        WebElement moduleElement = Driver.getDriver().findElement(By.xpath(moduleLocator));
        actions.click(moduleElement).perform();

    }

}


//=====================================================================
public class DashboardPage extends BasePage{

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li/a//span")
    public List<WebElement> modules;

    @FindBy(xpath = "//h1[@class=\"logo logo-text\"]")
    public WebElement dashboardLogo;


    @FindBy(xpath = "//a[@class=\"help no-hash\"]")
    public WebElement link_help;

    @FindBy(xpath = "//div[@class='pin-bar-empty']/a")
    public WebElement link_pinbar;






}


````


- We used Abstraction like using abstract class which is BasePage and using some interfaces like WebDriver, JavaScriptExecuter, TakeScreenShot, SearchContext

![WebDriver_UML_TakeScreenShot](https://drive.google.com/uc?export=view&id=1VBvkqPQAtJOcPK4FgmhqHzeVaJzNPqRU)
- We used Polymorphism like below:
````java
WebDriver driver;
 driver=new ChromeDriver();
 driver=new FirefoxDriver();
````
