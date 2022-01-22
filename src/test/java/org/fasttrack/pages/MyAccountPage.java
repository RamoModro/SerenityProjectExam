package org.fasttrack.pages;

import kotlin.random.URandomKt;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;


public class MyAccountPage extends BasePage {

    @FindBy(css = ".woocommerce-MyAccount-content p")
    private WebElementFacade welcomeRegisterText;

    public void checkUserLoggedInText(String userName) {
        welcomeRegisterText.shouldContainOnlyText("Hello" + userName + " (not" + userName + "? Log out)");
    }

    }
