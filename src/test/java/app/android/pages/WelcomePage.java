package app.android.pages;

import io.appium.java_client.AppiumDriver;
import app.Methods;

public class WelcomePage extends Methods {
    private static final String
            BTN_NEXT = "xpath://android.view.View[@content-desc=\"Продолжить\"]",
            WELCOME_TEXT = "xpath://android.view.View[@content-desc=\"Добро пожаловать в приложение Арабист\"]",
            WELCOME_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Ваш персональный помощник в изучении арабского языка, в котором вы научитесь:\"]",
            READ_TEXT = "xpath://android.view.View[@content-desc=\"читать\"]",
            READ_CLUE_TEXT = "xpath:(//android.view.View[@content-desc=\"на арабском\"])[1]",
            UNDERSTAND_TEXT = "xpath://android.view.View[@content-desc=\"понимать\"]",
            UNDERSTAND_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"арабский\"]",
            SPEAK_TEXT = "xpath://android.view.View[@content-desc=\"говорить\"]",
            SPEAK_CLUE_TEXT = "xpath:(//android.view.View[@content-desc=\"на арабском\"])[2]",
            LISTEN_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"арабскую речь\"]",
            LISTEN_TEXT = "xpath://android.view.View[@content-desc=\"говорить\"]",
            THINK_TEXT = "xpath://android.view.View[@content-desc=\"говорить\"]",
            THINK_CLUE_TEXT = "xpath:(//android.view.View[@content-desc=\"на арабском\"])[3]",
            EDUCATION_TEXT = "xpath://android.view.View[@content-desc=\"Уникальная программа обучения\"]",
            EDUCATION_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Квалифицированные арабисты собрали для вас уникальную программу, чтобы сделать обучение понятным и эффективным:\"]",
            DIALOG_TEXT = "xpath://android.view.View[@content-desc=\"Диалоги и тексты\"]",
            DIALOG_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"для каждого уровня\"]",
            EXERСISE_TEXT = "xpath://android.view.View[@content-desc=\"20 000+ упражнений\"]",
            EXERСISE_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"различного типа\"]",
            GRAMMARY_TEXT = "xpath://android.view.View[@content-desc=\"Арабская грамматика\"]",
            GRAMMARY_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"с примерами и упражнениями\"]",
            DICTIONARY_TEXT = "xpath://android.view.View[@content-desc=\"с примерами и упражнениями\"]",
            DICTIONARY_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"для каждого урока\"]",
            AI_TEXT = "xpath://android.view.View[@content-desc=\"Искусственный интеллект\"]",
            AI_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Мы внедрили ИИ — чтобы вывести изучение арабского языка на совершенно новый уровень. Вот как нейросеть поможет вам:\"]",
            PRACTICE_TEXT = "xpath://android.view.View[@content-desc=\"Практика с ИИ\"]",
            PRACTICE_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Общайтесь с нейросетью в живом чате\"]",
            CHAT_TEXT = "xpath://android.view.View[@content-desc=\"Чат с ИИ ассистентом\"]",
            CHAT_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Задавайте вопросы по грамматике и лексике\"]",
            VOICE_TEXT = "xpath://android.view.View[@content-desc=\"Озвучивание текстов\"]",
            VOICE_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Слушайте живую речь на арабском\"]",
            LESSON_TEXT = "xpath://android.view.View[@content-desc=\"Слушайте живую речь на арабском\"]",
            LESSON_CLUE_TEXT = "xpath://android.view.View[@content-desc=\"Нейросеть анализирует и подстраивается под вас\"]",
            REVIEWS_TEXT = "xpath://android.view.View[@content-desc=\"Учитесь с единомышленниками\"]",
            REVIEW_1_1 = "xpath://android.view.View[@content-desc=\"Саба\"]",
            REVIEW_1_2 = "xpath://android.view.View[@content-desc=\"Я очень давно искала способ для повторения пройденных слов. Это приложение просто большая находка не только для повторения, но и для улучшения в освоении языка со всех сторон. Одно удовольствие заниматься.\"]",
            REVIEW_2_1 = "xpath://android.view.View[@content-desc=\"Сулейма\"]",
            REVIEW_2_2 = "xpath://android.view.View[@content-desc=\"Грамматика во 2 курсе, просто блеск. То что я не поняла во время уроков написано просто, понятно и с примерами. ДжазакумуЛлаху хайран за такое приложение.\"]",
            REVIEW_3_1 = "xpath://android.view.View[@content-desc=\"Людмила\"]",
            REVIEW_3_2 = "xpath://android.view.View[@content-desc=\"Как интересно заниматься! Одно удовольствие! Давно искала такое Приложение!\"]",
            REVIEW_4_1 = "xpath://android.view.View[@content-desc=\"Ильяс\"]",
            REVIEW_4_2 = "xpath://android.view.View[@content-desc=\"Сегодня я зашёл, и мне очень понравилась ваша программа, прям душа радуется от такой возможности, АльхьамдулилЛяхl. Хорошая возможность для изучающих арабский язык.\n" +
                    "Особенно радует что есть диалоги с озвучкой и ИИ практика. БаракалЛахlу фикум ва ДжазакалЛахlу Хайран.\"]",
            REVIEW_5_1 = "xpath://android.view.View[@content-desc=\"Пётр\"]",
            REVIEW_5_2 = "xpath://android.view.View[@content-desc=\"Приложение удивительное, Ма Ша Аллах. Впрочем, как и словарь\"]",
            REVIEW_6_1 = "xpath://android.view.View[@content-desc=\"Аноним\"]",
            REVIEW_6_2 = "xpath://android.view.View[@content-desc=\"У меня 2 приложения арабский словарь и арабист, я с обоих в восторге, нигде не видел лучше.\"]",
            REVIEW_7_1 = "xpath://android.view.View[@content-desc=\"Зайнаб\"]",
            REVIEW_7_2 = "xpath://android.view.View[@content-desc=\"Какое прекрасное приложение! АльхьамдулиЛлах, бесконечная Хвала Аллаху! Моя радость настолько велика, что она просто не помещается в моё сердце!\n" +
                    "Я как маленький ребёнок не могу уснуть ночью, а утром мне не терпится поскорее зайти в это приложение)\"]",
            BEGIN_TEXT = "xpath://android.widget.ImageView[@content-desc=\"Давайте начнём\n" +
                    "Мы зададим вам несколько вопросов, чтобы определить ваш уровень и персонализировать приложение под вас.\"]",
    END = "END";

    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public void tapNext() {
        System.out.println("Нажимаю Продолжить");

        this.waitForElementAndClick(
                BTN_NEXT,
                "Can not tap on BTN_NEXT");
    }
    public void checkWelcomeScreen1(){
        this.checkWelcomeText();
        this.checkReadText();
        this.checkUnderstandText();
        this.checkSpeakText();
        this.checkListenText();
        this.checkThinkText();
    }

