package com.alura.appium.page;

import com.alura.appium.core.BasePage;
import com.alura.appium.core.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// classe page nao deve ter assert, classe test nao deve ter locators
public class ConfigPage extends BasePage {


    public void pressionarBotaoConfigurarIP() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Configurar IP\"]"));
    }

    public void digitarIP(String ip, String porta) {
        // Divide o IP pelos pontos
        String[] ipParts = ip.split("\\.");
        for (int i = 0; i < ipParts.length; i++) {
            digitar(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")"),
                    ipParts[i]
            );
        }

        // Preenche o campo da porta (assumindo que é o 4º campo de EditText)
        digitar(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(4)"),
                porta
        );
    }

    public void pressionarBotaoConfirmarIP() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Confirmar\"]"));
    }

    public void pressionarBotaoPDV() {
        clicar(AppiumBy.androidUIAutomator("new UiSelector().text(\"PDV\")"));
    }

    public void selecionarPDVporTEF(String nomePDV) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

        String xpath = String.format("//android.widget.TextView[@text=\"PAY ROTINA %s\"]", nomePDV);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(xpath))).click();
    }

    public void pressionarBotaoCarregarConfigpista() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Carregar ConfigPista\"]"));
    }

    public void pressionarBotaoVoltarTelaLogin() {
        clicar(AppiumBy.accessibilityId("Voltar"));
    }



}

