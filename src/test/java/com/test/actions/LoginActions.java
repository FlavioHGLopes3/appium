package com.test.actions;

import com.test.page.BasePage;
import com.test.page.LoginPage;
import com.test.page.MasterPageFactory;
import io.appium.java_client.AppiumBy;

public class LoginActions extends BasePage {

    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void validatePage() {
        loginPage().validatePage();
    }


    public static void acessarAlterarConfiguracoes() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Alterar configurações\"]"));
    }

    public static void realizarLogin(String usuario, String senha) {
        digitar(AppiumBy.xpath("//android.widget.EditText[@text=\"00000\"]"), usuario);
        digitar(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"), senha);
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
    }

    public static boolean verificarConfigurePDV() {
        return toastGetMessage("Configure PDV");
    }

    public static boolean verificarToastTEFInvalidoAoLogar() {
        return toastGetMessage("TEF INVALIDO");
    }

}
