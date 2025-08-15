package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomPhone() {
        var result = "";
        for (int i = 0; i < 9; i++) {
            int rnd = (int) (Math.random() * 10);
            String rndStr = String.valueOf(rnd);
            result = result + rndStr;
        }
        result = "89" + result;
        return result;
    }

    public static String randomEmail(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n+1; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        result = result + "@" + result + ".ru" ;
        return result;
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }

}
