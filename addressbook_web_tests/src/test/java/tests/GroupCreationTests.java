package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCrateGroup() {
        TestBase.app.openGroupsPage();
        TestBase.app.createGroup(new GroupData("group name 1", "group header", "group footer"));
    }

    @Test
    public void canCrateGroupWithEmptyName() {
        TestBase.app.openGroupsPage();
        TestBase.app.createGroup(new GroupData());
    }

    @Test
    public void canCrateGroupWithNameOnly() {
        TestBase.app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        TestBase.app.createGroup(groupWithName);
    }

    @Test
    public void canCrateGroupWithHeaderOnly() {
        TestBase.app.openGroupsPage();
        TestBase.app.createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void canCrateGroupWithFooterOnly() {
        TestBase.app.openGroupsPage();
        TestBase.app.createGroup(new GroupData().withFooter("some footer"));
    }

}
