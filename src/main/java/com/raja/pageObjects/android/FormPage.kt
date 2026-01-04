package com.raja.pageObjects.android

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class FormPage constructor(private val driver: AndroidDriver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    @AndroidBy(id = "com.androidsample.generalstore:id/nameField")
    lateinit var nameField: WebElement

    @AndroidBy(id = "com.androidsample.generalstore:id/radioFemale")
    lateinit var genderField: WebElement

    
}