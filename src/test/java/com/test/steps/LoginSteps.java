package com.test.steps;

import com.test.actions.ConfigActions;
import com.test.actions.LoginActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertTrue;

@Slf4j
public class LoginSteps {
    @Dado("que o pdv esteja configurado incorretamente")
    public void que_o_pdv_esteja_configurado_incorretamente() {

        log.info("Realizando a configuração do PDV");
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP("192.168.018.172","8081");
        ConfigActions.selecionarPDVporTEF("SAFRAPAY");
        ConfigActions.pressionarBotaoVoltarTelaLogin();


    }
    @Quando("informo o usuario e senha")
    public void informo_o_usuario_e_senha() {

        LoginActions.realizarLogin("3","1");
    }


//    @Então("é exibido um toast de {string}>")
//    public void e_exibido_um_toast_de_gerenciador_tef_incorreto(String mensagemEsperada) {
//
//    }


    @Então("é exibido um toast de {string}")
    public void e_exibido_um_toast_de_gerenciado_tef_incorreto(String mensagemEsperada) {
        assertTrue("A mensagem de Configure PDV não foi exibida corretamente", LoginActions.toastContainsMessage(mensagemEsperada));
    }

}
