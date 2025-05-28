package com.test.page.produtos.carrinho;

import com.test.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@Getter
@NoArgsConstructor
public class CarrinhoPage extends BasePage {
    public void validatePage () {validateElementPresence("//android.widget.TextView[@text=\"Carrinho\"]");}

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View")
    private WebElement botaoIdentificarCliente;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Adicionar produtos\"]")
    private WebElement botaoAdicionarProdutos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Finalizar compra\"]")
    private WebElement botaoFinalizarCompra;


}
