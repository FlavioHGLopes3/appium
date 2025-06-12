package com.test.actions;

import com.test.DriverFactory;
import com.test.page.BasePage;
import com.test.page.MasterPageFactory;
import com.test.page.login.LoginPage;
import com.test.page.menu.MenuPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginActions extends BasePage {

    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void validatePage() {
        loginPage().validatePage();
    }


    public static void acessarAlterarConfiguracoes() {
        clicar(loginPage().getBotaoAlterarConfiguracoes());
    }

    public static void realizarLogin(String usuario, String senha) {
        digitar(loginPage().getCampoUsuario(),usuario);
        digitar(loginPage().getCampoSenha(),senha);
        clicar(loginPage().getBotaoEntrar());
    }



    public static boolean isLoggedIn() {
        try {
            // Obtém a instância do MenuPage usando sua MasterPageFactory
            MenuPage menuPage = MasterPageFactory.getPage(MenuPage.class);

            // Cria um wait explícito
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

            // Verifica se o elemento está visível
            return wait.until(ExpectedConditions.visibilityOf(menuPage.getMenuPageIdentifier())).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }




}
