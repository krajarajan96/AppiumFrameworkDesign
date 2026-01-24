package com.raja.pageObjects.android

import com.raja.pageObjects.AppiumUtils
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class ECommerceAppTest: BaseTest() {

    private lateinit var formPage: FormPage
    @BeforeClass
    fun setup() {
        formPage = FormPage(driver)
    }

    @Test
    fun fillForm() {
        formPage.setNameField("Raja")
        formPage.setGender("female")
        formPage.setCountry("Argentina")
        formPage.submitForm()
    }


    @Test(dataProvider = "getData")
    fun fillFormFromDataProvider(name: String, gender: String, country: String) {
        val formPage = FormPage(driver)
        formPage.setNameField(name)
        formPage.setGender(gender)
        formPage.setCountry(country)
        formPage.submitForm()
    }

//    @Test(dataProvider = "getDataAsHM")
//    fun fillFormFromHashMap(data: HashMap<String, String>) {
//        val formPage = FormPage(driver)
//        formPage.setNameField(data["name"]!!)
//        formPage.setGender(data["gender"]!!)
//        formPage.setCountry(data["country"]!!)
//        formPage.submitForm()
//    }

    @DataProvider
    fun getData(): List<List<Any>> {
        return listOf(
            listOf("Lakshya", "female", "Argentina"),
            listOf("Raja", "male", "Argentina"),
        )
    }

    @DataProvider
    fun getDataAsHM(): List<HashMap<String, String>> {
        val data =  formPage.getJsonData(
            System.getProperty("user.dir") +
                    "src/test/resources/test_data.json"
        )
        return listOf(
            data[0],
            data[1]
        )
    }
}