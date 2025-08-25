package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
//        if (!app.hbm().isContactPresent()){
        if (app.hbm().getContactCount() == 0){
            app.hbm().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес 1",
                    "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                    "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
        }
        var oldContracts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContracts.size());
        app.contacts().removeContact(oldContracts.get(index));
        var newContracts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContracts);
        expectedList.remove(index);
        Assertions.assertEquals(newContracts, expectedList);
    }

}
