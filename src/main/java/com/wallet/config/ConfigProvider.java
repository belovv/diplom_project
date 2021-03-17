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

    public static String getWebRemoteDriverUrl(){
        return getWebConfig().webRemoteDriverUrl();
    }

    public static String getWebRemoteDriver(){
        return "https://" + getWebConfig().webRemoteDriverUser() + ":" + getWebConfig().webRemoteDriverPassword() +
               "@" +  getWebRemoteDriverUrl() + ":4444/wd/hub/";
    }

     private static WebConfig getWebConfig() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

}
