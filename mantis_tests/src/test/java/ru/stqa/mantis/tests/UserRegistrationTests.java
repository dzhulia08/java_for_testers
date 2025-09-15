package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser() {
        var email = "user2@localhost";
        var password = "password";
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        app.jamesCli().addUser(email, password);
        // заполняем форму создания в браузере и отправляем (браузер)


        // ждём почту (MailHelper)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        // извлекаем ссылку из письма
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
        // проходим по ссылке и завершаем регистрацию (браузер)

        // проверяем, что пользователь может залогиниться (HttpSessionHelper)
        app.http().login(email, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
