package ru.stqa.addressbook.manager;

import org.openqa.selenium.support.ui.Select;
import ru.stqa.addressbook.model.ContactData;
import org.openqa.selenium.By;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


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

    public void createContact(ContactData contact, GroupData group) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToContactPage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void removeContact(ContactData contact) {
        openContactsPage();
        selectContact(contact);
        removeSelectedContact();
//        closeAlertAfterRemoveContact();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage();
//        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactPage();
    }

    private void initContactModification(ContactData contact) {
        click(By.xpath(String.format("//a[contains(@href, \"edit.php?id=%s\")]", contact.id())));
    }

    private void submitContactModification() {
        click(By.name("update"));
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
        click(By.linkText("home"));
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
        attach(By.name("photo"), contact.photo());
    }

    private void selectContact(ContactData contact) {
//        click(By.name("selected[]"));
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contracts = new ArrayList<ContactData>();
//        var checkboxes = manager.driver.findElements(By.xpath("//td[@class='center']/input"));
//        for (var checkbox : checkboxes) {
//            String firstName = manager.driver.findElements(By.xpath("/parent::td/following::td[1]")).toString();
//            String lastName = manager.driver.findElements(By.xpath("/parent::td/following::td[2]")).toString();
//            String address = manager.driver.findElements(By.xpath("/parent::td/following::td[3]")).toString();
//            var id = checkbox.getAttribute("value");
//            contracts.add(new ContactData().withId(id).withName(firstName, lastName).withAddress(address));
//        }
        var rows = manager.driver.findElements(By.xpath("//tr[@name='entry']"));
        for (var row : rows) {
            var input = row.findElement(By.name("selected[]"));
            var id = input.getAttribute("value");
            var lastName = row.findElement(By.xpath(String.format("//input[@value='%s']//parent::td/following::td[1]", id))).getText();
            var firstName = row.findElement(By.xpath(String.format("//input[@value='%s']//parent::td/following::td[2]", id))).getText();
            contracts.add(new ContactData().withId(id).withName(firstName, lastName));
        }
        return contracts;
    }
}
