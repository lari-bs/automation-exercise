package com.automationexercise.pages;

import com.automationexercise.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Stylish Dress')]/../../../td[4]/button")
    private WebElement textoQuantidadeStylishDress;

    @FindBy(xpath = "//a[contains(text(),'Beautiful Peacock Blue Cotton Linen Saree')]/../../../td[4]/button")
    private WebElement textoQuantidadeBeautifulPeacockBlueCottonLinenSaree;

    @FindBy(xpath = "//a[contains(text(),'Men Tshirt')]/../../../td[4]/button")
    private WebElement textoQuantidadeMenTshirt;

    public CartPage() {
        this.driver = DriverManager.startDriver();
        PageFactory.initElements(driver, this);
    }

    public void abrirCarrinho(){
        driver.get("https://automationexercise.com/view_cart");
    }

    public void validarCarrinho(String produto, String quantidade) throws InterruptedException {
        switch (produto) {
            case "Stylish Dress" -> elementoContemTexto(textoQuantidadeStylishDress, quantidade);
            case "Beautiful Peacock Blue Cotton Linen Saree" ->
                    elementoContemTexto(textoQuantidadeBeautifulPeacockBlueCottonLinenSaree, quantidade);
            case "Men Tshirt" -> elementoContemTexto(textoQuantidadeMenTshirt, quantidade);
            default -> System.out.println("Produto não encontrado");
        }
    }

}
