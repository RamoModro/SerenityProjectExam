package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;


public class BasePage extends PageObject {

    @Override
    protected void waitABit(long timeInMilliseconds) {
        super.waitABit(timeInMilliseconds);
    }

    public int getIntFromPrice(String priceNonFormatted) {
        return Integer.parseInt(priceNonFormatted
                .replace("lei", "")
                .replace(".", ""));
    }
}