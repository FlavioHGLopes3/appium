package com.test.page.produtos.tela_prazos;

import com.test.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@Getter
@NoArgsConstructor
public class telaDePrazosPage extends BasePage {

    public void validatePage() {
        validateElementPresence(titulo);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pagamentos\"]")
    private WebElement titulo;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Filtro produto\"]")
    private WebElement btcarrinhoProduto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Identificar Venda\"]")
    private WebElement btIdentificarCliente;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Voltar\"])[1]")
    private WebElement btRetroceder;
}
