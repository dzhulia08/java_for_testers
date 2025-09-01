package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import ru.stqa.addressbook.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected static ApplicationManager app;

    protected static ContactData getContactForAddedToGroup(GroupData group) {
        ContactData contact = null;
        if (app.hbm().getContactCount() == 0){
            app.contacts().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес",
                    "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                    "", "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
            contact = app.hbm().getContactList().get(0);
        } else {
            int countContactsInGroup = app.hbm().getContactsInGroup(group).size();
            if (countContactsInGroup == 0) {
                contact = app.hbm().getContactList().get(0);
            } else {
                app.contacts().createContact(new ContactData("", "Иван", "Иванович", "Иванов", "Адрес",
                        "src/test/resources/images/avatar.png", "89091110998", "4956768898", "4956768800",
                        "", "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
                int count = app.hbm().getContactList().size();
                contact = app.hbm().getContactList().get(count-1);
            }
        }
        return contact;
    }

    @BeforeEach
    public void setUp() throws IOException {
        if (app == null){
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "firefox"), properties);
        }
    }

    @AfterEach
    void checkDatabaseConsistency() {
        app.jdbc().checkConsistency();
    }

}
