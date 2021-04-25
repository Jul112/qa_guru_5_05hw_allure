package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;

public class BaseSteps {
   private final String BASE_URL = "https://github.com";

    @Step("Open main page")
    public void openMainPage(String user) {
        parameter("User", user);
        open(BASE_URL);
    }
    @Step("Search the repository {repository}")
    public void searchForRepository(String repository) {
        parameter("Repository", repository);
        $(".header-search-input").val(repository).pressEnter();
    }
    @Step("Go to the repository {repository}")
    public void goToRepository(String repository) {
        $(byLinkText(repository)).click();
    }
    @Step("Go to tab Issues")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }
    @Step("Verify there is Issue number {number} in Issues")
    public void shouldSeeIssueWithNumber(int number) {
        parameter("Issue Number", number);
        $(withText("#" + number)).shouldBe(visible);
    }
}
