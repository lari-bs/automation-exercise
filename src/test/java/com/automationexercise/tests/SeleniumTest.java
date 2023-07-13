package com.automationexercise.tests;

import com.automationexercise.driver.DriverManager;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.data.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeleniumTest {
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeEach
    public void setup() {
        DriverManager.startDriver();
        DriverManager.inicializarPastaDeEvidencias();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    @AfterEach
    public void teardown() {
        DriverManager.killDriver();
    }

    @Test
    void testeComprar() throws Exception {
        homePage.fecharAd();
        homePage.comprar(Products.Product.STYLISH_DRESS.nome(), Products.Product.STYLISH_DRESS.quantidade());
        homePage.comprar(Products.Product.BEAUTIFUL_PEACOCK_BLUE_COTTON_LINEN_SAREE.nome(), Products.Product.BEAUTIFUL_PEACOCK_BLUE_COTTON_LINEN_SAREE.quantidade());
        homePage.comprar(Products.Product.MEN_TSHIRT.nome(), Products.Product.MEN_TSHIRT.quantidade());
        cartPage.abrirCarrinho();
        cartPage.validarCarrinho(Products.Product.STYLISH_DRESS.nome(), Products.Product.STYLISH_DRESS.quantidade());
        cartPage.validarCarrinho(Products.Product.BEAUTIFUL_PEACOCK_BLUE_COTTON_LINEN_SAREE.nome(), Products.Product.BEAUTIFUL_PEACOCK_BLUE_COTTON_LINEN_SAREE.quantidade());
        cartPage.validarCarrinho(Products.Product.MEN_TSHIRT.nome(), Products.Product.MEN_TSHIRT.quantidade());
    }
}
