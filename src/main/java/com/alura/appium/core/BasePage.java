package com.alura.appium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static com.alura.appium.core.DriverFactory.driver;
import static com.alura.appium.core.DriverFactory.getDriver;

public class BasePage {
    public void clicar(By appiumBy) {
        getDriver().findElement(appiumBy).click();
    }


    public void digitar (By appiumBy, String texto  ) {
        getDriver().findElement(appiumBy).sendKeys(texto);
    }

    public String obterTexto(By appiumBy) {
        return getDriver().findElement(appiumBy).getText();
    }

    public void scrollDown(){
        scroll(0.1, 0.9);
    }

    public void scrollUp(){
        scroll(0.9, 0.1);
    }

    public void swipeElement(WebElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        genericSwipe(start_x, y, end_x, y);
    }

    public void genericSwipe(int startX, int startY, int endX, int endY) {
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

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        genericSwipe(x, start_y, x, end_y);
    }

    public boolean isElementEnabled(By appiumBy) {
        WebElement element = driver.findElement(appiumBy);
        return element.isEnabled();
    }


}
