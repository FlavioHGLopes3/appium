package com.test.actions.produtos;

import com.test.page.BasePage;
import com.test.page.MasterPageFactory;
import com.test.page.produtos.lista_produtos.ListaProdutosPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.test.DriverFactory.getDriver;

public class ListaProdutosActions extends BasePage {

    public static ListaProdutosPage listaProdutosDoGrupoPage(){
        return MasterPageFactory.getPage(ListaProdutosPage.class);
    }

    public static void selecionarProduto (String nomeProduto) {
        BasePage.scrollUp();
        String nomeProdutoUpper = nomeProduto.toUpperCase().trim();
        clicar(AppiumBy.xpath("//android.widget.TextView[@text=\"" + nomeProdutoUpper + "\"]"));
    }

    public static boolean verificarSeCardFoiExibido () {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
            WebElement cardQuantidade = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Adicionar item\"]")
                )
            );
            return cardQuantidade.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }






}
