package com.automationpractice;

import com.automationpractice.helpers.AttachmentsHelper;
import com.automationpractice.helpers.DriverHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

        @BeforeAll
        public static void beforeAll() {
            DriverHelper.configureDriver();
        }

        @AfterEach
        public void addAttachments(){
            String sessionId = DriverHelper.getSessionId();
            AttachmentsHelper.attachScreenshot("Last screenshot");
            AttachmentsHelper.attachPageSource();
            AttachmentsHelper.attachAsText("Browser console logs", DriverHelper.getConsoleLogs());
            AttachmentsHelper.attachVideo(sessionId);
            closeWebDriver();

        }


}
