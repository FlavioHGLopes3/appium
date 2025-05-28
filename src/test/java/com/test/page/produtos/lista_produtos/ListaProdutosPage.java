package com.test.page.produtos.lista_produtos;

import com.test.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@Getter
@NoArgsConstructor
public class ListaProdutosPage extends BasePage {

    public void validatePage () {validateElementPresence("//android.widget.TextView[@text=\"BEBIDAS\"][1]");}

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Adicionar item\"]")
    private WebElement botaoAdicionarQuantidadeCard;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Subtrair item\"]")
    private WebElement botaoSubtrairQuantidadeCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirmar\"]")
    private WebElement botaoConfirmarCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancelar\"]")
    private WebElement botaoCancelarCard;


}
