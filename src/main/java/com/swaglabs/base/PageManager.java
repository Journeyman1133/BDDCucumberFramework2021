package com.swaglabs.base;

import com.swaglabs.pages.*;

public class PageManager {
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static CartPage cartPage;
    public static CheckoutStepOne checkoutStepOne;
    public static CheckoutStepTwo checkoutStepTwo;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutStepOne = new CheckoutStepOne();
        checkoutStepTwo = new CheckoutStepTwo();
    }
}
