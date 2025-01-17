package com.test;

import com.alura.appium.core.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    private static AppiumDriverLocalService server;
    private static AppiumDriver driver;

    @BeforeAll
    public static void setUpServer (){
        log.info("Inicializando servidor");

        server = new AppiumServiceBuilder()
                .usingPort(4723)
                .build();

        server.start();
    }

    @AfterAll
    public static void tearDownServer (){
        log.info("Finalizando o servidor");

        if (server!= null) server.stop();
        server = null;

    }

    @Before
    public void setUpDriver(){
        log.info("Inicializando sessao driver");

        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDownDriver(){
        log.info("Finalizando sessao driver");

        DriverFactory.KillDriver();
    }

}

