package hnd.context;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "classpath:features",
        glue = "hnd",
        tags="not @ignore",
        monochrome = true,
        dryRun = false,
        publish = false,
        plugin={"pretty","html:target/test-report/report.html", "json:target/test-report/json/report.json"})
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        int threadCount = System.getProperty("threads")==null ? 1: Integer.parseInt(System.getProperty("threads"));
        context.getCurrentXmlTest().getSuite()
                .setDataProviderThreadCount(threadCount);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}