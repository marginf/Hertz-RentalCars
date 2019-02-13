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
WebUI.switchToFrame(findTestObject('Optimiser/4. Length of Hire/iframe_Length of Hire'),1)

//WebUI.comment('Select Market')
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Market'))
WebUI.selectOptionByValue(findTestObject('Optimiser/4. Length of Hire/select_Market'),NZ, false)
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Market'))

//Select Vehicle Type
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_CarType'))
WebUI.selectOptionByValue(findTestObject('Optimiser/4. Length of Hire/select_CarType'),'0fe6fdbe-50ed-4b99-91e5-2abf9413f8f8',false)
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_CarType'))

//WebUI.comment('Select Region')
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Region'))
WebUI.selectOptionByValue(findTestObject('Optimiser/4. Length of Hire/select_Region'),'152',false) //Auckland Airport
WebUI.click(findTestObject('Optimiser/4. Length of Hire/select_Region'))

//Click on Bulk Insertt Buttom
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Button_Bulk Insert'))

//LoH Bulk Insert Modal displays
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration1'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration1 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration2'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration2 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration3'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration3 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration4'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration4 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration5'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration5 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration6'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration6 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration7'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration7 - Input'),'1')

WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration8'))
WebUI.setText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoH Duration8 - Input'),'1')

// Click Expand button
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Button_Expand'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Button_Expand'))

//Select Modal Region & Options
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Region-Option'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Region-DropDown1'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Region-DropDown2'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Region-DropDown3'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Region-Option'))

//Select Season Group
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season Group-Option'))
WebUI.uncheck(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season Group-DropDown-SelectAll'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season Group-DropDown1'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season Group-DropDown2'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season Group-Option'))

//Select Season
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season-Option'))
WebUI.uncheck(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season-DropDown-SelectAll'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season-DropDown1'))
WebUI.check(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season-DropDown2'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Season-Option'))

//Select Categtory
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Category-Option'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Category-DropDown1'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Category-DropDown2'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Category-Option')) 

//Select LoHDiffs
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoHDiffs-Option'))
WebUI.selectOptionByIndex(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoHDiffs-Option'),0)
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/LoHDiffs-Option'))

//Click on Accept Button
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Button_Accept'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Button_Accept'))

//Update successfully message displayed
String SaveText = WebUI.getText(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Success Message'))
WebUI.verifyTextPresent("Update successfully!",false)
WebUI.verifyMatch(SaveText,'Update successfully!', true)

//Close Modal form
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Button_Close'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Bulk Insert Modal/Button_Close'))

//Click Save Button
WebUI.focus(findTestObject('Optimiser/4. Length of Hire/Button_Save'))
WebUI.click(findTestObject('Optimiser/4. Length of Hire/Button_Save'))

//Log User out
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()