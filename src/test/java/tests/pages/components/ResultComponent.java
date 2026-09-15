package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private final SelenideElement resultWindow = $(".modal-open");
    private final SelenideElement tableOutput = $(".table-responsive");
    private final SelenideElement closeButton = $("#closeLargeModal");


    public void checkResultWindow() {
        resultWindow.should(appear);
    }

    public void checkResult(String key, String value) {
        tableOutput.$(byText(key)).parent().shouldHave(text(value));
    }

    public  void closeWindow() {
        closeButton.click();
    }
}