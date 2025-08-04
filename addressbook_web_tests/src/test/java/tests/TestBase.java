package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class TestBase {

    protected static ApplicationManager app;

    protected static void removeGroup() {
        ApplicationManager.driver.findElement(By.name("selected[]")).click();
        ApplicationManager.driver.findElement(By.name("delete")).click();
        ApplicationManager.driver.findElement(By.linkText("group page")).click();
    }

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
        app.init();
    }

}
