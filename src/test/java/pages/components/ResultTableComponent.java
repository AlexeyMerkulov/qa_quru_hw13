package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    SelenideElement
            modalDialogForm = $(".modal-dialog"),
            modalDialogHeader = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive");

    public void verifyModalDialogAppeared() {
        modalDialogForm.should(appear);
        modalDialogHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyTableContent(String label, String value) {
        resultTable.$(byText(label)).sibling(0).shouldHave(text(value));
    }
}
