import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCrateGroup() {
        openGroupsPage();
        createGroup("group name 1", "group header", "group footer");
    }

    @Test
    public void canCrateGroupWithEmptyName() {
        openGroupsPage();
        createGroup("", "", "");
    }

}
