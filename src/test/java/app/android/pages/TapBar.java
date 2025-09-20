package app.android.pages;

import io.appium.java_client.AppiumDriver;
import app.Methods;
import io.qameta.allure.Step;

import static app.android.BaseEnvironments.ANDROID_APP_BUILD;

public class TapBar extends Methods {

    private static final String

            TAB_MAIN = "xpath://android.widget.ImageView[@content-desc=\"Портфель\n" +
            "Tab 1 of 4\"]",
            TAB_SEARCH =  "xpath://android.widget.ImageView[@content-desc=\"Поиск\n" +
                    "Tab 2 of 4\"]",
            TAB_ANALYTICS =  "xpath://android.widget.ImageView[@content-desc=\"Аналитика\n" +
                    "Tab 3 of 4\"]",
            TAB_MENU =  "xpath://android.widget.ImageView[@content-desc=\"Меню\n" +
                    "Tab 4 of 4\"]",
            END = "END";


    public TapBar(AppiumDriver driver) {
        super(driver);
    }


//    public void checkNavBarIsPresent() {
//        System.out.println("Навбар отображается");
//        this.waitForElementPresent(
//                TAB_BAR,
//                "Navbar is not present");
//    }

    @Step("Тап по табу Портфель")
    public void tapTabMain() {
        System.out.println("Тап по табу Главная");
//        this.tapOnTheCoordinat(150,2095);
//        waitDelay(3000);
                this.waitForElementAndClick(
                TAB_MAIN,
                "Cannot click on TAB_MAIN");
    }

    @Step("Тап по табу Поиск")
    public void tapTabSearch() {
        System.out.println("Тап по табу Поиск");
        waitDelay(1000);
//        this.tapOnTheCoordinat(350,2095);
        this.waitForElementAndClick(
                TAB_SEARCH,
                "Cannot click on TAB_SEARCH");

    }

    @Step("Тап по табу Аналитика")
    public void tapTabAnalytics() {
        System.out.println("Тап по табу Аналитика");
//        this.tapOnTheCoordinat(700,2095);
        this.waitForElementAndClick(
                TAB_ANALYTICS,
                "Cannot click on TAB_ANALYTICS");
    }

    @Step("Тап по табу Меню")
    public void tapTabMenu() {
//        waitDelay(1000);
        System.out.println("Тап по табу Меню");
//        this.tapOnTheCoordinat(950,2095);

        this.waitForElementAndClick(
                TAB_MENU,
                "Cannot click on TAB_MAIN");
    }

    public void debugDelay() {
        waitDelay(10000);
    }

}