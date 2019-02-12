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
//WebUI.comment('User logs into MF')
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/Home/Login')
WebUI.setText(findTestObject('Global Objects/input_Username'), 'PTHertzrentals')
WebUI.setText(findTestObject('Global Objects/input_Password'), Password)
WebUI.click(findTestObject('Global Objects/button_Login'))

//WebUI.comment('The welcome menu sometimes expands, sometimes not')
//WebUI.click(findTestObject('Global Objects/Page_Car Rental - Portal/span_Welcome_menu-text'))
WebUI.click(findTestObject('Global Objects/span_Optimiser'))
WebUI.click(findTestObject('Optimiser/1. Price View/a_Price View'))
WebUI.switchToFrame(findTestObject('Optimiser/1. Price View/iframe_Price View_PageContent'),1)

// Select Region
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Region'))
WebUI.selectOptionByValue(findTestObject('Optimiser/1. Price View/Select_Region'),'2',false) //Adelaide City
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Region'))
//'Select Category'
WebUI.click(findTestObject('Optimiser/1. Price View/Select_CarType'))
WebUI.selectOptionByValue(findTestObject('Optimiser/1. Price View/Select_CarType'),'0fe6fdbe-50ed-4b99-91e5-2abf9413f8f8',false) //Car

//'Select Car from Category'
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Car'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Select_Car - SelectAll'))
WebUI.check(findTestObject('Optimiser/1. Price View/Select_Car_1'))
TempCar1 = WebUI.getText(findTestObject('Optimiser/1. Price View/Select_Car_1 - Text'))
WebUI.check(findTestObject('Optimiser/1. Price View/Select_Car_2'))
TempCar2 = WebUI.getText(findTestObject('Optimiser/1. Price View/Select_Car_2 - Text'))
WebUI.check(findTestObject('Optimiser/1. Price View/Select_Car_7'))
TempCar5 = WebUI.getText(findTestObject('Optimiser/1. Price View/Select_Car_7 - Text'))
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Car'))

//'Select Group'
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Groups'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Select_Groups - SelectAll'))
WebUI.check(findTestObject('Optimiser/1. Price View/Select_Groups_Select_Month'))
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Groups'))

//'Select Seasons'
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Seasons'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Select_Season - SelectAll'))
WebUI.check(findTestObject('Optimiser/1. Price View/select_Season_day1'))

//'Extract Season Day 1'
TSeasonDay1 = WebUI.getText(findTestObject('Optimiser/1. Price View/select_Season_day1_Text'))
TSeasonDay1L = TSeasonDay1.split('(\\()')[1]
TempSeasonDay1 = TSeasonDay1L.replaceAll('\\(|\\)','')

WebUI.check(findTestObject('Optimiser/1. Price View/select_Season_day2'))

//'Extract Season Day 2'
TSeasonDay2 = WebUI.getText(findTestObject('Optimiser/1. Price View/select_Season_day2_Text'))
TSeasonDay2L = TSeasonDay2.split('(\\()')[1]
TempSeasonDay2 = TSeasonDay2L.replaceAll('\\(|\\)','')

WebUI.check(findTestObject('Optimiser/1. Price View/select_Season_day3'))

//'Extract Season Week 4'
TSeasonWeek4 = WebUI.getText(findTestObject('Optimiser/1. Price View/select_Season_day3_Text'))
TSeasonWeek4L = TSeasonWeek4.split('(\\()')[1]
TempSeasonWeek4 = TSeasonWeek4L.replaceAll('\\(|\\)','')

WebUI.click(findTestObject('Optimiser/1. Price View/Select_Seasons'))

//'Set Duration'
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Duration'))
WebUI.selectOptionByValue(findTestObject('Optimiser/1. Price View/Select_Duration'),'7',false)

//'Extract Duration'
Duration1 = WebUI.getText(findTestObject('Optimiser/1. Price View/Select_Duration_Text'))
WebUI.click(findTestObject('Optimiser/1. Price View/Select_Duration'))

//'Select View Type' -
WebUI.click(findTestObject('Optimiser/1. Price View/Select_View Type'))
WebUI.selectOptionByLabel(findTestObject('Optimiser/1. Price View/Select_View Type'),'Current Utilisation',false)
//Other options: Current Rates,Forecast Utilisation,Current Utilisation,Recommended V Current,Availability

try {
	// Select Search Button
	WebUI.focus(findTestObject('Optimiser/1. Price View/Button_Search'))
	WebUI.click(findTestObject('Optimiser/1. Price View/Button_Search'))
	
	if (WebUI.verifyTextPresent('Please Select Seasons',false)) {
		throw new com.kms.katalon.core.exception.StepErrorException('Alert present')
		}
	}
	catch (StepErrorException e) {
		this.println(e)
}
	catch (Exception e) {
		this.println("General issue occurs")
	}
	finally {
	// Start stopwatch
	StopWatch stopwatch = new StopWatch()
	stopwatch.start()
	//'Wait for jQuery to be loaded in 180 seconds timeout.
	WebUI.waitForJQueryLoad(180)
	stopwatch.stop()
	long timeTaken = stopwatch.getTime()  
	WebUI.comment(">>> timeTaken = ${timeTaken}")
}
// Click Select All button
WebUI.focus(findTestObject('Optimiser/1. Price View/Button_Select All'))
WebUI.click(findTestObject('Optimiser/1. Price View/Button_Select All'))

