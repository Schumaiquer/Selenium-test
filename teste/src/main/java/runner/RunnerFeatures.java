package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features",
        glue = "step",
        plugin = {"html:target/report-html/"}, // gera relatorio
        tags = {"@Smoke"},
        monochrome = true, // habilita cores de execução
        snippets = SnippetType.CAMELCASE,
        dryRun = false, // se for "true" da após executar os metodos faltando
        strict = false
)
public class RunnerFeatures {
}