package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement monthSelected = $(".react-datepicker__month-select"),
            yearSelected = $(".react-datepicker__year-select");

    private SelenideElement dayButton(String day) {
        return $(
                ".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)"
        );
    }

    public void setDate(String day, String month, String year){
        monthSelected.selectOption(month);
        yearSelected.selectOption(year);
        dayButton(day).click();
}
}
