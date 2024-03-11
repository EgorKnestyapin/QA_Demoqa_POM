package com.demoqa.tests;

import com.demoqa.pages.BrokenLinksPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectBrokenLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        new BrokenLinksPage(driver).checkBrokenLinks();
    }
}
