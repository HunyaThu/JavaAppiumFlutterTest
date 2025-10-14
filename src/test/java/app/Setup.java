package app;

import java.io.File;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;

public class Setup {

    protected AppiumDriver driver;

    @Before
    //@Step("Старт сессии")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
//        this.createAllurePropertyFile(); // можно создать allure отчёт, если настроить
    }

    @After
    //@Step("Окончание сессии")

    public void tearDown(){

//        this.terminateApp(); //у меня ошибки из-за этого метода
        driver.quit();
    }

    private void createAllurePropertyFile() {
        String path = System.getProperty("allure.results.directory");
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://github.com/allure-framework/");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }

}
