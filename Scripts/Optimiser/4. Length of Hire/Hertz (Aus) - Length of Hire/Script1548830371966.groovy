import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords

WebUI.openBrowser('')
WebUI.maximizeWindow()
//WebUI.comment('User logs into MF')
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/Home/Login')
WebUI.setText(findTestObject('Global Objects/input_Username'), 'PTHertzrentals')
WebUI.setText(findTestObject('Global Objects/input_Password'), Password)
WebUI.click(findTestObject('Global Objects/button_Login'))

//WebUI.comment('The welcome menu sometimes expands, sometimes not')
//WebUI.click(findTestObject('Global Objects/Page_Car Rental - Portal/span_Welcome_menu-text'))
WebUI.click(findTestObject('Global Objects/span_Optimiser'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/a_Length Of Hire'))
WebUI.switchToFrame(findTestObject('Optimiser/4. Length of Hire/iframe_Length of Hire'),2)

//WebUI.comment('Select Market')
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Market'))
WebUI.selectOptionByValue(findTestObject('Optimiser/4. Length of Hire/select_Market'),Australia, false)
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Market'))

//Select Vehicle Type
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_CarType')) 
WebUI.selectOptionByValue(findTestObject('Optimiser/4. Length of Hire/select_CarType'),'0fe6fdbe-50ed-4b99-91e5-2abf9413f8f8',false)
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_CarType'))

//WebUI.comment('Select Region')
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Region'))
WebUI.selectOptionByValue(findTestObject('Optimiser/4. Length of Hire/select_Region'),'144',false) //Melbourne Airport
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Region'))

//WebUI.comment('Select Season')
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Season'))
WebUI.selectOptionByLabel(findTestObject('Optimiser/4. Length of Hire/select_Season'),'Feb-6 (06/02/19-07/02/19)',false)//'25191',false)//Feb-6 (06/02/19-07/02/19)
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Season'))

//WebUI.comment("Click Search button')
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Button_Search'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Button_Search'))

//WebUI.comment('Enter new data in table and save')
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Data_Table'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Data_Table - ClickCell1'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Data_Table - InsertCell1'),'1')
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Data_Table - ClickCell2'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Data_Table - InsertCell2'),'2')
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Button_Save'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Button_Save'))
SaveText = WebUI.getText(findTestObject('Optimiser/4. Length of Hire/LoH Success Message'))
WebUI.verifyTextPresent("Update successfully",false)
//WebUI.verifyMatch(SaveText,'Update successfully')

//Log User out
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()