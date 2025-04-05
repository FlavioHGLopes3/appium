package com.test.page;

import com.test.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static com.test.DriverFactory.driver;
import static com.test.DriverFactory.getDriver;

public class BasePage {


    public static void clicar(By appiumBy) {
        getDriver().findElement(appiumBy).click();
    }

    public static void clicar(WebElement element) { // pode utilizar os elementos mapeados diretamente na page sem precisar informar o xpath
        element.click();
    }


    public static void digitar (By appiumBy, String texto  ) {
        getDriver().findElement(appiumBy).sendKeys(texto);
    }

    public String obterTexto(By appiumBy) {
        return getDriver().findElement(appiumBy).getText();
    }

    public static void scrollDown(){
        scroll(0.1, 0.9);
    }

    public static void scrollUp(){
        scroll(0.9, 0.1);
    }

    public static void elementPresence(By appiumBy){
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(appiumBy));
    }

    public void swipeElement(WebElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        genericSwipe(start_x, y, end_x, y);
    }

    public static void genericSwipe(int startX, int startY, int endX, int endY) {
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
                        startX, startY))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(FINGER, Duration.ofMillis(500)))
                .addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
                        endX, endY))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(drag));
    }

    public static void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        genericSwipe(x, start_y, x, end_y);
    }

    public boolean isElementEnabled(By appiumBy) { // verifica se o elemento está presente na tela
        WebElement element = driver.findElement(appiumBy);
        return element.isEnabled();
    }

    public void validateElementPresence(String xpath){

        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(xpath)));

    }


    public static boolean toastGetMessage(String mensagemEsperada) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            WebElement toast = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[1]"))
            );

            String mensagemToast = toast.getText();

            return mensagemToast.equals(mensagemEsperada);

        } catch (Exception e) {
            System.out.println("Toast não encontrado: " + e.getMessage());
            return false;
        }

    }

    public static boolean toastContainsMessage(String mensagemEsperada) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
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
