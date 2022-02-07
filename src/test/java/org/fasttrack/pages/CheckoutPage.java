package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage extends BasePage{

    @FindBy(css = ".post-title")
    private WebElementFacade pageTitle;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css = "li[class$=order] strong")
    private WebElementFacade orderNumberElement;

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameField;

    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameField;

    @FindBy(id = "select2-billing_country-container")
    private WebElementFacade dropDown_Country;

    @FindBy(css = "#billing_address_1[placeholder~=\"street\"]")
    private WebElementFacade streetField;

    @FindBy(css = "#billing_city[name]")
    private WebElementFacade cityField;

    @FindBy(css = "#billing_postcode[name]")
    private WebElementFacade postcodeField;

    @FindBy(css = "#billing_phone[name]")
    private WebElementFacade phoneField;


    public boolean isUserInCheckoutPage() {
        return pageTitle.containsText("CHECKOUT");
    }

    public void clickProceedOrderButton(){
        clickOn(placeOrderButton);
    }

    String orderNumber;
    public String getOrderNumber(){
        orderNumber = orderNumberElement.getText();
        return orderNumber;
    }

    public boolean isUserInOrderConfirmationPage() {
        return pageTitle.containsText("ORDER RECEIVED");
    }

    public void setFirstNameField(String firstName){
        typeInto(firstNameField, firstName);
    }

    public void setLastNameField(String lastName){
        typeInto(lastNameField, lastName);
    }

    public void setStreetName(String address){
    typeInto(streetField, address );
    }

    public void setCityField(String name){
        typeInto(cityField, name);
    }

    public void setPostcode(String value) {
        typeInto(postcodeField, value);
    }

    public void setPhoneField(String number){
        typeInto(phoneField, number);
    }
}
