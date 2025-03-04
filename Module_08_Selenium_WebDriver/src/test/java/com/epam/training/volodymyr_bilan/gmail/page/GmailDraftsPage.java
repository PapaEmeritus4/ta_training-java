package com.epam.training.volodymyr_bilan.gmail.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils.*;

public class GmailDraftsPage extends AbstractPage {

    @FindBy(xpath = "(//span[text()='Draft'])[2]")
    private WebElement draftEmailButton;

    @FindBy(xpath = "(//*[contains(text(),'drafts')])[3]")
    private WebElement draftsPresence;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendDraftButton;

    @FindBy(xpath = "//*[text()='Sent']")
    private WebElement sentFolderButton;

    @FindBy(xpath = "(//span[contains(text(),'@gmail.com')])[2]")
    private WebElement recipientEmail;

    @FindBy(xpath = "(//span[text()='Letter'])[2]")
    private WebElement subject;

    @FindBy(xpath = "//div[@aria-label='Message Body']//div[text()='Hello World!']")
    private WebElement message;

    public GmailDraftsPage(WebDriver driver) {
        super(driver);
    }

    public GmailDraftsPage openDraftEmail() {
        waitForVisibility(draftEmailButton).click();
        return this;
    }

    public boolean isDraftsEmpty() {
        try {
            return waitForVisibility(draftsPresence).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public GmailDraftsPage sendDraftMessage() {
        waitForVisibility(sendDraftButton).click();
        return this;
    }

    public GmailSentPage clickOnSentFolder() {
        waitForVisibility(sentFolderButton).click();
        return new GmailSentPage(driver);
    }

    public String getRecipient() {
        return waitForVisibility(recipientEmail).getText();
    }

    public String getSubject() {
        return waitForVisibility(subject).getText();
    }

    public String getMessage() {
        return waitForVisibility(message).getText();
    }
}
