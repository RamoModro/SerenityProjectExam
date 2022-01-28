package org.fasttrack.pages;

import kotlin.random.URandomKt;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;


public class MyAccountPage extends BasePage {

    @FindBy(css = ".woocommerce-MyAccount-content p")
    private WebElementFacade helloText;

    @FindBy(css = ".woocommerce-MyAccount-content a")
    private WebElementFacade logOutLink;

    public void checkUserLoggedIn(String userName) {
        Assert.assertTrue("Hello " + userName + "(not " + userName + "? Log out)", true);
    }

    public void clickLogOut(){
        clickOn(logOutLink);
    }

    }

