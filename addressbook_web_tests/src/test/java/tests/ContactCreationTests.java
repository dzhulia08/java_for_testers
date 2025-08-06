package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("Иван", "Иванович", "Иванов", "Адрес 1",
                "89091110998", "4956768898", "4956768800",
                "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactData().withName("Иван", "Иванов"));
    }

    @Test
    public void canCreateContactWithAddressOnly() {
        app.contacts().createContact(new ContactData().withAddress("Адрес 2"));
    }

    @Test
    public void canCreateContactWithPhonesOnly() {
        app.contacts().createContact(new ContactData().withPhones("89091110998", "4956768898", ""));
    }

    @Test
    public void canCreateContactWithEmailOnly() {
        app.contacts().createContact(new ContactData().withEmail("test@rt.ru", "", ""));
    }

}
