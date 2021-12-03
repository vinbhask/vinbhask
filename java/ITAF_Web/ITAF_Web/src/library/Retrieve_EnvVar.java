package library;

import java.io.File;
import java.net.URL;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.explodingpixels.macwidgets.Test;



public class Retrieve_EnvVar {

	public static String ReportGlobalParameters(String TagValue){
		String HTMLGlobalParameters=null;
		try {


			URL url = Test.class.getClassLoader().getResource("EnvVar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("EnvVariables");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return HTMLGlobalParameters;

	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
		}


	public static String ReportCredentialParameters(String TagValue){
		String HTMLGlobalParameters=null;
		try {


			URL url = Test.class.getClassLoader().getResource("EnvVar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Credentials");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return HTMLGlobalParameters;

	}

	public static String ReportParameters(String TagValue){
		String HTMLGlobalParameters=null;
		try {

			//File fXmlFile = new File("C:\\Users\\\\workspace\\SAPBO_Automation\\EnvVar.xml");
			URL url = Test.class.getClassLoader().getResource("EnvVar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Parameters");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return HTMLGlobalParameters;

	}


	public static String ReportGlobalImages(String TagValue){
		String HTMLGlobalParameters=null;
		try {


			URL url = Test.class.getClassLoader().getResource("EnvVar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Images");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return HTMLGlobalParameters;

	}

	public static String ReportCredentials(String TagValue){
		String HTMLGlobalParameters=null;
		try {


			URL url = Test.class.getClassLoader().getResource("EnvVar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Credentials");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return HTMLGlobalParameters;

	}
	public static String ReportGMWalkProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("GM_Walk_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersGMWalkFiscalYearNumber=HTMLGlobalParameters.replaceAll("@GMWalkFiscalYearNumber@", UtilLib.getParam("GMWalkFiscalYearNumber"));
		String HTMLGlobalParametersGMWalkFiscalQuarterNumber=HTMLGlobalParametersGMWalkFiscalYearNumber.replaceAll("@GMWalkFiscalQuarterNumber@", UtilLib.getParam("GMWalkFiscalQuarterNumber"));
		String HTMLGlobalParametersRevenueBOFINANCEBVDB_TS2=HTMLGlobalParametersGMWalkFiscalQuarterNumber.replaceAll("@GMWALKPVWDB_TSDatabase@",UtilLib.getParam("GMWALKPVWDB_TSDatabase"));

		return HTMLGlobalParametersRevenueBOFINANCEBVDB_TS2;

	}

public static String ReportGMWalkStageQuery(String TagValue,String type){
		String HTMLGlobalParameters=null;
		String HTMLGlobalParametersGMWalkAsOfFiscalQuarter = null;
		String htmlGlobalParametersGMWalkAnchorValue = null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("GM_Walk_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(type.equalsIgnoreCase("year")){
			HTMLGlobalParametersGMWalkAsOfFiscalQuarter=HTMLGlobalParameters.replaceAll("@GMWalkAsOFFiscalQuarterNumber@", UtilLib.getUpdatedParam("GMWalkAsOFFiscalQuarterNumber"));
			String HTMLGlobalParametersGMWalkCurrentFiscalYearNumber=HTMLGlobalParametersGMWalkAsOfFiscalQuarter.replaceAll("@GMWalkCurrentFiscalYearNumber@",UtilLib.getUpdatedParam("GMWalkCurrentFiscalYearNumber"));
			htmlGlobalParametersGMWalkAnchorValue = HTMLGlobalParametersGMWalkCurrentFiscalYearNumber.replaceAll("@GMWalkAnchorValue@", UtilLib.getUpdatedParam("GMWalkAnchorValue"));
		}else if(type.equalsIgnoreCase("quarter")){

			HTMLGlobalParametersGMWalkAsOfFiscalQuarter=HTMLGlobalParameters.replaceAll("@GMWalkAsOFFiscalQuarterNumber@", UtilLib.getUpdatedParam("GMWalkAsOFFiscalQuarterNumber"));
			String HTMLGlobalParametersGMWalkFiscalQuarters=HTMLGlobalParametersGMWalkAsOfFiscalQuarter.replaceAll("@GMWalkCurrentFiscalQuarterNumber@",UtilLib.getUpdatedParam("GMWalkCurrentFiscalQuarterNumber"));
			htmlGlobalParametersGMWalkAnchorValue = HTMLGlobalParametersGMWalkFiscalQuarters.replaceAll("@GMWalkAnchorValue@", UtilLib.getUpdatedParam("GMWalkAnchorValue"));
		}
		return htmlGlobalParametersGMWalkAnchorValue;

	}

	public static String ReportRevenueBOProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("RevenueBO_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParameters.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersRevenueBOFINANCEBVDB_TS2=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@FINANCEBVDB_TSDatabase@",UtilLib.getParam("FINANCEBVDB_TSDatabase"));
		String HTMLGlobalParametersRevenueBOPerformance=HTMLGlobalParametersRevenueBOFINANCEBVDB_TS2.replaceAll("@RevenueBOPerform@", UtilLib.getParam("RevenueBOPerform"));
		String HTMLGlobalParametersRevenueBOPerformanceTotal=HTMLGlobalParametersRevenueBOPerformance.replaceAll("@RevenueBOPerformTotal@", UtilLib.getParam("RevenueBOPerformTotal"));
		String HTMLGlobalParametersRevenueBOfinal=HTMLGlobalParametersRevenueBOPerformanceTotal.replaceAll("@RevenueBOINPeriodId@", UtilLib.getUpdatedParam("RevenueBOINPeriodId"));


		return HTMLGlobalParametersRevenueBOfinal;

	}

	public static String ReportRevenueBOProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("RevenueBO_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersRevenueBO2=HTMLGlobalParameters.replaceAll("@RevenueBOPerformTotal@", UtilLib.getParam("RevenueBOPerformTotal"));
		String HTMLGlobalParametersRevenueBO1=HTMLGlobalParametersRevenueBO2.replaceAll("@RevenueBOPerformTotal@", UtilLib.getParam("RevenueBOPerformTotal"));
		String HTMLGlobalParametersRevenueBO=HTMLGlobalParametersRevenueBO1.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		return HTMLGlobalParametersRevenueBO;

	}


	public static String ReportRevenueBOStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("RevenueBO_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParameters.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersRevenueBOFINANCEBVDB_TS2=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@FINANCEBVDB_TSDatabase@",UtilLib.getParam("FINANCEBVDB_TSDatabase"));
		String HTMLGlobalParametersRevenueBOPerformance=HTMLGlobalParametersRevenueBOFINANCEBVDB_TS2.replaceAll("@RevenueBOPerform@", UtilLib.getParam("RevenueBOPerform"));
		String HTMLGlobalParametersRevenueBOPerformanceTotal=HTMLGlobalParametersRevenueBOPerformance.replaceAll("@RevenueBOPerformTotal@", UtilLib.getParam("RevenueBOPerformTotal"));
		String HTMLGlobalParametersRevenueBOfinal=HTMLGlobalParametersRevenueBOPerformanceTotal.replaceAll("@RevenueBOINPeriodId@", UtilLib.getUpdatedParam("RevenueBOINPeriodId"));
		return HTMLGlobalParametersRevenueBOfinal;

	}



	public static String ReportPNLProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("PNL_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParameters.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersRevenueInPeriodId=HTMLGlobalParametersCFABWPeriodId.replaceAll("@FISCALYEARMONTHINT@", UtilLib.getParam("FISCALYEARMONTHINT"));
		String  HTMLGlobalParametersFinal=HTMLGlobalParametersRevenueInPeriodId.replaceAll("@PNLINPeriodId@",UtilLib.getUpdatedParam("PNLINPeriodId"));


		return HTMLGlobalParametersFinal;

	}

	public static String ReportPNLProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("PNL_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParameters.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersFinal=HTMLGlobalParametersCFABWPeriodId.replaceAll("@FISCALYEARMONTHINT@", UtilLib.getParam("FISCALYEARMONTHINT"));

		return HTMLGlobalParametersFinal;

	}


	public static String ReportPNLStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			//URL url = Test.class.getClassLoader().getResource("Queries.xml");
			URL url = Test.class.getClassLoader().getResource("PNL_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@InPeriodId@", UtilLib.getUpdatedParam("InPeriodId"));
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersRevenueInPeriodId=HTMLGlobalParametersCFABWPeriodId.replaceAll("@FISCALYEARMONTHINT@", UtilLib.getParam("FISCALYEARMONTHINT"));
		String  HTMLGlobalParametersFinal=HTMLGlobalParametersRevenueInPeriodId.replaceAll("@PNLINPeriodId@",UtilLib.getUpdatedParam("PNLINPeriodId"));

		return HTMLGlobalParametersFinal;

	}




	public static String ReportCFAProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("CFA_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParameters.replaceAll("@CFABWPeriodId@", UtilLib.getUpdatedParam("CFABWPeriodId"));
		String HTMLGlobalParametersCFAfinal=HTMLGlobalParametersCFABWPeriodId.replaceAll("@CFAINPeriodId@", UtilLib.getUpdatedParam("CFAINPeriodId"));

    	return HTMLGlobalParametersCFAfinal;
			}
	public static String ReportCFAProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("CFA_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersCFAfinal=HTMLGlobalParameters.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));

    	return HTMLGlobalParametersCFAfinal;
			}


	public static String ReportCFAStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("CFA_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParameters.replaceAll("@CFABWPeriodId@", UtilLib.getUpdatedParam("CFABWPeriodId"));
		String HTMLGlobalParametersCFAfinal=HTMLGlobalParametersCFABWPeriodId.replaceAll("@CFAINPeriodId@", UtilLib.getUpdatedParam("CFAINPeriodId"));
    	return HTMLGlobalParametersCFAfinal;
			}



	public static String ReportBookingsCubeProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("BookingsCube_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@InPeriodId@", UtilLib.getUpdatedParam("InPeriodId"));
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersSLSORD= HTMLGlobalParametersCFABWPeriodId.replaceAll("@SLSORDVWDatabase@",UtilLib.getParam("SLSORDVWDatabase"));
		String HTMLGlobalParametersCOMREF= HTMLGlobalParametersSLSORD.replaceAll("@COMREFVWDatabase@",UtilLib.getParam("COMREFVWDatabase"));
		String HTMLGlobalParametersfinal= HTMLGlobalParametersCOMREF.replaceAll("@FISCALYEARMONTHINT@",UtilLib.getParam("FISCALYEARMONTHINT"));
		String HTMLGlobalParametersBookingsCubefinal=HTMLGlobalParametersfinal.replaceAll("@BookingsCubeINPeriodId@", UtilLib.getUpdatedParam("BookingsCubeINPeriodId"));

		return HTMLGlobalParametersBookingsCubefinal;

			}
	public static String ReportBookingsCubeProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("BookingsCube_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParameters.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersSLSORD= HTMLGlobalParametersCFABWPeriodId.replaceAll("@SLSORDVWDatabase@",UtilLib.getParam("SLSORDVWDatabase"));
		String HTMLGlobalParametersCOMREF= HTMLGlobalParametersSLSORD.replaceAll("@COMREFVWDatabase@",UtilLib.getParam("COMREFVWDatabase"));
		String HTMLGlobalParametersWWBPV= HTMLGlobalParametersCOMREF.replaceAll("@WWBPVWDBDatabase@",UtilLib.getParam("WWBPVWDBProdDatabase"));
		String HTMLGlobalParametersfinal= HTMLGlobalParametersWWBPV.replaceAll("@FISCALYEARMONTHINT@",UtilLib.getParam("FISCALYEARMONTHINT"));
		//String HTMLGlobalParametersBookingsCubefinal=HTMLGlobalParametersfinal.replaceAll("@BookingsCubeINPeriodId@", UtilLib.getUpdatedParam("BookingsCubeINPeriodId"));


		return HTMLGlobalParametersfinal;

			}

	public static String ReportBookingsCubeStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("BookingsCube_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@InPeriodId@", UtilLib.getParam("InPeriodId"));
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersSLSORD= HTMLGlobalParametersCFABWPeriodId.replaceAll("@SLSORDVWDatabase@",UtilLib.getParam("SLSORDVW_TSDatabase"));
		String HTMLGlobalParametersCOMREF= HTMLGlobalParametersSLSORD.replaceAll("@COMREFVWDatabase@",UtilLib.getParam("COMREFVW_TSDatabase"));
		String HTMLGlobalParametersWWBPV= HTMLGlobalParametersCOMREF.replaceAll("@WWBPVWDBDatabase@",UtilLib.getParam("WWBPVWDB_TSDatabase"));
		String HTMLGlobalParametersInPeriod= HTMLGlobalParametersWWBPV.replaceAll("@FISCALYEARMONTHINT@",UtilLib.getParam("FISCALYEARMONTHINT"));
		String HTMLGlobalParametersBookingsCubefinal=HTMLGlobalParametersInPeriod.replaceAll("@BookingsCubeINPeriodId@", UtilLib.getUpdatedParam("BookingsCubeINPeriodId"));

		return HTMLGlobalParametersBookingsCubefinal;
			}

	public static String ReportBookingsBOProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("BookingsBO_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@InPeriodId@", UtilLib.getParam("InPeriodId"));
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersSLSORD= HTMLGlobalParametersCFABWPeriodId.replaceAll("@SLSORDVWDatabase@",UtilLib.getParam("SLSORDVWDatabase"));
		String HTMLGlobalParametersCOMREF= HTMLGlobalParametersSLSORD.replaceAll("@COMREFVWDatabase@",UtilLib.getParam("COMREFVWDatabase"));
		String HTMLGlobalParametersInPeriod= HTMLGlobalParametersCOMREF.replaceAll("@FISCALYEARMONTHINT@",UtilLib.getParam("FISCALYEARMONTHINT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersInPeriod.replaceAll("@BookingsBOINPeriodId@",UtilLib.getUpdatedParam("BookingsBOINPeriodId"));

		return HTMLGlobalParametersfinal;
			}
	public static String ReportBookingsBOProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("BookingsBO_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParameters.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersSLSORD= HTMLGlobalParametersCFABWPeriodId.replaceAll("@SLSORDVWDatabase@",UtilLib.getParam("SLSORDVWDatabase"));
		String HTMLGlobalParametersCOMREF= HTMLGlobalParametersSLSORD.replaceAll("@COMREFVWDatabase@",UtilLib.getParam("COMREFVWDatabase"));
		String HTMLGlobalParametersInPeriod= HTMLGlobalParametersCOMREF.replaceAll("@FISCALYEARMONTHINT@",UtilLib.getParam("FISCALYEARMONTHINT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersInPeriod.replaceAll("@BookingsBOINPeriodId@",UtilLib.getUpdatedParam("BookingsBOINPeriodId"));

		return HTMLGlobalParametersfinal;
			}

	public static String ReportBookingsBOStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("BookingsBO_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("in period id is :"+ UtilLib.getParam("BookingsBOINPeriodId"));
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@InPeriodId@", UtilLib.getParam("InPeriodId"));
		String HTMLGlobalParametersRevenueBOBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@RevenueBOBWPeriodId@", UtilLib.getParam("RevenueBOBWPeriodId"));
		String HTMLGlobalParametersRevenueBOTotalQTR=HTMLGlobalParametersRevenueBOBWPeriodID.replaceAll("@TotalQTR@", UtilLib.getParam("TotalQTR"));
		String HTMLGlobalParametersBookingsBOBWPeriodId=HTMLGlobalParametersRevenueBOTotalQTR.replaceAll("@BookingsBOBWPeriodId@", UtilLib.getParam("BookingsBOBWPeriodId"));
		String HTMLGlobalParametersBookingsCubeBWPeriodId=HTMLGlobalParametersBookingsBOBWPeriodId.replaceAll("@BookingsCubeBWPeriodId@", UtilLib.getParam("BookingsCubeBWPeriodId"));
		String HTMLGlobalParametersPNLBWPeriodId=HTMLGlobalParametersBookingsCubeBWPeriodId.replaceAll("@PNLBWPeriodId@", UtilLib.getParam("PNLBWPeriodId"));
		String HTMLGlobalParametersPNLHIERBWPeriodId=HTMLGlobalParametersPNLBWPeriodId.replaceAll("@PNLHIERBWPeriodId@", UtilLib.getParam("PNLHIERBWPeriodId"));
		String HTMLGlobalParametersCFABWPeriodId=HTMLGlobalParametersPNLHIERBWPeriodId.replaceAll("@CFABWPeriodId@", UtilLib.getParam("CFABWPeriodId"));
		String HTMLGlobalParametersSLSORD= HTMLGlobalParametersCFABWPeriodId.replaceAll("@SLSORDVWDatabase@",UtilLib.getParam("SLSORDVW_TSDatabase"));
		String HTMLGlobalParametersCOMREF= HTMLGlobalParametersSLSORD.replaceAll("@COMREFVWDatabase@",UtilLib.getParam("COMREFVW_TSDatabase"));
		String HTMLGlobalParametersWWBPV= HTMLGlobalParametersCOMREF.replaceAll("@WWBPVWDB_TSDatabase@",UtilLib.getParam("WWBPVWDB_TSDatabase"));
		String HTMLGlobalParametersInPeriod= HTMLGlobalParametersWWBPV.replaceAll("@FISCALYEARMONTHINT@",UtilLib.getParam("FISCALYEARMONTHINT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersInPeriod.replaceAll("@BookingsBOINPeriodId@",UtilLib.getUpdatedParam("BookingsBOINPeriodId"));
		return HTMLGlobalParametersfinal;
			}

	public static String ReportFetchCubeProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("FetchCube_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@FetchCubeINPeriodId@", UtilLib.getUpdatedParam("FetchCubeINPeriodId"));
		String HTMLGlobalParametersBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@FetchCubeBWPeriodId@", UtilLib.getUpdatedParam("FetchCubeBWPeriodId"));
		String HTMLGlobalParametersMonthsInt=HTMLGlobalParametersBWPeriodID.replaceAll("@FetchCubeMNTHNUMINT@",UtilLib.getParam("FetchCubeMNTHNUMINT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersMonthsInt.replaceAll("@FETCHPVWDB_Database@",UtilLib.getParam("FETCHPVWDB_ProdDatabase"));

		return HTMLGlobalParametersfinal;
			}

	public static String ReportFetchCubeProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("FetchCube_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersBWPeriodID=HTMLGlobalParameters.replaceAll("@FetchCubeBWPeriodId@", UtilLib.getParam("FetchCubeBWPeriodId"));
		String HTMLGlobalParametersMonthsInt=HTMLGlobalParametersBWPeriodID.replaceAll("@FetchCubeMNTHNUMINT@",UtilLib.getParam("FetchCubeMNTHNUMINT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersMonthsInt.replaceAll("@FETCHPVWDB_Database@",UtilLib.getParam("FETCHPVWDB_ProdDatabase"));

		return HTMLGlobalParametersfinal;
			}

	public static String ReportFetchCubeStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("FetchCube_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@FetchCubeINPeriodId@", UtilLib.getUpdatedParam("FetchCubeINPeriodId"));
		String HTMLGlobalParametersBWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@FetchCubeBWPeriodId@", UtilLib.getParam("FetchCubeBWPeriodId"));
		String HTMLGlobalParametersMonthsInt=HTMLGlobalParametersBWPeriodID.replaceAll("@FetchCubeMNTHNUMINT@",UtilLib.getParam("FetchCubeMNTHNUMINT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersMonthsInt.replaceAll("@FETCHPVWDB_Database@",UtilLib.getParam("FETCHPVWDB_TSDatabase"));

		return HTMLGlobalParametersfinal;
			}


	public static String ReportAEProdQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("AE_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@AEINPeriodID@", UtilLib.getUpdatedParam("AEINPeriodID"));
		String HTMLGlobalParametersAEORABWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@AE_ORACLE_DBBWPeriodID@", UtilLib.getParam("AE_ORACLE_DBBWPeriodID"));
		String HTMLGlobalParametersAEORAPERIODYEAR=HTMLGlobalParametersAEORABWPeriodID.replaceAll("@AE_ORACLE_PERIOD_YEAR@", UtilLib.getParam("AE_ORACLE_PERIOD_YEAR"));
		String HTMLGlobalParametersAEORAFISCALMONTHINT=HTMLGlobalParametersAEORAPERIODYEAR.replaceAll("@AE_ORACLE_FISCAL_MONTH_ID@", UtilLib.getParam("AE_ORACLE_FISCAL_MONTH_ID"));
		String HTMLGlobalParametersAEORAFISCALMONTHINTBW=HTMLGlobalParametersAEORAFISCALMONTHINT.replaceAll("@AE_ORACLE_FISCAL_MONTH_IDBW@", UtilLib.getParam("AE_ORACLE_FISCAL_MONTH_IDBW"));
		String HTMLGlobalParametersBWPeriodID=HTMLGlobalParametersAEORAFISCALMONTHINTBW.replaceAll("@AEBWPeriodID@", UtilLib.getParam("AEBWPeriodID"));
		String HTMLGlobalParametersMonthsInt=HTMLGlobalParametersBWPeriodID.replaceAll("@AESINGLEPERIODID@",UtilLib.getParam("AESINGLEPERIODID"));
		String HTMLGlobalParametersAEPVWDB=HTMLGlobalParametersMonthsInt.replaceAll("@AEPVWDB@",UtilLib.getParam("AEPVWDB_ProdDatabase"));
		String HTMLGlobalParametersFinextpvwdb=HTMLGlobalParametersAEPVWDB.replaceAll("@FINEXTPVWDB@",UtilLib.getParam("FINEXTPVWDB_ProdDatabase"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersFinextpvwdb.replaceAll("@AEORADB.@", "");
		return HTMLGlobalParametersfinal;
			}

	public static String ReportAEProdQuery1(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("AE_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersAEORABWPeriodID=HTMLGlobalParameters.replaceAll("@AE_ORACLE_DBBWPeriodID@", UtilLib.getParam("AE_ORACLE_DBBWPeriodID"));
		String HTMLGlobalParametersAEORAPERIODYEAR=HTMLGlobalParametersAEORABWPeriodID.replaceAll("@AE_ORACLE_PERIOD_YEAR@", UtilLib.getParam("AE_ORACLE_PERIOD_YEAR"));
		String HTMLGlobalParametersAEORAFISCALMONTHINT=HTMLGlobalParametersAEORAPERIODYEAR.replaceAll("@AE_ORACLE_FISCAL_MONTH_ID@", UtilLib.getParam("AE_ORACLE_FISCAL_MONTH_ID"));
		String HTMLGlobalParametersAEORAFISCALMONTHINTBW=HTMLGlobalParametersAEORAFISCALMONTHINT.replaceAll("@AE_ORACLE_FISCAL_MONTH_IDBW@", UtilLib.getParam("AE_ORACLE_FISCAL_MONTH_IDBW"));
		String HTMLGlobalParametersBWPeriodID=HTMLGlobalParametersAEORAFISCALMONTHINTBW.replaceAll("@AEBWPeriodID@", UtilLib.getParam("AEBWPeriodID"));
		String HTMLGlobalParametersMonthsInt=HTMLGlobalParametersBWPeriodID.replaceAll("@AESINGLEPERIODID@",UtilLib.getParam("AESINGLEPERIODID"));
		String HTMLGlobalParametersAEPVWDB=HTMLGlobalParametersMonthsInt.replaceAll("@AEPVWDB@",UtilLib.getParam("AEPVWDB_ProdDatabase"));
		String HTMLGlobalParametersFinextpvwdb=HTMLGlobalParametersAEPVWDB.replaceAll("@FINEXTPVWDB@",UtilLib.getParam("FINEXTPVWDB_ProdDatabase"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersFinextpvwdb.replaceAll("@AEORADB.@", "");
		return HTMLGlobalParametersfinal;
			}

	public static String ReportAEStageQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("AE_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@AEINPeriodID@", UtilLib.getUpdatedParam("AEINPeriodID"));
		String HTMLGlobalParametersAEORABWPeriodID=HTMLGlobalParametersInPeriodID.replaceAll("@AE_ORACLE_DBBWPeriodID@", UtilLib.getParam("AE_ORACLE_DBBWPeriodID"));
		String HTMLGlobalParametersAEORAPERIODYEAR=HTMLGlobalParametersAEORABWPeriodID.replaceAll("@AE_ORACLE_PERIOD_YEAR@", UtilLib.getParam("AE_ORACLE_PERIOD_YEAR"));
		String HTMLGlobalParametersAEORAFISCALMONTHINT=HTMLGlobalParametersAEORAPERIODYEAR.replaceAll("@AE_ORACLE_FISCAL_MONTH_ID@", UtilLib.getParam("AE_ORACLE_FISCAL_MONTH_ID"));
		String HTMLGlobalParametersAEORAFISCALMONTHINTBW=HTMLGlobalParametersAEORAFISCALMONTHINT.replaceAll("@AE_ORACLE_FISCAL_MONTH_IDBW@", UtilLib.getParam("AE_ORACLE_FISCAL_MONTH_IDBW"));
		String HTMLGlobalParametersBWPeriodID=HTMLGlobalParametersAEORAFISCALMONTHINTBW.replaceAll("@AEBWPeriodID@", UtilLib.getParam("AEBWPeriodID"));
		String HTMLGlobalParametersMonthsInt=HTMLGlobalParametersBWPeriodID.replaceAll("@AESINGLEPERIODID@",UtilLib.getParam("AESINGLEPERIODID"));
		String HTMLGlobalParametersAEPVWDB=HTMLGlobalParametersMonthsInt.replaceAll("@AEPVWDB@",UtilLib.getParam("AEPVWDB_TSDatabase"));
		String HTMLGlobalParametersFinextpvwdb=HTMLGlobalParametersAEPVWDB.replaceAll("@FINEXTPVWDB@",UtilLib.getParam("FINEXTPVWDB_TSDatabase"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersFinextpvwdb.replaceAll("@AEORADB.@", "");

		return HTMLGlobalParametersfinal;
			}

	public static String ReportAECLTDQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("AE_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersFinextpvwdb=HTMLGlobalParameters.replaceAll("@FINEXTPVWDB@",UtilLib.getParam("FINEXTPVWDB_TSDatabase"));
		String HTMLGlobalParametersFISCALMNTHINT=HTMLGlobalParametersFinextpvwdb.replaceAll("@AE_CL_FISCAL_YEAR_MTH_NUMBER_INT@", UtilLib.getParam("AE_CL_FISCAL_YEAR_MTH_NUMBER_INT"));
		String HTMLGlobalParametersAEPVWDB=HTMLGlobalParametersFISCALMNTHINT.replaceAll("@AEPVWDB@", UtilLib.getParam("AEPVWDB_TSDatabase"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersAEPVWDB.replaceAll("@AEORADB.@", "");

		return HTMLGlobalParametersfinal;
			}


	public static String ReportAECLORAQuery(String TagValue){
		String HTMLGlobalParameters=null;
		try {
			URL url = Test.class.getClassLoader().getResource("AE_Queries.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url.getPath());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Queries");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String HTMLGlobalParametersFinextpvwdb=HTMLGlobalParameters.replaceAll("@FINEXTPVWDB@",UtilLib.getParam("FINEXTPVWDB_TSDatabase"));
		String HTMLGlobalParametersFISCALMNTHINT=HTMLGlobalParametersFinextpvwdb.replaceAll("@AE_CL_FISCAL_YEAR_MTH_NUMBER_INT@", UtilLib.getParam("AE_CL_FISCAL_YEAR_MTH_NUMBER_INT"));
		String HTMLGlobalParametersfinal=HTMLGlobalParametersFISCALMNTHINT.replaceAll("@AEORADB.@", "");

		return HTMLGlobalParametersfinal;
			}




	public static String RetrieveDefectDetails(String ErrCode, String TagValue){
		String HTMLGlobalParameters=null;
		try {

			File fXmlFile = new File("C:\\Automation\\OneCAT\\src\\Defects.xml");
			//File fXmlFile = new File(".\\EnvVar.xml");
			//System.out.println("Absolute: "+fXmlFile.getAbsolutePath());
			//System.out.println("Canonical: "+fXmlFile.getCanonicalPath());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName(ErrCode);
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//	System.out.println("ReportHeadLine : " + getTagValue("ReportHeadLine", eElement));
					//	System.out.println("ApplicationName : " + getTagValue("ApplicationName", eElement));
					//	System.out.println("Release : " + getTagValue("Release", eElement));
					//HTMLGlobalParameters = getTagValue("UI3", eElement)+";"+getTagValue("UI5", eElement);
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return HTMLGlobalParameters;

	}


	public static String RetrieveQCDetails(String TagValue){
		String HTMLGlobalParameters=null;
		try {

			File fXmlFile = new File("C:\\Automation\\OneCAT\\src\\QCDetails.xml");
			//File fXmlFile = new File(".\\EnvVar.xml");
			//System.out.println("Absolute: "+fXmlFile.getAbsolutePath());
			//System.out.println("Canonical: "+fXmlFile.getCanonicalPath());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("QC_Details");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//	System.out.println("ReportHeadLine : " + getTagValue("ReportHeadLine", eElement));
					//	System.out.println("ApplicationName : " + getTagValue("ApplicationName", eElement));
					//	System.out.println("Release : " + getTagValue("Release", eElement));
					//HTMLGlobalParameters = getTagValue("UI3", eElement)+";"+getTagValue("UI5", eElement);
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return HTMLGlobalParameters;

	}

	public static String ReportUpdatedParameters(String TagValue) {
		String HTMLGlobalParameters = null;
		try {

			File fXmlFile = new File(UtilLib.getEnvVar("ConfigXMLFilePath"));
			//URL url = Test.class.getClassLoader().getResource("EnvVar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Parameters");
			//System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					HTMLGlobalParameters = getTagValue(TagValue, eElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return HTMLGlobalParameters;

	}

	/* Code added for GM walk POC - 13th Jul */
	public static String ReportGMWalkQuery(String TagValue){
        String HTMLGlobalParameters=null;
        try {
        URL url = Test.class.getClassLoader().getResource("GMDashboardQueries.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url.getPath());
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Queries");
        for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;
        HTMLGlobalParameters = getTagValue(TagValue, eElement);
        }
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
        String HTMLGlobalParametersInPeriodID=HTMLGlobalParameters.replaceAll("@GMFiscalQrtNum@", UtilLib.getUpdatedParam("GMFiscalQrtNum"));
        String HTMLGlobalParametersfinal=HTMLGlobalParametersInPeriodID.replaceAll("@GMAsOfFiscalQrtNum@",UtilLib.getUpdatedParam("GMAsOfFiscalQrtNum"));

        return HTMLGlobalParametersfinal;
        }



/* Code added for GM walk POC - 13th Jul */

}
