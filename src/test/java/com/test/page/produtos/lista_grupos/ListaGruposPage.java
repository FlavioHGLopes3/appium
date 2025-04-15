package com.test.page.produtos.lista_grupos;

import com.test.page.BasePage;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListaGruposPage extends BasePage {



    public void validatePage () {
        validateElementPresence("//android.widget.TextView[@text=\"Produtos\"]");
    }

}
