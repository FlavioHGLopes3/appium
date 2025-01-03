package com.alura.appium.page;

import com.alura.appium.core.BasePage;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BasePage {



    public void acessarAlterarConfiguracoes() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Alterar configurações\"]"));
    }

    public void preencherCampoUsuario(String usuario) {
        digitar(AppiumBy.xpath("//android.widget.EditText[@text=\"00000\"]"), usuario);
    }

    public void preencherCampoSenha(String senha) {
        digitar(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"), senha);
    }


    public void confirmarLogin() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
    }

    public boolean isBotaoLoginHabilitado() {
        return isElementEnabled(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
    }


}
