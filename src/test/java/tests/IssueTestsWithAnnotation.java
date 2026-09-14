package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IssueTestsWithAnnotation {

    @Test
    @DisplayName("Тест с использованием степов с аннотацией")
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
