package com.raja.pageObjects

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import io.appium.java_client.AppiumDriver
import org.apache.commons.io.FileUtils
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import java.time.Duration

open class AppiumUtils constructor(private val driver: AppiumDriver) {

    fun getFormattedAmount(price: String): Double {
        return price.substring(1).toDouble()
    }

    fun waitForElement(element: WebElement) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(2))
        wait.until(
            ExpectedConditions.attributeContains(
                element,
                "text",
                "Cart"
            )
        )
    }

    fun getJsonData(filePath: String): List<HashMap<String, String>> {
        val fileContent = FileUtils
            .readFileToString(File(filePath))
        val mapper = ObjectMapper()
        val ref = object : TypeReference<List<HashMap<String, String>>>() {

        }
        return mapper.readValue(fileContent,  ref)
    }
}