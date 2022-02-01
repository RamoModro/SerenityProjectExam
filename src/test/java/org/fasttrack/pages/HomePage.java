package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(css = ".menu .menu-item-70")
    private WebElementFacade myAccountButton;

    @FindBy(id = "reg_email")
    private WebElementFacade regEmailField;

    @FindBy(id = "reg_password")
    private WebElementFacade regPasswordField;

    @FindBy(css = ".woocommerce-Button[value='Register']")
    private WebElementFacade registerButton;

    @FindBy(id = "username")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade loginPasswordField;

    @FindBy(css = ".woocommerce-Button[name=\"login\"]")
    private WebElementFacade loginButton;

    @FindBy(id="mastheads")
    private WebElementFacade siteHeader;

    @FindBy(className = "search-field")
    private WebElementFacade searchField;

    @FindBy(className = "searchsubmit")
    private WebElementFacade searchButton;



    public void clickMyAccountButton(){
        clickOn(myAccountButton);
    }

    public void setEmailField(String mail) {
        //waitFor(emailField);
        //withTimeoutOf(Duration.ofSeconds(10)).waitFor(emailField);
        typeInto(regEmailField, mail);
    }

    public void setPasswordField(String pass){
        typeInto(regPasswordField, pass);
    }

    public void clickRegisterButton(){
        clickOn(registerButton);
    }

    public void setUsernameField(String username){
        typeInto(usernameField, username);
    }

    public void setLoginPasswordField(String pass){
        typeInto(loginPasswordField, pass);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public boolean isLoggedOut(){
        return !siteHeader.containsText("Hello");
    }

    public void setSearchField(String value){
        typeInto(searchField, value);
    }

    public void clickSearchButton(){
        clickOn(searchButton);
    }

}
