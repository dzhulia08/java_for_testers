package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount() == 0){
            app.hbm().createContact(new ContactData("", "Ivan", "Ivanovich", "Ivanov", "Address 1",
                    "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                    "", "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
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

    @Test
    public void canRemoveContactFromGroupHomePage() {
        if (app.hbm().getGroupCount() == 0){
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        if (app.hbm().getContactsInGroup(group).size() == 0) {
            var contact = new ContactData()
                    .withName(CommonFunctions.randomString(10), CommonFunctions.randomString(10))
                    .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
            app.contacts().createContact(contact, group);
        }
        var contact = app.hbm().getContactsInGroup(group).get(0);


        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().deleteContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
    }

}
