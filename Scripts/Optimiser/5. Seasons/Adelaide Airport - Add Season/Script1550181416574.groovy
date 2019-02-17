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

// Select Search button
WebUI.click(findTestObject('Optimiser/5. Seasons/button_Season_Search'))
WebUI.waitForPageLoad(2)

// Click Add button
WebUI.focus(findTestObject('Optimiser/5. Seasons/button_Season-Add'))
WebUI.click(findTestObject('Optimiser/5. Seasons/button_Season-Add'))
// Modal form displays
WebUI.setText(findTestObject('Optimiser/5. Seasons/Modal - Season Add/input_Name_seasonName'), 'Robot Season1')
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/input_Date Range_daterange'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/Date_Picker_Right_Arrow'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/td_20'))
TDay1 = WebUI.getText(findTestObject('Optimiser/5. Seasons/Modal - Season Add/td_20'))
TMonth1 = WebUI.getText(findTestObject('Optimiser/5. Seasons/Modal - Season Add/Month_text'))
TMonth1L = TMonth1.substring(0,3)
SearchDate = WebUI.concatenate(TMonth1L,'-',TDay1)
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/Date_Picker_Right_Arrow'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/td_1'))
// Apply date range
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/button_Apply'))
// Save modal form
WebUI.scrollToElement(findTestObject('Optimiser/5. Seasons/Modal - Season Add/button_Save'),1)
WebUI.focus(findTestObject('Optimiser/5. Seasons/Modal - Season Add/button_Save'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/button_Save'))
'Update confirmation message'
'Get text alert on the alert when it\'s shown'
//alertText = WebUI.getAlertText()
'Verify text alert is correct or not'
WebUI.verifyTextPresent('Updating season and Setting default LOH and Rule!',false)

WebUI.focus(findTestObject('Optimiser/5. Seasons/Modal - Season Add/Modal_Close'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Season Add/Modal_Close'))

//Return to Season Page iframe
//WebUI.focus(findTestObject('Optimiser/5. Seasons/iframe_Regional Season_PageCon'))
//WebUI.switchToFrame(findTestObject('Optimiser/5. Seasons/iframe_Regional Season_PageCon'),1)

//Input Search criteria into Search field
WebUI.click(findTestObject('Optimiser/5. Seasons/Search_Field'))
WebUI.setText(findTestObject('Optimiser/5. Seasons/Search_Field'), SearchDate)

//Verify Search Date matches Input date
Cell_Text = WebUI.getText(findTestObject('Optimiser/5. Seasons/Search_Results_Date_Cell'))
WebUI.verifyMatch(Cell_Text,SearchDate, true)

//Select Status Link
WebUI.verifyMatch(WebUI.getText(findTestObject('Optimiser/5. Seasons/Search_Results_Status')),'Inactive', true)
WebUI.click(findTestObject('Optimiser/5. Seasons/Search_Results_Status'))

//Input Search criteria into Search field
WebUI.click(findTestObject('Optimiser/5. Seasons/Search_Field'))
WebUI.setText(findTestObject('Optimiser/5. Seasons/Search_Field'), SearchDate)

//Select Status Link
WebUI.verifyMatch(WebUI.getText(findTestObject('Optimiser/5. Seasons/Search_Results_Status')),'Active', true)
WebUI.click(findTestObject('Optimiser/5. Seasons/Search_Results_Status'))

// Select Data Cell Checkbox
WebUI.focus(findTestObject('Optimiser/5. Seasons/Search_Results_Date_Checkbox'))
WebUI.check(findTestObject('Optimiser/5. Seasons/Search_Results_Date_Cell'))

// Select Delete Button
WebUI.focus(findTestObject('Optimiser/5. Seasons/button_Season-Delete'))
WebUI.click(findTestObject('Optimiser/5. Seasons/button_Season-Delete'))

// Select Cancel button on Modal form
WebUI.focus(findTestObject('Optimiser/5. Seasons/Modal - Delete/Button_Cancel Delete'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Delete/Button_Cancel Delete'))

// Select Delete Button
WebUI.focus(findTestObject('Optimiser/5. Seasons/button_Season-Delete'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Delete/Button_Cancel Delete'))
'Verify text alert is correct or not'
WebUI.verifyTextPresent('Delete Successfully',false)

// Select OK button on Modal form
WebUI.focus(findTestObject('Optimiser/5. Seasons/Modal - Delete/Button_Confirm Delete'))
WebUI.click(findTestObject('Optimiser/5. Seasons/Modal - Delete/Button_Confirm Delete'))

//Log User out
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()