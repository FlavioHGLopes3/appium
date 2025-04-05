package com.test.page.produtos.lista_grupos_produtos;

import com.test.page.BasePage;

public class ListaGruposDeProdutosPage extends BasePage {




    public void validatePage () {
        validateElementPresence("//android.widget.TextView[@text=\"Produtos\"]");
    }
}
