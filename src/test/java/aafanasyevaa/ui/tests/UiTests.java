package aafanasyevaa.ui.tests;

import aafanasyevaa.ui.driverUtils.DriverUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UiTests extends UiTestData {

    @Test
    @DisplayName("Check the header on main page of the website")
    @Owner("aafanasyevaa")
    @Feature("UI Test")
    @Story("ReqresIn UI")
    @Severity(SeverityLevel.BLOCKER)
    public void checkHeaderTest() {
        step("Open main page of the website", () -> {
            open("https://demoqa.com/");
        });
        step("Find the header of the page", () -> {
            $(".tagline").shouldHave(text("Test your front-end against a real API"));
        });
    }

    @Test
    @DisplayName("Check if support button is clickable")
    @Owner("aafanasyevaa")
    @Feature("UI Test")
    @Story("ReqresIn UI")
    @Severity(SeverityLevel.NORMAL)
    public void checkSupportButtonTest() {
//        step("Open main page of the website", () -> {
//            open(url);
//        });
        step("Click the support button", () -> {
            $(byText("Support ReqRes")).click();
        });
        step("Check if support page is open", () -> {
            $("#support-heading").shouldHave(text("Support"));
        });
    }

    @Disabled
    @DisplayName("Check the input field on the main page")
    @Owner("aafanasyevaa")
    @Feature("UI Test")
    @Story("ReqresIn UI")
    @Severity(SeverityLevel.CRITICAL)
    @ValueSource(strings = {"1", "2"})
    @ParameterizedTest(name = "Check if input of {0} is possible in support section")
    public void supportInputFieldTest(String inputQuery) {
        step("Open main page of the website", () -> {
            open(url);
        });
        step("Set sum in the input field", () -> {
            $("[type=number]").setValue(inputQuery).pressEnter();
        });
        step("Check if the sum is displayed in the opened page", () -> {
            $(".ProductSummary").shouldHave(text(inputQuery + ",00 $"));
        });
    }

    @DisplayName("Description of DELETE request should contain 204 status code in its response")
    @Owner("aafanasyevaa")
    @Feature("UI Test")
    @Story("ReqresIn UI")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void DeleteRequestAndResponseDescriptionTest() {
        step("Open main page of the website", () -> {
            open(url);
        });
        step("Click on DELETE request in the list of request examples", () -> {
            $("[data-id=delete]").click();
        });
        step("Check if 204 status code is displayed in response field", () -> {
            $(".response").shouldHave(text("204"));
        });
    }

    @DisplayName("Console tab verifying")
    @Owner("aafanasyevaa")
    @Feature("UI Test")
    @Story("Console Errors")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkConsoleErrors() {
        step("Open main page of the website", () -> {
            open(url);
        });
        step("Open the console tab and check there are no issues", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "error";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
