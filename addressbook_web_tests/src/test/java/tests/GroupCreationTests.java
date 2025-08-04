package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCrateGroup() {
        app.groups().createGroup(new GroupData("group name 1", "group header", "group footer"));
    }

    @Test
    public void canCrateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCrateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }

    @Test
    public void canCrateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void canCrateGroupWithFooterOnly() {
        app.groups().createGroup(new GroupData().withFooter("some footer"));
    }

}
