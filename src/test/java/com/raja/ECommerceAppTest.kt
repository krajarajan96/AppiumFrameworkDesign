package com.raja

import com.raja.pageObjects.android.FormPage
import org.testng.annotations.Test

class ECommerceAppTest: BaseTest() {

    @Test
    fun fillForm() {
        val formPage = FormPage(driver)
        formPage.setNameField("Raja")
        formPage.setGender("female")
        formPage.setCountry("Argentina")
        formPage.submitForm()
    }
}