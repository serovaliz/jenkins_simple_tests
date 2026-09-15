package tests.pages.components;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CalendarComponent {
    public void setDateOfBirth(String day, String month, String year) {
        $("[class=react-datepicker__month-select]").selectOption(month);
        $("[class=react-datepicker__year-select]").selectOption(year);
        $$("[class=react-datepicker__week").find(text(day)).click();
    }

}