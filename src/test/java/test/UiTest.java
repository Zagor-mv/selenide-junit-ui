package test;

import io.qameta.allure.Description;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;


public class UiTest {

    @BeforeAll
    public static void setup() {
        // Увеличиваем время ожидания до 10 секунд (значение указывается в миллисекундах)
        Configuration.timeout = 30000;
    }

    @Test
    @Description("Successed Authorization")
    public void userCanLogin() {
        // Создаем объект страницы LoginPage
        LoginPage loginPage = new LoginPage();

        // Выполняем авторизацию с использованием данных пользователя
        loginPage.login("repeb12577@eixdeal.com", "111111");

        // Здесь можно добавить дополнительные проверки после авторизации
    }
}
