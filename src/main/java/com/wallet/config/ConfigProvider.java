package com.wallet.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getWebBrowser() {
        return getWebConfig().webBrowser();
    }

    public static String getWebBrowserScreenResolution() {
        return getWebConfig().webBrowserScreenResolution();
    }

    public static String getWebRemoteBrowser(){
        return getWebConfig().webRemoteBrowser();
    }

     private static WebConfig getWebConfig() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

}
