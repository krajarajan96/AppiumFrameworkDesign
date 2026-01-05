package com.raja.pageObjects.ios

import org.testng.annotations.Test

class ViewsTest: BaseTest() {

    @Test
    fun selectAlertViews() {
        val homePage = HomePage(driver)
        homePage.selectAlertViews()
    }
}