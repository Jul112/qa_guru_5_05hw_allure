package tests;

import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class GithubSearchWithLambdaStepsTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "Jul112/qa_guru_5_05hw_allure";
    private final static int ISSUE_NUMBER = 2;

    @Test
    @Owner("Jul112")
    @Feature("Github search")
    @Story("Search in repository")
    @Link(name="Base URL", url="https://github.com")
    @DisplayName("Search specific issue in the repository with lambda steps")
    public void searchForIssue() {
        addListener("AllureSelenide", new AllureSelenide());

        Allure.parameter("Repository", REPOSITORY);
        Allure.parameter("Issue number", ISSUE_NUMBER);

        step("Open main page", (step) -> {
            step.parameter("url",BASE_URL);
            open(BASE_URL);
        });
        step("Search the repository", (step) -> {
            step.parameter("repository", REPOSITORY);
            $(".header-search-input").val(REPOSITORY).pressEnter();
        });
        step("Go to the repository", (step) -> {
            step.parameter("repository", REPOSITORY);
            $(byLinkText(REPOSITORY)).click();
        });
        step("Go to tab Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Verify there is Issue number 2 in Issues", (step) -> {
            step.parameter("issueNumber", ISSUE_NUMBER);
            $(withText("#" + ISSUE_NUMBER)).shouldBe(visible);
        });
    }
}
