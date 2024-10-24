package com.epam.training.volodymyr_bilan.web_driver.optional_task2.test;

import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import com.epam.training.volodymyr_bilan.web_driver.optional_task2.model.PasteV2;
import com.epam.training.volodymyr_bilan.web_driver.optional_task2.page.PastebinV2MainPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task2.page.PastebinV2ResultPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task2.service.PasteV2Creator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PasteV2CreationTests extends BaseTest {

    @Test
    public void createNewPasteWithBashCode() {
        PasteV2 paste = PasteV2Creator.getPasteWithCredentialsFromProperty();

        String expectedPasteTitle = paste.getPasteName();
        String expectedSyntax = paste.getSyntax();
        String expectedPasteCode = paste.getCode();

        PastebinV2ResultPage resultPage = new PastebinV2MainPage(driver)
                .openPage()
                .createPaste(paste);
        String actualPasteTile = resultPage.getPageTitleText();
        String actualSyntax = resultPage.getSelectedSyntax();
        String actualPasteCode = resultPage.getPasteCode();

        assertEquals(expectedPasteTitle, actualPasteTile);
        assertEquals(expectedSyntax, actualSyntax);
        assertEquals(expectedPasteCode, actualPasteCode);
    }
}
