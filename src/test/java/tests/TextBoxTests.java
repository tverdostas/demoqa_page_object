package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    String userFullName = "Kathryn Dean";
    String userEmail = "katrin.dean@gmail.com";
    String userCurrentAddress = "Test current address";
    String userPermanentAddress = "Test permanent address";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void FillFormTextBoxTest(){
        textBoxPage.openPage().
                setUserFullName(userFullName).
                setUserEmail(userEmail).
                setCurrentAddress(userCurrentAddress).
                setPermanentAddress(userPermanentAddress).
                clickSubmitButton();

        textBoxPage.checkOutputName(userFullName).
                checkOutputEmail(userEmail).
                checkOutputCurrentAddress(userCurrentAddress).
                setPermanentAddress(userPermanentAddress);

    }
}
