package com.test.actions

import com.test.DriverFactory
import com.test.page.BasePage
import com.test.page.MasterPageFactory
import com.test.page.login.LoginPage
import com.test.page.menu.MenuPage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

object LoginActions2 : BasePage() {
    fun loginPage(): LoginPage? {
        return MasterPageFactory.getPage<LoginPage?>(LoginPage::class.java)
    }

    fun validatePage() {
        loginPage()!!.validatePage()
    }


    fun acessarAlterarConfiguracoes() {
        clicar(loginPage()!!.getBotaoAlterarConfiguracoes())
    }

    fun realizarLogin(usuario: String?, senha: String?) {
        digitar(loginPage()!!.getCampoUsuario(), usuario)
        digitar(loginPage()!!.getCampoSenha(), senha)
        clicar(loginPage()!!.getBotaoEntrar())
    }


    val isLoggedIn: Boolean
        get() {
            try {
                // Obtém a instância do MenuPage usando sua MasterPageFactory
                val menuPage = MasterPageFactory.getPage<MenuPage?>(MenuPage::class.java)

                // Cria um wait explícito
                val wait = WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))

                // Verifica se o elemento está visível
                return wait.until<WebElement?>(ExpectedConditions.visibilityOf(menuPage.getMenuPageIdentifier()))
                    .isDisplayed()
            } catch (e: Exception) {
                return false
            }
        }
}