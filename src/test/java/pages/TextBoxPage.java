package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage(){
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserFullName(String value){
        userName.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value){
        userEmail.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmitButton(){
        submitButton.click();

        return this;
    }
    public TextBoxPage checkOutputName(String value){
        outputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOutputEmail(String value){
        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOutputCurrentAddress(String value){
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOutputPermanentAddress(String value){
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }
}
