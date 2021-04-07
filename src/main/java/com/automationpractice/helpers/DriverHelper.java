package com.automationpractice.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.automationpractice.config.ConfigProvider.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {

        public static void configureDriver() {

            addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
            Configuration.browser = getWebBrowser();
            Configuration.baseUrl = getWebUrl();
            Configuration.browserSize = getWebBrowserScreenResolution();
            Configuration.timeout = 5000;
            //Configuration.remote = getWebRemoteDriver();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            Configuration.browserCapabilities = capabilities;
        }

        public static String getSessionId(){
            return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
        }

        public static String getConsoleLogs() {
            return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
        }


    }
