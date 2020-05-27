package stepdefs;
import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.GherkinKeyword;
	import com.aventstack.extentreports.gherkin.model.Feature;
	import com.aventstack.extentreports.gherkin.model.Scenario;
	import allocator.ReusableMethods;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import listeners.ExtentReportListener;



	public class DemoWebsiteSteps extends ExtentReportListener 
	{ 
		ReusableMethods RM = new ReusableMethods();
		ExtentTest logInfo=null;
		@Given("^I navigate to the Demo website$")
		public void navigateToWebTableWebsite() throws ClassNotFoundException, IOException
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/JqueryProgressBar.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}
		}
		@When("^I click on download link and verify it$")
		public void verifyingDownloadLink() throws Exception
		{
			RM.PerformActionOnElement("StartDownload_DemoWebsite", "click", "");
			if(RM.waitForCondition("Presence", "CompleteBtn_DemoWebsite", 10000))
			{
				Thread.sleep(10000);
				RM.PerformActionOnElement("CloseBtn_DemoWebsite", "click", "");
			}
			if(RM.waitForCondition("NotPresent", "CloseBtn_DemoWebsite", 2000))
			{
				logInfo.pass("Download has done and window is closed");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else
			{
				logInfo.fail("Download window is not closed");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		@Given("^I navigate to the Demo Website to upload a file$")
		public void navigateToUpload()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/FileUpload.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}
		}
		@When("^I upload a file$")
		public void uploadingFileInDemoSite() throws InterruptedException
		{
			Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("C:\\Users\\Raghwendra Sonu\\Desktop\\test.rb.txt");
		Thread.sleep(5000);
		
		}
		@Given("^I navigate to the website to verify run button$")
		public void naviToVerifyRunBtn()
		{
			try {
			test = extent.createTest(Feature.class, "Verify Demo Website");                         
			test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
			logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
			driver.get("http://demo.automationtesting.in/Loader.html");
			RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
		}
		catch(Exception e)
		{
			testStepHandle("FAIL",driver,logInfo,e);    

		}
			
		}
		@When("^I verify run button and save the changes$")
		public void runBtnVerification() throws Exception
		{
			RM.PerformActionOnElement("RunBtn_DemoWebsite", "click", "");
			Thread.sleep(8000);
			if(RM.waitForCondition("Presence", "ModalTitle_DemoWebsite", 10000))
			{
				Thread.sleep(7000);
				RM.reportandscreenshot("ModalTitle_DemoWebsite", "Modal title is displayed on the popup", logInfo, captureScreenShot(driver));
				Thread.sleep(5000);
				RM.PerformActionOnElement("SaveChangesBtn_DemoWebsite", "click", "");
			}
			if(RM.waitForCondition("NotPresent", "ModalTitle_DemoWebsite", 2000))
			{
				logInfo.pass("Changes has saved");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				logInfo.fail("Changes has not saved");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			
			}
		@Given("^I navigate to the website to verify download$")
		public void navigateToDownload()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/FileDownload.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}	
		}
		@When("^I verify download Link and verify the file get downloaded$")
		public void downloadVerifying() throws Exception
		{
			RM.PerformActionOnElement("DownloadBtn_DemoWebsite", "click", "");
			Thread.sleep(10000);
			if(RM.downloadedFileVerification("C:\\Users\\Raghwendra Sonu\\Downloads", "samplefile.pdf"))
			{
				logInfo.pass("File is downloaded");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				logInfo.fail("File is not downloaded");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			}
			
		}
		@Given("^I navigate to website to verify drag and drop$")
		public void naviToDragNDrop()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/Static.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}	
		}
		@When("^I verify dragging and dropping of the available image$")
		public void verifyDragNDrop() throws Exception
		{
			RM.dragNdropOnImages("FirstImage_DemoWebskite", "DropArea_DemoWebsite");
			Thread.sleep(5000);
			RM.dragNdropOnImages("SecondImage_DemoWebsite", "DropArea_DemoWebsite");
			Thread.sleep(5000);
			RM.dragNdropOnImages("ThirdImage_DemoWebsite", "DropArea_DemoWebsite");
			RM.reportandscreenshot("FirstImage_DemoWebskite", "Images are dragged and dropped", logInfo, captureScreenShot(driver));
			
		}
		@Given("^I navigate to website to verify the auto suggestion$")
		public void naviToAutoSuggest()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/AutoComplete.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}	
		}
		@When("^I verify auto suggestion with \"([^\"]*)\"$")
		public void autoSuggestion(String Text) throws Exception
		{
			if(RM.autoSuggestionFilling("SearchBox_DemoSWebsite", Text))
			{
			logInfo.pass("AutoSuggestion is working properly");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				logInfo.fail("AutoSuggestion is not working properly");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(5000);
		}
		@Given("^I navigate to dateFillingDateEnabledSite$")
		public void naviDateFillSite()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/Datepicker.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}	
			
		}
	
		@When("^I verify filling dates with \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
		public void verifyingDateFillingInDateEnabled(String Year, String Month, String Date) throws Exception
		{
			RM.PerformActionOnElement("DatePickerBlankBox_DemoWebsite", "click", "");
			Thread.sleep(2000);
			//RM.PerformActionOnElement("TodayDate_DemoWebsite", "click", "");
			RM.selectvalueFromDropdown("ChangeTheYearBtn_DemoWebsite", Year);
			Thread.sleep(2000);
			RM.selectvalueFromDropdown("ChangeTheMonthBtn_DemoWebSite", Month);
			Thread.sleep(2000);
			RM.PerformActionOnElement("ChangeTheDate_Demosite", "clickwithactionclass", Date);
			Thread.sleep(5000);
			
		}
		@Given("^I navigate to verify the alert popup$")
		public void naviToalert()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.automationtesting.in/Alerts.html");
				RM.reportandscreenshot("PageHeading_DemoWebsite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}	
			
		}
		 
		@When("^I verify the alert popup$")
		public void verifyingAlertPopup() throws Exception
		{
			RM.PerformActionOnElement("AlertBtnToclick_DemoSite", "click", "");
			Thread.sleep(5000);
			 Alert alert = driver.switchTo().alert();
		     alert.accept();
		     Thread.sleep(5000);
			
		}
		@Given("^I navigate to verify the right click and double click$")
		public void naviTorightNdoubleClick()
		{
			try {
				test = extent.createTest(Feature.class, "Verify Demo Website");                         
				test=test.createNode(Scenario.class, "Verify Automation of DemoWebsite");                       
				logInfo=test.createNode(new GherkinKeyword("Given"), "Verify Demo Website");
				driver.get("http://demo.guru99.com/test/simple_context_menu.html");
				RM.reportandscreenshot("HeadingNewSite_DemoSite", "User navigation to DemoWebsite to verify run button", logInfo, captureScreenShot(driver));
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);    

			}	
		}
		@When("^I verify the right click and double click$")
		public void verifyingRightNDoubleClick() throws Exception
		{
			Actions actions = new Actions(driver);
			WebElement webElement = driver.findElement(By.xpath("//span[text()=\"right click me\"]")); 
			Thread.sleep(5000);
			actions.contextClick(webElement).perform(); 
			RM.PerformActionOnElement("DeletBtn_RightClickWindow", "click", "");
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			WebElement webElement2 = driver.findElement(By.xpath("//button[contains(text(),\"Double-Click \")]")); 
			actions.doubleClick(webElement2).perform(); 
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			
		}
		
		
		
		
		
		
		
		
		
	

}
