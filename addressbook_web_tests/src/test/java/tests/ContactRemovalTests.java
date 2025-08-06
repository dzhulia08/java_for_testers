package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()){
            app.contacts().createContact(new ContactData("Иван", "Иванович", "Иванов", "Адрес 1",
                    "89091110998", "4956768898", "4956768800",
                    "test@rt.ru", "test2@rt.ru", "test3@rt.ru"));
        }
        app.contacts().removeContact();
    }

}
