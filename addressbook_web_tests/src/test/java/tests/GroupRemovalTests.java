package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (!app.groups().isGroupPresent()){
            app.groups().createGroup(new GroupData("group name 1", "group middleName", "group lastName"));
        }
        app.groups().removeGroup();
    }

}
