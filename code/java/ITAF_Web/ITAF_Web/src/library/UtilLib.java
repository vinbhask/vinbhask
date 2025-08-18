package library;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
//import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.api.DesktopScreenRegion;
//import org.sikuli.api.ImageTarget;
//import org.sikuli.api.ScreenRegion;
//import org.sikuli.api.Target;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
//import org.testng.Assert;
import org.testng.Assert;
import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import java.io.BufferedWriter;
import java.io.FileWriter;
//import java.io.File;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;




public class UtilLib {

	private static WebDriver driver;
	public boolean result;

    public static String newline = System.getProperty("line.separator");
    public static Object_Definition_Library prm = new Object_Definition_Library();
	private static WebElement element = null;
    private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	static int keyInput[] =
	{KeyEvent.VK_DOWN};
	 static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
     static Date date = new Date();

	 //static String AESASJOBSattachFiles="C:\\Users\\vinbhask\\Desktop\\Environment_Validations_Results.xls";




	public static String encrypt(String Data) throws Exception {
		//System.out.println("Inside encrypt function");
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}

    public static String cubePasswordEncode(String Data) {
  	  String encryptedString = "";
  	  try {
  		  for (char ch: Data.toCharArray()) {
  			 //System.out.println(ch);
  			 int ascii = (int) ch;
  			 int asciivalue= ascii+5;
  			 char character = (char)asciivalue;
  			 encryptedString=encryptedString+character;
  		 }
  		 //System.out.println(encryptedString);
  	  }
  	   catch (OverlappingFileLockException e) {
  	      // File is open by someone else
  	  }
	return encryptedString;
	}

	/********************************************************************************************
	 * @return
	 * @Function_Name :  Key in URL
	 * @Description : Applying URL according to environment
	********************************************************************************************/
		public static WebDriver KeyInURL(String Env, WebDriver driver){

			if (Env.equalsIgnoreCase("PROD")){
		  		driver.get(UtilLib.getEnvVar("PRODURL"));
		  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  		driver.manage().window().maximize();
		  			}
		  		else {
		  			driver.get(UtilLib.getEnvVar("STGURL"));
			  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  		driver.manage().window().maximize();
			  		Select dropdown = new Select(driver.findElement(By.xpath(prm.logon_dropDown)));
			 	    dropdown.selectByVisibleText(prm.logon_dropDownOpt);
		  			}
			return driver;

		}

		/********************************************************************************************
		 * @return
		 * @return
		 * @throws MalformedURLException
		 * @Function_Name :  Key in URL
		 * @Description : Applying URL according to environment
		 ********************************************************************************************/
			public static WebDriver  InitiateBrowser(String Env) throws MalformedURLException{

					driver=new FirefoxDriver();
					/*DesiredCapabilities capability = DesiredCapabilities.firefox();
					WebDriver driver = new RemoteWebDriver(new URL("http://173.38.100.170:4444/wd/hub"), capability);*/
				 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					System.out.println("Launching the browser...");
				if (Env.equalsIgnoreCase("PROD")){
			  		driver.get(UtilLib.getEnvVar("PRODURL"));
			  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  		driver.manage().window().maximize();
			  			}
			  	else {
			  			driver.get(UtilLib.getEnvVar("STGURL"));
				  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  		driver.manage().window().maximize();

			  		}
				if (Env.equalsIgnoreCase("PROD"))
				{
					try{
					driver.findElement(By.xpath(prm.logon_userName)).clear();
					driver.findElement(By.xpath(prm.logon_userName)).sendKeys(UtilLib.getCredentials("BOProdUserName"));
					driver.findElement(By.xpath(prm.logon_passWord)).clear();
					driver.findElement(By.xpath(prm.logon_passWord)).sendKeys(UtilLib.decrypt(UtilLib.getCredentials("BOProdPassword")));
					}
					catch(Exception e){
						e.printStackTrace();
					}
	    		}
			else
				{
					try{
						driver.switchTo().frame("servletBridgeIframe");
						//driver.findElement(By.xpath(prm.BOUISystemNameXpath)).clear();
						//driver.findElement(By.xpath(prm.BOUISystemNameXpath)).sendKeys(UtilLib.getEnvVar("BOUISystemName"));
						driver.findElement(By.xpath(prm.logon_userName)).clear();
						driver.findElement(By.xpath(prm.logon_userName)).sendKeys(UtilLib.getCredentials("BOUIStgUserName"));
						driver.findElement(By.xpath(prm.logon_passWord)).clear();
						driver.findElement(By.xpath(prm.logon_passWord)).sendKeys(UtilLib.decrypt(UtilLib.getCredentials("BOUIStgPassword")));
						Select selectByVisibleText = new Select (driver.findElement(By.xpath(prm.logon_dropDown)));
						selectByVisibleText.selectByVisibleText(prm.logon_dropDownOpt);

					}
					catch(Exception e){
						e.printStackTrace();
					}
				}

				/*Select dropdown = new Select(driver.findElement(By.xpath(prm.logon_dropDown)));
		 	    dropdown.selectByVisibleText(prm.logon_dropDownOpt);*/
		 	    driver.findElement(By.xpath(prm.logon_click)).click();
				return driver;

				//return driver;

			}



	/********************************************************************************************
	 * @Function_Name :  SAP_BO_login
	 * @Description : Initiate Browser and navigate to the URL and login
	 * @param TestCase_Name - Name of the TestCase
	 * @param AccessType - Operations/Admin
	 * @throws IOException
	 ********************************************************************************************/

		@SuppressWarnings("unused")
		public static void BO_Login(String URL,String Credentials, WebDriver driver) throws IOException{
		try
	     {
	         FileInputStream fstream = new FileInputStream(Credentials);
	         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	         String strLine;
	         int count = 0;
	         count++;

	         while((strLine = br.readLine())!= null)
	         {
	              UtilLib.txtbx_UserName(driver).sendKeys(strLine);
	              strLine = br.readLine();
	              count++;
	              UtilLib.txtbx_Password(driver).sendKeys(strLine);
	         }
	         br.close();
	         UtilLib.btn_LogIn(driver).click();

	         System.out.println("****** Continuing after login********");
	         Thread.sleep(5000);
	        // UtilLib.click_element(driver);
	     }
	     catch (Exception e)
	     {
	         System.err.println("Error: " + e.getMessage());
	     }

		}
		public static  WebElement txtbx_UserName(WebDriver driver){
	    	driver.findElement(By.xpath(prm.logon_userName)).clear();
	    	element = driver.findElement(By.xpath(prm.logon_userName));
	          return element;
	 	         }

	    public static WebElement txtbx_Password(WebDriver driver){
	    	 driver.findElement(By.xpath(prm.logon_passWord)).clear();
	         element = driver.findElement(By.xpath(prm.logon_passWord));
	 	     return element;
	 	         }

	    public static WebElement btn_LogIn(WebDriver driver) {
	   	        element = driver.findElement(By.xpath(prm.logon_click));
	            return element;

	         }



		/********************************************************************************************
		 * @Function_Name :  SAP_BO_login
		 * @Description : Initiate Browser and navigate to the URL and login
		 * @param TestCase_Name - Name of the TestCase
		 ********************************************************************************************/

			@SuppressWarnings("unused")
			public static void BO_Login_WebIntelligence(String URL,String Credentials) throws IOException{

			WebDriver driver=new FirefoxDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			try
		     {
		         FileInputStream fstream = new FileInputStream(prm.credentials_prod);
		         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		         String strLine;
		         int count = 0;
		         count++;

		         while((strLine = br.readLine())!= null)
		         {
		              UtilLib.txtbx_UserName(driver).sendKeys(strLine);
		              strLine = br.readLine();
		              count++;
		              UtilLib.txtbx_Password(driver).sendKeys(strLine);
		         }
		         br.close();
		         UtilLib.btn_LogIn(driver).click();

		         System.out.println("****** Continuing after login********");
		         Thread.sleep(5000);
		        // POM_Lib.click_element(driver);
		     }
		     catch (Exception e)
		     {
		         System.err.println("Error: " + e.getMessage());
		     }

			}


			/********************************************************************************************
			 * @Function_Name :  SAP_BO_Sikuli
			 * @Description : Use Sikuli to identify and click the elements
			 * @param TestCase_Name - Name of the TestCase
			 ********************************************************************************************/
			public static void  click_element(String url){

			try
		    {  Screen s = new Screen();
		 	   Pattern image = new Pattern(url);
		 	   s.wait(image, 10);
		 	   s.click(image);

		    }
		     catch (Exception e)
		    {
		        e.printStackTrace();
		    }
		     return   ;
			}

			public static void  click_element_targetOffset(String url){

			try
		    {  Screen s = new Screen();
		 	   Pattern image = new Pattern(url).targetOffset(-57,1);
		 	   s.wait(image, 10);
		 	   s.click(image);
		    }
		     catch (Exception e)
		    {
		        e.printStackTrace();
		    }
		     return   ;
			}

			public static void  click_element_doubleclick(String url){

				try
			    {  Screen s = new Screen();
			 	   Pattern image = new Pattern(url);
			 	   s.wait(image, 10);
			 	   s.doubleClick(image);
			     }
			     catch (Exception e)
			    {
			        e.printStackTrace();
			    }
			     return   ;
				}

			public static void type_element(String path, String text){
				try
			    {  Screen s = new Screen();
			 	   Pattern image = new Pattern(path);
			 	   s.wait(image, 10);
			 	   s.click(image);
			 	   s.type(text);
			     }
			     catch (Exception e)
			    {
			        e.printStackTrace();
			    }
			     return   ;
				}



		/********************************************************************************************
		 * @Function_Name :  MultiFlow Check
		 * @Description : Checking for Multiflow after clicking on 'View Script'
		 * @param TestCase_Name - Name of the TestCase
		 * @throws InterruptedException
		 ********************************************************************************************/
		public static boolean imgCheck(String url) throws FindFailed, InterruptedException{
			Thread.sleep(3000);
			Screen s = new Screen();
			//if (s.exists(new Pattern(UtilLib.getImagePath("ViewScriptError")).exact()) != null)
			//	{
			//		return false;
			//	}

			/*else*/ if (s.exists(new Pattern(url).exact()) != null)
			{
			 return true;
			}
		else {
			 return false;
		     }
		}



		/********************************************************************************************
		 * @Function_Name :  Get firefox driver
		 * @Description : Get firefox driver
		 ********************************************************************************************/
		public static WebDriver getdriver(String Envi){

			if(driver!= null){
				driver.getWindowHandle();
				UtilLib.KeyInURL(Envi, driver);
				return driver;
			}
			else {
				 driver=new FirefoxDriver();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  	 driver.manage().window().maximize();
			  	 UtilLib.KeyInURL(Envi, driver);
			  	return driver;
			}

		}

