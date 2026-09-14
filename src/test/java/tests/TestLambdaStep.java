package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class TestLambdaStep {
    private static final String REPOSITORY = "serovaliz/practice_form";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";

    }

    @DisplayName("Проверка поиска репозитория с LambdaSteps")
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу github", () -> {
            open("https://github.com/");
        });

        step("Кликаем на поле для ввода поиска репозиториев", () -> {
            $(".HeaderSearch-module__searchSlot__oVOUS").click();
        });

        step("Вставляем ссылку для поиска репозитория " + REPOSITORY, () -> {
            $(".prc-components-Input-IwWrt").setValue(REPOSITORY).pressEnter();
        });

        step("Нажимаем на результат поиска " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Проверяем что вкладка отображена", () -> {
            $("#issues-tab").shouldBe(visible);
        });


    }

}
