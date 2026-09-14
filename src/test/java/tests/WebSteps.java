package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу GitHub")
    public void openGitHubPage() {
        open("https://github.com/");
    }
    @Step("Выбираем поле для ввода поиска репозиториев")
    public void clickOnSearchField() {
        $(".HeaderSearch-module__searchSlot__oVOUS").click();
    }
    @Step("Вставляем ссылку для поиска репозитория")
    public void inputSearchingLink() {
        $(".prc-components-Input-IwWrt").setValue("serovaliz/practice_form").pressEnter();
    }
    @Step("Нажимаем на результат поиска")
    public void clickOnSearchResult() {
        $(linkText("serovaliz/practice_form")).click();
    }
    @Step("Проверяем что вкладка отображена")
    public void checkTabExistence() {
        $("#issues-tab").shouldBe(visible);
    }

}