// Click Edit and Confirm Rates button
//WebUI.waitForElementClickable(findTestObject('Optimiser/1. Price View/Button_Edit and Confirm Rates'),2)
WebUI.focus(findTestObject('Optimiser/1. Price View/Button_Edit and Confirm Rates'))
WebUI.click(findTestObject('Optimiser/1. Price View/Button_Edit and Confirm Rates'))

'Modal to Edit and Confirm Rates displays'
// Click on Download Rates button
WebUI.focus(findTestObject('Optimiser/1. Price View/Modal - Edit Rates/Button_Download Rates'))
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Edit Rates/Button_Download Rates'))

// Click on Confirm Rates button
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Edit Rates/Button_Confirm Rates'))
WebUI.verifyTextPresent('Update successfully!',false)

//Click to Close Modal
WebUI.focus(findTestObject('Optimiser/1. Price View/Modal - Edit Rates/Button_Close Modal'))
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Edit Rates/Button_Close Modal'))

// Click Customised Report button to download zip file (verify file has been downloaded)
WebUI.focus(findTestObject('Optimiser/1. Price View/Button_Customised Reports'))
WebUI.click(findTestObject('Optimiser/1. Price View/Button_Customised Reports'))
'Define Custom Path where file needs to be downloaded'
String downloadPath = 'C:\\Users\\MarginFuelTest\\Downloads'
'Verifying the file is downloaded to the User defined Path with Todays Date attached'
Assert.assertTrue(isFileDownloaded(downloadPath, 'Hertz_AU_AdelaideDowntown_'+ todaysDate + '.zip'), 'Failed to download Expected document')
boolean isFileDownloaded(String downloadPath, String fileName) {
	boolean flag = false
	'Creating an object for File and passing the download Path as argument'
	File dir = new File(downloadPath)
	'Creating an Array where it will store all the files from that folder'
	File[] dir_contents = dir.listFiles()
	println('Total Files Available in the folder are : ' + dir_contents.length)
	'Iterating a loop for number of files available in the folder to verify file name in the folder'
	for (int i = 0; i < dir_contents.length; i++) {
	println('File Name at 0 is : ' + dir_contents[i].getName())
	'Verifying the file name is available in the folder '
	if (dir_contents[i].getName().equals(fileName)) {
	'If the file is found then it will return a value as true'
	return flag = true
	}
}
	'If the file is found then it will return a value as false'
	return flag
}
//Return to Price View Page
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/#/Optimiser/PriceView')
WebUI.switchToFrame(findTestObject('Optimiser/1. Price View/iframe_Price View_PageContent'),1)
WebUI.scrollToElement(findTestObject('Optimiser/1. Price View/Graph - Recommended Price'),1)
// Change values of the graph dropdown lists
WebUI.focus(findTestObject('Optimiser/1. Price View/Graph - View Change'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - View Change'))
WebUI.selectOptionByIndex(findTestObject('Optimiser/1. Price View/Graph - View Change'),0)
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - View Change'))
WebUI.delay(1)
WebUI.focus(findTestObject('Optimiser/1. Price View/Graph - Category Change'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Category Change'))
WebUI.selectOptionByIndex(findTestObject('Optimiser/1. Price View/Graph - Category Change'),2)
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Category Change'))
WebUI.delay(1)
WebUI.focus(findTestObject('Optimiser/1. Price View/Graph - View Change'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - View Change'))
WebUI.selectOptionByIndex(findTestObject('Optimiser/1. Price View/Graph - View Change'),1)
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Season Change'))
WebUI.selectOptionByIndex(findTestObject('Optimiser/1. Price View/Graph - Season Change'),1)
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Season Change'))

// Select Legend Links
WebUI.scrollToElement(findTestObject('Optimiser/1. Price View/Graph - Recommended Price'),1)
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Recommended Price'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Current Price'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Competitor Price'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Forecast Utilisation'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Current Utilisation'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Min Price'))

WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Recommended Price'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Current Price'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Competitor Price'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Forecast Utilisation'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Current Utilisation'))
WebUI.click(findTestObject('Optimiser/1. Price View/Graph - Min Price'))

//Mouseover Graph
WebUI.mouseOverOffset(findTestObject('Optimiser/1. Price View/Graph - MouseOver'), 1092, 154)
//WebUI.scrollToElement(findTestObject('Optimiser/1. Price View/Button_Confirm Rates'),1)

// Click on Confirm Rates
WebUI.focus(findTestObject('Optimiser/1. Price View/Button_Confirm Rates'))
WebUI.click(findTestObject('Optimiser/1. Price View/Button_Confirm Rates'))

// Change Durations in Durations Modal Form
WebUI.waitForPageLoad(2)
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_1day'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_2day'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_3day'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_4-5days'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_6days'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_14-27days'))
WebUI.uncheck(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Select_Duration_28days'))

// Click OK Durations Modal
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Multiple Durations/Button_OK'))

//Invalid Rate Form Modal displays
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/IRF_Row1'))
WebUI.setText(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/IRF_Row1_Text'),'25.00')
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/IRF_Row2'))
WebUI.setText(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/IRF_Row2_Text'),'25.00')
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/IRF_Row3'))
WebUI.setText(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/IRF_Row3_Text'),'25.00')
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/Button_OK'))
WebUI.verifyTextPresent('Update successfully!',false)
WebUI.focus(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/Button_Close Modal'))
WebUI.click(findTestObject('Optimiser/1. Price View/Modal - Invalid Rate/Button_Close Modal'))

//Log User out
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()