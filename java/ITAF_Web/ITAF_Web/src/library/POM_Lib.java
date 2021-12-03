package library;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
//import org.apache.poi.hssf.record.CFRuleBase.ComparisonOperator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormattingRule;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPatternFormatting;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheetConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.python.modules.synchronize;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.RichTextString;
import java.sql.ResultSetMetaData;
import library.UtilLib;
import library.Object_Definition_Library;

public class POM_Lib {

	public  static String Credentials_prod = UtilLib.getEnvVar("Credentials_prod");
	public  static String Credentials_stg = UtilLib.getEnvVar("Credentials_stg");
    public  static Object_Definition_Library prm = new Object_Definition_Library();
    private static WebElement element = null;
    public static WebDriver driver = null;

    public static String newline = System.getProperty("line.separator");
    public static SoftAssert softAssert = new SoftAssert();
    public static boolean flag=false;
    public  static String parentwindowid = null;

	/***********************************************************************************************
	 * 	                                   GENERAL FUNCTIONS
	 ***********************************************************************************************/
	public static void doWaitforElement(WebDriver driver, final By by) {
		 /* Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(120, TimeUnit.SECONDS)
		  .pollingEvery(1, TimeUnit.SECONDS)
		  .ignoring(NoSuchElementException.class);
		   try{
				  WebElement locator = wait.until
				  (
					 new Function<WebDriver,WebElement>()
				  {
					  public WebElement apply(WebDriver driver)
					  {
			     	     WebElement element = getElement(driver,by);
			     	     return element;
					  }
			       }
				  );
		   	}
		   catch(TimeoutException te)
		   {
		   }*/
WebDriverWait wait1 = new WebDriverWait(driver, 700);
//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void doWaitforElementState(WebDriver driver, final By by) {

		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.elementToBeClickable(by));
	}

	private static WebElement getElement(WebDriver driver, By by) {

		WebElement element = null;
		try {
			element = driver.findElement(by);
		} catch (NoSuchElementException e) {

		}

		return element;

	}

	public void handleAlert(WebDriver driver) {
		if (isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}


		/********************************************************************************************
		 * @Function_Name :  SAP_BO_login
		 * @Description : Initiate Browser and navigate to the URL and login
		 * @param TestCase_Name - Name of the TestCase
		 * @param AccessType - Operations/Admin
		 * @throws Exception
		 ********************************************************************************************/
		public static void SAP_BO_Login(String Env, WebDriver driver) throws Exception{

		System.out.println("Environment is: "+Env);

		if (Env.equalsIgnoreCase("PROD"))
			{
				UtilLib.BO_Login(UtilLib.getEnvVar("PRODURL"),UtilLib.getEnvVar("Credentials_prod"),driver);
				Thread.sleep(10000);
    		}
		else
			{
				UtilLib.BO_Login(UtilLib.getEnvVar("STGURL"),UtilLib.getEnvVar("Credentials_stg"),driver);
			}
		     //   UtilLib.Report_PASS("Login Page",":entered the url","SAP_BO_Login_Prod");

		}

		/********************************************************************************************
		 * @Function_Name :  SAP_BO_Find_Report
		 * @Description : Finding the Required Report
		 * @param TestCase_Name - Name of the TestCase
		 ********************************************************************************************/

		public static WebElement select_report(WebDriver driver,String firstfolder, String secondfolder ,String Xpath, String file_select_opt) throws InterruptedException{
			/*Click on Documents link*/
			driver.findElement(By.xpath(prm.documents)).click();
			Thread.sleep(2000);

		  /*Right click on the Automation POC file and selecting Modify option */
			driver.switchTo().frame(driver.findElement(By.xpath(prm.frame1)));
			//WebDriverWait wait = new WebDriverWait(driver, 100);
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prm.folder_select)));
			//WebElement pWE=driver.findElement(By.xpath(firstfolder));
			Actions pAction=new Actions(driver);
			pAction.moveToElement(driver.findElement(By.xpath(firstfolder))).doubleClick().perform();

			Thread.sleep(2000);
			driver.findElement(By.xpath(secondfolder)).click();
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prm.file_select)));
			Thread.sleep(2000);
			WebElement oWE=driver.findElement(By.xpath(Xpath));
			Actions oAction=new Actions(driver);
		    oAction.moveToElement(oWE);
		    oAction.contextClick(oWE).build().perform();
		    WebElement elementOpen = driver.findElement(By.linkText(file_select_opt));
		    elementOpen.click();
		    long stoptime = System.currentTimeMillis()+20000;
		 	while(System.currentTimeMillis()<stoptime){		}

		 	for(String winHandle : driver.getWindowHandles()){driver.switchTo().window(winHandle);  }
		 	long stoptime1 = System.currentTimeMillis()+14000;
			while(System.currentTimeMillis()<stoptime1){}

		 	return element;
			}




		/********************************************************************************************
		 * @Function_Name :  SAP_BO_Find_Report
		 * @Description : Finding the Required Report
		 * @param TestCase_Name - Name of the TestCase
		 * @throws Exception
		 ********************************************************************************************/

	public static void BO_select_report(WebDriver driver, String Folders, String PublicFolders, String FinanceFolder,
			String AutomationFolder, String BOFolder, String ReportingFolder, String Xpath, String file_select_opt,
			String TestCaseName, String ComponentType, String startTime) throws Exception {

		/* Click on Documents link */

		doWaitforElement(driver, By.xpath(prm.documents));
		driver.findElement(By.xpath(prm.documents)).click();
		doWaitforElement(driver, By.xpath("//iframe[contains(@id,'iframe4220')]"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'iframe4220')]")));
		List<WebElement> elements1 = driver.findElements(By.tagName("iframe"));
		int counter1 = 1;
		for (WebElement element : elements1) {
			// System.out.println("attribute is ::"+element.getAttribute("id"));
			List<WebElement> alllinks = driver.findElements(By.tagName("a"));
			String[] linktext = new String[alllinks.size()];
			for (int i = 0; i < alllinks.size(); i++) {
				System.out.println(alllinks.get(i).getText());
				if (alllinks.get(i).getText().contains("Folders"))
				// if(alllinks.get(i).getText().contains("COMPATIBILITY_REVENUE&BOOKINGS
				// AUTOMATION"))
				{
					// System.out.println("text found");
					Actions pAction = new Actions(driver);

					doWaitforElement(driver, By.xpath(Folders));
					pAction.moveToElement(driver.findElement(By.xpath(Folders))).doubleClick().perform();

					doWaitforElement(driver, By.xpath(PublicFolders));
					pAction.moveToElement(driver.findElement(By.xpath(PublicFolders))).doubleClick().perform();

					doWaitforElement(driver, By.xpath(FinanceFolder));
					pAction.moveToElement(driver.findElement(By.xpath(FinanceFolder))).doubleClick().perform();

					doWaitforElement(driver, By.xpath(AutomationFolder));
					pAction.moveToElement(driver.findElement(By.xpath(AutomationFolder))).doubleClick().perform();

					doWaitforElement(driver, By.xpath(BOFolder));
					// Thread.sleep(1000);
					pAction.moveToElement(driver.findElement(By.xpath(BOFolder))).doubleClick().perform();

					doWaitforElement(driver, By.xpath(ReportingFolder));
					// Thread.sleep(10000);
					pAction.moveToElement(driver.findElement(By.xpath(ReportingFolder))).doubleClick().perform();
					Thread.sleep(10000);
					// driver.findElement(By.xpath(ReportingFolder)).click();
					doWaitforElement(driver, By.xpath(Xpath));
					// Thread.sleep(2000);
					WebElement oWE = driver.findElement(By.xpath(Xpath));
					Actions oAction = new Actions(driver);
					oAction.moveToElement(oWE);
					oAction.contextClick(oWE).build().perform();
					doWaitforElement(driver, By.linkText(file_select_opt));
					// Thread.sleep(10000);
					WebElement elementOpen = driver.findElement(By.linkText(file_select_opt));
					// Thread.sleep(5000);

					elementOpen.click();
					Thread.sleep(40000);

					// driver.switchTo().defaultContent();

					String parentwindow = driver.getWindowHandle();
					driver.switchTo().window(parentwindow);
					// driver.switchTo().defaultContent();
					doWaitforElement(driver, By.name("servletBridgeIframe"));
					driver.switchTo().frame(driver.findElement(By.name("servletBridgeIframe")));
					doWaitforElement(driver, By.xpath("//a[contains(@title, 'Open in a new window')]"));
					// Thread.sleep(20000);
					WebElement open1 = driver.findElement(By.xpath("//a[contains(@title, 'Open in a new window')]"));
					Thread.sleep(10000);
					open1.click();
					// Thread.sleep(40000);

					break;

				}
			}
		}

		/* Element handling in the new child window */
		String parentwindow = driver.getWindowHandle();
		Set<String> childwindow = driver.getWindowHandles();
		for (String eachWindow : childwindow) {
			if (!eachWindow.equalsIgnoreCase(parentwindow))

			{
				driver.switchTo().window(eachWindow);
				doWaitforElement(driver, By.tagName("iframe"));
				List<WebElement> elements = driver.findElements(By.tagName("iframe"));
				int counter = 0;
				for (WebElement element1 : elements) {
					/*
					 * System.out.println("attribute is ::"
					 * +element1.getAttribute("id"));
					 */
					if (element1.getAttribute("id").contains("4065")) {
						driver.switchTo().frame(element1);
						List<WebElement> childframe = driver.findElements(By.tagName("iframe"));
						for (WebElement each : childframe) {
							/*
							 * System.out.println("child is ::"
							 * +each.getAttribute("id"));
							 */
							driver.switchTo().frame(each);
							doWaitforElement(driver, By.xpath("//*[@id='IconImg__dhtmlLib_283']"));
							Thread.sleep(5000);
							driver.findElement(By.xpath("//*[@id='IconImg__dhtmlLib_283']")).click();
							doWaitforElement(driver,
									By.xpath("//div[contains(text(),'Query') and not (@class='iconText')]"));
							List<WebElement> listofItems = driver.findElements(
									By.xpath("//div[contains(text(),'Query') and not (@class='iconText')]"));
							int J = 0;
							StringBuilder logmessages = new StringBuilder();

							for (WebElement webEle : listofItems) {
								int i = 1 + J;
								if (logmessages.length() > 0) {
									logmessages.append("\n");
								}
								webEle.click();
								String QueryTabName = "Query " + i;
								driver.findElement(By.xpath("//*[@id='IconImg_viewScript']")).click();

								doWaitforElement(driver, By.id("scriptTree"));
								WebElement scriptTree = getElement(driver, By.id("scriptTree"));
								WebElement errordlg = getElement(driver, By.id("dlg_txt_alertDlg"));
								WebElement Querycontext = getElement(driver, By.id("ariaLabelledBy_contextDlg"));
								if (scriptTree != null && scriptTree.isDisplayed()) {
									getElement(driver, By.id("RealBtn_CANCEL_BTN_SqlViewerDlg")).click();
									// System.out.println("Multiple Queries
									// displayed");
									UtilLib.Report_FAIL(TestCaseName,
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName,
											"Compatibility Check");
									UtilLib.LogReport(TestCaseName,
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
									// UtilLib.LogExcelReportForCompatibility(TestCaseName,
									// "Compatibility is a fail for:
									// "+TestCaseName+"."+QueryTabName,
									// "FAILED",ComponentType,startTime);
									logmessages.append(
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
								}

								else if (errordlg != null && errordlg.isDisplayed()) {
									driver.findElement(By.id("RealBtn_OK_BTN_alertDlg")).click();
									// System.out.println("Alert is displayed");
									UtilLib.Report_FAIL(TestCaseName,
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName,
											"Compatibility Check");
									UtilLib.LogReport(TestCaseName,
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
									// UtilLib.LogExcelReportForCompatibility(TestCaseName,
									// "Compatibility is a fail for:
									// "+TestCaseName+"."+QueryTabName,
									// "FAILED",ComponentType,startTime);
									logmessages.append(
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
								}

								else if (Querycontext != null && Querycontext.isDisplayed()) {
									driver.findElement(By.id("RealBtn_CD_cancelBtn")).click();
									// System.out.println("Alert is displayed");
									UtilLib.Report_FAIL(TestCaseName,
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName,
											"Compatibility Check");
									UtilLib.LogReport(TestCaseName,
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
									// UtilLib.LogExcelReportForCompatibility(TestCaseName,
									// "Compatibility is a fail for:
									// "+TestCaseName+"."+QueryTabName,
									// "FAILED",ComponentType,startTime);
									logmessages.append(
											"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
								}

								else {
									getElement(driver, By.id("RealBtn_CANCEL_BTN_SqlViewerDlg")).click();
									// System.out.println("Testcase is passed");
									UtilLib.Report_PASS(TestCaseName,
											"Compatibility is a pass for: " + TestCaseName + "." + QueryTabName,
											"Compatibility Check");
									UtilLib.LogReport(TestCaseName,
											"Compatibility is a pass for: " + TestCaseName + "." + QueryTabName);
									// UtilLib.LogExcelReportForCompatibility(TestCaseName,
									// "Compatibility is a pass for:
									// "+TestCaseName+"."+QueryTabName,
									// "PASSED",ComponentType,startTime);

								}
								J++;
							}

							if (logmessages.length() > 0) {
								UtilLib.LogExcelReportForCompatibility(TestCaseName, logmessages.toString(), "FAILED",
										ComponentType, startTime);
							} else {
								UtilLib.LogExcelReportForCompatibility(TestCaseName,
										"Compatibility is a pass for: " + TestCaseName, "PASSED", ComponentType,
										startTime);
							}

							driver.quit();

						}
					}
				}
			}
		}
	}






		/********************************************************************************************
		 * @Function_Name :  SAP_BO_Find_Report
		 * @Description : Finding the Required Report from the current window
		 * @param TestCase_Name - Name of the TestCase
		 ********************************************************************************************/

		public static WebElement reselect_report(WebDriver driver,String documents,String Xpath, String file_select_opt) throws InterruptedException{
			/*Click on Documents link*/
			driver.findElement(By.xpath(documents)).click();
			Thread.sleep(2000);

		  /*Right click on the Automation POC file and selecting Modify option */
			driver.switchTo().frame(driver.findElement(By.xpath(prm.frame1)));
			//WebDriverWait wait = new WebDriverWait(driver, 100);
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prm.folder_select)));
			//WebElement pWE=driver.findElement(By.xpath(firstfolder));
			//Actions pAction=new Actions(driver);
			//pAction.moveToElement(driver.findElement(By.xpath(firstfolder))).doubleClick().perform();

			//Thread.sleep(2000);
			//driver.findElement(By.xpath(secondfolder)).click();
			//Thread.sleep(2000);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prm.file_select)));
			//Thread.sleep(2000);
			WebElement oWE=driver.findElement(By.xpath(Xpath));
			Actions oAction=new Actions(driver);
		    oAction.moveToElement(oWE);
		    oAction.contextClick(oWE).build().perform();
		    WebElement elementOpen = driver.findElement(By.linkText(file_select_opt));
		    elementOpen.click();
		    long stoptime = System.currentTimeMillis()+20000;
		 	while(System.currentTimeMillis()<stoptime){		}

		 	for(String winHandle : driver.getWindowHandles()){driver.switchTo().window(winHandle);  }
		 	/*String title=driver.getTitle();
		 	System.out.println("title of page is :"+title);
		 	String url= driver.getCurrentUrl();
		 	System.out.println("Current url of page: "+url);*/
		    long stoptime1 = System.currentTimeMillis()+14000;
			while(System.currentTimeMillis()<stoptime1){}
			//UtilLib.Report_PASS("Find Required Report","Found the Required Report","click_element");
		 	return element;
			}

		/********************************************************************************************
		 * @throws InterruptedException
		 * @Function_Name :  SAP_BO_Loop_Through_Query_Windows
		 * @Description : Loop through query windows
		 ********************************************************************************************/
		public static void QueryCompatibilityCheck(String TestCaseName, SoftAssert softAssert,String ComponentType,String startTime) throws InterruptedException{
			//	System.out.println("Control is inside the function");
				Thread.sleep(1000);
				for (int i=1;i<4;i++){
					String Query="C:\\Query"+i+".png";
					String fileNameWithOutExt = FilenameUtils.removeExtension("C:\\Query"+i+".png");
					 String QueryTabName=fileNameWithOutExt.substring(3);
					//System.out.println("the image path is: "+Query);
					try {
						IterateQueryWindow(TestCaseName,Query,QueryTabName, softAssert,ComponentType,startTime);
					    }
					catch (FindFailed e) {
						e.printStackTrace();

					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (Exception e) {

						e.printStackTrace();
					}
				}
				UtilLib.click_element(UtilLib.getImagePath("CloseButton"));
				UtilLib.click_element(UtilLib.getImagePath("CloseYesOption"));
				}



		/********************************************************************************************
		 * @throws InterruptedException
		 * @Function_Name :  SAP_BO_Loop_Through_Query_Windows
		 * @Description : Validate only given query window
		 ********************************************************************************************/
		public static void QueryCompatibilityCheck(String TestCaseName, int QueryWindow,SoftAssert softAssert,String ComponentType,String startTime) throws InterruptedException{
		//	System.out.println("Control is inside the function");
			Thread.sleep(1000);

				String Query="C:\\Query "+QueryWindow+".png";
				String fileNameWithOutExt = FilenameUtils.removeExtension("C:\\Query "+QueryWindow+".png");
				 String QueryTabName=fileNameWithOutExt.substring(3);
				//System.out.println("the image path is: "+Query);
				try {
					IterateQueryWindow(TestCaseName,Query,QueryTabName, softAssert,ComponentType,startTime);
				    }
				catch (FindFailed e) {
					e.printStackTrace();

				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}

			UtilLib.click_element(UtilLib.getImagePath("CloseButton"));
			UtilLib.click_element(UtilLib.getImagePath("CloseYesOption"));
			}

		/********************************************************************************************
		 * @throws Exception
		 * @Function_Name :  SAP_BO_Loop_Through_Query_Windows
		 * @Description : Validate only given query window
		 ********************************************************************************************/
		public static void BOQueryCompatibilityCheck(String TestCaseName,SoftAssert softAssert,String ComponentType,String startTime) throws Exception{
		//	System.out.println("Control is inside the function");
			UtilLib.WaitTime(10000);

	  		/* Sikuli codes*/
	  		UtilLib.click_element(UtilLib.getImagePath("EditDataProvider"));
	  		UtilLib.WaitTime(8000);
			Thread.sleep(1000);
			for (int i=1;i<=8;i++){
				String Query=UtilLib.getImagePath("SikiuliQueryTab")+"Query "+i+".png";
				String fileNameWithOutExt = FilenameUtils.removeExtension(UtilLib.getImagePath("SikiuliQueryTab")+"Query "+i+".png");
				 String QueryTabName=fileNameWithOutExt.substring(3);
				//System.out.println("the image path is: "+Query);
				try {
					IterateQueryWindow(TestCaseName,Query,QueryTabName, softAssert,ComponentType,startTime);
				    }
				catch (FindFailed e) {
					e.printStackTrace();

				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			UtilLib.click_element(UtilLib.getImagePath("CloseButton"));
			UtilLib.click_element(UtilLib.getImagePath("CloseYesOption"));
			}


		/********************************************************************************************
		 * @throws Exception
		 * @Function_Name : SAP_BO_Iterate_Query_Images
		 * @Description : Iterate through Query Images
		 ********************************************************************************************/
		public static void IterateQueryWindow(String TestCaseName,String Query, String QueryTabName, SoftAssert softAssert,String ComponentType,String startTime) throws Exception{
			//System.out.println("Control is checking the image");
			Screen s1=new Screen();
			if(s1.exists(new Pattern(Query).similar((float) 0.70))!=null)
			{	s1.hover(new Pattern(Query));
				s1.click(new Pattern(Query));
				UtilLib.WaitTime(5000);
				UtilLib.click_element(UtilLib.getImagePath("ViewScript"));
				UtilLib.WaitTime(5000);
				boolean status1=UtilLib.imgCheck(UtilLib.getImagePath("MultiFlowCheck"));
				//System.out.println("Status"+status1);
				if (status1==true)
				{
					UtilLib.Report_PASS(TestCaseName,"Compatibility is a pass for: "+TestCaseName+"."+QueryTabName, "Compatibility Check");
					UtilLib.LogReport(TestCaseName,"Compatibility is a pass for: "+TestCaseName+"."+QueryTabName);
					UtilLib.LogExcelReportForCompatibility(TestCaseName, "Compatibility is a pass for: "+TestCaseName, "PASSED",ComponentType,startTime);
					UtilLib.click_element(UtilLib.getImagePath("ScriptWindowClose"));
				}
				else
				{
					UtilLib.Report_FAIL(TestCaseName,"Compatibility is a fail for: "+TestCaseName+"."+QueryTabName, "Compatibility Check");
					UtilLib.LogReport(TestCaseName,"Compatibility is a fail for: "+TestCaseName+"."+QueryTabName);
					UtilLib.LogExcelReportForCompatibility(TestCaseName, "Compatibility is a fail for: "+TestCaseName, "FAILED",ComponentType,startTime);

					UtilLib.click_element(UtilLib.getImagePath("ScriptWindowClose"));
					softAssert.assertTrue(false,"Compatibility is a fail for: "+TestCaseName+"."+QueryTabName);
					//softAssert.assertAll();
				}

			}
			else
				return;
			}








		/********************************************************************************************
		 * @Function_Name :  SAP_BO_login_WebIntelligence
		 * @Description : Initiate Browser and navigate to the URL and login
		 * @param TestCase_Name - Name of the TestCase
		 * @param AccessType - Operations/Admin
		 * @throws Exception
		 ********************************************************************************************/
		public static void SAP_BO_Login_WebIntel(String Env) throws Exception{

		System.out.println("Environment is: "+Env);
		//System.out.println(Env);
		if (Env.equalsIgnoreCase("PROD"))
			{
				//System.out.println("Url: "+UtilLib.getEnvVar("PRODURL"));
				UtilLib.BO_Login_WebIntelligence(UtilLib.getEnvVar("PRODURL"),UtilLib.getEnvVar("Credentials_prod"));
				//System.out.println("Login success");
				Thread.sleep(10000);


			}
		else
			{
				UtilLib.BO_Login_WebIntelligence(UtilLib.getEnvVar("STGURL"),UtilLib.getEnvVar("Credentials_stg"));
			}
		     //   UtilLib.Report_PASS("Login Page",":entered the url","SAP_BO_Login_Prod");

		}






		/********************************************************************************************
		 * @Function_Name :  WebIntelligence
		 * @Description : New WebIntelligence
		 * @param TestCase_Name - Name of the TestCase
		 * @throws Exception
		 ********************************************************************************************/

		public static void Web_intelli_click_element(WebDriver driver, String Xpath, String frame) throws Exception{
			driver.switchTo().frame(driver.findElement(By.xpath(frame)));
			driver.findElement(By.xpath(Xpath)).click();
			Thread.sleep(10000);

			//String parentHandle = driver.getWindowHandle();
			 for(String winHandle : driver.getWindowHandles()){driver.switchTo().window(winHandle);  }
			 	/*String title=driver.getTitle();
			 	System.out.println("title of page is :"+title);
			 	String url= driver.getCurrentUrl();
			 	System.out.println("Current url of page: "+url);*/
			 	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


	}



		/********************************************************************************************
		 * @Function_Name :  MultiFlow Check
		 * @Description : Checking for Multiflow after clicking on 'View Script'
		 * @param TestCase_Name - Name of the TestCase
		 ********************************************************************************************/

		public static boolean  report_export() throws InterruptedException{

		 	try{
			UtilLib.click_element(UtilLib.getImagePath("ExportIcon"));
			UtilLib.click_element(UtilLib.getImagePath("ExportDocumentAs"));
			UtilLib.click_element(UtilLib.getImagePath("ExportToExcel"));
		    Thread.sleep(5000);
		    UtilLib.click_element_targetOffset(UtilLib.getImagePath("SaveFile"));
		    Thread.sleep(2000);
		    UtilLib.click_element(UtilLib.getImagePath("ExportOkButton"));
		    Thread.sleep(2000);
		    System.out.println("File Exported...!!!");
		    return true;
		 	}
		 	catch (Exception e)
		     {
		         System.err.println("Error: " + e.getMessage());
		     }
			return false;

	}
	/*
		*//********************************************************************************************
		 * @Function_Name :  SAP_BO_ReadFromExcel
		 * @Description : Read From Production and Stage reports
		 ********************************************************************************************//*
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static void ReadExcel() {

			HashMap dataHolder_sheet1 = UtilLib.readExcelFile(prm.ExcelPath_1,1);
			HashMap dataHolder_sheet2 = UtilLib.readExcelFile(prm.ExcelPath_2,2);

			HashMap hm11;
			HashMap hm22;
			HashMap mismatch = new HashMap();


			 Iterator it = dataHolder_sheet1.entrySet().iterator();
			 Iterator it2 = dataHolder_sheet2.entrySet().iterator();

			while (it.hasNext()&& it2.hasNext()) {
				 Map.Entry pair = (Map.Entry)it.next();
			       // System.out.println(pair.getKey() + " @@ " + pair.getValue());
			        hm11 = new HashMap((HashMap)pair.getValue());

			        Map.Entry pair2 = (Map.Entry)it2.next();
			        //System.out.println(pair2.getKey() + " @@ " + pair2.getValue());
			        hm22 = new HashMap((HashMap)pair2.getValue());

			        Iterator it11 = hm11.entrySet().iterator();
			        Iterator it22 = hm22.entrySet().iterator();
			        while (it11.hasNext()&& it22.hasNext()) {
			        	 Map.Entry pair11 = (Map.Entry)it11.next();
			        	//System.out.println(pair11.getKey() + " @@ " + pair11.getValue());
			        	Map.Entry pair22 = (Map.Entry)it22.next();
			        	//System.out.println(pair22.getKey() + " @@ " + pair22.getValue());
			        	if(pair11.getKey().equals(pair22.getKey())){
			        		try{
			        			//System.out.println(pair11.getKey());
			        			//System.out.println(new Double(pair11.getValue().toString()) - new Double(pair22.getValue().toString()));
			        			double d = new Double(pair11.getValue().toString()) - new Double(pair22.getValue().toString());
			        			if(d != 0.0|| d<-2){
			        				mismatch.put(pair22.getKey(), pair11.getValue()+" - "+pair22.getValue()+" = "+d);
			        			}

			        		}catch (IllegalArgumentException e) {
			        			if(!pair11.getValue().toString().equals(pair22.getValue().toString())){
			        				mismatch.put(pair22.getKey(), pair11.getValue()+", "+pair22.getValue());
			        			}
							}
			        	}

			        }
				}
			System.out.println(mismatch);
			POM_Lib.writeExcel(mismatch);

		}
			*/


		/********************************************************************************************
		 * @Function_Name :  SAP_BO_WriteToExcel
		 * @Description : Write the Mismatch to Excel
		 ********************************************************************************************/

		@SuppressWarnings({ "rawtypes", "resource" })
	public static void writeExcel(HashMap mismatch) {

		File file1 = new File(prm.ExcelPath_1);
		File file2 = new File(prm.ExcelPath_2);
		String fileName1 = file1.getName();
		String fileName2 = file2.getName();

	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Mismatch Values");

	/* code to format for header */
	HSSFFont boldFont = workbook.createFont();
	//boldFont.setFontHeightInPoints((short)22);
	boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //Setting Bold font
	boldFont.setFontHeightInPoints((short) 10);
	boldFont.setColor(HSSFColor.BLUE.index);

	  HSSFCellStyle cellStyle = workbook.createCellStyle();
	  cellStyle.setFillBackgroundColor(HSSFColor.BLACK.index);
     // cellStyle.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
	  cellStyle.setFont(boldFont); //Attaching the font to the Style

    HSSFRow row1 = sheet.createRow((short) 0);
    HSSFCell cell1= row1.createCell((int)0);
    cell1.setCellValue("Difference between file "+fileName1+" and "+fileName2);
    cell1.setCellStyle(cellStyle);

	/* code to format for mismatch values */
	HSSFCellStyle style = workbook.createCellStyle();
    style.setFillBackgroundColor(HSSFColor.GREY_50_PERCENT.index);
    HSSFFont font = workbook.createFont();
    font.setFontName(HSSFFont.FONT_ARIAL);
    font.setFontHeightInPoints((short) 10);
    font.setColor(HSSFColor.BLACK.index);
    style.setFont(font);

	int rownum = 2;

    Iterator it1 = mismatch.entrySet().iterator();
    	while (it1.hasNext()){
    		 Map.Entry pair = (Map.Entry)it1.next();
    		 Row row = (Row) sheet.createRow(rownum++);
    		 int cellnum = 0;
            org.apache.poi.ss.usermodel.Cell cell =  row.createCell(cellnum++);
            Object obj=pair.getKey() + " Cell id -- has the mismatch as " + pair.getValue();
            if(obj instanceof Date)
                ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((Date)obj);
            else if(obj instanceof Boolean)
                ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((Boolean)obj);
            else if(obj instanceof String)
                ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((String)obj);
            else if(obj instanceof Double)
                ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((Double)obj);
            cell.setCellStyle((CellStyle) style);
           // sheet.autoSizeColumn(1);
        }
    try {
    	String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
        FileOutputStream out =
                new FileOutputStream(new File("C:\\Users\\vinod\\Desktop\\BO_Reports\\MismatchValues"+fileName));
        workbook.write(out);
        out.close();
        System.out.println("Excel written successfully..");

    }
      catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
		}

		/********************************************************************************************
		 * @Function_Name :  Teradata Execution
		 * @Description : Check if Production file is already there if exists refer that else fetch
		 * details from teradata prod and compare it against stage
		 **********************************************************************************************//*
		public static void EnvironmentValidation(String connurlprod, String unameprod, String pwordprod,String connurlstg, String unamestg, String pwordstg,String Query, String TestCaseName, String PeriodIdType){
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			File prodFile = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder+"\\"+prodFileName);
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);
			String ComponentType=PeriodIdType.replaceAll("BWPeriodId", "");
			String PeriodId=UtilLib.getParam(PeriodIdType);
			//System.out.println("Prod file path"+prodFile);
			if (prodFile.exists())
			{
				//System.out.println("File already exists:" +prodFile);
				try{
				HSSFWorkbook workbook = new HSSFWorkbook();
				FileInputStream existingProdInput = new FileInputStream(prodFile);
				HSSFWorkbook existingProdWorkBook = new HSSFWorkbook(existingProdInput);
				HSSFSheet existingprodsheet = existingProdWorkBook.getSheet("Production Results");
				HSSFSheet prodsheet = workbook.createSheet("Production Results");
				UtilLib.PlainOfCopyContentsOfExcel(workbook, prodsheet,existingprodsheet);
				HSSFSheet stgsheet = workbook.createSheet("Stage Results");
				UtilLib.TeradataResultSetToExcel(connurlstg,unamestg,pwordstg,Query,workbook,stgsheet,TestCaseName,"Stage", PeriodIdType);
				HSSFSheet variancesheet = workbook.createSheet("Variance");
				UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
				UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
				VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stgsheet, Query);
				for (int i=1;i<100;i++){
							variancesheet.autoSizeColumn(i);
							prodsheet.autoSizeColumn(i);
							stgsheet.autoSizeColumn(i);
						}


						FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
						workbook.write(out);
						out.close();

						if (VarianceExists==0){
							 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches ", " ");
							 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
							 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",ComponentType, filePath,PeriodId,Query,dateStart);
							}
						else {
							UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
							UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
							UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",ComponentType, filePath,PeriodId,Query,dateStart);
							Assert.fail("The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
						}

				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
			else {
				POM_Lib.ValidateDataTeradata(connurlprod,unameprod,pwordprod, connurlstg,unamestg, pwordstg,Query, TestCaseName, PeriodIdType);
			}
		}



		*//********************************************************************************************
		 * @Function_Name :  Teradata Execution
		 * @Description : Login to teradata and execute given query

		 **********************************************************************************************//*
		public static void ValidateDataTeradata(String connurlprod, String unameprod, String pwordprod,String connurlstg, String unamestg, String pwordstg,String Query, String TestCaseName, String PeriodIdType){
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);
			String ComponentType=PeriodIdType.replaceAll("BWPeriodId", "");
			String PeriodId=UtilLib.getParam(PeriodIdType);
		try{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet prodsheet = workbook.createSheet("Production Results");
			UtilLib.TeradataResultSetToExcel(connurlprod,unameprod,pwordprod,Query,workbook,prodsheet,TestCaseName, "PRODUCTION",PeriodIdType);
			HSSFSheet stgsheet = workbook.createSheet("Stage Results");
			UtilLib.TeradataResultSetToExcel(connurlstg,unamestg,pwordstg,Query,workbook,stgsheet,TestCaseName,"Stage",PeriodIdType);
			HSSFSheet variancesheet = workbook.createSheet("Variance");
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
			VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stgsheet, Query);

			for (int i=1;i<100;i++){
				variancesheet.autoSizeColumn(i);
				prodsheet.autoSizeColumn(i);
				stgsheet.autoSizeColumn(i);
			}


			FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
			workbook.write(out);
			out.close();
			//System.out.println("Creating new file");

			 Save the production file for future reference
			HSSFWorkbook workbookforref = new HSSFWorkbook();
			HSSFSheet prodsheetforref = workbookforref.createSheet("Production Results");
			UtilLib.PlainOfCopyContentsOfExcel(workbookforref, prodsheetforref,prodsheet);
			File Prodfilefolder = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder);
			Prodfilefolder.mkdir();
			//System.out.println("Creating new file2");
			FileOutputStream outref=new FileOutputStream(new File(Prodfilefolder+"\\"+prodFileName));
			workbookforref.write(outref);
			out.close();
			//System.out.println("Created the new file");

			if (VarianceExists==0){
				 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches", " ");
				 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
				 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",ComponentType,filePath,PeriodId,Query);
				}
			else {
				UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
				UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
				UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",ComponentType,filePath,PeriodId,Query);
				Assert.fail("The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");

			}

		}
		catch (Exception e){
			e.printStackTrace();
		}


		}
		*/



		/********************************************************************************************
		 * @Function_Name :  Teradata Execution
		 * @Description : Check if Production file is already there if exists refer that else fetch
		 * details from teradata prod and compare it against stage
		 **********************************************************************************************/
		public static void EnvironmentValidation(String connurlprod, String unameprod, String pwordprod,String ProdQuery,String connurlstg, String unamestg, String pwordstg,String StageQuery, String TestCaseName, String PeriodIdType,String ViewName, String TrackName){
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			File prodFile = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder+"\\"+prodFileName);
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);
			String ComponentTypeBW=PeriodIdType.replaceAll("BWPeriodId", "");
			String ComponentType=ComponentTypeBW.replaceAll("INPeriodID", "");
			String PeriodId=UtilLib.getParam(PeriodIdType);
			//System.out.println("Prod file path"+prodFile);
			if (prodFile.exists())
			{
				System.out.println("File already exists:" +prodFile);
				try{
				XSSFWorkbook workbook = new XSSFWorkbook();
				FileInputStream existingProdInput = new FileInputStream(prodFile);
				XSSFWorkbook existingProdWorkBook = new XSSFWorkbook(existingProdInput);
				XSSFSheet existingprodsheet = existingProdWorkBook.getSheet("Production Results");
				XSSFSheet prodsheet = workbook.createSheet("Production Results");
				UtilLib.PlainOfCopyContentsOfExcel(workbook, prodsheet,existingprodsheet);
				XSSFSheet stgsheet = workbook.createSheet("Stage Results");
				UtilLib.TeradataResultSetToExcel(connurlstg,unamestg,pwordstg,StageQuery,workbook,stgsheet,TestCaseName,"Stage",PeriodIdType,ViewName);
				XSSFSheet variancesheet = workbook.createSheet("Variance");
				UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
				UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
				VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stgsheet, ProdQuery+newline+StageQuery);
				for (int i=1;i<100;i++){
							variancesheet.autoSizeColumn(i);
							prodsheet.autoSizeColumn(i);
							stgsheet.autoSizeColumn(i);
						}


						FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
						workbook.write(out);
						out.close();
						existingProdWorkBook.close();

						if (VarianceExists==0){
							 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches ", " ");
							 UtilLib.LogReport(TestCaseName, "The queries: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
							 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",TrackName,filePath,PeriodId,ProdQuery,dateStart,ViewName);
							}
						else {
							UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
							UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
							UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",TrackName,filePath,PeriodId,ProdQuery,dateStart,ViewName);
							Assert.fail("The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
						}

				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
			else {
				POM_Lib.ValidateDataTeradata(connurlprod,unameprod,pwordprod, ProdQuery,connurlstg,unamestg, pwordstg,StageQuery, TestCaseName, PeriodIdType,ViewName);
			}
		}



		/********************************************************************************************
		 * @Function_Name :  Teradata Execution
		 * @Description : Login to teradata and execute given query

		 **********************************************************************************************/
		public static void ValidateDataTeradata(String connurlprod, String unameprod, String pwordprod,String ProdQuery,String connurlstg, String unamestg, String pwordstg,String StageQuery, String TestCaseName, String PeriodIdType,String ViewName){
			System.out.println("File doesnt exist");
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			System.out.println("dateStart :"+dateStart);
			String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			System.out.println("prodFileName : "+prodFileName);
			String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			System.out.println("prodTestCaseFolder : "+prodTestCaseFolder);
			String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			System.out.println("ProdBaseLineFolderName : "+ProdBaseLineFolderName);
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			System.out.println("fileName : "+fileName);
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);
			System.out.println("filePath : "+filePath);
			String ComponentTypeBW=PeriodIdType.replaceAll("BWPeriodId", "");
			System.out.println("ComponentTypeBW : "+ComponentTypeBW);
			String ComponentType=ComponentTypeBW.replaceAll("INPeriodID", "");
			System.out.println("ComponentType : "+ComponentType);
			String PeriodId=UtilLib.getParam(PeriodIdType);
			System.out.println("PeriodId : "+PeriodId);
			System.out.println("ProdQuery : "+ProdQuery);

		try{
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet prodsheet = workbook.createSheet("Production Results");
			System.out.println("Prod sheet created");
			UtilLib.TeradataResultSetToExcel(connurlprod,unameprod,pwordprod,ProdQuery,workbook,prodsheet,TestCaseName, "PRODUCTION",PeriodIdType,ViewName);
			XSSFSheet stgsheet = workbook.createSheet("Stage Results");
			System.out.println("Stage sheet created");
			UtilLib.TeradataResultSetToExcel(connurlstg,unamestg,pwordstg,StageQuery,workbook,stgsheet,TestCaseName,"Stage",PeriodIdType,ViewName);
			XSSFSheet variancesheet = workbook.createSheet("Variance");
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
			VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stgsheet, ProdQuery+newline+StageQuery);

			for (int i=1;i<100;i++){
				variancesheet.autoSizeColumn(i);
				prodsheet.autoSizeColumn(i);
				stgsheet.autoSizeColumn(i);
			}


			FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
			workbook.write(out);
			out.close();
			System.out.println("Creating new file");

			/* Save the production file for future reference*/
			XSSFWorkbook workbookforref = new XSSFWorkbook();
			XSSFSheet prodsheetforref = workbookforref.createSheet("Production Results");
			UtilLib.PlainOfCopyContentsOfExcel(workbookforref, prodsheetforref,prodsheet);
			File Prodfilefolder = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder);
			Prodfilefolder.mkdir();
			System.out.println("Creating new file2");
			FileOutputStream outref=new FileOutputStream(new File(Prodfilefolder+"\\"+prodFileName));
			workbookforref.write(outref);
			out.close();
			//System.out.println("Created the new file");

			if (VarianceExists==0){
				 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches", " ");
				 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
				 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",ComponentType,filePath,PeriodId,"Prod Query: "+ProdQuery+newline+"Stage Query: "+StageQuery,dateStart,ViewName);
				}
			else {
				UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
				UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
				UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",ComponentType,filePath,PeriodId,"Prod Query: "+ProdQuery+newline+"Stage Query: "+StageQuery,dateStart,ViewName);
				Assert.fail("The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");

			}

		}
		catch (Exception e){
			e.printStackTrace();
		}


		}

		/********************************************************************************************
		 * @author vinod.adm
		 * @Function_Name :  AEORAEnvironmentValidation
		 * @Description : Check if Production file is already there if exists refer that else fetch
		 * details from teradata prod and compare it against stage
		 **********************************************************************************************/
		@SuppressWarnings("resource")
		public static void ORAEnvironmentValidation(String connurlprod, String unameprod, String pwordprod,String ProdQuery,String connurlstg, String unamestg, String pwordstg,String StageQuery, String TestCaseName, String PeriodIdType,String ViewName){
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			//String PeriodIdType=PeriodsIdType.replaceAll("BWPeriodId", "INPeriodId");
			String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			prodFileName=prodFileName.replaceAll(",", "-");
			String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			prodTestCaseFolder=prodTestCaseFolder.replaceAll(",", "-");
			String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			File prodFile = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder+"\\"+prodFileName);
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);

			String ComponentTypeBWC=PeriodIdType.replaceAll("BWPeriodID", "");
			String ComponentTypeBWCU=ComponentTypeBWC.replaceAll("_BWPeriodID", "");
			String ComponentTypeINC=ComponentTypeBWCU.replaceAll("INPeriodID", "");
			String ComponentTypeBW=ComponentTypeINC.replaceAll("BWPeriodId", "");
			String ComponentType=ComponentTypeBW.replaceAll("INPeriodId", "");
			//System.out.println("The component type is: "+ComponentType);
			String PeriodId=UtilLib.getParam(PeriodIdType);
			//System.out.println("Prod file path: "+prodFile);
			if (prodFile.exists())
			{
				//System.out.println("File already exists: " +prodFile);
				try{
				XSSFWorkbook workbook = new XSSFWorkbook();
				FileInputStream existingProdInput = new FileInputStream(prodFile);
				XSSFWorkbook existingProdWorkBook = new XSSFWorkbook(existingProdInput);
				XSSFSheet existingprodsheet = existingProdWorkBook.getSheet("Production Results");
				XSSFSheet prodsheet = workbook.createSheet("Production Results");
				UtilLib.PlainOfCopyContentsOfExcel(workbook, prodsheet,existingprodsheet);
				XSSFSheet stgsheet = workbook.createSheet("Stage Results");
				UtilLib.OracleResultSetToExcel(connurlstg,unamestg,pwordstg,StageQuery,workbook,stgsheet,TestCaseName,"Stage",PeriodIdType,ViewName);
				XSSFSheet variancesheet = workbook.createSheet("Variance");
				UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
				UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
				VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stgsheet, ProdQuery/*+newline+StageQuery*/);
				/*for (int i=1;i<100;i++){
							variancesheet.autoSizeColumn(i);
							prodsheet.autoSizeColumn(i);
							stgsheet.autoSizeColumn(i);
						}*/


						FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
						workbook.write(out);
						out.close();

						if (VarianceExists==0){
							 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches ", " ");
							 UtilLib.LogReport(TestCaseName, "The queries: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
							 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",ComponentType,filePath,PeriodId,ProdQuery,dateStart,ViewName);
							}
						else {
							UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
							UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
							UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",ComponentType,filePath,PeriodId,ProdQuery,dateStart,ViewName);
							Assert.fail("The query for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
						}

				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
			else {
				POM_Lib.ValidateDataOracle(connurlprod,unameprod,pwordprod, ProdQuery,connurlstg,unamestg, pwordstg,StageQuery, TestCaseName, PeriodIdType,ViewName);
			}
		}



		/********************************************************************************************
		 * @author vinod.adm
		 * @Function_Name :  ValidateDataOracle
		 * @Description : Login to teradata and execute given query

		 **********************************************************************************************/
		public static void ValidateDataOracle(String connurlprod, String unameprod, String pwordprod,String ProdQuery,String connurlstg, String unamestg, String pwordstg,String StageQuery, String TestCaseName, String PeriodIdType,String ViewName){
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			prodFileName=prodFileName.replaceAll(",", "-");
			String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			prodTestCaseFolder=prodTestCaseFolder.replaceAll(",", "-");
			String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);

			String ComponentTypeBWC=PeriodIdType.replaceAll("BWPeriodID", "");
			String ComponentTypeBWCU=ComponentTypeBWC.replaceAll("_BWPeriodID", "");
			String ComponentTypeINC=ComponentTypeBWCU.replaceAll("INPeriodID", "");
			String ComponentTypeBW=ComponentTypeINC.replaceAll("BWPeriodId", "");
			String ComponentType=ComponentTypeBW.replaceAll("INPeriodId", "");
			String PeriodId=UtilLib.getParam(PeriodIdType);

		try{
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet prodsheet = workbook.createSheet("Production Results");
			UtilLib.OracleResultSetToExcel(connurlprod,unameprod,pwordprod,ProdQuery,workbook,prodsheet,TestCaseName, "PRODUCTION",PeriodIdType, ViewName);
			XSSFSheet stgsheet = workbook.createSheet("Stage Results");
			UtilLib.OracleResultSetToExcel(connurlstg,unamestg,pwordstg,StageQuery,workbook,stgsheet,TestCaseName,"Stage",PeriodIdType,ViewName);
			XSSFSheet variancesheet = workbook.createSheet("Variance");
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
			VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stgsheet, ProdQuery/*+newline+StageQuery*/);

			for (int i=1;i<100;i++){
				variancesheet.autoSizeColumn(i);
				prodsheet.autoSizeColumn(i);
				stgsheet.autoSizeColumn(i);
			}


			FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
			workbook.write(out);
			out.close();
			//System.out.println("Creating new file");

			/* Save the production file for future reference*/
			XSSFWorkbook workbookforref = new XSSFWorkbook();
			XSSFSheet prodsheetforref = workbookforref.createSheet("Production Results");
			UtilLib.PlainOfCopyContentsOfExcel(workbookforref, prodsheetforref,prodsheet);
			File Prodfilefolder = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder);
			Prodfilefolder.mkdir();
			//System.out.println("Creating new file2");
			FileOutputStream outref=new FileOutputStream(new File(Prodfilefolder+"\\"+prodFileName));
			workbookforref.write(outref);
			out.close();
			//System.out.println("Created the new file");

			if (VarianceExists==0){
				 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches", " ");
				 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
				 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",ComponentType,filePath,PeriodId,ProdQuery,dateStart,ViewName);
				}
			else {
				UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
				UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
				UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",ComponentType,filePath,PeriodId,ProdQuery,dateStart,ViewName);
				Assert.fail("The query: "+newline+newline+"\""+ProdQuery+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");

			}

		}
		catch (Exception e){
			e.printStackTrace();
		}


		}



		/**/
		/********************************************************************************************
		 * @Function_Name :  Teradata_Oracle_Data_Validation
		 * @author vinod.adm
		 * @Description : Data validations between Teradata and Oracle

		 **********************************************************************************************/
		public static void ValidateDataTeradataOracle(String TDconnurl, String TDuname, String TDpword,String TDQuery,String ORAconnurl, String ORAuname, String ORApword,String ORAQuery, String TestCaseName, String PeriodIdType,String ViewName){
			int VarianceExists;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			//String prodFileName=TestCaseName+"_"+(UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+",""))+".xls";
			//String prodTestCaseFolder=TestCaseName+"_"+UtilLib.getParam(PeriodIdType).trim().replaceAll("\\s+","");
			//String ProdBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String filePath=(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName);
			/*String ComponentTypeBW=PeriodIdType.replaceAll("BWPeriodId", "");
			String ComponentType=ComponentTypeBW.replaceAll("INPeriodID", "");*/
			String ComponentType="AE_TD_ORACLE_CommonLayer";
			String PeriodId=UtilLib.getParam(PeriodIdType);

		try{
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet prodsheet = workbook.createSheet("Teradata Results");
			UtilLib.TeradataResultSetToExcel(TDconnurl,TDuname,TDpword,TDQuery,workbook,prodsheet,TestCaseName, "Teradata",PeriodIdType,ViewName);
			XSSFSheet stgsheet = workbook.createSheet("Oracle Results");
			UtilLib.OracleResultSetToExcel(ORAconnurl,ORAuname,ORApword,ORAQuery,workbook,stgsheet,TestCaseName,"Oracle",PeriodIdType,ViewName);
			XSSFSheet variancesheet = workbook.createSheet("Variance");
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
			UtilLib.CopyContentsOfExcel(workbook, variancesheet,stgsheet);
			VarianceExists=UtilLib.CompareExcelSheetsForVarianceExact(workbook, variancesheet,prodsheet, stgsheet, TDQuery+newline+ORAQuery);

			for (int i=1;i<100;i++){
				variancesheet.autoSizeColumn(i);
				prodsheet.autoSizeColumn(i);
				stgsheet.autoSizeColumn(i);
			}


			FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
			workbook.write(out);
			out.close();
			//System.out.println("Creating new file");

			/* Save the production file for future reference*/
			/*HSSFWorkbook workbookforref = new HSSFWorkbook();
			HSSFSheet prodsheetforref = workbookforref.createSheet("Production Results");
			UtilLib.PlainOfCopyContentsOfExcel(workbookforref, prodsheetforref,prodsheet);
			File Prodfilefolder = new File(ProdBaseLineFolderName+"\\"+prodTestCaseFolder);
			Prodfilefolder.mkdir();
			//System.out.println("Creating new file2");
			FileOutputStream outref=new FileOutputStream(new File(Prodfilefolder+"\\"+prodFileName));
			workbookforref.write(outref);
			out.close();*/
			//System.out.println("Created the new file");

			if (VarianceExists==0){
				 UtilLib.Report_PASS(TestCaseName, "The data between Teradata and Oracle matches", " ");
				 //UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+TDQuery+newline+ORAQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between Teradata and Oracle");
				 UtilLib.LogExcelReport(TestCaseName, "The data between Teradata and Oracle matches", "PASSED",ComponentType,filePath,PeriodId,"Prod Query: "+TDQuery+newline+"Stage Query: "+ORAQuery,dateStart,ViewName);
				}
			else {
				UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
				//UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+TDQuery+newline+ORAQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between Teradata and Oracle");
				UtilLib.LogExcelReport(TestCaseName, "The data between Teradata and Oracle does not match!", "FAILED",ComponentType,filePath,PeriodId,"Prod Query: "+TDQuery+newline+"Stage Query: "+ORAQuery,dateStart,ViewName);
				Assert.fail("The query: "+newline+newline+"\""+TDQuery+newline+ORAQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between Teradata and Oracle");

			}

		}
		catch (Exception e){
			e.printStackTrace();
		}
		}

		/*public static void EnvironmentValidationFact(String connurlprod, String unameprod, String pwordprod,String ProdQuery,String connurlstg, String unamestg, String pwordstg,String StageQuery, String TestCaseName, String PeriodIdType,String ViewName, String FactLoadFlag, String SnapshotPeriodID, String SnapshotNumOfMonths, String TrackName) throws IOException, SQLException, ClassNotFoundException{
			 String str=connurlstg;
			 String DbEnv= str.substring(str.length() - 3);
			 System.out.println("DbEnv : "+DbEnv);
			int SnapshotMonths=Integer.parseInt(SnapshotNumOfMonths);
			int VarianceExists=0;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String stageFileName=TestCaseName+".xls";
			String stageBaseLineFolderName=UtilLib.getEnvVar("StageBaseLineFolderName");
			File stageFile = new File(stageBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"//"+stageFileName);
			String prodFileName=TestCaseName+".xls";
			String prodBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			File prodFile = new File(prodBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"//"+prodFileName);
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String CompTypeBW=PeriodIdType.replaceAll("BWPeriodId", "");
			String CompType=CompTypeBW.replaceAll("INPeriodID", "");
			String PeriodId=UtilLib.getUpdatedParam(PeriodIdType);
			String PeriodId1=UtilLib.getUpdatedParam(PeriodIdType);
			System.out.println("PeriodId1 : "+PeriodId1);
			//String PeriodIdValue="";
			int cellContent;
			String Envi="Stage";
			String Envi1="Prod";
			String PeriodParameter="@"+PeriodIdType+"@";
			//System.out.println("PeriodParameter : "+PeriodParameter);

			Required to saave Fact_validation file
            int len=TrackName.length()+2;
            String OutputPath=UtilLib.getEnvVar(PeriodIdType);
            String OPath=OutputPath.substring(0, OutputPath.length() -len);
            String ValidationPath=OPath+DbEnv+"\\"+TrackName+"\\";
            String filePath=ValidationPath+TestCaseName+"_"+fileName;

            Initialization of Fact_validation workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet prodsheet = workbook.createSheet("Production Results");
			HSSFSheet stgsheet = workbook.createSheet("Stage Results");
			HSSFSheet variancesheet1 = workbook.createSheet("Snapshot Variance");
			HSSFSheet variancesheet = workbook.createSheet("PeriodID Variance");

			To copy stage data from teraData to the stageBaseline excel sheet
			System.out.println("Trying to connect to: "+connurlstg);
			try {
			Class.forName("com.teradata.jdbc.TeraDriver");
			Connection conn=DriverManager.getConnection(connurlstg, unamestg, pwordstg);
			PreparedStatement stmt=conn.prepareStatement(StageQuery);
			stmt.setQueryTimeout(600);
			System.out.println("Connected to Teradata...");
			ResultSet rs=stmt.executeQuery();
			System.out.println("Query Executed in Teradata..."+StageQuery);
			 if (!rs.isBeforeFirst() ) {
			                 System.out.println("Result Set is empty in "+Envi);
                 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", " ");
                 //UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
                 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,StageQuery,dateStart,ViewName);
                 Assert.fail("The query: "+newline+newline+"\""+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
                 }

			 FileInputStream existProdInput = new FileInputStream(stageFile);
				HSSFWorkbook existProdWorkBook = new HSSFWorkbook(existProdInput);
				HSSFSheet existstgsheet = existProdWorkBook.getSheet("Stage Results");

			 while (rs.next()){
				 cellContent=Integer.parseInt(rs.getString(1));
				//System.out.println("Cell Content: "+cellContent);
				 UtilLib.UpdateTeradataResultToExcelForFacts(rs, cellContent, existstgsheet);
			 }
			 UtilLib.PlainOfCopyContentsOfExcelForFacts(workbook, stgsheet,existstgsheet);
			 FileOutputStream out=new FileOutputStream(new File(stageBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"\\"+stageFileName));
	  			existProdWorkBook.write(out);
				out.close();
				existProdWorkBook.close();


			 }catch(Exception e){
				 e.printStackTrace();
			}catch(SQLException e){
			       if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
				          Check Teradata exception.
				         int TeradataCode = e.getErrorCode();  Get specific error.
				         if (TeradataCode!=0){
				        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,StageQuery,dateStart,ViewName);
						     Assert.fail("Query has failed to execute");
				        					         }
				       }
			}

			To copy Prod data from teraData to the ProdBaseline excel sheet when the LoadFlag= 'Y'
		try {
			String OProdQuery=null;
			if (FactLoadFlag.equals("Y")){

				System.out.println("Trying to connect to: "+connurlprod);
				String ProdQueryP=ProdQuery.replaceAll(PeriodParameter, UtilLib.getUpdatedParam(PeriodIdType));
				System.out.println("ProdQueryP first : "+ProdQueryP);
				Class.forName("com.teradata.jdbc.TeraDriver");
				System.out.println("After class.forName");
				Connection conn=DriverManager.getConnection(connurlprod,unameprod,pwordprod);
				System.out.println("After conn");
				System.out.println("ProdQueryP : "+ProdQueryP);
				PreparedStatement stmt=conn.prepareStatement(ProdQueryP);
				stmt.setQueryTimeout(600);
				System.out.println("Connected to Teradata...");
				ResultSet rs=stmt.executeQuery();
				System.out.println("Query Executed in Teradata...");
				 if (!rs.isBeforeFirst() ) {
	                 System.out.println("Result Set is empty in "+Envi1);
	                 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", " ");
	                 //UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
	                 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,ProdQueryP,dateStart,ViewName);
	                 Assert.fail("The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
	                 }
				 OProdQuery=ProdQueryP;
				 FileInputStream existProdInput = new FileInputStream(prodFile);
					@SuppressWarnings("resource")
					HSSFWorkbook existProdWorkBook = new HSSFWorkbook(existProdInput);
					HSSFSheet existprodsheet = existProdWorkBook.getSheet("Prod Results");

				 while (rs.next()){
					 cellContent=Integer.parseInt(rs.getString(1));
					 UtilLib.UpdateTeradataResultToExcelForFacts(rs, cellContent, existprodsheet);
				 }
					UtilLib.PlainOfCopyContentsOfExcelForFacts(workbook, prodsheet,existprodsheet);
				 FileOutputStream out=new FileOutputStream(new File(prodBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"\\"+prodFileName));
		  			existProdWorkBook.write(out);
			}
			To copy Prod data from teraData to the stageBaseline excel sheet when the LoadFlag= 'N'
			else if (FactLoadFlag.equals("N")){
			 	FileInputStream existProdInput = new FileInputStream(prodFile);
				HSSFWorkbook existProdWorkBook = new HSSFWorkbook(existProdInput);
				HSSFSheet existprodsheet = existProdWorkBook.getSheet("Prod Results");
				HSSFSheet variancesheet2=existProdWorkBook.getSheet("Variance");
				String months =PeriodId;
				//System.out.println("PeriodId N :"+PeriodId);
				//	System.out.println("months N : "+months);

				ArrayList  monthListString= new ArrayList(Arrays.asList(months.split(",")));
				ArrayList<Integer>  monthList= new ArrayList<>();
				ArrayList<Integer>  monthListNew= new ArrayList<>();

				for (int j=0;j<monthListString.size();j++){
					monthList.add(Integer.parseInt((String) monthListString.get(j)));
				}

				ArrayList<Integer> monthsInExcel= new ArrayList<>();
				int monthnew=0, month=0;
				monthsInExcel=UtilLib.ProdFactsExistTrial(existprodsheet,monthsInExcel);

				for(int i=0;i<monthList.size();i++){
					if(monthsInExcel.contains(monthList.get(i))==true){
					}
					else{
						monthListNew.add(monthList.get(i));
					}
				}
				//System.out.println("New array list is: "+monthListNew);

					 Convert ArrayList to String
					 String csv = monthListNew.toString().replace("[", "").replace("]", "").replace(", ", ",");
					 PeriodId=csv;
					 System.out.println("New Period Id : " +PeriodId);

					 Execution of production Query
					 //	System.out.println("ProdQueryP Before : "+ProdQuery);
				 		String ProdQueryP=ProdQuery.replaceAll("@"+PeriodIdType+"@",PeriodId);
				 		System.out.println("ProdQueryP : "+ProdQueryP);

						if(monthListNew.size()==0){
						}else{
					System.out.println("Trying to connect to: "+connurlprod);
					Class.forName("com.teradata.jdbc.TeraDriver");
					Connection conn=DriverManager.getConnection(connurlprod, unameprod, pwordprod);
					PreparedStatement stmt=conn.prepareStatement(ProdQueryP);
					stmt.setQueryTimeout(600);
					System.out.println("Connected to Teradata...");
					ResultSet rs=stmt.executeQuery();
					System.out.println("Query Executed in Teradata...");
					 if (!rs.isBeforeFirst() ) {
		                 System.out.println("Result Set is empty in "+Envi1);
		                 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", " ");
		                // UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
		                 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,ProdQueryP,dateStart,ViewName);
		                 Assert.fail("The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
		                 }
					 FileInputStream existProdInput1 = new FileInputStream(prodFile);
						@SuppressWarnings("unused")
						HSSFWorkbook existProdWorkBook1 = new HSSFWorkbook(existProdInput1);
						HSSFSheet existprodsheet1 = existProdWorkBook.getSheet("Prod Results");

					 while (rs.next()){
						 cellContent=Integer.parseInt(rs.getString(1));
					//	 System.out.println("Cell Content: "+cellContent);
						 UtilLib.AppenedTeradataResultToExcelForFacts(rs, cellContent, existprodsheet1);
					 }
						}
						UtilLib.PlainOfCopyContentsOfExcelForFacts(workbook, prodsheet,existprodsheet);

					 FileOutputStream out=new FileOutputStream(new File(prodBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"\\"+prodFileName));
			  			existProdWorkBook.write(out);
			 }
			To copy Prod data to PeriodID variance sheet
			Prod Header copy
			int rownum=0;
			System.out.println("Prod Header copy");
			variancesheet.createRow(rownum).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
			UtilLib.HeaderCopy(workbook,prodsheet,variancesheet,rownum);
			Prod Data copy
			System.out.println("Prod Data copy");
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList ProdmonthListToCopy= new ArrayList(Arrays.asList(PeriodId1.split(",")));
			for(int i=1; i<=ProdmonthListToCopy.size();i++){
				int MonthToCopy=Integer.parseInt((String)ProdmonthListToCopy.get(i-1));
				System.out.println("MonthToCopy : "+MonthToCopy);
				//int ProdStartingRow=3;
				System.out.println("ProdmonthListToCopy : "+ProdmonthListToCopy.get(i-1));
				int numberOfRows=ProdmonthListToCopy.size();
				System.out.println("numberOfRows : "+numberOfRows);
				int ProdStartingRow = (int)(variancesheet.getLastRowNum()+1);
				System.out.println("ProdStartingRow : "+ProdStartingRow);
				UtilLib.SelectiveDataCopy(workbook,prodsheet,variancesheet,ProdStartingRow,MonthToCopy,numberOfRows);
			}
			Stage Header copy
			System.out.println("Stage Header copy");
			//int StageStartingRowHeader= ProdmonthListToCopy.size()+2;
			int row = (int)(variancesheet.getLastRowNum()+2);
			variancesheet.createRow(row).createCell(0).setCellValue(stgsheet.getSheetName().toUpperCase());
			int StageStartingRowHeader= (int)(variancesheet.getLastRowNum());
			UtilLib.HeaderCopy(workbook,stgsheet,variancesheet,StageStartingRowHeader);

			Stage Data copy
			System.out.println("Stage Data copy");
				for(int i=1; i<=ProdmonthListToCopy.size();i++){
				int MonthToCopy=Integer.parseInt((String)ProdmonthListToCopy.get(i-1));
				//int StageStartingRow=StageStartingRowHeader+1;
				int numberOfRows=ProdmonthListToCopy.size();
				System.out.println("numberOfRows in stage :"+numberOfRows);
				int StageStartingRow= (int)(variancesheet.getLastRowNum()+1);
				System.out.println("StageStartingRow : "+StageStartingRow);
				UtilLib.SelectiveDataCopy(workbook,stgsheet,variancesheet,StageStartingRow,MonthToCopy,numberOfRows);

				}
			---------------------------------------------------------------------------------------------------

			To copy Stage data to Snapshot variance sheet
			Header copy
				int rownum1=0;
				System.out.println("Prod Header copy");
				variancesheet1.createRow(rownum1).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
				UtilLib.HeaderCopy(workbook,prodsheet,variancesheet1,rownum1);
				Prod Data copy
				System.out.println("Stage Data copy in snapshot");
				@SuppressWarnings("unchecked")

				 Snapshot Month List
				ArrayList ProdmonthListToCopy1= new ArrayList(Arrays.asList(PeriodId1.split(",")));
				int numberOfRows=Integer.parseInt(SnapshotNumOfMonths);
				int MonthToCopy=Integer.parseInt(SnapshotPeriodID);
				  int p=1;

				ArrayList<Integer> SnapshotMonthListToBeCopied=new <Integer>ArrayList();
				SnapshotMonthListToBeCopied.add(MonthToCopy);
				  for(int i=0;i<=(numberOfRows-2);i++){
					  int temp = Integer.parseInt(String.valueOf(MonthToCopy).substring(4));
				  if(temp>=01 && temp<=11){
					  MonthToCopy=MonthToCopy+1;
					SnapshotMonthListToBeCopied.add(MonthToCopy);
				  }
				  else if(temp>11){
					  MonthToCopy=MonthToCopy+89;
					  SnapshotMonthListToBeCopied.add(MonthToCopy);
					  //temp = Integer.parseInt(String.valueOf(MonthToCopy).substring(4));
				  }
				  }

				  for(int i=1; i<=SnapshotMonthListToBeCopied.size();i++){
					//int ProdStartingRow=3;
					int ProdStartingRow = (int)(variancesheet1.getLastRowNum()+1);
					MonthToCopy=SnapshotMonthListToBeCopied.get(i-p);
					UtilLib.SelectiveDataCopy(workbook,prodsheet,variancesheet1,ProdStartingRow,MonthToCopy,numberOfRows);
				}
				Stage Header copy
				System.out.println("Stage Header copy");
				//int StageStartingRowHeader= ProdmonthListToCopy.size()+2;
				int row2 = (int)(variancesheet1.getLastRowNum()+2);
				variancesheet1.createRow(row2).createCell(0).setCellValue(stgsheet.getSheetName().toUpperCase());
				int StageStartingRowHeader1= (int)(variancesheet1.getLastRowNum());
				UtilLib.HeaderCopy(workbook,prodsheet,variancesheet1,StageStartingRowHeader1);

				Stage Data copy
				System.out.println("Stage Data copy");

					for(int i=1; i<=SnapshotMonthListToBeCopied.size();i++){
						int StageStartingRow= (int)(variancesheet1.getLastRowNum()+1);
						MonthToCopy=SnapshotMonthListToBeCopied.get(i-p);
					UtilLib.SelectiveDataCopy(workbook,stgsheet,variancesheet1,StageStartingRow,MonthToCopy,numberOfRows);
					}

					Variance compare for PeriodID sheet
					String months =PeriodId;
					ArrayList NumberOfLines= new ArrayList(Arrays.asList(PeriodId1.split(",")));

					int pRow=2;
					int sRow=pRow+NumberOfLines.size()+3;
					int VariacneStartingRow2 = (int)(variancesheet.getLastRowNum()+2);
					 variancesheet.createRow(VariacneStartingRow2).createCell(0).setCellValue(variancesheet.getSheetName().toUpperCase());
					 int VariacneStartingRow3 = (int)(variancesheet.getLastRowNum());
					 UtilLib.HeaderCopy(workbook,prodsheet,variancesheet,VariacneStartingRow3);
					// System.out.println("pRowpRow : "+pRow);
				//	 System.out.println("sRowsRow : "+sRow);
				//	 System.out.println("VariacneStartingRow3VariacneStartingRow3 : "+VariacneStartingRow3);
					for(int i=1; i<=NumberOfLines.size(); i++){
					VarianceExists= UtilLib.VarianceForFacts(workbook, variancesheet, pRow, sRow);
					System.out.println("VarianceExists : "+VarianceExists);
					pRow++;
					sRow++;
					}

					for (int i=1;i<100;i++){
						variancesheet.autoSizeColumn(i);
						prodsheet.autoSizeColumn(i);
						stgsheet.autoSizeColumn(i);
					}

					Variance compare for SnapshorID sheet
					int VarianceExists1=0;
					int numOfRows=Integer.parseInt(SnapshotNumOfMonths);
					int pRow1=2;
					int sRow1=pRow1+numOfRows+3;
					int VariacneStartingRow = (int)(variancesheet1.getLastRowNum()+2);
					 variancesheet1.createRow(VariacneStartingRow).createCell(0).setCellValue(variancesheet1.getSheetName().toUpperCase());
					 int VariacneStartingRow1 = (int)(variancesheet1.getLastRowNum());
					 UtilLib.HeaderCopy(workbook,prodsheet,variancesheet1,VariacneStartingRow1);
					for(int i=1; i<=numOfRows; i++){
						VarianceExists1=UtilLib.VarianceForFacts(workbook, variancesheet1, pRow1, sRow1);
						int temp1 = Integer.parseInt(String.valueOf(MonthToCopy).substring(4));
						  pRow1++;
						  sRow1++;
					}
					To copy Stage and Prod Query to the PeriodID variance sheet
					HSSFFont boldFont = workbook.createFont();
					boldFont.setFontHeightInPoints((short)12);
					boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					HSSFCellStyle boldStyle = workbook.createCellStyle();
					boldStyle.setFont(boldFont);
					int SQueryRow = variancesheet.getLastRowNum()+2;
					HSSFRow row1 = variancesheet.createRow(SQueryRow);
                    HSSFCell cell1 = row1.createCell(1);
                    cell1.setCellValue("Stage Query");
                    cell1.setCellStyle(boldStyle);
                    row1.createCell(2).setCellValue(StageQuery);
                    int PQueryRow=SQueryRow+2;
					HSSFRow rowp = variancesheet.createRow(PQueryRow);
                    HSSFCell cell2 = rowp.createCell(1);
                    cell2.setCellValue("Prod Query");
                    cell2.setCellStyle(boldStyle);
                    System.out.println("OProdQuery :"+OProdQuery);
                    rowp.createCell(2).setCellValue(ProdQuery);
                    if (FactLoadFlag.equals("Y")){
                    rowp.createCell(2).setCellValue(ProdQuery);
                    }else
                    	if (FactLoadFlag.equals("N")){
                    	rowp.createCell(2).setCellValue(OProdQuery);
                    	}

			FileOutputStream Resout1=new FileOutputStream(new File(ValidationPath+TestCaseName+"_"+fileName));
			//FileOutputStream Resout1=new FileOutputStream(new File(OPath+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"_"+fileName));
                //    FileOutputStream Resout1=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
			//System.out.println("UtilLib.getEnvVar(PeriodIdType : "+UtilLib.getEnvVar(PeriodIdType));
		//	System.out.println("TestCaseName : "+TestCaseName);
		//	System.out.println("fileName : "+fileName);

			workbook.write(Resout1);
			Resout1.close();

			System.out.println("VarianceExistsVarianceExists : "+VarianceExists);
			 System.out.println("filePath : "+filePath);
			if (VarianceExists==0){
				 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches ", " ");
				 //UtilLib.LogReport(TestCaseName, "The queries: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
				 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED"+" in "+DbEnv,TrackName,filePath,PeriodId1,StageQuery,dateStart,ViewName);
				}
			else {
				UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
				//UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
				UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED"+" in "+DbEnv,TrackName,filePath,PeriodId1,StageQuery,dateStart,ViewName);
				Assert.fail("The query: "+newline+newline+"\""+StageQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
			}

		}catch (SQLException e) {
		       if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
			          Check Teradata exception.
			         int TeradataCode = e.getErrorCode();  Get specific error.
			         if (TeradataCode!=0){
			        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId1,StageQuery,dateStart,ViewName);
					     Assert.fail("Query has failed to execute");
			        					         }
			       }
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
}	*/

		public static void EnvironmentValidationFact(String connurlprod, String unameprod, String pwordprod,String ProdQuery,String connurlstg, String unamestg, String pwordstg,String StageQuery, String TestCaseName, String PeriodIdType,String ViewName, String FactLoadFlag, String SnapshotPeriodID, String SnapshotNumOfMonths, String TrackName) throws IOException, SQLException, ClassNotFoundException{
			 String str=connurlstg;
			 String DbEnv= str.substring(str.length() - 3);
			 System.out.println("DbEnv : "+DbEnv);
			int SnapshotMonths=Integer.parseInt(SnapshotNumOfMonths);
			int VarianceExists=0;
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String stageFileName=TestCaseName+".xls";
			String stageBaseLineFolderName=UtilLib.getEnvVar("StageBaseLineFolderName");
			File stageFile = new File(stageBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"//"+stageFileName);
			String prodFileName=TestCaseName+".xls";
			String prodBaseLineFolderName=UtilLib.getEnvVar("ProdBaseLineFolderName");
			File prodFile = new File(prodBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"//"+prodFileName);
			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
			String CompTypeBW=PeriodIdType.replaceAll("BWPeriodId", "");
			String CompType=CompTypeBW.replaceAll("INPeriodID", "");
			String PeriodId=UtilLib.getUpdatedParam(PeriodIdType);
			String PeriodId1=UtilLib.getUpdatedParam(PeriodIdType);
			//System.out.println("PeriodId1 : "+PeriodId1);
			//String PeriodIdValue="";
			int cellContent;
			String Envi="Stage";
			String Envi1="Prod";
			String PeriodParameter="@"+PeriodIdType+"@";
			//System.out.println("PeriodParameter : "+PeriodParameter);

			/*Required to saave Fact_validation file*/
           int len=TrackName.length()+2;
           String OutputPath=UtilLib.getEnvVar(PeriodIdType);
           String OPath=OutputPath.substring(0, OutputPath.length() -len);
           //System.out.println("OPath is:"+OPath);
           String ValidationPath=OPath+DbEnv+"\\"+TrackName+"\\";
           String filePath=ValidationPath+TestCaseName+"_"+fileName;
           //String filePath=UtilLib.getEnvVar(PeriodIdType.replaceAll("INPeriodId", "").replaceAll("BWPeriodId", ""))+TestCaseName+"_"+fileName;
           //System.out.println("FIlepath is "+filePath);

           /*Initialization of Fact_validation workbook*/
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet prodsheet = workbook.createSheet("Production Results");
			HSSFSheet stgsheet = workbook.createSheet("Stage Results");
			HSSFSheet variancesheet1 = workbook.createSheet("Snapshot Variance");
			HSSFSheet variancesheet = workbook.createSheet("PeriodID Variance");

			/*To copy stage data from teraData to the stageBaseline excel sheet */
			System.out.println("Trying to connect to: "+connurlstg);
			try {
			Class.forName("com.teradata.jdbc.TeraDriver");
			Connection conn=DriverManager.getConnection(connurlstg, unamestg, pwordstg);
			PreparedStatement stmt=conn.prepareStatement(StageQuery);
			stmt.setQueryTimeout(600);
			System.out.println("Connected to Teradata...");
			ResultSet rs=stmt.executeQuery();
			System.out.println("Query Executed in Teradata..."+StageQuery);
			 if (!rs.isBeforeFirst() ) {
			                 System.out.println("Result Set is empty in "+Envi);
                UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", " ");
                UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
                UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,StageQuery,dateStart,ViewName);
               // Assert.fail("The query: "+newline+newline+"\""+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
                }

			 FileInputStream existProdInput = new FileInputStream(stageFile);
				HSSFWorkbook existProdWorkBook = new HSSFWorkbook(existProdInput);
				HSSFSheet existstgsheet = existProdWorkBook.getSheet("Stage Results");

			 while (rs.next()){
				 cellContent=Integer.parseInt(rs.getString(1));
				//System.out.println("Cell Content: "+cellContent);
				 UtilLib.UpdateTeradataResultToExcelForFacts(rs, cellContent, existstgsheet);
			 }
			 UtilLib.PlainOfCopyContentsOfExcelForFacts(workbook, stgsheet,existstgsheet);
			 FileOutputStream out=new FileOutputStream(new File(stageBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"\\"+stageFileName));
	  			existProdWorkBook.write(out);
				out.close();
				existProdWorkBook.close();


			 /*}catch(Exception e){
				 e.printStackTrace();*/
			}catch(SQLException e){
			       if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
				          /*Check Teradata exception.*/
				         int TeradataCode = e.getErrorCode();  /*Get specific error.*/
				         if (TeradataCode!=0){
				        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,StageQuery,dateStart,ViewName);
						     //Assert.fail("Query has failed to execute");
				        					         }
				       }
			}

			/*To copy Prod data from teraData to the ProdBaseline excel sheet when the LoadFlag= 'Y' */
		try {
			String OProdQuery=null;
			if (FactLoadFlag.equals("Y")){

				System.out.println("Trying to connect to: "+connurlprod);
				String ProdQueryP=ProdQuery.replaceAll(PeriodParameter, UtilLib.getUpdatedParam(PeriodIdType));
				System.out.println("ProdQueryP first : "+ProdQueryP);
				Class.forName("com.teradata.jdbc.TeraDriver");
				System.out.println("After class.forName");
				Connection conn=DriverManager.getConnection(connurlprod,unameprod,pwordprod);
				System.out.println("After conn");
				System.out.println("ProdQueryP : "+ProdQueryP);
				PreparedStatement stmt=conn.prepareStatement(ProdQueryP);
				stmt.setQueryTimeout(600);
				System.out.println("Connected to Teradata...");
				ResultSet rs=stmt.executeQuery();
				System.out.println("Query Executed in Teradata...");
				 if (!rs.isBeforeFirst() ) {
	                 System.out.println("Result Set is empty in "+Envi1);
	                 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", " ");
	                 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
	                 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,ProdQueryP,dateStart,ViewName);
	                 //Assert.fail("The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
	                 }
				 OProdQuery=ProdQueryP;
				 FileInputStream existProdInput = new FileInputStream(prodFile);
					@SuppressWarnings("resource")
					HSSFWorkbook existProdWorkBook = new HSSFWorkbook(existProdInput);
					HSSFSheet existprodsheet = existProdWorkBook.getSheet("Prod Results");

				 while (rs.next()){
					 cellContent=Integer.parseInt(rs.getString(1));
					 UtilLib.UpdateTeradataResultToExcelForFacts(rs, cellContent, existprodsheet);
				 }
					UtilLib.PlainOfCopyContentsOfExcelForFacts(workbook, prodsheet,existprodsheet);
				 FileOutputStream out=new FileOutputStream(new File(prodBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"\\"+prodFileName));
		  			existProdWorkBook.write(out);
			}
			/*To copy Prod data from teraData to the stageBaseline excel sheet when the LoadFlag= 'N'*/
			else if (FactLoadFlag.equals("N")){
			 	FileInputStream existProdInput = new FileInputStream(prodFile);
				HSSFWorkbook existProdWorkBook = new HSSFWorkbook(existProdInput);
				HSSFSheet existprodsheet = existProdWorkBook.getSheet("Prod Results");
				HSSFSheet variancesheet2=existProdWorkBook.getSheet("Variance");
				String months =PeriodId;
				//System.out.println("PeriodId N :"+PeriodId);
				//	System.out.println("months N : "+months);

				ArrayList  monthListString= new ArrayList(Arrays.asList(months.split(",")));
				ArrayList<Integer>  monthList= new ArrayList<>();
				ArrayList<Integer>  monthListNew= new ArrayList<>();

				for (int j=0;j<monthListString.size();j++){
					monthList.add(Integer.parseInt((String) monthListString.get(j)));
				}

				ArrayList<Integer> monthsInExcel= new ArrayList<>();
				int monthnew=0, month=0;
				monthsInExcel=UtilLib.ProdFactsExistTrial(existprodsheet,monthsInExcel);

				for(int i=0;i<monthList.size();i++){
					if(monthsInExcel.contains(monthList.get(i))==true){
					}
					else{
						monthListNew.add(monthList.get(i));
					}
				}
				//System.out.println("New array list is: "+monthListNew);

					 /*Convert ArrayList to String*/
					 String csv = monthListNew.toString().replace("[", "").replace("]", "").replace(", ", ",");
					 PeriodId=csv;
					 System.out.println("New Period Id : " +PeriodId);

					/* Execution of production Query */
					 //	System.out.println("ProdQueryP Before : "+ProdQuery);
				 		String ProdQueryP=ProdQuery.replaceAll("@"+PeriodIdType+"@",PeriodId);
				 		System.out.println("ProdQueryP : "+ProdQueryP);

						if(monthListNew.size()==0){
						}else{
					System.out.println("Trying to connect to: "+connurlprod);
					Class.forName("com.teradata.jdbc.TeraDriver");
					Connection conn=DriverManager.getConnection(connurlprod, unameprod, pwordprod);
					PreparedStatement stmt=conn.prepareStatement(ProdQueryP);
					stmt.setQueryTimeout(600);
					System.out.println("Connected to Teradata...");
					ResultSet rs=stmt.executeQuery();
					System.out.println("Query Executed in Teradata...");
					 if (!rs.isBeforeFirst() ) {
		                 System.out.println("Result Set is empty in "+Envi1);
		                 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", " ");
		                 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
		                 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi1+" Environment", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId,ProdQueryP,dateStart,ViewName);
		                 //Assert.fail("The query: "+newline+newline+"\""+ProdQueryP+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi1+" Environment");
		                 }
					 FileInputStream existProdInput1 = new FileInputStream(prodFile);
						@SuppressWarnings("unused")
						HSSFWorkbook existProdWorkBook1 = new HSSFWorkbook(existProdInput1);
						HSSFSheet existprodsheet1 = existProdWorkBook.getSheet("Prod Results");

					 while (rs.next()){
						 cellContent=Integer.parseInt(rs.getString(1));
					//	 System.out.println("Cell Content: "+cellContent);
						 UtilLib.AppenedTeradataResultToExcelForFacts(rs, cellContent, existprodsheet1);
					 }
						}
						UtilLib.PlainOfCopyContentsOfExcelForFacts(workbook, prodsheet,existprodsheet);

					 FileOutputStream out=new FileOutputStream(new File(prodBaseLineFolderName+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"\\"+prodFileName));
			  			existProdWorkBook.write(out);
			 }
			/*To copy Prod data to PeriodID variance sheet*/
			/*Prod Header copy*/
			int rownum=0;
			System.out.println("Prod Header copy");
			variancesheet.createRow(rownum).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
			UtilLib.HeaderCopy(workbook,prodsheet,variancesheet,rownum);
			/*Prod Data copy*/
			System.out.println("Prod Data copy");
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList ProdmonthListToCopy= new ArrayList(Arrays.asList(PeriodId1.split(",")));
			for(int i=1; i<=ProdmonthListToCopy.size();i++){
				int MonthToCopy=Integer.parseInt((String)ProdmonthListToCopy.get(i-1));
				System.out.println("MonthToCopy : "+MonthToCopy);
				//int ProdStartingRow=3;
				System.out.println("ProdmonthListToCopy : "+ProdmonthListToCopy.get(i-1));
				int numberOfRows=ProdmonthListToCopy.size();
				System.out.println("numberOfRows : "+numberOfRows);
				int ProdStartingRow = (int)(variancesheet.getLastRowNum()+1);
				System.out.println("ProdStartingRow : "+ProdStartingRow);
				UtilLib.SelectiveDataCopy(workbook,prodsheet,variancesheet,ProdStartingRow,MonthToCopy,numberOfRows);
			}
			/*Stage Header copy*/
			System.out.println("Stage Header copy");
			//int StageStartingRowHeader= ProdmonthListToCopy.size()+2;
			int row = (int)(variancesheet.getLastRowNum()+2);
			variancesheet.createRow(row).createCell(0).setCellValue(stgsheet.getSheetName().toUpperCase());
			int StageStartingRowHeader= (int)(variancesheet.getLastRowNum());
			UtilLib.HeaderCopy(workbook,stgsheet,variancesheet,StageStartingRowHeader);

			/*Stage Data copy*/
			System.out.println("Stage Data copy");
				for(int i=1; i<=ProdmonthListToCopy.size();i++){
				int MonthToCopy=Integer.parseInt((String)ProdmonthListToCopy.get(i-1));
				//int StageStartingRow=StageStartingRowHeader+1;
				int numberOfRows=ProdmonthListToCopy.size();
				System.out.println("numberOfRows in stage :"+numberOfRows);
				int StageStartingRow= (int)(variancesheet.getLastRowNum()+1);
				System.out.println("StageStartingRow : "+StageStartingRow);
				UtilLib.SelectiveDataCopy(workbook,stgsheet,variancesheet,StageStartingRow,MonthToCopy,numberOfRows);

				}
			/*---------------------------------------------------------------------------------------------------*/

			/*To copy Stage data to Snapshot variance sheet*/
			/*Header copy*/
				int rownum1=0;
				System.out.println("Prod Header copy");
				variancesheet1.createRow(rownum1).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
				UtilLib.HeaderCopy(workbook,prodsheet,variancesheet1,rownum1);
				/*Prod Data copy*/
				System.out.println("Stage Data copy in snapshot");
				@SuppressWarnings("unchecked")

				/* Snapshot Month List */
				ArrayList ProdmonthListToCopy1= new ArrayList(Arrays.asList(PeriodId1.split(",")));
				int numberOfRows=Integer.parseInt(SnapshotNumOfMonths);
				int MonthToCopy=Integer.parseInt(SnapshotPeriodID);
				  int p=1;

				ArrayList<Integer> SnapshotMonthListToBeCopied=new <Integer>ArrayList();
				SnapshotMonthListToBeCopied.add(MonthToCopy);
				  for(int i=0;i<=(numberOfRows-2);i++){
					  int temp = Integer.parseInt(String.valueOf(MonthToCopy).substring(4));
				  if(temp>=01 && temp<=11){
					  MonthToCopy=MonthToCopy+1;
					SnapshotMonthListToBeCopied.add(MonthToCopy);
				  }
				  else if(temp>11){
					  MonthToCopy=MonthToCopy+89;
					  SnapshotMonthListToBeCopied.add(MonthToCopy);
					  //temp = Integer.parseInt(String.valueOf(MonthToCopy).substring(4));
				  }
				  }

				  for(int i=1; i<=SnapshotMonthListToBeCopied.size();i++){
					//int ProdStartingRow=3;
					int ProdStartingRow = (int)(variancesheet1.getLastRowNum()+1);
					MonthToCopy=SnapshotMonthListToBeCopied.get(i-p);
					UtilLib.SelectiveDataCopy(workbook,prodsheet,variancesheet1,ProdStartingRow,MonthToCopy,numberOfRows);
				}
				/*Stage Header copy*/
				System.out.println("Stage Header copy");
				//int StageStartingRowHeader= ProdmonthListToCopy.size()+2;
				int row2 = (int)(variancesheet1.getLastRowNum()+2);
				variancesheet1.createRow(row2).createCell(0).setCellValue(stgsheet.getSheetName().toUpperCase());
				int StageStartingRowHeader1= (int)(variancesheet1.getLastRowNum());
				UtilLib.HeaderCopy(workbook,prodsheet,variancesheet1,StageStartingRowHeader1);

				/*Stage Data copy*/
				System.out.println("Stage Data copy");

					for(int i=1; i<=SnapshotMonthListToBeCopied.size();i++){
						int StageStartingRow= (int)(variancesheet1.getLastRowNum()+1);
						MonthToCopy=SnapshotMonthListToBeCopied.get(i-p);
					UtilLib.SelectiveDataCopy(workbook,stgsheet,variancesheet1,StageStartingRow,MonthToCopy,numberOfRows);
					}

					/*Variance compare for PeriodID sheet*/
					String months =PeriodId;
					ArrayList NumberOfLines= new ArrayList(Arrays.asList(PeriodId1.split(",")));

					int pRow=2;
					int sRow=pRow+NumberOfLines.size()+3;
					int VariacneStartingRow2 = (int)(variancesheet.getLastRowNum()+2);
					 variancesheet.createRow(VariacneStartingRow2).createCell(0).setCellValue(variancesheet.getSheetName().toUpperCase());
					 int VariacneStartingRow3 = (int)(variancesheet.getLastRowNum());
					 UtilLib.HeaderCopy(workbook,prodsheet,variancesheet,VariacneStartingRow3);
					// System.out.println("pRowpRow : "+pRow);
				//	 System.out.println("sRowsRow : "+sRow);
				//	 System.out.println("VariacneStartingRow3VariacneStartingRow3 : "+VariacneStartingRow3);
					for(int i=1; i<=NumberOfLines.size(); i++){
					VarianceExists= UtilLib.VarianceForFacts(workbook, variancesheet, pRow, sRow);
					System.out.println("VarianceExists : "+VarianceExists);
					pRow++;
					sRow++;
					}

					for (int i=1;i<100;i++){
						variancesheet.autoSizeColumn(i);
						prodsheet.autoSizeColumn(i);
						stgsheet.autoSizeColumn(i);
					}

					/*Variance compare for SnapshorID sheet*/
					int VarianceExists1=0;
					int numOfRows=Integer.parseInt(SnapshotNumOfMonths);
					int pRow1=2;
					int sRow1=pRow1+numOfRows+3;
					int VariacneStartingRow = (int)(variancesheet1.getLastRowNum()+2);
					 variancesheet1.createRow(VariacneStartingRow).createCell(0).setCellValue(variancesheet1.getSheetName().toUpperCase());
					 int VariacneStartingRow1 = (int)(variancesheet1.getLastRowNum());
					 UtilLib.HeaderCopy(workbook,prodsheet,variancesheet1,VariacneStartingRow1);
					for(int i=1; i<=numOfRows; i++){
						VarianceExists1=UtilLib.VarianceForFacts(workbook, variancesheet1, pRow1, sRow1);
						int temp1 = Integer.parseInt(String.valueOf(MonthToCopy).substring(4));
						  pRow1++;
						  sRow1++;
					}
					/*To copy Stage and Prod Query to the PeriodID variance sheet*/
					HSSFFont boldFont = workbook.createFont();
					boldFont.setFontHeightInPoints((short)12);
					boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					HSSFCellStyle boldStyle = workbook.createCellStyle();
					boldStyle.setFont(boldFont);
					int SQueryRow = variancesheet.getLastRowNum()+2;
					HSSFRow row1 = variancesheet.createRow(SQueryRow);
                   HSSFCell cell1 = row1.createCell(1);
                   cell1.setCellValue("Stage Query");
                   cell1.setCellStyle(boldStyle);
                   row1.createCell(2).setCellValue(StageQuery);
                   int PQueryRow=SQueryRow+2;
					HSSFRow rowp = variancesheet.createRow(PQueryRow);
                   HSSFCell cell2 = rowp.createCell(1);
                   cell2.setCellValue("Prod Query");
                   cell2.setCellStyle(boldStyle);
                   System.out.println("OProdQuery :"+OProdQuery);
                   rowp.createCell(2).setCellValue(ProdQuery);
                   /*if (FactLoadFlag.equals("Y")){
                   rowp.createCell(2).setCellValue(ProdQuery);
                   }else
                   	if (FactLoadFlag.equals("N")){
                   	rowp.createCell(2).setCellValue(OProdQuery);
                   	}*/

			FileOutputStream Resout1=new FileOutputStream(new File(ValidationPath+TestCaseName+"_"+fileName));
			//FileOutputStream Resout1=new FileOutputStream(new File(OPath+"\\"+DbEnv+"\\"+TrackName+"\\"+TestCaseName+"_"+fileName));
               //    FileOutputStream Resout1=new FileOutputStream(new File(UtilLib.getEnvVar(PeriodIdType)+TestCaseName+"_"+fileName));
			//System.out.println("UtilLib.getEnvVar(PeriodIdType : "+UtilLib.getEnvVar(PeriodIdType));
		//	System.out.println("TestCaseName : "+TestCaseName);
		//	System.out.println("fileName : "+fileName);

			workbook.write(Resout1);
			Resout1.close();

			System.out.println("VarianceExistsVarianceExists : "+VarianceExists);
			 System.out.println("filePath : "+filePath);
			if (VarianceExists==0){
				 UtilLib.Report_PASS(TestCaseName, "The data between production and stage matches ", " ");
				 UtilLib.LogReport(TestCaseName, "The queries: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
				 UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED"+" in "+DbEnv,TrackName,filePath,PeriodId1,StageQuery,dateStart,ViewName);
				}
			else {
				UtilLib.Report_FAIL(TestCaseName, "The data between production and stage does not match!", " ");
				UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
				UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED"+" in "+DbEnv,TrackName,filePath,PeriodId1,StageQuery,dateStart,ViewName);
				//Assert.fail("The query: "+newline+newline+"\""+StageQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
			}

		}catch (SQLException e) {
		       if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
			          /*Check Teradata exception.*/
			         int TeradataCode = e.getErrorCode();  /*Get specific error.*/
			         if (TeradataCode!=0){
			        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED"+" in "+DbEnv,TrackName,"",PeriodId1,StageQuery,dateStart,ViewName);
					     //Assert.fail("Query has failed to execute");
			        					         }
			       }
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
}
		public static void doLogin(String Env) throws MalformedURLException, InterruptedException
		{
			if (driver == null) {

				driver = UtilLib.InitiateBrowser(Env);

			}
		}

	public static void navigateTillDocuments(String Folders) throws InterruptedException {
		/*
		 * waitForElement(By.name("servletBridgeIframe"));
		 * driver.switchTo().frame(driver.findElement(By.name(
		 * "servletBridgeIframe")));
		 */

		handleClick(By.xpath(prm.documents));

		switchToPublicFolders(Folders);

	}


	public static void switchToPublicFolders(String Folders) {
		// TODO Auto-generated method stub
		System.out.println("***::" + driver.getWindowHandle());
		doWaitforElement(driver, By.xpath("//iframe[contains(@id,'iframe4220')]"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'iframe4220')]")));
		Actions pAction = new Actions(driver);
		doWaitforElement(driver, By.xpath(Folders));
		pAction.moveToElement(driver.findElement(By.xpath(Folders))).doubleClick().perform();
	}

	public static void navigateTillTestcaseFolder(String PublicFolders,String FinanceFolder, String AutomationFolder,String BOFolder,String ReportingFolder) throws InterruptedException
	{
		handleDoubleClick( By.xpath(PublicFolders),By.xpath(FinanceFolder));
		handleDoubleClick( By.xpath(FinanceFolder), By.xpath(AutomationFolder));
		handleDoubleClick( By.xpath(AutomationFolder),By.xpath(BOFolder));
		handleDoubleClick( By.xpath(BOFolder),By.xpath(ReportingFolder));
		driver.findElement(By.xpath(ReportingFolder)).click();
		Thread.sleep(3000);

		/*Actions pAction=new Actions(driver);

		doWaitforElement(driver, By.xpath(PublicFolders));
		pAction.moveToElement(driver.findElement(By.xpath(PublicFolders))).doubleClick().perform();




		doWaitforElement(driver, By.xpath(FinanceFolder));
		pAction.moveToElement(driver.findElement(By.xpath(FinanceFolder))).doubleClick().perform();

		doWaitforElement(driver, By.xpath(AutomationFolder));
		pAction.moveToElement(driver.findElement(By.xpath(AutomationFolder))).doubleClick().perform();

		doWaitforElement(driver, By.xpath(BOFolder));
		//Thread.sleep(1000);
		pAction.moveToElement(driver.findElement(By.xpath(BOFolder))).doubleClick().perform();

		doWaitforElement(driver, By.xpath(ReportingFolder));
		//Thread.sleep(10000);
		pAction.moveToElement(driver.findElement(By.xpath(ReportingFolder))).doubleClick().perform();
		Thread.sleep(5000);*/
		//driver.findElement(By.xpath(ReportingFolder)).click();

	}
	public static void selectTestcase(String testcase,String file_select_opt) throws InterruptedException
	{
		//handleClick(By.xpath(GotoLastPage));
		handleClick(By.xpath(testcase));
		doWaitforElementState(driver, By.xpath(testcase));
		Thread.sleep(2000);
		WebElement oWE=driver.findElement(By.xpath(testcase));
		Actions oAction=new Actions(driver);
		oAction.moveToElement(oWE);
		oAction.contextClick(oWE).build().perform();
		Thread.sleep(2000);
		doWaitforElement(driver, By.linkText(file_select_opt));
		Thread.sleep(10000);
		WebElement elementOpen = driver.findElement(By.linkText(file_select_opt));
		Thread.sleep(5000);
		elementOpen.click();
		/*	Thread.sleep(40000);*/
		String parentwindow = driver.getWindowHandle();
		driver.switchTo().window(parentwindow);
		//driver.switchTo().defaultContent();
		//doWaitforElement(driver, By.name("servletBridgeIframe"),"frame");

		/*waitUntilElementIsVisible(driver, By.name("servletBridgeIframe"));
		waitUntilFrameIsVisible(driver, By.name("servletBridgeIframe"));*/

		/*waitForElement(By.name("servletBridgeIframe"));
		driver.switchTo().frame(driver.findElement(By.name("servletBridgeIframe")));

	     waitUntilElementIsVisible(driver, By.xpath("//a[contains(@title, 'Open in a new window')]"));
	     waitUntilElementIsClickable(driver, By.xpath("//a[contains(@title, 'Open in a new window')]"));

		doWaitforElement(driver, By.xpath("//a[contains(@title, 'Open in a new window')]"));
		//Thread.sleep(20000);

		waitUntilElementIsVisible(driver,By.xpath("//a[contains(@title, 'Open in a new window')]"));
		WebElement open1 = driver.findElement(By.xpath("//a[contains(@title, 'Open in a new window')]"));

		Thread.sleep(10000);
		open1.click();*/

		navigateToTestCaseInNewWindow();
		Thread.sleep(3000);
	}

		public static void queryNavigation(String TestCaseName, String ComponentType, String startTime)
				throws InterruptedException {

			String parentwindow = driver.getWindowHandle();
			parentwindowid = parentwindow;
			Set<String> childwindow = driver.getWindowHandles();
			for (String eachWindow : childwindow) {
				if (!eachWindow.equalsIgnoreCase(parentwindow))

				{
					driver.switchTo().window(eachWindow);
					/* doWaitforElement(driver, By.tagName("iframe")); */
					List<WebElement> elements = driver.findElements(By.tagName("iframe"));
					int counter = 0;
					for (WebElement element1 : elements) {
						System.out.println("attribute is ::" + element1.getAttribute("id"));
						if (element1.getAttribute("id").contains("4065")) {
							driver.switchTo().frame(element1);
							List<WebElement> childframe = driver.findElements(By.tagName("iframe"));
							for (WebElement each : childframe) {
								System.out.println("child is ::" + each.getAttribute("id"));
								driver.switchTo().frame(each);
								doWaitforElement(driver, By.xpath("//*[@id='IconImg__dhtmlLib_289']"));
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='IconImg__dhtmlLib_289']")).click();
								doWaitforElement(driver,
										By.xpath("//div[contains(text(),'Query') and not (@class='iconText')]"));
								List<WebElement> listofItems = driver.findElements(
										By.xpath("//div[contains(text(),'Query') and not (@class='iconText')]"));
								int J = 0;
								StringBuilder logmessages = new StringBuilder();

								for (WebElement webEle : listofItems) {
									int i = 1 + J;
									if (logmessages.length() > 0) {
										logmessages.append("\n");
									}
									webEle.click();
									String QueryTabName = "Query " + i;
									driver.findElement(By.xpath("//*[@id='IconImg_viewScript']")).click();

									WebElement scriptTree = getElement(driver, By.id("scriptTree"));
									WebElement errordlg = getElement(driver, By.id("dlg_txt_alertDlg"));
									WebElement Querycontext = getElement(driver, By.id("ariaLabelledBy_contextDlg"));
									if (scriptTree != null && scriptTree.isDisplayed()) {
										getElement(driver, By.id("RealBtn_CANCEL_BTN_SqlViewerDlg")).click();
										// System.out.println("Multiple Queries
										// displayed");
										/*
										 * UtilLib.Report_FAIL(TestCaseName,
										 * "Compatibility is a fail for: " +
										 * TestCaseName + "." + QueryTabName,
										 * "Compatibility Check");
										 */
										Reporter.log(TestCaseName + ",,," + "Compatibility is a fail for: " + TestCaseName
												+ "." + QueryTabName);
										/*
										 * Reporter.log(TestCaseName
										 * "Compatibility is a fail for: " +
										 * TestCaseName + "." + QueryTabName);
										 */
										// UtilLib.LogExcelReportForCompatibility(TestCaseName,
										// "Compatibility is a fail for:
										// "+TestCaseName+"."+QueryTabName,
										// "FAILED",ComponentType,startTime);
										logmessages.append(
												"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
									}

									else if (errordlg != null && errordlg.isDisplayed()) {
										driver.findElement(By.id("RealBtn_OK_BTN_alertDlg")).click();
										// System.out.println("Alert is displayed");
										Reporter.log(TestCaseName + ",,," + "Compatibility is a fail for: " + TestCaseName
												+ "." + QueryTabName);
										/*
										 * UtilLib.LogReport(TestCaseName,
										 * "Compatibility is a fail for: " +
										 * TestCaseName + "." + QueryTabName);
										 */
										// UtilLib.LogExcelReportForCompatibility(TestCaseName,
										// "Compatibility is a fail for:
										// "+TestCaseName+"."+QueryTabName,
										// "FAILED",ComponentType,startTime);
										logmessages.append(
												"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
									}

									else if (Querycontext != null && Querycontext.isDisplayed()) {
										driver.findElement(By.id("RealBtn_CD_cancelBtn")).click();
										// System.out.println("Alert is displayed");
										Reporter.log(TestCaseName + ",,," + "Compatibility is a fail for: " + TestCaseName
												+ "." + QueryTabName);
										/*
										 * UtilLib.LogReport(TestCaseName,
										 * "Compatibility is a fail for: " +
										 * TestCaseName + "." + QueryTabName);
										 */
										// UtilLib.LogExcelReportForCompatibility(TestCaseName,
										// "Compatibility is a fail for:
										// "+TestCaseName+"."+QueryTabName,
										// "FAILED",ComponentType,startTime);
										logmessages.append(
												"Compatibility is a fail for: " + TestCaseName + "." + QueryTabName);
									}

									else {
										getElement(driver, By.id("RealBtn_CANCEL_BTN_SqlViewerDlg")).click();
										// System.out.println("Testcase is passed");
										Reporter.log(TestCaseName + ",,," + "Compatibility is a Pass for: " + TestCaseName
												+ "." + QueryTabName);
										/*
										 * UtilLib.LogReport(TestCaseName,
										 * "Compatibility is a pass for: " +
										 * TestCaseName + "." + QueryTabName);
										 */
										// UtilLib.LogExcelReportForCompatibility(TestCaseName,
										// "Compatibility is a pass for:
										// "+TestCaseName+"."+QueryTabName,
										// "PASSED",ComponentType,startTime);

									}
									J++;
								}

								if (logmessages.length() > 0) {
									/*
									 * UtilLib.LogExcelReportForCompatibility(
									 * TestCaseName, logmessages.toString(),
									 * "FAILED", ComponentType, startTime);
									 */

									Reporter.log(TestCaseName + ",,," + "Compatibility is a fail for: " + TestCaseName
											+ ",,," + "FAILED" + ",,," + ComponentType + ",,," + startTime);

								} else {
									/*
									 * UtilLib.LogExcelReportForCompatibility(
									 * TestCaseName, "Compatibility is a pass for: "
									 * + TestCaseName, "PASSED", ComponentType,
									 * startTime);
									 */

									Reporter.log(TestCaseName + ",,," + "Compatibility is a pass for: " + TestCaseName
											+ ",,," + "PASSED" + ",,," + ComponentType + ",,," + startTime);
								}

								getElement(driver, By.id("dialogClose_queryPanelDlg")).click();

								if (isVisible(By.id("RealBtn_OK_BTN_promptDlg"))) {
									getElement(driver, By.id("RealBtn_OK_BTN_promptDlg")).click();
								}

								driver.close();

								/* driver.close(); */
								Alert alert = driver.switchTo().alert();
								alert.accept();
								driver.switchTo().window(parentwindow);
								waitForElement(By.name("servletBridgeIframe"));
								driver.switchTo().frame(driver.findElement(By.name("servletBridgeIframe")));
								getElement(driver, By.xpath("//a[@title='Close this tab']")).click();
								/* driver.switchTo().defaultContent(); */
								driver.switchTo().window(parentwindow);
								driver.navigate().refresh();
								driver.switchTo().window(parentwindow);
								waitForElement(By.name("servletBridgeIframe"));
								driver.switchTo().frame(driver.findElement(By.name("servletBridgeIframe")));
								// driver.switchTo().defaultContent();
								// switchToPublicFolders(prm.Folders);
								/*
								 * driver.quit(); driver=null;
								 */

							}
						}
					}
				}
			}
		}

		/*public static void waitUntilElementIsInvisible(By by) {

	        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(by);
	        new WebDriverWait(driver, 120).until(condition);
	    }*/


		public static void waitUntilElementIsInvisible(By by) {
			// TODO Auto-generated method stub
			 ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(by);
		        new WebDriverWait(driver, 120).until(condition);
		}

		public static void waitUntilElementIsInvisible(WebDriver driver,By by) {
			// TODO Auto-generated method stub
			 ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(by);
		        new WebDriverWait(driver, 180).until(condition);
		}

		public static void waitUntilElementIsVisible(WebDriver driver,By by) {
			// TODO Auto-generated method stub
			 ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(by);
		        new WebDriverWait(driver, 240).until(condition);
		}

		public static void waitUntilFrameIsVisible(WebDriver driver,By by) {
			// TODO Auto-generated method stub
			 ExpectedCondition<WebDriver> condition = ExpectedConditions.frameToBeAvailableAndSwitchToIt(by);
		        new WebDriverWait(driver, 240).until(condition);
		}

		public static void waitUntilElementIsClickable(WebDriver driver, By by) {
			// TODO Auto-generated method stub
			ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(by);
			new WebDriverWait(driver, 240).until(condition);
		}


		public static void waitForNewWindowToAppear(String ParentWindow) {
			int counter = 1;
			do {
				Set<String> windows = driver.getWindowHandles();
				if (windows.size() == 2) {
					break;
				} else {
					counter++;
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} while (counter <= 10);


		}

		public static void waitForElement(By by) {
			int counter = 1;
			WebElement elementObject = null;
			do {
				try {
					elementObject=driver.findElement(by);

					break;
				} catch (NoSuchElementException ne) {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("counter is::" + counter);
				counter++;
			} while (counter <= 10);
			if (elementObject == null) {
				driver.findElement(by);
			}
		}

		public static void frameSwitch() {
			waitForElement(By.name("servletBridgeIframe"));
			driver.switchTo().frame(driver.findElement(By.name("servletBridgeIframe")));
		}

		public static void navigateToTestCaseInNewWindow() {

			frameSwitch();
			handleClick(By.xpath("//a[contains(@title, 'Open in a new window')]"));
		}

		public static void handleClick(By by) {
			int counter = 0;
			WebElement elementObject = null;
			do {
				counter++;
				System.out.println("counter ::" + counter);
				try {

					/*
					 * waitUntilElementIsVisible(driver, by);
					 * waitUntilElementIsClickable(driver, by);
					 */
					/*
					 * driver.getTitle();
					 * System.out.println(driver.getWindowHandles().size());
					 * driver.switchTo().window(driver.getWindowHandle());
					 * driver.switchTo().defaultContent(); for(WebElement
					 * element:driver.findElements(By.xpath("//a[@class='TabTilte']"
					 * ))) { System.out.println(element.getAttribute("title")); }
					 */
					/*
					 * WebElement element=driver.switchTo().activeElement();
					 * System.out.println("element is::"+element);
					 */

					// driver.switchTo().window(parentwindow);
					elementObject = driver.findElement(by);
					elementObject.click();
					break;
				} catch (WebDriverException we) {
					/* System.out.println(we.toString()); */
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} while (counter <= 35);
			if (elementObject == null) {
				driver.findElement(by);
			}

		}

		public static void handleDoubleClick(By by, By expected) {
			Actions pAction = new Actions(driver);
			int counter = 0;
			WebElement elementObject = null;
			do {

				counter++;
				System.out.println("counter ::" + counter);
				try {

					doWaitforElement(driver, by);
					pAction.moveToElement(driver.findElement(by)).doubleClick().perform();
					/* doWaitforElement(driver,expected); */
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(expected));
					elementObject = driver.findElement(expected);
					break;
				} catch (WebDriverException we) {
					/* System.out.println(we.toString()); */
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} while (counter <= 25);
			if (elementObject == null) {
				driver.findElement(by);
			}

		}

		public static boolean isVisible(By by) {
			int counter = 1;
			boolean isVisible = false;
			WebElement element = null;
			do {
				try {
					element = driver.findElement(by);
					break;
				} catch (NoSuchElementException ne) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				counter++;
			} while (counter <= 2);
			if (element != null) {
				isVisible = element.isDisplayed();
			}
			return isVisible;
		}

		public static void GMWalkRawDataValidations(String Resultfile, String DbConnurl, String DbUname, String DbPword, List<String> QueriesList, String TestCaseName) throws SQLException{
			try {
			FileInputStream resultFileInput = new FileInputStream(Resultfile);
			XSSFWorkbook resultFileWorkBook = new XSSFWorkbook(resultFileInput);
		//	UtilLib.removeOtherSheets("Query Results",resultFileWorkBook);
		//	UtilLib.removeOtherSheets("Variance",resultFileWorkBook);
			XSSFSheet queryResultsheet = resultFileWorkBook.createSheet("Query Results");
			//HSSFSheet queryResultsheet = resultFileWorkBook.getSheet("Query Results");
			XSSFSheet variancesheet = resultFileWorkBook.createSheet("Variance");
			String Query;
			int StartingRow =0;
			/*TD connection and execution of the query*/
			System.out.println("Trying to connect to: "+DbConnurl);
				Class.forName("com.teradata.jdbc.TeraDriver");
				Connection conn=DriverManager.getConnection(DbConnurl, DbUname, DbPword);
				System.out.println("Connection done");
				for(int i=0;i<QueriesList.size();i++){
				//	System.out.println("Querie "+i+QueriesList.get(i));
					Query = UtilLib.getGMWalkStageQuery(QueriesList.get(i),"Quarter");
			//System.out.println("Query : "+Query);
			PreparedStatement stmt=conn.prepareStatement(Query);
			stmt.setQueryTimeout(600);
			System.out.println("Connected to Teradata...");
			ResultSet rs=stmt.executeQuery();
			System.out.println("Query Executed in Teradata...");
			/*To copy the TD records to an the excel sheet*/
			System.out.println("Starting row : "+StartingRow);
			UtilLib.GMWalkResultSetToExcel(resultFileWorkBook, queryResultsheet, rs, StartingRow, Resultfile);
			System.out.println("queryResultsheet.getLastRowNum() : "+queryResultsheet.getLastRowNum());
			StartingRow = queryResultsheet.getLastRowNum()+2;
			System.out.println("In the end  StartingRow : "+StartingRow);
				}
				System.out.println("variancesheet.getLastRowNum() : "+variancesheet.getLastRowNum());
				UtilLib.PlainOfCopyContentsOfExcel(resultFileWorkBook, variancesheet,queryResultsheet);
				UtilLib.DeleteSelectedRows(variancesheet);
				XSSFSheet resultFileSheet=resultFileWorkBook.getSheet("PNL Output");
				int srcRow=0;
				int dstnRow=1;
				UtilLib.HeaderCopy1(resultFileWorkBook,resultFileSheet,variancesheet,0,8);
				  Iterator rowIterator = variancesheet.iterator();
				  XSSFFont textFont = resultFileWorkBook.createFont();
				  ArrayList<String> pnlArray=new ArrayList<String>();
				  ArrayList<String> TdArray= new ArrayList<String>();
				  ArrayList<Integer> pnlRowNosToCopy=new ArrayList<Integer>();
				  ArrayList<Integer> pnlRowsToCopy=new ArrayList<Integer>();
				  for(int rownum=1;rownum<=variancesheet.getLastRowNum();rownum++){
						Row row = variancesheet.getRow(rownum);
						TdArray.add(row.getCell(4).getStringCellValue());
						//System.out.println("TdArray : "+TdArray );
						System.out.println("TdArrayTdArray : "+TdArray.size());
					}
				  //TdArray.removeAll(Collections.singleton(null));

				 /* ArrayList s1=new ArrayList();
				  s1.add(null);
				  TdArray.removeAll(s1);
				  System.out.println("TdArrayTdArray aFTER: "+TdArray.size());*/

				  pnlArray=UtilLib.GMWalkMapping(TdArray);
				  for(int a=0;a<pnlArray.size();a++){
				  String Ele=pnlArray.get(a);
				  System.out.println("Ele : "+Ele);
				  pnlRowsToCopy=UtilLib.GMWalkSelectiveDataCopy(resultFileWorkBook, resultFileSheet, Ele, pnlRowNosToCopy);
				  }
				  for(int w=0;w<pnlRowsToCopy.size();w++){
					  System.out.println("pnlRowsToCopy.size()"+pnlRowsToCopy.size());
					  srcRow=pnlRowsToCopy.get(w);
					  System.out.println("srcRow :" +srcRow);
					  UtilLib.GMwalkMeasureCopy(resultFileWorkBook,resultFileSheet,variancesheet,srcRow,dstnRow,9);
				  UtilLib.GMwalkcopyRows(resultFileWorkBook,resultFileSheet,variancesheet,srcRow,dstnRow);
				  dstnRow++;
				  }

				  UtilLib.HeaderCopy1(resultFileWorkBook,resultFileSheet,variancesheet,0,13);
				  int j=1;
				  for(int i=0; i<TdArray.size();i++){
				  UtilLib.GMwalkMeasureCopy1(resultFileWorkBook,variancesheet,j,j,14);
				  j++;
				  }
				  int VarianceExists=0;
				  VarianceExists=UtilLib.VarianceForGMWalk(resultFileWorkBook, variancesheet, Resultfile);
				  System.out.println("x : "+VarianceExists);

				  //To left Align
				  UtilLib.GMWalkLeftAlign(resultFileWorkBook, variancesheet);
				  if (VarianceExists==0){
						 UtilLib.Report_PASS(TestCaseName, "The data between Pnl and TD matches ", " ");
						 //UtilLib.LogReport(TestCaseName, "The queries: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" results in matching data between production and stage");
						// UtilLib.LogExcelReport(TestCaseName, "The data between production and stage matches", "PASSED",CompType,filePath,PeriodId1,ProdQuery,dateStart,ViewName);
						}
					else {
						UtilLib.Report_FAIL(TestCaseName, "The data between Pnl and TD does not match!", " ");
						//UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+ProdQuery+newline+StageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" resulted in MISMATCHING data between production and stage");
					//	UtilLib.LogExcelReport(TestCaseName, "The data between production and stage does not match!", "FAILED",CompType,filePath,PeriodId1,ProdQuery,dateStart,ViewName);
						Assert.fail("The query resulted in MISMATCHING of data between Pnl and TD");
					}

			FileOutputStream out=new FileOutputStream(Resultfile);
			resultFileWorkBook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
}
		/* Code added for GM walk POC - 13th Jul */
		public static void GMWalkPoc(String GMDashboardResultsFile, String DbConnurl, /*String GMDashboardDownload*/String DbUname,

				String DbPword, List<String> QueriesList) throws FileNotFoundException{
			try{
			String Query;
			 int StartingRow=0;
			 int srcRow=0;
			 int dstnRow=1;
			 FileInputStream resultFileInput= new FileInputStream(GMDashboardResultsFile);
			 //FileInputStream DashboardInput = new FileInputStream(GMDashboardDownload);
			 	//XSSFWorkbook DashboardFileWorkbook = new XSSFWorkbook(DashboardInput);
			 	XSSFWorkbook resultFileWorkBook = new XSSFWorkbook(resultFileInput);
			 	XSSFSheet queryResultsheet = resultFileWorkBook.createSheet("Query Results");
			 	//XSSFSheet dashboardsheet = DashboardFileWorkbook.getSheet("GM Walk Summary Incremental - N");
			 	XSSFSheet DashboardData = resultFileWorkBook.getSheet("DashboardData");
				XSSFSheet VarianceDashboardVsSQL = resultFileWorkBook.getSheet("FormattedQueryData");
				//XSSFSheet iCubeData = resultFileWorkBook.createSheet("iCubeData");

				//UtilLib.GMwalkcopyRows(resultFileWorkBook,dashboardsheet,DashboardData,0,0);

				System.out.println("Trying to connect to: "+DbConnurl);
				Class.forName("com.teradata.jdbc.TeraDriver");
				Connection conn=DriverManager.getConnection(DbConnurl, DbUname, DbPword);
				System.out.println("Connection done");
				for(int i=0;i<QueriesList.size();i++){
				System.out.println("Querie "+i+QueriesList.get(i));
				Query = UtilLib.getGMWalkQuery(QueriesList.get(i));
				//System.out.println("Query : "+Query);
				PreparedStatement stmt=conn.prepareStatement(Query);
				stmt.setQueryTimeout(600);
				System.out.println("Connected to Teradata...");
				ResultSet rs=stmt.executeQuery();
				System.out.println("Query Executed in Teradata...");
				/*To copy the TD records to an the excel sheet*/
				System.out.println("Starting row : "+StartingRow);
				UtilLib.GMWalkResultSetToExcel(resultFileWorkBook, queryResultsheet, rs, StartingRow, GMDashboardResultsFile);
				System.out.println("queryResultsheet.getLastRowNum() : "+queryResultsheet.getLastRowNum());
				StartingRow = queryResultsheet.getLastRowNum()+2;
				System.out.println("In the end  StartingRow : "+StartingRow);
				}
				UtilLib.PlainOfCopyContentsOfExcel(resultFileWorkBook, VarianceDashboardVsSQL,queryResultsheet,GMDashboardResultsFile);
				FileOutputStream out=new FileOutputStream(GMDashboardResultsFile);
				resultFileWorkBook.write(out);
				Desktop.getDesktop().open(new File(UtilLib.getEnvVar("Fileconvertor")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public static void GMWalkSeleniumPoc(String ReportName) throws IOException, InterruptedException{

			String GMWalkDashboardFolder = UtilLib.getUpdatedParam("GMWalkDashboardFolder");
			String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
			// Create a profile
			FirefoxProfile profile = new FirefoxProfile();
			// Set preferences for file type
			profile.setPreference("browser.download.dir", GMWalkDashboardFolder);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
			profile.setPreference("signon.autologin.proxy", "true");

			Desktop.getDesktop().open(new File(UtilLib.getEnvVar("FileDelete")));

			// Open Webbrowser
			WebDriver driver = new FirefoxDriver(profile);
			driver.manage().window().maximize();

			// Open URL with AutoIT script for authentication
			Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
			driver.get(sCFAUrl);
			driver.manage().timeouts().pageLoadTimeout(800, TimeUnit.SECONDS);

			// Click on GMWalk dashboard

			doWaitforElement(driver,By.xpath("(//img[contains(@src,'http://fesfa-app-prd-01:8080/Images/interface/gmw.jpg')])[1]"));
			driver.findElement(By.xpath("(//img[contains(@src,'http://fesfa-app-prd-01:8080/Images/interface/gmw.jpg')])[1]")).click();
			driver.manage().timeouts().pageLoadTimeout(7000, TimeUnit.SECONDS);
			Thread.sleep(10000);
			driver.switchTo().frame("mstrFrame");

			/*// Dropdown option for Fiscal Quarter
			String FiscalQtr = "Q2 FY2015";
			driver.findElement(By.xpath("(//div[contains(@class,'mstrmojo-ui-Pulldown-text')])[2]")).click();
			driver.findElement(By.xpath("(//div[text()='" + FiscalQtr + "'])")).click();

			// Dropdown option for Product/Service Flag

			String productOrServiceFlag = "Service";
			driver.findElement(By.xpath("(//div[contains(@class,'mstrmojo-ui-Pulldown-text')])[3]")).click();
			driver.findElement(By.xpath("(//div[text()='" + productOrServiceFlag + "'])")).click();

			// Dropdown option for WalkAnchor

			String WalkAnchor = "Internal BE / I-GEO";
			driver.findElement(By.xpath("(//div[contains(@class,'mstrmojo-ui-Pulldown-text')])[4]")).click();
			driver.findElement(By.xpath("(//div[text()='" + WalkAnchor + "'])")).click();
		*/
			// Click on GMWalk Summary link

			doWaitforElement(driver, By.xpath("(//div[contains(text(),'GM Walk Summary')])[1]"));
			driver.findElement(By.xpath("(//div[contains(text(),'GM Walk Summary')])[1]")).click();

			// Click on Downloads

			doWaitforElement(driver, By.xpath("//div[contains(text(),'Downloads')]"));
			driver.findElement(By.xpath("//div[contains(text(),'Downloads')]")).click();

			doWaitforElement(driver, By.xpath("//div[contains(text(),'Excel Download')]"));
			driver.findElement(By.xpath("//div[contains(text(),'Excel Download')]")).click();

			// Handle new window when download option is clicked
			Thread.sleep(10000);
			driver.manage().timeouts().pageLoadTimeout(7000, TimeUnit.SECONDS);
			Set<String> set1 = driver.getWindowHandles();
			Iterator<String> win1 = set1.iterator();
			String parent = win1.next();
			String child = win1.next();
			driver.switchTo().window(child);
			System.out.println("driver is ::" + driver.getTitle());
			driver.close();

			driver.switchTo().window(parent);

			//driver.navigate().refresh();
			/*
			driver.findElement(By.xpath("//span[@class='navtext'][contains(text(),'My Reports')]")).click();
			*/
			driver.findElement(By.id("myReports")).click();
			driver.switchTo().frame("mstrFrame");
			doWaitforElement(driver,By.linkText(ReportName));
			String sReportURL = driver.findElement(By.linkText(ReportName)).getAttribute("href")
					.replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
			WebElement xpath = driver.findElement(By.xpath("(//a[contains(@href,'" + (sReportURL) + "')])[1]"));
			driver.findElement(By.xpath("(//a[contains(@href,'" + (sReportURL) + "')])[2]")).click();
			//doWaitforElement(driver, By.xpath("//span[contains(@title,'Export')])"));
			Thread.sleep(15000);
			driver.findElement(By.xpath("(//span[contains(@title,'Export')])")).click();

			Thread.sleep(30000);
			Set<String> set2 = driver.getWindowHandles();
			Iterator<String> win2 = set2.iterator();
			String parentwindow = win2.next();
			String childwindow = win2.next();
			driver.switchTo().window(childwindow);
			System.out.println("driver is ::" + driver.getTitle());
			//driver.findElements(By.className("mstrButton")).get(1).click();
			Thread.sleep(5000);
			driver.close();
			driver.quit();
		 }

	/*public static void doWaitforElement(WebDriver driver,final By by){
		WebDriverWait wait1 = new WebDriverWait(driver,300);
		//WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(by));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(by));
   }
;*/
	/* Code added for GM walk POC - 13th Jul */
	/* Code added for CFA POC - 15th Jul */
	public static void CFADownloadReportDatatoExcel(String CFABaselinesFolder,String ReportFolderPath,String ReportName,String[] ReportFilter) throws IOException, Exception{
		String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
		String sReportURL;
		String CurrentReport = "_" + new java.text.SimpleDateFormat("MM_dd_yyyy_h_mm_ss").format(new Date());
		String UserID = UtilLib.getUpdatedParam("CFAUserID");
		String Password = UtilLib.getUpdatedParam("CFAPwd");

		// Create a profile
		FirefoxProfile profile = new FirefoxProfile();
		// Set preferences for file type
		profile.setPreference("browser.download.dir", CFABaselinesFolder);
		System.out.println(CFABaselinesFolder);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
		//profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		profile.setPreference("signon.autologin.proxy", "true");

		// Open Webbrowser
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();

		// Open URL with AutoIT script for authentication
		System.out.println("Open the link....");
		//Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
		driver.get(sCFAUrl);

		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.id("userInput")).sendKeys(UserID);
		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		//Navigate to the Report folder
		System.out.println("Navigate to the folder....");
		doWaitforElement(driver,By.id("myWorkplace"));
		driver.findElement(By.id("myWorkplace")).click();

		String aReportFolderPath[]=ReportFolderPath.split(">");
		doWaitforElement(driver,By.id("mstrFrame"));
	    driver.switchTo().frame("mstrFrame");
	    for (int i = 0 ; i < aReportFolderPath.length;i++)
	    {
	    	doWaitforElement(driver,By.linkText(aReportFolderPath[i]));
	        sReportURL = driver.findElement(By.linkText(aReportFolderPath[i])).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	        doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]"));
	        driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]")).click();

	    }

	    //Run the report
	    doWaitforElement(driver,By.linkText(ReportName));
	    sReportURL = driver.findElement(By.linkText(ReportName)).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	    doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[2]"));
	    driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[2]")).click();
	    doWaitforElement(driver,By.xpath("(//label[text()='Report Message Name:'])"));
	    String reportnameinput = driver.findElement(By.xpath("(//label[text()='Report Message Name:'])")).getAttribute("for");
	    doWaitforElement(driver,By.id(reportnameinput));
	    driver.findElement(By.id(reportnameinput)).sendKeys(CurrentReport);

	    //Remove all the quarters selected for the report
	    doWaitforElement(driver,By.xpath("(//img[@title='Remove All'])"));
	    driver.findElement(By.xpath("(//img[@title='Remove All'])")).click();

	    //Select the quarters for report filter
	    System.out.println("Applying Filter....");
	    for (int i = 0 ; i < ReportFilter.length ; i++)
	    {
	    	doWaitforElement(driver,By.xpath("(//label[contains(text(),'Search for')])"));
	    	String inputelementid = driver.findElement(By.xpath("(//label[contains(text(),'Search for')])")).getAttribute("for");
	    	doWaitforElement(driver,By.id(inputelementid));
	    	driver.findElement(By.id(inputelementid)).clear();
	    	driver.findElement(By.id(inputelementid)).sendKeys(ReportFilter[i].replace(" ", "%"));
		    doWaitforElement(driver,By.className("mstrBGIcon_tbSearch"));
		    driver.findElement(By.className("mstrBGIcon_tbSearch")).click();
		    Thread.sleep(5000);
		    doWaitforElement(driver,By.xpath("(//img[@title='Add'])"));
		    driver.findElement(By.xpath("(//img[@title='Add'])")).click();
	    }


	    //Run the report
	    System.out.println("Running the report....");
	    doWaitforElement(driver,By.xpath("(//input[contains(@value,'Run Report')])"));
	    driver.findElement(By.xpath("(//input[contains(@value,'Run Report')])")).click();

	    Thread.sleep(15000);
	    doWaitforElement(driver,By.xpath("//div[text()='Report Home']"));
	    driver.findElement(By.xpath("//div[text()='Report Home']")).click();

	    //Export data to excel
	    Thread.sleep(10000);
	    System.out.println("Exporting to excel....");
	    doWaitforElement(driver, By.xpath("(//span[@title='Export'])"));
	    driver.findElement(By.xpath("(//span[@title='Export'])")).click();

	    Thread.sleep(15000);
	    Set<String> set2 = driver.getWindowHandles();
		Iterator<String> win2 = set2.iterator();
		String parentwindow = win2.next();
		String childwindow = win2.next();
		driver.switchTo().window(childwindow);
		System.out.println(ReportName + " Report is downloaded");

		//Closing browser
		driver.close();
		driver.quit();

		//System.out.println("Verify if excel is downloaded or not");
		//Assert.assertTrue(isFileDownloaded(CFABaselinesFolder , ReportName + CurrentReport + ".xlsx"), "Failed to download report");

		//Converting .xls to .xlsx file
		File file1 = new File(CFABaselinesFolder + ReportName + CurrentReport + ".xls");
		if(file1.exists()){
			String filename = "E:\\fpm-it_test_automation\\workspace\\FINBI_E2E_WebApp\\FINBI_E2E\\vbscript\\ExcelConvertor.vbs" + " \"" + CFABaselinesFolder + ReportName + CurrentReport+"\"";
			System.out.println(filename);
			Runtime.getRuntime().exec("cmd /c " + filename);
		}

   }
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();

	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	public static void MergeExcelReports(String CFABaselinesFolder,String BaselineReport,String CurrentReport,String CompReport) throws IOException
	{
		//Create a new workbook
		XSSFWorkbook newWorkbook = new XSSFWorkbook();
		System.out.println("Merging two reports....");
		// Create Workbook instance holding reference to .xls file
		XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(BaselineReport));
		XSSFWorkbook workbook2 = new XSSFWorkbook(new FileInputStream(CurrentReport));

		//Create new sheet in new workbook for First File
		XSSFSheet sheet1 = newWorkbook.createSheet("Report1");

		//Copy data from file 1 to New Workbook
		copySheets(newWorkbook, sheet1, workbook1.getSheetAt(0),true);

	    XSSFSheet sheet2 = newWorkbook.createSheet("Report2");

	    copySheets(newWorkbook, sheet2, workbook2.getSheetAt(0),true);

	    workbook1.close();
        workbook2.close();

        File file = new File(CFABaselinesFolder + CompReport);

        try {
            writeFile(newWorkbook, file);
          }

          catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

}

	protected static void writeFile(XSSFWorkbook book, File file) throws Exception {
	    FileOutputStream out = new FileOutputStream(file);
	    book.write(out);
	    out.close();
	  }

    private static void copySheets(XSSFWorkbook newWorkbook, XSSFSheet newSheet, XSSFSheet sheet, boolean copyStyle){
	    int newRownumber = newSheet.getLastRowNum() + 1;
	    int maxColumnNum = 0;
	    Map<Integer, XSSFCellStyle> styleMap = (copyStyle) ? new HashMap<Integer, XSSFCellStyle>() : null;

	    for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
	      XSSFRow srcRow = sheet.getRow(i);
	      XSSFRow destRow = newSheet.createRow(i + newRownumber);
	      if (srcRow != null) {
	        copyRow(newWorkbook, sheet, newSheet, srcRow, destRow, styleMap);
	        if (srcRow.getLastCellNum() > maxColumnNum) {
	            maxColumnNum = srcRow.getLastCellNum();
	        }
	      }
	    }
	    for (int i = 0; i <= maxColumnNum; i++) {
	      newSheet.setColumnWidth(i, sheet.getColumnWidth(i));
	    }
	  }

	public static void copyRow(XSSFWorkbook newWorkbook, XSSFSheet srcSheet, XSSFSheet destSheet, XSSFRow srcRow, XSSFRow destRow, Map<Integer, XSSFCellStyle> styleMap) {
	    destRow.setHeight(srcRow.getHeight());
	    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
	      XSSFCell oldCell = srcRow.getCell(j);
	      XSSFCell newCell = destRow.getCell(j);
	      if (oldCell != null) {
	        if (newCell == null) {
	          newCell = destRow.createCell(j);
	        }
	        copyCell(newWorkbook, oldCell, newCell, styleMap);
	      }
	    }
	  }

	public static void copyCell(XSSFWorkbook newWorkbook, XSSFCell oldCell, XSSFCell newCell, Map<Integer, XSSFCellStyle> styleMap) {
	    if(styleMap != null) {
	      int stHashCode = oldCell.getCellStyle().hashCode();
	      XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
	      if(newCellStyle == null){
	        newCellStyle = newWorkbook.createCellStyle();
	        newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
	        styleMap.put(stHashCode, newCellStyle);
	      }
	      newCell.setCellStyle(newCellStyle);
	    }
	    switch(oldCell.getCellType()) {
	      case XSSFCell.CELL_TYPE_STRING:
	        newCell.setCellValue(oldCell.getRichStringCellValue());
	        break;
	      case XSSFCell.CELL_TYPE_NUMERIC:
	        newCell.setCellValue(oldCell.getNumericCellValue());
	        break;
	      case XSSFCell.CELL_TYPE_BLANK:
	        newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
	        break;
	      case XSSFCell.CELL_TYPE_BOOLEAN:
	        newCell.setCellValue(oldCell.getBooleanCellValue());
	        break;
	      case XSSFCell.CELL_TYPE_ERROR:
	        newCell.setCellErrorValue(oldCell.getErrorCellValue());
	        break;
	      case XSSFCell.CELL_TYPE_FORMULA:
	        newCell.setCellFormula(oldCell.getCellFormula());
	        break;
	      default:
	        break;
	    }
	  }

	public static void CompCFAReports(String sCFABaselinesFolder, String sComparisionReport) throws Exception {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(sCFABaselinesFolder + sComparisionReport));
		XSSFSheet worksheet1 = workbook.getSheetAt(0);
		XSSFSheet worksheet2 = workbook.getSheetAt(1);

		System.out.println("Comparing two reports");

		File file = new File(sCFABaselinesFolder + sComparisionReport);

		List cellDataList1 = new ArrayList();
	  	List cellDataList2 = new ArrayList();
	  	List cellValidatedList = new ArrayList();

	  	cellDataList1 = RetriveExcelData(worksheet1);
	  	cellDataList2 = RetriveExcelData(worksheet2);

	  	XSSFCellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1 = workbook.createCellStyle();
        cellStyle1.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        cellStyle1.setFillPattern(CellStyle.SOLID_FOREGROUND);

        XSSFCellStyle cellStyle2 = workbook.createCellStyle();
        cellStyle2 = workbook.createCellStyle();
        cellStyle2.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        cellStyle2.setFillPattern(CellStyle.SOLID_FOREGROUND);


	  	int headerRowNumStart=0;
	  	int headerRowNumEnd=0;
	  	int attributeColNumEnd=0;

	  	for (int i = 0; i < cellDataList1.size(); i++) {
	          List cellTempList = (List) cellDataList1.get(i);
	             for (int j = 0; j < cellTempList.size(); j++) {
		              XSSFCell xssfCell = (XSSFCell) cellTempList.get(j);
		              if(xssfCell.getCellType() == Cell.CELL_TYPE_STRING)
		              {
		                 switch(xssfCell.getStringCellValue().trim())
		                 {
		                 	case "Fiscal Year":
		                 		headerRowNumStart = xssfCell.getRowIndex();
		                 	case "Fiscal Month":
		                 		headerRowNumEnd = xssfCell.getRowIndex();
		                 		attributeColNumEnd = xssfCell.getColumnIndex();
		                 }
		              }
		          }
		}


	  	int maxColumnNum = 0;
	    XSSFSheet newSheet = workbook.createSheet("Report 1 vs Report 2");

	  	for (int i = headerRowNumStart ; i <= worksheet1.getLastRowNum(); i++) {
	  		XSSFRow srcRow = worksheet1.getRow(i);
	  		XSSFRow destRow = newSheet.createRow(i);
	  		if (srcRow != null) {
	  			destRow.setHeight(srcRow.getHeight());
	  		    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
	  		      XSSFCell oldCell = srcRow.getCell(j);
	  		      XSSFCell newCell = destRow.getCell(j);
	  		      if (oldCell != null) {
			  		        if (newCell == null) {
			  		          newCell = destRow.createCell(j);
			  		        }
			  		      switch(oldCell.getCellType()) {
			  		      case XSSFCell.CELL_TYPE_STRING:
			  		        newCell.setCellValue(oldCell.getRichStringCellValue());
			  		        break;
			  		      case XSSFCell.CELL_TYPE_NUMERIC:
			  		        newCell.setCellValue(oldCell.getNumericCellValue());
			  		        break;
			  		      case XSSFCell.CELL_TYPE_BLANK:
			  		        newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
			  		        break;
			  		      case XSSFCell.CELL_TYPE_BOOLEAN:
			  		        newCell.setCellValue(oldCell.getBooleanCellValue());
			  		        break;
			  		      case XSSFCell.CELL_TYPE_ERROR:
			  		        newCell.setCellErrorValue(oldCell.getErrorCellValue());
			  		        break;
			  		      case XSSFCell.CELL_TYPE_FORMULA:
			  		        newCell.setCellFormula(oldCell.getCellFormula());
			  		        break;
			  		      default:
			  		        break;
			  		    }

			  		    if (oldCell.getColumnIndex() > attributeColNumEnd && oldCell.getRowIndex() > headerRowNumEnd )
			  		    {
			  		    	for (int k = headerRowNumEnd + 1 ; k <= worksheet2.getLastRowNum(); k++) {
			  			  		XSSFRow srcRow2 = worksheet2.getRow(k);
				  			  	if (srcRow != null && srcRow2.getCell(attributeColNumEnd).getNumericCellValue() == srcRow.getCell(attributeColNumEnd).getNumericCellValue()) {
				  			  		newCell.setCellValue(oldCell.getNumericCellValue() - srcRow2.getCell(j).getNumericCellValue());
				  			  	}

				  			  	double diff = newCell.getNumericCellValue() ;

			  		  			if( diff > -100 && diff < 100)
			  		  			{
			  		  				newCell.setCellStyle(cellStyle2);
			  		  			}
			  		  			else
			  		  			{
			  		  				newCell.setCellStyle(cellStyle1);
			  		  			}

			  		    	}

			  		    }

	  		      	}

	  		    }
		        if (srcRow.getLastCellNum() > maxColumnNum) {
		            maxColumnNum = srcRow.getLastCellNum();
		        }
		      }
		    }

	  	int z = 1 ;

	  	for (int i = headerRowNumEnd + 1 ; i <= worksheet2.getLastRowNum(); i++) {
	  		XSSFRow srcRow = worksheet2.getRow(i);
	  		XSSFRow destRow = newSheet.createRow(worksheet1.getLastRowNum() + z );
	  		boolean newRow = true;
	  		if (srcRow != null) {
	  			for (int k = headerRowNumEnd + 1 ; k <= worksheet1.getLastRowNum(); k++) {
	  			 	XSSFRow srcRow2 = worksheet1.getRow(k);
		  			if (srcRow != null && srcRow2.getCell(attributeColNumEnd).getNumericCellValue() == srcRow.getCell(attributeColNumEnd).getNumericCellValue()) {
		  			  		 newRow = false ;
		  		  	}

	  		    }
	  			if(newRow == true)
	  			{
	  				z = z + 1 ;
	  				destRow.setHeight(srcRow.getHeight());
		  		    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
		  		      XSSFCell oldCell = srcRow.getCell(j);
		  		      XSSFCell newCell = destRow.getCell(j);
		  		      if (oldCell != null) {
				  		        if (newCell == null) {
				  		          newCell = destRow.createCell(j);
				  		        }
				  		      switch(oldCell.getCellType()) {
				  		      case XSSFCell.CELL_TYPE_STRING:
				  		        newCell.setCellValue(oldCell.getRichStringCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_NUMERIC:
				  		        newCell.setCellValue(oldCell.getNumericCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_BLANK:
				  		        newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
				  		        break;
				  		      case XSSFCell.CELL_TYPE_BOOLEAN:
				  		        newCell.setCellValue(oldCell.getBooleanCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_ERROR:
				  		        newCell.setCellErrorValue(oldCell.getErrorCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_FORMULA:
				  		        newCell.setCellFormula(oldCell.getCellFormula());
				  		        break;
				  		      default:
				  		        break;
				  		    }

				  		    if (oldCell.getColumnIndex() > attributeColNumEnd && oldCell.getRowIndex() > headerRowNumEnd )
				  		    {
				  		    	newCell.setCellValue(oldCell.getNumericCellValue() * -1);
				  		    	double diff = oldCell.getNumericCellValue() * -1 ;

			  		  			if( diff > -100 && diff < 100)
			  		  			{
			  		  				newCell.setCellStyle(cellStyle2);
			  		  			}
			  		  			else
			  		  			{
			  		  				newCell.setCellStyle(cellStyle1);
			  		  			}
				  		    }


		  		      	}

		  		    }

	  			}

		      }
		    }

		writeFile(workbook, file);

		workbook.close();
		System.out.println("Report Generated");
	}

	private static List RetriveExcelData(XSSFSheet worksheet1) {
		// TODO Auto-generated method stub
		List cellDataList = new ArrayList();

		XSSFRow row;
		Iterator < Row > rowIterator = worksheet1.iterator();
	    while (rowIterator.hasNext())
	    {
	       row = (XSSFRow) rowIterator.next();
	       Iterator < Cell > cellIterator = row.cellIterator();
	       List cellTempList = new ArrayList();
	       while ( cellIterator.hasNext())
	       {
	          Cell cell = cellIterator.next();
	          cellTempList.add(cell);
	         }
	       cellDataList.add(cellTempList);
	    }

		return cellDataList;
	}

	public static List<String> RetriveFileList()
	{
		// Directory path here
        String path = UtilLib.getUpdatedParam("CFABaselinesFolder");

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        List<String> filelist = new ArrayList<String>();

        for (int i = 0; i < listOfFiles.length; i++)
        {

            if (listOfFiles[i].isFile() && listOfFiles[i].getName().trim().endsWith(".xlsx") && !(listOfFiles[i].getName().trim().startsWith("Comp_")))
            {
            	   	filelist.add(listOfFiles[i].getName());
            	   	System.out.println("File: "+i+" :"+listOfFiles[i].getName());
            }

        }

        return filelist;
	}

	public static void CFAExcelTemplateRefresh(String FolderName,String ReportName,String ReportFolderPath) throws IOException, InterruptedException, AWTException
	{
		String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
		String sReportURL;
		String UserID = UtilLib.getUpdatedParam("CFAUserID");
		String Password = UtilLib.getUpdatedParam("CFAPwd");

		//Opening Excel Template and Refreshing data
		System.out.println("Refreshing Cube Excel Template...");
		Desktop.getDesktop().open(new File( FolderName+"Baseline\\" + ReportName + ".xlsm"));

		// Open Webbrowser
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// Open URL with AutoIT script for authentication
		System.out.println("Open the link....");
		//Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
		driver.get(sCFAUrl);

		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.id("userInput")).sendKeys(UserID);
		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		//Navigate to the Report folder
		System.out.println("Navigate to the folder....");
		doWaitforElement(driver,By.id("myWorkplace"));
		driver.findElement(By.id("myWorkplace")).click();

		String aReportFolderPath[]=ReportFolderPath.split(">");
		doWaitforElement(driver,By.id("mstrFrame"));
	    driver.switchTo().frame("mstrFrame");
	    for (int i = 0 ; i < aReportFolderPath.length;i++)
	    {
	    	doWaitforElement(driver,By.linkText(aReportFolderPath[i]));
	        sReportURL = driver.findElement(By.linkText(aReportFolderPath[i])).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	        doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]"));
	        driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]")).click();

	    }

	    //Refreshing iCube
	    System.out.println("Refreshing iCube....");
	    doWaitforElement(driver,By.xpath("(//a[contains(@onclick,'"+ ReportName +"')])[2]"));
	    WebElement wb = driver.findElement(By.xpath("(//a[contains(@onclick,'"+ ReportName +"')])[2]"));

	    Actions oAction = new Actions(driver);
	    oAction.moveToElement(wb);
	    oAction.contextClick(wb).build().perform();
	    driver.findElement(By.xpath("//table[@class='mstrContextMenuRight']/tbody/tr[1]/td[3]")).click();

	    doWaitforElement(driver,By.xpath("(//span[contains(@class,'mstrmojo-CheckBox')])"));
	    driver.findElement(By.xpath("(//span[contains(@class,'mstrmojo-CheckBox')])")).click();

	    doWaitforElement(driver,By.className("mstrmojo-FileUploadBox-buttonDiv"));
	    driver.findElement(By.className("mstrmojo-FileUploadBox-buttonDiv")).click();

	    StringSelection filepath = new StringSelection(FolderName +"Results\\Report_" + ReportName + ".xls");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);

	    Thread.sleep(5000);
	    Robot okrobot = new Robot();
	    okrobot.keyPress(KeyEvent.VK_ENTER);    // press Enter
	    okrobot.keyRelease(KeyEvent.VK_ENTER);  // release Enter
	    okrobot.keyPress(KeyEvent.VK_ENTER);    // press Enter
	    okrobot.keyRelease(KeyEvent.VK_ENTER);  // release Enter

	    Thread.sleep(5000);
	    doWaitforElement(driver,By.xpath("//div[contains(@class,'hot')]"));
	    driver.findElement(By.xpath("//div[contains(@class,'hot')]")).click();

	    Thread.sleep(10000);
	    doWaitforElement(driver,By.id("mstr85"));
	    driver.findElement(By.id("mstr85")).click();

	    //Closing browser
	    Thread.sleep(5000);
	    System.out.println("Closing the Browser....");
	  	driver.close();
	  	driver.quit();

	}

	public static void CFAReportTemplateRefresh(String ReportName,String ReportFolderPath,String[] ReportFilter) throws IOException, InterruptedException
	{
		String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
		String UserID = UtilLib.getUpdatedParam("CFAUserID");
		String Password = UtilLib.getUpdatedParam("CFAPwd");
		String sReportURL;

		// Open Webbrowser
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// Open URL with AutoIT script for authentication
		System.out.println("Open the link....");
		//Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
		driver.get(sCFAUrl);

		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.id("userInput")).sendKeys(UserID);
		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		//Navigate to the Report folder
		System.out.println("Navigate to the folder....");
		doWaitforElement(driver,By.id("myWorkplace"));
		driver.findElement(By.id("myWorkplace")).click();

		String aReportFolderPath[]=ReportFolderPath.split(">");
		doWaitforElement(driver,By.id("mstrFrame"));
	    driver.switchTo().frame("mstrFrame");
	    for (int i = 0 ; i < aReportFolderPath.length;i++)
	    {
	    	doWaitforElement(driver,By.linkText(aReportFolderPath[i]));
	        sReportURL = driver.findElement(By.linkText(aReportFolderPath[i])).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	        doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]"));
	        driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]")).click();

	    }

	    //Edit the report
	    doWaitforElement(driver,By.linkText(ReportName));
	    sReportURL = driver.findElement(By.linkText(ReportName)).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	    doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[2]"));
	    WebElement wb = driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[2]"));

	    Actions oAction = new Actions(driver);
	    oAction.moveToElement(wb);
	    oAction.contextClick(wb).build().perform();
	    driver.findElement(By.xpath("//table[@class='mstrContextMenuRight']/tbody/tr[2]/td[3]")).click();
	    doWaitforElement(driver,By.className("mstr-filter-text-editable"));
	    driver.findElement(By.className("mstr-filter-text-editable")).click();

	    //Remove all the values selected for the report
	    doWaitforElement(driver,By.xpath("(//img[contains(@title,'Remove all')])"));
	    driver.findElement(By.xpath("(//img[contains(@title,'Remove all')])")).click();

	    //Select the values for report filter
	    System.out.println("Applying Filter....");
	    for (int i = 0 ; i < ReportFilter.length ; i++)
	    {
	    	doWaitforElement(driver,By.xpath("(//label[contains(text(),'Search for')])"));
	    	String inputelementid = driver.findElement(By.xpath("(//label[contains(text(),'Search for')])")).getAttribute("for");
	    	doWaitforElement(driver,By.id(inputelementid));
	    	driver.findElement(By.id(inputelementid)).clear();
	    	driver.findElement(By.id(inputelementid)).sendKeys(ReportFilter[i].replace(" ", "%"));
		    doWaitforElement(driver,By.id("cartSearchButton"));
		    driver.findElement(By.id("cartSearchButton")).click();
		    Thread.sleep(5000);
		    doWaitforElement(driver,By.xpath("(//img[contains(@title,'Add all elements to selections')])"));
		    driver.findElement(By.xpath("(//img[contains(@title,'Add all elements to selections')])")).click();

	    }
	    doWaitforElement(driver,By.id("acceptButton"));
	    driver.findElement(By.id("acceptButton")).click();

	    Thread.sleep(10000);
	    System.out.println("Saving the Report....");
	    doWaitforElement(driver,By.xpath("(//span[contains(@title,'Save')])"));
	    driver.findElement(By.xpath("(//span[contains(@title,'Save')])")).click();

	    //Closing browser
	    Thread.sleep(5000);
	    System.out.println("Closing the Browser....");
	  	driver.close();
	  	driver.quit();

	}

	public static void UpdateExcelConfig(String sCubeTemplateFolder, String sYear, String sMonth, Integer iNMonths,String CubeApplication,String CubeDatabase,String CubeServer) {
		// TODO Auto-generated method stub
		File xmlFile = new File(sCubeTemplateFolder + "XML//CFAConfig.xml" );
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //update attribute value
            Element var = (Element)doc.getElementsByTagName("Details").item(0);
            var.getElementsByTagName("Year").item(0).getFirstChild().setNodeValue(sYear.toString());
            var.getElementsByTagName("Month").item(0).getFirstChild().setNodeValue(sMonth.toString());
            var.getElementsByTagName("NumberofMonths").item(0).getFirstChild().setNodeValue(iNMonths.toString());

            var.getElementsByTagName("Application").item(0).getFirstChild().setNodeValue(CubeApplication.toString());
            var.getElementsByTagName("DataBase").item(0).getFirstChild().setNodeValue(CubeDatabase.toString());
            var.getElementsByTagName("ServerName").item(0).getFirstChild().setNodeValue(CubeServer.toString());

            //write the updated document to file or console
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");

        } catch (Exception e1) {
            e1.printStackTrace();
        }


	}

	public static void GSPDashboardDownload(String CFADashboardFolder,String ScreenType)
	{
		try {
	    	 //Browse GSP Dashboard and download the excel
			String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
			String UserID = UtilLib.getUpdatedParam("CFAUserID");
			String Password = UtilLib.getUpdatedParam("CFAPwd");

			//Delete Existing Files
			System.out.println("Deleting existing files");
			File file1 = new File(CFADashboardFolder + "GSP P & L.xls");
			if(file1.exists()){
				file1.delete();
			}

			File file2 = new File(CFADashboardFolder + "GSP P & L.xlsx");
			if(file2.exists()){
				file2.delete();
			}

			FirefoxProfile profile = new FirefoxProfile();
			// Set preferences for file type
			profile.setPreference("browser.download.dir", CFADashboardFolder);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
			//profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			profile.setPreference("signon.autologin.proxy", "true");

			// Open Webbrowser
			WebDriver driver = new FirefoxDriver(profile);
			driver.manage().window().maximize();

			// Open URL with AutoIT script for authentication
			System.out.println("Opening the link....");
			//Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
			driver.get(sCFAUrl);

			doWaitforElement(driver,By.id("userInput"));
			driver.findElement(By.id("userInput")).sendKeys(UserID);
			doWaitforElement(driver,By.id("userInput"));
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.xpath("//input[@value='Log In']")).click();

			//Opening the Dashboard
			System.out.println("Opening the Dashboard....");
			doWaitforElement(driver,By.xpath("//span[text()='Global Service Provider']"));
			driver.findElement(By.xpath("//span[text()='Global Service Provider']")).click();

			doWaitforElement(driver,By.id("mstrFrame"));
		    driver.switchTo().frame("mstrFrame");

		   doWaitforElement(driver,By.xpath("//div[@class='mstrmojo-Button  mstrmojo-oivmSprite tbDown']"));


			List<WebElement> rows =driver.findElements(By.xpath("//div[@class='mstrmojo-Button  mstrmojo-oivmSprite tbDown']"));

			java.util.Iterator<WebElement> i = rows.iterator();
			while(i.hasNext()) {

				if(ScreenType.trim().contains("Bookings-Summary"))
				{
					WebElement row = i.next();
					row.click();

				    System.out.println("Downloading Excel");

				    doWaitforElement(driver,By.xpath("//td[text()='Export to Excel']"));
				    driver.findElement(By.xpath("//td[text()='Export to Excel']")).click();
				    System.out.println("Downloading Excel1");
				    /*Thread.sleep(30000);*/
				    System.out.println("Downloading Excel");
					Set<String> set2 = driver.getWindowHandles();
					Iterator<String> win2 = set2.iterator();
					String parentwindow = win2.next();
					String childwindow = win2.next();
					driver.switchTo().window(childwindow);
					System.out.println("Dashboard is downloaded");
					driver.close();

					//Coverting .xls to .xlsx file
					File file3 = new File(CFADashboardFolder + "GSP P & L.xls");
					if(file3.exists()){
						String filename = "E:\\fpm-it_test_automation\\workspace\\FINBI_E2E_WebApp\\FINBI_E2E\\vbscript\\ExcelConvertor.vbs" + " \"" + CFADashboardFolder + "GSP P & L\""  ;
						System.out.println(filename);
						Runtime.getRuntime().exec("cmd /c " + filename);
					}

				    driver.switchTo().window(parentwindow);
					//driver.switchTo().frame("mstrFrame");

				    break;
				}


			}



			Thread.sleep(10000);

			driver.quit();


	     }

	     catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

	}

	public static String[] BuildReportFilter(String sYear, String sMonth,int iNoMonths) {
		// TODO Auto-generated method stub
		String [] Fiscalmonths = {"AUG","SEP","OCT","NOV","DEC","JAN","FEB","MAR","APR","MAY","JUN","JUL"};
		String [] FilterSelectionMonths = new String[iNoMonths];

 		int StartMonthindex = 0;

			for (int j=0 ; j< Fiscalmonths.length ; j++)
			{
				if ( sMonth.toUpperCase().contains(Fiscalmonths[j])  )
				{
					StartMonthindex = j;
					break;
				}
			}

			int j = StartMonthindex ;
			for (int i = 0 ; i < iNoMonths ; i++)
			{
				FilterSelectionMonths[i] = Fiscalmonths[j] + " " +  sYear.substring(0, 2) + "20" + sYear.substring(sYear.length()-2);

				if(j < Fiscalmonths.length - 1)
				{
					j = j + 1 ;
				}
				else
				{
					j = 0;
					sYear = sYear.substring(0, 2) + (Integer.parseInt(sYear.substring(sYear.length()-2)) + 1);

				}

			}
		return FilterSelectionMonths;
	}

	public static void DashboardCubeTemplate(String DashboardFolderName, String ReportName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Opening Excel Template and Refreshing data
		System.out.println("Refreshing Cube Excel Template...");
		Desktop.getDesktop().open(new File( DashboardFolderName+"Baseline\\" + ReportName + ".xlsm"));
		/*
		//Delete Existing Files
		System.out.println("Deleting existing files");
		File file1 = new File(DashboardFolderName +"Results\\Report_" + ReportName +".xlsx");
		if(file1.exists()){
			file1.delete();
		}

		 Thread.sleep(15000);

		//Coverting .xls to .xlsx file
		String filename = "E:\\fpm-it_test_automation\\workspace\\FINBI_E2E_WebApp\\FINBI_E2E\\vbscript\\ExcelConvertor.vbs" + " \"" + DashboardFolderName +"Results\\Report_" + ReportName + "\"" ;
		System.out.println(filename);
		Runtime.getRuntime().exec("cmd /c " + filename);

		Thread.sleep(10000);*/

	}

	public static void CompGSPSummaryReports(String DashboardFolderName, String sComparisionReport,String Screen) throws Exception {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(DashboardFolderName + sComparisionReport));
		XSSFSheet worksheet1 = workbook.getSheetAt(0);
		XSSFSheet worksheet2 = workbook.getSheetAt(1);

		System.out.println("Comparing two reports");

		File file = new File(DashboardFolderName + sComparisionReport);

		List cellDataList1 = new ArrayList();
	  	List cellDataList2 = new ArrayList();
	  	List cellValidatedList = new ArrayList();

	  	cellDataList1 = RetriveExcelData(worksheet1);
	  	cellDataList2 = RetriveExcelData(worksheet2);

	  	XSSFCellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1 = workbook.createCellStyle();
        cellStyle1.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        cellStyle1.setFillPattern(CellStyle.SOLID_FOREGROUND);

        XSSFCellStyle cellStyle2 = workbook.createCellStyle();
        cellStyle2 = workbook.createCellStyle();
        cellStyle2.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        cellStyle2.setFillPattern(CellStyle.SOLID_FOREGROUND);

	  	int headerRowNumStart=0;
	  	int headerRowNumEnd=0;
	  	int attributeColNumEnd=0;

	  	if(Screen.equalsIgnoreCase("Bookings-Summary"))
	  	{
		  	for (int i = 0; i < cellDataList1.size(); i++) {
		          List cellTempList = (List) cellDataList1.get(i);
		             for (int j = 0; j < cellTempList.size(); j++) {
			              XSSFCell xssfCell = (XSSFCell) cellTempList.get(j);
			              if(xssfCell.getCellType() == Cell.CELL_TYPE_STRING)
			              {
			                 switch(xssfCell.getStringCellValue().trim())
			                 {
			                 	case "Anchor Year":
			                 		headerRowNumStart = xssfCell.getRowIndex();
			                 	case "Metrics":
			                 		headerRowNumEnd = xssfCell.getRowIndex();
			                 		//attributeColNumEnd = xssfCell.getColumnIndex();
			                 }
			              }
			          }
			}


		  	int maxColumnNum = 0;
		    XSSFSheet newSheet = workbook.createSheet("Report 1 vs Report 2");

		  	for (int i = headerRowNumStart ; i <= worksheet1.getLastRowNum(); i++) {
		  		XSSFRow srcRow = worksheet1.getRow(i);
		  		XSSFRow destRow = newSheet.createRow(i);
		  		if (srcRow != null) {
		  			destRow.setHeight(srcRow.getHeight());
		  		    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
		  		      XSSFCell oldCell = srcRow.getCell(j);
		  		      XSSFCell newCell = destRow.getCell(j);
		  		      if (oldCell != null) {
				  		        if (newCell == null) {
				  		          newCell = destRow.createCell(j);
				  		        }
				  		      switch(oldCell.getCellType()) {
				  		      case XSSFCell.CELL_TYPE_STRING:
				  		        newCell.setCellValue(oldCell.getRichStringCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_NUMERIC:
				  		        newCell.setCellValue(oldCell.getNumericCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_BLANK:
				  		        newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
				  		        break;
				  		      case XSSFCell.CELL_TYPE_BOOLEAN:
				  		        newCell.setCellValue(oldCell.getBooleanCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_ERROR:
				  		        newCell.setCellErrorValue(oldCell.getErrorCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_FORMULA:
				  		        newCell.setCellFormula(oldCell.getCellFormula());
				  		        break;
				  		      default:
				  		        break;
				  		    }

				  		    if (oldCell.getColumnIndex() > attributeColNumEnd && oldCell.getRowIndex() > headerRowNumEnd )
				  		    {
				  		    	for (int k = headerRowNumEnd  ; k <= worksheet2.getLastRowNum(); k++) {
				  		    		XSSFRow srcRow1H1 = worksheet1.getRow(4);
				  		    		XSSFRow srcRow1H2 = worksheet1.getRow(5);
				  		    		XSSFRow srcRow2 = worksheet2.getRow(k);
				  		    		XSSFRow srcRow2H1 = worksheet2.getRow(1);
				  		    		XSSFRow srcRow2H2 = worksheet2.getRow(2);
				  		    		if (srcRow != null && srcRow1H2.getCell(j).getStringCellValue().trim().contentEquals("Current")) {
					  		    		for (int l = srcRow2.getFirstCellNum(); l <= srcRow2.getLastCellNum(); l++) {
					  		    			 if(srcRow2H1.getCell(l) != null)
					  		    			 {
				  		    			  		String sYear=  srcRow2H1.getCell(l).getStringCellValue().trim();
							  			  		if(sYear.length() > 0 && srcRow1H1.getCell(j).getStringCellValue().trim().contentEquals(srcRow2H2.getCell(l).getStringCellValue().trim() + sYear.substring(sYear.length()-2)))
							  			  		{
							  			  	     	newCell.setCellValue(oldCell.getNumericCellValue() - srcRow2.getCell(l).getNumericCellValue());
							  			  	     	double diff = oldCell.getNumericCellValue() - srcRow2.getCell(l).getNumericCellValue() ;

								  		  			if( diff > -100 && diff < 100)
								  		  			{
								  		  				newCell.setCellStyle(cellStyle2);
								  		  			}
								  		  			else
								  		  			{
								  		  				newCell.setCellStyle(cellStyle1);
								  		  			}

							  			  		}
					  		    			 }
							  			 }
				  		    		}

				  		    	}

				  		    }

		  		      	}

		  		    }
			        if (srcRow.getLastCellNum() > maxColumnNum) {
			            maxColumnNum = srcRow.getLastCellNum();
			        }
			      }
			    }
	  	}
		else
		{
			for (int i = 0; i < cellDataList1.size(); i++) {
		          List cellTempList = (List) cellDataList1.get(i);
		             for (int j = 0; j < cellTempList.size(); j++) {
			              XSSFCell xssfCell = (XSSFCell) cellTempList.get(j);
			              if(xssfCell.getCellType() == Cell.CELL_TYPE_STRING)
			              {
			                 switch(xssfCell.getStringCellValue().trim())
			                 {
			                 	case "Anchor Year":
			                 		headerRowNumStart = xssfCell.getRowIndex();
			                 	case "Current":
			                 		headerRowNumEnd = xssfCell.getRowIndex();
			                 }
			              }
			          }
			}


		  	int maxColumnNum = 0;
		    XSSFSheet newSheet = workbook.createSheet("Report 1 vs Report 2");

		  	for (int i = headerRowNumStart ; i <= worksheet1.getLastRowNum(); i++) {
		  		XSSFRow srcRow = worksheet1.getRow(i);
		  		XSSFRow destRow = newSheet.createRow(i);
		  		if (srcRow != null) {
		  			destRow.setHeight(srcRow.getHeight());
		  		    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
		  		      XSSFCell oldCell = srcRow.getCell(j);
		  		      XSSFCell newCell = destRow.getCell(j);
		  		      if (oldCell != null) {
				  		        if (newCell == null) {
				  		          newCell = destRow.createCell(j);
				  		        }
				  		      switch(oldCell.getCellType()) {
				  		      case XSSFCell.CELL_TYPE_STRING:
				  		        newCell.setCellValue(oldCell.getRichStringCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_NUMERIC:
				  		        newCell.setCellValue(oldCell.getNumericCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_BLANK:
				  		        newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
				  		        break;
				  		      case XSSFCell.CELL_TYPE_BOOLEAN:
				  		        newCell.setCellValue(oldCell.getBooleanCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_ERROR:
				  		        newCell.setCellErrorValue(oldCell.getErrorCellValue());
				  		        break;
				  		      case XSSFCell.CELL_TYPE_FORMULA:
				  		        newCell.setCellFormula(oldCell.getCellFormula());
				  		        break;
				  		      default:
				  		        break;
				  		    }

				  		    if (oldCell.getColumnIndex() > attributeColNumEnd && oldCell.getRowIndex() >= headerRowNumEnd )
				  		    {
				  		    	for (int k = headerRowNumEnd  ; k <= worksheet2.getLastRowNum(); k++) {
				  		    		XSSFRow srcRow1H1 = worksheet1.getRow(3);
				  		    		XSSFRow srcRow1H2 = worksheet1.getRow(4);
				  		    		XSSFRow srcRow2 = worksheet2.getRow(k);
				  		    		XSSFRow srcRow2H1 = worksheet2.getRow(1);
				  		    		XSSFRow srcRow2H2 = worksheet2.getRow(2);
				  		    		for (int l = srcRow2.getFirstCellNum(); l <= srcRow2.getLastCellNum(); l++) {
					  		    	  if(srcRow2H1.getCell(l) != null)
					  		    	 {
				  		    				String sYear=  srcRow2H1.getCell(l).getStringCellValue().trim();
							  		  		if(sYear.length() > 0 && srcRow1H1.getCell(j).getStringCellValue().trim().contentEquals(srcRow2H1.getCell(l).getStringCellValue().trim()) && srcRow1H2.getCell(j).getStringCellValue().trim().contentEquals(srcRow2H2.getCell(l).getStringCellValue().trim()))
							  		  		{
							  		  			newCell.setCellValue(oldCell.getNumericCellValue() - srcRow2.getCell(l).getNumericCellValue());
							  		  		    double diff = oldCell.getNumericCellValue() - srcRow2.getCell(l).getNumericCellValue() ;

							  		  			if( diff > -100 && diff < 100)
							  		  			{
							  		  				newCell.setCellStyle(cellStyle2);
							  		  			}
							  		  			else
							  		  			{
							  		  				newCell.setCellStyle(cellStyle1);
							  		  			}
							  		  		}
					  		    	  }
							  		}

				  		    	}

				  		    }

		  		      	}

		  		    }
			        if (srcRow.getLastCellNum() > maxColumnNum) {
			            maxColumnNum = srcRow.getLastCellNum();
			        }
			      }
			    }

		}
		writeFile(workbook, file);

		workbook.close();
		System.out.println("Report Generated");

	}
	public static void UpdateDashboardExcelConfig(String sCubeTemplateFolder, String sFiscalQtrs,String CubeApplication,String CubeDatabase,String CubeServer) {
		// TODO Auto-generated method stub
		File xmlFile = new File(sCubeTemplateFolder + "XML//CFAConfig.xml" );
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //update attribute value
            Element var = (Element)doc.getElementsByTagName("Details").item(0);
            var.getElementsByTagName("FiscalQtrs").item(0).getFirstChild().setNodeValue(sFiscalQtrs.toString());

            var.getElementsByTagName("Application").item(0).getFirstChild().setNodeValue(CubeApplication.toString());
            var.getElementsByTagName("DataBase").item(0).getFirstChild().setNodeValue(CubeDatabase.toString());
            var.getElementsByTagName("ServerName").item(0).getFirstChild().setNodeValue(CubeServer.toString());

            //write the updated document to file or console
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");

        } catch (Exception e1) {
            e1.printStackTrace();
        }


	}

	public static void GSPiCubeDataDownload(String CFADashboardFolder,String ReportFolderPath, String sScreen, String sFiscalQtr) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
		String UserID = UtilLib.getUpdatedParam("CFAUserID");
		String Password = UtilLib.getUpdatedParam("CFAPwd");
		String sReportURL;
		String ReportName = "GSP_Bookings Report Summary DS_Auto";
		String[] ReportFilter =  sFiscalQtr.split(";");

		//Delete Existing Files
		System.out.println("Deleting existing files");
		File file1 = new File(CFADashboardFolder + ReportName + ".xls");
		if(file1.exists()){
			file1.delete();
		}

		File file2 = new File(CFADashboardFolder + ReportName + ".xlsx");
		if(file2.exists()){
			file2.delete();
		}

		FirefoxProfile profile = new FirefoxProfile();
		// Set preferences for file type
		profile.setPreference("browser.download.dir", CFADashboardFolder);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
		//profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		profile.setPreference("signon.autologin.proxy", "true");

		// Open Webbrowser
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();

		// Open URL with AutoIT script for authentication
		System.out.println("Open the link....");
		//Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
		driver.get(sCFAUrl);

		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.id("userInput")).sendKeys(UserID);
		doWaitforElement(driver,By.id("userInput"));
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		//Navigate to the Report folder
		System.out.println("Navigate to the folder....");
		doWaitforElement(driver,By.id("myWorkplace"));
		driver.findElement(By.id("myWorkplace")).click();

		String aReportFolderPath[]=ReportFolderPath.split(">");
		doWaitforElement(driver,By.id("mstrFrame"));
	    driver.switchTo().frame("mstrFrame");
	    for (int i = 0 ; i < aReportFolderPath.length;i++)
	    {
	    	doWaitforElement(driver,By.linkText(aReportFolderPath[i]));
	        sReportURL = driver.findElement(By.linkText(aReportFolderPath[i])).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	        doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]"));
	        driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[1]")).click();

	    }

	    //Edit the report
	    doWaitforElement(driver,By.linkText(ReportName));
	    sReportURL = driver.findElement(By.linkText(ReportName)).getAttribute("href").replaceAll("https://wwwin-webapps-stage..com/MicroStrategy10/servlet/", "");
	    doWaitforElement(driver,By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[2]"));
	    WebElement wb = driver.findElement(By.xpath("(//a[contains(@href,'"+(sReportURL)+"')])[2]"));

	    Actions oAction = new Actions(driver);
	    oAction.moveToElement(wb);
	    oAction.contextClick(wb).build().perform();
	    driver.findElement(By.xpath("//table[@class='mstrContextMenuRight']/tbody/tr[1]/td[3]")).click();

	    doWaitforElement(driver,By.xpath("//div[text()='Tools']"));
	    driver.findElement(By.xpath("//div[text()='Tools']")).click();

	    doWaitforElement(driver,By.xpath("//span[@title='View Filter']"));
	    driver.findElement(By.xpath("//span[@title='View Filter']")).click();

	    doWaitforElement(driver,By.className("mstr-filter-text-editable"));
	    driver.findElement(By.className("mstr-filter-text-editable")).click();

	    //Remove all the values selected for the report
	    doWaitforElement(driver,By.xpath("(//img[contains(@title,'Remove all')])"));
	    driver.findElement(By.xpath("(//img[contains(@title,'Remove all')])")).click();

	    //Select the values for report filter
	    System.out.println("Applying Filter....");
	    for (int i = 0 ; i < ReportFilter.length ; i++)
	    {
	    	ReportFilter[i] = ReportFilter[i].substring(3) + " " + ReportFilter[i].substring(0,2) ;
	    	doWaitforElement(driver,By.xpath("(//label[contains(text(),'Search for')])"));
	    	String inputelementid = driver.findElement(By.xpath("(//label[contains(text(),'Search for')])")).getAttribute("for");
	    	doWaitforElement(driver,By.id(inputelementid));
	    	driver.findElement(By.id(inputelementid)).clear();
	    	driver.findElement(By.id(inputelementid)).sendKeys(ReportFilter[i].replace(" ", "%"));
		    doWaitforElement(driver,By.id("cartSearchButton"));
		    driver.findElement(By.id("cartSearchButton")).click();
		    Thread.sleep(5000);
		    doWaitforElement(driver,By.xpath("(//img[contains(@title,'Add all elements to selections')])"));
		    driver.findElement(By.xpath("(//img[contains(@title,'Add all elements to selections')])")).click();

	    }

	    doWaitforElement(driver,By.id("acceptButton"));
	    driver.findElement(By.id("acceptButton")).click();

	    Thread.sleep(15000);
	    doWaitforElement(driver,By.xpath("//div[text()='Report Home']"));
	    driver.findElement(By.xpath("//div[text()='Report Home']")).click();

	    //Export data to excel
	    Thread.sleep(10000);
	    System.out.println("Exporting to excel....");
	    doWaitforElement(driver, By.xpath("(//span[@title='Export'])"));
	    driver.findElement(By.xpath("(//span[@title='Export'])")).click();

	    Thread.sleep(15000);
	    Set<String> set2 = driver.getWindowHandles();
		Iterator<String> win2 = set2.iterator();
		String parentwindow = win2.next();
		String childwindow = win2.next();
		driver.switchTo().window(childwindow);
		System.out.println(ReportName + " Report is downloaded");

		//Closing browser
	    System.out.println("Closing the Browser....");
	  	driver.close();
	  	driver.quit();

	  //Coverting .xls to .xlsx file
		File file = new File(CFADashboardFolder + "GSP_Bookings Report Summary DS_Auto.xls");
		if(file.exists()){
			String filename = "E:\\fpm-it_test_automation\\workspace\\FINBI_E2E_WebApp\\FINBI_E2E\\vbscript\\ExcelConvertor.vbs" + " \"" + CFADashboardFolder + "GSP_Bookings Report Summary DS_Auto\""  ;
			System.out.println(filename);
			Runtime.getRuntime().exec("cmd /c " + filename);
		}

		Thread.sleep(10000);

	}

	public static void GSPDashboardDownloadChrome(String CFADashboardFolder,String ScreenType)
	{
		try {
	    	 //Browse GSP Dashboard and download the excel
			String sCFAUrl = UtilLib.getUpdatedParam("CFAURL");
			String UserID = UtilLib.getUpdatedParam("CFAUserID");
			String Password = UtilLib.getUpdatedParam("CFAPwd");

			//Delete Existing Files
			System.out.println("Deleting existing files");
			File file1 = new File(CFADashboardFolder + "GSP P & L.xls");
			if(file1.exists()){
				file1.delete();
			}

			File file2 = new File(CFADashboardFolder + "GSP P & L.xlsx");
			if(file2.exists()){
				file2.delete();
			}

			/*Chrome profile = new FirefoxProfile();
			// Set preferences for file type
			profile.setPreference("browser.download.dir", CFADashboardFolder);
			profile.setPreference("browser.download.folderList", 2);
			//profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			profile.setPreference("signon.autologin.proxy", "true");*/

			// Open Webbrowser
			System.setProperty("webdriver.chrome.driver","C:\\Users\\lvepuri\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Open URL with AutoIT script for authentication
			System.out.println("Opening the link....");
			//Runtime.getRuntime().exec("C:\\Users\\lvepuri\\Desktop\\CFA-Automation\\GMDashboardPOC\\AutoIT Script\\authentication.exe");
			driver.get(sCFAUrl);

			doWaitforElement(driver,By.id("userInput"));
			driver.findElement(By.id("userInput")).sendKeys(UserID);
			doWaitforElement(driver,By.id("userInput"));
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.xpath("//input[@value='Log In']")).click();

			//Opening the Dashboard
			System.out.println("Opening the Dashboard....");
			doWaitforElement(driver,By.xpath("//span[text()='Global Service Provider']"));
			driver.findElement(By.xpath("//span[text()='Global Service Provider']")).click();

			doWaitforElement(driver,By.id("mstrFrame"));
		    driver.switchTo().frame("mstrFrame");

		    doWaitforElement(driver,By.xpath("//div[@class='mstrmojo-Button  mstrmojo-oivmSprite tbDown']"));

			List<WebElement> rows =driver.findElements(By.xpath("//div[@class='mstrmojo-Button  mstrmojo-oivmSprite tbDown']"));

			java.util.Iterator<WebElement> i = rows.iterator();
			while(i.hasNext()) {

				if(ScreenType.trim().contains("Bookings-Summary"))
				{
					WebElement row = i.next();
					row.click();

				    System.out.println("Downloading Excel");

				    doWaitforElement(driver,By.xpath("//td[text()='Export to Excel']"));
				    driver.findElement(By.xpath("//td[text()='Export to Excel']")).click();
				    Thread.sleep(30000);
					Set<String> set2 = driver.getWindowHandles();
					Iterator<String> win2 = set2.iterator();
					String parentwindow = win2.next();
					String childwindow = win2.next();
					driver.switchTo().window(childwindow);
					System.out.println("Dashboard is downloaded");
					driver.close();

					//Coverting .xls to .xlsx file
					File file3 = new File(CFADashboardFolder + "GSP P & L.xls");
					if(file3.exists()){
						String filename = "E:\\fpm-it_test_automation\\workspace\\FINBI_E2E_WebApp\\FINBI_E2E\\vbscript\\ExcelConvertor.vbs" + " \"" + CFADashboardFolder + "GSP P & L\""  ;
						System.out.println(filename);
						Runtime.getRuntime().exec("cmd /c " + filename);
					}

				    driver.switchTo().window(parentwindow);
					//driver.switchTo().frame("mstrFrame");

				    break;
				}


			}



			Thread.sleep(10000);

			driver.quit();


	     }

	     catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

	}

	/* Code added for CFA POC - 15th Jul */




}
