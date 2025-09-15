package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UserRegistrationTests extends TestBase{

    public static Stream<String> randomUser() {
        return Stream.of(CommonFunctions.randomString(5));
    }

    @ParameterizedTest
    @MethodSource("randomUser")
    void canRegisterUser(String userName) {
        var email = String.format("%s@localhost", userName);
        var password = "password";
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        app.jamesCli().addUser(email, password);
        // заполняем форму создания в браузере и отправляем (браузер)
        app.user().creationUser(userName);
        // ждём почту (MailHelper)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        // извлекаем ссылку из письма
        var text = messages.get(0).content();
        var url = CommonFunctions.extractedUrl(text);
        // проходим по ссылке и завершаем регистрацию (браузер)
        app.user().finishCreationUser(url, password);
        // проверяем, что пользователь может залогиниться (HttpSessionHelper)
        app.http().login(userName, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
