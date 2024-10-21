package com.epam.training.volodymyr_bilan.web_driver.optional_task2.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task2.model.PasteV2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils.*;

@Slf4j
public class PastebinV2MainPage extends AbstractPage {

    private final String BASE_URL = "https://pastebin.com/";
    private final long DURATION = 10;

    @FindBy(id = "postform-text")
    private WebElement codeTextArea;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxSelectBox;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationSelectBox;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public PastebinV2MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinV2MainPage openPage() {
        driver.get(BASE_URL);
        log.info("Pastebin page opened.");
        return this;
    }

    public PastebinV2MainPage enterCode(String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.visibilityOf(codeTextArea)).sendKeys(code);
        return this;
    }

    public PastebinV2MainPage selectSyntax(String syntax) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", syntaxSelectBox);
        syntaxSelectBox.click();
        waitForVisibility(By.xpath("//li[text()='" + syntax + "']")).click();
        return this;
    }

    public PastebinV2MainPage selectExpiration(String expiration) {
        expirationSelectBox.click();
        waitForVisibility(By.xpath("//li[text()='" + expiration + "']")).click();
        return this;
    }

    public PastebinV2MainPage enterPasteName(String pasteName) {
        pasteNameInput.sendKeys(pasteName);
        return this;
    }

    public PastebinV2ResultPage createPaste(PasteV2 paste) {
        enterCode(paste.getCode())
                .selectSyntax(paste.getSyntax())
                .selectExpiration(paste.getPasteExpiration())
                .enterPasteName(paste.getPasteName());

        createNewPasteButton.click();
        log.info("Paste was created with name: {}", paste.getPasteName());
        return new PastebinV2ResultPage(driver);
    }
}