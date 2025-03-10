package com.epam.training.volodymyr_bilan.gmail.steps;

import com.epam.training.volodymyr_bilan.gmail.model.EmailSendStatus;
import com.epam.training.volodymyr_bilan.gmail.model.LoginData;
import com.epam.training.volodymyr_bilan.gmail.model.MessageData;
import com.epam.training.volodymyr_bilan.gmail.page.GmailDraftsPage;
import com.epam.training.volodymyr_bilan.gmail.page.GmailLoginPage;
import com.epam.training.volodymyr_bilan.gmail.page.GmailSentPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;


@Slf4j
public class GmailStepDefinition {

    private final WebDriver driver;

    public GmailStepDefinition(WebDriver driver) {
        this.driver = driver;
    }

    public String performLoginAndGetDisplayedEmail(LoginData data) {
        return new GmailLoginPage(driver)
                .openPage()
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .getUserEmail();
    }

    public GmailDraftsPage saveDraft(LoginData loginData, MessageData messageData) {
        return new GmailLoginPage(driver)
                .openPage()
                .enterEmail(loginData.getEmail())
                .enterPassword(loginData.getPassword())
                .clickCompose()
                .enterRecipient(messageData.getRecipient())
                .enterSubject(messageData.getSubject())
                .enterMessage(messageData.getMessage())
                .saveDraft()
                .clickOnDraftFolder()
                .openDraftEmail();
    }

    public EmailSendStatus sendEmail(LoginData loginData) {
        GmailDraftsPage gmailPage = new GmailLoginPage(driver)
                .openPage()
                .enterEmail(loginData.getEmail())
                .enterPassword(loginData.getPassword())
                .clickOnDraftFolder()
                .openDraftEmail()
                .sendDraftMessage();

        GmailSentPage sentEmailsPage = gmailPage.clickOnSentFolder();
        return new EmailSendStatus(gmailPage.isDraftsEmpty(), sentEmailsPage.isSendsEmpty());
    }
}

