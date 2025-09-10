package ru.stqa.mantis.manager;

import org.openqa.selenium.io.CircularOutputStream;
import org.openqa.selenium.os.CommandLine;
import org.openqa.selenium.os.ExternalProcess;

import java.time.Duration;

public class JamesCliHelper extends HelperBase {

    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser(String email, String password){
//        ExternalProcess.builder()
//                .command("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "AddUser", email, password)
//                .directory(manager.property("james.workingDir"))
//                .copyOutputTo(System.err)
//                .start()
//                .waitFor(Duration.ofHours(1));

        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"",
                "org.apache.james.cli.ServerCmd",
                "AddUser", email, password);
        cmd.setWorkingDirectory(manager.property("james.workingDir"));
        CircularOutputStream out = new CircularOutputStream();
        cmd.copyOutputTo(out);
        cmd.execute();
        cmd.waitFor();
        System.out.println(out);
    }

}
