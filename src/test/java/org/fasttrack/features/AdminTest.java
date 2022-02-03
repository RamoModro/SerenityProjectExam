package org.fasttrack.features;

import org.fasttrack.utils.Constants;
import org.junit.Test;

public class AdminTest extends BaseTest {

    @Test
    public void checkCreatingPercentageDiscountCouponCode() {
        loginSteps.navigateToAdminHomePage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openCouponsPage();
        adminSteps.createCoupon("percentage25", "Percentage discount", "25");
        adminSteps.openCouponsPage();
        adminSteps.searchItemInAdminCouponsPage("percentage25");
        adminSteps.verifyTextInBodyList("Percentage discount");
        adminSteps.verifyTextInBodyList("25");
        adminSteps.deleteItem();
    }

    @Test
    public void checkCreatingFixedCartDiscountCouponCode() {
        loginSteps.navigateToAdminHomePage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openCouponsPage();
        adminSteps.createCoupon("fixed15", "Fixed cart discount", "15");
        adminSteps.openCouponsPage();
        adminSteps.searchItemInAdminCouponsPage("fixed15");
        adminSteps.verifyTextInBodyList("Fixed cart discount");
        adminSteps.verifyTextInBodyList("15");
        adminSteps.deleteItem();
    }

    @Test
    public void checkCreatingFixedProductDiscountCouponCode() {
        loginSteps.navigateToAdminHomePage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openCouponsPage();
        adminSteps.createCoupon("fixedproduct10", "Fixed product discount", "10");
        adminSteps.openCouponsPage();
        adminSteps.searchItemInAdminCouponsPage("fixedproduct10");
        adminSteps.verifyTextInBodyList("Fixed product discount");
        adminSteps.verifyTextInBodyList("10");
        adminSteps.deleteItem();
    }

}
