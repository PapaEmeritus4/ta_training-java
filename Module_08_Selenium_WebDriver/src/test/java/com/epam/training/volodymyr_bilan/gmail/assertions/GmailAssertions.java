package com.epam.training.volodymyr_bilan.gmail.assertions;

import com.epam.training.volodymyr_bilan.gmail.model.EmailSendStatus;
import com.epam.training.volodymyr_bilan.gmail.model.LoginData;
import com.epam.training.volodymyr_bilan.gmail.model.MessageData;
import com.epam.training.volodymyr_bilan.gmail.page.GmailDraftsPage;
import lombok.extern.slf4j.Slf4j;

import static org.testng.Assert.*;

@Slf4j
public class GmailAssertions {

    public static void verifySuccessfulLogin(String actualEmail, LoginData expectedData) {
        assertEquals(actualEmail, expectedData.getEmail(), "Displayed email does not match expected");
        log.info("✅ Login test passed for email: {}", expectedData.getEmail());
    }

    public static void verifyDraftSaved(GmailDraftsPage draftEmailPage, MessageData messageData) {
        assertFalse(draftEmailPage.isDraftsEmpty(), "❌ Draft folder is not empty after saving draft.");
        assertTrue(draftEmailPage.getRecipient().contains(messageData.getRecipient()), "❌ Recipient does not match.");
        assertEquals(draftEmailPage.getSubject(), messageData.getSubject(), "❌ Subject does not match.");
        assertEquals(draftEmailPage.getMessage(), messageData.getMessage(), "❌ Message does not match.");
        log.info("✅ Draft saved successfully: recipient={}, subject={}, message={}",
                messageData.getRecipient(), messageData.getSubject(), messageData.getMessage());
    }

    public static void verifyEmailSent(EmailSendStatus status) {
        assertTrue(status.isDraftEmpty(), "❌ Draft folder is empty after sending email.");
        assertFalse(status.isSentFolderEmpty(), "❌ Sent folder is not empty after sending email.");
        log.info("✅ Email successfully sent and appears in Sent folder.");
    }
}

