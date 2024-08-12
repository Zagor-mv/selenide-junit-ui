package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    // XPath для элементов
    private final String emailInputXpath = "//input[@type='email']";
    private final String passwordInputXpath = "//input[@type='password']";
    private final String loginButtonXpath = "//div[@class='content__form grid-row']/button";
    private final String cookieBannerXpath = "//div[@class='cookie-gdpr__text']"; // Обновите XPath в зависимости от вашего баннера
    private final String cookieBannerCloseButtonXpath = "//div[@class='cookie-gdpr__action']//button"; // Обновите XPath на кнопку закрытия баннера, если она есть

    // Метод для открытия страницы авторизации
    @Step("Open Login Page")
    public void openLoginPageTest() {
        open("https://russiarunning.com/login");
    }

    // Метод для закрытия модального окна с куками
    @Step("Close cookie banner")
    public void closeCookieBanner() {
        if ($x(cookieBannerXpath).isDisplayed()) {
            $x(cookieBannerCloseButtonXpath).click(); // Закрыть баннер, если он отображается
        }
    }

    // Метод для ввода логина
    @Step("Enter Email")
    public void enterEmail(String email) {
        $x(emailInputXpath).setValue(email);
    }

    // Метод для ввода пароля
    @Step("Enter Password")
    public void enterPassword(String password) {
        $x(passwordInputXpath).setValue(password);
    }

    // Метод для нажатия на кнопку "Войти"
    @Step("Click Login Button")
    public void clickLoginButton() {
        $x(loginButtonXpath).click();
    }

    // Метод для авторизации пользователя
    @Step("Authorization")
    public void login(String email, String password) {
        openLoginPageTest();
        closeCookieBanner(); // Закрываем баннер перед авторизацией
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