		/********************************************************************************************
		 * @Function_Name :  SAP_BO_MultiFlow_Error
		 * @Description : MultiFlow Error Message
		 ********************************************************************************************/
		public static void MultiflowError(){

			 final JOptionPane optionPane = new JOptionPane("Please check the compatibility... this window will auto close in 5 secs", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
			   final JDialog dialog = new JDialog();
			   dialog.setTitle("Message");
			   dialog.setLocation(10, 10);
			   dialog.setModal(true);
			   dialog.setContentPane(optionPane);
			   dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			   dialog.pack();
			   //create timer to dispose of dialog after 5 seconds
			   Timer timer = new Timer(5000, new AbstractAction() {
			    private static final long serialVersionUID = 1L;
				@Override
			       public void actionPerformed(ActionEvent ae) {
			           dialog.dispose();
			       }
			   });
			   timer.setRepeats(false);//the timer should only go off once
			   //start timer to close JDialog as dialog modal we must start the timer before its visible
			   timer.start();
			   dialog.setVisible(true);


		}/*

		*//********************************************************************************************
		 * @Function_Name :  SAP_BO_ReadExcel
		 * @Description : MultiFlow Error Message
		 ********************************************************************************************//*

		  @SuppressWarnings({ "unchecked", "rawtypes" })
		  public static HashMap readExcelFile(String fileName, int file) {
			  HashMap multipleSheetData = new HashMap();
		        HashMap cellData;
		        int NumberOfSheets;
		        try {
		            FileInputStream myInput = new FileInputStream(fileName);
		            HSSFWorkbook myWorkBook = new HSSFWorkbook(myInput);
		            NumberOfSheets = myWorkBook.getNumberOfSheets();
		            if (file == 1) {
		                SheetNames1 = new String[NumberOfSheets];
		            } else {
		                SheetNames2 = new String[NumberOfSheets];
		            }
		            for (int i = 0; i < NumberOfSheets; i++) {
		                if (file == 1) {
		                    SheetNames1[i] = myWorkBook.getSheetName(i);
		                } else {
		                    SheetNames2[i] = myWorkBook.getSheetName(i);
		                }
		                cellData = new HashMap();
		                HSSFSheet mySheet = myWorkBook.getSheetAt(i);
		                Iterator<Row> rowIter = mySheet.rowIterator();
		                while (rowIter.hasNext()) {
		                    HSSFRow myRow = (HSSFRow) rowIter.next();
		                    Iterator<Cell> cellIter = myRow.cellIterator();
		                    while (cellIter.hasNext()) {
		                        HSSFCell myCell = (HSSFCell) cellIter.next();
		                        cellData.put(ExcelColumns[myCell.getColumnIndex()] + (myRow.getRowNum() + 1), myCell);
		                    }
		                }
		                multipleSheetData.put(i + "", cellData);
		            }
		        } catch (Exception e) {
		            System.out.println("Exception. " + e.getMessage());
		        }
		        return multipleSheetData;
		      }*/


		  /********************************************************************************************
			 * @Function_Name :  Log Reports
			 * @Description : Log Reports
			 * @param TestCase_Name - Name of the TestCase
		   ********************************************************************************************/
		  public static void LogReport(String TestCaseName, String Message)
		    {
			String fileName = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			File mainFolder = new File(UtilLib.getEnvVar("TextFileReportsPath")+"Reports_"+fileName);
			String subFolderPath=UtilLib.getEnvVar("TextFileReportsPath")+"Reports_"+fileName+"\\"+TestCaseName;
			File subFolder = new File(subFolderPath );
			//System.out.println("\"" + subFolderPath + "\"");
			//System.out.println(subFolderPath);
			if (!mainFolder.exists()) {
				//System.out.println("Creating Main folder");
				 mainFolder.mkdir();

				 if (!subFolder.exists()){
					// System.out.println("Creating sub folder");
					 subFolder.mkdir();
					 UtilLib.WriteLogToText(subFolderPath,Message);
				 }
				 else
				 {
					 UtilLib.WriteLogToText(subFolderPath,Message);
				 }

			}
			else {
			//System.out.println("Main Folder already exists!!");
			 if (!subFolder.exists()){
				 subFolder.mkdir();
				 UtilLib.WriteLogToText(subFolderPath,Message);
			}
			 else  UtilLib.WriteLogToText(subFolderPath,Message);

			}

		    }


		    /*********************************************************************************************
			 * @Function_Name :  WriteToLog
			 * @Description : Write Log to a text file
			 ********************************************************************************************/
		  public static void WriteLogToText(String subFolderPath,String Message){
			  String LogfileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.txt'").format(new java.util.Date());
			  Writer writer = null;

		        try {
		            String text = Message;
		            File file = new File(subFolderPath+"\\"+LogfileName);
		            writer = new BufferedWriter(new FileWriter(file));
		            writer.write(text);
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if (writer != null) {
		                    writer.close();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		  }

		  /*********************************************************************************************
			 * @Function_Name :  WriteLogInExcel
			 * @Description : Write Log to a Excel file
			 ********************************************************************************************/
		  public static void LogExcelReport(String TestCaseName, String Message, String TestCaseStatus, String ComponentType, String FilePath, String PeriodID, String Query, String StartTime, String ViewName){
			 // String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			  //String fileName = new SimpleDateFormat("yyyy-MM-dd'.xls'").format(new java.util.Date());
				//File mainFolder = new File(UtilLib.getEnvVar("ReportsPath")+"Excel_Report_"+folderName);
				File mainFolder = new File(UtilLib.getEnvVar("EnvironmentValidationsReportPath"));
				File ExcelFile= new File(UtilLib.getEnvVar("EnvironmentValidationsReportPath")+"Environment_Validations_Results.xls");
				if (!mainFolder.exists()&& !ExcelFile.exists()) {
					//System.out.println("Creating Main folder");
					 mainFolder.mkdir();
					 if(!ExcelFile.exists()){
						 //System.out.println("Create new folder");
						 CreateNewExcelForLog(TestCaseName,Message, TestCaseStatus,ComponentType, FilePath,PeriodID, Query,StartTime,ViewName);
					 }
					 else{

					 }
				}
				else if (mainFolder.exists()&& !ExcelFile.exists()){
					CreateNewExcelForLog(TestCaseName,Message, TestCaseStatus, ComponentType, FilePath,PeriodID, Query,StartTime,ViewName);
				}
				else{
					WriteLogToExcel(TestCaseName, TestCaseStatus,Message,ComponentType, FilePath,PeriodID, Query,StartTime,ViewName);
				}

		  }



		  /*********************************************************************************************
			 * @Function_Name :  CreateExcelForLog
			 * @Description : Write Log to a New Excel file
			 ********************************************************************************************/
		  public static void CreateNewExcelForLog(String TestCaseName, String Message, String TestCaseStatus,String ComponentType, String FilePath, String PeriodID,String Query, String StartTime, String ViewName){

			  try {
			  HSSFWorkbook workbook = new HSSFWorkbook();
			  HSSFSheet sheet = workbook.createSheet("Test_Execution_Results");


				 HSSFFont textFont = workbook.createFont();
				 textFont.setFontHeightInPoints((short) 10);
				 textFont.setColor(HSSFColor.WHITE.index);
				 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			  	 HSSFCellStyle style = workbook.createCellStyle();
				 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
				 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
				 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				 style.setFont(textFont);

			  HSSFRow row = sheet.createRow(0);
			  org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(0);
			  cell1.setCellValue("Sl no.");
			  cell1.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(1);
			  cell2.setCellValue("Track Name");
			  cell2.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(2);
			  cell3.setCellValue("View Name");
			  cell3.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(3);
			  cell4.setCellValue("Test Case Name");
			  cell4.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(4);
			  cell5.setCellValue("Status & Environment");
			  cell5.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(5);
			  cell6.setCellValue("Executed On");
			  cell6.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(6);
			  cell7.setCellValue("Time Taken (in secs)");
			  cell7.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell8 =  row.createCell(7);
			  cell8.setCellValue("Period Id");
			  cell8.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell9 =  row.createCell(8);
			  cell9.setCellValue("File Path");
			  cell9.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell10 =  row.createCell(9);
			  cell10.setCellValue("Comments");
			  cell10.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell11 =  row.createCell(10);
			  cell11.setCellValue("Query Used");
			  cell11.setCellStyle(style);

			  //String fileName = new SimpleDateFormat("yyyy-MM-dd'.xls'").format(new java.util.Date());
			 // String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		      //FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("ReportsPath")+"Excel_Report_"+folderName+"\\"+"Excel_Report"+".xls"));
			  FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("EnvironmentValidationsReportPath")+"Environment_Validations_Results"+".xls"));
				workbook.write(out);
				out.close();
				workbook.close();
				} catch (Exception e) {

					e.printStackTrace();
				}

		       // System.out.println("New Excel created...Will proceed to update it");

			  WriteLogToExcel(TestCaseName, TestCaseStatus,Message, ComponentType, FilePath,PeriodID, Query,StartTime,ViewName);
			}


		  /*********************************************************************************************
			 * @Function_Name :  WriteLogToExcel
			 * @Description : Write Log to Excel
		   ********************************************************************************************/
		  public static void WriteLogToExcel(String TestCaseName, String TestCaseStatus,String Message,String ComponentType, String FilePath, String PeriodID,String Query, String StartTime, String ViewName){
			  int UpdationCount=0;
			  String FilePathDisplayValue;
			  try{
				  if(FilePath==""){
					  FilePathDisplayValue="N/A";
				  }

				  else if( FilePath != null && !FilePath.isEmpty()&& FilePath!=""){
					   FilePathDisplayValue="Click to Open the file";
				 }
				 else{
					 FilePathDisplayValue="N/A";
				 }

			  HSSFHyperlink file_link=new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
			  file_link.setAddress(FilePath);

			  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_hh:mm").format(new java.util.Date());
			  //String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			  //FileInputStream logfile=new FileInputStream(new File(UtilLib.getEnvVar("ReportsPath")+"Excel_Report_"+folderName+"\\"+"Excel_Report"+".xls"));
			  FileInputStream logfile=new FileInputStream(new File(UtilLib.getEnvVar("EnvironmentValidationsReportPath")+"Environment_Validations_Results"+".xls"));
			  HSSFWorkbook workbook = new HSSFWorkbook(logfile);
			  HSSFSheet logsheet = workbook.getSheet("Test_Execution_Results");

			  /*CellStyle style = workbook.createCellStyle();
			  Font underlineFont = workbook.createFont();
			  underlineFont.setColor(HSSFColor.BLUE.index);
			  underlineFont.setUnderline(HSSFFont.U_SINGLE);
			  style.setFont(underlineFont);*/

			  UpdationCount=UtilLib.UpdateExcelLog(workbook,logsheet, TestCaseName,  TestCaseStatus, Message, ComponentType,  FilePath,  PeriodID, Query,StartTime);
			  //System.out.println("Updation Count is:"+UpdationCount);
			  if (UpdationCount<=0){

				  String StopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

				  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

					Date d1 = null;
					Date d2 = null;
					d1 = format.parse(StartTime);
					d2 = format.parse(StopTime);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					long diffSeconds = diff / 1000 ;
					//long diffMinutes = diff / (60 * 1000) % 60;

			  int rownum = logsheet.getLastRowNum();
			  HSSFRow row = logsheet.createRow(rownum+1);

			  org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(0);
			  cell1.setCellValue(rownum+1);

			  org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(1);
			  cell2.setCellValue(ComponentType);

			  org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(2);
			  cell3.setCellValue(ViewName);

			  org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(3);
			  cell4.setCellValue(TestCaseName);

			  org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(4);
			  cell5.setCellValue(TestCaseStatus);

			  org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(5);
			  cell6.setCellValue(timeStamp);

			  org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(6);
			  cell7.setCellValue(diffSeconds);

			  org.apache.poi.ss.usermodel.Cell cell8 =  row.createCell(7);
			  cell8.setCellValue(PeriodID);

			  org.apache.poi.ss.usermodel.Cell cell9 =  row.createCell(8);
			  cell9.setCellValue(FilePathDisplayValue);
			  cell9.setHyperlink(file_link);
			  //cell9.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell10 =  row.createCell(9);
			  cell10.setCellValue(Message);

			  org.apache.poi.ss.usermodel.Cell cell11 =  row.createCell(10);
			  cell11.setCellValue(Query);
			  }
			  else{
				 // System.out.println("Log for this testcase has been updated");
			  }

				for (int i=1;i<100;i++){
					logsheet.autoSizeColumn(i);
									}

			    //FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("ReportsPath")+"Excel_Report_"+folderName+"\\"+"Excel_Report"+".xls"));
			    FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("EnvironmentValidationsReportPath")+"Environment_Validations_Results"+".xls"));
				workbook.write(out);
				out.close();


			  }
			  catch (Exception e) {

					e.printStackTrace();
			  }
		  }





		  /*********************************************************************************************
			 * @Function_Name :  UpdateExcelLog
			 * @Description : Update the log if the test case already exists in the log file
		   ********************************************************************************************/
		  @SuppressWarnings({ "rawtypes", "unused" })
		public static int UpdateExcelLog(HSSFWorkbook workbook,HSSFSheet logsheet,String TestCaseName, String TestCaseStatus,String Message,String ComponentType, String FilePath, String PeriodID,String Query, String StartTime){
			  int updatecount=0;
			  String FilePathDisplayValue;
			  try{
				  if(FilePath==""){
					  FilePathDisplayValue="N/A";
				  }

				  else if( FilePath != null && !FilePath.isEmpty()&& FilePath!=""){
					   FilePathDisplayValue="Click to Open the file";
				 }
				 else{
					 FilePathDisplayValue="N/A";
				 }

				 /* CellStyle style = workbook.createCellStyle();
				  Font underlineFont = workbook.createFont();
				  underlineFont.setColor(HSSFColor.BLUE.index);
				  underlineFont.setUnderline(HSSFFont.U_SINGLE);
				  style.setFont(underlineFont);*/

				  HSSFHyperlink file_link=new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
				  file_link.setAddress(FilePath);

				  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_hh:mm").format(new java.util.Date());
				  String StopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

				  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

					Date d1 = null;
					Date d2 = null;
					d1 = format.parse(StartTime);
					d2 = format.parse(StopTime);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					long diffSeconds = diff / 1000 ;
					//long diffMinutes = diff / (60 * 1000) % 60;
				//	long diffHours = diff / (60 * 60 * 1000) % 24;
					//long diffDays = diff / (24 * 60 * 60 * 1000);


				  /* Update the log file if the test case already exists */
			  		Iterator rowIterator = logsheet.iterator();
			  			while (rowIterator.hasNext()){
			  					Row logrow = (Row) rowIterator.next();
			  						Iterator prodCellIterator = logrow.cellIterator();
				 					Cell prodcell1 = (Cell) prodCellIterator.next();
									Cell prodcell2 = (Cell) prodCellIterator.next();
									Cell prodcell3 = (Cell) prodCellIterator.next();
									Cell prodcell4 = (Cell) prodCellIterator.next();
									Cell cell =null;
									if (prodcell4.getStringCellValue().trim().toUpperCase().equalsIgnoreCase(TestCaseName)){
										//System.out.println("The cell value is: "+prodcell3.getStringCellValue().trim().toUpperCase());
										/* Update status */
										cell=logrow.getCell(4);
										cell.setCellValue(TestCaseStatus);
										//System.out.println(logrow.getCell(0));

										/* Update Execution time stamp */
										cell=logrow.getCell(5);
										cell.setCellValue(timeStamp);

										/* Update Time taken */
										cell=logrow.getCell(6);
										cell.setCellValue(diffSeconds);

										/* Update Period Id */
										cell=logrow.getCell(7);
										cell.setCellValue(PeriodID);

										/* Update FilePath*/
										cell=logrow.getCell(8);
										cell.setCellValue(FilePathDisplayValue);
										cell.setHyperlink(file_link);
										//cell.setCellStyle(style);

										/* Update Comments */
										cell=logrow.getCell(9);
										cell.setCellValue(Message);

										/* Update Query */
										cell=logrow.getCell(10);
										cell.setCellValue(Query);

										updatecount=updatecount+1;

									}

			  			}

			  }
			  catch (Exception e) {

					e.printStackTrace();
			  }
			return updatecount;
		  }


		  /*********************************************************************************************
			 * @Function_Name :  WriteLogInExcel
			 * @Description : Write Log to a Excel file
			 ********************************************************************************************/
		  public static void LogExcelReportForCompatibility(String TestCaseName, String Message, String TestCaseStatus, String ComponentType, String StartTime){
				File mainFolder = new File(UtilLib.getEnvVar("CompatibilityExcelReportPath"));
				File ExcelFile= new File(UtilLib.getEnvVar("CompatibilityExcelReportPath")+"Compatibility_Validations_Results.xls");
				if (!mainFolder.exists()&& !ExcelFile.exists()) {
					//System.out.println("Creating Main folder");
					 mainFolder.mkdir();
					 if(!ExcelFile.exists()){
						 //System.out.println("Create new folder");
						 CreateNewExcelForLogForCompatibility(TestCaseName,Message, TestCaseStatus,ComponentType,StartTime);
					 }
					 else{

					 }
				}
				else if (mainFolder.exists()&& !ExcelFile.exists()){
					CreateNewExcelForLogForCompatibility(TestCaseName,Message, TestCaseStatus, ComponentType,StartTime);
				}
				else{
					WriteLogToExcelForCompatibility(TestCaseName, TestCaseStatus,Message,ComponentType,StartTime);
				}

		  }



		  /*********************************************************************************************
			 * @Function_Name :  CreateExcelForLog
			 * @Description : Write Log to a New Excel file
			 ********************************************************************************************/
		  public static void CreateNewExcelForLogForCompatibility(String TestCaseName, String Message, String TestCaseStatus,String ComponentType, String StartTime){

			  try {
			  HSSFWorkbook workbook = new HSSFWorkbook();
			  HSSFSheet sheet = workbook.createSheet("Test_Execution_Results");


				 HSSFFont textFont = workbook.createFont();
				 textFont.setFontHeightInPoints((short) 10);
				 textFont.setColor(HSSFColor.WHITE.index);
				 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			  	 HSSFCellStyle style = workbook.createCellStyle();
				 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
				 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
				 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				 style.setFont(textFont);

			  HSSFRow row = sheet.createRow(0);
			  org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(0);
			  cell1.setCellValue("Sl no.");
			  cell1.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(1);
			  cell2.setCellValue("Track Name");
			  cell2.setCellStyle(style);


			  org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(2);
			  cell3.setCellValue("Test Case Name");
			  cell3.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(3);
			  cell4.setCellValue("Status & Environment");
			  cell4.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(4);
			  cell5.setCellValue("Executed On");
			  cell5.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(5);
			  cell6.setCellValue("Time Taken (in secs)");
			  cell6.setCellStyle(style);

			  org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(6);
			  cell7.setCellValue("Comments");
			  cell7.setCellStyle(style);

			  FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("CompatibilityExcelReportPath")+"Compatibility_Validations_Results"+".xls"));
				workbook.write(out);
				out.close();
				workbook.close();
				} catch (Exception e) {

					e.printStackTrace();
				}

		       // System.out.println("New Excel created...Will proceed to update it");

			  WriteLogToExcelForCompatibility(TestCaseName, TestCaseStatus,Message, ComponentType,StartTime);
			}


		  /*********************************************************************************************
			 * @Function_Name :  WriteLogToExcel
			 * @Description : Write Log to Excel
		   ********************************************************************************************/
		  public static void WriteLogToExcelForCompatibility(String TestCaseName, String TestCaseStatus,String Message,String ComponentType,String StartTime){
			  int UpdationCount=0;

			  try{


			  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_hh:mm").format(new java.util.Date());

			  FileInputStream logfile=new FileInputStream(new File(UtilLib.getEnvVar("CompatibilityExcelReportPath")+"Compatibility_Validations_Results"+".xls"));
			  HSSFWorkbook workbook = new HSSFWorkbook(logfile);
			  HSSFSheet logsheet = workbook.getSheet("Test_Execution_Results");



			  UpdationCount=UtilLib.UpdateExcelLogForCompatibility(workbook,logsheet, TestCaseName,  TestCaseStatus, Message, StartTime);

			  if (UpdationCount<=0){

				  String StopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

				  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

					Date d1 = null;
					Date d2 = null;
					d1 = format.parse(StartTime);
					d2 = format.parse(StopTime);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					long diffSeconds = diff / 1000 ;
					//long diffMinutes = diff / (60 * 1000) % 60;

			  int rownum = logsheet.getLastRowNum();
			  HSSFRow row = logsheet.createRow(rownum+1);

			  org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(0);
			  cell1.setCellValue(rownum+1);

			  org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(1);
			  cell2.setCellValue(ComponentType);

			  org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(2);
			  cell3.setCellValue(TestCaseName);

			  org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(3);
			  cell4.setCellValue(TestCaseStatus);

			  org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(4);
			  cell5.setCellValue(timeStamp);

			  org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(5);
			  cell6.setCellValue(diffSeconds);

			  org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(6);
			  cell7.setCellValue(Message);

			  }
			  else{
				 // System.out.println("Log for this testcase has been updated");
			  }

				for (int i=1;i<100;i++){
					logsheet.autoSizeColumn(i);
									}


			    FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("CompatibilityExcelReportPath")+"Compatibility_Validations_Results"+".xls"));
				workbook.write(out);
				out.close();


			  }
			  catch (Exception e) {

					e.printStackTrace();
			  }
		  }





		  /*********************************************************************************************
			 * @Function_Name :  UpdateExcelLog
			 * @Description : Update the log if the test case already exists in the log file
		   ********************************************************************************************/
		  @SuppressWarnings({ "rawtypes", "unused" })
		public static int UpdateExcelLogForCompatibility(HSSFWorkbook workbook,HSSFSheet logsheet,String TestCaseName, String TestCaseStatus,String Message, String StartTime){
			  int updatecount=0;

			  try{


				  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_hh:mm").format(new java.util.Date());
				  String StopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

				  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

					Date d1 = null;
					Date d2 = null;
					d1 = format.parse(StartTime);
					d2 = format.parse(StopTime);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					long diffSeconds = diff / 1000 ;


				  /* Update the log file if the test case already exists */
			  		Iterator rowIterator = logsheet.iterator();
			  			while (rowIterator.hasNext()){
			  					Row logrow = (Row) rowIterator.next();
			  						Iterator prodCellIterator = logrow.cellIterator();
				 					Cell prodcell1 = (Cell) prodCellIterator.next();
									Cell prodcell2 = (Cell) prodCellIterator.next();
									Cell prodcell3 = (Cell) prodCellIterator.next();
									Cell cell =null;
									if (prodcell3.getStringCellValue().trim().toUpperCase().equalsIgnoreCase(TestCaseName)){
										//System.out.println("The cell value is: "+prodcell3.getStringCellValue().trim().toUpperCase());
										/* Update status */
										cell=logrow.getCell(3);
										cell.setCellValue(TestCaseStatus);

										/* Update Execution time stamp */
										cell=logrow.getCell(4);
										cell.setCellValue(timeStamp);

										/* Update Time taken */
										cell=logrow.getCell(5);
										cell.setCellValue(diffSeconds);

										/* Update Comments */
										cell=logrow.getCell(6);
										cell.setCellValue(Message);


										updatecount=updatecount+1;

									}

			  			}

			  }
			  catch (Exception e) {

					e.printStackTrace();
			  }
			return updatecount;
		  }


		  /*********************************************************************************************
			 * @Function_Name :  Result Set to Excel
			 * @Description : Write Result Set (Teradata Query results) to Excel
		   ********************************************************************************************/
		  public static void ResultSetToExcel(XSSFWorkbook workbook,XSSFSheet prodsheet, ResultSet rs){

		try{
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int currentRow = 0;
			XSSFRow row = prodsheet.createRow(currentRow);
			int numCols = resultSetMetaData.getColumnCount();
			CellStyle style = workbook.createCellStyle();
			style.setFillBackgroundColor(HSSFColor.BLUE.index);

			for (int j = 1; j < numCols+1; j++) {
		        String title = resultSetMetaData.getColumnName(j);
		        org.apache.poi.ss.usermodel.Cell cell =  row.createCell(j-1);
		        cell.setCellValue(title.toString());
		        cell.setCellStyle(style);
					}
			XSSFCell cell;
			int i=1;
			while(rs.next())
		      {  row=prodsheet.createRow(i);
		         for (int j=1;j<numCols+1;j++){
		         cell=row.createCell(j-1);
		         int ColType=resultSetMetaData.getColumnType(j);
		         switch (ColType) {
		         case 0: //Null
		         case 1: //Char
		         case 12: //Varchar
		         case 111: //Other
			        cell.setCellValue(rs.getString(j));
			        break;
			     case 2: //Numeric
			     case 3: //Decimal
			     case 8: //Double
			        cell.setCellValue(rs.getDouble(j));
			        break;
			     case 4: //Integer
			     case 5: //SmallInt
			           cell.setCellValue(rs.getInt(j));
			           break;
			     case 6: //Float
			     case 7: //REAL
			           cell.setCellValue(rs.getFloat(j));
			           break;
			     case 91: //Date
			    	 	cell.setCellValue(rs.getDate(j));
			    	 	break;
			     case 92: //Time
			    	 	cell.setCellValue(rs.getTime(j));
			    	 	break;
			     case 93: //Time-stamp
			    	 	cell.setCellValue(rs.getTimestamp(j));
			    	 	break;
			     default:
			    	    cell.setCellValue(rs.getString(j));
			    	    break;
		              }
		     //    i++;
		      } i++;
		      }
			System.out.println("Excel written successfully..");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

}


		  /*********************************************************************************************
			 * @Function_Name :  Result Set to Excel
			 * @Description : Write Result Set (Teradata Query results) to Excel
		   ********************************************************************************************/
		  public static boolean ResultSetToExcel2(String WorkSheetName, ResultSet rs, String TestCaseName){

		try{
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(WorkSheetName);
			int currentRow = 0;
			HSSFRow row = sheet.createRow(currentRow);
			int numCols = resultSetMetaData.getColumnCount();
			CellStyle style = workbook.createCellStyle();
			style.setFillBackgroundColor(HSSFColor.BLUE.index);

			for (int j = 1; j < numCols+1; j++) {
		        String title = resultSetMetaData.getColumnName(j);
		        org.apache.poi.ss.usermodel.Cell cell =  row.createCell(j-1);
		        cell.setCellValue(title.toString());
		        cell.setCellStyle(style);
					}
			HSSFCell cell;
			int i=1;
			while(rs.next())
		      {  row=sheet.createRow(i);
		         for (int j=1;j<numCols+1;j++){
		         cell=row.createCell(j-1);
		         int ColType=resultSetMetaData.getColumnType(j);
		         switch (ColType) {
		         case 0: //Null
		         case 1: //Char
		         case 12: //Varchar
		         case 111: //Other
			        cell.setCellValue(rs.getString(j));
			        break;
			     case 2: //Numeric
			     case 3: //Decimal
			     case 8: //Double
			        cell.setCellValue(rs.getDouble(j));
			        break;
			     case 4: //Integer
			     case 5: //SmallInt
			           cell.setCellValue(rs.getInt(j));
			           break;
			     case 6: //Float
			     case 7: //REAL
			           cell.setCellValue(rs.getFloat(j));
			           break;
			     case 91: //Date
			    	 	cell.setCellValue(rs.getDate(j));
			    	 	break;
			     case 92: //Time
			    	 	cell.setCellValue(rs.getTime(j));
			    	 	break;
			     case 93: //Time-stamp
			    	 	cell.setCellValue(rs.getTimestamp(j));
			    	 	break;
			     default:
			    	    cell.setCellValue(rs.getString(j));
			    	    break;
		              }
		         i++;
		      }
		      }

			String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
	        FileOutputStream out =
	                new FileOutputStream(new File("C:\\PROD"+TestCaseName+fileName));
	        workbook.write(out);
	        out.close();
	        workbook.close();
	        System.out.println("Excel written successfully..");
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}
		return true;

}

		  public static WebElement opt_Dropdown(WebDriver driver, String Xpath, String DropdownOpt){

		 		Select dropdown = new Select(driver.findElement(By.xpath(Xpath)));
		 	    dropdown.selectByVisibleText(DropdownOpt);
		    	 return element; }

			    public static WebElement txtbx(WebDriver driver, String Xpath){
			    	 driver.findElement(By.xpath(Xpath)).clear();

			         element = driver.findElement(By.xpath(Xpath));

			         return element;

			         }
		/*
		  *//*********************************************************************************************
			 * @Function_Name : Teradata
			 * @Description : Connect to teradata and execute given query
		   ********************************************************************************************//*
		  public static void TDQueryExecute(String CredentialsPath,String Query, String WorkSheetName, String TestCaseName, String Env) throws IOException{
				try
			     {
			         FileInputStream fstream = new FileInputStream(CredentialsPath);
			         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			         String strLine;
			         int count = 0;
			         count++;
			         String Uname = null;
			         String Pword = null;

			         while((strLine = br.readLine())!= null)
			         {
			              Uname=strLine;
			              strLine = br.readLine();
			              count++;
			              Pword=strLine;
			         }
			         br.close();

			         if (Env.equalsIgnoreCase("PROD")){
			        	 DatabaseQueryExecuteProd.fetch_Prod_Data(Query,TestCaseName,WorkSheetName,Uname,Pword);
			        	    }
			         else {
			        	 DatabaseQueryExecuteStg.fetch_Stg_Data(Query,TestCaseName,WorkSheetName,Uname,Pword);
			         	  }
			     }

		     catch (Exception e)
		     {
		         System.err.println("Error: " + e.getMessage());
		     }
}*/

		  /********************************************************************************************
			 * @return
		 * @Function_Name :  Get the connection URL
			 * @Description : Get the connection URL for the given environment
			*******************************************************************************************/
				public static void GetConnUrl(String Envi){

					if (Envi.equalsIgnoreCase("PROD")){
				  		UtilLib.getEnvVar("ProdDatabaseConnUrl");
				  			}
				  		else {
				  			UtilLib.getEnvVar("StgDatabaseConnUrl");

				  			}
					}


				/********************************************************************************************
				 * @return Uname and Pword
				 * @Function_Name :  Get Credentials
				 * @Description : Read username and Password from file for database connectivity
				 ********************************************************************************************/

					@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
					public static ArrayList ReadCredentails(String Envi) throws IOException{
						String CredentialsFilePath;
						 ArrayList al = new ArrayList();
					if (Envi=="PROD"){
						CredentialsFilePath=UtilLib.getEnvVar("CredentialsFilePathProd");
					}
					else {
						CredentialsFilePath=UtilLib.getEnvVar("CredentialsFilePathStg");
					}

					try
				     {
				         FileInputStream fstream = new FileInputStream(CredentialsFilePath);
				         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				         String strLine;
				         int count = 0;
				         count++;

				         while((strLine = br.readLine())!= null)
				         {
				              al.add(strLine);
				              strLine = br.readLine();
				              count++;
				              al.add(strLine);
				         }
				         br.close();

				     }
					 catch (Exception e)
				     {
				         System.err.println("Error: " + e.getMessage());
				     }
					return al;
					}

		/********************************************************************************************
					 * @Function_Name :  Connect to Teradata and fetch details
					 * @Description : Connect to Teradata and execute the given query and write the results to excel
		********************************************************************************************/
		  public static void TeradataResultSetToExcel(String connurl,String uname,String pword,String Query,XSSFWorkbook workbook ,XSSFSheet prodsheet, String TestCaseName, String Envi,String PeriodIdType, String ViewName)
		  {
			  System.out.println("HI : "+PeriodIdType);
			  String ComponentTypeAE=PeriodIdType; //.substring(0,24);
			  System.out.println("ComponentTypeAE : "+ComponentTypeAE);
			  String ComponentTypeBW=ComponentTypeAE.replaceAll("BWPeriodId", "");
			  String ComponentType=ComponentTypeBW.replaceAll("INPeriodId", "");
			  System.out.println("ComponentType : "+ComponentType);
			  String PeriodId=UtilLib.getParam(PeriodIdType);
			  System.out.println("PeriodId : "+PeriodId);
			  String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			  System.out.println("dateStart : "+dateStart);
			  try
			    {
				System.out.println("Trying to connect to: "+connurl);
				Class.forName("com.teradata.jdbc.TeraDriver");
				Connection conn=DriverManager.getConnection(connurl, uname, pword);
				PreparedStatement stmt=conn.prepareStatement(Query);
				stmt.setQueryTimeout(600);
				System.out.println("Connected to Teradata...");
				ResultSet rs=stmt.executeQuery();
				System.out.println("Query Executed in Teradata...");
				/*ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();*/

				if (!rs.isBeforeFirst() ) {
					System.out.println("Result Set is empty in "+Envi);
					 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", " ");
					 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
					 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", "FAILED",ComponentType,"",PeriodId,Query,dateStart,ViewName);
					 Assert.fail("The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
					}

				/*System.out.println(" This table has " + colCount + " columns.\n");
				 while (rs.next()) {
					//Print one row
					for(int i = 1 ; i <= colCount; i++){

					      System.out.print(rs.getString(i) + " "); //Print one element of a row
					}
					  System.out.println();//Move to the next line to print the next row.
					    }

				 for (int i = 1; i < colCount + 1; i++ ) {

					System.out.println(rsmd.getColumnName(i));
				}*/

				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				int currentRow = 0;
				XSSFRow row = prodsheet.createRow(currentRow);
				int numCols = resultSetMetaData.getColumnCount();
				CellStyle style = workbook.createCellStyle();
				style.setFillBackgroundColor(HSSFColor.BLUE.index);

				for (int j = 1; j < numCols+1; j++) {
			        String title = resultSetMetaData.getColumnName(j);
			        org.apache.poi.ss.usermodel.Cell cell =  row.createCell(j-1);
			        cell.setCellValue(title.toString());
			        cell.setCellStyle(style);
			        			       			    }
				XSSFCell cell;
				int i=1;
				while(rs.next())
			      {
			         row=prodsheet.createRow(i);
			         for (int j=1;j<numCols+1;j++){
				         cell=row.createCell(j-1);
				         int ColType=resultSetMetaData.getColumnType(j);
				         switch (ColType) {
				         case 0: //Null
				         case 1: //Char
				         case 12: //Varchar
				         case 111: //Other
					        cell.setCellValue(rs.getString(j));
					        break;
					     case 2: //Numeric
					     case 3: //Decimal
					     case 8: //Double
					        cell.setCellValue(rs.getDouble(j));
					        break;
					     case 4: //Integer
					     case 5: //SmallInt
					           cell.setCellValue(rs.getInt(j));
					           break;
					     case 6: //Float
					     case 7: //REAL
					           cell.setCellValue(rs.getFloat(j));
					           break;
					     case 91: //Date
					    	 	cell.setCellValue(rs.getDate(j));
					    	 	break;
					     case 92: //Time
					    	 	cell.setCellValue(rs.getTime(j));
					    	 	break;
					     case 93: //Time-stamp
					    	 	cell.setCellValue(rs.getTimestamp(j));
					    	 	break;
					     default:
					    	    cell.setCellValue(rs.getString(j));
					    	    break;
				              }
				            }
			         i++;
			      }
				conn.close();
			    }

				   catch (SQLException e) {
				      // if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
				          /*Check Teradata exception.*/
				         int TeradataCode = e.getErrorCode();  /*Get specific error.*/
				         if (TeradataCode!=0){
				        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED",ComponentType,"",PeriodId,Query,dateStart,ViewName);
						     Assert.fail("Query failed to execute");
				        					        // }
				       }
				     }
				   catch (ClassNotFoundException e){
					   e.printStackTrace();
				   }
			}


		  /********************************************************************************************
			 * @Function_Name :  Copy the worksheet to variance sheet
			 * @Description : Copy the worksheet to variance sheet
		   ********************************************************************************************/

		  @SuppressWarnings("rawtypes")
		public static void CopyContentsOfExcel(XSSFWorkbook workbook, XSSFSheet variancesheet,XSSFSheet prodsheet) throws IOException {

				int rownum = variancesheet.getLastRowNum() + 2;
				try {
					Iterator rowIterator = prodsheet.iterator();
					 XSSFFont textFont = workbook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle Existingstyle = workbook.createCellStyle();
					Existingstyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					Existingstyle.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					Existingstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Existingstyle.setFont(textFont);
					variancesheet.createRow(rownum).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
					rownum++;
					if (rowIterator.hasNext()) {
						Row row1 = (Row) rowIterator.next();
						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;
						Iterator CellIterator = row1.cellIterator();
						while (CellIterator.hasNext()) {
							Cell prodcell = (Cell) CellIterator.next();
							org.apache.poi.ss.usermodel.Cell cell = row
									.createCell(cellnum++);
							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_STRING:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								cell.setCellStyle(Existingstyle);
								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}

					while (rowIterator.hasNext()) {
						Row row1 = (Row) rowIterator.next();
						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;
						Iterator CellIterator = row1.cellIterator();
						while (CellIterator.hasNext()) {
							Cell prodcell = (Cell) CellIterator.next();
							org.apache.poi.ss.usermodel.Cell cell = row
									.createCell(cellnum++);
							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_STRING:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}
					rownum = rownum + 2;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		  /********************************************************************************************
			 * @Function_Name :  Copy the worksheet to variance sheet
			 * @Description : Copy the worksheet to variance sheet
		   ********************************************************************************************/

		  @SuppressWarnings("rawtypes")
		public static void PlainOfCopyContentsOfExcel(XSSFWorkbook workbook, XSSFSheet prodsheet,XSSFSheet existstgsheet) throws IOException {

				int rownum = prodsheet.getLastRowNum();
				try {
					Iterator rowIterator = existstgsheet.iterator();

					while (rowIterator.hasNext()) {
						Row row1 = (Row) rowIterator.next();
						Row row = prodsheet.createRow(rownum++);
						int cellnum = 0;
						Iterator CellIterator = row1.cellIterator();
						while (CellIterator.hasNext()) {
							Cell prodcell = (Cell) CellIterator.next();
							org.apache.poi.ss.usermodel.Cell cell = row
									.createCell(cellnum++);
							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_STRING:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}
					rownum = rownum + 2;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}




		  /********************************************************************************************
			 * @Function_Name :  Compare two excels and get variance
			 * @Description : Compare two excels and get variance
		   ********************************************************************************************/
		   @SuppressWarnings("rawtypes")
		public static int CompareExcelSheetsForVariance(XSSFWorkbook workbook, XSSFSheet variancesheet,XSSFSheet prodsheet,XSSFSheet stgsheet, String Query) {
			  int rownum = variancesheet.getLastRowNum() + 2;
			  int mismatchCount=0;
			  int prodsheetrownum = prodsheet.getLastRowNum();
			  int stgsheetrownum = stgsheet.getLastRowNum();

			  if(prodsheetrownum==stgsheetrownum){

				try {

					/* Formatting for Headers*/
					XSSFFont textFont = workbook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle style = workbook.createCellStyle();
					 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 style.setFont(textFont);

					 /* Formatting for Values*/
					 XSSFFont ValuesFont = workbook.createFont();
					 ValuesFont.setFontHeightInPoints((short) 10);
					 ValuesFont.setColor(HSSFColor.BLACK.index);
					 ValuesFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle Valuesstyle = workbook.createCellStyle();
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillBackgroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Valuesstyle.setFont(ValuesFont);

					 XSSFCellStyle Valuesmismatchstyle = workbook.createCellStyle();
					 Valuesmismatchstyle.setFillForegroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillBackgroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 Valuesmismatchstyle.setFont(textFont);

					Iterator prodrowIterator = prodsheet.iterator();
					Iterator stgrowIterator = stgsheet.iterator();
					variancesheet.createRow(rownum).createCell(0).setCellValue(variancesheet.getSheetName().toUpperCase());
					rownum++;
					if (prodrowIterator.hasNext() && stgrowIterator.hasNext()) {
						Row rowprod = (Row) prodrowIterator.next();
						Row rowstg = (Row) stgrowIterator.next();

						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;

						Iterator prodCellIterator = rowprod.cellIterator();
						Iterator stgCellIterator = rowstg.cellIterator();

						while (prodCellIterator.hasNext()&& stgCellIterator.hasNext()) {
							Cell prodcell = (Cell) prodCellIterator.next();
							Cell stgcell = (Cell) stgCellIterator.next();

							org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);

							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								if ((prodcell.getBooleanCellValue())==(stgcell.getBooleanCellValue())){
								//	System.out.println("==prodcell.getBooleanCellValue() :"+prodcell.getBooleanCellValue() +"stgcell.getBooleanCellValue( :"+stgcell.getBooleanCellValue());
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
										}
								else if((prodcell.getBooleanCellValue())!=(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
								//	System.out.println("!=prodcell.getBooleanCellValue() :"+prodcell.getBooleanCellValue() +"stgcell.getBooleanCellValue( :"+stgcell.getBooleanCellValue());
									mismatchCount=mismatchCount+1;
								}
								break;
							case Cell.CELL_TYPE_NUMERIC:
								double difference=prodcell.getNumericCellValue()-stgcell.getNumericCellValue();
								if ((prodcell.getNumericCellValue())==(stgcell.getNumericCellValue())){
									//System.out.println("==prodcell.getNumericCellValue() :"+prodcell.getNumericCellValue() +"stgcell.getNumericCellValue( :"+stgcell.getNumericCellValue());
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
										}
								//else if((prodcell.getNumericCellValue())!=(stgcell.getNumericCellValue())){
								else if(difference<Double.parseDouble(UtilLib.getParam("NegativeRange")) || difference>Double.parseDouble(UtilLib.getParam("PositiveRange"))){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
									cell.setCellStyle(Valuesmismatchstyle);
									//System.out.println("difference : "+difference);
									mismatchCount=mismatchCount+1;
								}
								else if(difference>Double.parseDouble(UtilLib.getParam("NegativeRange")) || difference<Double.parseDouble(UtilLib.getParam("PositiveRange"))){

									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
									cell.setCellStyle(Valuesstyle);
																	}
								else  {

									//((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getNumericCellValue()-(stgcell.getNumericCellValue()));
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
								}

								break;

							case Cell.CELL_TYPE_STRING:
								if ((prodcell.getStringCellValue())==(stgcell.getStringCellValue())){
									//System.out.println("==prodcell.getStringCellValue() :"+prodcell.getStringCellValue() +"stgcell.getStringCellValue( :"+stgcell.getStringCellValue());
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getStringCellValue());
										}
								else if((prodcell.getStringCellValue())!=(stgcell.getStringCellValue())){
									//System.out.println("!=prodcell.getStringCellValue() :"+prodcell.getStringCellValue() +"stgcell.getStringCellValue( :"+stgcell.getStringCellValue());
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getStringCellValue())+(stgcell.getStringCellValue()));
									//mismatchCount=mismatchCount+1;
								}
								cell.setCellStyle(style);
								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}

					while (prodrowIterator.hasNext() && stgrowIterator.hasNext()) {
						Row rowprod = (Row) prodrowIterator.next();
						Row rowstg = (Row) stgrowIterator.next();

						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;

						Iterator prodCellIterator = rowprod.cellIterator();
						Iterator stgCellIterator = rowstg.cellIterator();

						while (prodCellIterator.hasNext()&& stgCellIterator.hasNext()) {
							Cell prodcell = (Cell) prodCellIterator.next();
							Cell stgcell = (Cell) stgCellIterator.next();

							org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);

							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								if ((prodcell.getBooleanCellValue())==(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
										}
								else if((prodcell.getBooleanCellValue())!=(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
									mismatchCount=mismatchCount+1;
								}
								break;
							case Cell.CELL_TYPE_NUMERIC:
								double difference=prodcell.getNumericCellValue()-stgcell.getNumericCellValue();
								if ((prodcell.getNumericCellValue())==(stgcell.getNumericCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
										}
								//else if((prodcell.getNumericCellValue())!=(stgcell.getNumericCellValue())){
								else if(difference<Double.parseDouble(UtilLib.getParam("NegativeRange")) || difference>Double.parseDouble(UtilLib.getParam("PositiveRange"))){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
									cell.setCellStyle(Valuesmismatchstyle);
									mismatchCount=mismatchCount+1;
								}

								else  {

									//((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getNumericCellValue()-(stgcell.getNumericCellValue()));
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
								}

								break;

							case Cell.CELL_TYPE_STRING:
								if ((prodcell.getStringCellValue())==(stgcell.getStringCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getStringCellValue());
									cell.setCellStyle(Valuesstyle);
								}
								else if((prodcell.getStringCellValue())!=(stgcell.getStringCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getStringCellValue())+(stgcell.getStringCellValue()));
									cell.setCellStyle(Valuesmismatchstyle);
									mismatchCount=mismatchCount+1;
								}

								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}
					rownum = rownum + 2;


					variancesheet.createRow(rownum).createCell(0).setCellValue("Query used:");
					variancesheet.createRow(rownum+1).createCell(0).setCellValue(Query);

				} catch (Exception e) {
					e.printStackTrace();
				}
			  }
			  else {
				  mismatchCount=mismatchCount+1;
			  }
				return mismatchCount;
		  }



		   /********************************************************************************************
			 * @Function_Name :  Compare two excels and get variance
			 * @author vinbhask.adm
			 * @Description : Compare two excels and get variance
		   ********************************************************************************************/
		   @SuppressWarnings("rawtypes")
		public static int CompareExcelSheetsForVarianceExact(XSSFWorkbook workbook, XSSFSheet variancesheet,XSSFSheet prodsheet,XSSFSheet stgsheet, String Query) {
			  int rownum = variancesheet.getLastRowNum() + 2;
			  int mismatchCount=0;
			  int prodsheetrownum = prodsheet.getLastRowNum();
			  int stgsheetrownum = stgsheet.getLastRowNum();

			  if(prodsheetrownum==stgsheetrownum){

				try {

					/* Formatting for Headers*/
					XSSFFont textFont = workbook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle style = workbook.createCellStyle();
					 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 style.setFont(textFont);

					 /* Formatting for Values*/
					 XSSFFont ValuesFont = workbook.createFont();
					 ValuesFont.setFontHeightInPoints((short) 10);
					 ValuesFont.setColor(HSSFColor.BLACK.index);
					 ValuesFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle Valuesstyle = workbook.createCellStyle();
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillBackgroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Valuesstyle.setFont(ValuesFont);

					 XSSFCellStyle Valuesmismatchstyle = workbook.createCellStyle();
					 Valuesmismatchstyle.setFillForegroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillBackgroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 Valuesmismatchstyle.setFont(textFont);

					Iterator prodrowIterator = prodsheet.iterator();
					Iterator stgrowIterator = stgsheet.iterator();
					variancesheet.createRow(rownum).createCell(0).setCellValue(variancesheet.getSheetName().toUpperCase());
					rownum++;
					if (prodrowIterator.hasNext() && stgrowIterator.hasNext()) {
						Row rowprod = (Row) prodrowIterator.next();
						Row rowstg = (Row) stgrowIterator.next();

						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;

						Iterator prodCellIterator = rowprod.cellIterator();
						Iterator stgCellIterator = rowstg.cellIterator();

						while (prodCellIterator.hasNext()&& stgCellIterator.hasNext()) {
							Cell prodcell = (Cell) prodCellIterator.next();
							Cell stgcell = (Cell) stgCellIterator.next();

							org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);

							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								if ((prodcell.getBooleanCellValue())==(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
										}
								else if((prodcell.getBooleanCellValue())!=(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
									mismatchCount=mismatchCount+1;
								}
								break;
							case Cell.CELL_TYPE_NUMERIC:
								double difference=prodcell.getNumericCellValue()-stgcell.getNumericCellValue();
								if ((prodcell.getNumericCellValue())==(stgcell.getNumericCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
										}
								//else if((prodcell.getNumericCellValue())!=(stgcell.getNumericCellValue())){
								else if(difference<0 || difference>0){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
									cell.setCellStyle(Valuesmismatchstyle);
									mismatchCount=mismatchCount+1;
								}
								else if(difference>0 || difference<0){

									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
									cell.setCellStyle(Valuesstyle);
																	}
								else  {

									//((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getNumericCellValue()-(stgcell.getNumericCellValue()));
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
								}

								break;

							case Cell.CELL_TYPE_STRING:
								if ((prodcell.getStringCellValue())==(stgcell.getStringCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getStringCellValue());
										}
								else if((prodcell.getStringCellValue())!=(stgcell.getStringCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getStringCellValue())+(stgcell.getStringCellValue()));
									mismatchCount=mismatchCount+1;
								}
								cell.setCellStyle(style);
								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}

					while (prodrowIterator.hasNext() && stgrowIterator.hasNext()) {
						Row rowprod = (Row) prodrowIterator.next();
						Row rowstg = (Row) stgrowIterator.next();

						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;

						Iterator prodCellIterator = rowprod.cellIterator();
						Iterator stgCellIterator = rowstg.cellIterator();

						while (prodCellIterator.hasNext()&& stgCellIterator.hasNext()) {
							Cell prodcell = (Cell) prodCellIterator.next();
							Cell stgcell = (Cell) stgCellIterator.next();

							org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);

							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								if ((prodcell.getBooleanCellValue())==(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
										}
								else if((prodcell.getBooleanCellValue())!=(stgcell.getBooleanCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
									mismatchCount=mismatchCount+1;
								}
								break;
							case Cell.CELL_TYPE_NUMERIC:
								double difference=prodcell.getNumericCellValue()-stgcell.getNumericCellValue();
								if ((prodcell.getNumericCellValue())==(stgcell.getNumericCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
										}
								//else if((prodcell.getNumericCellValue())!=(stgcell.getNumericCellValue())){
								else if(difference<0 || difference>0){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
									cell.setCellStyle(Valuesmismatchstyle);
									mismatchCount=mismatchCount+1;
								}

								else  {

									//((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getNumericCellValue()-(stgcell.getNumericCellValue()));
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
									cell.setCellStyle(Valuesstyle);
								}

								break;

							case Cell.CELL_TYPE_STRING:
								if ((prodcell.getStringCellValue())==(stgcell.getStringCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getStringCellValue());
									cell.setCellStyle(Valuesstyle);
								}
								else if((prodcell.getStringCellValue())!=(stgcell.getStringCellValue())){
									((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getStringCellValue())+(stgcell.getStringCellValue()));
									cell.setCellStyle(Valuesmismatchstyle);
									mismatchCount=mismatchCount+1;
								}

								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}
					rownum = rownum + 2;


					variancesheet.createRow(rownum).createCell(0).setCellValue("Query used:");
					variancesheet.createRow(rownum+1).createCell(0).setCellValue(Query);

				} catch (Exception e) {
					e.printStackTrace();
				}
			  }
			  else {
				  mismatchCount=mismatchCount+1;
			  }
				return mismatchCount;
		  }


		 /********************************************************************************************
			 * @return
		 * @throws IOException
		 * @Function_Name : Read variance
			 * @Description : Read variance
		  ********************************************************************************************/
		   @SuppressWarnings({ "rawtypes", "resource" })
		  public static   void ReadVariance(String ExcelPath,String varianceSheetName, String TestCaseName,String ComponentType,String startTime, String Resultfilename) {
			   FileInputStream variancefile;
			   int mismatchCount=0;
			  // String FilePath=UtilLib.getEnvVar(ComponentType)+Resultfilename;
			   //System.out.println("FilePath is:"+FilePath);
			   try {

					variancefile = new FileInputStream(new File(ExcelPath));
					HSSFWorkbook workbook = new HSSFWorkbook(variancefile);
					HSSFSheet variancesheet = workbook.getSheet(varianceSheetName);
					Iterator rowIterator = variancesheet.iterator();
					while (rowIterator.hasNext()) {
						Row row1 = (Row) rowIterator.next();
						Iterator CellIterator = row1.cellIterator();
						while (CellIterator.hasNext()) {
							Cell variancecell = (Cell) CellIterator.next();
							switch (variancecell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								if (variancecell.getNumericCellValue()<-1 || variancecell.getNumericCellValue()>1){
									//System.out.println(variancecell.getNumericCellValue());
									mismatchCount=mismatchCount+1;
									}
								break;
							}
							}
							}

		   } catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		 catch (IOException e) {

				e.printStackTrace();
			}
			if (mismatchCount==0){
	       		UtilLib.Report_PASS(TestCaseName, "No Variance Observed", " ");
	       		//UtilLib.LogExcelReport(TestCaseName, "No Variance Found", "PASSED",ComponentType,FilePath, "", "",startTime,ViewName);
	       		}
	       	else {
	       		UtilLib.Report_FAIL(TestCaseName, "Variance Exists", " ");
	       		//UtilLib.LogExcelReport(TestCaseName, "Variance Exists", "FAILED",ComponentType,FilePath, "", "",startTime);
	       		Assert.fail("Variance Exists");
	       		}
}


		  /********************************************************************************************
			 * @throws IOException
			 * @Function_Name : Result Set Count Check
			 * @Description : Execute the given query and check the result set, if numnber of rows are
			 * greater than zero then fail the testcase
		  ********************************************************************************************/
 public static void ResultSetCountCheck(String connurlprod,String unameprod,String pwordprod,String prodQuery,String connurlstg,String unamestg,String pwordstg,String stageQuery, String TestCaseName, String ComponentType, String PeriodID,String ViewName) {
	 String str=connurlstg;
	 String DbEnv= str.substring(str.length() - 3);
	 int VarianceExists;
	 String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
	// System.out.println("fileName : "+fileName);
	 String filePath=(UtilLib.getEnvVar(ComponentType)+TestCaseName+"_"+fileName);
	// System.out.println("filePath : "+filePath);
	 String startTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
	// System.out.println("startTime : "+startTime);
	 System.out.println("stageQuery"+stageQuery);

	 try
	   {
		Class.forName("com.teradata.jdbc.TeraDriver");
		Connection conn=DriverManager.getConnection(connurlstg, unamestg, pwordstg);
		System.out.println("Trying to Connect");
		PreparedStatement stmt=conn.prepareStatement(stageQuery);
		System.out.println("Stg Connected");
		stmt.setQueryTimeout(600);
		ResultSet rsstage=stmt.executeQuery();
		System.out.println("Stg query Executed successfully");

					ResultSetMetaData rsmd = rsstage.getMetaData();
					int columnsNumber = rsmd.getColumnCount();
					/*System.out.println("columnsNumber : "+columnsNumber);
					while (rsstage.next()) {
					    for (int i = 1; i <= columnsNumber; i++) {
					        if (i > 1) System.out.print(",  ");
					        String columnValue = rsstage.getString(i);
					        System.out.print(columnValue + " " + rsmd.getColumnName(i));
					    }
					    System.out.println("");
					}*/

					/* Check if stage returns zero rows*/
		if (!rsstage.isBeforeFirst() ) {
			System.out.println("Stage has 0 records");
				UtilLib.Report_PASS(TestCaseName, "The given query for this testcase returned zero rows", " ");
				UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+stageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows");
				UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows", "PASSED"+" in "+DbEnv,ComponentType,"", PeriodID, stageQuery,startTime,ViewName);
					}
		else {

						/*Check if production returns zero rows*/
				Connection connprod=DriverManager.getConnection(connurlprod, unameprod, pwordprod);
				System.out.println("Prd Connected");
				System.out.println("prodQuery : "+prodQuery);
				PreparedStatement stmtprod=connprod.prepareStatement(prodQuery);
				System.out.println("Hi");
				ResultSet rsprod=stmtprod.executeQuery();
				System.out.println("Prod Query executed successfully");
				if (!rsprod.isBeforeFirst()){
					XSSFWorkbook stgworkbook = new XSSFWorkbook();
					XSSFSheet stgsheet = stgworkbook.createSheet("Stage");
					UtilLib.ResultSetToExcel(stgworkbook, stgsheet, rsstage);
					System.out.println("Copied to excel");
					System.out.println("UtilLib.getEnvVar(ComponentType)+TestCaseName++fileName : "+UtilLib.getEnvVar(ComponentType)+TestCaseName+fileName);
					FileOutputStream stgout=new FileOutputStream(new File(UtilLib.getEnvVar(ComponentType)+TestCaseName+"_"+fileName));
					stgworkbook.write(stgout);
					stgout.close();

					UtilLib.Report_FAIL(TestCaseName, "Hierarchy drop exists in Stage whereas not in production", " ");
					UtilLib.LogReport(TestCaseName, "Hierarchy drop exists in Stage whereas not in production, query: "+newline+newline+"\""+stageQuery);
					UtilLib.LogExcelReport(TestCaseName, "Hierarchy drop exists in Stage whereas not in production", "FAILED"+" in "+DbEnv,ComponentType,filePath,PeriodID,stageQuery,startTime,ViewName);
					Assert.fail("Hierarchy drop exists in Stage whereas not in production");
								}
							/* Compare production result with stage result */
				else {
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet prodsheet = workbook.createSheet("Production");
					UtilLib.ResultSetToExcel(workbook, prodsheet,  rsprod);
					XSSFSheet stagesheet=workbook.createSheet("Stage");
					UtilLib.ResultSetToExcel(workbook, stagesheet, rsstage);
					XSSFSheet variancesheet=workbook.createSheet("Variance");
					UtilLib.CopyContentsOfExcel(workbook, variancesheet,prodsheet);
					UtilLib.CopyContentsOfExcel(workbook, variancesheet,stagesheet);
					VarianceExists=UtilLib.CompareExcelSheetsForVariance(workbook, variancesheet,prodsheet, stagesheet, stageQuery);
					System.out.println("VarianceExists : "+VarianceExists);
					for (int i=1;i<100;i++){
						variancesheet.autoSizeColumn(i);
						prodsheet.autoSizeColumn(i);
						stagesheet.autoSizeColumn(i);
					}

						FileOutputStream out=new FileOutputStream(new File(UtilLib.getEnvVar(ComponentType)+TestCaseName+"_"+fileName));
						workbook.write(out);
							out.close();
							if (VarianceExists==0){
								 UtilLib.Report_PASS(TestCaseName, "The Hierarchy drop in stage is same as in production environment ", " ");
								 UtilLib.LogReport(TestCaseName, "The Hierarchy drop in stage is same as in production environment, query: "+newline+newline+"\""+stageQuery);
								 System.out.println("filePath : "+filePath);
								 UtilLib.LogExcelReport(TestCaseName, "The Hierarchy drop in stage is same as in production environment", "PASSED"+" in "+DbEnv,ComponentType,filePath,PeriodID,stageQuery,startTime,ViewName);
								}
							else {

							UtilLib.Report_FAIL(TestCaseName, "The Hierarchy drop in stage is different as compared to production environment", " ");
							UtilLib.LogReport(TestCaseName, "The Hierarchy drop in stage is different as compared to production environment, query: "+newline+newline+"\""+stageQuery+"\""+newline);
							UtilLib.LogExcelReport(TestCaseName, "The Hierarchy drop in stage is different as compared to production environment", "FAILED"+" in "+DbEnv,ComponentType,filePath,PeriodID,prodQuery,startTime,ViewName);
							Assert.fail("Hierarchy drop exists");
						}
						}
					conn.close();
				    }}
				   catch (IOException e)
				    {
				        e.printStackTrace();
				    }

				   catch (SQLException e) {
				      // if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
				          /*Check Teradata exception.*/
				         int TeradataCode = e.getErrorCode();  /*Get specific error.*/
				         if (TeradataCode!=0){
				        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED"+" in "+DbEnv,ComponentType,"",PeriodID,stageQuery,startTime,ViewName);
						     //Assert.fail("Query failed to execute");
						     e.printStackTrace();
				        					         }
//				       }
				     }
				   catch (ClassNotFoundException e){
					   e.printStackTrace();
				   }
			}


 /********************************************************************************************
	 * @Function_Name :  Copy the execution report to workspace
	 * @Description : Copy the execution report to workspace

	 ********************************************************************************************/


 public static void CopyExcelReportToWorkspace(){

	    try {
	    	Path source = Paths.get(UtilLib.getEnvVar("EnvironmentValidationsReportPath")+"Environment_Validations_Results"+".xls");
		    Path target = Paths.get(UtilLib.getEnvVar("WorkSpace")+"Environment_Validations_Results"+".xls");
		    Files.copy(source, target, REPLACE_EXISTING);
		   /* Path reportsource = Paths.get(UtilLib.getEnvVar("EmailableReportPath")+"emailable-report.html");
		    Path reporttarget = Paths.get(UtilLib.getEnvVar("EmailableReportPathInWorkSpace")+"emailable-report.html");
		    Files.copy(reportsource, reporttarget, REPLACE_EXISTING);*/
		    UtilLib.WaitTime(5000);
	        } catch (Exception ex) {

	            ex.printStackTrace();
	        }
	    }



 /********************************************************************************************
  * @throws IOException
* @Function_Name : Read variance
  * @Description : Read variance for cube
********************************************************************************************/
@SuppressWarnings("rawtypes")
public static void CubeReadVariance(String ExcelPath,String varianceSheetName, String TestCaseName,String ComponentType,String startTime, String Resultfilename) {
	   FileInputStream variancefile;
	   int mismatchCount=0;
	   String FilePath=Resultfilename;
	   //System.out.println("FilePath is:"+ExcelPath);
	   try {

			variancefile = new FileInputStream(new File(ExcelPath));
			HSSFWorkbook workbook = new HSSFWorkbook(variancefile);
			HSSFSheet variancesheet = workbook.getSheet(varianceSheetName);
			Iterator rowIterator = variancesheet.iterator();
			while (rowIterator.hasNext()) {
				Row row1 = (Row) rowIterator.next();
				Iterator CellIterator = row1.cellIterator();
				while (CellIterator.hasNext()) {
					Cell variancecell = (Cell) CellIterator.next();
					switch (variancecell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if (variancecell.getNumericCellValue()<-1 || variancecell.getNumericCellValue()>1){
							//System.out.println(variancecell.getNumericCellValue());
							mismatchCount=mismatchCount+1;
							}
						break;
					}
					}
					}
			workbook.close();

 } catch (FileNotFoundException e) {

		e.printStackTrace();
	}
catch (IOException e) {

		e.printStackTrace();
	}
	if (mismatchCount==0){
 		UtilLib.Report_PASS(TestCaseName, "No Variance Observed", " ");
 		UtilLib.LogExcelReportForCubeValidations(TestCaseName, "No Variance Found", "PASSED",ComponentType,startTime,FilePath);
 		}
 	else {
 		UtilLib.Report_FAIL(TestCaseName, "Variance Exists", " ");
 		UtilLib.LogExcelReportForCubeValidations(TestCaseName, "Variance Exists", "FAILED",ComponentType,startTime,FilePath);
 		Assert.fail("Variance Exists");
 		}
}




/*********************************************************************************************
	 * @Function_Name :  WriteLogInExcel
	 * @Description : Write Log to a Excel file for compatibility
	 ********************************************************************************************/
public static void LogExcelReportForCubeValidations(String TestCaseName, String Message, String TestCaseStatus, String ComponentType, String StartTime,String FilePath){
		File mainFolder = new File(UtilLib.getEnvVar("CubeValidationExcelReportPath"));
		File ExcelFile= new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results.xls");
		if (!mainFolder.exists()&& !ExcelFile.exists())
		{
			//System.out.println("Creating Main folder");
			 mainFolder.mkdir();
			 if(!ExcelFile.exists())
			 {
				 //System.out.println("Create new folder");
				 CreateNewExcelForLogForCubeValidations(TestCaseName,Message, TestCaseStatus,ComponentType,StartTime,FilePath);
			 }
		}
		else if (mainFolder.exists()&& !ExcelFile.exists())
		{
			CreateNewExcelForLogForCubeValidations(TestCaseName,Message, TestCaseStatus, ComponentType,StartTime,FilePath);
		}
		else
		{
			WriteLogToExcelForCubeValidations(TestCaseName, TestCaseStatus,Message,ComponentType,StartTime,FilePath);
		}

}



/*********************************************************************************************
	 * @Function_Name :  CreateExcelForLog
	 * @Description : Write Log to a New Excel file
	 ********************************************************************************************/
public static void CreateNewExcelForLogForCubeValidations(String TestCaseName, String Message, String TestCaseStatus,String ComponentType, String StartTime,String FilePath){

	  try {
	  HSSFWorkbook workbook = new HSSFWorkbook();
	  HSSFSheet sheet = workbook.createSheet("Test_Execution_Results");


		 HSSFFont textFont = workbook.createFont();
		 textFont.setFontHeightInPoints((short) 10);
		 textFont.setColor(HSSFColor.WHITE.index);
		 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

	  	 HSSFCellStyle style = workbook.createCellStyle();
		 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
		 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
		 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		 style.setFont(textFont);

	  HSSFRow row = sheet.createRow(0);
	  org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(0);
	  cell1.setCellValue("Sl no.");
	  cell1.setCellStyle(style);

	  org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(1);
	  cell2.setCellValue("Track Name");
	  cell2.setCellStyle(style);


	  org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(2);
	  cell3.setCellValue("Test Case Name");
	  cell3.setCellStyle(style);

	  org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(3);
	  cell4.setCellValue("Status & Environment");
	  cell4.setCellStyle(style);

	  org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(4);
	  cell5.setCellValue("Executed On");
	  cell5.setCellStyle(style);

	  org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(5);
	  cell6.setCellValue("Time Taken (in secs)");
	  cell6.setCellStyle(style);

	  org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(6);
	  cell7.setCellValue("Comments");
	  cell7.setCellStyle(style);

	  //FilePath for Click to Open File
	  /*org.apache.poi.ss.usermodel.Cell cell8 =  row.createCell(7);
	  cell8.setCellValue("File Path");
	  cell8.setCellStyle(style);*/

	  FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results"+".xls"));
	  //FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results"+AssignEnvironmentToReport.getEnvironment()+".xls"));
		workbook.write(out);
		out.close();
		workbook.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

     // System.out.println("New Excel created...Will proceed to update it");

	  WriteLogToExcelForCubeValidations(TestCaseName, TestCaseStatus,Message, ComponentType,StartTime,FilePath);
	}


/*********************************************************************************************
	 * @Function_Name :  WriteLogToExcel
	 * @Description : Write Log to Excel
 ********************************************************************************************/
public static void WriteLogToExcelForCubeValidations(String TestCaseName, String TestCaseStatus,String Message,String ComponentType,String StartTime,String FilePath){
	  int UpdationCount=0;
	  //String FilePathDisplayValue;
	  try{
		 //FilePath for Click to Open File
			  /*if(FilePath==""){
				  FilePathDisplayValue="N/A";
			  }

			  else if( FilePath != null && !FilePath.isEmpty()&& FilePath!=""){
				   FilePathDisplayValue="Click to Open the file";
			 }
			 else{
				 FilePathDisplayValue="N/A";
			 }

		  HSSFHyperlink file_link=new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
		  file_link.setAddress(FilePath);*/


	  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_hh:mm").format(new java.util.Date());

	  FileInputStream logfile=new FileInputStream(new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results"+".xls"));
	  //FileInputStream logfile=new FileInputStream(new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results"+AssignEnvironmentToReport.getEnvironment()+".xls"));
	  HSSFWorkbook workbook = new HSSFWorkbook(logfile);
	  HSSFSheet logsheet = workbook.getSheet("Test_Execution_Results");



	  UpdationCount=UtilLib.UpdateExcelLogForCubeValidations(workbook,logsheet, TestCaseName,  TestCaseStatus, Message, StartTime, FilePath);

	  if (UpdationCount<=0){

		  String StopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			Date d1 = null;
			Date d2 = null;
			d1 = format.parse(StartTime);
			d2 = format.parse(StopTime);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 ;
			//long diffMinutes = diff / (60 * 1000) % 60;

	  int rownum = logsheet.getLastRowNum();
	  HSSFRow row = logsheet.createRow(rownum+1);

	  org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(0);
	  cell1.setCellValue(rownum+1);

	  org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(1);
	  cell2.setCellValue(ComponentType);

	  org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(2);
	  cell3.setCellValue(TestCaseName);

	  org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(3);
	  cell4.setCellValue(TestCaseStatus);

	  org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(4);
	  cell5.setCellValue(timeStamp);

	  org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(5);
	  cell6.setCellValue(diffSeconds);

	  org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(6);
	  cell7.setCellValue(Message);

	  /*org.apache.poi.ss.usermodel.Cell cell8 =  row.createCell(7);
	  cell8.setCellValue(FilePathDisplayValue);
	  cell8.setHyperlink(file_link);*/

	  }
	  else{
		 // System.out.println("Log for this testcase has been updated");
	  }

		for (int i=1;i<100;i++){
			logsheet.autoSizeColumn(i);
							}

		FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results"+".xls"));
	    //FileOutputStream out = new FileOutputStream(new File(UtilLib.getEnvVar("CubeValidationExcelReportPath")+"Cube_Validations_Results"+AssignEnvironmentToReport.getEnvironment()+".xls"));
		workbook.write(out);
		out.close();


	  }
	  catch (Exception e) {

			e.printStackTrace();
	  }
}





/*********************************************************************************************
	 * @Function_Name :  UpdateExcelLog
	 * @Description : Update the log if the test case already exists in the log file
 ********************************************************************************************/
@SuppressWarnings({ "rawtypes", "unused" })
public static int UpdateExcelLogForCubeValidations(HSSFWorkbook workbook,HSSFSheet logsheet,String TestCaseName, String TestCaseStatus,String Message, String StartTime,String FilePath)
{
	  int updatecount=0;
	  String FilePathDisplayValue;
	  try{
		  /*if(FilePath==""){
			  FilePathDisplayValue="N/A";
		  }

		  else if( FilePath != null && !FilePath.isEmpty()&& FilePath!=""){
			   FilePathDisplayValue="Click to Open the file";
		 }
		 else{
			 FilePathDisplayValue="N/A";
		 }

		  HSSFHyperlink file_link=new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
		  file_link.setAddress(FilePath);*/

		  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_hh:mm").format(new java.util.Date());
		  String StopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			Date d1 = null;
			Date d2 = null;
			d1 = format.parse(StartTime);
			d2 = format.parse(StopTime);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 ;


		  /* Update the log file if the test case already exists */
	  		Iterator rowIterator = logsheet.iterator();
	  			while (rowIterator.hasNext()){
	  					Row logrow = (Row) rowIterator.next();
	  						Iterator prodCellIterator = logrow.cellIterator();
		 					Cell prodcell1 = (Cell) prodCellIterator.next();
							Cell prodcell2 = (Cell) prodCellIterator.next();
							Cell prodcell3 = (Cell) prodCellIterator.next();
							Cell cell =null;
							if (prodcell3.getStringCellValue().trim().toUpperCase().equalsIgnoreCase(TestCaseName)){
								//System.out.println("The cell value is: "+prodcell3.getStringCellValue().trim().toUpperCase());
								/* Update status */
								cell=logrow.getCell(3);
								cell.setCellValue(TestCaseStatus);

								/* Update Execution time stamp */
								cell=logrow.getCell(4);
								cell.setCellValue(timeStamp);

								/* Update Time taken */
								cell=logrow.getCell(5);
								cell.setCellValue(diffSeconds);

								/* Update Comments */
								cell=logrow.getCell(6);
								cell.setCellValue(Message);

								/* Update FilePath
								cell=logrow.getCell(7);
								cell.setCellValue(FilePathDisplayValue);
								cell.setHyperlink(file_link);*/


								updatecount=updatecount+1;

							}

	  			}

	  }
	  catch (Exception e) {

			e.printStackTrace();
	  }
	return updatecount;
}

/********************************************************************************************
* @Function_Name :  SendEmailJava
* @Description : Send Email via Java using SMTP

********************************************************************************************/

public static void SendEmailJava(String FromUser, String ToUser, String EmailSubject, String messageToBeSent) throws Exception {

	        //Get the session object
	        Properties props = new Properties();
	        props.put("mail.smtp.host",UtilLib.getEnvVar("OutlookServer"));
	        props.put("mail.smtp.auth", "false");
	        Session session=Session.getDefaultInstance(props, null);
	        session.setDebug(true);

	       /* System.out.println("Subject: "+EmailSubject);
	        System.out.println("\n");
	        System.out.println("Email body : "+messageToBeSent);*/

	   	 final String user=FromUser;
	           String to=ToUser;

     //Compose the message
     try {
         MimeMessage message = new MimeMessage(session);
         message.saveChanges();
         message.setFrom(new InternetAddress(user));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
         //message.setSubject("Automation Environment validations Report as on: "+dateFormat.format(date));
         message.setSubject(EmailSubject);
                 // creates message part
         MimeBodyPart messageBodyPart = new MimeBodyPart();
         //messageBodyPart.setContent(messageToBeSent, "text/html ; charset=ISO-8859-1");

         // creates multi-part
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);

         // adds attachments
        /* if (attachFiles != null) {
                     MimeBodyPart attachPart = new MimeBodyPart();
                     attachPart.attachFile(attachFiles);
                     multipart.addBodyPart(attachPart);
                 } */

         // String messageToBeSent="<body > <p><font face="+"calibri"+">Hi All,</font></p><p><font face="+"calibri"+">Please find the Environment validations report as in the attached file</font></p><p><font face="+"calibri"+">This set of execution was completed on: "+dateFormat.format(date)+"</font></p><p><font face="+"calibri"+">Brief summary as below:<br><img src=\"cid:image1\" /></font></p><font face="+"calibri"+">Regards<br><font face="+"calibri"+">Sumanth Talsani<br><br>---This is a auto generated email---</body>";
         messageBodyPart.setContent(messageToBeSent, "text/html");

          // sets the multi-part as e-mail's content
         message.setContent(multipart);

         //send the message
         Transport.send(message);

         System.out.println("Message sent successfully...");
     }
     catch (MessagingException e) {e.printStackTrace();}

 }






/*
	*//********************************************************************************************
	 * @Function_Name :  getDriver
	 * @Description : Creates a FirefoxDriver and InternetExplorer object to launch scripts in Firefox and Internet browser

	 ********************************************************************************************//*

	public static  WebDriver getDriver (){
		String Browser = Retrieve_EnvVar.ReportGlobalParameters("Browser");
		if(Browser.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}else
			if(Browser.equalsIgnoreCase("InternetExplorer")){
					File file = new File("C:\\Automation\\ASPT\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver();
			}else
				if(Browser.equalsIgnoreCase("Safari")){
					driver = new SafariDriver();
				}else
					if(Browser.equalsIgnoreCase("Chrome")){
						File file = new File("C:\\SeleniumWorks\\SORT\\chromedriver.exe");
						System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
						driver = new ChromeDriver();
					}else{
					System.out.println("Kindly select a valid browser");
				}

		return driver;

		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

*/
	/********************************************************************************************
	 * @Function_Name :  PressDownKey
	 * @Description : Creates a Robot object to launch simulate the Keys pressing

	 ***************************************************************************************/

	public static void PressDownKey() throws AWTException,IOException
	{
		Robot rob = new Robot();

		for(int i=0;i<keyInput.length;i++){
			rob.keyPress(keyInput[i]);
			rob.delay(1000);
		}
		//System.out.println("pressed down");

	}

	/********************************************************************************************
	 * @Function_Name :  WaitTime
	 * @Description : Waits for given time in argument Bar to disappear
	 * * @param : milliseconds - time in milliseconds
	 ***************************************************************************************/

	public static void WaitTime(int milliseconds) throws Exception {
		//long stoptime = System.currentTimeMillis()+2000;
		long stoptime = System.currentTimeMillis()+milliseconds;
		while(System.currentTimeMillis()<stoptime){
		}
	}



	/********************************************************************************************
	 * @Function_Name :  VerifyTableHeader
	 * @Description : verifies if the Table header is displayed as expected
	 * * @param : pageElement - Name of the ELEMENT
	 * @param : xpath - XPATH of the element
	 * @param : TestCase_Name - Name of the TestCase
	 ***************************************************************************************/

	public static boolean VerifyTableHeader(String pageElement, String xpath, String TestCase_Name) throws Exception {
		try {
			//UtilLib.WaitForProcessingBarToDisappear();


			String tableHeaderText = driver.findElement(By.xpath(xpath)).getText();

			if((tableHeaderText.trim()).equals(pageElement.trim())) {
				Reporter.log("PASS: POM_Lib.VerifyTableHeader : ' " +pageElement + "' table header is displayed. <br>");
				return true;
			} else {
				Reporter.log("FAIL: POM_Lib.VerifyTableHeader : ' " +pageElement + "' table header is Not displayed. <br>");
				UtilLib.CaptureScreenshot(TestCase_Name);
				return false;

			}



		}catch (Exception e) {
			Reporter.log("FAIL: POM_Lib.VerifyTableHeader : Error in page. ' " +pageElement + "' table header is Not displayed. <br>");
			UtilLib.CaptureScreenshot(TestCase_Name);
			return false;
		}
	}

	/********************************************************************************************
	 * @Function_Name :  VerifyMandatoryFields
	 * @Description : verifies if the given page element and given xpath is a mandatory field or not
	 * * @param : pageElement - Name of the ELEMENT
	 * @param : xpath - XPATH of the element
	 * @param : TestCase_Name - Name of the TestCase
	 ***************************************************************************************/

	public static boolean VerifyMandatoryFields(String pageElement, String xpath, String TestCase_Name) throws Exception {
		try {


			/* check for Service program Mandatory field */


			boolean mandatoryStatus = driver.findElement(By.xpath(xpath)).isDisplayed();

			if(mandatoryStatus == true) {
				Reporter.log("PASS: POM_Lib.VerifyMandatoryFields : ' " +pageElement + "' mandatory field is displayed. <br>");
				return true;
			} else {
				Reporter.log("FAIL: POM_Lib.VerifyMandatoryFields : ' " +pageElement + "' mandatory field is Not displayed. <br>");
				System.out.println("FAIL: POM_Lib.VerifyMandatoryFields : ' " +pageElement + "' mandatory field is Not displayed.");
				UtilLib.CaptureScreenshot(TestCase_Name);
				return false;
			}



		}catch (NoSuchElementException e) {
			Reporter.log("FAIL: POM_Lib.VerifyMandatoryFields : Error in page.  ' " +pageElement + "' mandatory field is Not displayed. <br>");
			System.out.println("FAIL: POM_Lib.VerifyMandatoryFields : Error in page.  ' " +pageElement + "' mandatory field is Not displayed. ");

			return false;
		}
	}

	/********************************************************************************************
	 * @Function_Name :  isElementPresent
	 * @Description : Checks if Element is present
	 * * @param : element - Name of the ELEMENT
	 * @param : by - XPATH of the element

	 ***************************************************************************************/

	public static boolean isElementPresent(String element , By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/********************************************************************************************
	 * @Function_Name :  CloseDriver
	 * @Description : Close the Webdriver Session

	 ***************************************************************************************//*

	public static void CloseDriver() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}


	}*/

	/********************************************************************************************
	 * @Function_Name :  exit
	 * @Description : Quit the Browser

	 ***************************************************************************************/

	/*public static void exit(){
		driver.close();
	}*/

	/********************************************************************************************
	 * @throws AWTException
	 * @Function_Name :  CaptureScreenshot
	 * @Description : Captures the screenshot of Failed Case with current time stamp and copies to the created folder
	 * * @param : TestCase_Name - Name of the TestCase
	 ***************************************************************************************/

	public static String CaptureScreenshot(String TestcaseName) {

		String SreenshotPath = null;

		String SubFolderName="FAIL";
		String ResultFolderName = null;



		/*String ResultFolderMain = "C:\\"+ApplicationName+"_TestExecutionResults\\"+FolderName;
		ResultFolderName = "C:\\"+ApplicationName+"_TestExecutionResults\\"+FolderName+"\\"+SubFolderName;*/

		//String ResultFolderMain = ".\\TestExecutionResults\\"+FolderName;
		ResultFolderName = Object_Definition_Library.getEnvVar("ScreenShotPath")+SubFolderName+"\\"+TestcaseName;



		File file = new File(ResultFolderName);
		try{
			if(file.mkdirs()){
				System.out.println("Sub Directory Created");
			}
			else{
				// System.out.println("Sub Directory is not created");
			}
		}catch(Exception e){
			e.printStackTrace();
		}


		DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
		Date screenshotDate = new Date();
		String picName = screenshotName1.format(screenshotDate);
		//String folderPath = ResultFolderName+"\\Screenshots\\"+TestcaseName+"\\"+picName+".png";
		String folderPath = ResultFolderName+"\\Screenshots\\"+picName+".png";
		System.out.println(picName);
		System.out.println(folderPath);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


		try {
			FileUtils.copyFile(scrFile, new File(folderPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		SreenshotPath = ResultFolderName+"\\Screenshots\\"+TestcaseName+"\\"+picName+".png";
		//SreenshotPath = "file:///"+folderPath;
		return SreenshotPath;
	}

	/********************************************************************************************
	 * @Function_Name :  CaptureScreenshot_PASS
	 * @Description : Captures the screenshot of Passed Case with current time stamp and copies to the created folder
	 * * @param : TestCase_Name - Name of the TestCase
	 ***************************************************************************************/
	public static String CaptureScreenshot_PASS(String TestcaseName){

		String SreenshotPath = null;

		String SubFolderName="PASS";
		String ResultFolderName = null;


		/*String ResultFolderMain = "C:\\"+ApplicationName+"_TestExecutionResults\\"+FolderName;
		ResultFolderName = "C:\\"+ApplicationName+"_TestExecutionResults\\"+FolderName+"\\"+SubFolderName;*/

		//String ResultFolderMain = ".\\TestExecutionResults\\"+FolderName;
		ResultFolderName = Object_Definition_Library.getEnvVar("ScreenShotPath")+SubFolderName+"\\"+TestcaseName;

		File file = new File(ResultFolderName);
		try{
			if(file.mkdirs()){
				System.out.println("Sub Directory Created");
			}
			else{
				// System.out.println("Sub Directory is not created");
			}
		}catch(Exception e){
			e.printStackTrace();
		}


		DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
		Date screenshotDate = new Date();
		String picName = screenshotName1.format(screenshotDate);
		//String folderPath = ResultFolderName+"\\Screenshots\\"+TestcaseName+"\\"+picName+".png";
		String folderPath = ResultFolderName+"\\Screenshots\\"+picName+".png";
		System.out.println(picName);
		System.out.println(folderPath);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(folderPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		SreenshotPath = ResultFolderName+TestcaseName+"\\"+picName+".png";
		//SreenshotPath = "file:///"+folderPath;
		return SreenshotPath;
	}





	/********************************************************************************************
	 * @Function_Name :  FindSysTimeExecution
	 * @Description : Find systime in specified format

	 ***************************************************************************************/

	/*public static String FindSysTimeExecution(){

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat SysDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		return SysDate.format(cal.getTime()).toUpperCase();

		//return SysDate;
	}
*/
	/********************************************************************************************
	 * @Function_Name :  DeleteExecutionStatusXML
	 * @Description : deletes the Failed Test xml

	 ***************************************************************************************/
	/*public static void DeleteFailedTestXML()
	{
		try{

			File file = new File(Object_Definition_Library.getEnvVar("FailedTestXmlLocation"));

			if(file.delete()){
				System.out.println(file.getName() + " is deleted!");
			}else{
				System.out.println("Delete operation is failed.");
			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}

*/
	/********************************************************************************************
	 * @Function_Name :  CreateFailedTestXMLFile
	 * @Description : creates the Failed Test xml
	 ***************************************************************************************/

	/*public static void CreateFailedTestXMLFile() {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Suite");
			rootElement.setAttribute("name", "Suite");
			rootElement.setAttribute("parallel", "false");
			doc.appendChild(rootElement);

			// staff elements
			Element staff = doc.createElement("Error");
			rootElement.appendChild(staff);


			// firstname elements
			Element classes = doc.createElement("Classes");
			//firstname.appendChild(doc.createTextNode("Partner360"));
			staff.appendChild(classes);



			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(Object_Definition_Library.getEnvVar("FailedTestXmlLocation")));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}	*/

	/********************************************************************************************
	 * @Function_Name :  AppendFailedTestXML
	 * @Description : appends the testcases to Failed Test xml
	 ***************************************************************************************/

	/*public static void AppendFailedTestXML(String ClassName) throws TransformerException, SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(Object_Definition_Library.getEnvVar("FailedTestXmlLocation"));

		Node ExecutionStatus = doc.getElementsByTagName("Classes").item(0);
		NodeList list = ExecutionStatus.getChildNodes();
		@SuppressWarnings("unused")
		int len = list.getLength();

		Element teststep = doc.createElement("class");
		teststep.setAttribute("name", ClassName);
		ExecutionStatus.appendChild(teststep);
		System.out.println("Created");
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		String abc = Object_Definition_Library.getEnvVar("FailedTestXmlLocation");
		StreamResult result = new StreamResult(new File(abc));
		transformer.transform(source, result);
	}*/


	/********************************************************************************************
	 * @Function_Name :  Report_PASS
	 * @Description : Reporter statement for Passed test step
	 * *@param : ElementName - Name of the Element, Button or Text Box etc
	 *@param : Message - output message
	 *@param : FunctionName - Name of the Function
	 ***************************************************************************************/
	/*public static void Report_PASS(String ElementName, String Message, String FunctionName) {
		String PassConsoleReportingRequired = Retrieve_EnvVar.ReportGlobalParameters("PassConsoleReportingRequired");
		Reporter.log("PASS: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+". <br>");
		if(PassConsoleReportingRequired.equalsIgnoreCase("YES")){
			System.out.println("PASS: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+".");
		}
	}
*/

	/********************************************************************************************
	 * @Function_Name :  Report_FAIL
	 * @Description : Reporter statement for Failed test step
	 * *@param : ElementName - Name of the Element, Button or Text Box etc
	 *@param : Message - output message
	 *@param : FunctionName - Name of the Function
	 ***************************************************************************************/
	public static void Report_FAIL(String ElementName, String Message, String FunctionName) {
		String FailConsoleReportingRequired = Retrieve_EnvVar.ReportGlobalParameters("FailConsoleReportingRequired");
		Reporter.log("FAIL: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+". <br>");
		if(FailConsoleReportingRequired.equalsIgnoreCase("YES")){
			System.out.println("FAIL: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+".");
		}
	}


	/********************************************************************************************
	 * @Function_Name :  WaitForLoadingBarToDisappear
	 * @Description : Waits for the Loading bar to disappear
	 ***************************************************************************************/

	public static void WaitForLoadingBarToDisappear() throws Exception {
		Boolean bool=true;
		for( ;bool==true; ){
			//bool=driver.findElement(By.xpath("//*[@class='dijitDialogPaneContent']/div/p/b[contains(text(),'Loading...')]")).isDisplayed();
			bool=driver.findElement(By.xpath("//*[@class='dijitDialogPaneContent']/div/p/b[contains(text(),'Loading')]")).isDisplayed();

			long stoptime = System.currentTimeMillis()+2000;
			while(System.currentTimeMillis()<stoptime){
			}
		}
	}



	public static String getTestCasePointerName(String TestCaseName){

		String delims = "_";
		String[] tokens = TestCaseName.split(delims);
		//	System.out.println(tokens[0]);
		return tokens[0];

	}

	public static String TestTimeSummary(String ExecutionStartTime,String ExecutionStopTime) throws ParseException{

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		Date date1 = format.parse(ExecutionStartTime);
		Date date2 = format.parse(ExecutionStopTime);
		long difference = date2.getTime() - date1.getTime();
		System.out.println("difference : "+difference);

		difference=difference/1000;
		int minutes= (int)difference/60;
		int sec= (int)difference%60;
		int hours=minutes/60;
		minutes=minutes%60;
		System.out.println("Hours:"+hours);
		System.out.println("Minutes:"+minutes);
		System.out.println("Seconds:"+sec);

		System.out.println("Time duration:  " +hours+" hours "+minutes+" minutes "+sec+" seconds");

		String TimeDifference = ""+hours+":"+minutes+":"+sec+"";

		return TimeDifference;
	}


	/********************************************************************************************
	 * @Function_Name :  uf_C_ClickOnElement
	 * @Description : Clicks on a particular 'Element' .
	 * *@param TestCase_Name - Name of the TestCase
	 *@param ElementName - Name of the Element
	 *@param Xpath - XPATH of the Element

	 ********************************************************************************************/

	public static boolean uf_C_ClickOnElement(String ElementName,String Xpath,String TestCase_Name) throws Exception {
		int RerunFlag=0;
		if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
			long stoptime = System.currentTimeMillis()+5000;
			while(System.currentTimeMillis()<stoptime){
			}
		}

		try {

			boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
			if (Verify == true) {
				driver.findElement(By.xpath(Xpath)).click();
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}

				UtilLib.WaitTime(4000);
				UtilLib.Report_PASS(ElementName, "is succesfully clicked", "ClickOnElement");


			}else{
				RerunFlag = RerunFlag+1;
				UtilLib.Report_FAIL(ElementName, "is not displayed in the page", "ClickOnElement");
				UtilLib.CaptureScreenshot(TestCase_Name);
			}

			if(RerunFlag>0){
				//DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				return false;
			}else{
				return true;
			}

		}      catch(UnhandledAlertException alert){
			//	UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return false;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return false;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return false;
		}
	}

	/********************************************************************************************
	 * @Function_Name :  getEnvVar
	 * @Description : Get the value from the EnvVar.xml

	 ********************************************************************************************/
	public static String getEnvVar(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportGlobalParameters(tag);
		return xmlValue;
	}

	 /********************************************************************************************/
		public static String getAEProdQuery(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportAEProdQuery(tag);
			return xmlValue;
		}
		public static String getAEProdQuery1(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportAEProdQuery1(tag);
			return xmlValue;
		}

		/********************************************************************************************
		 * @Function_Name :  getStageQueries
		 * @Description : Get the query from the XML

		 ********************************************************************************************/
		public static String getAEStageQuery(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportAEStageQuery(tag);
			return xmlValue;
		}

		 /********************************************************************************************/
		public static String getAECLTDQuery(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportAECLTDQuery(tag);
			return xmlValue;
		}

		/********************************************************************************************
		 * @Function_Name :  getStageQueries
		 * @Description : Get the query from the XML

		 ********************************************************************************************/
		public static String getAECLORAQuery(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportAECLORAQuery(tag);
			return xmlValue;
		}


	/********************************************************************************************
	 * @Function_Name :  getEnvVar
	 * @Description : Get the value from the EnvVar.xml

	 ********************************************************************************************/
	public static String getEnvCredentials(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportCredentialParameters(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getParam
	 * @Description : Get the value from the EnvVar.xml

	 ********************************************************************************************/
	public static String getParam(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportParameters(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getImages
	 * @Description : Get the Images path from the EnvVar.xml

	 ********************************************************************************************/
	public static String getImagePath(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportGlobalImages(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getCredentials
	 * @Description : Get the Images path from the EnvVar.xml

	 ********************************************************************************************/
	public static String getCredentials(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportCredentials(tag);
		return xmlValue;
	}

	public static String getGMWalkOProdQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportGMWalkProdQuery(tag);
		return xmlValue;
	}


	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getGMWalkStageQuery(String tag,String type) {
		String xmlValue = Retrieve_EnvVar.ReportGMWalkStageQuery(tag,type);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getRevenueBOProdQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportRevenueBOProdQuery(tag);
		return xmlValue;
	}
	public static String getRevenueBOProdQuery1(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportRevenueBOProdQuery1(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getRevenueBOStageQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportRevenueBOStageQuery(tag);
		return xmlValue;
	}



	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getPNLProdQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportPNLProdQuery(tag);
		return xmlValue;
	}

	public static String getPNLProdQuery1(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportPNLProdQuery1(tag);
		return xmlValue;
	}


	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getPNLStageQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportPNLStageQuery(tag);
		return xmlValue;
	}


	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	/*public static String getBookingsCubeQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsCubeQuery(tag);
		return xmlValue;
	}*/

	/********************************************************************************************
	 * @Function_Name :  getProdQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getBookingsCubeProdQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsCubeProdQuery(tag);
		return xmlValue;
	}
	public static String getBookingsCubeProdQuery1(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsCubeProdQuery1(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getStageQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getBookingsCubeStageQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsCubeStageQuery(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getProdQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getBookingsBOProdQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsBOProdQuery(tag);
		return xmlValue;
	}
	public static String getBookingsBOProdQuery1(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsBOProdQuery1(tag);
		return xmlValue;
	}
	/********************************************************************************************
	 * @Function_Name :  getStageQueries
	 * @Description : Get the query from the XML

	 ********************************************************************************************/
	public static String getBookingsBOStageQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportBookingsBOStageQuery(tag);
		return xmlValue;
	}


	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the EnvVar.xml

	 ********************************************************************************************/
	public static String getCFAProdQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportCFAProdQuery(tag);
		return xmlValue;
	}
	public static String getCFAProdQuery1(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportCFAProdQuery1(tag);
		return xmlValue;
	}

	/********************************************************************************************
	 * @Function_Name :  getQueries
	 * @Description : Get the query from the EnvVar.xml

	 ********************************************************************************************/
	public static String getCFAStageQuery(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportCFAStageQuery(tag);
		return xmlValue;
	}

	/********************************************************************************************/
		public static String getFetchCubeProdQuery(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportFetchCubeProdQuery(tag);
			return xmlValue;
		}
		public static String getFetchCubeProdQuery1(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportFetchCubeProdQuery1(tag);
			return xmlValue;
		}

		/********************************************************************************************
		 * @Function_Name :  getStageQueries
		 * @Description : Get the query from the XML

		 ********************************************************************************************/
		public static String getFetchCubeStageQuery(String tag) {
			String xmlValue = Retrieve_EnvVar.ReportFetchCubeStageQuery(tag);
			return xmlValue;
		}



		  /********************************************************************************************
		   * @author vinbhask.adm
		   * @Function_Name:
		   * @Description: Copy Oracle result set to Excel
		   ********************************************************************************************/
		  public static void OracleResultSetToExcel(String connurl,String uname,String pword,String Query,XSSFWorkbook workbook ,XSSFSheet stgsheet, String TestCaseName, String Envi,String PeriodIdType, String ViewName)
		  {
			  String ComponentTypeBWPeriodId=PeriodIdType.replaceAll("BWPeriodId", "");
			  String ComponentType=ComponentTypeBWPeriodId.replaceAll("INPeriodId", "");
			  String PeriodId=UtilLib.getParam(PeriodIdType);
			  String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

			  try
			    {
				  // Load Oracle JDBC Driver
			        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			        // Connect to Oracle Database
			        Connection conn = DriverManager.getConnection(connurl, uname, pword);
			        //System.out.println("Connected to Oracle...");
			        Statement stmt = conn.createStatement();
			        stmt.setQueryTimeout(600);
			        //System.out.println("Statement created...");
			        ResultSet rs = stmt.executeQuery(Query);
			        //System.out.println("Query Executed in Oracle...");

				/*ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();*/

				if (!rs.isBeforeFirst() ) {
					//System.out.println("Result Set is empty in "+Envi);
					 UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", " ");
					 UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
					 UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows in the "+Envi+" Environment", "FAILED",ComponentType,"",PeriodId,Query,dateStart,ViewName);
					 Assert.fail("The query: "+newline+newline+"\""+Query+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows in the "+Envi+" Environment");
					}


				 /*System.out.println(" This table has " + colCount + " columns.\n");
					 while (rs.next()) {
						//Print one row
						for(int i = 1 ; i <= colCount; i++){

						      System.out.print(rs.getString(i) + " "); //Print one element of a row
						}
						  System.out.println();//Move to the next line to print the next row.
						    }

					 for (int i = 1; i < colCount + 1; i++ ) {

						System.out.println(rsmd.getColumnName(i));
					}*/

				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				int currentRow = 0;
				XSSFRow row = stgsheet.createRow(currentRow);
				int numCols = resultSetMetaData.getColumnCount();
				CellStyle style = workbook.createCellStyle();
				style.setFillBackgroundColor(HSSFColor.BLUE.index);

				for (int j = 1; j < numCols+1; j++) {
			        String title = resultSetMetaData.getColumnName(j);
			        org.apache.poi.ss.usermodel.Cell cell =  row.createCell(j-1);
			        cell.setCellValue(title.toString());
			        cell.setCellStyle(style);
			        			       			    }
				XSSFCell cell;
				int i=1;
				while(rs.next())
			      {
			         row=stgsheet.createRow(i);
			         for (int j=1;j<numCols+1;j++){
				         cell=row.createCell(j-1);
				         int ColType=resultSetMetaData.getColumnType(j);
				         //System.out.println("The col type is: "+ColType);
				         switch (ColType) {
				         case 0: //Null
				         case 1: //Char
				         case 12: //Varchar
				         case 111: //Other
					        cell.setCellValue(rs.getString(j));
					        break;
					     case 2: //Numeric
					     case 3: //Decimal
					     case 8: //Double
					        cell.setCellValue(rs.getDouble(j));
					        break;
					     case 4: //Integer
					     case 5: //SmallInt
					           cell.setCellValue(rs.getInt(j));
					           break;
					     case 6: //Float
					     case 7: //REAL
					           cell.setCellValue(rs.getFloat(j));
					           break;
					     case 91: //Date
					    	 	cell.setCellValue(rs.getDate(j));
					    	 	break;
					     case 92: //Time
					    	 	cell.setCellValue(rs.getTime(j));
					    	 	break;
					     case 93: //Time-stamp
					    	 	cell.setCellValue(rs.getTimestamp(j));
					    	 	break;
					     default:
					    	    cell.setCellValue(rs.getString(j));
					    	    break;
				              }
				            }
			         i++;
			      }
				//System.out.println("Closing the connection to database");
				conn.close();
			    }

				   catch (SQLException e) {
				       if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
				          /*Check Teradata exception.*/
				         int TeradataCode = e.getErrorCode();  /*Get specific error.*/
				         if (TeradataCode!=0){
				        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED",ComponentType,"",PeriodId,Query,dateStart,ViewName);
						     Assert.fail("Query has failed to execute");
				        					         }
				       }
				     }
			}


	/********************************************************************************************
	 * @Function_Name :  uf_C_EnterDataInTextBox
	 * @Description : Enters data in textbox
	 * *@param TestCase_Name - Name of the TestCase
	 *@param ElementName - Name of the Element
	 *@param Xpath - XPATH of the Element
	 *@param Data - Data that is to be passed to text field
	 * @throws Exception
	 ********************************************************************************************/


	public static String uf_C_EnterDataInTextBox(String ElementName,String Xpath,String Data, String TestCase_Name) throws Exception{
		int RerunFlag = 0;
		try {

			boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
			if (Verify  == true){
				driver.findElement(By.xpath(Xpath)).clear();
				if(UtilLib.getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+2000;
					while(System.currentTimeMillis()<stoptime){
					}
				}

				driver.findElement(By.xpath(Xpath)).sendKeys(Data);
				long stoptime = System.currentTimeMillis()+2000;
				while(System.currentTimeMillis()<stoptime){
				}
				//driver.findElement(By.xpath(Xpath)).sendKeys(Keys.TAB);
				UtilLib.Report_PASS(ElementName,"is present in the page. Data entered is "+Data,"EnterDataInTextBox");

			} else {
				RerunFlag = RerunFlag+1;
				UtilLib.Report_FAIL(ElementName,"is not present in the page ","EnterDataInTextBox");
				UtilLib.CaptureScreenshot(TestCase_Name);
			}
			if(RerunFlag>0){
				return "";
			} else{
				return Data;
			}


		}  catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return null;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return null;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return null;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return null;
		}

	}
	/********************************************************************************************
	 * @Function_Name :  uf_C_SelectValueFromDropdown
	 * @Description : Selects the value from the dropdown
	 * *@param TestCase_Name - Name of the TestCase
	 * * @param DropdownName - Name of the Dropdown
	 * * @param Xpath - Xpath of the dropdown (till select)
	 * * @param VisibleText - Visible text of Option to be selected

	 ********************************************************************************************/


	@SuppressWarnings("unused")
	public static boolean uf_C_SelectValueFromDropdown(String DropdownName,String Xpath,String VisibleText,String TestCase_Name) throws Exception{
		int RerunFlag=0;
		String RMAXpath = "";

		try {
			boolean Verify = driver.findElement(By.xpath(Xpath)).isDisplayed();
			if (Verify == true){
				new Select(driver.findElement(By.xpath(Xpath))).selectByVisibleText(VisibleText);
				//new Select(driver.findElement(By.xpath(Xpath))).selectByIndex(1);

				UtilLib.Report_PASS(VisibleText,"is selected from the "+DropdownName+" list","SelectValueFromDropdown");
				if(UtilLib.getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
			} else {
				RerunFlag = RerunFlag+1;
				UtilLib.Report_FAIL(DropdownName,"is not present in the page","verifyLinkPresent");
				UtilLib.CaptureScreenshot(TestCase_Name);
			}
			if(RerunFlag>0){
				return false;
			} else{
				return true;
			}


		} catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return false;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return false;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.Report_FAIL(VisibleText,"is not available in the "+DropdownName+" list","SelectValueFromDropdown");
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			return false;

		}
	}

	/********************************************************************************************
	 * @Function_Name :  uf_C_HandleAlert_Accept
	 * @Description : Handles the alerts in the page by clicking on OK button
	 * *@param TestCase_Name - Name of the TestCase
	 *@param ElementName - Name of the Element
	 *@param ErrorMessage - Expected Error Message
	 *@param FunctionName - Function name in POM_Lib
	 * @throws Exception
	 ********************************************************************************************/


	@SuppressWarnings("unused")
	public static boolean uf_C_HandleAlert_Accept(String ElementName, String ErrorMessage, String TestCase_Name) throws Exception {
		int RerunFlag = 0;
		String ScrPath = "";


		try {
			if(ErrorMessage.equalsIgnoreCase("")){
				Alert javascriptAlert = driver.switchTo().alert();
				String Alertmessage = javascriptAlert.getText();
				//UtilLib.captureScreen_Alert(TestCase_Name);
				javascriptAlert.accept();
				System.out.println("Alert message : "+Alertmessage);

			}else{
				Alert javascriptAlert = driver.switchTo().alert();
				String Alertmessage = javascriptAlert.getText();
				//UtilLib.captureScreen_Alert(TestCase_Name);
				javascriptAlert.accept();
				System.out.println("Alert message : "+Alertmessage);
				Alertmessage = Alertmessage.toLowerCase().trim();
				ErrorMessage = ErrorMessage.toLowerCase().trim();
				/*System.out.println("Alert lowercase = "+Alertmessage.toLowerCase());
				System.out.println("Expected lowercase = "+ErrorMessage.toLowerCase());*/

				if (Alertmessage.equals(ErrorMessage)){
					UtilLib.Report_PASS(ElementName, "Error text displayed '"+Alertmessage+"' is matching with the expected Error text '"+ErrorMessage+"' ","HandleAlert");
				} else {
					RerunFlag = RerunFlag + 1;
					UtilLib.Report_FAIL(ElementName, "Error text displayed '"+Alertmessage+"' is NOT matching with the expected Error text '"+ErrorMessage+"' ","HandleAlert");
					UtilLib.CaptureScreenshot(TestCase_Name);
					ScrPath = UtilLib.captureScreen_Alert(TestCase_Name);
				}
			}


			if(RerunFlag>0){
				return false;
			} else{
				return true;
			}


		} catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return false;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);

			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return false;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return false;
		}
		catch (Exception e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Screenshot error", "Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

	}


	/********************************************************************************************
	 * @Function_Name :  uf_C_HandleAlert_Dismiss
	 * @Description : Handles the alerts in the page by clicking on OK button
	 * *@param TestCase_Name - Name of the TestCase
	 *@param ElementName - Name of the Element
	 *@param ErrorMessage - Expected Error Message
	 *@param FunctionName - Function name in POM_Lib
	 * @throws Exception
	 ********************************************************************************************/


	@SuppressWarnings("unused")
	public static boolean uf_C_HandleAlert_Dismiss(String ElementName, String ErrorMessage, String TestCase_Name) throws Exception {
		int RerunFlag = 0;
		String ScrPath = "";

		try {
			if(ErrorMessage.equalsIgnoreCase("")){
				Alert javascriptAlert = driver.switchTo().alert();
				String Alertmessage = javascriptAlert.getText();
				//UtilLib.captureScreen_Alert(TestCase_Name);
				javascriptAlert.dismiss();
				System.out.println("Alert message : "+Alertmessage);

			}else{
				Alert javascriptAlert = driver.switchTo().alert();
				String Alertmessage = javascriptAlert.getText();
				//UtilLib.captureScreen_Alert(TestCase_Name);
				javascriptAlert.dismiss();
				System.out.println("Alert message : "+Alertmessage);
				Alertmessage = Alertmessage.toLowerCase().trim();
				ErrorMessage = ErrorMessage.toLowerCase().trim();
				/*System.out.println("Alert lowercase = "+Alertmessage.toLowerCase());
				System.out.println("Expected lowercase = "+ErrorMessage.toLowerCase());*/

				if (Alertmessage.equals(ErrorMessage)){
					UtilLib.Report_PASS(ElementName, "Error text displayed '"+Alertmessage+"' is matching with the expected Error text '"+ErrorMessage+"' ","HandleAlert");
				} else {
					RerunFlag = RerunFlag + 1;
					UtilLib.Report_FAIL(ElementName, "Error text displayed '"+Alertmessage+"' is NOT matching with the expected Error text '"+ErrorMessage+"' ","HandleAlert");
					UtilLib.CaptureScreenshot(TestCase_Name);
					ScrPath = UtilLib.captureScreen_Alert(TestCase_Name);
				}
			}


			if(RerunFlag>0){
				return false;
			} else{
				return true;
			}


		} catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return false;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);

			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return false;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return false;
		}
		catch (Exception e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Screenshot error", "Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

	}


	/********************************************************************************************
	 * @Function_Name :  uf_C_GetUIData
	 * @Description : Gets data from UI
	 * *@param TestCase_Name - Name of the TestCase
	 *@param ElementName - Name of the Element
	 *@param Xpath - XPATH of the Element
	 *@param FunctionName - Function name in POM_Lib
	 * @throws Exception
	 ********************************************************************************************/


	public static String uf_C_GetUIData(String ElementName,String Xpath,String TestCase_Name) throws Exception{
		int RerunFlag = 0;
		String UIData = "";

		try {
			boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
			if (Verify  == true){
				boolean Verify_Displayed  = driver.findElement(By.xpath(Xpath)).isDisplayed();
				if (Verify_Displayed  == true){

					UIData = driver.findElement(By.xpath(Xpath)).getText();
					UtilLib.Report_PASS(ElementName,"is present in the page and the value in UI is : "+UIData,"verifyElementPresent");
				} else {
					RerunFlag = RerunFlag+1;
					UtilLib.Report_FAIL(ElementName,"is not present in the page","verifyElementPresent");
					UtilLib.CaptureScreenshot(TestCase_Name);
				}
			} else {
				RerunFlag = RerunFlag+1;
				UtilLib.Report_FAIL(ElementName,"is not present in the page ","verifyElementPresent");
				UtilLib.CaptureScreenshot(TestCase_Name);

			}

			if(RerunFlag>0){
				return null;
			} else{
				return UIData;
			}


		} catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return null;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return null;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return null;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return null;
		}
	}




	/*public static String GetElementText(String ElementName,String Xpath,String TestCase_Name) throws Exception{
		int RerunFlag = 0;
		String Data= null;
		if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
		long stoptime = System.currentTimeMillis()+5000;
		while(System.currentTimeMillis()<stoptime){
		}
		}
		try {
		boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
		if (Verify  == true){

		Data = driver.findElement(By.xpath(Xpath)).getText();
		if (Data.equalsIgnoreCase("")){
		RerunFlag = RerunFlag+1;
		UtilLib.Report_FAIL(ElementName,"Text is not available for this element. Text displayed is  '"+Data+"'","GetElementText");
		} else {
		UtilLib.Report_PASS(ElementName,"'"+Data+"' is the text available for this element","GetElementText");
		}

		} else {
		RerunFlag = RerunFlag+1;
		UtilLib.Report_FAIL(ElementName,"is not present in the page ","GetElementText");
		UtilLib.CaptureScreenshot(TestCase_Name);

		}
		if(RerunFlag>0){
		return "";
		} else{
		return Data;
		}


		} catch(UnhandledAlertException alert){
		// UtilLib.CaptureScreenshot(TestCase_Name);
		UtilLib.captureScreen_Alert(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
		return null;
		}

		catch (NoSuchElementException e) {

		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
		return null;
		}

		catch (NoSuchFrameException e) {
		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
		return null;
		}

		catch (Error e) {
		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
		return null;
		}
		}*/

	/********************************************************************************************
	 * @Function_Name :  uf_C_EnterTextDataWithTimeStamp
	 * @Description : Input the String and tabs out from the field
	 * * @param : Data - Data to be entered in the field
	 * @param : elementXPATH - XPATH of the element
	 * @param TestCase_Name - Name of the TestCase
	 ***************************************************************************************/

	public static String uf_C_EnterTextDataWithTimeStamp(String ElementName, String Xpath, String TestCase_Name) throws Exception{
		if(UtilLib.getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
			long stoptime = System.currentTimeMillis()+5000;
			while(System.currentTimeMillis()<stoptime){
			}
		}
		try {

			Calendar cal = Calendar.getInstance();
			//	SimpleDateFormat SysDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
			SimpleDateFormat SysDate = new SimpleDateFormat("ddMMM-hh-mm-ss");
			String Data = SysDate.format(cal.getTime()).toUpperCase();

			UtilLib.WaitTime(2000);
			boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
			if (Verify  == true){
				driver.findElement(By.xpath(Xpath)).clear();
				if(UtilLib.getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+2000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				driver.findElement(By.xpath(Xpath)).sendKeys("TestAuto-"+Data);
				UtilLib.WaitTime(2000);
				driver.findElement(By.xpath(Xpath)).sendKeys(Keys.TAB);
				Data = "AutoTest-"+Data;
				UtilLib.Report_PASS(ElementName,"is present in the page. Data entered is "+Data,"EnterTextDataWithTimeStamp");
				return Data;
			} else {
				UtilLib.Report_FAIL(ElementName,"is not present in the page ","EnterTextDataWithTimeStamp");
				UtilLib.CaptureScreenshot(TestCase_Name);
				return null;
			}
			//  UtilLib.Report_PASS(ElementName, Message, FunctionName)




		}  catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return null;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return null;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return null;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return null;
		}


	}


	/********************************************************************************************
	 * @Function_Name :  verifyElementNotPresent
	 * @Description : Verifies the Elements not present in the page
	 * *@param TestCase_Name - Name of the TestCase
	 *@param ElementName - Name of the Element
	 *@param Xpath - XPATH of the Element
	 *@param FunctionName - Function name in POM_Lib
	 * @throws Exception
	 ********************************************************************************************/


	public static boolean uf_C_verifyElementNotPresent(String ElementName,String Xpath,String TestCase_Name) throws Exception{
		int RerunFlag = 0;

		try {
			boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
			if (Verify  == true){
				boolean Verify_Displayed  = driver.findElement(By.xpath(Xpath)).isDisplayed();
				if (Verify_Displayed  == true){
					UtilLib.Report_FAIL(ElementName,"is present in the page","verifyElementPresent");
					UtilLib.CaptureScreenshot(TestCase_Name);

				} else {
					RerunFlag = RerunFlag+1;
					UtilLib.Report_PASS(ElementName,"is not present in the page","verifyElementPresent");
					UtilLib.CaptureScreenshot_PASS(TestCase_Name);


				}
			} else {
				RerunFlag = RerunFlag+1;
				UtilLib.Report_PASS(ElementName,"is not present in the page ","verifyElementPresent");
				UtilLib.CaptureScreenshot_PASS(TestCase_Name);

			}

			if(RerunFlag>0){
				return false;
			} else{
				return true;
			}


		} catch(UnhandledAlertException alert){
			//UtilLib.CaptureScreenshot(TestCase_Name);
			UtilLib.captureScreen_Alert(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			return false;
		}

		catch (NoSuchElementException e) {

			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			return false;
		}

		catch (NoSuchFrameException e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			return false;
		}

		catch (Error e) {
			UtilLib.CaptureScreenshot(TestCase_Name);
			DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			return false;
		}
	}




	public static boolean uf_C_ElementIsDisabled(String ElementName,String Xpath,String TestCase_Name){
		int RerunFlag=0;
		if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
		long stoptime = System.currentTimeMillis()+5000;
		while(System.currentTimeMillis()<stoptime){
		}
		}
		try {
		boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
		if (Verify == true){
		boolean Status = driver.findElement(By.xpath(Xpath)).isEnabled();
		if (Status == false){
		UtilLib.Report_PASS(ElementName,"is disabled","ElementIsDisabled");
		} else {
		UtilLib.Report_FAIL(ElementName,"is not disabled","ElementIsDisabled");
		RerunFlag = RerunFlag+1;
		}
		} else {
		RerunFlag = RerunFlag+1;
		UtilLib.Report_FAIL(ElementName,"is not present in the page","ElementIsDisabled");
		UtilLib.CaptureScreenshot(TestCase_Name);
		}
		if(RerunFlag>0){
		return false;
		} else{
		return true;
		}
		} catch(UnhandledAlertException alert){
		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
		return false;
		}

		catch (NoSuchElementException e) {

		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
		return false;
		}

		catch (NoSuchFrameException e) {
		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
		return false;
		}

		catch (Error e) {
		UtilLib.CaptureScreenshot(TestCase_Name);
		DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
		UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
		return false;
		}
		}




	////////////////////////////////////////////////////////////////////////


	///////////////////////////////////////////////








/***************************************************************************************/

	public static String captureScreen_Alert(String TestcaseName) throws Exception {

		String SreenshotPath = null;

		String SubFolderName="FAIL";
		String ResultFolderName = null;

		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   Rectangle screenRectangle = new Rectangle(screenSize);
		   Robot robot = new Robot();

		/*String ResultFolderMain = "C:\\"+ApplicationName+"_TestExecutionResults\\"+FolderName;
		ResultFolderName = "C:\\"+ApplicationName+"_TestExecutionResults\\"+FolderName+"\\"+SubFolderName;*/

		//String ResultFolderMain = ".\\TestExecutionResults\\"+FolderName;
		ResultFolderName = Object_Definition_Library.getEnvVar("ScreenShotPath")+SubFolderName+"\\"+TestcaseName;



		File file = new File(ResultFolderName);
		try{
			if(file.mkdirs()){
				System.out.println("Sub Directory Created");
			}
			else{
				// System.out.println("Sub Directory is not created");
			}
		}catch(Exception e){
			e.printStackTrace();
		}


		DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
		Date screenshotDate = new Date();
		String picName = screenshotName1.format(screenshotDate);
		//String folderPath = ResultFolderName+"\\Screenshots\\"+TestcaseName+"\\"+picName+".png";
		String folderPath = ResultFolderName+"\\Screenshots\\"+picName+".png";
		System.out.println(picName);
		System.out.println(folderPath);
	//	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 BufferedImage image = robot.createScreenCapture(screenRectangle);
		   ImageIO.write(image, "png", new File(folderPath));

/*
		try {
			FileUtils.copyFile(scrFile, new File(folderPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
		SreenshotPath = ResultFolderName+"\\Screenshots\\"+TestcaseName+"\\"+picName+".png";
		//SreenshotPath = "file:///"+folderPath;
		return SreenshotPath;




		}

	/********************************************************************************************
	 * @Function_Name :  FindSysTimeExecution
	 * @Description : Find systime in specified format

	 ***************************************************************************************/

	public static String FindSysTimeExecution(){

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat SysDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		return SysDate.format(cal.getTime()).toUpperCase();

		//return SysDate;
	}

	/********************************************************************************************
	 * @Function_Name :  DeleteExecutionStatusXML
	 * @Description : deletes the Failed Test xml

	 ***************************************************************************************/
	public static void DeleteFailedTestXML()
	{
		try{

			File file = new File(Object_Definition_Library.getEnvVar("FailedTestXmlLocation"));

			if(file.delete()){
				System.out.println(file.getName() + " is deleted!");
			}else{
				System.out.println("Delete operation is failed.");
			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}


	/********************************************************************************************
	 * @Function_Name :  CreateFailedTestXMLFile
	 * @Description : creates the Failed Test xml
	  ***************************************************************************************/

	public static void CreateFailedTestXMLFile() {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Suite");
			rootElement.setAttribute("name", "Suite");
			rootElement.setAttribute("parallel", "false");
			doc.appendChild(rootElement);

			// staff elements
			Element staff = doc.createElement("Error");
			rootElement.appendChild(staff);


			// firstname elements
			Element classes = doc.createElement("Classes");
			//firstname.appendChild(doc.createTextNode("Partner360"));
			staff.appendChild(classes);



			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(Object_Definition_Library.getEnvVar("FailedTestXmlLocation")));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	/********************************************************************************************
	 * @Function_Name :  AppendFailedTestXML
	 * @Description : appends the testcases to Failed Test xml
	  ***************************************************************************************/

	public static void AppendFailedTestXML(String ClassName) throws TransformerException, SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(Object_Definition_Library.getEnvVar("FailedTestXmlLocation"));

		Node ExecutionStatus = doc.getElementsByTagName("Classes").item(0);
		NodeList list = ExecutionStatus.getChildNodes();
		@SuppressWarnings("unused")
		int len = list.getLength();

		Element teststep = doc.createElement("class");
		teststep.setAttribute("name", ClassName);
		ExecutionStatus.appendChild(teststep);
		System.out.println("Created");
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		String abc = Object_Definition_Library.getEnvVar("FailedTestXmlLocation");
		StreamResult result = new StreamResult(new File(abc));
		transformer.transform(source, result);
	}


//	/********************************************************************************************
//	* @Function_Name :  Report_PASS
//	* @Description : Reporter statement for Passed test step
//	* *@param : ElementName - Name of the Element, Button or Text Box etc
//	  *@param : Message - output message
//	  *@param : FunctionName - Name of the Function
//	 ************************************************************************************** */
	public static void Report_PASS(String ElementName, String Message, String FunctionName) {
		String PassConsoleReportingRequired = Retrieve_EnvVar.ReportGlobalParameters("PassConsoleReportingRequired");
		Reporter.log("PASS: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+". <br>");
		if(PassConsoleReportingRequired.equalsIgnoreCase("YES")){
			System.out.println("PASS: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+".");
		}
	}




	/********************************************************************************************
	* @Function_Name :  Report_INFO
	* @Description : Reporter statement for Information
	* *@param : ElementName - Name of the Element, Button or Text Box etc
	  *@param : Message - output message
	  *@param : FunctionName - Name of the Function
	 ***************************************************************************************/
	public static void Report_INFO(String ElementName, String Message, String FunctionName) {
		String InfoConsoleReportingRequired = Retrieve_EnvVar.ReportGlobalParameters("InfoConsoleReportingRequired");
		Reporter.log("INFO: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+". <br>");
		if(InfoConsoleReportingRequired.equalsIgnoreCase("YES")){
			System.out.println("INFO: POM_Lib."+FunctionName+" : '"+ElementName+"' "+Message+".");
		}
	}


	/********************************************************************************************
	* @Function_Name :  WaitForLoadingBarToDisappear
	* @Description : Waits for the Loading bar to disappear
	***************************************************************************************//*

	public static void WaitForLoadingBarToDisappear() throws Exception {
	Boolean bool=true;
	for( ;bool==true; ){
	//bool=driver.findElement(By.xpath("//*[@class='dijitDialogPaneContent']/div/p/b[contains(text(),'Loading...')]")).isDisplayed();
	bool=driver.findElement(By.xpath("//*[@class='dijitDialogPaneContent']/div/p/b[contains(text(),'Loading')]")).isDisplayed();

	long stoptime = System.currentTimeMillis()+2000;
	while(System.currentTimeMillis()<stoptime){
	}
	}
	}


	public static String TestTimeSummary(String ExecutionStartTime,String ExecutionStopTime) throws ParseException{

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		Date date1 = format.parse(ExecutionStartTime);
		Date date2 = format.parse(ExecutionStopTime);
		long difference = date2.getTime() - date1.getTime();
		System.out.println("difference : "+difference);

		difference=difference/1000;
		int minutes= (int)difference/60;
		int sec= (int)difference%60;
		int hours=minutes/60;
		minutes=minutes%60;
		System.out.println("Hours:"+hours);
		System.out.println("Minutes:"+minutes);
		System.out.println("Seconds:"+sec);

		System.out.println("Time duration:  " +hours+" hours "+minutes+" minutes "+sec+" seconds");

		String TimeDifference = ""+hours+":"+minutes+":"+sec+"";

		return TimeDifference;
	}


	*//********************************************************************************************
	 * @Function_Name :  getEnvVar
	 * @Description : Get the value from the EnvVar.xml
	 ********************************************************************************************//*
	public static String getEnvVar(String tag) {
		String xmlValue = Retrieve_EnvVar.ReportGlobalParameters(tag);
		return xmlValue;
	}
	*/
	/********************************************************************************************
	* @Function_Name : HandleAlert_Accept_withoutvalidatinMsg
	* @Description : Handles the alerts in the page by clicking on OK button
	* *@param TestCase_Name - Name of the TestCase
	******************************************************************************************/
	public static boolean HandleAlert_Accept_withoutvalidatinMsg(String ElementName, String TestCase_Name) throws Exception {
	int RerunFlag = 0;
	//String ScrPath = "";

	if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
	long stoptime = System.currentTimeMillis()+5000;
	while(System.currentTimeMillis()<stoptime){
	}
	}

	try {

	Alert javascriptAlert = driver.switchTo().alert();
	//String Alertmessage = javascriptAlert.getText();

	javascriptAlert.accept();


	if(RerunFlag>0){
	return false;
	} else{
	return true;
	}


	} catch(UnhandledAlertException alert){
	//UtilLib.CaptureScreenshot(TestCase_Name);
	UtilLib.captureScreen_Alert(TestCase_Name);
	DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
	UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
	return false;
	}

	catch (NoSuchElementException e) {

	UtilLib.CaptureScreenshot(TestCase_Name);

	DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
	UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
	return false;
	}

	catch (NoSuchFrameException e) {
	UtilLib.CaptureScreenshot(TestCase_Name);
	DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
	UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
	return false;
	}

	}




















	/********************************************************************************************
	 * @Function_Name :  FindSysTimeExecution
	 * @Description : Find systime in specified format

	 ***************************************************************************************/
   	public static String FindSysTimeExecution1(){

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat SysDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		return SysDate.format(cal.getTime()).toUpperCase();

		//return SysDate;
	}


	 /********************************************************************************************/
	   public static String RetrieveDataFromField(String ElementName, String Xpath, String TestCase_Name){
	                   int RerunFlag = 0;
	                   String ReturnText = null;

	                   try {

	                                   boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
	                                   if (Verify == true){

	                                                   ReturnText = driver.findElement(By.xpath(Xpath)).getText();

	                                                   if (! (ReturnText.trim().equals("")) ){
	                                                                   UtilLib.Report_PASS(ElementName, "The retrieved value from the field is "+ReturnText+"", "RetrieveDataFromField");
	                                                   } else {
	                                                                   RerunFlag = RerunFlag+1;
	                                                                   UtilLib.Report_FAIL(ElementName, "Data is not present in the field as the retrieved value is - '"+ReturnText+"' ", "RetrieveDataFromField");
	                                                                   UtilLib.CaptureScreenshot(TestCase_Name);
	                                                   }

	                                   } else {
	                                                   RerunFlag = RerunFlag+1;
	                                                   UtilLib.Report_FAIL(ElementName,"is not present in the page", "RetrieveDataFromField");
	                                                   UtilLib.CaptureScreenshot(TestCase_Name);
	                                   }

	                                   if(RerunFlag>0){
	                                                   return "";
	                                   } else {
	                                                   return ReturnText;
	                                   }


	                   } catch (Error e) {

	                                   return "";
	                   }
	   }



	   /********************************************************************************************
		 * @Function_Name :  CompareTextPresent
		 * @Description : Compare the Text present in the page
		 * *@param TestCase_Name - Name of the TestCase
		 *@param ElementName - Name of the Element
		 *@param Xpath - XPATH of the Element
		 *@param FunctionName - Function name in POM_Lib
		 * @throws Exception
		 ********************************************************************************************/


		public static boolean CompareTextPresent(String ElementName,String Xpath, String DataToBeVerified, String TestCase_Name) throws Exception{
			int RerunFlag = 0;
			if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
				long stoptime = System.currentTimeMillis()+5000;
				while(System.currentTimeMillis()<stoptime){
				}
			}
			try {
				boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
				if (Verify  == true){
					boolean Verify_Displayed  = driver.findElement(By.xpath(Xpath)).isDisplayed();
					if (Verify_Displayed  == true){
						String Data = driver.findElement(By.xpath(Xpath)).getText();
						Data = Data.toLowerCase();
						DataToBeVerified = DataToBeVerified.toLowerCase();
						System.out.println("Compare Data = "+Data);
						if (Data.contains(DataToBeVerified))
							UtilLib.Report_PASS(ElementName,"Text entered and Text displayed is matching. Text Entered is '"+DataToBeVerified+"' and Text dispalyed is '"+Data+"'","CompareTextPresent");
						else {
							RerunFlag = RerunFlag+1;
							UtilLib.Report_FAIL(ElementName,"Text '"+Data+"' entered is NOT populated in the page","CompareTextPresent");
						}


					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page","CompareTextPresent");
						UtilLib.CaptureScreenshot(TestCase_Name);


					}
				} else {
					RerunFlag = RerunFlag+1;
					UtilLib.Report_FAIL(ElementName,"is not present in the page ","CompareTextPresent");
					UtilLib.CaptureScreenshot(TestCase_Name);

				}

				if(RerunFlag>0){
					return false;
				} else{
					return true;
				}


			}catch(UnhandledAlertException alert){
				//UtilLib.CaptureScreenshot(TestCase_Name);
				UtilLib.captureScreen_Alert(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
				return false;
			}

			catch (NoSuchElementException e) {

				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
				return false;
			}

			catch (NoSuchFrameException e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
				return false;
			}

			catch (Error e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
				return false;
			}
		}


		public static String uf_C_GetUIData1(String ElementName,String Xpath,String TestCase_Name) throws Exception{
			   int RerunFlag = 0;
			   String UIData = "";

			   try {
			   boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
			   if (Verify  == true){
			   UIData = driver.findElement(By.xpath(Xpath)).getText();
			   /*boolean Verify_Displayed  = driver.findElement(By.xpath(Xpath)).isDisplayed();
			   if (Verify_Displayed  == true){


			   //UtilLib.Report_PASS(ElementName,"is present in the page and the value in UI is : "+UIData,"verifyElementPresent");
			   } else {
			   RerunFlag = RerunFlag+1;
			   UtilLib.Report_FAIL(ElementName,"is not present in the page","verifyElementPresent");
			   UtilLib.CaptureScreenshot(TestCase_Name);
			   }*/
			   } else {
			   RerunFlag = RerunFlag+1;
			   UtilLib.Report_FAIL(ElementName,"is not present in the page ","verifyElementPresent");
			   UtilLib.CaptureScreenshot(TestCase_Name);

			   }

			   if(RerunFlag>0){
			   return null;
			   } else{
			   return UIData;
			   }


			   } catch(UnhandledAlertException alert){
			   //UtilLib.CaptureScreenshot(TestCase_Name);
			   UtilLib.captureScreen_Alert(TestCase_Name);
			   DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			   UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
			   return null;
			   }

			   catch (NoSuchElementException e) {

			   UtilLib.CaptureScreenshot(TestCase_Name);
			   DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			   UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			   return null;
			   }

			   catch (NoSuchFrameException e) {
			   UtilLib.CaptureScreenshot(TestCase_Name);
			   DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			   UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
			   return null;
			   }

			   catch (Error e) {
			   UtilLib.CaptureScreenshot(TestCase_Name);
			   DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
			   UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
			   return null;
			   }
			   }


		/********************************************************************************************
		 * @Function_Name :  verifyLabelPresent
		 * @Description : Verifies the Elements present in the page
		 * *@param TestCase_Name - Name of the TestCase
		 *@param ElementName - Name of the Element
		 *@param Xpath - XPATH of the Element
		 *@param FunctionName - Function name in POM_Lib
		 ********************************************************************************************/


		public static boolean verifyLabelPresent(String ElementName,String Xpath,String TestCase_Name){
			int RerunFlag = 0;
			if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
				long stoptime = System.currentTimeMillis()+5000;
				while(System.currentTimeMillis()<stoptime){
				}
			}
			try {
				boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
				if (Verify  == true){
					String Verify_Displayed  = driver.findElement(By.xpath(Xpath)).getText();
					System.out.println("Label = "+Verify_Displayed);

					//System.out.println("Lable ="+Verify_Displayed);
					if (Verify_Displayed.contains(ElementName)){
						UtilLib.Report_PASS(ElementName,"is present in the page","verifyLabelPresent");


					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page","verifyLabelPresent");
						UtilLib.CaptureScreenshot(TestCase_Name);


					}
				} else {
					RerunFlag = RerunFlag+1;
					UtilLib.Report_FAIL(ElementName,"is not present in the page ","verifyLabelPresent");
					UtilLib.CaptureScreenshot(TestCase_Name);

				}

				if(RerunFlag>0){
					return false;
				} else{
					return true;
				}


			} catch(UnhandledAlertException alert){
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
				return false;
			}

			catch (NoSuchElementException e) {

				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
				return false;
			}

			catch (NoSuchFrameException e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
				return false;
			}

			catch (Error e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
				return false;
			}
		}


		public static boolean verifyAttributeValue(String ElementName, String Xpath, String attributeName, String expectedAttrValue, String TestCase_Name) throws Exception
		{
			int RerunFlag=0;
			if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer"))
			{
				long stoptime = System.currentTimeMillis()+5000;
				while(System.currentTimeMillis()<stoptime){ }
				}
			try {
				boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
				if (Verify == true)
				{
					String attributeValue = driver.findElement(By.xpath(Xpath)).getAttribute(attributeName);
					if (expectedAttrValue.equalsIgnoreCase(attributeValue))
					{
						UtilLib.Report_PASS(ElementName, "is Graded out", "verifyAttributeValue");
						}
					else{
						RerunFlag = RerunFlag+1; UtilLib.Report_FAIL(ElementName, "is not Graded out", "verifyAttributeValue");
						UtilLib.CaptureScreenshot(TestCase_Name);
						}
					}else{
						RerunFlag = RerunFlag+1; UtilLib.Report_FAIL(ElementName, "is not displayed in the page", "verifyAttributeValue");
						UtilLib.CaptureScreenshot(TestCase_Name);
						}
				if(RerunFlag>0)
				{
					return false;
					}
				else
				{
					return true;
					}
				}catch(UnhandledAlertException alert)
				{
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
					}
				catch (NoSuchElementException e)
				{
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
			}
			return false;
		}



		public static String GetAttributeValue(String ElementName, String Xpath, String attributeName, String TestCase_Name) throws Exception
		{
			int RerunFlag=0;
			String attributeValue =null;
			if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer"))
			{
				long stoptime = System.currentTimeMillis()+5000;
				while(System.currentTimeMillis()<stoptime){ }
				}
			try {
				boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
				if (Verify == true)
				{
					 attributeValue = driver.findElement(By.xpath(Xpath)).getAttribute(attributeName);
					 UtilLib.Report_PASS(ElementName,"'"+ElementName+"' is  displayed in the page ","GetAttributeValue");
				}else{
						RerunFlag = RerunFlag+1; UtilLib.Report_FAIL(ElementName, "is not displayed in the page", "UtilLib.verifyAttributeValue");
						UtilLib.CaptureScreenshot(TestCase_Name);
				}
				}catch(UnhandledAlertException alert)
				{
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return null;
					}
				catch (NoSuchElementException e)
				{
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return null;
			}
			return attributeValue;
		}


		 /********************************************************************************************
		  * @Function_Name :  GetElementText
		  * @Description : Get the text of the element
		  * *@param TestCase_Name - Name of the TestCase
		  *@param ElementName - Name of the Element
		  *@param Xpath - XPATH of the Element
		  *@param FunctionName - Function name in POM_Lib
		  * @throws Exception
		  ********************************************************************************************/
		 public static String GetElementText(String ElementName,String Xpath,String TestCase_Name) throws Exception{
			 int RerunFlag = 0;
			 String Data= null;
			 if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
				 long stoptime = System.currentTimeMillis()+5000;
				 while(System.currentTimeMillis()<stoptime){
				 }
			 }
			 try {
				 boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
				 if (Verify  == true){

					 Data = driver.findElement(By.xpath(Xpath)).getText();
					 if (Data.equalsIgnoreCase("")){
						 RerunFlag = RerunFlag+1;
						 UtilLib.Report_FAIL(ElementName,"Text is not available for this element. Text displayed is  '"+Data+"'","GetElementText");
					 } else {
						 UtilLib.Report_PASS(ElementName,"'"+Data+"' is the text available for this element","GetElementText");
					 }

				 } else {
					 RerunFlag = RerunFlag+1;
					 UtilLib.Report_FAIL(ElementName,"is not present in the page ","GetElementText");
					 UtilLib.CaptureScreenshot(TestCase_Name);

				 }
				 if(RerunFlag>0){
					 return "";
				 } else{
					 return Data;
				 }


			 } catch(UnhandledAlertException alert){
				 // UtilLib.CaptureScreenshot(TestCase_Name);
				 UtilLib.captureScreen_Alert(TestCase_Name);
				 DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				 UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
				 return null;
			 }

			 catch (NoSuchElementException e) {

				 UtilLib.CaptureScreenshot(TestCase_Name);
				 DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				 UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
				 return null;
			 }

			 catch (NoSuchFrameException e) {
				 UtilLib.CaptureScreenshot(TestCase_Name);
				 DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				 UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
				 return null;
			 }

			 catch (Error e) {
				 UtilLib.CaptureScreenshot(TestCase_Name);
				 DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				 UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
				 return null;
			 }
		 }


		 /********************************************************************************************
			 * @Function_Name :  ElementIsEnabled
			 * @Description : Verifies if the element is enabled or not
			 * *@param TestCase_Name - Name of the TestCase
			 * * @param DropdownName - Name of the Dropdown
			 * * @param Xpath - Xpath of the dropdown (till select)
			 * * @param VisibleText - Visible text of Option to be selected

			 ********************************************************************************************/


			public static boolean ElementIsEnabled(String ElementName,String Xpath,String TestCase_Name){
				int RerunFlag=0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {
					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify == true){
						boolean Status = driver.findElement(By.xpath(Xpath)).isEnabled();
						if (Status == true) {
							UtilLib.Report_PASS(ElementName,"is enabled","ElementIsEnabled");
						} else {
							UtilLib.Report_FAIL(ElementName,"is not enabled","ElementIsEnabled");
						}
					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page","ElementIsEnabled");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}
					if(RerunFlag>0){
						return false;
					} else{
						return true;
					}
				} catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}
			}


			/********************************************************************************************
			 * @Function_Name :  ElementIsDisabled
			 * @Description : Verifies if the element is Disabled or not
			 * *@param TestCase_Name - Name of the TestCase
			 * * @param DropdownName - Name of the Dropdown
			 * * @param Xpath - Xpath of the dropdown (till select)
			 * * @param VisibleText - Visible text of Option to be selected

			 ********************************************************************************************/


			public static boolean ElementIsDisabled(String ElementName,String Xpath,String TestCase_Name){
				int RerunFlag=0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {
					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify == true){
						boolean Status = driver.findElement(By.xpath(Xpath)).isEnabled();
						if (Status == false){
							UtilLib.Report_PASS(ElementName,"is disabled","ElementIsDisabled");
						} else {
							UtilLib.Report_FAIL(ElementName,"is not disabled","ElementIsDisabled");
							RerunFlag = RerunFlag+1;
						}
					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page","ElementIsDisabled");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}
					if(RerunFlag>0){
						return false;
					} else{
						return true;
					}
				} catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}
			}


			/********************************************************************************************
			 * @Function_Name :  verifyElementPresent
			 * @Description : Verifies the Elements present in the page
			 * *@param TestCase_Name - Name of the TestCase
			 *@param ElementName - Name of the Element
			 *@param Xpath - XPATH of the Element
			 *@param FunctionName - Function name in POM_Lib
			 ********************************************************************************************/


			public static boolean verifyElementPresent(String ElementName,String Xpath,String TestCase_Name){
				int RerunFlag = 0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {
					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify  == true){
						boolean Verify_Displayed  = driver.findElement(By.xpath(Xpath)).isDisplayed();
						if (Verify_Displayed  == true){
							UtilLib.Report_PASS(ElementName,"is present in the page","verifyElementPresent");


						} else {
							RerunFlag = RerunFlag+1;
							UtilLib.Report_FAIL(ElementName,"is not present in the page","verifyElementPresent");
							UtilLib.CaptureScreenshot(TestCase_Name);
						}

					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page ","verifyElementPresent");
						UtilLib.CaptureScreenshot(TestCase_Name);

					}

					if(RerunFlag>0){
						return false;
					} else{
						return true;
					}


				} catch (Error e) {

					return false;
				}
			}




			/********************************************************************************************
			 * @Function_Name :  SelectValueFromDropdown
			 * @Description : Selects the value from the dropdown
			 * *@param TestCase_Name - Name of the TestCase
			 * * @param DropdownName - Name of the Dropdown
			 * * @param Xpath - Xpath of the dropdown (till select)
			 * * @param VisibleText - Visible text of Option to be selected

			 ********************************************************************************************/
			public static boolean SelectValueFromDropdown(String DropdownName,String Xpath,String VisibleText,String TestCase_Name){
				int RerunFlag=0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {
					boolean Verify = driver.findElement(By.xpath(Xpath)).isDisplayed();
					if (Verify == true){
						new Select(driver.findElement(By.xpath(Xpath))).selectByVisibleText(VisibleText);
						UtilLib.Report_PASS(VisibleText,"is selected from the "+DropdownName+" list","SelectValueFromDropdown");
						if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
							long stoptime = System.currentTimeMillis()+5000;
							while(System.currentTimeMillis()<stoptime){
							}
						}
					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(DropdownName,"is not present in the page","verifyLinkPresent");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}
					if(RerunFlag>0){
						return false;
					} else{
						return true;
					}


				} catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					UtilLib.Report_FAIL(VisibleText,"is not available in the "+DropdownName+" list","SelectValueFromDropdown");
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					return false;

				}


			}




			/********************************************************************************************
			 * @Function_Name :  ClickOnElement
			 * @Description : Clicks on a particular 'Element' .
			 * *@param TestCase_Name - Name of the TestCase
			 *@param ElementName - Name of the Element
			 *@param Xpath - XPATH of the Element

			 ********************************************************************************************/

			public static boolean ClickOnElement(String ElementName,String Xpath,String TestCase_Name) throws Exception {
				int RerunFlag=0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}

				try {

					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify == true) {


						driver.findElement(By.xpath(Xpath)).click();
						if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
							long stoptime = System.currentTimeMillis()+5000;
							while(System.currentTimeMillis()<stoptime){
							}
						}

						UtilLib.WaitTime(4000);
						UtilLib.Report_PASS(ElementName, "is succesfully clicked", "ClickOnElement");


					}else{
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName, "is not displayed in the page", "ClickOnElement");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}

					if(RerunFlag>0){
						//DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
						return false;
					}else{
						return true;
					}

				}      catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}
			}



			/********************************************************************************************
			 * @Function_Name :  ClickElementAndVerify
			 * @Description : Clicks on a particular 'Element' and verify the 'VerifyElement' is present or not.
			 * *@param TestCase_Name - Name of the TestCase
			 *@param ElementName - Name of the Element
			 *@param Xpath - XPATH of the Element
			 *@param VerifyElement - Name of the VerifyElement
			 *@param VerifyElementXpath - XPATH of the VerifyElementXpath
			 *@param FunctionName - Function name in POM_Lib
			 *
			 ********************************************************************************************/

			public static boolean ClickElementAndVerify(String ElementName,String Xpath,String VerifyElement,String VerifyElementXpath,String TestCase_Name) throws Exception {
				int RerunFlag=0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {


					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify == true) {
						driver.findElement(By.xpath(Xpath)).click();
						if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
							long stoptime = System.currentTimeMillis()+2000;
							while(System.currentTimeMillis()<stoptime){
							}
						}

						//Wait till element appear on the page
						WebDriverWait wait = new WebDriverWait( driver , 300 );
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VerifyElementXpath)));

						boolean VerifyElementClick = UtilLib.isElementPresent(VerifyElement, By.xpath(VerifyElementXpath));
						if (VerifyElementClick == true) {
							UtilLib.Report_PASS(ElementName, "is succesfully clicked", "ClickElementAndVerify");
							UtilLib.Report_PASS(VerifyElement, "is displaying when clicked on "+ElementName, "ClickElementAndVerify");
						}else{
							RerunFlag = RerunFlag+1;
							UtilLib.Report_FAIL(ElementName, "is not clicked", "ClickElementAndVerify");
							UtilLib.CaptureScreenshot(TestCase_Name);
						}
					}else{
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName, "is not displayed in the page", "ClickElementAndVerify");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}

					if(RerunFlag>0){

						return false;
					}else{
						return true;
					}

				}catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

			}


			/********************************************************************************************
			 * @Function_Name :  EnterDataInTextBox
			 * @Description : Verifies the Elements present in the page
			 * *@param TestCase_Name - Name of the TestCase
			 *@param ElementName - Name of the Element
			 *@param Xpath - XPATH of the Element
			 *@param Data - Data that is to be passed to text field
			 * @throws Exception
			 ********************************************************************************************/
			public static String EnterDataInTextBox(String ElementName,String Xpath,String Data, String TestCase_Name) throws Exception{
				int RerunFlag = 0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {

					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify  == true){
						driver.findElement(By.xpath(Xpath)).clear();
						if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
							long stoptime = System.currentTimeMillis()+2000;
							while(System.currentTimeMillis()<stoptime){
							}
						}
						driver.findElement(By.xpath(Xpath)).sendKeys(Data);
						UtilLib.WaitTime(1000);
						driver.findElement(By.xpath(Xpath)).sendKeys(Keys.TAB);
						UtilLib.Report_PASS(ElementName,"is present in the page. Data entered is "+Data,"EnterDataInTextBox");

					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page ","EnterDataInTextBox");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}
					if(RerunFlag>0){
						return "";
					} else{
						return Data;
					}


				}  catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return null;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return null;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return null;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return null;
				}

			}




			/********************************************************************************************
			 * @Function_Name :  verifyLinkPresent
			 * @Description : Verifies the Link present in the page
			 * *@param TestCase_Name - Name of the TestCase
			 *@param ElementName - Name of the Element
			 *@param Xpath - XPATH of the Element
			 *@param FunctionName - Function name in POM_Lib
			 ********************************************************************************************/


			public static boolean verifyLinkPresent(String ElementName,String Xpath,String TestCase_Name){
				int RerunFlag=0;
				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}
				try {
					boolean Verify = UtilLib.isElementPresent(ElementName, By.xpath(Xpath));
					if (Verify  == true){
						boolean Verify_Displayed  = driver.findElement(By.xpath(Xpath)).isDisplayed();

						if (Verify_Displayed  == true){


							UtilLib.Report_PASS(ElementName,"is present in the page","verifyLinkPresent");
						} else {
							RerunFlag = RerunFlag+1;
							UtilLib.Report_FAIL(ElementName,"is not present in the page","verifyLinkPresent");
							UtilLib.CaptureScreenshot(TestCase_Name);
						}

					} else {
						RerunFlag = RerunFlag+1;
						UtilLib.Report_FAIL(ElementName,"is not present in the page ","verifyLinkPresent");
						UtilLib.CaptureScreenshot(TestCase_Name);
					}
					if(RerunFlag>0){
						return false;
					} else{
						return true;
					}
				}  catch(UnhandledAlertException alert){
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}
			}




			/********************************************************************************************
			 * @Function_Name :  HandleAlert_Accept
			 * @Description : Handles the alerts in the page by clicking on OK button
			 * *@param TestCase_Name - Name of the TestCase
			 *@param ElementName - Name of the Element
			 *@param ErrorMessage - Expected Error Message
			 *@param FunctionName - Function name in POM_Lib
			 * @throws Exception
			 ********************************************************************************************/

