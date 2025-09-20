package tests.android;

import app.Setup;
import app.android.pages.*;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Epic("Прочее")
public class AppStart extends Setup {

    @Test
    @DisplayName("Запуск приложения и проверка стартового экрана")
    public void testAppStart() {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.checkWelcomeScreen1();
        welcomePage.tapNext();
        welcomePage.checkWelcomeScreen2();
        welcomePage.tapNext();
        welcomePage.checkWelcomeScreen3();
        welcomePage.tapNext();
        welcomePage.checkReviewsScreen();
        welcomePage.tapNext();
        welcomePage.checkBeginScreen();
        welcomePage.tapNext();

    }
}
