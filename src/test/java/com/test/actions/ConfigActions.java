package com.test.actions;

import com.test.page.BasePage;
import com.test.page.ConfigPage;
import com.test.page.MasterPageFactory;
import io.appium.java_client.AppiumBy;

import static com.test.page.BasePage.clicar;
import static com.test.page.BasePage.digitar;

public class ConfigActions {


    public static ConfigPage configPage(){
        return MasterPageFactory.getPage(ConfigPage.class);
    }

    public static void validatePage() {
        configPage().validatePage();
    }

    public static void configurarIP(String ip, String porta) {

        configPage().pressionarBotaoConfigurarIP();

        // Divide o IP pelos pontos
        String[] ipParts = ip.split("\\.");
        for (int i = 0; i < ipParts.length; i++) {
            digitar(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")"),
                    ipParts[i]
            );
        }

        // Preenche o campo da porta (assumindo que é o 4º campo de EditText)
        digitar(,
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(4)"),
                porta
        );

        configPage().pressionarBotaoConfirmarIP();

    }

    public static void selecionarPDVporTEF(String nomePDV) {
        configPage().pressionarBotaoPDV();
        configPage().selecionarPDV(nomePDV);

        BasePage.scrollUp();
        clicar(AppiumBy
                .xpath
                        ("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[10]/android.widget.Button"));
    }

    public static void pressionarBotaoVoltarTelaLogin() {
        clicar(AppiumBy.accessibilityId("Voltar"));
    }

}


