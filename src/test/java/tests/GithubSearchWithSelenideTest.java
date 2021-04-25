package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class GithubSearchWithSelenideTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "Jul112/qa_guru_5_05hw_allure";
    private final static int ISSUE_NUMBER = 2;

    @Test
    @Owner("Jul112")
    @Feature("Github search")
    @Story("Search in repository")
    @Link(name="Base URL", url="https://github.com")
    @DisplayName("Search specific issue in the repository with selenide")
    public void searchForIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(BASE_URL);
        $(".header-search-input").val(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText("#"+ISSUE_NUMBER)).shouldBe(visible);
    }
}
