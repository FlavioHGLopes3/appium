package com.test.steps;

import com.test.actions.ConfigActions;
import com.test.actions.LoginActions;
import com.test.actions.MenuPageActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertTrue;

@Slf4j
public class LoginSteps {
    @Dado("que o pdv esteja configurado incorretamente")
    public void que_o_pdv_esteja_configurado_incorretamente() {
        log.info("Realizando a configuração incorreta do PDV");
        assertTrue(LoginActions.toastConfigurePDV("Configure PDV"));  ;
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP("192.168.011.093","8081");
        ConfigActions.selecionarPDVporTEF("SAFRAPAY");
        ConfigActions.pressionarBotaoVoltarTelaLogin();


    }
    @Quando("informo o usuario e senha")
    public void informo_o_usuario_e_senha() {
        log.info("Realizando login");
        LoginActions.realizarLogin("3","1");
    }


    @Então("é exibido um toast de gerenciador tef incorreto")
    public void e_exibido_um_toast_de_gerenciado_tef_incorreto(String mensagemEsperada) {
        log.info("Verificando toast de tef incorreto");
        assertTrue("A mensagem de Configure PDV não foi exibida corretamente",
                LoginActions.toastConfigurePDV("Gerenciador TEF incorreto.\nFavor verifique a configuração."));
    }


    @Dado("que o pdv esteja configurado corretamente")
    public void que_o_pdv_esteja_configurado_corretamente() {
        log.info("Realizando a configuração correta do PDV");
        assertTrue(LoginActions.toastConfigurePDV("Configure PDV"));  ;
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP("192.168.018.172","8081");
        ConfigActions.selecionarPDVporTEF("GETNET");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
    }


    @Então("é exibido o menu inicial")
    public void é_exibido_o_menu_inicial() {
        log.info("Verificando se o PDV está na página principal");
        MenuPageActions.validatePage();


    }

    @Quando("informo usuario e senha incorretos")
    public void informo_usuario_e_senha_incorretos() {
        log.info("Informando usuario e senha incorreto");

        LoginActions.realizarLogin("3","2");

    }

    @Quando("informo usuario e senha correto")
    public void informo_usuario_e_senha_correto() {
        log.info("Informando usuario e senha correto");

        LoginActions.realizarLogin("3","1");
        MenuPageActions.validatePage();
    }

    @Então("é exibido um toast de Login ou Senha Inválido")
    public void e_exibido_um_toast_de_login_senha_invalido() {
        assertTrue("Toast não encontrado",
                LoginActions.toastLoginInvalido("Login/Senha Inválido"));
    }


    @Dado("que o pdv esteja configurado e logado")
    public void que_o_pdv_esteja_configurado_e_logado() {
        log.info("Realizando a configuração correta do PDV");
        assertTrue(LoginActions.toastConfigurePDV("Configure PDV"));  ;
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP("192.168.018.172","8081");
        ConfigActions.selecionarPDVporTEF("GETNET");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
    }
}
