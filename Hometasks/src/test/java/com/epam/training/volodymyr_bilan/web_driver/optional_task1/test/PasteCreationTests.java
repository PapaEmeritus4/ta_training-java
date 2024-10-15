package com.epam.training.volodymyr_bilan.web_driver.optional_task1.test;

import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.model.Paste;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.page.PastebinMainPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.service.PasteCreator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PasteCreationTests extends BaseTest {

    @Test(description = "JIRA-0401") //first two numbers = number of module, last two = number of task
    public void createNewPaste() {
        Paste testPaste = PasteCreator.getPasteWithCredentialsFromProperty();
        PastebinMainPage mainPage = new PastebinMainPage(driver)
                .openPage()
                .createPaste(testPaste);

        assertNotNull(mainPage);
    }
}
