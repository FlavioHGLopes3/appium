package com.test.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ProdutosSteps {
    @Dado("um produto com estoque negativo")
    public void um_produto_com_estoque_negativo() {


    }
    @Quando("pressionado para informar a quantidade")
    public void pressionado_para_informar_a_quantidade() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Entao("é exibido um toast de estoque insuficiente")
    public void é_exibido_um_toast_de_estoque_insuficiente() {
        // Write code here that turns the phrase above into concrete actions

    }


    @Dado("um produto que permite a venda com estoque negativo")
    public void um_produto_que_permite_venda_com_estoque_negativo() {

    }


    @Entao("é exibido a tela de informar quantidade")
    public void eh_exibido_a_tela_de_informar_quantidade() {

    }

    @Dado("um produto com estoque zerado")
    public void um_produto_com_estoque_zerado() {

    }

    @E("o usuario ja esteja logado")
    public void o_usuario_ja_esteja_logado() {

    }
}
