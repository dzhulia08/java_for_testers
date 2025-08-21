package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    public void canModifyContact() {
        if (!app.contacts().isContactPresent()){
            app.contacts().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес",
                    "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                    "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withName("modified firstName", "modified lastName").withAddress("modified address").withPhoto("src/test/resources/images/avatar.png");
        app.contacts().modifyContact(oldContacts.get(index), testData);

        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
    }
}
