package com.test.page.produtos.lista_produtos_grupo;

import com.test.page.BasePage;
import com.test.page.MasterPageFactory;

public class ListaProdutosDoGrupoPage extends BasePage {
    public static ListaProdutosDoGrupoPage listaProdutosDoGrupoPage(){
        return MasterPageFactory.getPage(ListaProdutosDoGrupoPage.class);
    }




//    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Adicionar item\"]")
//    private WebElement botaoSimboloAdicionarQuantidade;


}
