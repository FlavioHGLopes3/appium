package com.test.steps.produtos;

import com.test.actions.ConfigActions;
import com.test.actions.LoginActions;
import com.test.actions.MenuPageActions;
import com.test.actions.produtos.ListaGruposActions;
import com.test.actions.produtos.ListaProdutosActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertTrue;

@Slf4j
public class ProdutosSteps {


    @Dado("que o pay esteja conectado no servidor")
    public void que_o_pay_esteja_conectado_no_servidor() {
        log.info("Conectando PAY ao servidor");
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP("192.168.018.172","8081");
    }





    @Dado("um produto com estoque negativo")
    public void um_produto_com_estoque_negativo() {
        log.info("Selecionando um produto com estoque negativo");
        MenuPageActions.acessarProdutos();
        ListaGruposActions.validatePage();
        ListaGruposActions.selecionarGrupoProduto("bebidas");
    }

    @Quando("pressionado para informar a quantidade")
    public void pressionado_para_informar_o_item() {
        assertTrue(
                "Card deveria ser exibido para informar a quantidade desejada",
                ListaProdutosActions.verificarSeCardFoiExibido()
        );

    }

    @Entao("é exibido um toast de estoque insuficiente")
    public void é_exibido_um_toast_de_estoque_insuficiente() {
        assertTrue("Toast de estoque insuficiente não foi exibido",
                ListaProdutosActions
                        .toastGetMessage("Produto com estoque insuficiente."));

    }


    @Dado("um produto que permite a venda com estoque negativo")
    public void um_produto_que_permite_venda_com_estoque_negativo() {
        log.info("Selecionando um produto com estoque positivo");

    }


    @Entao("é exibido a tela de informar quantidade")
    public void e_exibido_a_tela_de_informar_quantidade() {

    }

    @Dado("um produto com estoque zerado")
    public void um_produto_com_estoque_zerado() {

    }

    @E("o usuario ja esteja logado")
    public void o_usuario_ja_esteja_logado() {

    }

    @Dado("um pdv sem permissao")
    public void um_pdv_sem_permissao() {
        log.info("Selecionando PDV com a chave PDV-Bloqueia vendas c/ estoque negativo = SIM, PDV ROTINA GRANITO");
        ConfigActions.selecionarPDVporTEF("GRANITO");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
    }

    @Dado("um funcionario com permissao")
    public void um_funcionario_com_permissao() {
        log.info("Logando com o funcionário com permissao de 'Liberar Estoque Negativo'");
        LoginActions.realizarLogin("3","1");


    }

    @E("um produto sem permissao")
    public void um_produto_sem_permissao() {
        MenuPageActions.acessarProdutos();
        ListaGruposActions.selecionarGrupoProduto("BEBIDAS");
        ListaProdutosActions.selecionarProduto("VODKA SMIRNOFF CRANB");
    }

    @Entao("é possível realizar o fluxo de venda")
    public void e_possivel_realizar_o_fluxo_de_Venda() {
        assertTrue("Não foi exibido o card de editar quantidade do item corretamente",
                ListaProdutosActions.verificarSeCardFoiExibido());
    }

    @E("um funcionario sem permissao")
    public void um_funcionario_sem_permissao() {
        log.info("Logando com o funcionario sem permissao de 'Liberar Estoque Negativo'");
        LoginActions.realizarLogin("1","1");
    }

    @Dado("um pdv com permissao")
    public void um_pdv_com_permissao() {
        log.info("Selecionando PDV com a chave PDV-Bloqueia vendas c/ estoque negativo = NAO, PAY ROTINA GETNET");
        ConfigActions.selecionarPDVporTEF("GETNET");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
    }

    @E("um produto com permissao")
    public void um_produto_com_permissao() {
        MenuPageActions.acessarProdutos();
        ListaGruposActions.selecionarGrupoProduto("BEBIDAS");
        ListaProdutosActions.selecionarProduto("VODKA VORUS - 1L");
    }


}
