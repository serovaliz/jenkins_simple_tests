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
import static org.openqa.selenium.By.linkText;

public class IssuesTabTestsWithListener {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";

    }

    @DisplayName("Проверка поиска репозитория с addListener")
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".HeaderSearch-module__searchSlot__oVOUS").click();
        $(".prc-components-Input-IwWrt").setValue("serovaliz/practice_form").pressEnter();

        $(linkText("serovaliz/practice_form")).click();
        $("#issues-tab").shouldBe(visible);


    }

}
