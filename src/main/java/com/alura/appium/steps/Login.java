package com.alura.appium.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Login {
    @Dado("que eu configure o PDV")
    public void que_eu_configure_o_pdv() {

        log.info("Configurando pdv");

    }

    @Dado("acesse a tela de login")
    public void acesse_a_tela_de_login() {

        log.info("acessar tela de login");
    }

    @Quando("preencho o campo de <usuario> e <senha>")
    public void preencho_o_campo_de_e(String usuario, String senha) {

        log.info("preenchendo os campos");

    }

    @Então("é exibido a tela de menu")
    public void é_exibido_a_tela_de_menu() {

        log.info("tela de menu");

    }



}
