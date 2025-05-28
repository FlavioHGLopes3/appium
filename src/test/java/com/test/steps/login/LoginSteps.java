package com.test.steps.login;

import com.test.actions.ConfigActions;
import com.test.actions.LoginActions;
import com.test.actions.MenuPageActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;

import static com.test.Constants.PC_IP_ADDRESS;
import static com.test.Constants.PC_PORT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Slf4j
public class LoginSteps {
    @Dado("que o pdv esteja configurado incorretamente")
    public void que_o_pdv_esteja_configurado_incorretamente() {
        log.info("Realizando a configuração incorreta do PDV");
        assertTrue(LoginActions.toastGetMessage("Configure PDV"));  ;
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP(PC_IP_ADDRESS,PC_PORT);
        ConfigActions.selecionarPDVporTEF("CIELO");
        ConfigActions.pressionarBotaoVoltarTelaLogin();


    }
    @Quando("informo o usuario e senha")
    public void informo_o_usuario_e_senha() {
        log.info("Realizando login");
        LoginActions.realizarLogin("3","1");
    }


    @Então("é exibido um toast de gerenciador tef incorreto")
    public void e_exibido_um_toast_de_gerenciado_tef_incorreto() {
        log.info("Verificando toast de tef incorreto");
        assertTrue("A mensagem de Configure PDV não foi exibida corretamente",
                LoginActions
                        .toastGetMessage("Gerenciador TEF incorreto.\nFavor verifique a configuração."));
        assertFalse("O login foi bem-sucedido com gerenciador TEF incorreto",
                LoginActions.isLoggedIn());
    }


    @Dado("que o pdv esteja configurado corretamente")
    public void que_o_pdv_esteja_configurado_corretamente() {
        log.info("Realizando a configuração correta do PDV");
        assertTrue(LoginActions.toastGetMessage("Configure PDV"));  ;
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP(PC_IP_ADDRESS,PC_PORT);
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
                LoginActions.toastGetMessage("Login/Senha Inválido."));
    }


    @Dado("que o pdv esteja configurado e logado")
    public void que_o_pdv_esteja_configurado_e_logado() {
        log.info("Realizando a configuração correta do PDV");
        assertTrue(LoginActions.toastGetMessage("Configure PDV"));
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP(PC_IP_ADDRESS,PC_PORT);
        ConfigActions.selecionarPDVporTEF("GETNET");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
        LoginActions.realizarLogin("3","1");
    }

    @Dado("que o pdv não esteja configurado com a chave de transferência bancária")
    public void que_o_pdv_não_esteja_configurado_com_a_chave_de_transferencia_bancaria() {
        assertTrue(LoginActions.toastGetMessage("Configure PDV"));
        LoginActions.validatePage();
        LoginActions.acessarAlterarConfiguracoes();
        ConfigActions.validatePage();
        ConfigActions.configurarIP(PC_IP_ADDRESS,PC_PORT);
        ConfigActions.selecionarPDVporTEF("SAFRAPAY");
        ConfigActions.pressionarBotaoVoltarTelaLogin();
    }


    @Quando("informo usuario e senha corretos e realizo o login")
    public void informo_usuario_e_senha_corretos_e_realizo_o_login() {
        LoginActions.realizarLogin("3", "1");
    }

    @Então("é exibido um toast de verificar o prazo padrão")
    public void é_exibido_um_toast_de_verificar_o_prazo_padrão() {
        assertTrue("Toast de prazo padrão não foi exibido",
                LoginActions.toastGetMessage("Verifique o prazo padrão para o tipo transferência no cadastro do PDV"));

    }



}
