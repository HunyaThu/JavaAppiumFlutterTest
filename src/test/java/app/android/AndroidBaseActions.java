package app.android;

import app.android.pages.*;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


public class AndroidBaseActions {

    protected AppiumDriver driver;

    public AndroidBaseActions(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие приложения")
    public void startApp() {
        WelcomePage welcomePage = new WelcomePage(driver);

    }

    public void tapAndroidBackButton(){
        driver.navigate().back();
    }



    @Step("Перезапуск приложения")
    public void restartApp() {
        System.out.println("Перезапуск приложения");
        driver.closeApp();
        driver.launchApp();
        startApp();
    }




}