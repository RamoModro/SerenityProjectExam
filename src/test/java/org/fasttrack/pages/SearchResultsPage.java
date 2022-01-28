package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".collection_combine .inner-img")
    private List<WebElementFacade> listOfProducts;

    @FindBy(className ="orderby" )
    private WebElementFacade dropDown_SortBy;

    @FindBy(css = "div ins")
    private List<WebElementFacade> listOfProductsPrice;

    public boolean isProductInResults(String searchItem) {
        for (WebElementFacade element : listOfProducts) {
            if (!element.getText().contains(searchItem)) {
                return false;
            }
        }
        return true;
    }

    public boolean openProduct(String name){
        waitFor(listOfProducts.get(0));
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(listOfProducts);
        for (WebElementFacade element : listOfProducts){
            if (element.findElement(By.cssSelector("a .attachment-shop_catalog")).getText().equalsIgnoreCase(name)){
                element.findElement(By.cssSelector("a")).click();
                return true;
            }
        }
        return false;
    }

    public void selectDropDownValue(){
        dropDown_SortBy.selectByVisibleText("Sort by price: low to high");
    }

    public boolean isPriceAscending(){
        return getIntFromPrice(listOfProductsPrice.get(0).getText())
                <getIntFromPrice(listOfProductsPrice.get(listOfProductsPrice.size()-1).getText());

    }
}
