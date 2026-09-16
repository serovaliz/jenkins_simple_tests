package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnnotationStepsTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";

    }

    @Test
    @Disabled
    @DisplayName("Тест с использованием степов с аннотацией @Step")
     public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        webSteps.openGitHubPage();
        webSteps.clickOnSearchField();
        webSteps.inputSearchingLink();
        webSteps.clickOnSearchResult();
        webSteps.checkTabExistence();


    }

}
