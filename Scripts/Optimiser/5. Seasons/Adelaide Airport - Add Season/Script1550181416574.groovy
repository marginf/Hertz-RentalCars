import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang.time.StopWatch
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.common.WebUiCommonHelper

Date today = new Date()
String todaysDate = today.format("yyyyMMdd")

WebUI.openBrowser('')
WebUI.maximizeWindow()
//'User logs into MF'
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/Home/Login')
WebUI.setText(findTestObject('Global Objects/input_Username'), 'PTHertzrentals')
WebUI.setText(findTestObject('Global Objects/input_Password'), Password)
WebUI.click(findTestObject('Global Objects/button_Login'))

//'The welcome menu sometimes expands, sometimes not'
//WebUI.click(findTestObject('Global Objects/Page_Car Rental - Portal/span_Welcome_menu-text'))
WebUI.click(findTestObject('Global Objects/span_Optimiser'))
WebUI.delay(1)
WebUI.click(findTestObject('Optimiser/5. Seasons/a_Seasons'))
WebUI.switchToFrame(findTestObject('Optimiser/5. Seasons/iframe_Regional Season_PageCon'),1)

// Select Market
WebUI.click(findTestObject('Optimiser/5. Seasons/Select_Market'))
WebUI.selectOptionByValue(findTestObject('Optimiser/5. Seasons/Select_Market'),Australia,false)
WebUI.click(findTestObject('Optimiser/5. Seasons/Select_Market'))

// Select Region
WebUI.click(findTestObject('Optimiser/5. Seasons/Select_Region'))
WebUI.selectOptionByIndex(findTestObject('Optimiser/5. Seasons/Select_Region'),0)
WebUI.click(findTestObject('Optimiser/5. Seasons/Select_Region'))

//WebUI.comment("Click Add button')
WebUI.focus(findTestObject('Optimiser/5. Seasons/button_Season-Add'))
WebUI.click(findTestObject('Optimiser/5. Seasons/button_Season-Add'))
WebUI.delay(1)
WebUI.setText(findTestObject('Optimiser/5. Seasons/Season Add - Modal/input_Name_seasonName'), 'Robot Season1')
WebUI.delay(1)
WebUI.click(findTestObject('Optimiser/5. Seasons/Season Add - Modal/input_Date Range_daterange'))
WebUI.delay(1)
WebUI.click(findTestObject('Optimiser/5. Seasons/Season Add - Modal/td_20'))
WebUI.delay(1)
WebUI.click(findTestObject('Optimiser/5. Seasons/Season Add - Modal/td_26'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Season Add - Modal/button_Apply'))
WebUI.focus(findTestObject('Optimiser/5. Seasons/Season Add - Modal/button_Save'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Season Add - Modal/button_Save'))
'Update confirmation message'
'Get text alert on the alert when it\'s shown'
//alertText = WebUI.getAlertText()
'Verify text alert is correct or not'
WebUI.verifyTextPresent('Updating season and Setting default LOH and Rule!',false) 

WebUI.focus(findTestObject('Optimiser/5. Seasons/Season Add - Modal/Modal_Close'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Season Add - Modal/Modal_Close'))

//Return to Price View Page iframe
WebUI.switchToFrame(findTestObject('Optimiser/5. Seasons/iframe_Regional Season_PageCon'),1)

//Log User out
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()