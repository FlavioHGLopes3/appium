package com.test.page;

import com.test.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class MasterPageFactory {


    public static <T> T getPage(Class<T> cls) {
        T page;

        try {
            page = cls.getDeclaredConstructor().newInstance();
            PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), page);

        } catch (Exception e) {
            log.error("Error on page instantiation", e);
            throw new RuntimeException(e);
        }

        return page;
        // em qualquer classe actions deve ser utilizada esse metodo para instanciar as pages
    }


}
