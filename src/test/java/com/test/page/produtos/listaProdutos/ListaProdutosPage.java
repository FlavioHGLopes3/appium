package com.test.page.produtos.listaProdutos;

import com.test.page.BasePage;

public class ListaProdutosPage extends BasePage {




    public void validatePage () {
        validateElementPresence("//android.widget.TextView[@text=\"Produtos\"]");
    }
}
