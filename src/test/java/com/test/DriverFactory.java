package com.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class DriverFactory {

    private static final String APK_PATH = "D:\\appium\\src\\test\\resources\\apks\\app-play_store-debug.apk";

    private static final String APK_GERAL_PATH = "C:\\Appium\\appium\\src\\test\\resources\\apks\\app-geral-debug.apk";

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    public static AppiumDriver driver;


    public static AppiumDriver getDriver() {
        if(driver == null) {
            createDriver();
        }
        return driver;
    }


    private static void createDriver()  {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "android"); //
        caps.setCapability("appium:automationName", "uiautomator2");
//        caps.setCapability("appium:deviceName","emulator-5554"); // emulator-5554 caso utilizar emuladores
        caps.setCapability("appium:deviceName","PBF921CE70531"); // getnet p2
//        caps.setCapability("appium:deviceName","9a3761b6");
        caps.setCapability("appium:app", APK_GERAL_PATH ); // base path do apk
        caps.setCapability("appium:autoGrantPermissions", "true"); // inicia o apk com as permissoes de Manifest.permission já autorizadas

        try {
            log.info("Caminho do APK: " + APK_GERAL_PATH);

            driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), caps);
            log.info("Sessão criada com sucesso");

        } catch (MalformedURLException e) {
            log.error("URL do Appium inválida: " + APPIUM_SERVER_URL, e);
            throw new RuntimeException("Falha ao criar driver", e);
        } catch (Exception e) {
            log.error("Erro ao iniciar sessão do Appium", e);
            throw new RuntimeException("Falha ao iniciar sessão", e);
        }

        driver.manage().timeouts().implicitlyWait(Constants.TOAST_TIMEOUT);

    }

    public static void killDriver() {
        if (driver != null) {
            try {
                driver.quit();
                log.info("Driver finalizado com sucesso");
            } catch (Exception e) {
                log.error("Erro ao finalizar driver", e);
            } finally {
                driver = null;
            }
        }
    }
}
