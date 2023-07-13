package com.automationexercise.pages;

import com.automationexercise.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//p[contains(text(),'Stylish Dress')]/../../../div[2]/ul/li/a")
    private WebElement botaoStylishDress;

    @FindBy(xpath = "//p[contains(text(),'Beautiful Peacock Blue Cotton Linen Saree')]/../../../div[2]/ul/li/a")
    private WebElement botaoBeautifulPeacockBlueCottonLinenSaree;

    @FindBy(xpath = "//p[contains(text(),'Men Tshirt')]/../../../div[2]/ul/li/a")
    private WebElement botaoMenTshirt;

    @FindBy(css = "div.product-information h2")
    private WebElement tituloProduto;

    @FindBy(id = "quantity")
    private WebElement campoQuantidade;

    @FindBy(css = "span button")
    private WebElement botaoAdicionar;

    @FindBy(css = "div.modal-header h4")
    private WebElement mensagemAdicionado;

    @FindBy(css = "div.modal-footer button")
    private WebElement botaoContinuarComprando;

    @FindBy(css = "body ins:nth-child(15) div.grippy-host")
    private WebElement diminuirAds;

    @FindBy(css = "div.col-sm-8 div ul li:nth-child(2) a")
    private WebElement botaoProdutos;


    public HomePage() {
        this.driver = DriverManager.startDriver();
        PageFactory.initElements(driver, this);
    }

    public void fecharAd(){
        driver.get("https://automationexercise.com/");
        clicar(botaoProdutos);

    }

    public void comprar(String produto, String quantidade) throws InterruptedException {
        driver.get("https://automationexercise.com/");
        switch (produto) {
            case "Stylish Dress" -> clicar(botaoStylishDress);
            case "Beautiful Peacock Blue Cotton Linen Saree" -> clicar(botaoBeautifulPeacockBlueCottonLinenSaree);
            case "Men Tshirt" -> clicar(botaoMenTshirt);
            default -> System.out.println("Produto não encontrado");
        }
        elementoContemTexto(tituloProduto, produto);
        limparEpreencher(campoQuantidade, quantidade);
        clicar(botaoAdicionar);
        elementoContemTexto(mensagemAdicionado, "Added!");
        clicar(botaoContinuarComprando);

    }

}
