package com.epam.training.volodymyr_bilan.gmail.test;

import com.epam.training.volodymyr_bilan.gmail.assertions.GmailAssertions;
import com.epam.training.volodymyr_bilan.gmail.model.EmailSendStatus;
import com.epam.training.volodymyr_bilan.gmail.model.LoginData;
import com.epam.training.volodymyr_bilan.gmail.page.GmailDraftsPage;
import com.epam.training.volodymyr_bilan.gmail.service.DataCreator;
import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class GmailTest extends BaseTest {

    @Test(priority = 1)
    public void testSuccessfulGmailLoginFunctionality(){
        LoginData data = DataCreator.getLoginData();
        String displayedEmail = gmailSteps.performLoginAndGetDisplayedEmail(data);
        GmailAssertions.verifySuccessfulLogin(displayedEmail, data);
    }

    @Test(priority = 2)
    public void testDraftGmailCompositionAndSavingFunctionality() {
        GmailDraftsPage draftEmailPage = gmailSteps.saveDraft(DataCreator.getLoginData(), DataCreator.getMessageData());
        GmailAssertions.verifyDraftSaved(draftEmailPage, DataCreator.getMessageData());
    }

    @Test(priority = 3)
    public void testGmailSendingFunctionality() {
        EmailSendStatus emailStatus = gmailSteps.sendEmail(DataCreator.getLoginData());
        GmailAssertions.verifyEmailSent(emailStatus);
    }
}
