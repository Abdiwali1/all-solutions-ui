package net.trycloud.step_defintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.ContactsPage;
import net.trycloud.utilities.BrowserUtils;
import org.junit.Assert;




public class ContactsStepDefs {


    ContactsPage contactsPage = new ContactsPage();

    @Given("the user clicks on {string} module")
    public void the_user_clicks_on_module(String module) {

        // Navigate to "Contacts" module
        contactsPage.navigateTo(module);

    }

    @When("the user clicks on New Contact button")
    public void the_user_clicks_on_New_Contact_button() {

        // Click on "New Contact" button
        contactsPage.newContactBtn.click();

    }

    @Then("the user can put {string}")
    public void the_user_can_put_and(String contact) {

        contactsPage.contactFullName.clear();
        contactsPage.contactFullName.sendKeys(contact);

    }

    @When("the user clicks on All contacts button")
    public void the_user_clicks_on_All_contacts_button() {

        // click on "All contacts button"
        contactsPage.allContactsBtn.click();

    }

    @Then("the user should see the {string} in the All contacts list")
    public void the_user_should_see_the_initials_in_the_All_contacts_list(String expectedInitials) {


        // list of all contacts in the middle menu.
        System.out.println(ContactsPage.listOfAllContacts());

        // print expected initials
        System.out.println("expectedInitials = " + expectedInitials);

        // Verify that new contact appears in the list with matching initials
        Assert.assertTrue(ContactsPage.listOfAllContacts().contains(expectedInitials));


    }


    @Then("the user should see total number of contacts")
    public void the_user_should_see_total_number_of_contacts() {

        // get actual number (size) of "All contacts" from the list of middle menu
        int actualContactNum = ContactsPage.listOfAllContacts().size();
        System.out.println("actualContactNum = " + actualContactNum);

        // get expected number of "All contacts" from the menu and convert to int.
        int expectedContactNum = Integer.parseInt(contactsPage.contactTotalNum.getText());
        System.out.println("expectedContactNum = " + expectedContactNum);

        // Verify number of all contacts
        Assert.assertEquals(expectedContactNum, actualContactNum);

    }

    @When("the user clicks on an existing contact")
    public void the_user_clicks_on_an_existing_contact() {

        // click on an existing contact
        contactsPage.contactAvatar.click();

    }

    @When("the user clicks on the avatar icon on the right side")
    public void the_user_clicks_on_the_avatar_icon_on_the_right_side() {

        // Click on the avatar icon on the right sid of the page
        contactsPage.avatarMenuOptions.click();

    }

    @Then("the user clicks on Choose from files option")
    public void the_user_clicks_on_Choose_from_files_option() {

        // click on "Choose from files"
        contactsPage.chooseFromFiles.click();


    }

    @Then("the user should be able to change the profile picture")
    public void the_user_should_be_able_to_change_the_profile_picture() {

        // click on picture
        contactsPage.pictureFile.click();

        // click on Choose
        contactsPage.chooseButton.click();

        // Verify the picture changed
        Assert.assertTrue(contactsPage.contactAvatar.isEnabled());
    }


    @When("the user selects any {string} on the middle column")
    public void the_user_selects_any_on_the_middle_column(String contact) {

        // Find the index number of the contact that will be deleted
        int indexOfChosenContact = ContactsPage.listOfAllContacts().indexOf(contact);
        System.out.println("indexOfChosenContact = " + indexOfChosenContact);

        // Find the web element of the chosen contact from the list of web elements according to index number and get the text
        String chosenContact = ContactsPage.listOfAllContactsWebelements().get(indexOfChosenContact).getText();
        System.out.println("chosenContact = " + chosenContact);

        // Click on the chosen contact
        ContactsPage.listOfAllContactsWebelements().get(indexOfChosenContact).click();

    }

    @When("the user clicks on Delete option from the three dotted menu")
    public void the_user_clicks_on_Delete_option_from_the_three_dotted_menu() {

        // Click on three dotted menu
        contactsPage.threeDotMenu.click();

        // Click on "Delete" option from the menu;
        contactsPage.deleteOption.click();

    }

    @Then("the user should be able to delete the {string}")
    public void the_user_should_be_able_to_delete_the_contact(String contact) {

        // Print the contact that will be deleted
        System.out.println("Deleted contact = " + contact);

        // Verify that the contact is not in the list anymore
        Assert.assertFalse(ContactsPage.listOfAllContacts().contains(contact));

        // Print the new list after deleting
        System.out.println("ContactsPage.listOfAllContacts() = " + ContactsPage.listOfAllContacts());


    }

    @And("the user {string} should be deleted after test")
    public void theUserShouldBeDeletedAfterTest(String name) {
        contactsPage.getContact(name).click();
        contactsPage.contactMenu.click();
        contactsPage.deleteOption.click();
    }
}