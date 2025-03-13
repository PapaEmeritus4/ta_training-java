package com.epam.training.volodymyr_bilan.ui.test;

import com.epam.training.volodymyr_bilan.ui.assertions.GmailAssertions;
import com.epam.training.volodymyr_bilan.ui.model.DataCreator;
import com.epam.training.volodymyr_bilan.ui.model.LoginData;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest {

    @Test
    public void testSuccessfulGmailLoginFunctionality(){
        LoginData data = DataCreator.getLoginData();
        String displayedEmail = gmailSteps.performLoginAndGetDisplayedEmail(data);
        GmailAssertions.verifySuccessfulLogin(displayedEmail, data);
    }

}
