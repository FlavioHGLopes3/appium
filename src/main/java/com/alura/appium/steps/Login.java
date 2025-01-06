package com.alura.appium.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Login {
    @Given("que eu configure o PDV")
    public void que_eu_configure_o_pdv() {

        log.info("Configurando pdv");

    }

    @Given("acesse a tela de login")
    public void acesse_a_tela_de_login() {

        log.info("acessar tela de login");
    }

    @When("preencho o campo de {string} e {string}")
    public void preencho_o_campo_de_e(String usuario, String senha) {

        log.info("preenchendo os campos");

    }

    @Then("é exibido a tela de menu")
    public void é_exibido_a_tela_de_menu() {

        log.info("tela de menu");

    }



}
