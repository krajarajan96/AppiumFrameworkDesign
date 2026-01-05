package com.raja.pageObjects.ios

import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

class HomePage constructor(private val driver: IOSDriver): IOSActions(driver) {

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private lateinit var alertViewsField: WebElement

    fun selectAlertViews() {
        alertViewsField.click()
    }
}