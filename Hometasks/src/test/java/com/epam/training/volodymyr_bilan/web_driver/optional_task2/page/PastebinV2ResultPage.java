package com.epam.training.volodymyr_bilan.web_driver.optional_task2.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinV2ResultPage extends AbstractPage {

    @FindBy(tagName = "h1")
    private WebElement pasteTitle;

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement selectedSyntaxField;

    @FindBy(xpath = "//ol[@class='bash']")
    private WebElement pasteCodeField;

    public PastebinV2ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitleText() {
        return WaitUtils.waitForVisibility(driver, pasteTitle)
                .getText();
    }

    public String getSelectedSyntax() {
        return WaitUtils.waitForVisibility(driver, selectedSyntaxField)
                .getText();
    }

    public String getPasteCode() {
        return WaitUtils.waitForVisibility(driver, pasteCodeField)
                .getText();
    }
}
