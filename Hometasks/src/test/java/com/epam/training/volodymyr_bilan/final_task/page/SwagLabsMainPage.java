package com.epam.training.volodymyr_bilan.final_task.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils.*;

@Slf4j
public class SwagLabsMainPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
    private WebElement pageTitle;

    public SwagLabsMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        String title = waitForVisibility(pageTitle).getText();
        log.info("Page title obtained: {}", title);
        return title;
    }
}
