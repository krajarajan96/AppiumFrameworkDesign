package com.raja.pageObjects.android

import com.google.common.collect.ImmutableMap
import com.raja.pageObjects.AppiumUtils
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

open class AndroidActions constructor(private val driver: AndroidDriver): AppiumUtils(driver) {

    fun longPressGesture(element: WebElement) {
        (driver as JavascriptExecutor).executeScript(
            "mobile: longClickGesture",
            ImmutableMap.of(
                "elementId", (element as RemoteWebElement).id,
                "duration", 2000
            )
        )
    }

    fun scrollToElement(elementName: String) {
        driver.findElement(AppiumBy.androidUIAutomator("""
            new UiScrollable(new UiSelector()).scrollIntoView(text("$elementName"));
        """.trimIndent()))
    }

    fun scrollToEnd() {
        var canScrollMore = false
        do {
            canScrollMore = (driver as JavascriptExecutor).executeScript(
                "mobile: scrollGesture",
                ImmutableMap.of(
                    "left", 100,
                    "top", 100,
                    "width", 200,
                    "height", 200,
                    "direction", "down",
                    "percent", 10.0
                )
            ) as Boolean
        }
        while (canScrollMore)
    }

    fun scrollToTop() {
        var canScrollMore = false
        do {
            canScrollMore = (driver as JavascriptExecutor).executeScript(
                "mobile: scrollGesture",
                ImmutableMap.of(
                    "left", 100,
                    "top", 100,
                    "width", 200,
                    "height", 200,
                    "direction", "up",
                    "percent", 10.0
                )
            ) as Boolean
        }
        while (canScrollMore)
    }

    fun swipeLeft(element: WebElement, percent: Double = 0.1) {
        (driver as JavascriptExecutor).executeScript(
            "mobile: swipeGesture",
            ImmutableMap.of(
                "elementId", (element as RemoteWebElement).id,
                "direction", "left",
                "percent", percent
            )
        )
    }

    fun swipeRight(element: WebElement, percent: Double = 0.1) {
        (driver as JavascriptExecutor).executeScript(
            "mobile: swipeGesture",
            ImmutableMap.of(
                "elementId", (element as RemoteWebElement).id,
                "direction", "right",
                "percent", percent
            )
        )
    }

    fun drag(source: WebElement, endX: Double, endY: Double) {
        (driver as JavascriptExecutor).executeScript(
            "mobile: dragGesture", ImmutableMap.of(
                "elementId", (source as RemoteWebElement).getId(),
                "endX", endX,
                "endY", endY
            )
        )
    }

    fun startActivity(activity: String) {
        (driver as JavascriptExecutor).executeScript(
            "mobile: startActivity",
            ImmutableMap.of(
                "intent", activity,
            )
        )
    }
}