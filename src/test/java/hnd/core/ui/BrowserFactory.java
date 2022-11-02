package hnd.core.ui;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.*;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrowserFactory {

    @Getter
    private Page page;

    public void initBrowser(String browserName, boolean isHeadless) {
        this.page = createPage(launch(browserName, isHeadless));
        this.page.onDialog(Dialog::accept);
    }

    private Browser launch(String browserName, boolean isHeadless) {
        Playwright playwright = Playwright.create();
        return playwright.chromium().launch(launchOptions(browserName, isHeadless));
    }

    private Page createPage(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();
    }

    private BrowserType.LaunchOptions launchOptions(String browserName, boolean isHeadless) {
        List<String> args = new ArrayList<>();
        args.add("--start-maximized");
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setChannel(BrowserList.findBrowser(browserName).name().replace("_","-"));
        options.setHeadless(isHeadless);
        if (isHeadless) {
            args.add("--window-size="+getScreenWidth()+","+getScreenHeight());
        }
        return options.setArgs(args);
    }

    public void close() {
        this.page.context().close();
    }

    // Java code to display the screen width
    private static String getScreenWidth() {
        // getScreenSize() returns the size of the screen in pixels
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // return the width of the screen
        return String.valueOf((int) size.getWidth());
    }

    // Java code to display the screen height
    private static String getScreenHeight() {
        // getScreenSize() returns the size of the screen in pixels
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // return the height of the screen
        return String.valueOf((int) size.getHeight());
    }
}



