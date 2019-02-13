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
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang.time.StopWatch

WebUI.openBrowser('')
WebUI.maximizeWindow()
//WebUI.comment('User logs into MF')
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/Home/Login')
WebUI.setText(findTestObject('Global Objects/input_Username'), 'PTThriftyAU')
WebUI.setText(findTestObject('Global Objects/input_Password'), Password)
WebUI.click(findTestObject('Global Objects/button_Login'))

//WebUI.comment('The welcome menu sometimes expands, sometimes not')
//WebUI.click(findTestObject('Global Objects/Page_Car Rental - Portal/span_Welcome_menu-text'))
WebUI.click(findTestObject('Global Objects/span_Optimiser'))
WebUI.click(findTestObject('Optimiser/1. Price View/a_Price View'))
WebUI.switchToFrame(findTestObject('Optimiser/1. Price View/iframe_Price View_PageContent'),1)

// Select Region
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Region'))
WebUI.selectOptionByValue(findTestObject('Optimiser/1. Price View/Select_Region'),'28',false) //Hervey Bay Airport
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Region'))

// Select Search Button
WebUI.focus(findTestObject('Optimiser/1. Price View/Button_Search'))
WebUI.click(findTestObject('Optimiser/1. Price View/Button_Search'))
// 
StopWatch stopwatch = new StopWatch()
stopwatch.start()
//'Wait for jQuery to be loaded in 60 seconds timeout.
WebUI.waitForJQueryLoad(60)

'Verify displayed text'
WebUI.verifyTextPresent('Rule Colour Key: Competitor Constraint Combination Category Position', false)

stopwatch.stop()
long timeTaken = stopwatch.getTime()  // milli seconds
WebUI.comment(">>> timeTaken = ${timeTaken}")

//Log User out
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()
