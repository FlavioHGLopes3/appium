package com.alura.appium.core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class DriverFactory {



    public static AppiumDriver driver;



    public static AppiumDriver getDriver() {
        if(driver == null) {
            createDriver();
        }
        return driver;
    }


    private static void createDriver()  {

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability("platformName", "Android"); //
        configuracoes.setCapability("appium:automationName", "UiAutomator2");
        configuracoes.setCapability("appium:deviceName","emulator-5554"); // emulator-5554 caso utilizar emuladores
        configuracoes.setCapability("appium:deviceName","PBF921CE70531"); // getnet p2
        configuracoes.setCapability("appium:app", "D:\\appium\\src\\main\\resources\\app-play_store-debug.apk"); // base path do apk
        configuracoes.setCapability("appium:autoGrantPermissions", "true"); // inicia o apk com as permissoes de Manifest.permission já autorizadas
//        configuracoes.setCapability("appium:fullReset", "true");
        URI urlConexao = null;
        try {
            urlConexao = new URI("http://127.0.0.1:4723");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            driver = new AppiumDriver(urlConexao.toURL(), configuracoes);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void KillServer() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
