package com.automationexercise.pages;

import com.automationexercise.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class BasePage {

    protected void elementoContemTexto(WebElement element, String texto) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverManager.startDriver(), Duration.ofSeconds(15));
        DriverManager.tirarPrint();
        wait.until(ExpectedConditions.textToBePresentInElement(element, texto));
    }

    protected void clicar(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.startDriver(), Duration.ofSeconds(15));
        DriverManager.tirarPrint();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void limparEpreencher(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}