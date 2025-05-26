package com.test.steps.prazos;

import com.test.Constants;
import com.test.actions.ConfigActions;
import com.test.actions.LoginActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrocoPrazoSteps {

    @Dado("que o pdv esteja na tela de prazos")
    public void que_o_pdv_esteja_na_tela_de_prazos() {
        log.info("Configurando o PDV e realizando login");
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP(Constants.PC_IP_ADDRESS, Constants.PC_PORT);
        ConfigActions.selecionarPDVporTEF("GETNET");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
        LoginActions.realizarLogin("3","1");
    }

    @Quando("selecionado o prazo com percentual definido")
    public void selecionado_o_prazo_com_percentual_definido() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("o campo ira permitir informar um valor de ate X% maior que o exibido pelo prazo")
    public void o_campo_ira_permitir_informar_um_valor_de_ate_x_maior_que_o_exibido_pelo_prazo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("um pdv configurado para conceder descontos de ate determinado valor no cartao")
    public void um_pdv_configurado_para_conceder_descontos_de_ate_determinado_valor_no_cartao() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("selecionado o prazo cartao")
    public void selecionado_o_prazo_cartao() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("o campo ira permitir informar um valor de ate X reais maior que o exibido pelo prazo")
    public void o_campo_ira_permitir_informar_um_valor_de_ate_x_reais_maior_que_o_exibido_pelo_prazo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