    public void checkWelcomeText(){
        System.out.println("Проверяю отображение текста приветствия");

        this.waitForElementPresent(
                WELCOME_TEXT,
                "Not present WELCOME_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                WELCOME_CLUE_TEXT,
                "Not present WELCOME_CLUE_TEXT");
    }

    public void checkReadText(){
        System.out.println("Проверяю отображение текста про чтение");

        this.waitForElementPresent(
                READ_TEXT,
                "Not present READ_TEXT");

        System.out.println("Проверяю отображения текста про арабский");

        this.waitForElementPresent(
                READ_CLUE_TEXT,
                "Not present READ_CLUE_TEXT");
    }

    public void checkUnderstandText(){
        System.out.println("Проверяю отображение текста про понимание");

        this.waitForElementPresent(
                UNDERSTAND_TEXT,
                "Not present UNDERSTAND_TEXT");

        System.out.println("Проверяю отображения текста про арабский");

        this.waitForElementPresent(
                UNDERSTAND_CLUE_TEXT,
                "Not present UNDERSTAND_CLUE_TEXT");
    }

    public void checkSpeakText(){
        System.out.println("Проверяю отображение текста про говорение");

        this.waitForElementPresent(
                SPEAK_TEXT,
                "Not present SPEAK_TEXT");

        System.out.println("Проверяю отображения текста про арабский");

        this.waitForElementPresent(
                SPEAK_CLUE_TEXT,
                "Not present SPEAK_CLUE_TEXT");
    }

    public void checkListenText(){
        System.out.println("Проверяю отображение текста про слушанье");

        this.waitForElementPresent(
                LISTEN_TEXT,
                "Not present LISTEN_TEXT");

        System.out.println("Проверяю отображения текста про арабский");

        this.waitForElementPresent(
                LISTEN_CLUE_TEXT,
                "Not present LISTEN_CLUE_TEXT");
    }

