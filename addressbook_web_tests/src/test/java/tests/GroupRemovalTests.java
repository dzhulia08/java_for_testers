package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        TestBase.app.openGroupsPage();
        if (!TestBase.app.isGroupPresent()){
            TestBase.app.createGroup(new GroupData("group name 1", "group header", "group footer"));
        }
        TestBase.removeGroup();
    }

}
