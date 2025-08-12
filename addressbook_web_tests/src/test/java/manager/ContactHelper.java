package manager;

import model.ContactData;
import org.openqa.selenium.By;


public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactsPage() {
        if (! manager.isElementPresent(By.id("search_count"))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }

    public void removeContact() {
        openContactsPage();
        selectContact();
        removeSelectedContact();
//        closeAlertAfterRemoveContact();
    }

    private void closeAlertAfterRemoveContact() {
        closeAlert();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    private void returnToContactPage() {
        click(By.linkText("home page"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.phone1());
        type(By.name("mobile"), contact.phone2());
        type(By.name("work"), contact.phone3());
        type(By.name("email"), contact.email1());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