    public void checkThinkText(){
        System.out.println("Проверяю отображение текста про думанье");

        this.waitForElementPresent(
                THINK_TEXT,
                "Not present UNDERSTAND_TEXT");

        System.out.println("Проверяю отображения текста про арабский");

        this.waitForElementPresent(
                THINK_CLUE_TEXT,
                "Not present THINK_CLUE_TEXT");
    }

    public void checkWelcomeScreen2(){
        this.checkEducatedText();
        this.checkDialogText();
        this.checkExerciseText();
        this.checkGrammarText();
        this.checkDictionaryText();
    }

    public void checkEducatedText(){
        System.out.println("Проверяю отображение текста про обучение");

        this.waitForElementPresent(
                EDUCATION_TEXT,
                "Not present EDUCATION_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                EDUCATION_CLUE_TEXT,
                "Not present EDUCATION_CLUE_TEXT");
    }

    public void checkDialogText(){
        System.out.println("Проверяю отображение текста про диалоги");

        this.waitForElementPresent(
                DIALOG_TEXT,
                "Not present DIALOG_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                DIALOG_CLUE_TEXT,
                "Not present DIALOG_CLUE_TEXT");
    }

    public void checkExerciseText(){
        System.out.println("Проверяю отображение текста про упражнения");

        this.waitForElementPresent(
                EXERСISE_TEXT,
                "Not present EXERСISE_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                EXERСISE_CLUE_TEXT,
                "Not present EXERСISE_CLUE_TEXT");
    }

    public void checkGrammarText(){
        System.out.println("Проверяю отображение текста про грамматику");

        this.waitForElementPresent(
                GRAMMARY_TEXT,
                "Not present GRAMMARY_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                GRAMMARY_CLUE_TEXT,
                "Not present GRAMMARY_CLUE_TEXT");
    }

    public void checkDictionaryText() {
        System.out.println("Проверяю отображение текста про словарь");

        this.waitForElementPresent(
                DICTIONARY_TEXT,
                "Not present DICTIONARY_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                DICTIONARY_CLUE_TEXT,
                "Not present DIALOG_CLUE_TEXT");
    }

    public void checkWelcomeScreen3(){
        this.checkAIText();
        this.checkPracticeText();
        this.checkChatText();
        this.checkVoiceText();
        this.checkLessonText();
    }

    public void checkAIText(){
        System.out.println("Проверяю отображение текста про ИИ");

        this.waitForElementPresent(
                AI_TEXT,
                "Not present AI_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                AI_CLUE_TEXT,
                "Not present AI_CLUE_TEXT");
    }

    public void checkPracticeText() {
        System.out.println("Проверяю отображение текста про практику");

        this.waitForElementPresent(
                PRACTICE_TEXT,
                "Not present PRACTICE_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                PRACTICE_CLUE_TEXT,
                "Not present PRACTICE_CLUE_TEXT");
    }

    public void checkChatText() {
        System.out.println("Проверяю отображение текста про чат");

        this.waitForElementPresent(
                CHAT_TEXT,
                "Not present CHAT_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                CHAT_CLUE_TEXT,
                "Not present CHAT_CLUE_TEXT");
    }

    public void checkVoiceText() {
        System.out.println("Проверяю отображение текста про озвучивание");

        this.waitForElementPresent(
                VOICE_TEXT,
                "Not present VOICE_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                VOICE_CLUE_TEXT,
                "Not present VOICE_CLUE_TEXT");
    }

    public void checkLessonText() {
        System.out.println("Проверяю отображение текста про уроки");

        this.waitForElementPresent(
                LESSON_TEXT,
                "Not present LESSON_TEXT");

        System.out.println("Проверяю отображения подсказки");

        this.waitForElementPresent(
                LESSON_CLUE_TEXT,
                "Not present LESSON_CLUE_TEXT");
    }

    public void checkReviewsScreen(){
        System.out.println("Проверяю экран с отзывами");
        this.checkReviewsText();
        this.checkReview1();
        this.checkReview2();
        this.pageDownInEnd();
        this.checkReview3();
        this.checkReview4();
        this.pageDownInEnd();
        this.checkReview5();
        this.pageDownInEnd();
        this.checkReview6();
        this.pageDownInEnd();
        this.checkReview7();
    }

