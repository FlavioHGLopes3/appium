package com.test.actions;

import com.test.page.BasePage;
import com.test.page.MasterPageFactory;
import com.test.page.MenuPage;

public class MenuPageActions extends BasePage {


    public static MenuPage menuPage(){
        return MasterPageFactory.getPage(MenuPage.class);
    }

    public static void validatePage() {
        menuPage().validatePage();
    }

    public static void acessarAbastecimentos() {
        clicar(menuPage().getIconeAbastecimento());
    }

    public static void acessarProdutos() {
        clicar(menuPage().getIconeProdutos());
    }

    public static void acessarRestaurante() {
        clicar(menuPage().getIconeRestaurante());
    }

    public static void receberMesaMenu() {
        clicar(menuPage().getIconePagarMesa());
    }

    public static void acessarOperacoes() {
        clicar(menuPage().getIconeOperacoes());
    }

}
