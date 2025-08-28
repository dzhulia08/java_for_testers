package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
//        for (var firstName : List.of("", "Иван")) {
//            for (var lastName : List.of("", "Иванов")) {
//                for (var address : List.of("", "Адрес")) {
//                    for (var phone1 : List.of("", "89091110998")) {
//                        for (var email1 : List.of("", "test@test.ru")) {
//                            result.add(new ContactData("", firstName, "", lastName, address, "src/test/resources/images/avatar.png", phone1,  "",  "", email1,  "",  ""));
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < 2; i++) {
//            result.add(new ContactData("", CommonFunctions.randomString(i * 5), CommonFunctions.randomString(i * 5), CommonFunctions.randomString(i * 5), CommonFunctions.randomString(i * 5), "src/test/resources/images/avatar.png", CommonFunctions.randomPhone(), CommonFunctions.randomPhone(), CommonFunctions.randomPhone(), CommonFunctions.randomEmail(i), CommonFunctions.randomEmail(i), CommonFunctions.randomEmail(i)));
//        }
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }

    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData("", CommonFunctions.randomString(8),
                CommonFunctions.randomString(10), CommonFunctions.randomString(4),
                CommonFunctions.randomString(5), "src/test/resources/images/avatar.png",
                CommonFunctions.randomPhone(), CommonFunctions.randomPhone(),
                CommonFunctions.randomPhone(), CommonFunctions.randomEmail(5),
                CommonFunctions.randomEmail(6), CommonFunctions.randomEmail(7)));
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateContact(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var maxId = newContacts.get(newContacts.size()-1).id();
        var expectedList = new ArrayList<>(oldContacts);
//        expectedList.add(contact.withId(maxId).withName("", "").withMiddleName("").withAddress("").withPhoto("").withPhones("", "", "").withEmail("", "", ""));
        expectedList.add(contact.withId(maxId));
        expectedList.sort(compareById);

        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canCreateContact() {
        var contact = new ContactData()
                .withName(CommonFunctions.randomString(10), CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }

    @Test
    public void canCreateContactInGroup() {
        var contact = new ContactData()
                .withName(CommonFunctions.randomString(10), CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0){
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

    @Test
    public void canCreateContactInGroupHomePage() {
        if (app.hbm().getGroupCount() == 0){
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        if (app.hbm().getContactCount() == 0){
            app.contacts().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес",
                    "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                    "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
        }
        var contact = app.hbm().getContactList().get(0);

//        int countContactsInGroup = app.hbm().getContactsInGroup(group).size();
//        if (countContactsInGroup != 0) {
//            var contactsInGroup = app.hbm().getContactsInGroup(group);
//            var allContacts = app.hbm().getContactList();
//            int i = -1;
//            for (var all : allContacts) {
//                for (var inGroup : contactsInGroup) {
//                    if (!all.id().equals(inGroup.id())) {
//                        i = Integer.parseInt(inGroup.id());
//                        contact = app.hbm().getContactList().get(i);
//                    }
//                }
//            }

        int countContactsInGroup = app.hbm().getContactsInGroup(group).size();
        if (countContactsInGroup != 0) {
            var contactsInGroup = app.hbm().getContactsInGroup(group);
            ArrayList<String> allContacts = new ArrayList<String>();
            allContacts.add(app.hbm().getContactList().toString());
            int i = -1;
            for (var inGroup : contactsInGroup) {
                 if (!allContacts.contains(inGroup.id())) {
                    i = Integer.parseInt(inGroup.id());
                    contact = app.hbm().getContactList().get(i);
                 }
            }
            if (i == -1) {
                app.contacts().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес",
                                "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                                "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
                int count = app.hbm().getContactList().size();
                contact = app.hbm().getContactList().get(count);
            }
        }

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().addContactInGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

}