/*
			public static boolean HandleAlert_Accept(String ElementName, String ErrorMessage, String TestCase_Name) throws Exception {
				int RerunFlag = 0;
				String ScrPath = "";

				if(getEnvVar("Browser").equalsIgnoreCase("InternetExplorer")){
					long stoptime = System.currentTimeMillis()+5000;
					while(System.currentTimeMillis()<stoptime){
					}
				}

				try {


					Alert javascriptAlert = driver.switchTo().alert();
					String Alertmessage = javascriptAlert.getText();
					//UtilLib.captureScreen_Alert(TestCase_Name);
					System.out.println("Alert message="+Alertmessage);

					Alertmessage = Alertmessage.toLowerCase().trim();
					ErrorMessage = ErrorMessage.toLowerCase().trim();
					System.out.println("Alert lowercase = "+Alertmessage.toLowerCase());
					System.out.println("Expected lowercase = "+ErrorMessage.toLowerCase());

					if (Alertmessage.equals(ErrorMessage)){
						UtilLib.Report_PASS(ElementName, "Error text displayed '"+Alertmessage+"' is matching with the expected Error text '"+ErrorMessage+"' ","HandleAlert");

					} else {
						RerunFlag = RerunFlag + 1;
						UtilLib.Report_FAIL(ElementName, "Error text displayed '"+Alertmessage+"' is NOT matching with the expected Error text '"+ErrorMessage+"' ","HandleAlert");
						//UtilLib.CaptureScreenshot(TestCase_Name);
						ScrPath = UtilLib.captureScreen_Alert(TestCase_Name);

					}
					javascriptAlert.accept();



					if(RerunFlag>0){
						return false;
					} else{
						return true;
					}


				} catch(UnhandledAlertException alert){
					//UtilLib.CaptureScreenshot(TestCase_Name);
					UtilLib.captureScreen_Alert(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
					return false;
				}

				catch (NoSuchElementException e) {

					UtilLib.CaptureScreenshot(TestCase_Name);

					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
					return false;
				}

				catch (NoSuchFrameException e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				catch (Error e) {
					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}
				catch (Exception e) {

					UtilLib.CaptureScreenshot(TestCase_Name);
					DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
					UtilLib.Report_FAIL("Screenshot error", "Kindly re-execute the testcase",TestCase_Name);
					return false;
				}

				}
			*/

			//<Method Name>SelectDropdown</Method Name>
			//<Description>Selects the dropdown value by pressing Down Arrow key, number of times specified as "Option"</Description>
			//<Arguments>Option, elementXPATH</Arguments>
			//<Author>Shwetha Mallikarjunappa</Author>
			//<Version>1.0</Version>
			public static boolean SelectDropdown(int Option,String elementXPATH, String TestCase_Name) throws Exception{

			try {
			//Robot1 rob = new Robot1();
			WaitTime(2000);
			boolean displayed = driver.findElement(By.xpath(elementXPATH)).isDisplayed();
			if (displayed == true) {

			//driver.findElement(By.xpath(elementXPATH)).click();
			driver.findElement(By.xpath(elementXPATH)).sendKeys(Keys.ARROW_DOWN);

			WaitTime(2000);

			for(int i=0;i<Option;i++){
			//driver.findElement(By.xpath("//div[@id='widget_currroleSelect_pn']/div[@class='dijitReset dijitInputField dijitInputContainer']/input[@id='currroleSelect_pn']")).sendKeys(Keys.ARROW_DOWN);
			PressDownKey();
			}
			driver.findElement(By.xpath(elementXPATH)).sendKeys(Keys.TAB);
			//Reporter.log("Element Present." +elementXPATH);
			Report_PASS("Auto Suggest Filed", "is getting selected from the dropdown ", "ClickElement");
			CaptureScreenshot_PASS(TestCase_Name);

			return true;

			} else {
			Reporter.log("Dropdown not selected");
			System.out.println("Dropdown not selected");
			UtilLib.CaptureScreenshot(TestCase_Name);
			return false;
			}

			}catch(UnhandledAlertException alert){
				//UtilLib.CaptureScreenshot(TestCase_Name);
				UtilLib.captureScreen_Alert(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Unexpected & Unhandled Alert", "Unhandled alert window found",TestCase_Name);
				return false;
			}
			catch (NoSuchElementException e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Change in XPATH", "Kindly change the xpath value",TestCase_Name);
				return false;
			}
			catch (NoSuchFrameException e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("NoSuchFrameException", "Expected frame is not present in the UI. This is an intermittent issue. Kindly re-execute the testcase",TestCase_Name);
				return false;
			}

			catch (Error e) {
				UtilLib.CaptureScreenshot(TestCase_Name);
				DefectDetailsDriver.AppendFailedTestXML(TestCase_Name);
				UtilLib.Report_FAIL("Java Error", "Kindly re-execute the testcase",TestCase_Name);
				return false;
			}
			}

			public static void ResultSetForGMWalk(String connurlstg,String unamestg,String pwordstg,String stageQuery, String TestCaseName, String ComponentType, String asOfFiscalQuarterID,String currentQuarterID,String ViewName, String anchorValue) {
				 int VarianceExists;
				 String fileName = new SimpleDateFormat("yyyy-MM-dd_hhmm'.xls'").format(new java.util.Date());
				 System.out.println("fileName : "+fileName);
				 String filePath=(UtilLib.getEnvVar(ComponentType)+TestCaseName+"_"+fileName);
				 System.out.println("filePath : "+filePath);
				 String startTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
				 System.out.println("startTime : "+startTime);

				 try
				   {
					Class.forName("com.teradata.jdbc.TeraDriver");
					Connection conn=DriverManager.getConnection(connurlstg, unamestg, pwordstg);
					System.out.println("Trying to Connect");
					PreparedStatement stmt=conn.prepareStatement(stageQuery);
					System.out.println("Stg Connected");
					stmt.setQueryTimeout(600);
					ResultSet rsstage=stmt.executeQuery();
					System.out.println("Stg query Executed successfully");

								ResultSetMetaData rsmd = rsstage.getMetaData();
								int columnsNumber = rsmd.getColumnCount();

								/* Check if stage returns zero rows*/
					if (!rsstage.isBeforeFirst() ) {
						System.out.println("Stage has 0 records");
							UtilLib.Report_PASS(TestCaseName, "The given query for this testcase returned zero rows", " ");
							UtilLib.LogReport(TestCaseName, "The query: "+newline+newline+"\""+stageQuery+"\""+newline+newline+"for the testcase "+TestCaseName+" returned zero rows");
							UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase returned zero rows", "PASSED",ComponentType," ", "", stageQuery,startTime,ViewName);
								}
					else {

									/*Check if production returns zero rows*/
								XSSFWorkbook stgworkbook = new XSSFWorkbook();
								XSSFSheet stgsheet = stgworkbook.createSheet("Stage");
								UtilLib.ResultSetToExcel(stgworkbook, stgsheet, rsstage);
								System.out.println("Copied to excel");
								FileOutputStream stgout=new FileOutputStream(new File(UtilLib.getEnvVar(ComponentType)+TestCaseName+"_"+fileName));
								stgworkbook.write(stgout);
								stgout.close();

								UtilLib.Report_FAIL(TestCaseName, "The given query for this testcase has returned more than zero rows", " ");
								UtilLib.LogReport(TestCaseName, "The given query for this testcase has returned more than zero rows, query: "+newline+newline+"\""+stageQuery);
								UtilLib.LogExcelReport(TestCaseName, "The given query for this testcase has returned more than zero rows", "FAILED",ComponentType,filePath,"",stageQuery,startTime,ViewName);
								Assert.fail("The given query for this testcase has returned more than zero rows");
											}
								conn.close();
							   }catch (IOException e){
							        e.printStackTrace();
							    }catch (SQLException e) {
							      // if (e.getSQLState().equals("TS000") || e.getSQLState()=="HY000") {
							          /*Check Teradata exception.*/
							         int TeradataCode = e.getErrorCode();  /*Get specific error.*/
							         if (TeradataCode!=0){
							        	 UtilLib.LogExcelReport(TestCaseName, "Query has failed to execute", "FAILED",ComponentType,filePath,"",stageQuery,startTime,ViewName);
									     Assert.fail("Query failed to execute");
							        					         }
							     }
							   catch (ClassNotFoundException e){
								   e.printStackTrace();
							   }
						}
				public static void PlainOfCopyContentsOfExcelForFacts(HSSFWorkbook workbook, HSSFSheet prodsheet,HSSFSheet existstgsheet) throws IOException {

					int rownum = prodsheet.getLastRowNum();
					try {
						Iterator rowIterator = existstgsheet.iterator();

						while (rowIterator.hasNext()) {
							Row row1 = (Row) rowIterator.next();
							Row row = prodsheet.createRow(rownum++);
							int cellnum = 0;
							Iterator CellIterator = row1.cellIterator();
							while (CellIterator.hasNext()) {
								Cell prodcell = (Cell) CellIterator.next();
								org.apache.poi.ss.usermodel.Cell cell = row
										.createCell(cellnum++);
								switch (prodcell.getCellType()) {
								case Cell.CELL_TYPE_BOOLEAN:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getBooleanCellValue());
									break;
								case Cell.CELL_TYPE_NUMERIC:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getNumericCellValue());
									break;
								case Cell.CELL_TYPE_STRING:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									break;
								default:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									break;
								}
							}
						}
						rownum = rownum + 2;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				@SuppressWarnings({ "rawtypes", "unused" })
				public static void UpdateTeradataResultToExcelForFacts(ResultSet rs, int month, HSSFSheet existstgsheet){

					try{
						String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
					ResultSetMetaData resultSetMetaData = rs.getMetaData();
					int numCols = resultSetMetaData.getColumnCount();
					//System.out.println("numCols : "+numCols);

					Iterator<Row> rowIterator = existstgsheet.iterator();
					Row logrow0 = (Row) rowIterator.next();
		  			while (rowIterator.hasNext()){
		  					Row logrow = (Row) rowIterator.next();
		  						Iterator prodCellIterator = logrow.cellIterator();
			 					Cell prodcell1 = (Cell) prodCellIterator.next();
			 					//System.out.println("month : "+month);
			 			        	if((int)(prodcell1.getNumericCellValue())==month){
			 			        	HSSFCell cell,cellDate;
			 			        	int j=1;
			 			        	System.out.println("rs.getInt(1) : "+rs.getInt(j));
			 			        		//while(rs.next()){
			 			        			for (int i=1;i<numCols+1;i++){
			 			        		cell=existstgsheet.getRow(logrow.getRowNum()).getCell(i-j);
			 			        		System.out.println("cell : "+cell);
			 			        		System.out.println("RS :"+rs.getString(i));
			 			        	   int ColType=resultSetMetaData.getColumnType(i);
			 			       // 	   System.out.println("Col Type : "+ColType);
			 					         switch (ColType) {
			 					         case 0: //Null
			 					         case 1: //Char
			 					         case 12: //Varchar
			 					         case 111: //Other
			 						        cell.setCellValue(rs.getString(i));
			 						        break;
			 						     case 2: //Numeric
			 						     case 3: //Decimal
			 						     case 8: //Double
			 						    	 cell.setCellValue(rs.getDouble(i));
			 						    	 break;
			 						     case 4: //Integer
			 						     case 5: //SmallInt
			 						    	 cell.setCellValue(rs.getInt(i));
			 						           break;
			 						     case 6: //Float
			 						     case 7: //REAL
			 						         cell.setCellValue(rs.getFloat(i));
			 						           break;
			 						     case 91: //Date
			 						 	cell.setCellValue(rs.getDate(i));
			 						    	 	break;
			 						     case 92: //Time
			 						  	cell.setCellValue(rs.getTime(i));
			 						    	 	break;
			 						     case 93: //Time-stamp
			 						    	cell.setCellValue(rs.getTimestamp(i));
			 						    	 	break;
			 						     default:
			 						    cell.setCellValue(rs.getString(i));
			 						    	    break;
			 				      		}
			 					        cellDate=(HSSFCell) logrow.createCell(numCols);
			 			        		cellDate.setCellValue(dateStart);
			 			        			}
			 			        		//	j++;
			 			        	}
			 			       	}
		  	//		}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
	}

		//		@SuppressWarnings("unchecked")
				public static void ProdFactsExist(int month,HSSFSheet existprodsheet,ArrayList<Integer> monthNotInList){
					int returnMonth=0;
					Iterator<Row> rowIterator = existprodsheet.iterator();
					Row logrow0 = (Row) rowIterator.next();
							while (rowIterator.hasNext()){
		  					Row logrow = (Row) rowIterator.next();
		  						Iterator prodCellIterator = logrow.cellIterator();
			 					Cell prodcell1 = (Cell) prodCellIterator.next();
			 					//System.out.println("prodcell1 : "+(int)prodcell1.getNumericCellValue());
		 					//	System.out.println("monthList.get(i) : "+month);
			 			        	if(((int)prodcell1.getNumericCellValue())==month){
			 			        		System.out.println("Match at in Method : "+(int)prodcell1.getNumericCellValue());
			 			        		monthNotInList.add(month);//.add(month);//.remove(i);
			 			        		//monthNotInList.remove(monthNotInList.indexOf(month));
			 			        	}
			 					}
				}

				public static ArrayList<Integer> ProdFactsExistTrial(HSSFSheet existprodsheet,ArrayList<Integer> monthNotInList){
					int returnMonth=0;
					Iterator<Row> rowIterator = existprodsheet.iterator();
					Row logrow0 = (Row) rowIterator.next();
							while (rowIterator.hasNext()){
		  					Row logrow = (Row) rowIterator.next();
		  						Iterator prodCellIterator = logrow.cellIterator();
			 					Cell prodcell1 = (Cell) prodCellIterator.next();
			 					monthNotInList.add((int)prodcell1.getNumericCellValue());
			 					}
							return monthNotInList;
				}

				public static void AppenedTeradataResultToExcelForFacts(ResultSet rs, int month, HSSFSheet existprodsheet){
					try{
					//	int currentRow = 0;
					String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
					int rowsNum = existprodsheet.getPhysicalNumberOfRows();
					ResultSetMetaData resultSetMetaData = rs.getMetaData();
					int numCols = resultSetMetaData.getColumnCount();
					HSSFRow row = existprodsheet.createRow(rowsNum);
					System.out.println("rowsNum : "+rowsNum);
			 			        	HSSFCell cell, cellDate;
			 			        	int j=1;
			 			        			for (int i=1;i<numCols+1;i++){
			 			        				cell=row.createCell(j-1);
			 							         int ColType=resultSetMetaData.getColumnType(j);
			 							       //  System.out.println("ColType : "+ColType);
			 							     //    System.out.println("RS: "+rs.getString(i));

			 					         switch (ColType) {
			 					         case 0: //Null
			 					         case 1: //Char
			 					         case 12: //Varchar
			 					         case 111: //Other
			 						        cell.setCellValue(rs.getString(i));
			 						        break;
			 						     case 2: //Numeric
			 						     case 3: //Decimal
			 						     case 8: //Double
			 						    	 cell.setCellValue(rs.getDouble(i));
			 						    	 break;
			 						     case 4: //Integer
			 						     case 5: //SmallInt
			 						    	 cell.setCellValue(rs.getInt(i));
			 						           break;
			 						     case 6: //Float
			 						     case 7: //REAL
			 						         cell.setCellValue(rs.getFloat(i));
			 						           break;
			 						     case 91: //Date
			 						 	cell.setCellValue(rs.getDate(i));
			 						    	 	break;
			 						     case 92: //Time
			 						  	cell.setCellValue(rs.getTime(i));
			 						    	 	break;
			 						     case 93: //Time-stamp
			 						    	cell.setCellValue(rs.getTimestamp(i));
			 						    	 	break;
			 						     default:
			 						    cell.setCellValue(rs.getString(i));
			 						    	    break;
			 				      		}j++;
			 			        			}
			 			        		cellDate=row.createCell(numCols);
			 			        		cellDate.setCellValue(dateStart);
			 			        		//	j++;

		  	//		}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				}

			public static void CopyContentsOfExcel1(HSSFWorkbook workbook, HSSFSheet sheet,HSSFSheet Sourcesheet){
				try{
					int month=201502;
					HSSFFont textFont = workbook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					HSSFCellStyle Existingstyle = workbook.createCellStyle();
					Existingstyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					Existingstyle.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					Existingstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Existingstyle.setFont(textFont);
					int numCols = Sourcesheet.getRow(0).getPhysicalNumberOfCells();
					System.out.println("numCols : "+numCols);
					Iterator<Row> rowIterator = Sourcesheet.iterator();
					Iterator<Row> rowIteratorT = Sourcesheet.iterator();
		//			Row logrow0 = (Row) rowIterator.next();
					int ReqRowNum=0;
					int k=0;
					HSSFCell cell;
		  			while (rowIterator.hasNext()){
		  					Row logrow = (Row) rowIterator.next();
		  						Iterator prodCellIterator = logrow.cellIterator();
			 					Cell prodcell1 = (Cell) prodCellIterator.next();
			 			        	if((int)(prodcell1.getNumericCellValue())==month){
									ReqRowNum=logrow.getRowNum();
									System.out.println("Match found at: "+ReqRowNum);
			 			        			}

		  			while (rowIteratorT.hasNext()){
	  					Row logrow1 = (Row) rowIteratorT.next();
			 			        	for(int m=ReqRowNum;m<3;m++){
			 			        		for (int i=1;i<numCols+1;i++){
			 			        		//	cell=(HSSFCell) logrow1.createCell(k);
		 							       //  System.out.println("ColType : "+ColType);
		 							     //    System.out.println("RS: "+rs.getString(i));
			 			        			while (prodCellIterator.hasNext()) {
			 									Cell prodcell = (Cell) prodCellIterator.next();
			 									org.apache.poi.ss.usermodel.Cell cell2 = logrow
			 											.createCell(numCols++);
			 									switch (prodcell.getCellType()) {
			 									case Cell.CELL_TYPE_BOOLEAN:
			 										((org.apache.poi.ss.usermodel.Cell) cell2)
			 												.setCellValue(prodcell.getBooleanCellValue());
			 										break;
			 									case Cell.CELL_TYPE_NUMERIC:
			 										((org.apache.poi.ss.usermodel.Cell) cell2)
			 												.setCellValue(prodcell.getNumericCellValue());
			 										break;
			 									case Cell.CELL_TYPE_STRING:
			 										((org.apache.poi.ss.usermodel.Cell) cell2)
			 												.setCellValue(prodcell.getStringCellValue());
			 										cell2.setCellStyle(Existingstyle);
			 										break;
			 									default:
			 										((org.apache.poi.ss.usermodel.Cell) cell2)
			 												.setCellValue(prodcell.getStringCellValue());
			 										break;
			 									}

		 			        			}
		 			        		//	j++;

	  	//		}
			 			        			k++;
			 			        	}
			 			       	}


}
}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
}
			}
			//public static void HeaderCopy(HSSFWorkbook wrkbook,HSSFSheet prdsheet,HSSFSheet varincesheet, int rownum, String ResultsFileName) throws IOException{
			public static void HeaderCopy(HSSFWorkbook workbook,HSSFSheet prodsheet,HSSFSheet variancesheet, int rownum) throws IOException{

				//  int rownum = variancesheet.getLastRowNum() + 2;
			//	System.out.println("ResultsFileName : "+ResultsFileName);
		//		  FileInputStream existingProdInput = new FileInputStream(ResultsFileName);
				//	HSSFWorkbook workbook = new HSSFWorkbook(existingProdInput);
			//		HSSFSheet prodsheet = workbook.getSheet("Production Results");
			//		HSSFSheet variancesheet= workbook.getSheet("PeriodID Variance");

				  Iterator rowIterator = prodsheet.iterator();
					 HSSFFont textFont = workbook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					HSSFCellStyle Existingstyle = workbook.createCellStyle();
					Existingstyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					Existingstyle.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					Existingstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Existingstyle.setFont(textFont);
				//	variancesheet.createRow(rownum).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
					rownum++;
					System.out.println("rownum++ : "+rownum);
					if (rowIterator.hasNext()) {
						Row row1 = (Row) rowIterator.next();
						Row row = variancesheet.createRow(rownum++);
						int cellnum = 0;
						Iterator CellIterator = row1.cellIterator();
						while (CellIterator.hasNext()) {
							Cell prodcell = (Cell) CellIterator.next();
							//System.out.println("prodCell : "+prodcell);
							//System.out.println("ProdCell type : "+prodcell.getCellType());
							org.apache.poi.ss.usermodel.Cell cell = row
									.createCell(cellnum++);
							//System.out.println("Cell cretaed");
							switch (prodcell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_STRING:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								cell.setCellStyle(Existingstyle);
								break;
							default:
								((org.apache.poi.ss.usermodel.Cell) cell)
										.setCellValue(prodcell.getStringCellValue());
								break;
							}
						}
					}


			}

			public static void SelectiveDataCopy(HSSFWorkbook workbook,HSSFSheet prodsheet,HSSFSheet variancesheet, int StartingRow, int monthListToCopy, int numberOfRows){
				  try{

						int numCols = prodsheet.getRow(0).getPhysicalNumberOfCells();
						System.out.println("Number of columns are : "+numCols);
						System.out.println("monthListToCopy : "+monthListToCopy);

						 HSSFFont textFont = workbook.createFont();
						 textFont.setFontHeightInPoints((short) 10);
						 textFont.setColor(HSSFColor.WHITE.index);
						 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

						HSSFCellStyle Existingstyle = workbook.createCellStyle();
						Existingstyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
						Existingstyle.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
						Existingstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
						Existingstyle.setFont(textFont);

						Iterator<Row> rowIterator = prodsheet.iterator();
						Row logrow0 = (Row) rowIterator.next();
						Row logrow1 = variancesheet.createRow(StartingRow);
						//Row row = variancesheet.createRow(variancesheet.getLastRowNum()-1);
						while (rowIterator.hasNext()){
							Row logrow = (Row) rowIterator.next();
								Iterator prodCellIterator = logrow.cellIterator();
								Cell prodcell1 = (Cell) prodCellIterator.next();
								//Row row = variancesheet.createRow(variancesheet.getLastRowNum() + 1);
							//	Row row = variancesheet.createRow(StartingRow);
								int cellNum=0;
			 				//	if()
			 			        	if(prodcell1.getNumericCellValue()==monthListToCopy){
			 			        		System.out.println("Match found at: "+logrow.getRowNum());
			 			   			Iterator CellIterator = logrow.cellIterator();
			 						while (CellIterator.hasNext()) {
			 							Cell prodcell = (Cell) CellIterator.next();
			 							//System.out.println("prodCell : "+prodcell);
			 							//System.out.println("ProdCell type : "+prodcell.getCellType());
			 							org.apache.poi.ss.usermodel.Cell cell = logrow1
			 									.createCell(cellNum++);
			 						//	System.out.println("Cell cretaed");
			 							switch (prodcell.getCellType()) {
			 							case Cell.CELL_TYPE_BOOLEAN:
			 								System.out.println("1");
			 								((org.apache.poi.ss.usermodel.Cell) cell)
			 										.setCellValue(prodcell.getBooleanCellValue());
			 								break;
			 							case Cell.CELL_TYPE_NUMERIC:
			 						//		System.out.println("2");
			 								((org.apache.poi.ss.usermodel.Cell) cell)
			 										.setCellValue(prodcell.getNumericCellValue());
			 								break;
			 							case Cell.CELL_TYPE_STRING:
			 							//	System.out.println("3");
			 								((org.apache.poi.ss.usermodel.Cell) cell)
			 										.setCellValue(prodcell.getStringCellValue());
			 								cell.setCellStyle(Existingstyle);
			 								break;
			 							default:
			 								((org.apache.poi.ss.usermodel.Cell) cell)
			 										.setCellValue(prodcell.getStringCellValue());
			 								break;
			 							}
			 						}
			 			        	}
			 			        	}


				  }catch(Exception e){
					  e.printStackTrace();
				  }
			  }

			public static void SnapshotMonths(int numberOfRows, int month){
				  int first=month;
				  int SnapshotNumOfMonths=numberOfRows;

				  ArrayList<Integer> SnapshotMonthListToBeCopied=new <Integer>ArrayList();
				  int temp = Integer.parseInt(String.valueOf(first).substring(4));
				  System.out.println("temop : "+temp);
				 // int i=0;
				  for(int i=0;i<=(SnapshotNumOfMonths-1);i++){
				  if(temp>=01 && temp<=11){
					first=first+1;
					System.out.println("first : "+first);
					SnapshotMonthListToBeCopied.add(first);
					System.out.println("Element added");
				  }
				  else if(temp>11){
					  first=first+89;
					  System.out.println("first in Else : "+first);
					  SnapshotMonthListToBeCopied.add(first);
					  temp = Integer.parseInt(String.valueOf(first).substring(4));
				  }
				  }

			}

			  public static int VarianceForFacts(HSSFWorkbook workbook, HSSFSheet variancesheet,int pRow, int sRow) throws IOException {
					HSSFRow prodRow=variancesheet.getRow(pRow);
					HSSFRow stgRow=variancesheet.getRow(sRow);
					HSSFCell c = prodRow.getCell(0);
					int Lastrow = variancesheet.getRow(1).getPhysicalNumberOfCells();

					HSSFFont textFont = workbook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					HSSFCellStyle style = workbook.createCellStyle();
					 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 style.setFont(textFont);

					 /* Formatting for Values*/
					 HSSFFont ValuesFont = workbook.createFont();
					 ValuesFont.setFontHeightInPoints((short) 10);
					 ValuesFont.setColor(HSSFColor.BLACK.index);
					 ValuesFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					HSSFCellStyle Valuesstyle = workbook.createCellStyle();
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillBackgroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Valuesstyle.setFont(ValuesFont);

					 HSSFCellStyle Valuesmismatchstyle = workbook.createCellStyle();
					 Valuesmismatchstyle.setFillForegroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillBackgroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 Valuesmismatchstyle.setFont(textFont);

					 int VariacneStartingRow = (int)(variancesheet.getLastRowNum()-1);
					 int cellnum=0;
					 int mismatchCount=0;

						Row row = variancesheet.createRow(VariacneStartingRow+2);
					 	Iterator prodrowIterator = variancesheet.iterator();
						Iterator stgrowIterator = variancesheet.iterator();

						if (prodrowIterator.hasNext() && stgrowIterator.hasNext()) {

							Iterator prodCellIterator = prodRow.cellIterator();
							Iterator stgCellIterator = stgRow.cellIterator();

							while (prodCellIterator.hasNext()&& stgCellIterator.hasNext()) {
								Cell prodcell = (Cell) prodCellIterator.next();
								Cell stgcell = (Cell) stgCellIterator.next();

								org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);
								switch (prodcell.getCellType()) {
								case Cell.CELL_TYPE_BOOLEAN:
									if ((prodcell.getBooleanCellValue())==(stgcell.getBooleanCellValue())){
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
									}
									else if((prodcell.getBooleanCellValue())!=(stgcell.getBooleanCellValue())){
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getBooleanCellValue());
										mismatchCount=mismatchCount+1;
									}
									break;
								case Cell.CELL_TYPE_NUMERIC:
									double difference=prodcell.getNumericCellValue()-stgcell.getNumericCellValue();
									if ((prodcell.getNumericCellValue())==(stgcell.getNumericCellValue())){
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
										cell.setCellStyle(Valuesstyle);
											}
									//else if((prodcell.getNumericCellValue())!=(stgcell.getNumericCellValue())){
									else if(difference<Double.parseDouble(UtilLib.getParam("NegativeRange")) || difference>Double.parseDouble(UtilLib.getParam("PositiveRange"))){
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getNumericCellValue())-(stgcell.getNumericCellValue()));
										cell.setCellStyle(Valuesmismatchstyle);
										mismatchCount=mismatchCount+1;
									}

									else  {
										//((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getNumericCellValue()-(stgcell.getNumericCellValue()));
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(0.0);
										cell.setCellStyle(Valuesstyle);
									}
									break;

								case Cell.CELL_TYPE_STRING:
									if ((prodcell.getStringCellValue())==(stgcell.getStringCellValue())){
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(prodcell.getStringCellValue());
										cell.setCellStyle(Valuesstyle);
									}
									else if((prodcell.getStringCellValue())!=(stgcell.getStringCellValue())){
										((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((prodcell.getStringCellValue())+(stgcell.getStringCellValue()));
										cell.setCellStyle(Valuesmismatchstyle);
										//mismatchCount=mismatchCount+1;
									}
									break;
								default:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									break;
								}

							}
							}

						org.apache.poi.ss.usermodel.Cell cell0 = row.createCell(0);
						cell0.setCellValue(stgRow.getCell(0).getNumericCellValue());

						org.apache.poi.ss.usermodel.Cell cell01 = row.createCell(Lastrow-1);
						cell01.setCellValue(stgRow.getCell(Lastrow-1).getStringCellValue());


						return mismatchCount;
				  }

				/********************************************************************************************
				 * @Function_Name :  getParam
				 * @Description : Get the value from the EnvVar.xml

				 ********************************************************************************************/
				public static String getUpdatedParam(String tag) {
					String xmlValue = Retrieve_EnvVar.ReportUpdatedParameters(tag);
					return xmlValue;
				}

				@SuppressWarnings("deprecation")
				public static void GMWalkResultSetToExcel(XSSFWorkbook workbook,XSSFSheet sheet, ResultSet rs, int StartingRow, String Resultfile ){
					try{
						ResultSetMetaData resultSetMetaData = rs.getMetaData();
						//int currentRow = 0;
						XSSFRow row = sheet.createRow(StartingRow);
					//System.out.println("row.getRowNum() in ResultSetToExcel : "+row.getRowNum());
						int numCols = resultSetMetaData.getColumnCount();
						CellStyle style = workbook.createCellStyle();
						style.setFillBackgroundColor(HSSFColor.BLUE.index);

						for (int j = 1; j < numCols+1; j++) {
					        String title = resultSetMetaData.getColumnName(j);
					        org.apache.poi.ss.usermodel.Cell cell =  row.createCell(j-1);
					        cell.setCellValue(title.toString());
					        cell.setCellStyle(style);
								}
						XSSFCell cell;
						int i=StartingRow+1;
						while(rs.next())
					      {  row=sheet.createRow(i);
					         for (int j=1;j<numCols+1;j++){
					         cell=row.createCell(j-1);
					        // System.out.println("cell.getCellNum() : "+cell.getCellNum());
					         int ColType=resultSetMetaData.getColumnType(j);
					         switch (ColType) {
					         case 0: //Null
					         case 1: //Char
					         case 12: //Varchar
					         case 111: //Other
						        cell.setCellValue(rs.getString(j));
						        break;
						     case 2: //Numeric
						     case 3: //Decimal
						     case 8: //Double
						        cell.setCellValue(rs.getDouble(j));
						        break;
						     case 4: //Integer
						     case 5: //SmallInt
						           cell.setCellValue(rs.getInt(j));
						           break;
						     case 6: //Float
						     case 7: //REAL
						           cell.setCellValue(rs.getFloat(j));
						           break;
						     case 91: //Date
						    	 	cell.setCellValue(rs.getDate(j));
						    	 	break;
						     case 92: //Time
						    	 	cell.setCellValue(rs.getTime(j));
						    	 	break;
						     case 93: //Time-stamp
						    	 	cell.setCellValue(rs.getTimestamp(j));
						    	 	break;
						     default:
						    	    cell.setCellValue(rs.getString(j));
						    	    break;
					              }
					     //    i++;
					      } i++;
					      }
						System.out.println("Excel written successfully..");
						FileOutputStream out=new FileOutputStream(Resultfile);
						workbook.write(out);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
			}

				 /********************************************************************************************
				 * @Function_Name :  Copy the worksheet to variance sheet
				 * @Description : Copy the worksheet to variance sheet
			   ********************************************************************************************/

			  @SuppressWarnings("rawtypes")
			public static void PlainOfCopyContentsOfExcel(HSSFWorkbook workbook, HSSFSheet sheet,HSSFSheet Sourcesheet) throws IOException {

					int rownum = sheet.getLastRowNum();
					System.out.println("rownum : "+rownum);
					try {
						Iterator rowIterator = Sourcesheet.iterator();

						while (rowIterator.hasNext()) {
							Row row1 = (Row) rowIterator.next();
							Row row = sheet.createRow(rownum++);
							int cellnum = 0;
							Iterator CellIterator = row1.cellIterator();
							while (CellIterator.hasNext()) {
								Cell prodcell = (Cell) CellIterator.next();
								org.apache.poi.ss.usermodel.Cell cell = row
										.createCell(cellnum++);
								switch (prodcell.getCellType()) {
								case Cell.CELL_TYPE_BOOLEAN:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getBooleanCellValue());
									break;
								case Cell.CELL_TYPE_NUMERIC:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getNumericCellValue());
									break;
								case Cell.CELL_TYPE_STRING:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									break;
								default:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									break;
								}
							}
						}
						rownum = rownum + 2;
					} catch (Exception e) {
						e.printStackTrace();
					}
	}

			  public static void GMWalkTDVarianceCopy(HSSFWorkbook workbook,HSSFSheet variancesheet, HSSFSheet queryResultsheet, int sourceRowNum, int destinationRowNum ){
					try{
						// Get the source / new row
					    HSSFRow newRow = variancesheet.getRow(destinationRowNum);
					    HSSFRow sourceRow = queryResultsheet.getRow(sourceRowNum);

					    // If the row exist in destination, push down all rows by 1 else create a new row
					    if (newRow != null) {
					    	variancesheet.shiftRows(destinationRowNum, variancesheet.getLastRowNum(), 1);
					    } else {
					        newRow = variancesheet.createRow(destinationRowNum);
					    }

					    // Loop through source columns to add to new row
					    for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
					        // Grab a copy of the old/new cell
					        HSSFCell oldCell = sourceRow.getCell(i);
					        HSSFCell newCell = newRow.createCell(i);

					        // Copy style from old cell and apply to new cell
					        HSSFCellStyle newCellStyle = workbook.createCellStyle();
					        newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
					        ;
					        newCell.setCellStyle(newCellStyle);

					        // If there is a cell comment, copy
					        if (oldCell.getCellComment() != null) {
					            newCell.setCellComment(oldCell.getCellComment());
					        }

					        // If there is a cell hyperlink, copy
					        if (oldCell.getHyperlink() != null) {
					            newCell.setHyperlink(oldCell.getHyperlink());
					        }
				 							switch (oldCell.getCellType()) {
				 							case Cell.CELL_TYPE_BOOLEAN:
				 								System.out.println("1");
				 								((org.apache.poi.ss.usermodel.Cell) newCell)
				 										.setCellValue(oldCell.getBooleanCellValue());
				 								break;
				 							case Cell.CELL_TYPE_NUMERIC:
				 						//		System.out.println("2");
				 								((org.apache.poi.ss.usermodel.Cell) newCell)
				 										.setCellValue(oldCell.getNumericCellValue());
				 								break;
				 							case Cell.CELL_TYPE_STRING:
				 							//	System.out.println("3");
				 								((org.apache.poi.ss.usermodel.Cell) newCell)
				 										.setCellValue(oldCell.getStringCellValue());
				 								break;
				 							default:
				 								((org.apache.poi.ss.usermodel.Cell) newCell)
				 										.setCellValue(oldCell.getStringCellValue());
				 								break;
				 							}
				 						}

				}		catch (Exception e)
					{
					e.printStackTrace();
				}

}
				 public static void DeleteSelectedRows(XSSFSheet sheet){
					 XSSFRow Row = null;
					 XSSFCell Cell = null;
				       int LastRowNum = sheet.getLastRowNum();
				       for(int RowNum= 1;RowNum<LastRowNum-1;RowNum++){
				            Row=sheet.getRow(RowNum);
				            for(int CellNum = 0; CellNum<Row.getLastCellNum();CellNum++){
				               Cell = Row.getCell(CellNum);
				               String TextInCell=Cell.toString();
				               if(TextInCell.contains("CURRENT_FISCAL_QUARTER_NUMBER")){
				                  sheet.shiftRows(RowNum+1, LastRowNum, -1);
				                  LastRowNum--;
				                  RowNum--;
				                  break;
				               }
				            }
				        }
				    }

				  @SuppressWarnings("rawtypes")
					public static void GMVariancePnlDataCopy(HSSFWorkbook workbook, HSSFSheet sheet,HSSFSheet Sourcesheet) throws IOException {

							int rownum = 0;
							FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

						//	System.out.println("rownum : "+rownum);
							try {
								Iterator rowIterator = Sourcesheet.iterator();

								while (rowIterator.hasNext()) {
									Row row1 = (Row) rowIterator.next();
									Row row = sheet.createRow(rownum++);
									int cellnum = 9;
									Iterator CellIterator = row1.cellIterator();
									while (CellIterator.hasNext()) {
										Cell prodcell = (Cell) CellIterator.next();
										org.apache.poi.ss.usermodel.Cell cell = row
												.createCell(cellnum++);
										CellValue cellValue = evaluator.evaluate(prodcell);
										switch (evaluator.evaluateFormulaCell(cell)) {
										case Cell.CELL_TYPE_BOOLEAN:
											((org.apache.poi.ss.usermodel.Cell) cell)
													.setCellValue(prodcell.getBooleanCellValue());
											break;
										case Cell.CELL_TYPE_NUMERIC:
											((org.apache.poi.ss.usermodel.Cell) cell)
													.setCellValue(prodcell.getNumericCellValue());
											break;
										case Cell.CELL_TYPE_STRING:
											((org.apache.poi.ss.usermodel.Cell) cell)
													.setCellValue(prodcell.getStringCellValue());
											break;
										default:
											((org.apache.poi.ss.usermodel.Cell) cell)
													.setCellValue(prodcell.getStringCellValue());
											break;
										}
									}
								}
								rownum = rownum + 2;
							} catch (Exception e) {
								e.printStackTrace();
				}
		}


				  public static void HeaderCopy1(XSSFWorkbook workbook,XSSFSheet prodsheet,XSSFSheet variancesheet, int rownum, int cellnum) throws IOException{

					  Iterator rowIterator = prodsheet.iterator();
					  XSSFFont textFont = workbook.createFont();

						 XSSFCellStyle Existingstyle = workbook.createCellStyle();
						Existingstyle.setFont(textFont);
					//	variancesheet.createRow(rownum).createCell(0).setCellValue(prodsheet.getSheetName().toUpperCase());
					//	rownum++;
					//	System.out.println("rownum++ : "+rownum);
						if (rowIterator.hasNext()) {
							Row row1 = (Row) rowIterator.next();
							Row row = variancesheet.getRow(rownum++);
							//int cellnum = 8;
							Iterator CellIterator = row1.cellIterator();
							while (CellIterator.hasNext()) {
								Cell prodcell = (Cell) CellIterator.next();
								//System.out.println("prodCell : "+prodcell);
								//System.out.println("ProdCell type : "+prodcell.getCellType());
								org.apache.poi.ss.usermodel.Cell cell = row
										.createCell(cellnum++);
								//System.out.println("Cell cretaed");
								switch (prodcell.getCellType()) {
								case Cell.CELL_TYPE_BOOLEAN:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getBooleanCellValue());
									break;
								case Cell.CELL_TYPE_NUMERIC:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getNumericCellValue());
									break;
								case Cell.CELL_TYPE_STRING:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									cell.setCellStyle(Existingstyle);
									break;
								default:
									((org.apache.poi.ss.usermodel.Cell) cell)
											.setCellValue(prodcell.getStringCellValue());
									break;
								}
							}
						}


				}
			  public static ArrayList GMWalkMapping(ArrayList list) throws IOException{
				  ArrayList<String> listPnl= new ArrayList<String>();
				  String ListValue;
					  for(int a=0;a<list.size();a++){
						  ListValue=(String) list.get(a);
					//	  System.out.println("Elements are : "+ListValue);

					switch (ListValue){
					/*case "Shipped Revenue (Direct and Disty POS)":
						listPnl.add("Shipped Revenue (Direct and Disty POS)");
						break;*/
					case "Pricing Drivers":
						listPnl.add("Pricing Drivers");
						break;
					case "MUV PPV":
						listPnl.add("PPV COGS-RECLASS+MUV COGS-RECLASS");
						//listPnl.add("MUV COGS-RECLASS");
						break;
					case "PRICE MASKED REBATES":
						listPnl.add("PRICE MASKED REBATES");
						break;
					case "Net Revenue":
						listPnl.add("Net Revenue");
						break;
					case "Net Cost":
						listPnl.add("Net Cost");
						break;
					case "Gross Margin":
						listPnl.add("Net Revenue");
						listPnl.add("Net Cost");
						break;
					case "Overhead":
						listPnl.add("OVERHEAD");
						break;
					case "Variance/OCOGS":
						listPnl.add("Variance/OCOGS");
						break;
					case "Excess and Obsolete":
						listPnl.add("Excess and Obsolete");
						break;
					case "NMS":
						listPnl.add("OVERHEAD");
						listPnl.add("Variance/OCOGS");
						listPnl.add("Excess and Obsolete");
						break;
					case "Direct Warranty":
						listPnl.add("Direct Warranty");
						break;
					case "Royalty":
						listPnl.add("Royalty");
						break;
					case "Legal Cost":
						listPnl.add("Legal Cost");
						break;
/*						case "Acquisition Shipped Revenue":
						listPnl.add("Shipped Revenue (Direct and Disty POS)");
						break;
					case "Shipped Cost (Direct and Disty)":
						listPnl.add("Shipped Cost");
						break;
					case "Acquisition Shipped Cost":
						listPnl.add("Shipped Cost");
						break;	*/
					case "Freight Revenue":
						listPnl.add("Freight Revenue");
						break;
					case "Product Returns":
						listPnl.add("Product Returns");
						break;
					case "Global Central Rev Adj":
						listPnl.add("Global Central Rev Adj");
						break;
					case "AR Reserves":
						listPnl.add("AR Reserves");
						break;
					case "Remarketing CM/DM":
						listPnl.add("Remarketing CM/DM");
						break;
					case "REMARKETING REV COGS":
						listPnl.add("Remarketing revenue other");
						break;
					case "Remarketing Cost":
						listPnl.add("Remarketing Cost");
						break;
					case "Capital Operating Lease Revenue":
						listPnl.add("Capital Operating Lease Revenue");
						break;
					case "Capital":
						listPnl.add("Capital");
						break;
					case "Capital Operating Lease Cost":
						listPnl.add("Capital Operating Lease Cost");
						break;
					case "Capital":
						listPnl.add("Capital");
						break;
					case "Specific Deals Deferral Rev":
						listPnl.add("Specific Deals Deferral Rev");
						break;
					case "Specific Deals Deferral COGS":
						listPnl.add("Specific Deals Deferral COGS");
						break;
					case "OTHER Deferrals":
						listPnl.add("OTHER Deferrals");
						break;
					case "Customer Shipment Term Deferral COGS":
						listPnl.add("Customer Shipment Term Deferral COGS");
						break;
					case "REPLACEMENT 0 - GMB":
						listPnl.add("REPLACEMENT 0 - GMB");
						break;
					case "OTHER GMB ADJS":
						listPnl.add("OTHER GMB ADJS");
						break;
					case "NEWBUYS COGS- ADJ":
						listPnl.add("NEWBUYS COGS- ADJ");
						break;
					case "SOFTWARE FULFILLMENT":
						listPnl.add("SOFTWARE FULFILLMENT");
						break;
					case "R2A COGS":
						listPnl.add("R2A COGS");
						break;
					case "OTHER GMB ADJS MANUAL":
						listPnl.add("OTHER GMB ADJS MANUAL");
						break;
					case "SA STD COST":
						listPnl.add("SA STD COST");
						break;
					case "WEBEX STD COST":
						listPnl.add("WEBEX STD COST");
						break;
					case "HOSTED TG STD COST":
						listPnl.add("HOSTED TG STD COST");
						break;
					case "HCBU STD COST":
						listPnl.add("HCBU STD COST");
						break;
					case "IRONPORT DATACENTER STD COST":
						listPnl.add("IRONPORT DATACENTER STD COST");
						break;
					case "Other Material Cost":
						listPnl.add("Other Material Cost");
						break;
					case "STD COST ADJ_POS_L2":
						listPnl.add("STD COST ADJ_POS_L2");
						break;
					case "STD COST ADJ_POS_L3":
						listPnl.add("STD COST ADJ_POS_L3");
						break;
					case "DEFER COGS ADJ_POS_L2":
						listPnl.add("DEFER COGS ADJ_POS_L2");
						break;
					case "DEFER COGS ADJ_POS_L3":
						listPnl.add("DEFER COGS ADJ_POS_L3");
						break;
					case "Service Revenue":
						listPnl.add("Service Revenue");
						break;
					case "Service COGS":
						listPnl.add("Service COGS");
						break;
					case "Government Certifications":
						listPnl.add("GOVERNMENT CERTIFICATIONS");
						break;
					case "Software Delivery Standard Cost":
						listPnl.add("SOFTWARE DELIVERY STANDARD COST");
						break;
					case "SAAS STD COST":
						listPnl.add("SAAS STD COST");
						break;
					case "NDS STD COST":
						listPnl.add("NDS STD COST");
						break;
						}
					  }
					  return listPnl;
			  }

			  public static ArrayList GMWalkSelectiveDataCopy(XSSFWorkbook resultFileWorkBook,XSSFSheet p, String ele, ArrayList pnlRowNosToCopy){
				  try{
						Iterator rowIterator = p.iterator();
						while (rowIterator.hasNext()){
							Row logrow = (Row) rowIterator.next();
								Iterator prodCellIterator = logrow.cellIterator();
								Cell prodcell1 = (Cell) prodCellIterator.next();
								//System.out.println("prodcell1.getRichStringCellValue() :: "+prodcell1.getRichStringCellValue());
			 			        	if(prodcell1.getRichStringCellValue().toString().equalsIgnoreCase(ele)){
			 			        		System.out.println("Match found at: "+logrow.getRowNum());
			 			        		pnlRowNosToCopy.add(logrow.getRowNum());
			 			        	}
			 			        	}
				  }catch(Exception e){
					  e.printStackTrace();
				  }
				return pnlRowNosToCopy;
			  }

			  public static void Test(HSSFWorkbook workbook,HSSFSheet sheet,String ele){
				  try{
						int column = 0;
						Iterator<Row> rowIterator = sheet.iterator();

						while (rowIterator.hasNext()){
							Row logrow = rowIterator.next();
								Iterator<Cell> prodCellIterator = logrow.cellIterator();
								while(prodCellIterator.hasNext()){
									column++;
									String field1 = prodCellIterator.next().getStringCellValue();
								System.out.println("field1 :: "+field1);
								if(field1.equals(ele)){
		 			        		System.out.println("Match found at: "+logrow.getRowNum());
			 			        	}
			 			        	}
						}
				  }catch(Exception e){
					  e.printStackTrace();
				  }
			      }

			  public static void GMwalkcopyRows(XSSFWorkbook resultFileWorkBook,XSSFSheet p, XSSFSheet variancesheet, int sourceRowNum, int destinationRowNum) {
				  // Get the source / new row
				  Row newRow = variancesheet.getRow(destinationRowNum);
				  Row sourceRow = p.getRow(sourceRowNum);
				  CellStyle style = resultFileWorkBook.createCellStyle();
				  style.setAlignment(CellStyle.ALIGN_LEFT);

				  int j=10;
				  for (int i = 2; i < 5; i++) {
				    Cell oldCell = sourceRow.getCell(i);
				    Cell newCell = newRow.createCell(j);
				    j++;
				    if (oldCell == null) {
				        newCell = null;
				        continue;
				      }
				 					switch (oldCell.getCachedFormulaResultType()) {
									case Cell.CELL_TYPE_BOOLEAN:
										newCell.setCellValue(oldCell.getBooleanCellValue());
										newCell.setCellStyle(style);
										break;
									case Cell.CELL_TYPE_NUMERIC:
										newCell.setCellValue(oldCell.getNumericCellValue());
										newCell.setCellStyle(style);
										break;
									case Cell.CELL_TYPE_STRING:
										newCell.setCellValue(oldCell.getRichStringCellValue());
										newCell.setCellStyle(style);
										break;
							}
				  }
				}

			  public static void GMwalkMeasureCopy(XSSFWorkbook resultFileWorkBook,XSSFSheet p, XSSFSheet variancesheet, int sourceRowNum, int destinationRowNum, int colnum) {
			  Row newRow = variancesheet.getRow(destinationRowNum);
			  Row sourceRow = p.getRow(sourceRowNum);
			  CellStyle style = resultFileWorkBook.createCellStyle();
			  style.setAlignment(CellStyle.ALIGN_LEFT);
			    Cell oldCell = sourceRow.getCell(1);
			 //   System.out.println("oldCell : "+oldCell);
			    Cell newCell = newRow.createCell(colnum);

			    // Set the cell data value
			 		switch (oldCell.getCellType()) {
						case Cell.CELL_TYPE_BLANK:
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							newCell.setCellValue(oldCell.getBooleanCellValue());
							newCell.setCellStyle(style);
							break;
						case Cell.CELL_TYPE_ERROR:
							newCell.setCellErrorValue(oldCell.getErrorCellValue());
							newCell.setCellStyle(style);
							break;
						case Cell.CELL_TYPE_FORMULA:
							newCell.setCellFormula(oldCell.getCellFormula());
							newCell.setCellStyle(style);
							break;
						case Cell.CELL_TYPE_NUMERIC:
							newCell.setCellValue(oldCell.getNumericCellValue());
							newCell.setCellStyle(style);
							break;
						case Cell.CELL_TYPE_STRING:
							newCell.setCellValue(oldCell.getRichStringCellValue());
							newCell.setCellStyle(style);
							break;
					}
			  }

			  public static void GMwalkMeasureCopy1(XSSFWorkbook resultFileWorkBook,XSSFSheet variancesheet,int sourceRowNum, int destinationRowNum, int colnum) {
				  Row newRow = variancesheet.getRow(destinationRowNum);
				  Row sourceRow = variancesheet.getRow(sourceRowNum);
				  CellStyle style = resultFileWorkBook.createCellStyle();
				  style.setAlignment(CellStyle.ALIGN_LEFT);
				    Cell oldCell = sourceRow.getCell(4);
				    System.out.println("oldCell : "+oldCell);
				    Cell newCell = newRow.createCell(colnum);

				    // Set the cell data value
				 		switch (oldCell.getCellType()) {
							case Cell.CELL_TYPE_BLANK:
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								newCell.setCellValue(oldCell.getBooleanCellValue());
								newCell.setCellStyle(style);
								break;
							case Cell.CELL_TYPE_ERROR:
								newCell.setCellErrorValue(oldCell.getErrorCellValue());
								newCell.setCellStyle(style);
								break;
							case Cell.CELL_TYPE_FORMULA:
								newCell.setCellFormula(oldCell.getCellFormula());
								newCell.setCellStyle(style);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								newCell.setCellValue(oldCell.getNumericCellValue());
								newCell.setCellStyle(style);
								break;
							case Cell.CELL_TYPE_STRING:
								newCell.setCellValue(oldCell.getRichStringCellValue());
								newCell.setCellStyle(style);
								break;
						}
				  }

			  public static int VarianceForGMWalk(XSSFWorkbook resultFileWorkBook, XSSFSheet variancesheet, String resultFile) throws IOException {
					XSSFRow prodRow=variancesheet.getRow(1);
					XSSFRow stgRow=variancesheet.getRow(1);
					XSSFCell c = prodRow.getCell(0);
					//int Lastrow = variancesheet.getRow(1).getPhysicalNumberOfCells();
					int rownum=variancesheet.getLastRowNum();
					//System.out.println("rownum : "+rownum);
					int cellnums=variancesheet.getRow(1).getPhysicalNumberOfCells();

					XSSFFont textFont = resultFileWorkBook.createFont();
					 textFont.setFontHeightInPoints((short) 10);
					 textFont.setColor(HSSFColor.WHITE.index);
					 textFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle style = resultFileWorkBook.createCellStyle();
					 style.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
					 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 style.setFont(textFont);

					 /* Formatting for Values*/
					 XSSFFont ValuesFont = resultFileWorkBook.createFont();
					 ValuesFont.setFontHeightInPoints((short) 10);
					 ValuesFont.setColor(HSSFColor.BLACK.index);
					 ValuesFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

					XSSFCellStyle Valuesstyle = resultFileWorkBook.createCellStyle();
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillBackgroundColor(HSSFColor.LIGHT_GREEN.index);
					Valuesstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					Valuesstyle.setFont(ValuesFont);

					 XSSFCellStyle Valuesmismatchstyle = resultFileWorkBook.createCellStyle();
					 Valuesmismatchstyle.setFillForegroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillBackgroundColor(HSSFColor.CORAL.index);
					 Valuesmismatchstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 Valuesmismatchstyle.setFont(textFont);

					 int VariacneStartingRow = (int)(variancesheet.getLastRowNum()-1);
					 int cellnum=15;
					 int mismatchCount=0;

						//Row row = variancesheet.createRow(VariacneStartingRow+2);
				/*		Row row=(Row) variancesheet.getRow(1).createCell(cellnum);
					 	Iterator prodrowIterator = variancesheet.iterator();
						Iterator stgrowIterator = variancesheet.iterator();*/

						for (int i = 1 ; i < rownum+1 ; i++) {
							 int k = 10 ;
							 int l = 15 ;
							Row row = (Row)variancesheet.getRow(i);
						//	System.out.println("i : "+i);
					            for (int j = 5 ; j < 8 ; j++) {
					                Cell cellTD = row.getCell(j);
					                System.out.println("row.getCell(j); "+row.getCell(j));
					                double valueTD = cellTD.getNumericCellValue();
					            //    System.out.println("valueTD : "+j+" "+valueTD);
						                Cell cellPnl = row.getCell(k);
						                double valuePnl = cellPnl.getNumericCellValue();
						          //      System.out.println("valuePnl : "+k+" "+valuePnl);
						                		double valueVar=valueTD-valuePnl;
						              //  		System.out.println("valueVar : "+l+" "+valueVar);
						                		Cell cellVar = row.createCell(l);
						                		cellVar.setCellValue(valueVar);
						                		k++;
						                		l++;
						                		if(valueVar!=0){
						                			mismatchCount++;
						                			cellVar.setCellStyle(Valuesmismatchstyle);
						                		}
						                			else {
						                				cellVar.setCellStyle(Valuesstyle);
						                			}

					            }
					        }
						FileOutputStream out=new FileOutputStream(resultFile);
						resultFileWorkBook.write(out);
						return mismatchCount;
					    }
			  public static void GMWalkLeftAlign(XSSFWorkbook resultFileWorkBook, XSSFSheet variancesheet) throws IOException {
				  Iterator<Row> rowIteratorr = variancesheet.iterator();
					while (rowIteratorr.hasNext()){
				  Row row= rowIteratorr.next();
				  Cell cell= row.getCell(8);
				  Cell cell1= row.getCell(9);
				  Cell cell2= row.getCell(10);
				  variancesheet.autoSizeColumn(9);
				  CellStyle style = resultFileWorkBook.createCellStyle();
				  style.setAlignment(CellStyle.ALIGN_LEFT);
				 // cell.setCellStyle(style);
				 // cell1.setCellStyle(style);
				 // cell2.setCellStyle(style);
					}
			  }

			  public static void removeOtherSheets(String sheetName, HSSFWorkbook book) {
		            for(int i=book.getNumberOfSheets()-1;i>=0;i--){
		                HSSFSheet tmpSheet =book.getSheetAt(i);
		                if(!tmpSheet.getSheetName().equals(sheetName)){
		                    book.removeSheetAt(i);
		                }
		            }
		    }

