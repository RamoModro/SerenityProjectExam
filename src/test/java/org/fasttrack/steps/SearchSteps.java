package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{


    @Step
    public void executeSearch(String keyword){
    homePage.setSearchField(keyword);
    homePage.clickSearchButton();
    }

    @Step
    public void checkSearchResultContainsTheSearchedText(String Item) {
        Assert.assertTrue("Result doesn't contain the searched item", searchResultsPage.isProductInResults(Item));
    }

    @Step
    public void sortProductByPrice(){
        searchResultsPage.selectDropDownValue();
        Assert.assertTrue(searchResultsPage.isPriceAscending());
    }

    @Step
    public void findAndOpenProduct(String productName){
        Assert.assertTrue(searchResultsPage.openProduct(productName));
    }

    @Step
    public void searchAndSelectProduct(String productName){
        executeSearch(productName);
        findAndOpenProduct(productName);
    }
}
