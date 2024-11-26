package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import services.authorization.AuthorizationService;
import static com.codeborne.selenide.Condition.*;

// Создаём публичный клаас Авторизация (Authorization)
public class Authtorization {

  private final AuthorizationService authorizationService = new AuthorizationService();
  private final AuthorizationPage authorizationPage = new AuthorizationPage();


//Создаём метод для проверки регистрации с заданными параметрами емейла и пароля.
  @Test
  public void checkAuthorization() {
    String email = "alex20-03sh@mail.ru";
    String password = "022093Aa";

    // Используем в данном методе методы классов authorizationService и authorizationPage,
    // которые входят на страницу авторизации, вводят емейл с паролем и проверяют все возможные действия.

    authorizationService.openAutorizationPage();
    authorizationPage.setEmail(email);
    authorizationPage.setPassword(password);
    authorizationPage.getEnterButton().click();
  }

  @Test
  public void checkValidationAuthorization() {
    String password = "022093Aa";
    String IncorrectEmail = "email or password are incorrect";

    // Используем в данном методе методы классов authorizationService и authorizationPage,
    // которые входят на страницу авторизации, вводят емейл с паролем и проверяют все возможные действия.

    authorizationService.openAutorizationPage();
    authorizationPage.setPassword(password);
    authorizationPage.getEnterButton().click();
    authorizationPage.getExpectedText().shouldHave(exactText(IncorrectEmail));
  }


  @Test
  public void checkValidationWithoutPassword() {
    String email = "alex20-03sh@mail.ru";
    String IncorrectEmail = "email or password are incorrect";

    // Используем в данном методе методы классов authorizationService и authorizationPage,
    // которые входят на страницу авторизации, вводят емейл с паролем и проверяют все возможные действия.

    authorizationService.openAutorizationPage();
    authorizationPage.setEmail(email);
    authorizationPage.getEnterButton().click();
    authorizationPage.getExpectedText().shouldHave(exactText(IncorrectEmail));
  }

}