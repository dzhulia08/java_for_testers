package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
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
        var oldContracts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContracts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContracts.sort(compareById);

        var expectedList = new ArrayList<>(oldContracts);
        expectedList.add(contact.withId(newContracts.get(newContracts.size()-1).id()).withName("", "").withMiddleName("").withAddress("").withPhones("", "", "").withEmail("", "", ""));
        expectedList.sort(compareById);

        Assertions.assertEquals(newContracts, expectedList);
    }

}
