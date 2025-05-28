package com.test.steps.produtos;

import com.test.actions.ConfigActions;
import com.test.actions.LoginActions;
import com.test.actions.MenuPageActions;
import com.test.actions.produtos.CarrinhoActions;
import com.test.actions.produtos.ListaGruposActions;
import com.test.actions.produtos.ListaProdutosActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static com.test.Constants.PC_IP_ADDRESS;
import static com.test.Constants.PC_PORT;

public class FluxoDeVendasSteps {
    @Dado("que o pdv esteja configurado com a chave ECF-Trunca valores Totais igual a SIM e logado")
    public void que_o_pdv_esteja_configurado_com_a_chave_ecf_trunca_valores_totais_igual_a_sim_e_logado() {
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.configurarIP(PC_IP_ADDRESS,PC_PORT);
        ConfigActions.selecionarPDVporTEF("GETNET");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
        LoginActions.realizarLogin("3","1");
    }

    @Dado("um produto no valor de 10 reais")
    public void um_produto_no_valor_de_10_reais() {
        MenuPageActions.acessarProdutos();
        ListaGruposActions.selecionarGrupoProduto("BEBIDAS");
        ListaProdutosActions.selecionarProduto("COCA COLA A");
        ListaProdutosActions.confirmarProduto();
    }


    @Dado("outro produto no valor de 8 reais")
    public void outro_produto_no_valor_de_8_reais() {
        CarrinhoActions.acessarListaDeProdutos();
        ListaGruposActions.selecionarGrupoProduto("BEBIDAS");
        ListaProdutosActions.selecionarProduto("COCA COLA B");
        ListaProdutosActions.confirmarProduto();
    }

    @Quando("pressionado para ir em tela de prazos")
    public void pressionado_para_ir_em_tela_de_prazos() {
        CarrinhoActions.acessarTelaDePrazos();
    }

    @Quando("efetuar pagamento de 5 reais")
    public void efetuar_pagamento_de_5_reais_no_dinheiro() {

    }

    @Entao("o saldo restante deve exibir 13 reais")
    public void o_saldo_restante_deve_exibir_13_reais() {

    }

    @Entao("demais prazos devem exibir 13 reais")
    public void demais_prazos_devem_exibir_13_reais() {

    }



    @E("deve ser possivel finalizar a venda lançando o pagamento exibido")
    public void deve_ser_possivel_finalizar_a_venda_lancando_o_pagamento_exibido() {
    }
}
