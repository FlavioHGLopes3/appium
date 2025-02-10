package com.test.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@Getter
@NoArgsConstructor
public class MenuPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Open Modal Drawer\"]")
    private WebElement menuDrawer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"WebPostoPay\"]")
    private WebElement tituloMenuPrincipal;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Botoes menu\"])[1]")
    private WebElement iconeAbastecimento;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Botoes menu\"])[2]")
    private WebElement iconeProdutos;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Botoes menu\"])[3]")
    private WebElement iconeRestaurante;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Botoes menu\"])[4]")
    private WebElement iconePagarMesa;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Botoes menu\"])[5]")
    private WebElement iconeOperacoes;


    public void validatePage () {
        validateElementPresence("//android.widget.TextView[@text=\"WebPostoPay\"]");
    }



}
