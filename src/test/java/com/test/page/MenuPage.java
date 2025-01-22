package com.test.page;

import io.appium.java_client.AppiumBy;


public class MenuPage extends BasePage {

    public void validatePage () {
        validateElementPresence("//android.widget.TextView[@text=\"WebPostoPay\"]");
    }


    public void acessarProdutos() {
        clicar(AppiumBy.xpath("(//android.view.View[@content-desc=\"Botoes menu\"])[2]"));
    }




}
