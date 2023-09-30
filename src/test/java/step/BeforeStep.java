package step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {

    @Given("Open URL {string}")
    public void openURL(String arg0) {
        Configuration.timeout = 60_000;
        Selenide.open(arg0);
    }
}
