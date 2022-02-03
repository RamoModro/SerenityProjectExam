package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/wp-admin/edit.php?post_type=shop_order")

public class AdminOrdersPage extends BasePage{

    @FindBy(id="search-submit")
    private WebElementFacade searchButton;

    @FindBy(id="the-list")
    private WebElementFacade bodyList;


    @FindBy(css=".submitdelete")
    private WebElementFacade deleteLink;

    @FindBy(css="[class*='has-row-actions']")
    private WebElementFacade rowActions;

    public void clickSearchButton(){
        clickOn(searchButton);
    }

    public boolean doesListContain(String text){
        return bodyList.containsText(text);
    }

    public void deleteItem(){
        clickOn(deleteLink);
    }

    public void enableRowActions() {
        clickOn(rowActions);
    }
}
