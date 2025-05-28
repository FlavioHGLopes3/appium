package com.test.actions.produtos;


import com.test.page.MasterPageFactory;
import com.test.page.produtos.carrinho.CarrinhoPage;
import static com.test.page.BasePage.clicar;

public class CarrinhoActions {

    public static CarrinhoPage carrinhoPage () {
        return MasterPageFactory.getPage(CarrinhoPage.class);
    }

    public static void acessarListaDeProdutos(){
        clicar(carrinhoPage().getBotaoAdicionarProdutos());
    }

    public static void acessarTelaDePrazos(){
        clicar(carrinhoPage().getBotaoFinalizarCompra());
    }

    public static void acessarFluxoDeIdentificarCliente(){
        clicar(carrinhoPage().getBotaoIdentificarCliente());
    }


}
