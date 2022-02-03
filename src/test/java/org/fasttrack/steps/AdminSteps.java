package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class AdminSteps extends BaseSteps{

    @Steps
    CheckoutSteps checkoutSteps;

    @Step
    public void openUsersPage() {
        adminUsersPage.open();
    }

    @Step
    public void openCouponsPage() {
        adminCouponsPage.open();
    }

    @Step
    public void verifyOrderNumber() {
        String orderNumber = checkoutSteps.getOrderNumberValue();
        System.out.println("verify order number - last step" + orderNumber);
        Assert.assertTrue("The order number was not found in the Orders List", adminOrdersPage.doesListContain(orderNumber));

    }

    @Step
    public void verifyTextInBodyList(String text) {
        Assert.assertTrue("The text was not found in the body list", homePageAdmin.doesListContain(text));
    }

    @Step
    public void searchItemInAdminUsersPage(String searchItem) {
        adminUsersPage.setSearchField(searchItem);
        homePageAdmin.clickSearchButton();
    }

    @Step
    public void deleteItem() {
        homePageAdmin.enableRowActions();
        homePageAdmin.deleteItem();
    }

    @Step
    public void confirmDeletion() {
        adminUsersPage.confirmDeletion();
    }

    @Step
    public void createCoupon(String couponTitle, String discountType, String couponAmount) {
        adminCouponsPage.clickAddCoupon();
        adminCouponsPage.setCouponTitle(couponTitle);
        adminCouponsPage.selectDiscountType(discountType);
        adminCouponsPage.setCouponAmount(couponAmount);
        adminCouponsPage.clickPublishButton();
    }

    @Step
    public void searchItemInAdminCouponsPage(String searchItem) {
        adminCouponsPage.setSearchField(searchItem);
        homePageAdmin.clickSearchButton();
    }

    @Step
    public void searchUserInAdminUsersPage(String username){
        adminUsersPage.setSearchField(username);
        homePageAdmin.clickSearchButton();
    }
}
