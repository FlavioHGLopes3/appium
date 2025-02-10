package com.test.actions;

import com.test.page.BasePage;
import com.test.page.LoginPage;
import com.test.page.MasterPageFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.test.DriverFactory.getDriver;

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
        digitar(AppiumBy.xpath("//android.widget.EditText[@text=\"00000\"]"), usuario);
        digitar(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"), senha);
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
    }

    public static boolean toastConfigurePDV(String mensagemEsperada) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
            WebElement toast = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[@text=\"" + mensagemEsperada + "\"]"))
            );

            String mensagemToast = toast.getText();

            return mensagemToast.contains(mensagemEsperada);

        } catch (Exception e) {
            System.out.println("Toast não encontrado: " + e.getMessage());
            return false;
        }

    }

    public static boolean toastLoginInvalido(String mensagemEsperada) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
            WebElement toast = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[@text=\"" + mensagemEsperada + "\"]"))
            );

            String mensagemToast = toast.getText();

            return mensagemToast.contains(mensagemEsperada);

        } catch (Exception e) {
            System.out.println("Toast não encontrado: " + e.getMessage());
            return false;
        }

    }


}