/* Code added for GM walk POC - 13th Jul */
 public static String getGMWalkQuery(String tag) {
                  System.out.println("tag :"+tag);
                       String xmlValue = Retrieve_EnvVar.ReportGMWalkQuery(tag);
                       return xmlValue;
}



public static void PlainOfCopyContentsOfExcel(XSSFWorkbook workbook, XSSFSheet sheet,XSSFSheet Sourcesheet,String GMDashboardResultsFile) throws IOException {

          //int rownum = sheet.getLastRowNum();
            int rownum =0;
          System.out.println("rownum : "+rownum);
          try {
          Iterator rowIterator = Sourcesheet.iterator();

          while (rowIterator.hasNext()) {
          Row row1 = (Row) rowIterator.next();
          Row row = sheet.createRow(rownum++);
          //Row row = sheet.createRow(rownum);
          int cellnum = 0;
          Iterator CellIterator = row1.cellIterator();
          while (CellIterator.hasNext()) {
          Cell prodcell = (Cell) CellIterator.next();
   org.apache.poi.ss.usermodel.Cell cell = row
          .createCell(cellnum++);
          switch (prodcell.getCellType()) {
          case Cell.CELL_TYPE_BOOLEAN:
          ((org.apache.poi.ss.usermodel.Cell) cell)
          .setCellValue(prodcell.getBooleanCellValue());
          break;
          case Cell.CELL_TYPE_NUMERIC:
          ((org.apache.poi.ss.usermodel.Cell) cell)
          .setCellValue(prodcell.getNumericCellValue());
          break;
          case Cell.CELL_TYPE_STRING:
          ((org.apache.poi.ss.usermodel.Cell) cell)
          .setCellValue(prodcell.getStringCellValue());
          break;
          default:
          ((org.apache.poi.ss.usermodel.Cell) cell)
          .setCellValue(prodcell.getStringCellValue());
          break;
          }
          }
          }
          rownum = rownum + 2;
          } catch (Exception e) {
          e.printStackTrace();
          }


         FileOutputStream out=new FileOutputStream(GMDashboardResultsFile);
         workbook.write(out);


          }

			  /* Code added for GM walk POC - 13th Jul */
}
