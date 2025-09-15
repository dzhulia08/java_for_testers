package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void creationUser(String userName) {
        click(By.xpath("//a[@class='back-to-login-link pull-left']"));
        type(By.name("username"), userName);
        type(By.xpath("//input[@id='email-field']"), String.format("%s@localhost", userName));
        click(By.xpath("//input[@type='submit']"));
    }

    public void finishCreationUser(String urlFromResponse, String password) {
        manager.driver().navigate().to(String.format("%s", urlFromResponse));
        type(By.xpath("//input[@id='password']"), password);
        type(By.xpath("//input[@id='password-confirm']"), password);
        click(By.xpath("//button[@type='submit']"));
    }
}
