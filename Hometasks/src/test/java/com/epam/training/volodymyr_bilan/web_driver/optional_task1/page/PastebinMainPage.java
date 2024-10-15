package com.epam.training.volodymyr_bilan.web_driver.optional_task1.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.model.Paste;
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

@Slf4j
public class PastebinMainPage extends AbstractPage {

    private final String BASE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement codeTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationSelectBox;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public PastebinMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinMainPage openPage() {
        driver.get(BASE_URL);
        log.info("Pastebin page opened.");
        return this;
    }

    public PastebinMainPage createPaste(Paste paste) {
        codeTextArea.sendKeys(paste.getCode());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", expirationSelectBox);
        expirationSelectBox.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + paste.getPasteExpiration() + "']")));
        WebElement option = driver.findElement(By.xpath("//li[text()='" + paste.getPasteExpiration() + "']"));
        option.click();

        pasteNameInput.sendKeys(paste.getPasteName());

        createNewPasteButton.click();
        log.info("Paste was created.");
        return this;
    }

}