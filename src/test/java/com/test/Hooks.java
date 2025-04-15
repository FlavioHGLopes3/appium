package com.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class Hooks {

    private static AppiumDriverLocalService server;

    @BeforeAll
    public static void setUpServer (){
        log.info("Inicializando servidor Appium");

        server = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(60))
                .build();

        server.start();

        if (!server.isRunning()) {
            throw new RuntimeException("Falha ao iniciar servidor Appium");


        }
    }

    @AfterAll
    public static void tearDownServer() {
        log.info("Finalizando servidor Appium");

        if (server != null) {
            server.stop();
            log.info("Servidor Appium finalizado");
        }
    }

    @Before
    public void setUpDriver(){
        log.info("Inicializando sessao driver");

        AppiumDriver driver = DriverFactory.getDriver();
    }

    @After
    public void tearDownDriver(){
        log.info("Finalizando sessao driver");

        DriverFactory.killDriver();
    }

}

