package com.wallet.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
//        "classpath:config/local.properties",
        "classpath:web.properties"
})
public interface WebConfig extends Config {

        @Key("web.url")
        String webUrl();

        @Key("web.browser")
        String webBrowser();

        @Key("web.browser.screen.resolution")
        String webBrowserScreenResolution();

        @Key("web.browser.remote")
        String webRemoteBrowser();




}
