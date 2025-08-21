package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()){
            app.contacts().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес 1",
                    "", "89091110998", "4956768898", "4956768800",
                    "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
        }
        var oldContracts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContracts.size());
        app.contacts().removeContact(oldContracts.get(index));
        var newContracts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContracts);
        expectedList.remove(index);
        Assertions.assertEquals(newContracts, expectedList);
    }

}
