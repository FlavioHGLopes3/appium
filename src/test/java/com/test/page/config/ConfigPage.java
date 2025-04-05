package com.test.page.config;

import com.test.DriverFactory;
import com.test.page.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@NoArgsConstructor
public class ConfigPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.widget.Button")
    private WebElement botaoConfigurarIP;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[2]/android.widget.Button")
    private WebElement botaoPDV;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.widget.Button")
    private WebElement botaoCarregarConfigPista;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[4]/android.widget.Button")
    private WebElement botaoLimparConfiguracoes;

    public void validatePage () {
        validateElementPresence("//android.widget.TextView[@text=\"Configurações\"]");
    }



    public void pressionarBotaoConfigurarIP() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Configurar IP\"]"));
    }


    public void pressionarBotaoConfirmarIP() {
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Confirmar\"]"));
    }

    public void pressionarBotaoPDV() {
        clicar(AppiumBy.androidUIAutomator("new UiSelector().text(\"PDV\")"));
    }

    public void selecionarPDV(String nomePDV) {
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

