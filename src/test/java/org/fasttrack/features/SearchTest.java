package org.fasttrack.features;

import org.junit.Test;

public class SearchTest extends BaseTest{

    @Test
    public void checkSearchResultContainsTheSearchedText(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("T-Shirt");
        searchSteps.checkSearchResultContainsTheSearchedText("T-Shirt");
    }

    @Test
    public void searchByPriceTest(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("product");
        searchSteps.sortProductByPrice();
    }
}
