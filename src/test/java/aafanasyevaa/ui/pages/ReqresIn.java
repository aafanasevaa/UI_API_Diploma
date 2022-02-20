package aafanasyevaa.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ReqresIn {

    private SelenideElement
            mainPageHeader = $(".tagline"),
            supportButton = $(byText("Support ReqRes")),
            supportPageHeader = $("#support-heading"),
            sumInput = $("[type=number]"),
            supportHeader = $(".ProductSummary"),
            deleteRequestButton = $("[data-id=delete]"),
            responseField = $(".response");

    public ReqresIn checkHeader() {
        mainPageHeader.shouldHave(text("Test your front-end against a real API"));
        return this;
    }

    public ReqresIn clickSupportButton() {
        supportButton.click();
        return this;
    }

    public ReqresIn checkSupportPage() {
        supportPageHeader.shouldHave(text("Support"));
        return this;
    }

    public ReqresIn setSumInput(String inputQuery) {
        sumInput.setValue(inputQuery).pressEnter();
        return this;
    }

    public ReqresIn checkNewPage(String inputQuery) {
        supportHeader.shouldHave(text(inputQuery + ",00 $"));
        return this;
    }

    public ReqresIn clickDeleteRequestButton() {
        deleteRequestButton.click();
        return this;
    }

    public ReqresIn checkResponseStatusCode() {
        responseField.shouldHave(text("204"));
        return this;
    }
}
