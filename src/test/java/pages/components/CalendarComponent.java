package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement monthSelected = $(".react-datepicker__month-select"),
            yearSelected = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year){
        monthSelected.selectOption(month);
        yearSelected.selectOption(year);
    $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
}
}
