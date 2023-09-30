package step;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class KlavagonkiStep {

    private final SelenideElement closeWindowButton = $x("//*[@id='howtoplay']/div[2]/div/table/tbody/tr[2]/td[2]/p[5]/input");
    private final SelenideElement startGameBtn = $x("//a[@id='host_start']");
    private final SelenideElement findHighlightWord = $x("//span[@id='typefocus']");
    private final SelenideElement inputWordsInField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocusWord = $x("//span[@id='afterfocus']");


    private String getCurrentWord () {
        return findHighlightWord.getText().replaceAll("с","с")
                .replaceAll("o","о")
                .replaceAll("a","а")
                .replaceAll("Ps","o")
                .replaceAll("B","В")
                .replaceAll("C","С")
                .replaceAll("p","р")
                .replaceAll("H","Н");


    }

    @When("We start the game")
    public void startGame() {
        closeWindowButton.click();
        if (startGameBtn.isDisplayed()) {
            startGameBtn.click();
        }
    }

    @And("wait for game start")
    public void waitForGameStart() {
        findHighlightWord.click();
    }

    @And("enter highlighted word in cycle")
    public void playGame() {
        while (true) {
            String currentWord = getCurrentWord();
            String focusSymbol = afterFocusWord.getText();
            inputWordsInField.sendKeys(currentWord);
            if(focusSymbol.equals(".")) {
                inputWordsInField.sendKeys(".");
                break;
            }
            inputWordsInField.sendKeys(Keys.SPACE);
        }
    }

    @Then("ensure that the game is ended and it has a number of symbols not less than {int}")
    public void endGame (int minValue) {
    }
}
