package com.swaglabs.pages;

import com.swaglabs.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.swaglabs.base.BasePage.driver;

public class CheckoutStepOne {

    @FindBy(id = "firstName")
    private static WebElement firstName;

    @FindBy(id = "last-name")
    private static WebElement lastName;

    @FindBy(id = "postal-code")
    private static WebElement zipCode;

    @FindBy(xpath = "//button[@id='checkout']")
    private static WebElement continueBtn;

    public CheckoutStepOne() {
        PageFactory.initElements(driver, this);
    }

    public static void sendOrderInfo(String fName, String lName, String zCode) {
        ElementUtil.doSendText(firstName, fName);
        ElementUtil.doSendText(lastName, lName);
        ElementUtil.doSendText(zipCode, zCode);
    }

    public static void clickContinue() {
        ElementUtil.doClick(continueBtn);
    }
}
