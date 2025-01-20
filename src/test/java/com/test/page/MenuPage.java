package com.test.page;

import io.appium.java_client.AppiumBy;


public class MenuPage extends BasePage {



    public void acessarProdutos() {
        clicar(AppiumBy.xpath("(//android.view.View[@content-desc=\"Botoes menu\"])[2]"));
    }




}
