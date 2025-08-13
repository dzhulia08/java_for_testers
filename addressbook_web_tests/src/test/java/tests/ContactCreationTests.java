package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "Иван")) {
            for (var lastName : List.of("", "Иванов")) {
                for (var address : List.of("", "Адрес")) {
                    for (var phone1 : List.of("", "89091110998")) {
                        for (var email1 : List.of("", "test@test.ru")) {
                            result.add(new ContactData("", firstName, "", lastName, address, phone1,  "",  "", email1,  "",  ""));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData("", randomString(i * 5), randomString(i * 5), randomString(i * 5), randomString(i * 5), randomPhone(), randomPhone(), randomPhone(), randomEmail(i), randomEmail(i), randomEmail(i)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

}