    public void checkReviewsText(){
        System.out.println("Проверяю отображение текста про единомышленников");

        this.waitForElementPresent(
                REVIEWS_TEXT,
                "Not present REVIEWS_TEXT");
    }

    public void checkReview1(){
        System.out.println("Проверяю отображение имени автора первого отзыва");

        this.waitForElementPresent(
                REVIEW_1_1,
                "Not present REVIEW_1_1");

        System.out.println("Проверяю отображение текста первого отзыва");

        this.waitForElementPresent(
                REVIEW_1_2,
                "Not present REVIEW_1_2");
    }

    public void checkReview2(){
        System.out.println("Проверяю отображение имени автора второго отзыва");

        this.waitForElementPresent(
                REVIEW_2_1,
                "Not present REVIEW_2_1");

        System.out.println("Проверяю отображение текста второго отзыва");

        this.waitForElementPresent(
                REVIEW_2_2,
                "Not present REVIEW_2_2");
    }

    public void checkReview3(){
        System.out.println("Проверяю отображение имени автора третьего отзыва");

        this.waitForElementPresent(
                REVIEW_3_1,
                "Not present REVIEW_3_1");

        System.out.println("Проверяю отображение текста третьего отзыва");

        this.waitForElementPresent(
                REVIEW_3_2,
                "Not present REVIEW_3_2");
    }

    public void checkReview4(){
        System.out.println("Проверяю отображение имени автора четвёртого отзыва");

        this.waitForElementPresent(
                REVIEW_4_1,
                "Not present REVIEW_4_1");

        System.out.println("Проверяю отображение текста четвёртого отзыва");

        this.waitForElementPresent(
                REVIEW_4_2,
                "Not present REVIEW_4_2");
    }

    public void checkReview5(){
        System.out.println("Проверяю отображение имени автора пятого отзыва");

        this.waitForElementPresent(
                REVIEW_5_1,
                "Not present REVIEW_5_1");

        System.out.println("Проверяю отображение текста пятого отзыва");

        this.waitForElementPresent(
                REVIEW_5_2,
                "Not present REVIEW_5_2");
    }

    public void checkReview6(){
        System.out.println("Проверяю отображение имени автора шестого отзыва");

        this.waitForElementPresent(
                REVIEW_6_1,
                "Not present REVIEW_6_1");

        System.out.println("Проверяю отображение текста шестого отзыава");

        this.waitForElementPresent(
                REVIEW_6_2,
                "Not present REVIEW_6_2");
    }

    public void checkReview7(){
        System.out.println("Проверяю отображение имени автора седьмого отзыва");

        this.waitForElementPresent(
                REVIEW_7_1,
                "Not present REVIEW_7_1");

        System.out.println("Проверяю отображение текста седьмого отзыава");

        this.waitForElementPresent(
                REVIEW_7_2,
                "Not present REVIEW_7_2");
    }

    public void checkBeginScreen() {
        System.out.println("Проверяю отображение текста предложения начать");

        this.waitForElementPresent(
                BEGIN_TEXT,
                "Not present BEGIN_TEXT");
    }











    public void inputSupportText() {

        System.out.println("Клик по полю ввода текста");
        this.waitForElementAndClick(
                END,
                "Cannot click on PASSWORD_RECOVERY_BOX");

        String SUPPORT_TEXT = "Тестовое сообщение";
        System.out.println("Ввод сообщения службе поддержки");
        this.waitForElementAndSendKeys(
                END,
                SUPPORT_TEXT,
                "Cannot enter SUPPORT_TEXT");

        driver.hideKeyboard();

        this.waitForElementAndClick(
                END,
                "Cannot click on BTN_INPUT_SUPPORT");
    }

    public void checkNewMassegeSupport() {
        System.out.println("Проверяю переход в службу поддержки");

        this.waitForElementPresent(
                END,
                "Not present TEXT_SUPPORT_PD");
    }

    public void checkPincodeScreen() {
        System.out.println("Проверяю нахождение на экране создания пинкода");

        this.waitForElementPresent(
                END,
                "Not present SCREEN_PINCODE_TEXT");
    }

    public void сheckIncorrectSymbols() {
        System.out.println("Проверяю надпись о недопустимом логине");

        this.waitForElementPresent(
                END,
                "Not present ERROR_INCORRECT_LOGIN_TEXT");
    }

}