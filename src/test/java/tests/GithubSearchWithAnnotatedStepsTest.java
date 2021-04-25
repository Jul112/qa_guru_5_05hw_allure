package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class GithubSearchWithAnnotatedStepsTest {
    private final static String REPOSITORY = "Jul112/qa_guru_5_05hw_allure";
    private final static int ISSUE_NUMBER = 2;

    public BaseSteps steps = new BaseSteps();

    @Test
    @Owner("Jul112")
    @Feature("Github search")
    @Story("Search in repository")
    @Link(name="Base URL", url="https://github.com")
    @DisplayName("Search specific issue in the repository with annotated steps")

    public void searchForIssue() {
        addListener("AllureSelenide", new AllureSelenide());

        steps.openMainPage("Jul112");
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
