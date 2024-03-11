package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(2)")
    WebElement forms;

    @FindBy(css = ".fc-button-label")
    WebElement buttonLabel;

    public SidePanel getForms() {
        click(forms);
        return new SidePanel(driver);
    }

    public HomePage confirmCookie() {
        click(buttonLabel);
        return this;
    }

    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    @FindBy(css = ".card:nth-child(4)")
    WebElement widgets;

    public SidePanel getAlertsFrameWindows() {
        click(alertsFrameWindows);
        return new SidePanel(driver);
    }

    public SidePanel getWidgets() {
        click(widgets);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(1)")
    WebElement elements;

    public SidePanel getElements() {
        click(elements);
        return new SidePanel(driver);
    }
}
