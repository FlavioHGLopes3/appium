package com.test.page.login;

import com.test.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
@Getter
@NoArgsConstructor
public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Entrar\"]")
    private WebElement botaoEntrar;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"00000\"]")
    private WebElement campoUsuario;

    @AndroidFindBy(xpath = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement campoSenha;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Alterar configurações\"]")
    private WebElement botaoAlterarConfiguracoes;

    public void validatePage () {
        validateElementPresence("(//android.widget.ImageView[@content-desc=\"Clean Confirm\"])[2]");
    }


}
