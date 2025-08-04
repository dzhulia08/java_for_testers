import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()){
            createGroup(new GroupData("group name 1", "group header", "group footer"));
        }
        removeGroup();
    }

}
