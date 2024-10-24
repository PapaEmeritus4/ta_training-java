package com.epam.training.volodymyr_bilan.web_driver.optional_task1.test;

import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.model.Paste;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.page.PastebinMainPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.service.PasteCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PasteCreationTests extends BaseTest {

    @Test()
    public void createNewPaste() {
        Paste testPaste = PasteCreator.getPasteWithCredentialsFromProperty();
        PastebinMainPage mainPage = new PastebinMainPage(driver)
                .openPage()
                .createPaste(testPaste);

        assertNotNull(mainPage);
    }
}
