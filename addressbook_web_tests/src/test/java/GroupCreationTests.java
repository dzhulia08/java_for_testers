import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCrateGroup() {
        openGroupsPage();
        createGroup(new GroupData("group name 1", "group header", "group footer"));
    }

    @Test
    public void canCrateGroupWithEmptyName() {
        openGroupsPage();
        createGroup(new GroupData());
    }

    @Test
    public void canCrateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        createGroup(groupWithName);
    }

    @Test
    public void canCrateGroupWithHeaderOnly() {
        openGroupsPage();
        createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void canCrateGroupWithFooterOnly() {
        openGroupsPage();
        createGroup(new GroupData().withFooter("some footer"));
    }

}
