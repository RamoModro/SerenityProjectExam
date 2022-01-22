package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(css = ".login-woocommerce a")
    private WebElementFacade loginButton;

    @FindBy(id = "reg_email")
    private WebElementFacade emailField;

    @FindBy(id = "reg_password")
    private WebElementFacade passwordField;

    @FindBy(css = ".woocommerce-Button[value='Register']")
    private WebElementFacade registerButton;

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void setEmailField(String mail) {
        //waitFor(emailField);
        //withTimeoutOf(Duration.ofSeconds(10)).waitFor(emailField);
        String email = RandomStringUtils.randomAlphanumeric(15)+"@email.com";
        typeInto(emailField, email);
    }

    public void setPasswordField(String pass){
        typeInto(passwordField, pass);
    }

    public void clickRegisterButton(){
        clickOn(registerButton);
    }
}
