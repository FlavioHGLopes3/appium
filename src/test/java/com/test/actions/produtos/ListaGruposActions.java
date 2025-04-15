package com.test.actions.produtos;

import com.test.page.MasterPageFactory;
import com.test.page.produtos.lista_grupos.ListaGruposPage;
import io.appium.java_client.AppiumBy;

import static com.test.page.BasePage.clicar;

public class ListaGruposActions {

    public static ListaGruposPage listaGruposDeProdutosPage(){
        return MasterPageFactory.getPage(ListaGruposPage.class);
    }

    public static void validatePage() {
        listaGruposDeProdutosPage().validatePage();
    }


    public static void selecionarGrupoProduto(String nomeGrupo) {
        String nomeGrupoUpper = nomeGrupo.toUpperCase().trim();
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"" + nomeGrupoUpper + "\"]"));
    }



}
