package hnd.core.ui;

import java.util.stream.Stream;

enum BrowserList {
    firefox,
    chrome,
    chrome_beta,
    chrome_dev,
    msedge,
    msedge_beta;
    public static BrowserList findBrowser(String browserName) {
        return Stream.of(BrowserList.values()).filter(browser -> browserName
                .equalsIgnoreCase(browser.name())).findFirst().orElseThrow(() -> new RuntimeException("given browser is not handled"));
    }

}



