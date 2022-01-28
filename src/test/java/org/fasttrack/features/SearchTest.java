package org.fasttrack.features;

import org.junit.Test;

public class SearchTest extends BaseTest{

    @Test
    public void checkSearchResultContainsTheSearchedText(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Shirt");
        searchSteps.checkSearchResultContainsTheSearchedText("Shirt");
    }

    @Test
    public void searchByPriceTest(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("product");
        searchSteps.sortProductByPrice();
    }
}
