package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage{

    @FindBy(id = "user_login")
    private WebElementFacade loginUserNameField;

    @FindBy(id = "user_pass")
    private WebElementFacade loginPasswordField;

    @FindBy(id = "wp-submit")
    private WebElementFacade loginButton;

    public void setLoginUserNameOrEmailAddressField(String user){
        typeInto(loginUserNameField, user);
    }

    public void setLoginPasswordField(String password) {
        typeInto(loginPasswordField, password);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }
}
