package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksPage extends BasePage {
    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public BrokenLinksPage checkBrokenLinks() {
        for (WebElement element : allLinks) {
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String url) {
        URL linkUrl;
        try {
            linkUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " is broken link");
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            System.out.println(url + " - " + e.getMessage() + " link with exception");
        }
    }
}
