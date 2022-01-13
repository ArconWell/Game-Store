package run;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue="steps",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {
}
