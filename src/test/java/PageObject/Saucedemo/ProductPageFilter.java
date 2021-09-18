package PageObject.Saucedemo;

import org.openqa.selenium.By;

public enum ProductPageFilter {
    NAME_A_Z("az"),
    NAME_Z_A("za"),
    PRICE_L_H("lohi"),
    PRICE_H_L("hilo");

    String element;

    public String getElement() {
        return element;
    }

    ProductPageFilter(String element) {
        this.element = element;
    }

}
