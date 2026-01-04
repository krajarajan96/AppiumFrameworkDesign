package com.raja.pageObjects.android

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class FormPage constructor(private val driver: AndroidDriver): AndroidActions(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    @AndroidBy(id = "com.androidsample.generalstore:id/nameField")
    lateinit var nameField: WebElement

    @AndroidBy(id = "com.androidsample.generalstore:id/radioFemale")
    lateinit var femaleField: WebElement

    @AndroidBy(id = "com.androidsample.generalstore:id/radioMale")
    lateinit var maleField: WebElement

    @AndroidBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    lateinit var countrySelector: WebElement

    @AndroidBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    lateinit var submitButton: WebElement

    fun setNameField(name: String) {
        nameField.sendKeys(name)
        driver.hideKeyboard()
    }

    fun setGender(gender: String) {
        if (gender.contains("female")) {
            femaleField.click()
        }
        else {
            maleField.click()
        }
    }

    fun setCountry(name: String) {
        countrySelector.click()
        scrollToElement(name)
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"$name\"]"))
            .click()
    }

    fun submitForm() {
        submitButton.click()
    }
}