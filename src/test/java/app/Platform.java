package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static app.android.BaseEnvironments.*;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String APP_PATH = System.getProperty("/Users/anastasiacetvergova/Downloads/JavaAppiumFlutter/apks/");

    private static Platform instance;
    //приватный контруктор
    public Platform() {}

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }



    //метод возвращает настройки Capabilities для нужной платформы
    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver(URL,this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(URL,this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("Cannot detected type of driver. Platform value: " + this.getPlatformVar());
        }
    }

    //метод возвращает значение true, если платформа в переменной среды PLATFORM = Android и false, если iOs
    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    //метод возвращает значение true, если платформа в переменной среды PLATFORM = iOs и false, если Android
    public boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }

    // параметры Capability для платформы Android
    public static DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Sony - Настройки для реального устройства
        //    capabilities.setCapability("deviceName","I4213");
        //    capabilities.setCapability("udid","CQ3001M5FW");

        // Huawei - Настройки для реального устройства
        //    capabilities.setCapability("deviceName","device");
        //    capabilities.setCapability("udid","K5J0220507004902");

        // Emulator - Настройки для эмулятора

        capabilities.setCapability("deviceName","PXL4");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","14.0");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("appPackage",ANDROID_APP_BUILD);
        capabilities.setCapability("appActivity",ANDROID_APP_ACTIVITY);
        capabilities.setCapability("app",ANDROID_APP);
        capabilities.setCapability("appium:settings[waitForIdleTimeout]",50);


        return capabilities;
    }

    //параметры Capability для платформы iOS
    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("AutomationName", "UIAutomator2");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 12");
        capabilities.setCapability("platformVersion", "15.0");
        capabilities.setCapability("app","/Users/anastasiacetvergova/Downloads/vprok-app-main/apks/Впрок DEV.app");
        capabilities.setCapability("locationServicesAuthorized", "true");

        return capabilities;
    }

    //метод возвращает значение переменной окружения PLATFORM (Edit Configuration/Junit/Environment variables)
    String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

    //метод сравнивает полученную строку с переменной окружения PLATFORM
    private boolean isPlatform(String myPlatform)
    {
//        String platform = this.getPlatformVar();
//        return myPlatform.equals(platform);
        return myPlatform.equals("android"); // чтобы не было сложностей в конфигирации. Для запуска iOS замена на верхние строчки
    }

}
