package com.swaglabs.Drivers;

import com.swaglabs.Utils.propertiesUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Map;

public class BrowserFactory {



    // Kill all Edge processes (browser + driver)
    public static void killEdgeProcesses() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                Runtime.getRuntime().exec("taskkill /F /IM msedge.exe /T");
                Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe /T");
            } else {
                // For Linux/macOS
                Runtime.getRuntime().exec("pkill -f msedge");
                Runtime.getRuntime().exec("pkill -f msedgedriver");
            }

            System.out.println("✅ Edge processes killed successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to kill Edge processes: " + e.getMessage());
        }
    }


    public static WebDriver getBrowser(String browser) {
        if (browser == null) {
            throw new IllegalArgumentException("Browser name must not be null");
        }

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "edge":
                driver = new EdgeDriver(getEdgeOptions());
                break;
            case "firefox":
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            default:
                driver = new ChromeDriver(getChromeOptions());
        }

        if (driver instanceof JavascriptExecutor &&
                (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("edge"))) {
            ((JavascriptExecutor) driver).executeScript(
                    "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
            );
        }

        return driver;
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--lang=en-GB");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");


        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.setExperimentalOption("useAutomationExtension", false);

        Map<String, Object> prefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false
        );
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if (!propertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            chromeOptions.addArguments("--headless=new"); // headless new for Chrome 109+
        }

        return chromeOptions;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--remote-allow-origins=*");

        Map<String, Object> prefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false
        );
        edgeOptions.setExperimentalOption("prefs", prefs);
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if (!propertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            edgeOptions.addArguments("--headless=new");
        }
        return edgeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("--width=1920");
        firefoxOptions.addArguments("--height=1080");
        firefoxOptions.addArguments("--disable-notifications");

        if (!propertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            firefoxOptions.addArguments("--headless");
        }
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setAcceptInsecureCerts(true);

        return firefoxOptions;
    }
}

