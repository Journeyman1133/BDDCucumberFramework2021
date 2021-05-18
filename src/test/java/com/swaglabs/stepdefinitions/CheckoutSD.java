package com.swaglabs.stepdefinitions;

import com.sun.tools.javac.comp.Check;
import com.swaglabs.base.ConfigReader;
import com.swaglabs.pages.*;
import com.swaglabs.utils.ElementUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSD {
    @Given("^User is logged in$")
    public void verifyUserIsLoggedIn() {
        LoginPage.enterUserName(ConfigReader.getProperty("username"));
        LoginPage.enterPassword(ConfigReader.getProperty("password"));
        LoginPage.clickLoginBtn();
        String actualTitle = HomePage.verifyTitle();
        Assert.assertEquals("Swag Labs", actualTitle);
        Assert.assertTrue(HomePage.isLogoDisplayed());
    }

    @When("User clicks on item with name {string}")
    public void userClicksOnItemWithName(String itemName) {
        HomePage.clickItem(itemName);
    }

    @And("User clicks on the add to cart button")
    public void userClicksOnTheAddToCartButton() {
        ItemPage.clickAddToCart();
    }

    @And("User clicks on the shopping cart button")
    public void userClicksOnTheShoppingCartButton() {
        ItemPage.clickOnShoppingCart();
    }

    @And("User clicks on the checkout")
    public void userClicksOnTheCheckout() {
        CartPage.clickCheckout();
    }

    @And("User adds the order info as {string}, {string}, {string}")
    public void userAddsTheOrderInfoAs(String firstName, String lastName, String zipCode) {
        CheckoutStepOne.sendOrderInfo(firstName, lastName, zipCode);
    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        CheckoutStepOne.clickContinue();
    }

    @Then("User sees the item matches with the {string}")
    public void userSeesTheItemMatchesWithThe(String itemName) {
        Assert.assertEquals(itemName, CheckoutStepTwo.getItemName());
    }
}

