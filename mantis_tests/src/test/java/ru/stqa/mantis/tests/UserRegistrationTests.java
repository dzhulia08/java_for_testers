package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser() {
//        var email = String.format("user2@localhost", username);
        var email = "user2@localhost";
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        // заполняем форму создания в браузере и отправляем (браузер)
        // ждём почту (MailHelper)
        // извлекаем ссылку из письма
        // проходим по ссылке и завершаем регистрацию (браузер)
        // проверяем, что пользователь может разлогиниться (HttpSessionHelper)
    }
}
