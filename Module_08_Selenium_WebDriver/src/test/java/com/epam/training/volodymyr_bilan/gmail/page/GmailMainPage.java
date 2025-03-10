package com.epam.training.volodymyr_bilan.gmail.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.volodymyr_bilan.util.WaitUtils.*;

@Slf4j
public class GmailMainPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='epam.qa.mail@gmail.com']")
    private WebElement userEmail;

    @FindBy(xpath = "//*[text()='Compose']")
    private WebElement composeButton;

    @FindBy(xpath = "//input[@aria-label='To recipients']")
    private WebElement recipientInput;

    @FindBy(xpath = "//input[@aria-label='Subject']")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement messageInput;

    @FindBy(xpath = "//img[@aria-label='Save & close']")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//*[text()='Drafts']")
    private WebElement draftFolderButton;

    @FindBy(xpath = "//a[@role='button' and contains(@aria-label, 'Google Account')]")
    private WebElement profileButton;

    @FindBy(xpath = "//*[text()='Sign out']")
    private WebElement signOutButton;

    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    public String getUserEmail() {
        String email = userEmail.getText();
        log.info("User email obtained: {}", email);
        return email;
    }

    public GmailMainPage clickCompose() {
        waitForVisibility(composeButton).click();
        return this;
    }

    public GmailMainPage enterRecipient(String recipient) {
        waitForVisibility(recipientInput).clear();
        recipientInput.sendKeys(recipient);
        return this;
    }

    public GmailMainPage enterSubject(String subject) {
        waitForVisibility(subjectInput).clear();
        subjectInput.sendKeys(subject);
        return this;
    }

    public GmailMainPage enterMessage(String message) {
        waitForVisibility(messageInput).clear();
        messageInput.sendKeys(message);
        return this;
    }

    public GmailMainPage saveDraft() {
        waitForVisibility(saveDraftButton).click();
        return this;
    }

    public GmailDraftsPage clickOnDraftFolder() {
        waitForVisibility(draftFolderButton).click();
        return new GmailDraftsPage(driver);
    }

    public GmailMainPage clickOnProfile() {
        waitForVisibility(profileButton).click();
        return this;
    }

    public GmailMainPage signOut() {
        waitForVisibility(signOutButton).click();
        log.info("User {} sign out", getUserEmail());
        return this;
    }
}
