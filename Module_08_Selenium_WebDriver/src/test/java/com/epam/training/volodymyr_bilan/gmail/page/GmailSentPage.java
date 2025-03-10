package com.epam.training.volodymyr_bilan.gmail.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.volodymyr_bilan.util.WaitUtils.*;

public class GmailSentPage extends AbstractPage {

    @FindBy(xpath = "//*[text()='No sent messages! ']")
    private WebElement sendsPresence;

    public GmailSentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSendsEmpty() {
        try {
            return waitForVisibility(sendsPresence).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
