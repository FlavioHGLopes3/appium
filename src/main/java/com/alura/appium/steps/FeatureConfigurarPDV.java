package com.alura.appium.steps;


import com.alura.appium.core.BaseTest;
import com.alura.appium.core.DriverFactory;
import com.alura.appium.page.ConfigPage;
import com.alura.appium.page.LoginPage;
import com.alura.appium.page.MenuPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FeatureConfigurarPDV extends BaseTest {

    private AppiumDriver driver;


    private final LoginPage login = new LoginPage();
    private final ConfigPage config = new ConfigPage();
    private final MenuPage menu = new MenuPage();




    @Before // Incializa a sessao appium antes de rodar os testes
    public void inicializarAppium() {
        driver = DriverFactory.getDriver();
    }





//    @Test
//    public void erro_ao_conectar_backend() {
//
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement btAlterarConfigs = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().text(\"Alterar configurações\")")
//                )
//        );
//        btAlterarConfigs.click();
//
//
//        WebElement btConfigurarIP = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)")
//                )
//        );
//        btConfigurarIP.click();
//
//        WebElement primeiroQuadradoIP = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")
//                )
//        );
//
//        primeiroQuadradoIP.sendKeys("192");
//
//        WebElement segundaQuadradoIP = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")
//                )
//        );
//        segundaQuadradoIP.sendKeys("168");
//
//        WebElement terceiroQuadrado = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)")
//                )
//        );
//        terceiroQuadrado.sendKeys("018");
//
//        WebElement quartoQuadrado = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)")
//                )
//        );
//        quartoQuadrado.sendKeys("172");
//
//        WebElement campoPorta = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(4)")
//                )
//        );
//        campoPorta.sendKeys("8081");
//
//        WebElement btConfirmarIP = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)")
//                )
//        );
//        btConfirmarIP.click();
//
//        WebElement btConfigPDV = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)")
//                )
//        );
//        btConfigPDV.click();
//
//        WebElement avisoErroConectar = wait.until(
//                ExpectedConditions.presenceOfElementLocated(
//                        AppiumBy.xpath("\t\n" + "//android.widget.Toast[@text=\"Erro ao conectar\"]")
//                )
//        );
//
//        Assert.assertEquals("Erro ao conectar", avisoErroConectar.getText());
//    }




    @Test
    public void configurarConfigPistaELogar()  {

        login.preencherCampoUsuario("3");
        login.preencherCampoSenha("1");
        Assert.assertFalse("O botão de login deveria estar habilitado.", login.isBotaoLoginHabilitado()); // caso o botão esteja habilitado, irá retornar true, com o assertFalse ele vai dar erro.

        login.acessarAlterarConfiguracoes();
        config.pressionarBotaoConfigurarIP();
        config.digitarIP("192.168.011.093", "8081");
        config.pressionarBotaoConfirmarIP();
        config.pressionarBotaoPDV();
        config.selecionarPDVporTEF("GETNET");
        menu.scrollUp();
        config.pressionarBotaoConfirmarIP();
        config.pressionarBotaoCarregarConfigpista();
        config.pressionarBotaoVoltarTelaLogin();
        login.preencherCampoUsuario("3");
        login.preencherCampoSenha("1");
        login.confirmarLogin();



    }

    @Test
    public void retornarTelaDeLoginAposFinalizarVendaDeProduto () {

        login.acessarAlterarConfiguracoes();
        config.pressionarBotaoConfigurarIP();
        config.digitarIP("192.168.010.243", "8081");
        config.pressionarBotaoConfirmarIP();
        config.pressionarBotaoPDV();
        config.selecionarPDVporTEF("GETNET");
        menu.scrollUp();
        config.pressionarBotaoConfirmarIP();
        config.pressionarBotaoCarregarConfigpista();
        config.pressionarBotaoVoltarTelaLogin();
        login.preencherCampoUsuario("3");
        login.preencherCampoSenha("1");
        login.confirmarLogin();
        menu.acessarProdutos();
        menu.scrollUp();

    }





}


