package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Methods {

    protected AppiumDriver driver;

    public Methods(AppiumDriver driver) {
        this.driver = driver;
    }


    /**
     * Ожидание доступности элемента с указанием времени
     *
     * @param locator          Локатор
     * @param error_message    Сообщение об ошибке если элемент не найден
     * @param timeoutInSeconds Время ожидания элемента
     * @return Результат доступности элемента.
     */
    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    /**
     * Ожидание доступности элемента
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке если элемент не найден
     * @return Результат доступности элемента.
     */
    public WebElement waitForElementPresent(String locator, String error_message) {
        return waitForElementPresent(locator, error_message, waitDelay());
    }

    /**
     * Клик по элементу с указанием времени
     *
     * @param locator          Локатор
     * @param error_message    Сообщение об ошибке если элемент не найден
     * @param timeoutInSeconds Время ожидания элемента
     */
    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    /**
     * Клик по элементу
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке если элемент не найден
     */
    public WebElement waitForElementAndClick(String locator, String error_message) {
        return waitForElementAndClick(locator, error_message, waitDelay());
    }

    /**
     * Ввод текста с указанием времени
     *
     * @param locator          Локатор
     * @param value            Вводимый текст
     * @param timeoutInSeconds Время ожидания элемента
     * @param error_message    Сообщение об ошибке
     */
    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    /**
     * Ввод текста
     *
     * @param locator       Локатор
     * @param value         Вводимый текст
     * @param error_message Сообщение об ошибке
     */
    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message) {
        return waitForElementAndSendKeys(locator, value, error_message, waitDelay());
    }

    /**
     * Проверка отсутствия элемента с указанием времени
     *
     * @param locator          Локатор
     * @param error_message    Сообщение об ошибке если элемент не найден
     * @param timeoutInSeconds Время ожидания элемента
     * @return Результат доступности элемента. true - элемент отсутствует. false - элемент присутствует.
     */
    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * Проверка отсутствия элемента
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке если элемент не найден
     * @return Результат доступности элемента. true - элемент отсутствует. false - элемент присутствует.
     */
    public boolean waitForElementNotPresent(String locator, String error_message) {
        return waitForElementNotPresent(locator, error_message, waitDelay());
    }

    /**
     * Очистка поля ввода с указанием времени
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке если элемент не найден
     */
    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    /**
     * Очистка поля ввода
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке если элемент не найден
     */
    public WebElement waitForElementAndClear(String locator, String error_message) {
        return waitForElementAndClear(locator, error_message, waitDelay());
    }

    /**
     * Проверка наличия текста у элемента
     *
     * @param locator       Локатор
     * @param text_element  Текст который должен содержаться в элементе локатора
     * @param error_message Сообщение об ошибке если нет такого текста
     * @return true если в элементе содержится нужный текст.
     * false если текст другой.
     */
    public boolean assertElementHasText(String locator, String text_element, String error_message) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.attributeContains(by, "text", text_element)
        );
    }

    /**
     * Получение значения атрибута элемента с указанием времени
     *
     * @param locator          Локатор
     * @param attribute        Атрибут локатора
     * @param error_message    Сообщение об ошибке, если не найден элемент
     * @param timeoutInSeconds Время ожидания элемента
     * @return Возвращает значение атрибута.
     */
    public String getAttributeOfElement(String locator, String attribute, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        String attributeOfElement = element.getAttribute(attribute);
        return attributeOfElement;
    }

    /**
     * Получение значения атрибута элемента
     *
     * @param locator       Локатор
     * @param attribute     Атрибут локатора
     * @param error_message Сообщение об ошибке, если не найден элемент
     * @return Возвращает значение атрибута.
     */
    public String getAttributeOfElement(String locator, String attribute, String error_message) {
        return getAttributeOfElement(locator, attribute, error_message, waitDelay());
    }

    public boolean assertElementHasValue(String locator, String text_element, String error_message) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.attributeContains(by, "value", text_element)
        );
    }

    public boolean assertElementIsSelected(String locator, String error_message) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.attributeToBe(by, "selected", "true")
        );
    }

    /**
     * Метод проверяет наличие нескольких элементов на странице с указанием времени
     *
     * @param locator         Локатор
     * @param error_message   Сообщение об ошибке, если элементы не найдены
     * @param timeoutInSecond Время ожидания
     * @return Массив найденных элементов на странице по заданному локатору
     */
    public List<WebElement> waitForElementsPresent(String locator, String error_message, long timeoutInSecond) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by)
        );
    }

    /**
     * Метод проверяет наличие нескольких элементов на странице
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке, если элементы не найдены
     * @return Массив найденных элементов на странице по заданному локатору
     */
    public List<WebElement> waitForElementsPresent(String locator, String error_message) {
        return waitForElementsPresent(locator, error_message, waitDelay());
    }

    /**
     * Метод проверяет количество элементов по локатору
     *
     * @param locator       Локатор
     * @return              Количество элементо для передаваемого локатора
     */
    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return  elements.size();
    }

    public void swipeFromDownToUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();    // в size передаются параметры экрана
        int x = size.width / 2; // для вертикального свайпа x не меняется
        int start_y = (int) (size.width * 0.8); // Точка находится внизу на уровне 80% экрана
        int end_y = (int) (size.width * 0.2); // Точка находится вверху на уровне 20% экрана
        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    public void swipeFromRightToLeft(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();    // в size передаются параметры экрана
        int y = size.width / 2; // для горизонтального свайпа y не меняется
        int start_x = (int) (size.width * 0.2); // Точка находится справа на уровне 80% экрана
        int end_x = (int) (size.width * 0.8); // Точка находится слева на уровне 20% экрана
        action
                .press(PointOption.point(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(end_x,y))
                .release()
                .perform();
    }

    public void swipeFromRightToLeftFromCoordinat(int timeOfSwipe, int X, int Y) {
        TouchAction action = new TouchAction(driver);
        int y = Y; // для горизонтального свайпа y не меняется
        int start_x = (int) (X);
        int end_x = (int) (X*0.2);
        action
                .press(PointOption.point(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(end_x,y))
                .release()
                .perform();
    }

    public void swipeFromDownToUpLittle(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();    // в size передаются параметры экрана
        int x = size.width / 2; // для вертикального свайпа x не меняется
        int start_y = (int) (size.width * 0.6); // Точка находится внизу на уровне 80% экрана
        int end_y = (int) (size.width * 0.4); // Точка находится вверху на уровне 20% экрана
        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    public void pageDownInEnd(){
        System.out.println("Проматывание экрана вниз");
        waitDelay(500);
        this.swipeFromDownToUp(3000);
    }
    public void swipeFromUpToDown(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();    // в size передаются параметры экрана
        int x = size.width / 2; // для вертикального свайпа x не меняется
        int start_y = (int) (size.width * 0.2); // Точка находится вверху на уровне 20% экрана
        int end_y = (int) (size.width * 0.8); // Точка находится внизу на уровне 80% экрана
        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    public void swipeFromDownToUpQuick() {
        swipeFromDownToUp(500);
    }

    /**
     * Свайп до элемента, пока элемент не окажется на странице
     *
     * @param locator       Локатор
     * @param error_message Сообщение об ошибке если элемент не найден
     * @param max_swipes    Количество свайпов
     */
    public void swipeToFindElement(String locator, String error_message, int max_swipes) {
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPresent(locator, "Cannot find element by swiping down. \n" + error_message, 0);
                return;
            }
            swipeFromDownToUpQuick();
            ++already_swiped;
        }
    }

    public void swipeUpToFindElement(String locator, String error_message, int max_swipes) {
        // Свайп, пока элемент из locator не окажется на странице
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeFromUpToDown(1000);
            ++already_swiped;
        }
    }

    public void swipeElementToLeft(String locator, String error_message) {
        // Получение координат элемента и свайп
        WebElement element = waitForElementPresent(
                locator,
                error_message,
                10);

        int left_x = element.getLocation().getX();
        int right_x = (int) (left_x + element.getSize().getWidth() * 0.95);
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();
    }

    public void tapInTheTopOfScreen() {
        // Тап вне боттомшита
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();    // в size передаются параметры экрана
        int x = size.width / 2; // Точка x посередине длинны
        int y = (int) (size.width * 0.2); // Точка y находится вверху на уровне 20% экрана
        action
                .tap(PointOption.point(x, y))
                .perform();
    }

    public void tapByCoordinateOfElement(String locator, String error_message) {
        // Нахождение координат элемента и тап по координатам
        WebElement element = waitForElementPresent(
                locator,
                error_message,
                10);

        int x = element.getLocation().getX(); // Получение координат элемента
        int y = element.getLocation().getY(); // Получение координат элемента

        TouchAction action = new TouchAction(driver);
        action
                .tap(PointOption.point(x, y))
                .perform();
    }

    private By getLocatorByString(String locatorWithType) { // добавить другой тип локатора - убрала туду, так как пока неактуально
        // Обработка типа локатора по передаваемому id с разделителем :
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locatorWithType);
        }
    }

    public boolean checkElementExist(String locator) {
        By by = this.getLocatorByString(locator);
        if (driver.findElements(by).isEmpty()) {
            return false;
        } // false - Элемент отсутствует
        else return true; // true - Элемент присутствует
    }

    public void tapInTheMiddleOfScreen() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int y = size.height / 2;
        System.out.println("Пополнение баланса" + x + "hh" + y);

        action.tap(PointOption.point(x, y)).perform();
    }

    public void tapInTheRightSideOfScreen() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = (int)(size.width * 0.8);
        int y = size.height / 2;
        action.tap(PointOption.point(x, y)).perform();
    }

    public void tapOnTheCoordinat(int x, int y) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        action.tap(PointOption.point(x, y)).perform();
    }

    public void takeScreenshotAndPrint(String name) {
        screenshot(this.takeScreenshot(name));
    }

    public int waitDelay() {
        int delay = 10;
        return delay;
    }

    public int waitLongDelay() {
        int delay = 30;
        return delay;
    }

    public String takeScreenshot(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/target/screenshots/" + timeStamp() + name + ".png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path) {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }

    public String timeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd_HH-mm-ss_");
        Date date = new Date();
        String timeStamp = formatter.format(date);
        return timeStamp;
    }

    public void waitDelay(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDateTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        Date tomorrow = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String format = formatter.format(tomorrow);
        System.out.println(format);
        return format;
    }

    public String getDate90() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 90);

        Date tomorrow = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String format = formatter.format(tomorrow);
        System.out.println(format);
        return format;
    }

}
