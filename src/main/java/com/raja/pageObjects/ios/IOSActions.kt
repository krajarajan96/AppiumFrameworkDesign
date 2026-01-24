package com.raja.pageObjects.ios

import com.raja.pageObjects.AppiumUtils
import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

open class IOSActions constructor(private val driver: IOSDriver): AppiumUtils(driver) {

    fun longPress(element: WebElement, duration: Int = 5) {
        val params = kotlin.collections.HashMap<String, Any>()
        params["element"] = (element as RemoteWebElement).id
        params["duration"] = duration
        driver
            .executeScript("mobile:touchAndHold", params)
    }

    fun scrollTopTo(element: WebElement) {
        val params = kotlin.collections.HashMap<String, Any>()
        params["element"] = (element as RemoteWebElement).id
        params["direction"] = "up"
        driver
            .executeScript("mobile:scroll", params)
    }

    fun scrollBottomTo(element: WebElement) {
        val params = kotlin.collections.HashMap<String, Any>()
//        params["element"] = (element as RemoteWebElement).id
        params["direction"] = "down"
//        params["toVisible"] = true
        driver
            .executeScript("mobile: scroll", params)
    }
}