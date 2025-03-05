package com.epam.training.volodymyr_bilan.gmail.test;

import com.epam.training.volodymyr_bilan.gmail.model.LoginData;
import com.epam.training.volodymyr_bilan.gmail.model.MessageData;
import com.epam.training.volodymyr_bilan.gmail.page.GmailLoginPage;
import com.epam.training.volodymyr_bilan.gmail.service.DataCreator;
import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Slf4j
public class GmailTest extends BaseTest {

//    LoginData data = new LoginData(
//            "epam.qa.mail@gmail.com",
//            "12345678!A"
//    );
//    MessageData messageData = new MessageData(
//            "vovakaiman2005@gmail.com",
//            "Letter",
//            "Hello World!"
//    );

    @Test(priority = 1)
    public void testSuccessfulGmailLoginFunctionality(){
        LoginData data = DataCreator.getLoginData();
        var displayedEmail = new GmailLoginPage(driver)
                .openPage()
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .getUserEmail();
        assertEquals(displayedEmail, data.getEmail(), "Displayed email does not match expected");
        log.info("Login test passed for email: {}, password: {}", data.getEmail(), data.getPassword());
    }

    @Test(priority = 2)
    public void testDraftGmailCompositionAndSavingFunctionality() {
        LoginData data = DataCreator.getLoginData();
        MessageData messageData = DataCreator.getMessageData();
        var draftEmailPage  = new GmailLoginPage(driver)
                .openPage()
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .clickCompose()
                .enterRecipient(messageData.getRecipient())
                .enterSubject(messageData.getSubject())
                .enterMessage(messageData.getMessage())
                .saveDraft()
                .clickOnDraftFolder()
                .openDraftEmail();
        assertFalse(draftEmailPage.isDraftsEmpty());
        assertTrue(draftEmailPage.getRecipient().contains(messageData.getRecipient()));
        assertEquals(draftEmailPage.getSubject(), messageData.getSubject());
        assertEquals(draftEmailPage.getMessage(), messageData.getMessage());
        log.info(
                "Draft Email composition and saving test passed for recipient: {}, subject: {}, message: {}",
                messageData.getRecipient(), messageData.getSubject(), messageData.getMessage()
        );
    }

    @Test(priority = 3)
    public void testGmailSendingFunctionality() {
        LoginData data = DataCreator.getLoginData();
        var gmailPage  = new GmailLoginPage(driver)
                .openPage()
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .clickOnDraftFolder()
                .openDraftEmail()
                .sendDraftMessage();
        assertTrue(gmailPage.isDraftsEmpty());

        var sendEmailsPage  = gmailPage.clickOnSentFolder();
        assertFalse(sendEmailsPage.isSendsEmpty());
        log.info("Test completed successfully: Draft email sent and Sent folder is not empty.");
    }
}
