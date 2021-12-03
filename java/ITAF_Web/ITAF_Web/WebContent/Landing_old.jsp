<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="library.POM_Lib" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Streams</title>
 <link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="CSS/bootstrap-theme.min.css"> 
  
 <link rel="stylesheet" type="text/css" href="CSS/styleSheet.css" />

	
</head>
<body onload="myFunction()">



<div id="set_cstext-title" class="handcursor" style="display:block; padding:0px; margin-bottom:1px; background-color:#274B7D; color:#FFFFFF; 
font-weight: bold; font: italic normal bold normal 50px helvetica, arial, sans-serif;">
<img src="images/logo-cisco.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FPP&A-IT QA Test Automation 
</div>
																
																				<p align="right" style="display:block;font-weight: bold;"> 
																				Welcome &nbsp;
																				<%=session.getAttribute("User")%>&nbsp;&nbsp;&nbsp;&nbsp;
																				<a class="hyperlinkblock4" href="ChangeConfig.jsp" >Change Config</a> |
																				<a class="hyperlinkblock2" href="logout">Logout</a></p>
   <div class="tabbable">
 
    <ul class="tabs">
			<!-- <li><a href="#CFADashBoards">CFA DashBoard Links</a></li> -->
   	    <li><a href="#EnvironmentValidations">Data Validations</a></li>
   	    <li><a href="#CubeValidations">Cube Validations</a></li>
        <li><a href="#CompatibilityValidations">Compatibility Validations</a></li>
        <li><a href="#AESASJOBS">AE SAS Jobs</a></li>
        <li><a href="#GMWalk">GM Walk</a></li>
        <li><a href="#AEEnvironmentValidations">AE Data Validations</a></li>
			<li><a href="#CFAValidations">CFA Validations</a></li>
        
        
    </ul>
   
    <div class="tabcontent">
      
<!---------------------------------------------------- CFA DashBoards ------------------------------------------------------------------------------------>            
			<!--<div id="CFADashBoards" class="tab">
         <br>
      <table class="t_data">
	      <tr>
      	<th colspan="4">By Time</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="https://wwwin-webapps-stage.cisco.com:443/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475&server=FESCFA-APP-STG-004&Project=Cisco%20Financial%20Analyzer&port=0&share=1" target="_blank">ProductBookings</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-01&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=45C9EC4711E52C6E00000080EF85C958" target="_blank">ProductRevenue</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-01&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=8D6713BA11E52C7F00000080EF454A5A" target="_blank">ServiceBookings</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-01&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=7B8634D811E5344E00000080EF35BFEB" target="_blank">ServiceRevenue</a></td>
        </tr>
        </table> 
        
        <br>
        <table class="t_data">
         <tr>
      	<th colspan="4">By DSH</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=7E41CEFF11E537C700000080EF45E1EF" target="_blank">ProductBookings</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=E40786CC11E5376100000080EF25A0ED" target="_blank">ProductRevenue</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=D7B6F4B211E53B4D00000080EF1580ED" target="_blank">ServiceBookings</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">ServiceRevenue</a></td>
        </tr>
        </table>
        
        <br>
        <table class="t_data">
         <tr>
      	<th colspan="4">By SCMS</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=CFFED7D711E539BC00000080EF957FEC" target="_blank">ProductBookings</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=C779C47511E53B3100000080EF651FEC" target="_blank">ProductRevenue</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=3216B44B11E53B4B00000080EF753FEC" target="_blank">ServiceBookings</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">ServiceRevenue</a></td>
        </tr>
        </table>
        
         <br>
        <table class="t_data">
         <tr>
      	<th colspan="4">By eBE</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=98705B6511E53B5B00000080EFA5A1F0" target="_blank">ProductBookings</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=88D9B8F011E53CD500000080EF753FEC" target="_blank">ProductRevenue</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">ServiceBookings</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">ServiceRevenue</a></td>
        </tr>
        </table>
        
          <br>
        <table class="t_data">
         <tr>
      	<th colspan="4">By iBE</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=5A165D9911E53B6300000080EFE521EF" target="_blank">ProductBookings</a></td>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=B117779611E53F2600000080EF750446" target="_blank">ProductRevenue</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">ServiceBookings</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">ServiceRevenue</a></td>
        </tr>
        </table>
        
          <br>
        <table class="t_data">
         <tr>
      	<th colspan="4">By SFH</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="http://wwwin-webapps-stage.cisco.com/MicroStrategy/servlet/mstrWeb?Server=FESFA-APP-STG-02&Project=Cisco+Financial+Analyzer&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=1D09B1FD11E53F4600000080EF45A649" target="_blank">Product Revenue</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">Service Revenue</a></td>
      	</tr>
        </table>
        
         <br>
        <table class="t_data">
         <tr>
      	<th colspan="4">By TG</th>
      	 </tr>
      	 <tr>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">Product Revenue</a></td>
      	<td><a class="hyperlinkblock" href="TBC" target="_blank">Service Revenue</a></td>
      	</tr>
        </table>
         
        </div>
			-->
<!---------------------------------------------------- Environment Validations ---------------------------------------------------------------------------->           
        <div id="EnvironmentValidations" class="tab">	
        
        <p align="right"> 
    	<a class="hyperlinkblock3" href="ReportDownload?fileId=DV" target="_blank">Download Latest Execution report</a></p>
	<!-- <table><tr height="80"><td height="80"></td></tr></table>		 -->																											
<form name="Form" onsubmit ="return validateemailid()"   action="MapNRun"  method="post">

        <p align="right"> 
    	<a class="hyperlinkblock3" href="XmlDownload?fileId=xml" target="_blank">Download Latest XML</a></p>
	<!-- <table><tr height="80"><td height="80"></td></tr></table>		 -->																											

					Load Flag <select name="LoadFlag" class="selectClass">
						<option value="N">N</option>
						<option value="Y">Y</option>
					</select> Snapshot Period ID <input type="text" name="SnapshotPeriodId" class="inputClass"
						size="25" maxlength="100" placeholder="Snapshot Period ID">
					Snapshot Number Of Months <input type="text"
						name="SnapshotNumberOfMonths" size="25" maxlength="100"
						placeholder="Snapshot No.of Months" class="inputClass"> <br> <br> <br>

<table>
<tr>
<td>
</td>
<td>
</td>
<td>
<!--  Bookings BO -->
<a class="hyperlinkblock" id="BookingsBO" href="javascript:ExpandCollapaseBookingsBO();" >Bookings BO</a> 
<div class="container"  id="BookingsBOTestcases" style="display: none"  >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="togglebookingBO_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_001_Cisco_Bookings_Fact"/> TC_001_Cisco_Bookings_Fact<br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_002_Total_Cisco_Bookings_Fact"/> TC_002_Total_Cisco_Bookings_Fact <br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_003_Bookings_Adjustments_Fact" /> TC_003_Bookings_Adjustments_Fact <br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_004_ManualAdjustments_Fact" /> TC_004_ManualAdjustments_Fact <br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_005_Total_Rebates_Fact"/> TC_005_Total_Rebates_Fact<br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_006_Management_Adjustments_Fact"/> TC_006_Management_Adjustments_Fact<br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_007_POS_Adjustments_Fact"/> TC_007_POS_Adjustments_Fact<br />
    <input type="checkbox" name="BookingsBO_fact_TC" value="TC_008_Debookings_Fact"/> TC_008_Debookings_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_012_Allocated_POS_Fact"/> TC_012_Allocated_POS_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_027_Credit_Memo_AND_RMAs_Fact"/> TC_027_Credit_Memo_AND_RMAs_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_028_CA_Service_Reporting_Fact"/> TC_028_CA_Service_Reporting_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_030_Acquisition_Fact"/> TC_030_Acquisition_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_034_Managed_Services_Fact"/> TC_034_Managed_Services_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_035_Acquisition_Non_Cisco_Fact"/> TC_035_Acquisition_Non_Cisco_Factss <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_039_Conditional_Sales_Fact"/> TC_039_Conditional_Sales_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_043_Conditional_Sales_History_Fact"/> TC_043_Conditional_Sales_History_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_047_Not_Booked_Measures_Fact"/> TC_047_Not_Booked_Measures_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_051_Not_Booked_Measures_History_Fact"/> TC_051_Not_Booked_Measures_History_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_055_Shipments_Fact"/> TC_055_Shipments_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_059_POS_Fact"/> TC_059_POS_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_060_Invalid_Claims_Fact"/> TC_060_Invalid_Claims_Fact <br />
	<input type="checkbox" name="BookingsBO_fact_TC" value="TC_061_Claims_Fact"/> TC_061_Claims_Fact <br />
    </td>
    <td>
    <input type="checkbox" onClick="togglebookingBO_Hire(this)" /><b> Toggle All Hirerarchy</b><br/>
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_009_Debookings_BE_Hierarchy"/> TC_009_Debookings_BE_Hierarchy<br />
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_010_Debookings_Products_Hierarchy"/> TC_010_Debookings_Products_Hierarchy<br />
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_011_Debookings_Sales_Hieararchy"/> TC_011_Debookings_Sales_Hieararchy<br />
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_013_CiscoBooks_Product_Hierarchy"/> TC_013_CiscoBooks_Product_Hierarchy<br />
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_014_CiscoBooks_BE_Hierarchy"/> TC_014_CiscoBooks_BE_Hierarchy<br />
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_015_CiscoBooks_Sales_Hierarchy"/> TC_015_CiscoBooks_Sales_Hierarchy<br />  
    <input type="checkbox" name="BookingsBO_hire_TC" value="TC_016_CiscoBooks_Partner_Hierarchy"/> TC_016_CiscoBooks_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_017_CiscoBooks_Sold_To_Customer"/> TC_017_CiscoBooks_Sold_To_Customer <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_018_CiscoBooks_Ship_To_Customer"/> TC_018_CiscoBooks_Ship_To_Customer <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_019_CiscoBooks_BillToCust_Hierarchy"/> TC_019_CiscoBooks_BillToCust_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_020_CiscoBooks_EndCust_Hierarchy"/> TC_020_CiscoBooks_EndCust_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_021_CiscoBooks_OrderInfo_Hierarchy"/> TC_021_CiscoBooks_OrderInfo_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_022_CiscoBooks_TMSCorp_Hierarchy"/> TC_022_CiscoBooks_TMSCorp_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_023_CiscoBooks_TMSSales_Hierarchy"/> TC_023_CiscoBooks_TMSSales_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_024_CiscoBooks_SW_Hierarchy"/> TC_024_CiscoBooks_SW_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_025_CiscoBooks_SW_Cogs_Hierarchy"/> TC_025_CiscoBooks_SW_Cogs_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_026_CiscoBooks_SW_NonCogs_Hierarchy"/> TC_026_CiscoBooks_SW_NonCogs_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_031_UpliftBookings_BE_Hieararchy"/> TC_031_UpliftBookings_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_032_UpliftBookings_Products_Hieararchy"/> TC_032_UpliftBookings_Products_Hieararchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_033_UpliftBookings_Sales_Hieararchy"/> TC_033_UpliftBookings_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_036_Acquisition_Non_Cisco_BE_Hierarchy"/> TC_036_Acquisition_Non_Cisco_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_037_Acquisition_Non_Cisco_Products_Hierarchy"/> TC_037_Acquisition_Non_Cisco_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_038_Acquisition_Non_Cisco_Sales_Hierarchy"/> TC_038_Acquisition_Non_Cisco_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_040_Conditional_Sales_BE_Hierarchy"/> TC_040_Conditional_Sales_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_041_Conditional_Sales_Products_Hierarchy"/> TC_041_Conditional_Sales_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_042_Conditional_Sales_Sales_Hierarchy"/> TC_042_Conditional_Sales_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_044_Conditional_Sales_History_BE_Hierarchy"/> TC_044_Conditional_Sales_History_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_045_Conditional_Sales_History_Products_Hierarchy"/> TC_045_Conditional_Sales_History_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_046_Conditional_Sales_History_Sales_Hierarchy"/> TC_046_Conditional_Sales_History_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_048_Not_Booked_Measures_BE_Hierarchy"/> TC_048_Not_Booked_Measures_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_049_Not_Booked_Measures_Products_Hierarchy"/> TC_049_Not_Booked_Measures_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_050_Not_Booked_Measures_Sales_Hierarchy"/> TC_050_Not_Booked_Measures_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_052_Not_Booked_Measures_History_BE_Hierarchy"/> TC_052_Not_Booked_Measures_History_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_053_Not_Booked_Measures_History_Products_Hierarchy"/> TC_053_Not_Booked_Measures_History_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_054_Not_Booked_Measures_History_Sales_Hierarchy"/> TC_054_Not_Booked_Measures_History_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_056_Shipments_BE_Hierarchy"/> TC_056_Shipments_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_057_Shipments_Products_Hierarchy"/> TC_057_Shipments_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsBO_hire_TC" value="TC_058_Shipments_Sales_Hierarchy"/> TC_058_Shipments_Sales_Hierarchy <br />      
    </td>
    <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="BookingsBOPeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div> <br>
	<table>
	<tr></tr>
	</table>

<!--  Bookings Cube -->
<a class="hyperlinkblock" id="BookingsCube" href="javascript:ExpandCollapaseBookingsCube();">Bookings Cube</a> 
<div  class="container"  id="BookingsCubeTestcases" style="display: none" >
<table>
	<tr>
	<!-- Bookings Cube Fact -->
	<td>
	<input type="checkbox" onClick="toggleBookingCube_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_001_LegalBookCorpProduct_Fact"/> TC_001_LegalBookCorpProduct_Fact<br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_010_AdjustBookCorpProduct_Fact"/> TC_010_AdjustBookCorpProduct_Fact<br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_019_AcquisBookCorpProduct_Fact"/> TC_019_AcquisBookCorpProduct_Fact<br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_026_LegalBooksCAService_Fact"/> TC_026_LegalBooksCAService_Fact<br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_029_AdjustBooksCAService_Fact"/> TC_029_AdjustBooksCAService_Fact<br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_032_AcquisBooksCAService_Fact"/> TC_032_AcquisBooksCAService_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_035_DeBooksCAService_Fact"/> TC_035_DeBooksCAService_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_042_CondSales_Corp_Product_Fact"/> TC_042_CondSales_Corp_Product_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_046_CondSalesProducts_Corp_Product_Fact"/> TC_046_CondSalesProducts_Corp_Product_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_050_CondSalesServices_Corp_Product_Fact"/> TC_050_CondSalesServices_Corp_Product_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_051_Conditional_Sales_CA_Service_Fact"/> TC_051_Conditional_Sales_CA_Service_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_052_Debooks_Corp_Product_Fact"/> TC_052_Debooks_Corp_Product_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_061_NBMCorpProduct_Fact"/> TC_061_NBMCorpProduct_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_072_NBMCAServices_Fact"/> TC_072_NBMCAServices_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_073_BacklogsCorpProduct_Fact"/> TC_073_BacklogsCorpProduct_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_080_BacklogsCAService_Fact"/> TC_080_BacklogsCAService_Fact <br />
	<input type="checkbox" name="BookingsCube_fact_TC" value="TC_081_Uplift_Bookings_Corp_Product_Fact"/> TC_081_Uplift_Bookings_Corp_Product_Fact <br />
   </td>
	 <!-- Bookings Cube Hierarchy -->
    <td>
    <input type="checkbox" onClick="toggleBookingCube_Hire(this)" /><b> Toggle All Hirerarchy</b><br/>
    <input type="checkbox" name="BookingsCube_hire_TC" value="TC_002_LegalBooksProd_Product_Hierarchy"/> TC_002_LegalBooksProd_Product_Hierarchy <br />
    <input type="checkbox" name="BookingsCube_hire_TC" value="TC_003_LegalBooksProd_SalesOrderLine_Hierarchy" /> TC_003_LegalBooksProd_SalesOrderLine_Hierarchy <br />
    <input type="checkbox" name="BookingsCube_hire_TC" value="TC_004_LegalBooksProd_BE_Hierarchy" /> TC_004_LegalBooksProd_BE_Hierarchy <br />
    <input type="checkbox" name="BookingsCube_hire_TC" value="TC_005_LegalBooksProd_Sales_Hierarchy_Hierarchy"/> TC_005_LegalBooksProd_Sales_Hierarchy_Hierarchy<br />
    <input type="checkbox" name="BookingsCube_hire_TC" value="TC_006_LegalBooksServices_Product_Hierarchy"/> TC_006_LegalBooksServices_Product_Hierarchy<br />
    <input type="checkbox" name="BookingsCube_hire_TC" value="TC_007_LegalBooksServices_SalesOrderLine_Hierarchy"/> TC_007_LegalBooksServices_SalesOrderLine_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_008_LegalBooksServices_BE_Hierarchy"/> TC_008_LegalBooksServices_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_009_LegalBooksServices_Sales_Hierarchy_Hierarchy"/> TC_009_LegalBooksServices_Sales_Hierarchy_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_011_AdjustBookCorpProduct_Product_Hierarchy"/> TC_011_AdjustBookCorpProduct_Product_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_012_AdjustBookCorpProduct_SalesOrderLine_Hierarchy"/> TC_012_AdjustBookCorpProduct_SalesOrderLine_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_013_AdjustBookCorpProduct_BE_Hierarchy"/> TC_013_AdjustBookCorpProduct_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_014_AdjustBookCorpProduct_Sales_Hierarchy"/> TC_014_AdjustBookCorpProduct_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_015_AdjustBookCorpServices_Product_Hierarchy"/> TC_015_AdjustBookCorpServices_Product_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_016_AdjustBookCorpServices_SalesOrderLine_Hierarchy"/> TC_016_AdjustBookCorpServices_SalesOrderLine_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_017_AdjustBookCorpServices_BE_Hierarchy"/> TC_017_AdjustBookCorpServices_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_018_AdjustBookCorpServices_Sales_Hierarchy"/> TC_018_AdjustBookCorpServices_Sales_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_020_AcquisBookCorpProduct_Product_Hierarchy"/> TC_020_AcquisBookCorpProduct_Product_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_021_AcquisBookCorpProduct_SalesOrderLine_Hierarchy"/> TC_021_AcquisBookCorpProduct_SalesOrderLine_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_022_AcquisBookCorpProduct_BE_Hierarchy"/> TC_022_AcquisBookCorpProduct_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_023_AcquisBookCorpProduct_Product_Hierarchy"/> TC_023_AcquisBookCorpProduct_Product_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_024_AcquisBookCorpProduct_SalesOrderLine_Hierarchy"/> TC_024_AcquisBookCorpProduct_SalesOrderLine_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_025_AcquisBookCorpProduct_BE_Hierarchy"/> TC_025_AcquisBookCorpProduct_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_027_LegalBooksServices_Partner_Hierarchy"/> TC_027_LegalBooksServices_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_028_LegalBooksProduct_Partner_Hierarchy"/> TC_028_LegalBooksProduct_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_030_AdjustBooksProducts_Partner_Hierararchy"/> TC_030_AdjustBooksProducts_Partner_Hierararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_031_AdjustBooksServices_Partner_Hierararchy"/> TC_031_AdjustBooksServices_Partner_Hierararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_033_AcquisBooksProducts_Partner_Hierarchy"/> TC_033_AcquisBooksProducts_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_034_AcquisBooksServices_Partner_Hierarchy"/> TC_034_AcquisBooksServices_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_036_DeBooksProducts_Partner_Hierarchy"/> TC_036_DeBooksProducts_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_037_DeBooksServices_Partner_Hierarchy"/> TC_037_DeBooksServices_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_038_Bookings_Service_Finance_Hieararchy"/> TC_038_Bookings_Service_Finance_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_039_Bookings_Software_Hieararchy"/> TC_039_Bookings_Software_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_040_Bookings_SWCOGS_Hieararchy"/> TC_040_Bookings_SWCOGS_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_041_Bookings_SWNonCOGS_Hieararchy"/> TC_041_Bookings_SWNonCOGS_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_043_CondSalesProducts_Products_Hieararchy"/> TC_043_CondSalesProducts_Products_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_044_CondSalesProducts_Sales_Order_Line_Hieararchy"/> TC_044_CondSalesProducts_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_045_CondSalesProducts_Sales_Hieararchy"/> TC_045_CondSalesProducts_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_047_CondSalesServices_Products_Hieararchy"/> TC_047_CondSalesServices_Products_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_048_CondSalesServices_Sales_Order_Line_Hieararchy"/> TC_048_CondSalesServices_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_049_CondSalesServices_Sales_Hieararchy"/> TC_049_CondSalesServices_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_053_Debooks_Products_Hierarchy"/> TC_053_Debooks_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_054_Debooks_Services_Hieararchy"/> TC_054_Debooks_Services_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_055_Debooks_Products_Sales_Order_Line_Hieararchy"/> TC_055_Debooks_Products_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_056_Debooks_Services_Sales_Order_Line_Hieararchy"/> TC_056_Debooks_Services_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_057_Debooks_Corp_Product_BE_Hierarchy"/> TC_057_Debooks_Corp_Product_BE_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_058_Debooks_Services_BE_Hieararchy"/> TC_058_Debooks_Services_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_059_Debooks_Corp_Product_Sales_Hieararchy"/> TC_059_Debooks_Corp_Product_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_060_Debooks_Services_Sales_Hieararchy"/> TC_060_Debooks_Services_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_062_NBMCorpProduct_Partner_Hierarchy"/> TC_062_NBMCorpProduct_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_063_NBMCorpProduct_Products_Hierarchy"/> TC_063_NBMCorpProduct_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_064_NBMCorpProduct_Sales_Order_Line_Hierarchy"/> TC_064_NBMCorpProduct_Sales_Order_Line_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_065_NBMCorpProduct_BE_Hieararchy"/> TC_065_NBMCorpProduct_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_066_NBMCorpProduct_Sales_Hieararchy"/> TC_066_NBMCorpProduct_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_067_NBMCorpServices_Partner_Hierarchy"/> TC_067_NBMCorpServices_Partner_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_068_NBMCorpServices_Products_Hierarchy"/> TC_068_NBMCorpServices_Products_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_069_NBMCorpServices_Sales_Order_Line_Hierarchy"/> TC_069_NBMCorpServices_Sales_Order_Line_Hierarchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_070_NBMCorpServices_BE_Hieararchy"/> TC_070_NBMCorpServices_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_071_NBMCorpServices_Sales_Hieararchy"/> TC_071_NBMCorpServices_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_074_BacklogsCorpProduct_Products_Hieararchy"/> TC_074_BacklogsCorpProduct_Products_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_075_BacklogsCorpProduct_Sales_Hieararchy"/> TC_075_BacklogsCorpProduct_Sales_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_076_BacklogsCorpProduct_BE_Hieararchy"/> TC_076_BacklogsCorpProduct_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_077_BacklogsCoprServices_BE_Hieararchy"/> TC_077_BacklogsCoprServices_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_078_BacklogsCoprServices_BE_Hieararchy"/> TC_078_BacklogsCoprServices_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_079_BacklogsCoprServices_BE_Hieararchy"/> TC_079_BacklogsCoprServices_BE_Hieararchy <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_082_SOLKeys_BK_ALLOCATED_SERVC_GROUP_ID_UNKNOWN"/> TC_082_SOLKeys_BK_ALLOCATED_SERVC_GROUP_ID_UNKNOWN <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_083_SOLKeys_NULL_values_in_PV_CDNLSLS_MSR_TMS_SLS_ALC_TV"/> TC_083_SOLKeys_NULL_values_in_PV_CDNLSLS_MSR_TMS_SLS_ALC_TV <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_084_ATTRIBUTION_CD_Mismatch_between_MT_RSTD_BKGS_MEASURE_and_PV_SVC_FINANCE_HIERARCHY_DYN"/> TC_084_ATTRIBUTION_CD_Mismatch_between_MT_RSTD_BKGS_MEASURE_and_PV_SVC_FINANCE_HIERARCHY_DYN <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_085_Missing_ItemKeys_between_R_PRODUCTS_FIN_and_R_TECH_MKT_SEGMENT"/> TC_085_Missing_ItemKeys_between_R_PRODUCTS_FIN_and_R_TECH_MKT_SEGMENT <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_086_Product_Subgroup_Id_mismatch_LegalBookings"/> TC_086_Product_Subgroup_Id_mismatch_LegalBookings <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_087_Product_Subgroup_Id_mismatch_NBM"/> TC_087_Product_Subgroup_Id_mismatch_NBM <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_088_Product_Subgroup_Id_mismatch_CondSales"/> TC_088_Product_Subgroup_Id_mismatch_CondSales <br />
	<input type="checkbox" name="BookingsCube_hire_TC" value="TC_089_Missing_Bookings_Measure_Keys"/> TC_089_Missing_Bookings_Measure_Keys <br />
	    
     </td>
       <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="BookingsCubePeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>


<!--  CFA -->
<a class="hyperlinkblock" id="CFA" href="javascript:ExpandCollapaseCFA();">CFA</a> 
<div  class="container"  id="CFATestcases" style="display: none" >

	<table>
	<tr>
	<!-- CFA Fact -->
	<td>
	<input type="checkbox" onClick="toggleCFA_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="CFA_fact_TC" value="TC_001_CiscoProdRevandCogs_Fact"/> TC_001_CiscoProdRevandCogs_Fact<br />
	<input type="checkbox" name="CFA_fact_TC" value="TC_009_CiscoProdRevandCogs_Fact"/> TC_009_CiscoProdRevandCogs_Fact<br />
	<input type="checkbox" name="CFA_fact_TC" value="TC_021_CiscoProdRevandCogs_Fact"/> TC_021_CiscoProdRevandCogs_Fact<br />
	<input type="checkbox" name="CFA_fact_TC" value="TC_034_Cisco_Service_Revenue_Fact"/> TC_034_Cisco_Service_Revenue_Fact<br />
	<input type="checkbox" name="CFA_fact_TC" value="TC_046_ASCogs_Fact"/> TC_046_ASCogs_Fact<br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_050_TS_Cogs_TAC_Fact"/> TC_050_TS_Cogs_TAC_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_053_TS_Cogs_SAC_Fact"/> TC_053_TS_Cogs_SAC_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_056_Opex_Fact"/> TC_056_Opex_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_060_Bookings_Fact"/> TC_060_Bookings_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_072_Bookings_Fact"/> TC_072_Bookings_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_081_Bookings_Fact"/> TC_081_Bookings_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_098_Shipment_Fact"/> TC_098_Shipment_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_105_ServRevTriang_Fact"/> TC_105_ServRevTriang_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_116_RevProfitability_Fact"/> TC_116_RevProfitability_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_146_Bookings_SW_Annuity_Grossmargin_Fact"/> TC_146_Bookings_SW_Annuity_Grossmargin_Fact <br />
	<input type="checkbox" name="CFA_fact_TC"  value="TC_152_Bookings_SW_Grossmargin_Fact"/> TC_152_Bookings_SW_Grossmargin_Fact <br />
	
		
	
	 </td>
	 <!-- CFA Hierarchy -->
    <td>
    <input type="checkbox" onClick="toggleCFA_Hire(this)" /><b> Toggle All Hierarchy</b><br/>
    <input type="checkbox" name="CFA_hire_TC" value="TC_002_CiscoProdRevandCogs_Product_Hieararchy"/> TC_002_CiscoProdRevandCogs_Product_Hieararchy <br />
    <input type="checkbox" name="CFA_hire_TC" value="TC_003_CiscoProdRevandCogs_Sales_Hierararchy" /> TC_003_CiscoProdRevandCogs_Sales_Hierararchy <br />
    <input type="checkbox" name="CFA_hire_TC" value="TC_004_CiscoProdRevandCogs_Fin_Sales_Theater_Hieararchy" /> TC_004_CiscoProdRevandCogs_Fin_Sales_Theater_Hieararchy <br />
    <input type="checkbox" name="CFA_hire_TC" value="TC_005_CiscoProdRevandCogs_Ext_BE_Hieararchy"/> TC_005_CiscoProdRevandCogs_Ext_BE_Hieararchy<br />
    <input type="checkbox" name="CFA_hire_TC" value="TC_006_CiscoProdRevandCogs_Int_BE_Hieararchy"/> TC_006_CiscoProdRevandCogs_Int_BE_Hieararchy<br />
    <input type="checkbox" name="CFA_hire_TC" value="TC_007_CiscoProdRevandCogs_TMS_Corp_Alloc_Hieararchy"/> TC_007_CiscoProdRevandCogs_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_008_CiscoProdRevandCogs_TMS_Sales_Alloc_Hieararchy"/> TC_008_CiscoProdRevandCogs_TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_010_CiscoProdRevandCogs_Product_Hieararchy"/> TC_010_CiscoProdRevandCogs_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_011_CiscoProdRevandCogs_Fin_Sales_Theater_Hieararchy"/> TC_011_CiscoProdRevandCogs_Fin_Sales_Theater_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_012_CiscoProdRevandCogs_Sales_Hierararchy"/> TC_012_CiscoProdRevandCogs_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_013_CiscoProdRevandCogs_TMS_Corp_Alloc_Hieararchy"/> TC_013_CiscoProdRevandCogs_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_014_CiscoProdRevandCogs_TMS_Sales_Alloc_Hieararchy"/> TC_014_CiscoProdRevandCogs_TMS_Sales_Alloc_Hieararchy <br />
	 <!--  <input type="checkbox" name="CFA_hire_TC" value="TC_015_CiscoProdRevandCogs_Sales_Order_Hierararchy"/> TC_015_CiscoProdRevandCogs_Sales_Order_Hierararchy <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_016_CiscoProdRevandCogs_Ext_BE_Hieararchy"/> TC_016_CiscoProdRevandCogs_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_017_CiscoProdRevandCogs_Int_BE_Hieararchy"/> TC_017_CiscoProdRevandCogs_Int_BE_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_018_CiscoProdRevandCogs_Sales_Order_Line_Hieararchy"/> TC_018_CiscoProdRevandCogs_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_019_CiscoProdRevandCogs_Serv_Finance_Hierararchy"/> TC_019_CiscoProdRevandCogs_Serv_Finance_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_020_CiscoProdRevandCogs_Serv_Finance_and_Products_Hierarchy"/> TC_020_CiscoProdRevandCogs_Serv_Finance_and_Products_Hierarchy <br />  -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_022_CiscoProdRevandCogs_Product_Hieararchy"/> TC_022_CiscoProdRevandCogs_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_023_CiscoProdRevandCogs_Sales_Hierararchy"/> TC_023_CiscoProdRevandCogs_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_024_CiscoProdRevandCogs_Fin_Sales_Theater_Hieararchy"/> TC_024_CiscoProdRevandCogs_Fin_Sales_Theater_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_025_CiscoProdRevandCogs_Sales_Order_Hierararchy"/> TC_025_CiscoProdRevandCogs_Sales_Order_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_026_CiscoProdRevandCogs_Ext_BE_Hieararchy"/> TC_026_CiscoProdRevandCogs_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_027_CiscoProdRevandCogs_Int_BE_Hieararchy"/> TC_027_CiscoProdRevandCogs_Int_BE_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_028_CiscoProdRevandCogs_Sales_Order_Line_Hieararchy"/> TC_028_CiscoProdRevandCogs_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_029_CiscoProdRevandCogs_Serv_Finance_Hierararchy"/> TC_029_CiscoProdRevandCogs_Serv_Finance_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_030_CiscoProdRevandCogs_Serv_Finance_and_Products_Hierarchy"/> TC_030_CiscoProdRevandCogs_Serv_Finance_and_Products_Hierarchy <br />  -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_031_CiscoProdRevandCogs_TMS_Corp_Alloc_Hieararchy"/> TC_031_CiscoProdRevandCogs_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_032_CiscoProdRevandCogs_TMS_Sales_Alloc_Hieararchy"/> TC_032_CiscoProdRevandCogs_TMS_Sales_Alloc_Hieararchy <br />
	<!--  <input type="checkbox" name="CFA_hire_TC" value="TC_033_CiscoProdRevandCogs_Serv_Finance_and_Delivery_Theater_Hierarchy"/> TC_033_CiscoProdRevandCogs_Serv_Finance_and_Delivery_Theater_Hierarchy <br />   -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_035_Cisco_Service_Revenue_Product_Hieararchy"/> TC_035_Cisco_Service_Revenue_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_036_Cisco_Service_Revenue_Sales_Hierararchy"/> TC_036_Cisco_Service_Revenue_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_037_Cisco_Service_Revenue_Fin_Sales_Theater_Hieararchy"/> TC_037_Cisco_Service_Revenue_Fin_Sales_Theater_Hieararchy <br />
	<!--  <input type="checkbox" name="CFA_hire_TC" value="TC_038_Cisco_Service_Revenue_Sales_Order_Hierararchy"/> TC_038_Cisco_Service_Revenue_Sales_Order_Hierararchy <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_039_Cisco_Service_Revenue_Ext_BE_Hieararchy"/> TC_039_Cisco_Service_Revenue_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_040_Cisco_Service_Revenue_Int_BE_Hieararchy"/> TC_040_Cisco_Service_Revenue_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_041_Cisco_Service_Revenue_TMS_Corp_Alloc_Hieararchy"/> TC_041_Cisco_Service_Revenue_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_042_Cisco_Service_Revenue_TMS_Sales_Alloc_Hieararchy"/> TC_042_Cisco_Service_Revenue_TMS_Sales_Alloc_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_043_Cisco_Service_Revenue_Sales_Order_Line_Hieararchy"/> TC_043_Cisco_Service_Revenue_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_044_Cisco_Service_Revenue_Serv_Finance_and_Products_Hierarchy"/> TC_044_Cisco_Service_Revenue_Serv_Finance_and_Products_Hierarchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_045_Cisco_Service_Revenue_Service_Finance_Hieararchy"/> TC_045_Cisco_Service_Revenue_Service_Finance_Hieararchy <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_047_ASCogs_Sales_Hierararchy"/> TC_047_ASCogs_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_048_ASCogs_Fin_Sales_Theater_Hieararchy"/> TC_048_ASCogs_Fin_Sales_Theater_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_049_ASCogs_Service_Delivery_Theater"/> TC_049_ASCogs_Service_Delivery_Theater <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_051_TS_Cogs_TAC_Sales_Hierararchy"/> TC_051_TS_Cogs_TAC_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_052_TS_Cogs_TAC_Triangulated_Sales_with_Sales_Hierarchy"/> TC_052_TS_Cogs_TAC_Triangulated_Sales_with_Sales_Hierarchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_054_TS_Cogs_SAC_Sales_Hierararchy"/> TC_054_TS_Cogs_SAC_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_055_TS_Cogs_SAC_Triangulated_Sales_with_Sales_Hierarchy"/> TC_055_TS_Cogs_SAC_Triangulated_Sales_with_Sales_Hierarchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_057_opex_Sales_Hierararchy"/> TC_057_opex_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_058_opex_Int_BE_Hieararchy"/> TC_058_opex_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_059_opex_Ext_BE_Hieararchy"/> TC_059_opex_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_061_Bookings_Product_Hieararchy"/> TC_061_Bookings_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_062_Bookings_Sales_Hierararchy"/> TC_062_Bookings_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_063_Bookings_Fin_Sales_Theater_Hieararchy"/> TC_063_Bookings_Fin_Sales_Theater_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_064_Bookings_Sales_Order_Hierararchy"/> TC_064_Bookings_Sales_Order_Hierararchy <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_065_Bookings_Ext_BE_Hieararchy"/> TC_065_Bookings_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_066_Bookings_Int_BE_Hieararchy"/> TC_066_Bookings_Int_BE_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_067_Bookings_Sales_Order_Line_Hieararchy"/> TC_067_Bookings_Sales_Order_Line_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_068_Bookings_Service_Finance_Hieararchy"/> TC_068_Bookings_Service_Finance_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_069_Bookings_Product_Hier_and_New_Svc_Finance_Hieararchy"/> TC_069_Bookings_Product_Hier_and_New_Svc_Finance_Hieararchy <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_070_Bookings_TMS_Corp_Alloc_Hieararchy"/> TC_070_Bookings_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_071_Bookings_TMS_Sales_Alloc_Hieararchy"/> TC_071_Bookings_TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_073_Bookings_Product_Hieararchy"/> TC_073_Bookings_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_074_Bookings_Sales_Hierararchy"/> TC_074_Bookings_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_075_Bookings_Fin_Sales_Theater_Hieararchy"/> TC_075_Bookings_Fin_Sales_Theater_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_076_Bookings_Sales_Order"/> TC_076_Bookings_Sales_Order <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_077_Bookings_Ext_BE_Hieararchy"/> TC_077_Bookings_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_078_Bookings_Int_BE_Hieararchy"/> TC_078_Bookings_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_079_Bookings_TMS_Corp_Alloc_Hieararchy"/> TC_079_Bookings_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_080_Bookings_TMS_Sales_Alloc_Hieararchy"/> TC_080_Bookings_TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_082_Bookings__Product_Hieararchy"/> TC_082_Bookings__Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_083_Bookings__Sales_Hierararchy"/> TC_083_Bookings__Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_084_Bookings__Fin_Sales_Theater_Hieararchy"/> TC_084_Bookings__Fin_Sales_Theater_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_085_Bookings__Sales_Order"/> TC_085_Bookings__Sales_Order <br /> --> 
	<input type="checkbox" name="CFA_hire_TC" value="TC_086_Bookings__Ext_BE_Hieararchy"/> TC_086_Bookings__Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_087_Bookings_Int_BE_Hieararchy"/> TC_087_Bookings_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_088_Bookings__TMS_Corp_Alloc_Hieararchy"/> TC_088_Bookings__TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_089_Bookings__TMS_Sales_Alloc_Hieararchy"/> TC_089_Bookings__TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_091_Bookings__Product_Hieararchy"/> TC_091_Bookings__Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_092_Bookings__Sales_Hierararchy"/> TC_092_Bookings__Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_093_Bookings__Fin_Sales_Theater_Hieararchy"/> TC_093_Bookings__Fin_Sales_Theater_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_094_Bookings__Ext_BE_Hieararchy"/> TC_094_Bookings__Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_095_Bookings__Int_BE_Hieararchy"/> TC_095_Bookings__Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_096_Bookings__TMS_Corp_Alloc_Hieararchy"/> TC_096_Bookings__TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_097_Bookings__TMS_Sales_Alloc_Hieararchy"/> TC_097_Bookings__TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_099_Shipment_Product_Hieararchy"/> TC_099_Shipment_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_100_Shipment_Sales_Hierararchy"/> TC_100_Shipment_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_101_Shipment_Ext_BE_Hieararchy"/> TC_101_Shipment_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_102_Shipment_Int_BE_Hieararchy"/> TC_102_Shipment_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_103_Shipment_TMS_Corp_Alloc_Hieararchy"/> TC_103_Shipment_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_104_Shipment_TMS_Sales_Alloc_Hieararchy"/> TC_104_Shipment_TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_106_ServRevTriang_Product_Hieararchy"/> TC_106_ServRevTriang_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_107_ServRevTriang_Sales_Hierararchy"/> TC_107_ServRevTriang_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_108_ServRevTriang_Ext_BE_Hieararchy"/> TC_108_ServRevTriang_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_109_ServRevTriang_Int_BE_Hieararchy"/> TC_109_ServRevTriang_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_110_ServRevTriang_TMS_Corp_Alloc_Hieararchy"/> TC_110_ServRevTriang_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_111_ServRevTriang_TMS_Sales_Alloc_Hieararchy"/> TC_111_ServRevTriang_TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_112_ServRevTriang_Fin_Sales_Theater_Hieararchy"/> TC_112_ServRevTriang_Fin_Sales_Theater_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_113_ServRevTriang_Triang_Sales_Theater_Hierarchy"/> TC_113_ServRevTriang_Triang_Sales_Theater_Hierarchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_114_ServRevTriang_Triang_Sales_Hieararchy"/> TC_114_ServRevTriang_Triang_Sales_Hieararchy <br />
	<!-- <input type="checkbox" name="CFA_hire_TC" value="TC_115_ServRevTriang_Service_Finance_Hieararchy"/> TC_115_ServRevTriang_Service_Finance_Hieararchy <br /> -->
	<input type="checkbox" name="CFA_hire_TC" value="TC_117_RevProfitability_Product_Hieararchy"/> TC_117_RevProfitability_Product_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_118_RevProfitability_Sales_Hierararchy"/> TC_118_RevProfitability_Sales_Hierararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_119_RevProfitability_Fin_Sales_Theater_Hieararchy"/> TC_119_RevProfitability_Fin_Sales_Theater_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_120_RevProfitability_TMS_Corp_Alloc_Hieararchy"/> TC_120_RevProfitability_TMS_Corp_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_121_RevProfitability_TMS_Sales_Alloc_Hieararchy"/> TC_121_RevProfitability_TMS_Sales_Alloc_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_122_RevProfitability_Ext_BE_Hieararchy"/> TC_122_RevProfitability_Ext_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_123_RevProfitability_Int_BE_Hieararchy"/> TC_123_RevProfitability_Int_BE_Hieararchy <br />
	<input type="checkbox" name="CFA_hire_TC" value="TC_125_RevProfitability_Product_Hieararchy"/> TC_125_RevProfitability_Product_Hieararchy<br />
<input type="checkbox" name="CFA_hire_TC" value="TC_126_RevProfitability_Sales_Hierararchy"/> TC_126_RevProfitability_Sales_Hierararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_127_RevProfitability_Fin_Sales_Theater_Hieararchy"/> TC_127_RevProfitability_Fin_Sales_Theater_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_128_RevProfitability_TMS_Corp_Alloc_Hieararchy"/> TC_128_RevProfitability_TMS_Corp_Alloc_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_129_RevProfitability_TMS_Sales_Alloc_Hieararchy"/> TC_129_RevProfitability_TMS_Sales_Alloc_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_130_RevProfitability_Ext_BE_Hieararchy"/> TC_130_RevProfitability_Ext_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_131_RevProfitability_Int_BE_Hieararchy"/> TC_131_RevProfitability_Int_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_132_Bookings_Grossmargin_Fact"/> TC_132_Bookings_Grossmargin_Fact <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_133_Bookings_Grossmargin_Product_Hieararchy"/> TC_133_Bookings_Grossmargin_Product_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_134_Bookings_Grossmargin_Sales_Hierararchy"/> TC_134_Bookings_Grossmargin_Sales_Hierararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_135_Bookings_Grossmargin_Fin_Sales_Theater_Hieararchy"/> TC_135_Bookings_Grossmargin_Fin_Sales_Theater_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_136_Bookings_Grossmargin_Ext_BE_Hieararchy"/> TC_136_Bookings_Grossmargin_Ext_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_137_Bookings_Grossmargin_Int_BE_Hieararchy"/> TC_137_Bookings_Grossmargin_Int_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_138_Bookings_Grossmargin_Fact"/> TC_138_Bookings_Grossmargin_Fact <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_139_Bookings_Grossmargin_Product_Hieararchy"/> TC_139_Bookings_Grossmargin_Product_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_140_Bookings_Grossmargin_Sales_Hierararchy"/> TC_140_Bookings_Grossmargin_Sales_Hierararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_141_Bookings_Grossmargin_Fin_Sales_Theater_Hieararchy"/> TC_141_Bookings_Grossmargin_Fin_Sales_Theater_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_142_Bookings_Grossmargin_Ext_BE_Hieararchy"/> TC_142_Bookings_Grossmargin_Ext_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_143_Bookings_Grossmargin_Int_BE_Hieararchy"/> TC_143_Bookings_Grossmargin_Int_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_144_Opex_Plan_Fact"/> TC_144_Opex_Plan_Fact <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_145_FCM_COGS_Fact"/> TC_145_FCM_COGS_Fact <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_146_Bookings_SW_Annuity_Grossmargin_Fact"/> TC_146_Bookings_SW_Annuity_Grossmargin_Fact <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_147_Bookings_SW_Annuity_Grossmargin_Product_Hieararchy"/> TC_147_Bookings_SW_Annuity_Grossmargin_Product_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_148_Bookings_SW_Annuity_Grossmargin_Sales_Hierararchy"/> TC_148_Bookings_SW_Annuity_Grossmargin_Sales_Hierararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_149_Bookings_SW_Annuity_Grossmargin_Fin_Sales_Theater_Hieararchy"/> TC_149_Bookings_SW_Annuity_Grossmargin_Fin_Sales_Theater_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_150_Bookings_SW_Annuity_Grossmargin_Ext_BE_Hieararchy"/> TC_150_Bookings_SW_Annuity_Grossmargin_Ext_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_151_Bookings_SW_Annuity_Grossmargin_Int_BE_Hieararchy"/> TC_151_Bookings_SW_Annuity_Grossmargin_Int_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_152_Bookings_SW_Grossmargin_Fact"/> TC_152_Bookings_SW_Grossmargin_Fact <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_153_Bookings_SW_Grossmargin_Product_Hieararchy"/> TC_153_Bookings_SW_Grossmargin_Product_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_154_Bookings_SW_Grossmargin_Sales_Hierararchy"/> TC_154_Bookings_SW_Grossmargin_Sales_Hierararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_155_Bookings_SW_Grossmargin_Fin_Sales_Theater_Hieararchy"/> TC_155_Bookings_SW_Grossmargin_Fin_Sales_Theater_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_156_Bookings_SW_Grossmargin_Ext_BE_Hieararchy"/> TC_156_Bookings_SW_Grossmargin_Ext_BE_Hieararchy <br />
<input type="checkbox" name="CFA_hire_TC" value="TC_157_Bookings_SW_Grossmargin_Int_BE_Hieararchy"/> TC_157_Bookings_SW_Grossmargin_Int_BE_Hieararchy <br />
	</td>
       <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="CFAPeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>



<!--  Fetch Cube -->
<a class="hyperlinkblock" id="FetchCube" href="javascript:ExpandCollapaseFetchCube();">Fetch Cube</a> 
<div  class="container"  id="FetchCubeTestcases" style="display: none" >

	<table>
	<tr>
	<!--  Fetch Cube Fact-->
	<td>
	<input type="checkbox" onClick="toggleFetchCube_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="FetchCube_fact_TC" value="TC_001_PV_FIXED_ASSET_WITH_DEPRN_FACT"/> TC_001_PV_FIXED_ASSET_WITH_DEPRN_FACT<br />
	<input type="checkbox" name="FetchCube_fact_TC" value="TC_002_PV_JOURNAL_ENTRY_LINE_FACT"/> TC_002_PV_JOURNAL_ENTRY_LINE_FACT<br />
	<input type="checkbox" name="FetchCube_fact_TC" value="TC_003_FetchCube_ExpenseFutureCommit_Fact"/> TC_003_FetchCube_ExpenseFutureCommit_Fact<br />
	<input type="checkbox" name="FetchCube_fact_TC" value="TC_004_FetchCube_ExpenseFutureBudget_Fact"/> TC_004_FetchCube_ExpenseFutureBudget_Fact<br />
	<input type="checkbox" name="FetchCube_fact_TC" value="TC_012_FetchCube_OpexPlan_Fact"/> TC_012_FetchCube_OpexPlan_Fact<br />
	<input type="checkbox" name="FetchCube_fact_TC" value="TC_013_FetchCube_TotalOpex_Fact"/> TC_013_FetchCube_TotalOpex_Fact<br />
	 </td>
	 <!--  Fetch Cube Hierarchy-->
    <td>
    <input type="checkbox" onClick="toggleFetchCube_Hire(this)" /><b> Toggle All Hirerarchy</b><br/>
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_005_FetchCube_PL_Hierarchy"/> TC_005_FetchCube_PL_Hierarchy <br />
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_006_FetchCube_FinancialAccount_Hierarchy" /> TC_006_FetchCube_FinancialAccount_Hierarchy <br />
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_007_FetchCube_JournalEntry_Hierarchy" /> TC_007_FetchCube_JournalEntry_Hierarchy <br />
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_008_FetchCube_SetOfBooks_Hierarchy"/> TC_008_FetchCube_SetOfBooks_Hierarchy<br />
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_009_FetchCube_Opex_Sales_Hierarchy"/> TC_009_FetchCube_Opex_Sales_Hierarchy<br />
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_010_FetchCube_Opex_IntBE_Hierarchy"/> TC_010_FetchCube_Opex_IntBE_Hierarchy<br />
    <input type="checkbox" name="FetchCube_hire_TC" value="TC_011_FetchCube_Opex_ExtBE_Hierarchy"/> TC_011_FetchCube_Opex_ExtBE_Hierarchy<br />
     </td>
       <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="FetchCubePeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>

<!--  PNL -->
<a class="hyperlinkblock" id="PNL" href="javascript:ExpandCollapasePNL();">PNL</a> 
<div  class="container"  id="PNLTestcases" style="display: none" >

	<table>
	<tr>
	<!-- PNL Fact -->
	<td>
	<input type="checkbox" onClick="togglePNL_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="PNL_fact_TC" value="TC_001_Revenue_Fact"/> TC_001_Revenue_Fact<br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_015_Shipment_Fact"/> TC_015_Shipment_Fact<br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_022_ServiceTriangulated_Fact"/> TC_022_ServiceTriangulated_Fact<br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_033_AS_COGS_Fact"/> TC_033_AS_COGS_Fact<br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_037_TSCOGS_TAC_COST_Fact"/> TC_037_TSCOGS_TAC_COST_Fact<br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_041_TSCOGS_SSC_COST_Fact"/> TC_041_TSCOGS_SSC_COST_Fact <br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_044_ManualAdjust_Fact"/> TC_044_ManualAdjust_Fact <br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_051_Profitability_Fact"/> TC_051_Profitability_Fact <br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_061_ISOCountry_Fact"/> TC_061_ISOCountry_Fact <br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_062_Backlog_Fact"/> TC_062_Backlog_Fact <br />
	<!--  <input type="checkbox" name="PNL_fact_TC" value="TC_068_Acquisition_FDI_Fact"/> TC_068_Acquisition_FDI_Fact <br />
	<input type="checkbox" name="PNL_fact_TC" value="TC_069_Acquisition_Webex_Fact"/> TC_069_Acquisition_Webex_Fact <br />  -->
	</td>
	<!-- PNL Hierarchy -->
    <td>
    <input type="checkbox" onClick="togglePNL_Hire(this)" /><b> Toggle All Hierarchy</b><br/>
    <input type="checkbox" name="PNL_hire_TC" value="TC_002_Revenue_Product_Hierarchy"/> TC_002_Revenue_Product_Hierarchy <br />
    <input type="checkbox" name="PNL_hire_TC" value="TC_003_Revenue_Sales_Hierarchy" /> TC_003_Revenue_Sales_Hierarchy <br />
    <input type="checkbox" name="PNL_hire_TC" value="TC_004_Revenue_TMS_Hierarchy" /> TC_004_Revenue_TMS_Hierarchy <br />
    <input type="checkbox" name="PNL_hire_TC" value="TC_005_Revenue_Sales_Order"/> TC_005_Revenue_Sales_Order<br />
    <input type="checkbox" name="PNL_hire_TC" value="TC_006_Revenue_External_BE_Hierarchy"/> TC_006_Revenue_External_BE_Hierarchy<br />
    <input type="checkbox" name="PNL_hire_TC" value="TC_007_Revenue_Internal_BEHierarchy"/> TC_007_Revenue_Internal_BEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_008_Revenue_SalesOrder_VI_Hierarchy"/> TC_008_Revenue_SalesOrder_VI_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_009_Revenue_ServiceFinHierarchy"/> TC_009_Revenue_ServiceFinHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_010_Revenue_DeliveryTheaterHierarchy"/> TC_010_Revenue_DeliveryTheaterHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_011_Revenue_SFHHierarchy"/> TC_011_Revenue_SFHHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_012_Revenue_SWHierarchy"/> TC_012_Revenue_SWHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_013_Revenue_SWHierarchyCOGS"/> TC_013_Revenue_SWHierarchyCOGS <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_014_Revenue_SWHierarchy_NONCOGS"/> TC_014_Revenue_SWHierarchy_NONCOGS <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_016_Shipment_ProductHierarchy"/> TC_016_Shipment_ProductHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_017_Shipment_SalesHierarchy"/> TC_017_Shipment_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_018_Shipment_TMS_Hierarchy"/> TC_018_Shipment_TMS_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_019_Shipment_ExternalBEHierarchy"/> TC_019_Shipment_ExternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_020_Shipment_InternalBEHierarchy"/> TC_020_Shipment_InternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_021_Shipment_SFH_Hierarchy"/> TC_021_Shipment_SFH_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_023_ServTriang_ProductHierarchy"/> TC_023_ServTriang_ProductHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_024_ServTriang_SalesHierarchy"/> TC_024_ServTriang_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_025_ServTriang_TMS_Hierarchy"/> TC_025_ServTriang_TMS_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_026_ServTriang_ExternalBEHierarchy"/> TC_026_ServTriang_ExternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_027_ServTriang_InternalBEHierarchy"/> TC_027_ServTriang_InternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_028_ServTriang_ServiceFinHierarchy"/> TC_028_ServTriang_ServiceFinHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_029_ServTriang_TriangulatedSalesHierarchy"/> TC_029_ServTriang_TriangulatedSalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_030_ServTriang_Triangulated_Sales_Theater_Hierarchy"/> TC_030_ServTriang_Triangulated_Sales_Theater_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_031_ServTriang_Sales_Theater_Hieararchy"/> TC_031_ServTriang_Sales_Theater_Hieararchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_032_ServTriang_SFH_Hieararchy"/> TC_032_ServTriang_SFH_Hieararchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_034_AS_COGS_DeliveryTheater"/> TC_034_AS_COGS_DeliveryTheater <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_035_AS_COGS_SFH"/> TC_035_AS_COGS_SFH <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_036_AS_COGS_SalesHierarchy"/> TC_036_AS_COGS_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_038_TSCOGS_TAC_COST_SalesHierarchy"/> TC_038_TSCOGS_TAC_COST_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_039_TSCOGS_TAC_COST_Triangulated_Sales_Hierarchy"/> TC_039_TSCOGS_TAC_COST_Triangulated_Sales_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_040_TSCOGS_TAC_COST_SFH_Hierarchy"/> TC_040_TSCOGS_TAC_COST_SFH_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_042_TSCOGS_SSC_COST_SalesHierarchy"/> TC_042_TSCOGS_SSC_COST_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_043_TSCOGS_SSC_COST_SFH_Hierarchy"/> TC_043_TSCOGS_SSC_COST_SFH_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_045_ManualAdj_ProductHierarchy"/> TC_045_ManualAdj_ProductHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_046_ManualAdj_SalesHierarchy"/> TC_046_ManualAdj_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_047_ManualAdj_TMS_Hierarchy"/> TC_047_ManualAdj_TMS_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_048_ManualAdj_ExternalBEHierarchy"/> TC_048_ManualAdj_ExternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_049_ManualAdj_InternalBEHierarchy"/> TC_049_ManualAdj_InternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_050_ManualAdj_SFH_Hieararchy"/> TC_050_ManualAdj_SFH_Hieararchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_052_Profitability_ProductHierarchy"/> TC_052_Profitability_ProductHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_053_Profitability_SalesHierarchy"/> TC_053_Profitability_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_054_Profitability_TMSHierarchy"/> TC_054_Profitability_TMSHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_055_Profitability_ExternalBEHierarchy"/> TC_055_Profitability_ExternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_056_Profitability_InternalBEHierarchy"/> TC_056_Profitability_InternalBEHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_057_Profitability_SalesOrder_VI_Hierarchy"/> TC_057_Profitability_SalesOrder_VI_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_058_Profitability_SalesTheaterHierarchy"/> TC_058_Profitability_SalesTheaterHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_059_Profitability_Delivery_Theater"/> TC_059_Profitability_Delivery_Theater <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_060_Profitability_SFH_Hierarchy"/> TC_060_Profitability_SFH_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_063_Item_keyTMSwithProdHierarchy"/> TC_063_Item_keyTMSwithProdHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_064_Item_key_Internal_BE_with_Prod_Hierarchy"/> TC_064_Item_key_Internal_BE_with_Prod_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_065_Item_key_ExternalBE_with_Prod_Hierarchy"/> TC_065_Item_key_ExternalBE_with_Prod_Hierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_066_STK_Sales_Theater_with_SalesHierarchy"/> TC_066_STK_Sales_Theater_with_SalesHierarchy <br />
	<input type="checkbox" name="PNL_hire_TC" value="TC_067_STK_Service_Delivery_Theater_with_SalesHierarchy"/> TC_067_STK_Service_Delivery_Theater_with_SalesHierarchy <br />
     
     
     </td>
       <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="PNLPeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>


<!--  Revenue BO -->
<a class="hyperlinkblock" id="RevenueBO" href="javascript:ExpandCollapaseRevenueBO();">RevenueBO</a> 
<div  class="container"  id="RevenueBOTestcases" style="display: none" >

	<table>
	<tr>
	<!--  Revenue BO fact -->
	<td>
	<input type="checkbox" onClick="toggleRevenueBO_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_001_CiscoRevenue_Base_Fact"/> TC_001_CiscoRevenue_Base_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_002_TotalCiscoRevenue_Fact"/> TC_002_TotalCiscoRevenue_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_003_AcquisitionDetails_Fact"/> TC_003_AcquisitionDetails_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_004_CiscoPandL_GM_Fact"/> TC_004_CiscoPandL_GM_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_005_TotalCiscoPandL_GM_Fact"/> TC_005_TotalCiscoPandL_GM_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_006_Revenue_GrossMargin_Fact"/> TC_006_Revenue_GrossMargin_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_010_Invoice_GrossMargin_Fact"/> TC_010_Invoice_GrossMargin_Fact<br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_011_CiscoRevenue_Aggregated_Fact"/> TC_011_CiscoRevenue_Aggregated_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_012_Revenue_CreditMemoDebitMemo_Fact"/> TC_012_Revenue_CreditMemoDebitMemo_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_013_Revenue_CreditMemo_Fact"/> TC_013_Revenue_CreditMemo_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_014_Revenue_DebitMemo_Fact"/> TC_014_Revenue_DebitMemo_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_024_Invoice_Fact"/> TC_024_Invoice_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_025_Invoice_CreditMemo_Fact"/> TC_025_Invoice_CreditMemo_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_026_Invoice_DebitMemo_Fact"/> TC_026_Invoice_DebitMemo_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_036_CAServRev_Fact"/> TC_036_CAServRev_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_038_TotalCAServRev_Fact"/> TC_038_TotalCAServRev_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_039_CAServInv_Fact"/> TC_039_CAServInv_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_041_TMSCorpAllocRev_Fact"/> TC_041_TMSCorpAllocRev_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_043_TMSSalesAllocInv_Fact"/> TC_043_TMSSalesAllocInv_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_045_AcqServRev_Fact"/> TC_045_AcqServRev_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_047_CreditMemoAdj_Fact"/> TC_047_CreditMemoAdj_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_048_ContriMargin_Fact"/> TC_048_ContriMargin_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_053_ContriMarginBudget_Fact"/> TC_053_ContriMarginBudget_Fact <br />
	<input type="checkbox" name="RevenueBO_fact_TC" value="TC_054_ContriMarginCommit_Fact"/> TC_054_ContriMarginCommit_Fact <br />
	</td>
	 <!--  Revenue BO hierarchy -->
    <td>
    <input type="checkbox" onClick="toggleRevenueBO_Hire(this)" /><b> Toggle All Hierarchy</b><br/>
    <input type="checkbox" name="RevenueBO_hire_TC" value="TC_007_Revenue_SWHierarchy"/> TC_007_Revenue_SWHierarchy <br />
    <input type="checkbox" name="RevenueBO_hire_TC" value="TC_008_Revenue_COGS_SWHier" /> TC_008_Revenue_COGS_SWHier <br />
    <input type="checkbox" name="RevenueBO_hire_TC" value="TC_009_Revenue_NONCOGS_SWHier" /> TC_009_Revenue_NONCOGS_SWHier <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_015_Revenue_SalesHierarchy"/> TC_015_Revenue_SalesHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_016_Revenue_ProductHierarchy"/> TC_016_Revenue_ProductHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_019_Revenue_SoldtoCustomerHierarchy"/> TC_019_Revenue_SoldtoCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_020_Revenue_BilltoCustomerHierarchy"/> TC_020_Revenue_BilltoCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_021_Revenue_ShiptoCustomerHierarchy"/> TC_021_Revenue_ShiptoCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_022_Revenue_EndCustomerHierarchy"/> TC_022_Revenue_EndCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_023_Revenue_SalesFinanceHierarchy"/> TC_023_Revenue_SalesFinanceHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_027_Invoice_SalesHierarchy"/> TC_027_Invoice_SalesHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_028_Invoice_ProductHierarchy"/> TC_028_Invoice_ProductHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_031_Invoice_SoldtoCustomerHierarchy"/> TC_031_Invoice_SoldtoCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_032_Invoice_BilltoCustomerHierarchy"/> TC_032_Invoice_BilltoCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_033_Invoice_ShiptoCustomerHierarchy"/> TC_033_Invoice_ShiptoCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_034_Invoice_EndCustomerHierarchy"/> TC_034_Invoice_EndCustomerHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_035_Invoice_SalesFinanceHierarchy"/> TC_035_Invoice_SalesFinanceHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_040_CAServInv_ServiceFinance_Hierarchy"/> TC_040_CAServInv_ServiceFinance_Hierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_046_Acquisition_SalesHierarchy"/> TC_046_Acquisition_SalesHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_049_ContriMargin_SalesHierarchy"/> TC_049_ContriMargin_SalesHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_050_ContriMargin_ProductHierarchy"/> TC_050_ContriMargin_ProductHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_051_ContriMargin_InternalBE_Hierarchy"/> TC_051_ContriMargin_InternalBE_Hierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_052_ContriMargin_ExternalBE_Hierarchy"/> TC_052_ContriMargin_ExternalBE_Hierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_017_Revenue_InternalBEHierarchy"/> TC_017_Revenue_InternalBEHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_018_Revenue_ExternalBEHierarchy"/> TC_018_Revenue_ExternalBEHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_029_Invoice_InternalBEHierarchy"/> TC_029_Invoice_InternalBEHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_030_Invoice_ExternalBEHierarchy"/> TC_030_Invoice_ExternalBEHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_037_CAServRev_ServiceFinance_Hierarchy"/> TC_037_CAServRev_ServiceFinance_Hierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_042_TmsCorpAllocRev_TMSCorp_Hierarchy"/> TC_042_TmsCorpAllocRev_TMSCorp_Hierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_044_TmsSalesAllocInv_TMSSales_Hierarchy"/> TC_044_TmsSalesAllocInv_TMSSales_Hierarchy <br />
	 <input type="checkbox" name="RevenueBO_hire_TC" value="TC_046_Acquisition_SalesHierarchy"/> TC_046_Acquisition_SalesHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_049_ContriMargin_SalesHierarchy"/> TC_049_ContriMargin_SalesHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_050_ContriMargin_ProductHierarchy"/> TC_050_ContriMargin_ProductHierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_051_ContriMargin_InternalBE_Hierarchy"/> TC_051_ContriMargin_InternalBE_Hierarchy <br />
	<input type="checkbox" name="RevenueBO_hire_TC" value="TC_052_ContriMargin_ExternalBE_Hierarchy"/> TC_052_ContriMargin_ExternalBE_Hierarchy <br />
	 
	  
	  
	  </td>
       <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="RevenueBOPeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>
	
	
	
	<!--  Allocation Engine -->
<a class="hyperlinkblock" id="AE" href="javascript:ExpandCollapaseAE();">Allocation Engine</a> 
<div  class="container"  id="AETestcases" style="display: none" >

	<table>
	<tr>
	<!--  AE fact -->
	<td>
	<input type="checkbox" onClick="toggleAE_Fact(this)" /><b> Toggle All Fact</b><br/>
	<input type="checkbox" name="AE_fact_TC" value="TC_001_AE_FACT_Revenue"/> TC_001_AE_FACT_Revenue<br />
	<input type="checkbox" name="AE_fact_TC" value="TC_002_AE_FACT_Revenue"/> TC_002_AE_FACT_Revenue<br />
	<input type="checkbox" name="AE_fact_TC" value="TC_003_AE_FACT_Bookings"/> TC_003_AE_FACT_Bookings<br />
	<input type="checkbox" name="AE_fact_TC" value="TC_004_AE_FACT_SCAA"/> TC_004_AE_FACT_SCAA<br />
	<input type="checkbox" name="AE_fact_TC" value="TC_005_AE_FACT_RevCostMeasure"/> TC_005_AE_FACT_RevCostMeasure<br />
	<input type="checkbox" name="AE_fact_TC" value="TC_006_AE_FACT_TAC_Measure"/> TC_006_AE_FACT_TAC_Measure <br />
	<input type="checkbox" name="AE_fact_TC" value="TC_007_AE_FACT_SSC_Measure"/> TC_007_AE_FACT_SSC_Measure <br />
	<input type="checkbox" name="AE_fact_TC" value="TC_008_AE_FACT_Restated_Revenue"/> TC_008_AE_FACT_Restated_Revenue <br />
	<input type="checkbox" name="AE_fact_TC" value="TC_009_AE_FACT_Restated_Bookings"/> TC_009_AE_FACT_Restated_Bookings <br />
	<input type="checkbox" name="AE_fact_TC" value="TC_010_AE_FACT_Expense"/> TC_010_AE_FACT_Expense <br />
	<input type="checkbox" name="AE_fact_TC" value="TC_011_AE_FACT_Hours"/> TC_011_AE_FACT_Hours <br />
	
	</td>
	 <!--  AE hierarchy -->
    <td>
    <input type="checkbox" onClick="toggleAE_Hire(this)" /><b> Toggle All Hierarchy</b><br/>
    <input type="checkbox" name="AE_hire_TC" value="TC_012_AE_Hier_GL_Rev"/> TC_012_AE_Hier_GL_Rev <br />
    <input type="checkbox" name="AE_hire_TC" value="TC_013_AE_Hier_AR_Trx" /> TC_013_AE_Hier_AR_Trx <br />
    <input type="checkbox" name="AE_hire_TC" value="TC_014_AE_Hier_GL_RevenueWithCustomer" /> TC_014_AE_Hier_GL_RevenueWithCustomer <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_015_AE_Hier_GL_RevWithCust"/> TC_015_AE_Hier_GL_RevWithCust <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_016_AE_Hier_GLRevWithAccount"/> TC_016_AE_Hier_GLRevWithAccount <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_017_AE_Hier_GLRevWithCustAccount"/> TC_017_AE_Hier_GLRevWithCustAccount <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_018_AE_Hier_GLRevenueDrvdNCR"/> TC_018_AE_Hier_GLRevenueDrvdNCR <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_019_AE_Hier_GLRevDrvdNCR"/> TC_019_AE_Hier_GLRevDrvdNCR <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_020_AE_Hier_GLRevArTrxLine"/> TC_020_AE_Hier_GLRevArTrxLine <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_021_AE_Hier_GLRevArTrxLine"/> TC_021_AE_Hier_GLRevArTrxLine <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_022_AE_Hier_GLRevShipTo"/> TC_022_AE_Hier_GLRevShipTo <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_023_AE_Hier_GLRevShipTo"/> TC_023_AE_Hier_GLRevShipTo <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_024_AE_Hier_GLRevPverp_Cust_acct_loc_use"/> TC_024_AE_Hier_GLRevPverp_Cust_acct_loc_use <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_025_AE_Hier_GLRevPverp_Cust_acct_loc_use"/> TC_025_AE_Hier_GLRevPverp_Cust_acct_loc_use <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_026_AE_Hier_GLRevPV_Cust_Account"/> TC_026_AE_Hier_GLRevPV_Cust_Account <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_027_AE_Hier_GLRevPV_Cust_Account"/> TC_027_AE_Hier_GLRevPV_Cust_Account <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_028_AE_Hier_GLRevPV_Cust_Acc_locatr_asgn"/> TC_028_AE_Hier_GLRevPV_Cust_Acc_locatr_asgn <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_029_AE_Hier_GLRevPV_Cust_Acc_locatr_asgn"/> TC_029_AE_Hier_GLRevPV_Cust_Acc_locatr_asgn <br />
	<input type="checkbox" name="AE_hire_TC" value="TC_030_AE_Hier_GLRev_Bill_To"/> TC_030_AE_Hier_GLRev_Bill_To <br />
    <input type="checkbox" name="AE_hire_TC" value="TC_032_AE_Hier_GLRev_Bill_To"/> TC_032_AE_Hier_GLRev_Bill_To <br />
<input type="checkbox" name="AE_hire_TC" value="TC_033_AE_Hier_GLRevenue_erp_cust_acct_loc_use"/> TC_033_AE_Hier_GLRevenue_erp_cust_acct_loc_use <br />
<input type="checkbox" name="AE_hire_TC" value="TC_034_AE_Hier_GLRev_erp_cust_acct_loc_use"/> TC_034_AE_Hier_GLRev_erp_cust_acct_loc_use <br />
<input type="checkbox" name="AE_hire_TC" value="TC_035_AE_Hier_GLRevenue_customer_account"/> TC_035_AE_Hier_GLRevenue_customer_account <br />
<input type="checkbox" name="AE_hire_TC" value="TC_036_AE_Hier_GLRev_customer_account"/> TC_036_AE_Hier_GLRev_customer_account <br />
<input type="checkbox" name="AE_hire_TC" value="TC_037_AE_Hier_GLRevenue_cust_acct_lctr_asgn"/> TC_037_AE_Hier_GLRevenue_cust_acct_lctr_asgn <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_038_AE_Hier_GLRev_cust_acct_lctr_asgn"/> TC_038_AE_Hier_GLRev_cust_acct_lctr_asgn <br />
<input type="checkbox" name="AE_hire_TC" value="TC_039_AE_Hier_ISO_Country"/> TC_039_AE_Hier_ISO_Country <br />
<input type="checkbox" name="AE_hire_TC" value="TC_040_AE_Hier_GLRevenue_Prod_Hier"/> TC_040_AE_Hier_GLRevenue_Prod_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_041_AE_Hier_GLRev_Prod_Hier"/> TC_041_AE_Hier_GLRev_Prod_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_042_AE_Hier_GLRevenue_Sales_Hier"/> TC_042_AE_Hier_GLRevenue_Sales_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_043_AE_Hier_GLRev_Sales_Hier"/> TC_043_AE_Hier_GLRev_Sales_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_044_AE_Hier_GLRevenue_ServFin_Hier"/> TC_044_AE_Hier_GLRevenue_ServFin_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_045_AE_Hier_GLRev_ServFin_Hier"/> TC_045_AE_Hier_GLRev_ServFin_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_046_AE_Hier_GLRevenue_SalesOrder_Line"/> TC_046_AE_Hier_GLRevenue_SalesOrder_Line <br />
<input type="checkbox" name="AE_hire_TC" value="TC_047_AE_Hier_GLRev_SalesOrder_Line"/> TC_047_AE_Hier_GLRev_SalesOrder_Line <br />
<input type="checkbox" name="AE_hire_TC" value="TC_048_AE_Hier_BE_hier"/> TC_048_AE_Hier_BE_hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_049_AE_Hier_BE_hier"/> TC_049_AE_Hier_BE_hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_050_AE_Hier_BillTo"/> TC_050_AE_Hier_BillTo <br />
<input type="checkbox" name="AE_hire_TC" value="TC_051_AE_Hier_BE_hier"/> TC_051_AE_Hier_BE_hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_052_AE_Hier_Sales_hier"/> TC_052_AE_Hier_Sales_hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_053_AE_Hier_Prod_hier"/> TC_053_AE_Hier_Prod_hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_054_AE_Hier_Sales_Order"/> TC_054_AE_Hier_Sales_Order <br />
<input type="checkbox" name="AE_hire_TC" value="TC_055_AE_Hier_Sales_Order_V1_Tv"/> TC_055_AE_Hier_Sales_Order_V1_Tv <br />
<input type="checkbox" name="AE_hire_TC" value="TC_056_AE_Hier_Sol_Shipment"/> TC_056_AE_Hier_Sol_Shipment <br />
<input type="checkbox" name="AE_hire_TC" value="TC_057_AE_Hier_Mt_Erp_Pos_SoldTo"/> TC_057_AE_Hier_Mt_Erp_Pos_SoldTo <br />
<input type="checkbox" name="AE_hire_TC" value="TC_058_AE_Hier_Cust_Account"/> TC_058_AE_Hier_Cust_Account <br />
<input type="checkbox" name="AE_hire_TC" value="TC_059_AE_Hier_Rev_Cost_Prod_Tv"/> TC_059_AE_Hier_Rev_Cost_Prod_Tv <br />
<input type="checkbox" name="AE_hire_TC" value="TC_060_AE_Hier_Rev_Cost_Sales_Tv"/> TC_060_AE_Hier_Rev_Cost_Sales_Tv <br />
<input type="checkbox" name="AE_hire_TC" value="TC_061_AE_Hier_Rev_Cost_Pnl_Hier"/> TC_061_AE_Hier_Rev_Cost_Pnl_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_062_AE_Hier_Sales_Hier"/> TC_062_AE_Hier_Sales_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_063_AE_Hier_Prod_Hier"/> TC_063_AE_Hier_Prod_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_064_AE_Hier_Sales_Hier"/> TC_064_AE_Hier_Sales_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_065_AE_Hier_Prod_Hier"/> TC_065_AE_Hier_Prod_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_066_AE_Hier_Prod_Hier"/> TC_066_AE_Hier_Prod_Hier <br />
<input type="checkbox" name="AE_hire_TC" value="TC_067_AE_Hier_Sales_Fin_DYN"/> TC_067_AE_Hier_Sales_Fin_DYN <br />
<input type="checkbox" name="AE_hire_TC" value="TC_068_AE_Hier_Sales_Fin_DYN"/> TC_068_AE_Hier_Sales_Fin_DYN <br />
<input type="checkbox" name="AE_hire_TC" value="TC_069_AE_Hier_Derived_NCR_Rev"/> TC_069_AE_Hier_Derived_NCR_Rev <br />
<input type="checkbox" name="AE_hire_TC" value="TC_070_AE_Hier_AR_Trx"/> TC_070_AE_Hier_AR_Trx <br />
<input type="checkbox" name="AE_hire_TC" value="TC_071_AE_Hier_Prod_Fin"/> TC_071_AE_Hier_Prod_Fin <br />
<input type="checkbox" name="AE_hire_TC" value="TC_072_AE_Hier_Prod_Fin"/> TC_072_AE_Hier_Prod_Fin <br />
<input type="checkbox" name="AE_hire_TC" value="TC_073_AE_Hier_ERP_End_Cust"/> TC_073_AE_Hier_ERP_End_Cust <br />
<input type="checkbox" name="AE_hire_TC" value="TC_074_AE_Hier_Sales_Order_Line"/> TC_074_AE_Hier_Sales_Order_Line <br />
<input type="checkbox" name="AE_hire_TC" value="TC_075_AE_Hier_Sales_Order"/> TC_075_AE_Hier_Sales_Order <br />
<input type="checkbox" name="AE_hire_TC" value="TC_076_AE_Hier_ERP_End_Cust"/> TC_076_AE_Hier_ERP_End_Cust <br />
<input type="checkbox" name="AE_hire_TC" value="TC_077_AE_Hier_ISO_Country"/> TC_077_AE_Hier_ISO_Country <br />
<input type="checkbox" name="AE_hire_TC" value="TC_078_AE_Hier_Business_Unit"/> TC_078_AE_Hier_Business_Unit <br />
<input type="checkbox" name="AE_hire_TC" value="TC_079_AE_Hier_Setrv_program_TV"/> TC_079_AE_Hier_Setrv_program_TV <br />
<input type="checkbox" name="AE_hire_TC" value="TC_080_AE_Hier_Journal_Entry"/> TC_080_AE_Hier_Journal_Entry <br />
<input type="checkbox" name="AE_hire_TC" value="TC_081_AE_Hier_Book_TV"/> TC_081_AE_Hier_Book_TV <br />
<input type="checkbox" name="AE_hire_TC" value="TC_082_AE_Hier_Acnt_SubAcnt"/> TC_082_AE_Hier_Acnt_SubAcnt <br />
<input type="checkbox" name="AE_hire_TC" value="TC_083_AE_Hier_Fin_Accnt"/> TC_083_AE_Hier_Fin_Accnt <br />
<input type="checkbox" name="AE_hire_TC" value="TC_084_AE_Hier_Local_Fin_Accnt"/> TC_084_AE_Hier_Local_Fin_Accnt <br />
<input type="checkbox" name="AE_hire_TC" value="TC_085_AE_Hier_Financial_Dept"/> TC_085_AE_Hier_Financial_Dept <br />
<input type="checkbox" name="AE_hire_TC" value="TC_086_AE_Hier_Financial_Market_Lob"/> TC_086_AE_Hier_Financial_Market_Lob <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_087_AE_Hier_PL_Hier"/> TC_087_AE_Hier_PL_Hier <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_088_AE_Hier_Fin_Svc_Dlvry_Thtr"/> TC_088_AE_Hier_Fin_Svc_Dlvry_Thtr <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_089_AE_Hier_Sales_Hier_TV"/> TC_089_AE_Hier_Sales_Hier_TV <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_090_AE_Hier_Sales_Hier_TV"/> TC_090_AE_Hier_Sales_Hier_TV <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_091_AE_Hier_ISO_Country"/> TC_091_AE_Hier_ISO_Country <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_092_AE_Hier_AS_COGS_HOURS_PROJECT"/> TC_092_AE_Hier_AS_COGS_HOURS_PROJECT <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_093_AE_Hier_Fin_Sales_Thtr"/> TC_093_AE_Hier_Fin_Sales_Thtr <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_094_AE_Hier_Fin_Sales_Thtr"/> TC_094_AE_Hier_Fin_Sales_Thtr <br />	
<input type="checkbox" name="AE_hire_TC" value="TC_095_AE_Hier_Mt_adj_desc"/> TC_095_AE_Hier_Mt_adj_desc <br />		
	  </td>
       <td>
    </td>
    <td>
    </td>
    <td>
    Period ID=&nbsp;<input type="text" name="AEPeriodID" size="25" maxlength="100" placeholder = "One Quarter Only">
    </td>
    </tr>
 	</table>
</div><br /><br>
	<table>
	<tr></tr>
	</table>

</td>
</tr>
</table>
Enter email id (id's - comma separated) for which execution report needs to be sent: <input type="text" name="emailid" size="25" maxlength="100"  required placeholder="Email Address" style="color: #C0C0C0;"> <br> <br>
<input type ="Submit" value="Submit" class="glossy" id="custommessage" >    
<!-- <img id="loader" src="ajax-loader.gif" style="display: none;" /> -->

</form>	
            	
        </div>        
        
 <!---------------------------------------------------- Cube Validations ---------------------------------------------------------------------------------->          
        <div id="CubeValidations" class="tab">
            	<br>
<p id="nav" align="right">            	
<a class="hyperlinkblock3" href="ReportDownload?fileId=CV" target="_blank">Download Latest Execution report</a> </p><br>
<!-- <table><tr height="150"><td height="150"></td></tr></table>	 -->

<form name="CubeValidationsForm"  action="CubeMapNRun"  method="post">
<table>
<tr>
<td>
</td>
<td>
</td>
<td>
<!--  Bookings Cube -->
<a class="hyperlinkblock" id="BookingsCubeCV" href="javascript:ExpandCollapaseBookingsCubeCV();" >Bookings Cube</a> 
<div class="container" id="BookingsCubeCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="togglebookingCubeCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="BookingsCubeCV" value="TC001_Net_Bookings_Product_Cisco"/> TC001_Net_Bookings_Product_Cisco<br />
    <input type="checkbox" name="BookingsCubeCV" value="TC002_Net_Bookings_Product_Total_Cisco"/> TC002_Net_Bookings_Product_Total_Cisco <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC003_Net_Bookings_Service" /> TC003_Net_Bookings_Service <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC004_Net_Bookings_Product_Cisco_EBE" /> TC004_Net_Bookings_Product_Cisco_EBE <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC005_Net_Bookings_Product_Cisco_IBE" /> TC005_Net_Bookings_Product_Cisco_IBE <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC006_Net_Bookings_Product_Cisco_SL1" /> TC006_Net_Bookings_Product_Cisco_SL1 <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC007_Net_Bookings_Product_Cisco_Software" /> TC007_Net_Bookings_Product_Cisco_Software <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC008_Net_Bookings_Product_Total_Cisco_EBE" /> TC008_Net_Bookings_Product_Total_Cisco_EBE <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC009_Net_Bookings_Product_Total_Cisco_IBE" /> TC009_Net_Bookings_Product_Total_Cisco_IBE <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC010_Net_Bookings_Product_Total_Cisco_SL1" /> TC010_Net_Bookings_Product_Total_Cisco_SL1 <br />
    <input type="checkbox" name="BookingsCubeCV" value="TC011_Net_Bookings_Product_Total_Cisco_Software" /> TC011_Net_Bookings_Product_Total_Cisco_Software <br />
   
    <td>
    </td>
    <td>
    </td>
    <td>
   Financial Year=&nbsp;
   		<select class="selectClass" name="BookingsCubeCVFinancialYear" id="BookingsCubeCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="BookingsCubeCVMonth" id="BookingsCubeCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="BookingsCubeCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
    
    </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigBookingsCube">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigBookingsCube" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>


<!--  Bookings Cube vs BO -->
<a class="hyperlinkblock" id="BookingsCubevsBOCV" href="javascript:ExpandCollapaseBookingsCubevsBOCV();" >Bookings Cube vs BO</a> 
<div class="container" id="BookingsCubevsBOCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="togglebookingCubevsBOCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="BookingsCubevsBOCV" value="TC001_Net_Bookings_Product_Cisco"/> TC001_Net_Bookings_Product_Cisco<br />
    <input type="checkbox" name="BookingsCubevsBOCV" value="TC002_Net_Bookings_Product_Total_Cisco"/> TC002_Net_Bookings_Product_Total_Cisco <br />
    <input type="checkbox" name="BookingsCubevsBOCV" value="TC003_Net_Bookings_Service" /> TC003_Net_Bookings_Service <br />
    <input type="checkbox" name="BookingsCubevsBOCV" value="TC004_Prod_Book_EBE" /> TC004_Prod_Book_EBE <br />
    <input type="checkbox" name="BookingsCubevsBOCV" value="TC005_Prod_Book_IBE" /> TC005_Prod_Book_IBE <br />
    <input type="checkbox" name="BookingsCubevsBOCV" value="TC006_Prod_Book_SL1" /> TC006_Prod_Book_SL1 <br />
    <input type="checkbox" name="BookingsCubevsBOCV" value="TC007_Prod_Book_SW" /> TC007_Prod_Book_SW <br />
	
   
    <td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="BookingsCubevsBOCVFinancialYear" id="BookingsCubevsBOCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="BookingsCubevsBOCVMonth" id="BookingsCubevsBOCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="BookingsCubevsBOCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
    <td>TD:&nbsp;<input type="text" name="BookingsCubevsBOCVTDPeriod" size="12" maxlength="600" placeholder="TDPeriod"> </td>
    </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigBookingsCubevsBO">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigBookingsCubevsBO" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />

	<table>
	<tr></tr>
	</table>
<!--  L3 Validations -->
<a class="hyperlinkblock" id="L3ValidationsCV" href="javascript:ExpandCollapaseL3ValidationsCV();" >L3 Validations</a> 
<div class="container" id="L3ValidationsCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleL3ValidationsCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="L3ValidationsCV" value="TC001_Net_Revenue_L3Validation_CubeVsBO"/> TC001_Net_Revenue_L3Validation_CubeVsBO<br />
    <input type="checkbox" name="L3ValidationsCV" value="TC002_Net_Cost_L3Validation_CubeVsBO"/> TC002_Net_Cost_L3Validation_CubeVsBO<br />
    <input type="checkbox" name="L3ValidationsCV" value="TC003_Net_Revenue_TCP_L3Validation_CubeVsBO"/> TC003_Net_Revenue_TCP_L3Validation_CubeVsBO<br />
    <input type="checkbox" name="L3ValidationsCV" value="TC004_Net_Cost_TCP_L3Validation_CubeVsBO"/> TC004_Net_Cost_TCP_L3Validation_CubeVsBO<br />
    <td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="L3ValidationsCVFinancialYear" id="L3ValidationsCVFinancialYear">
   			<option value="none">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="L3ValidationsCVMonth" id="L3ValidationsCVMonth">
			<option value="none">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	 	<td>TD:&nbsp;<input type="text" name="L3ValidationsCVTDPeriod" size="12" maxlength="600" placeholder="TDPeriod"> </td>
	</tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigL3Validations">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigL3Validations" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />

	<table>
	<tr></tr>
	</table>

<!--  Expense Actual -->
<a class="hyperlinkblock" id="ExpenseActualCV" href="javascript:ExpandCollapaseExpenseActualCV();" >Expense Actual</a> 
<div class="container" id="ExpenseActualCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleexpenseactualCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="ExpenseActualCV" value="TC001_Expense_Actual_ByHL"/> TC001_Expense_Actual_ByHL<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC002_Expense_Actual_ByView"/> TC002_Expense_Actual_ByView<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC003_Expense_Actual_ByTotalPL"/> TC003_Expense_Actual_ByTotalPL<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC004_Expense_Actual_ByScenario"/> TC004_Expense_Actual_ByScenario<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC005_Expense_Actual_ByProject"/> TC005_Expense_Actual_ByProject<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC006_Expense_Actual_ByGeography"/> TC006_Expense_Actual_ByGeography<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC007_Expense_Actual_ATBFX_ByGeo"/> TC007_Expense_Actual_ATBFX_ByGeo<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC008_Expense_Actual_ATBFX_ByDept"/> TC008_Expense_Actual_ATBFX_ByDept<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC009_Expense_Actual_ByDepreciationType"/> TC009_Expense_Actual_ByDepreciationType <br />
	<input type="checkbox" name="ExpenseActualCV" value="TC010_Expense_Actual_ByDepartment"/> TC010_Expense_Actual_ByDepartment<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC011_Expense_Actual_ByCurrency"/> TC011_Expense_Actual_ByCurrency<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC012_Expense_Actual_ByGeo"/> TC012_Expense_Actual_ByGeo<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC013_Expense_Actual_ByDept"/> TC013_Expense_Actual_ByDept<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC014_Expense_AssetAddition_ByView"/> TC014_Expense_AssetAddition_ByView <br />
	<input type="checkbox" name="ExpenseActualCV" value="TC015_Expense_AssetAddition_ByProject"/> TC015_Expense_AssetAddition_ByProject<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC016_Expense_AssetAddition_ByHL"/> TC016_Expense_AssetAddition_ByHL<br />
	<input type="checkbox" name="ExpenseActualCV" value="TC017_Expense_AssetAddition_ByGeography"/> TC017_Expense_AssetAddition_ByGeography <br />
	<input type="checkbox" name="ExpenseActualCV" value="TC018_Expense_AssetAddition_ByDepartment"/> TC018_Expense_AssetAddition_ByDepartment<br />
   
    <td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="ExpenseActualCVFinancialYear" id="ExpenseActualCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="ExpenseActualCVMonth" id="ExpenseActualCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="ExpenseActualCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
    </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigExpenseActualCV">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigExpenseActualCV" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />

	<table>
	<tr></tr>
	</table>
	


<!--  Expense Allocated -->
<a class="hyperlinkblock" id="ExpenseAllocatedCV" href="javascript:ExpandCollapaseExpenseAllocatedCV();" >Expense Allocated</a> 
<div class="container" id="ExpenseAllocatedCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleexpenseallocatedCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC001_Expense_Allocated_ByBE"/> TC001_Expense_Allocated_ByBE<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC002_Expense_Allocated_ByDept"/> TC002_Expense_Allocated_ByDept<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC003_Expense_Allocated_ByGeo"/> TC003_Expense_Allocated_ByGeo<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC004_Expense_Allocated_BySFH"/> TC004_Expense_Allocated_BySFH<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC005_Expense_Allocated_ATBFX_ByBE"/> TC005_Expense_Allocated_ATBFX_ByBE<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC006_Expense_Allocated_ATBFX_ByDept"/> TC006_Expense_Allocated_ATBFX_ByDept<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC007_Expense_Allocated_ATBFX_ByGeo"/> TC007_Expense_Allocated_ATBFX_ByGeo<br />
	<input type="checkbox" name="ExpenseAllocatedCV" value="TC008_Expense_Allocated_ATBFX_BySFH"/> TC008_Expense_Allocated_ATBFX_BySFH<br />
	<td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="ExpenseAllocatedCVFinancialYear" id="ExpenseAllocatedCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="ExpenseAllocatedCVMonth" id="ExpenseAllocatedCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="ExpenseAllocatedCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
    </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigExpenseAllocatedCV">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigExpenseAllocatedCV" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />

	<table>
	<tr></tr>
	</table>	
	
	

<!--  Fetch -->
<a class="hyperlinkblock" id="FetchCV" href="javascript:ExpandCollapaseFetchCV();" >Fetch</a> 
<div class="container" id="FetchCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="togglefetchCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="FetchCV" value="TC001_Fetch_ByDept"/> TC001_Fetch_ByDept<br />
	<input type="checkbox" name="FetchCV" value="TC002_Fetch_ByGeo"/> TC002_Fetch_ByGeo<br />
	<td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="FetchCVFinancialYear" id="FetchCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="FetchCVMonth" id="FetchCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="FetchCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
    </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigFetchCV">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigFetchCV" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />

	<table>
	<tr></tr>
	</table>	
	
	<!--  GL -->
<a class="hyperlinkblock" id="GLCV" href="javascript:ExpandCollapaseGLCV();" >GL</a> 
<div class="container" id="GLCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleglCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="GLCV" value="TC001_GLCube_Bal"/> TC001_GLCube_Bal<br />
	<input type="checkbox" name="GLCV" value="TC002_GLCube_IncState"/> TC002_GLCube_IncState<br />
	<td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="GLCVFinancialYear" id="GLCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="GLCVMonth" id="GLCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="GLCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
    </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigGLCV">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigGLCV" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />

	<table>
	<tr></tr>
	</table>



<!--  PNL Cube -->
<a class="hyperlinkblock" id="PNLCube" href="javascript:ExpandCollapasePNLCV();" >PNL Cube</a> 
<div class="container" id="PNLCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="togglePNLCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="PNLCubeCV" value="TC001_Net_COGS_Product_Cisco"/> TC001_Net_COGS_Product_Cisco<br />
    <input type="checkbox" name="PNLCubeCV" value="TC002_Net_COGS_Product_Total_Cisco"/> TC002_Net_COGS_Product_Total_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC003_Net_COGS_Service_Cisco" /> TC003_Net_COGS_Service_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC004_Net_COGS_Service_Total_Cisco" /> TC004_Net_COGS_Service_Total_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC005_Net_Revenue_Product_Cisco" /> TC005_Net_Revenue_Product_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC006_Net_Revenue_Product_Total_Cisco" /> TC006_Net_Revenue_Product_Total_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC007_Net_Revenue_Service_Cisco" /> TC007_Net_Revenue_Service_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC008_Net_Revenue_Service_Total_Cisco" /> TC008_Net_Revenue_Service_Total_Cisco <br />
    <input type="checkbox" name="PNLCubeCV" value="TC009_Net_COGS_Product_Cisco_EBE"/>TC009_Net_COGS_Product_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC010_Net_COGS_Product_Cisco_IBE"/>TC010_Net_COGS_Product_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC011_Net_COGS_Product_Cisco_SFH"/>TC011_Net_COGS_Product_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC012_Net_COGS_Product_Cisco_SL1"/>TC012_Net_COGS_Product_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC013_Net_COGS_Product_Cisco_Software"/>TC013_Net_COGS_Product_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC014_Net_COGS_Product_Total_Cisco_EBE"/>TC014_Net_COGS_Product_Total_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC015_Net_COGS_Product_Total_Cisco_IBE"/>TC015_Net_COGS_Product_Total_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC016_Net_COGS_Product_Total_Cisco_SFH"/>TC016_Net_COGS_Product_Total_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC017_Net_COGS_Product_Total_Cisco_SL1"/>TC017_Net_COGS_Product_Total_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC018_Net_COGS_Product_Total_Cisco_Software"/>TC018_Net_COGS_Product_Total_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC019_Net_COGS_Service_Cisco_EBE"/>TC019_Net_COGS_Service_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC020_Net_COGS_Service_Cisco_IBE"/>TC020_Net_COGS_Service_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC021_Net_COGS_Service_Cisco_SFH"/>TC021_Net_COGS_Service_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC022_Net_COGS_Service_Cisco_SL1"/>TC022_Net_COGS_Service_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC023_Net_COGS_Service_Cisco_Software"/>TC023_Net_COGS_Service_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC024_Net_COGS_Service_Total_Cisco_EBE"/>TC024_Net_COGS_Service_Total_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC025_Net_COGS_Service_Total_Cisco_IBE"/>TC025_Net_COGS_Service_Total_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC026_Net_COGS_Service_Total_Cisco_SFH"/>TC026_Net_COGS_Service_Total_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC027_Net_COGS_Service_Total_Cisco_SL1"/>TC027_Net_COGS_Service_Total_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC028_Net_COGS_Service_Total_Cisco_Software"/>TC028_Net_COGS_Service_Total_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC029_Net_Revenue_Product_Cisco_EBE"/>TC029_Net_Revenue_Product_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC030_Net_Revenue_Product_Cisco_IBE"/>TC030_Net_Revenue_Product_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC031_Net_Revenue_Product_Cisco_SFH"/>TC031_Net_Revenue_Product_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC032_Net_Revenue_Product_Cisco_SL1"/>TC032_Net_Revenue_Product_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC033_Net_Revenue_Product_Cisco_Software"/>TC033_Net_Revenue_Product_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC034_Net_Revenue_Product_Total_Cisco_EBE"/>TC034_Net_Revenue_Product_Total_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC035_Net_Revenue_Product_Total_Cisco_IBE"/>TC035_Net_Revenue_Product_Total_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC036_Net_Revenue_Product_Total_Cisco_SFH"/>TC036_Net_Revenue_Product_Total_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC037_Net_Revenue_Product_Total_Cisco_SL1"/>TC037_Net_Revenue_Product_Total_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC038_Net_Revenue_Product_Total_Cisco_Software"/>TC038_Net_Revenue_Product_Total_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC039_Net_Revenue_Service_Cisco_IBE"/>TC039_Net_Revenue_Service_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC040_Net_Revenue_Service_Cisco_SFH"/>TC040_Net_Revenue_Service_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC041_Net_Revenue_Service_Cisco_SL1"/>TC041_Net_Revenue_Service_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC042_Net_Revenue_Service_Cisco_Software"/>TC042_Net_Revenue_Service_Cisco_Software<br />
<input type="checkbox" name="PNLCubeCV" value="TC043_Net_Revenue_Service_Cisco_EBE"/>TC043_Net_Revenue_Service_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC044_Net_Revenue_Service_Total_Cisco_EBE"/>TC044_Net_Revenue_Service_Total_Cisco_EBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC045_Net_Revenue_Service_Total_Cisco_IBE"/>TC045_Net_Revenue_Service_Total_Cisco_IBE<br />
<input type="checkbox" name="PNLCubeCV" value="TC046_Net_Revenue_Service_Total_Cisco_SFH"/>TC046_Net_Revenue_Service_Total_Cisco_SFH<br />
<input type="checkbox" name="PNLCubeCV" value="TC047_Net_Revenue_Service_Total_Cisco_SL1"/>TC047_Net_Revenue_Service_Total_Cisco_SL1<br />
<input type="checkbox" name="PNLCubeCV" value="TC048_Net_Revenue_Service_Total_Cisco_Software"/>TC048_Net_Revenue_Service_Total_Cisco_Software<br />
    
   
    <td>
    </td>
    <td>
    </td>
     <td>
     Financial Year=&nbsp;
   		<select class="selectClass" name="PNLCubeCVFinancialYear" id="PNLCubeCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY10">FY10</option>
			<option value="FY11">FY11</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="PNLCubeCVMonth" id="PNLCubeCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="PNLCubeCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
   </tr>
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigPNLCubeCV">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigPNLCubeCV" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br />
	<table>
	<tr></tr>
	</table>

<!--  PNL Cube vs Revenue BO -->
<a class="hyperlinkblock" id="PNLCubevsRevenueBOCV" href="javascript:ExpandCollapasePNLCubevsRevenueBOCV();" >PNL Cube vs Revenue BO</a> 
<div class="container" id="PNLCubevsRevenueBOCVTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="togglePNLCubevsRevenueBOCV(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC001_Net_COGS_Product_Cisco"/> TC001_Net_COGS_Product_Cisco<br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC002_Net_COGS_Product_Total_Cisco"/> TC002_Net_COGS_Product_Total_Cisco <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC003_Net_Revenue_Product_Cisco" /> TC003_Net_Revenue_Product_Cisco <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC004_Net_Revenue_Product_Total_Cisco" /> TC004_Net_Revenue_Product_Total_Cisco <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC005_Net_Revenue_Service_Cisco" /> TC005_Net_Revenue_Service_Cisco <br />
    <!--  <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC006_Net_COGS_Prod_Cisco_EBE" /> TC006_Net_COGS_Prod_Cisco_EBE <br /> -->
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC007_Net_COGS_Prod_Cisco_IBE" /> TC007_Net_COGS_Prod_Cisco_IBE <br /> 
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC008_Net_COGS_Prod_Cisco_SFH" /> TC008_Net_COGS_Prod_Cisco_SFH <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC009_Net_COGS_Prod_Cisco_SL1" /> TC009_Net_COGS_Prod_Cisco_SL1 <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC010_Net_COGS_Prod_Cisco_SW" /> TC010_Net_COGS_Prod_Cisco_SW <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC011_Net_Revenue_Prod_Cisco_EBE" /> TC011_Net_Revenue_Prod_Cisco_EBE <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC012_Net_Revenue_Prod_Cisco_IBE" /> TC012_Net_Revenue_Prod_Cisco_IBE <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC013_Net_Revenue_Prod_Cisco_SFH" /> TC013_Net_Revenue_Prod_Cisco_SFH <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC014_Net_Revenue_Prod_Cisco_SL1" /> TC014_Net_Revenue_Prod_Cisco_SL1 <br />
    <input type="checkbox" name="PNLCubevsRevenueBOCV_TC" value="TC015_Net_Revenue_Prod_Cisco_SW" /> TC015_Net_Revenue_Prod_Cisco_SW <br />
    
    </td>
    <td>
    </td>
    <td>
    </td>
    <td>
    Financial Year=&nbsp;
   		<select class="selectClass" name="PNLCubevsRevenueBOCVFinancialYear" id="PNLCubevsRevenueBOCVFinancialYear">
   			<option value="">-- Select a Year --</option>
			<option value="FY12">FY12</option>
			<option value="FY13">FY13</option>
			<option value="FY14">FY14</option>
			<option value="FY15">FY15</option>
			<option value="FY16">FY16</option>
			<option value="FY17">FY17</option>
			<option value="FY18">FY18</option>
			<option value="FY19">FY19</option>
			<option value="FY20">FY20</option>
   		</select>
    </td>
    <td>
    </td>
    <td>
       Select Starting Month : &nbsp;
       	<td>
 		<select class="selectClass" name="PNLCubevsRevenueBOCVMonth" id="PNLCubevsRevenueBOCVMonth">
			<option value="">-- Select a Month --</option>
			<option value="Jan">January</option>
			<option value="Feb">February</option>
			<option value="Mar">March</option>
			<option value="Apr">April</option>
			<option value="May">May</option>
			<option value="Jun">June</option>
			<option value="Jul">July</option>
			<option value="Aug">August</option>
			<option value="Sep">September</option>
			<option value="Oct">October</option>
			<option value="Nov">November</option>
			<option value="Dec">December</option>
	 	</select>
	 	</td> 
	<td>Number of Months:&nbsp;<input type="text" name="PNLCubevsRevenueBOCVNumOfMonths" size="12" maxlength="2" placeholder="No. of Months"> </td>
	 <td>TD:&nbsp;<input type="text" name="PNLCubevsRevenueBOCVTDPeriod" size="12" maxlength="120" placeholder="TDPeriod"> </td>  
	   
	   </tr>
	 
    <tr><td>
    <br></td></tr>
    
 	</table>
 	<table>
 	<tr><td>
     <button id="ViewCubeConfigPNLCubevsRevenueBOCV">View Current Config Details</button><br>
     <div class=""  id="showCubeConfigPNLCubevsRevenueBOCV" style="display: none"  ></div>
     </td></tr>
 	</table>
</div><br /><br>
	<table>
	<tr></tr>
	</table>
</table>
Enter email id for which execution report needs to be sent: <input type="text" name="emailid" size="25" maxlength="100"  required placeholder="Email Address" style="color: #ff0000;"> <br> <br>
<input type ="Submit" value="Submit" class="glossy" id="custommessage">
</form>
</div>

<!---------------------------------------------------- Compatibility Validations -------------------------------------------------------------------------->   
        <div id="CompatibilityValidations" class="tab">
    
        
<p id="nav" align="right" >            	

<a class="hyperlinkblock3" href="ReportDownload?fileId=ComV" target="_blank">Download Latest Execution report</a> </p>

<form name="CompatibilityForm"    action="CompatibilityMapNRun"  method="post">
<table>
<tr>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>

<!-- <div  class="streamcontainer"> -->
<!-- <b><h2>&nbsp;&nbsp;&nbsp;Bookings BO</h2></b>  -->
<h2>&nbsp;&nbsp;&nbsp;Bookings BO</h2>
<a class="hyperlinkblock" id="BookingsReportingCompatibility" href="javascript:ExpandCollapaseBookingsReportingCompatibility();" >Bookings Reporting</a> 
<div class="container" id="BookingsBOCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
<input type="checkbox" onClick="toggleBookingsReportingCompatibility(this)" /><b> Toggle All </b><br/>
<input type="checkbox" name="BookingsReportingCompatibility" value="TC001_A_CISCO_BOOKINGS"/> TC001_A_CISCO_BOOKINGS <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC001_B_CISCO_BOOKINGS"/> TC001_B_CISCO_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC001_C_CISCO_BOOKINGS"/> TC001_C_CISCO_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC002_A_TOTAL_CISCO_BOOKINGS_NET"/> TC002_A_TOTAL_CISCO_BOOKINGS_NET<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC003_A_PRODUCT_BOOKINGS"/> TC003_A_PRODUCT_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC003_B_PRODUCT_BOOKINGS"/> TC003_B_PRODUCT_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC003_C_PRODUCT_BOOKINGS"/> TC003_C_PRODUCT_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC004_A_TOTAL_CISCO_PRODUCT_BOOKINGS_NET"/> TC004_A_TOTAL_CISCO_PRODUCT_BOOKINGS_NET<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC004_B_TOTAL_CISCO_PRODUCT_BOOKINGS_NET"/> TC004_B_TOTAL_CISCO_PRODUCT_BOOKINGS_NET<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC005_A_SERVICE_BOOKINGS"/> TC005_A_SERVICE_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC005_B_SERVICE_BOOKINGS"/> TC005_B_SERVICE_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC005_C_SERVICE_BOOKINGS"/> TC005_C_SERVICE_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC006_A_UPLIFT_BOOKINGS"/> TC006_A_UPLIFT_BOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC007_A_ACQUISITION"/> TC007_A_ACQUISITION<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC008_A_ACQUISITION_NON_CISCO"/> TC008_A_ACQUISITION_NON_CISCO<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC009_A_NOT_BOOKED_MEASURES"/> TC009_A_NOT_BOOKED_MEASURES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC009_B_NOT_BOOKED_MEASURES"/> TC009_B_NOT_BOOKED_MEASURES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC010_A_NOT_BOOKED_MEASURES_HISTORY"/> TC010_A_NOT_BOOKED_MEASURES_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC010_B_NOT_BOOKED_MEASURES_HISTORY"/> TC010_B_NOT_BOOKED_MEASURES_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC011_A_CONDITIONAL_SALES"/> TC011_A_CONDITIONAL_SALES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC011_B_CONDITIONAL_SALES"/> TC011_B_CONDITIONAL_SALES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC012_A_CONDITIONAL_SALES_HISTORY"/> TC012_A_CONDITIONAL_SALES_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC013_A_SHIPMENTS"/> TC013_A_SHIPMENTS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC013_B_SHIPMENTS"/> TC013_B_SHIPMENTS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC014_A_SHIPPED_NOT_INVOICED"/> TC014_A_SHIPPED_NOT_INVOICED<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC014_B_SHIPPED_NOT_INVOICED"/> TC014_B_SHIPPED_NOT_INVOICED<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC015_A_FINANCE_BACKLOG"/> TC015_A_FINANCE_BACKLOG<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC015_B_FINANCE_BACKLOG"/> TC015_B_FINANCE_BACKLOG<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC016_A_FINANCE_BACKLOG_HISTORY"/> TC016_A_FINANCE_BACKLOG_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC016_B_FINANCE_BACKLOG_HISTORY"/> TC016_B_FINANCE_BACKLOG_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC017_A_MANUFACTURING_BACKLOG"/> TC017_A_MANUFACTURING_BACKLOG<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC017_B_MANUFACTURING_BACKLOG"/> TC017_B_MANUFACTURING_BACKLOG<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC018_A_MANUFACTURING_BACKLOG_HISTORY"/> TC018_A_MANUFACTURING_BACKLOG_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC018_B_MANUFACTURING_BACKLOG_HISTORY"/> TC018_B_MANUFACTURING_BACKLOG_HISTORY<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC019_A_DEBOOKINGS"/> TC019_A_DEBOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC019_B_DEBOOKINGS"/> TC019_B_DEBOOKINGS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC020_A_MANAGED_SERVICES"/> TC020_A_MANAGED_SERVICES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC021_A_BOOKINGS_ADJUSTMENTS"/> TC021_A_BOOKINGS_ADJUSTMENTS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC021_B_BOOKINGS_ADJUSTMENTS"/> TC021_B_BOOKINGS_ADJUSTMENTS<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC022_A_CREDIT_MEMO_RMA"/> TC022_A_CREDIT_MEMO_RMA<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC022_B_CREDIT_MEMO_RMA"/> TC022_B_CREDIT_MEMO_RMA<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC023_A_Management_Adjustments"/> TC023_A_Management_Adjustments<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC023_B_Management_Adjustments"/> TC023_B_Management_Adjustments<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC024_A_TOTAL_REBATES"/> TC024_A_TOTAL_REBATES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC024_B_TOTAL_REBATES"/> TC024_B_TOTAL_REBATES<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC025_A_OA_BundleID_Bookings"/> TC025_A_OA_BundleID_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC025_B_OA_BundleID_Bookings"/> TC025_B_OA_BundleID_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC026_A_ON_SN_Bookings"/> TC026_A_ON_SN_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC026_B_ON_SN_Bookings"/> TC026_B_ON_SN_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC026_C_ON_SN_Bookings"/> TC026_CA_ON_SN_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC027_A_RTM_CiscoBookings"/> TC027_A_RTM_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC028_A_OA_POSReports_Bookings"/> TC028_A_OA_POSReports_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC028_B_RTM_CiscoBookings"/> TC028_B_RTM_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC029_A_BGM"/> TC029_A_BGM<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC029_B_BGM"/> TC029_B_BGM<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC029_C_BGM"/> TC029_C_BGM<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC030_A_Sales_Order_Notes_Number_TCH"/> TC030_A_Sales_Order_Notes_Number_TCH<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC030_B_Sales_Order_Notes_Number_TCH"/> TC030_B_Sales_Order_Notes_Number_TCH<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC031_A_XAAS_ATTRIBUTE"/> TC031_A_XAAS_ATTRIBUTE<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC032_A_GlobalVirtualSales"/> TC032_A_GlobalVirtualSales<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC032_B_GlobalVirtualSales"/> TC032_B_GlobalVirtualSales<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC032_C_GlobalVirtualSales"/> TC032_C_GlobalVirtualSales<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC033_A_SaaS_Attributes"/> TC033_A_SaaS_Attributes<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC034_A_FCM_Bookings"/> TC034_A_FCM_Bookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC034_B_FCM_Bookings"/> TC034_B_FCM_Bookings <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_A_OEHieararchy_CiscoBookings"/> TC035_A_OEHieararchy_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_B_OEHieararchy_ProductBookings"/> TC035_B_OEHieararchy_ProductBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_C_OEHieararchy_BookingsGM"/> TC035_C_OEHieararchy_BookingsGM<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_D_OEHieararchy_ServiceBookings"/> TC035_D_OEHieararchy_ServiceBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_E_OEHieararchy_BookingsAdj"/> TC035_E_OEHieararchy_BookingsAdj<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_F_OEHieararchy_CMRMA"/> TC035_F_OEHieararchy_CMRMA <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_G_OEHieararchy_BookingsNBM"/> TC035_G_OEHieararchy_BookingsNBM <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_H_OEHieararchy_CondSales"/> TC035_H_OEHieararchy_CondSales <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_I_OEHieararchy_Shipments"/> TC035_I_OEHieararchy_Shipments<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC035_J_OEHieararchy_ShippingNotInv"/> TC035_J_OEHieararchy_ShippingNotInv<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC036_A_POE_CiscoBookings"/> TC036_A_POE_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC036_B_POE_CiscoBookings"/> TC036_B_POE_CiscoBookings <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC036_C_POE_CiscoBookings"/> TC036_C_POE_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC037_A_CSC_CiscoBookings"/> TC037_A_CSC_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC037_B_CSC_CiscoBookings"/> TC037_B_CSC_CiscoBookings<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC038_A_Enterprise_SKU"/> TC038_A_Enterprise_SKU<br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC038_B_Enterprise_SKU"/> TC038_B_Enterprise_SKU <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC039_A_Attribution_SubSKU"/> TC039_A_Attribution_SubSKU <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC040_A_DSV_EnableSO"/> TC040_A_DSV_EnableSO <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC041_A_CiscoBGM"/> TC041_A_CiscoBGM <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC042_A_POSEnrichment"/> TC042_A_POSEnrichment <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC042_B_POSEnrichment"/> TC042_B_POSEnrichment <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC043_A_New_Renewal"/> TC043_A_New_Renewal <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC044_A_SalesMotionContext"/> TC044_A_SalesMotionContext <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC045_A_SubscriptionDetails"/> TC045_A_SubscriptionDetails <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC045_B_SubscriptionDetails"/> TC045_B_SubscriptionDetails <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC046_A_MLB"/> TC046_A_MLB <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC046_B_MLB"/> TC046_B_MLB <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC046_C_MLB"/> TC046_C_MLB <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC047_A_POSEnrichment"/> TC047_A_POSEnrichment <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC047_B_POSEnrichment"/> TC047_B_POSEnrichment <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC048_A_Distributors"/> TC048_A_Distributors <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC048_B_Distributors"/> TC048_B_Distributors <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC048_C_Distributors"/> TC048_C_Distributors <br />
<input type="checkbox" name="BookingsReportingCompatibility" value="TC049_A_SBPAttributes"/> TC049_A_SBPAttributes <br />




	</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	
<a class="hyperlinkblock" id="BookingsCAServiceReportingCompatibility" href="javascript:ExpandCollapaseBookingsCAServiceReportingCompatibility();" >CA Service Reporting</a> 
<div class="container" id="BookingsCAServiceReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleBookingsCAServiceReportingCompatibility(this)" /><b> Toggle All </b><br/>
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC001_A_CA_SERVICE_REPORTING"/>TC001_A_CA_SERVICE_REPORTING<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC002_A_CA_SERVICE_ADJUSTMENTS"/>TC002_A_CA_SERVICE_ADJUSTMENTS<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC002_B_CA_SERVICE_ADJUSTMENTS"/>TC002_B_CA_SERVICE_ADJUSTMENTS<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC003_A_CA_SERVICE_NOT_BOOKED_MEASURES"/>TC003_A_CA_SERVICE_NOT_BOOKED_MEASURES<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC004_A_CA_SERVICE_NOT_BOOKED_MEASURES_HISTORY"/>TC004_A_CA_SERVICE_NOT_BOOKED_MEASURES_HISTORY<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC005_A_CA_SERVICE_POS"/>TC005_A_CA_SERVICE_POS<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC006_A_CA_SERVICE_NET_POS_MEASURES"/>TC006_A_CA_SERVICE_NET_POS_MEASURES<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC007_A_CA_SERVICE_MS_POS_MEASURES"/>TC007_A_CA_SERVICE_MS_POS_MEASURES<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC008_A_CA_SERVICE_SALES_AT_POS_WPL"/>TC008_A_CA_SERVICE_SALES_AT_POS_WPL<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC009_A_CA_SERVICE_CONDITIONAL_SALES"/>TC009_A_CA_SERVICE_CONDITIONAL_SALES<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC010_A_CA_SERVICE_CONDITIONAL_SALES_HISTORY"/>TC010_A_CA_SERVICE_CONDITIONAL_SALES_HISTORY<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC011_A_CA_SERVICE_FINANCE_BACKLOG"/>TC011_A_CA_SERVICE_FINANCE_BACKLOG<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC012_A_CA_SERVICE_FINANCE_BACKLOG_HISTORY"/>TC012_A_CA_SERVICE_FINANCE_BACKLOG_HISTORY<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC013_A_CA_SERVICE_MANUFACTURING_BACKLOG"/>TC013_A_CA_SERVICE_MANUFACTURING_BACKLOG<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC014_A_CA_SERVICE_MANUFACTURING_BACKLOG_HISTORY"/>TC014_A_CA_SERVICE_MANUFACTURING_BACKLOG_HISTORY<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC015_A_CA_SERVICE_ACQUISITION_NON_CISCO"/>TC015_A_CA_SERVICE_ACQUISITION_NON_CISCO<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC016_A_CA_SERVICE_REPORTING_DEMO"/>TC016_A_CA_SERVICE_REPORTING_DEMO<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC016_B_CA_SERVICE_REPORTING_DEMO"/>TC016_B_CA_SERVICE_REPORTING_DEMO<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC017_A_CA_SERVICE_OA_BundlePID"/>TC017_A_CA_SERVICE_OA_BundlePID<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC018_A_CA_SERVICE_ON_SN"/>TC018_A_CA_SERVICE_ON_SN<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC019_A_CA_SERVICE_REPORTING_DSV_Allocated"/>TC019_A_CA_SERVICE_REPORTING_DSV_Allocated<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC019_B_CA_SERVICE_REPORTING_DSV_Allocated"/>TC019_B_CA_SERVICE_REPORTING_DSV_Allocated<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC019_C_CA_SERVICE_REPORTING_DSV_Allocated"/>TC019_C_CA_SERVICE_REPORTING_DSV_Allocated<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC019_D_CA_SERVICE_REPORTING_DSV_Allocated"/>TC019_D_CA_SERVICE_REPORTING_DSV_Allocated<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC020_A_CA_SERVICE_REPORTING_DSV_Bookings"/>TC020_A_CA_SERVICE_REPORTING_DSV_Bookings<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC020_B_CA_SERVICE_REPORTING_DSV_Bookings"/>TC020_B_CA_SERVICE_REPORTING_DSV_Bookings<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC020_C_CA_SERVICE_REPORTING_DSV_Bookings"/>TC020_C_CA_SERVICE_REPORTING_DSV_Bookings<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC020_D_CA_SERVICE_REPORTING_DSV_Bookings"/>TC020_D_CA_SERVICE_REPORTING_DSV_Bookings<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC021_RTM_Bookings"/>TC021_RTM_Bookings<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC022_A_CA_SERVICE_REPORTING_Services_Annualized_1"/>TC022_A_CA_SERVICE_REPORTING_Services_Annualized_1<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC022_A_CA_SERVICE_REPORTING_Services_Annualized_2"/>TC022_A_CA_SERVICE_REPORTING_Services_Annualized_2<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC022_A_CA_SERVICE_REPORTING_Services_Annualized_3"/>TC022_A_CA_SERVICE_REPORTING_Services_Annualized_3<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC023_A_CA_SERVICE_REPORTING_Services_Annualized"/>TC023_A_CA_SERVICE_REPORTING_Services_Annualized<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC024_A_CA_SERVICE_REPORTING_CONTRACT_CONV"/>TC024_A_CA_SERVICE_REPORTING_CONTRACT_CONV<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC025_A_CA_SERVICE_ANNUALIZED_"/>TC025_A_CA_SERVICE_ANNUALIZED_<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC025_A_CA_SERVICE_ANNUALIZED_REPORTING"/>TC025_A_CA_SERVICE_ANNUALIZED_REPORTING<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC025_B_CA_SERVICE_ANNUALIZED"/>TC025_B_CA_SERVICE_ANNUALIZED<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC026_A_Sales_Order_Notes_Number"/>TC026_A_Sales_Order_Notes_Number<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC026_B_Sales_Order_Notes_Number"/>TC026_B_Sales_Order_Notes_Number<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC027_A_XAAS_ATTRIBUTES"/>TC027_A_XAAS_ATTRIBUTES<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC028_A_SERVICEANNUALIZED"/>TC028_A_SERVICEANNUALIZED<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC028_B_SERVICEANNUALIZED"/>TC028_B_SERVICEANNUALIZED<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC028_C_SERVICEANNUALIZED"/>TC028_C_SERVICEANNUALIZED<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC028_D_SERVICEANNUALIZED"/>TC028_D_SERVICEANNUALIZED<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC028_E_SERVICEANNUALIZED"/>TC028_E_SERVICEANNUALIZED<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC029_A_TCH_SalesOrderNote"/>TC029_A_TCH_SalesOrderNote<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC030_A_CAService_EnableTSBkngsProdBE"/>TC030_A_CAService_EnableTSBkngsProdBE<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC031_A_CAService_POE"/>TC031_A_CAService_POE<br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC031_B_CAService_POE"/>TC031_B_CAService_POE <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC032_A_CAService_OE"/>TC032_A_CAService_OE <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC032_B_CAService_OE"/>TC032_B_CAService_OE <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC032_C_CAService_OE"/>TC032_C_CAService_OE <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC033_A_CAService_CSC"/>TC033_A_CAService_CSC <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC033_B_CAService_CSC"/>TC033_B_CAService_CSC <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC034_A_CAService_ASBGM"/>TC034_A_CAService_ASBGM <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC034_B_CAService_ASBGM"/>TC034_B_CAService_ASBGM <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC035_A_Enterprise_SKU"/>TC035_A_Enterprise_SKU <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC037_A_CAService_ASBGM"/>TC037_A_CAService_ASBGM <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC038_A_CAService_TSSDiscounts"/>TC038_A_CAService_TSSDiscounts <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC039_B_CAService_ASBGM"/>TC039_B_CAService_ASBGM <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC040_A_POSEnrichment"/>TC040_A_POSEnrichment <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC040_B_POSEnrichment"/>TC040_B_POSEnrichment <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC041_A_New_Renew"/>TC041_A_New_Renew <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC041_B_New_Renew"/>TC041_B_New_Renew <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC042_A_SubscriptionDetails"/>TC042_A_SubscriptionDetails <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC043_A_POSEnrichment"/>TC043_A_POSEnrichment <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC043_B_POSEnrichment"/>TC043_B_POSEnrichment <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC044_A_Distributors"/>TC044_A_Distributors <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC044_B_Distributors"/>TC044_B_Distributors <br />
<input type="checkbox" name="BookingsCAServiceReportingCompatibility" value="TC045_A_SBPAttributes"/>TC045_A_SBPAttributes <br />



	</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	
<a class="hyperlinkblock" id="BookingsChannelsReportingCompatibility" href="javascript:ExpandCollapaseBookingsChannelsReportingCompatibility();" >Channels Reporting</a> 
<div class="container" id="BookingsChannelsReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleBookingsChannelsReportingCompatibility(this)" /><b> Toggle All </b><br/><input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC001_A_Inventory"/>TC001_A_Inventory<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC002_A_POS"/>TC002_A_POS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC002_B_POS"/>TC002_B_POS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC003_A_NET_POS_MEASURES"/>TC003_A_NET_POS_MEASURES<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC004_A_MS_POS_MEASURES"/>TC004_A_MS_POS_MEASURES<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC004_B_MS_POS_MEASURES"/>TC004_B_MS_POS_MEASURES<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC005_A_POS_WPL"/>TC005_A_POS_WPL<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC005_B_POS_WPL"/>TC005_B_POS_WPL<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC006_A_ALLOCATED_POS"/>TC006_A_ALLOCATED_POS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC006_B_ALLOCATED_POS"/>TC006_B_ALLOCATED_POS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC007_A_POS_WPL_GPL"/>TC007_A_POS_WPL_GPL<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC007_B_POS_WPLGPL"/>TC007_B_POS_WPLGPL<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC008_A_CTMP_RELATED_RMA"/>TC008_A_CTMP_RELATED_RMA<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC008_B_CTMP_RELATED_RMA"/>TC008_B_CTMP_RELATED_RMA<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC009_A_INVALID_CLAIMS"/>TC009_A_INVALID_CLAIMS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC010_A_CLAIMS"/>TC010_A_CLAIMS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC011_A_CLAIM_SPLITS"/>TC011_A_CLAIM_SPLITS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC012_A_REBATES_GENERATED"/>TC012_A_REBATES_GENERATED<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC013_OA_BunPID_ChannelsReporting"/>TC013_OA_BunPID_ChannelsReporting<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC014_A_DSV_BOOKINGS"/>TC014_A_DSV_BOOKINGS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC014_B_DSV_BOOKINGS"/>TC014_B_DSV_BOOKINGS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC015_ON_SN_ChannelsReporting"/>TC015_ON_SN_ChannelsReporting<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC016_A_DSVALLOCATED_BOOKINGS"/>TC016_A_DSVALLOCATED_BOOKINGS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC016_B_DSVALLOCATED_BOOKINGS"/>TC016_B_DSVALLOCATED_BOOKINGS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC017_DSV_BOOKINGS"/>TC017_DSV_BOOKINGS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC018_RTM_Bookings"/>TC018_RTM_Bookings<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC019_DSVBacklog_Bookings_Timehirearchy"/>TC019_DSVBacklog_Bookings_Timehirearchy<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC020_DSVbacklog_Bookings_productHirearchy"/>TC020_DSVbacklog_Bookings_productHirearchy<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC021_DSVBacklog_Bookings_BEhirearchy"/>TC021_DSVBacklog_Bookings_BEhirearchy<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC022_DSVBacklog_Bookings_Customer"/>TC022_DSVBacklog_Bookings_Customer<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC023_DSVBacklog_Bookings_SalesHIrearchy"/>TC023_DSVBacklog_Bookings_SalesHIrearchy<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC024_DSVBacklog_Bookings_ERPCustomer"/>TC024_DSVBacklog_Bookings_ERPCustomer<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC025_A_Sales_Order_Notes_Number_TCH"/>TC025_A_Sales_Order_Notes_Number_TCH<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC026_A_XAAS_ATTRIBUTES"/>TC026_A_XAAS_ATTRIBUTES<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC027_A_SaaS_Attributes"/>TC027_A_SaaS_Attributes<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC028_A_OE_Hierarchies"/>TC028_A_OE_Hierarchies<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC028_B_OE_Hierarchies"/>TC028_B_OE_Hierarchies<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC028_C_OE_Hierarchies"/>TC028_C_OE_Hierarchies<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC028_D_OE_Hierarchies"/>TC028_D_OE_Hierarchies<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC028_E_OE_Hierarchies"/>TC028_E_OE_Hierarchies<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC028_F_OE_Hierarchies"/>TC028_F_OE_Hierarchies<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC029_A_POE_ChannelsReporting"/>TC029_A_POE_ChannelsReporting<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC029_B_POE_ChannelsReporting"/>TC029_B_POE_ChannelsReporting<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC030_A_CSC_ChannelsReporting"/>TC030_A_CSC_ChannelsReporting<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC031_A_Enterprise_SKU"/>TC031_A_Enterprise_SKU<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC032_A_DSVReporting_EnablePONumber"/>TC032_A_DSVReporting_EnablePONumber<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC033_A_AbilitytodistinguishtheAttributionSubSKU"/>TC033_A_AbilitytodistinguishtheAttributionSubSKU<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC034_A_POSEnrichment"/>TC034_A_POSEnrichment<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC034_B_POSEnrichment"/>TC034_B_POSEnrichment<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC035_A_New_Renew_POS"/>TC035_A_New_Renew_POS<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC035_A_New_Renew"/>TC035_A_New_Renew<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC036_A_SubscriptionDetails"/>TC036_A_SubscriptionDetails<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC037_A_MLB"/>TC037_A_MLB<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC038_A_POSEnrichment"/>TC038_A_POSEnrichment<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC038_B_POSEnrichment"/>TC038_B_POSEnrichment<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC039_A_Distributors"/>TC039_A_Distributors<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC039_B_Distributors"/>TC039_B_Distributors<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC039_C_Distributors"/>TC039_C_Distributors<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC040_A_SBPAttributes"/>TC040_A_SBPAttributes<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC041_A_DSV"/>TC041_A_DSV<br />
<input type="checkbox" name="BookingsChannelsReportingCompatibility" value="TC041_B_DSV"/>TC041_B_DSV<br />



	</td>
	</tr>
	</table>
	</div> <br>	
	<table>
	<tr></tr>
	</table>
	
	<a class="hyperlinkblock" id="CommonObjects" href="javascript:ExpandCollapaseCommonObjects();" >Common Objects</a> 
	<div class="container" id="CommonObjectsTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleCommonObjects(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="CommonObjects" value="TC001_A_NEW_RENEW"/>TC001_A_NEW_RENEW<br />
<input type="checkbox" name="CommonObjects" value="TC001_B_NEW_RENEW"/>TC001_B_NEW_RENEW<br />
<input type="checkbox" name="CommonObjects" value="TC001_C_NEW_RENEW"/>TC001_C_NEW_RENEW<br />
<input type="checkbox" name="CommonObjects" value="TC002_A_INSTANCE_LEVEL"/>TC002_A_INSTANCE_LEVEL<br />
<input type="checkbox" name="CommonObjects" value="TC003_A_SALESMOTIONCONTEXT"/>TC003_A_SALESMOTIONCONTEXT<br />
<input type="checkbox" name="CommonObjects" value="TC004_A_POSEnrichment"/>TC004_A_POSEnrichment<br />
<input type="checkbox" name="CommonObjects" value="TC004_B_POSEnrichment"/>TC004_B_POSEnrichment<br />
<input type="checkbox" name="CommonObjects" value="TC004_C_POSEnrichment"/>TC004_C_POSEnrichment<br />
<input type="checkbox" name="CommonObjects" value="TC004_D_POSEnrichment"/>TC004_D_POSEnrichment<br />
<input type="checkbox" name="CommonObjects" value="TC005_A_SBPAttributesReporting"/>TC005_A_SBPAttributesReporting<br />
<input type="checkbox" name="CommonObjects" value="TC005_B_SBPAttributesReporting"/>TC005_B_SBPAttributesReporting<br />
<input type="checkbox" name="CommonObjects" value="TC005_C_SBPAttributesReporting"/>TC005_C_SBPAttributesReporting<br />
<input type="checkbox" name="CommonObjects" value="TC005_D_SBPAttributesReporting"/>TC005_D_SBPAttributesReporting<br />

</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	<a class="hyperlinkblock" id="ServicePnD" href="javascript:ExpandCollapaseServicePnD();" >ServicePnD</a> 
	<div class="container" id="ServicePnDTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleServicePnD(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="ServicePnD" value="TC001_A_INSTANCE_LEVEL"/>TC001_A_INSTANCE_LEVEL<br />
<input type="checkbox" name="ServicePnD" value="TC001_A_POS_ENRICHMENT"/>TC001_A_POS_ENRICHMENT<br />


</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	
	<a class="hyperlinkblock" id="BookingsTMSReportingCompatibility" href="javascript:ExpandCollapaseBookingsTMSReportingCompatibility();" >TMS Reporting</a> 
	<div class="container" id="BookingsTMSReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleBookingsTMSReportingCompatibility(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC001_A_TMS_Corp_Allocated_Bookings"/>TC001_A_TMS_Corp_Allocated_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC001_B_TMS_Corp_Allocated_Bookings"/>TC001_B_TMS_Corp_Allocated_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC001_C_TMS_Corp_Allocated_Bookings"/>TC001_C_TMS_Corp_Allocated_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC002_A_TMS_Corp_Allocated_TotalCisco_Bookings_Net"/>TC002_A_TMS_Corp_Allocated_TotalCisco_Bookings_Net<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC003_A_TMS_Corp_Allocated_Product_Bookings"/>TC003_A_TMS_Corp_Allocated_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC003_B_TMS_Corp_Allocated_Product_Bookings"/>TC003_B_TMS_Corp_Allocated_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC003_C_TMS_Corp_Allocated_Product_Bookings"/>TC003_C_TMS_Corp_Allocated_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC004_A_TMS_Corp_Allocated_Total_Product_Bookings"/>TC004_A_TMS_Corp_Allocated_Total_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC004_B_TMS_Corp_Allocated_Total_Product_Bookings"/>TC004_B_TMS_Corp_Allocated_Total_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC005_A_OA_BundleID_TMS_Corp_Allocated"/>TC005_A_OA_BundleID_TMS_Corp_Allocated<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC005_B_OA_BundleID_TMS_Corp_Allocated"/>TC005_B_OA_BundleID_TMS_Corp_Allocated<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC005_C_OA_BundleID_TMS_Corp_Allocated"/>TC005_C_OA_BundleID_TMS_Corp_Allocated<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC006_A_ON_SN_TMS_Corp_Allocated"/>TC006_A_ON_SN_TMS_Corp_Allocated<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC006_B_ON_SN_TMS_Corp_Allocated"/>TC006_B_ON_SN_TMS_Corp_Allocated<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC006_C_ON_SN_TMS_Corp_Allocated"/>TC006_C_ON_SN_TMS_Corp_Allocated<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC007_A_DSVBkngsListBkngs__DSV_Bkngs_TMS_Corp"/>TC007_A_DSVBkngsListBkngs__DSV_Bkngs_TMS_Corp<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC007_B_DSVBkngsListBkngs__DSV_Bkngs_TMS_Corp"/>TC007_B_DSVBkngsListBkngs__DSV_Bkngs_TMS_Corp<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC008_DSV_Bkngs_TMS_Corp"/>TC008_DSV_Bkngs_TMS_Corp<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC009_A_RTM_TMS_Corp"/>TC009_A_RTM_TMS_Corp<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC010_A_TCH_Sales_Order_Notes_Number"/>TC010_A_TCH_Sales_Order_Notes_Number<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC010_B_TCH_Sales_Order_Notes_Number"/>TC010_B_TCH_Sales_Order_Notes_Number<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC011_A_TMS_TMSCorp_Subscription"/>TC011_A_TMS_TMSCorp_Subscription<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC011_B_TMS_TMSCorp_Subscription"/>TC011_B_TMS_TMSCorp_Subscription<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC012_A_TMSCorp_EnableTSBkngsProdBE"/>TC012_A_TMSCorp_EnableTSBkngsProdBE<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC013_A_TMSCorp_OEHierarchy"/>TC013_A_TMSCorp_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC013_B_TMSCorp_OEHierarchy"/>TC013_B_TMSCorp_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC013_C_TMSCorp_OEHierarchy"/>TC013_C_TMSCorp_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC013_D_TMSCorp_OEHierarchy"/>TC013_D_TMSCorp_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC013_E_TMSCorp_OEHierarchy"/>TC013_E_TMSCorp_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC014_A_TMSCorp_POE"/>TC014_A_TMSCorp_POE<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC014_B_TMSCorp_POE"/>TC014_B_TMSCorp_POE<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC014_C_TMSCorp_POE"/>TC014_C_TMSCorp_POE<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC014_D_TMSCorp_POE"/>TC014_D_TMSCorp_POE<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC015_A_Enterprise_SKU"/>TC015_A_Enterprise_SKU<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC016_A_POSEnrichment"/>TC016_A_POSEnrichment<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC016_B_POSEnrichment"/>TC016_B_POSEnrichment<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC017_A_New_Renew"/>TC017_A_New_Renew<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC017_B_New_Renew"/>TC017_B_New_Renew<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC018_A_SubscriptionDetails"/>TC018_A_SubscriptionDetails<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC018_B_SubscriptionDetails"/>TC018_B_SubscriptionDetails<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC019_A_MLB"/>TC019_A_MLB<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC019_B_MLB"/>TC019_B_MLB<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC020_A_Distributors"/>TC020_A_Distributors<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC020_B_Distributors"/>TC020_B_Distributors<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC020_C_Distributors"/>TC020_C_Distributors<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC020_D_Distributors"/>TC020_D_Distributors<br />
<input type="checkbox" name="BookingsTMSReportingCompatibility" value="TC021_A_SBPAttributes"/>TC021_A_SBPAttributes<br />



</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	<a  class="hyperlinkblock" id="BookingsTMSSalesCompatibility" href="javascript:ExpandCollapaseBookingsTMSSalesCompatibility();" >TMS Sales</a> 
	<div class="container" id="BookingsTMSSalesCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleBookingsTMSSalesCompatibility(this)" /><b> Toggle All </b><br/><input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC001_A_TMS_Sales_Allocated_Bookings"/>TC001_A_TMS_Sales_Allocated_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC001_B_TMS_Sales_Allocated_Bookings"/>TC001_B_TMS_Sales_Allocated_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC001_C_TMS_Sales_Allocated_Bookings"/>TC001_C_TMS_Sales_Allocated_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC002_A_TMS_Sales_Allocated_TotalCisco_Bookings"/>TC002_A_TMS_Sales_Allocated_TotalCisco_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC003_A_TMS_Sales_Allocated_Product_Bookings"/>TC003_A_TMS_Sales_Allocated_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC003_B_TMS_Sales_Allocated_Product_Bookings"/>TC003_B_TMS_Sales_Allocated_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC003_C_TMS_Sales_Allocated_Product_Bookings"/>TC003_C_TMS_Sales_Allocated_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC004_A_TMS_Sales_Allocated_Total_Product_Bookings"/>TC004_A_TMS_Sales_Allocated_Total_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC004_B_TMS_Sales_Allocated_Total_Product_Bookings"/>TC004_B_TMS_Sales_Allocated_Total_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC004_C_TMS_Sales_Allocated_Total_Product_Bookings"/>TC004_C_TMS_Sales_Allocated_Total_Product_Bookings<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC005_A_TMS_Sales_Allocated_Bookings_Adjustments"/>TC005_A_TMS_Sales_Allocated_Bookings_Adjustments<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC005_B_TMS_Sales_Allocated_Bookings_Adjustments"/>TC005_B_TMS_Sales_Allocated_Bookings_Adjustments<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC005_C_TMS_Sales_Allocated_Bookings_Adjustments"/>TC005_C_TMS_Sales_Allocated_Bookings_Adjustments<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC006_A_TMS_Sales_Allocated_OA_BundlePID"/>TC006_A_TMS_Sales_Allocated_OA_BundlePID<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC006_B_TMS_Sales_Allocated_OA_BundlePID"/>TC006_B_TMS_Sales_Allocated_OA_BundlePID<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC006_C_TMS_Sales_Allocated_OA_BundlePID"/>TC006_C_TMS_Sales_Allocated_OA_BundlePID<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC007_A_TMS_Sales_Allocated_ON_SN"/>TC007_A_TMS_Sales_Allocated_ON_SN<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC007_B_TMS_Sales_Allocated_ON_SN"/>TC007_B_TMS_Sales_Allocated_ON_SN<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC007_C_TMS_Sales_Allocated_ON_SN"/>TC007_C_TMS_Sales_Allocated_ON_SN<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC008_A_DSVBkngsListBkngs__DSV_Bkngs_TMS_Sales"/>TC008_A_DSVBkngsListBkngs__DSV_Bkngs_TMS_Sales<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC008_B_DSVBkngsListBkngs__DSV_Bkngs_TMS_Sales"/>TC008_B_DSVBkngsListBkngs__DSV_Bkngs_TMS_Sales<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC009_DSV_Bkngs_TMS_Sales"/>TC009_DSV_Bkngs_TMS_Sales<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC010_A_RTM_TMS_Sales"/>TC010_A_RTM_TMS_Sales<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC010_B_RTM_TMS_Sales"/>TC010_B_RTM_TMS_Sales<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC011_A_TCH_Sales_Order_Notes_Number"/>TC011_A_TCH_Sales_Order_Notes_Number<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC011_B_TCH_Sales_Order_Notes_Number"/>TC011_B_TCH_Sales_Order_Notes_Number<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC012_A_TMS_TMSSales_Subscription"/>TC012_A_TMS_TMSSales_Subscription<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC012_B_TMS_TMSSales_Subscription"/>TC012_B_TMS_TMSSales_Subscription<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC013_A_TMSSales_OEHierarchy"/>TC013_A_TMSSales_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC013_B_TMSSales_OEHierarchy"/>TC013_B_TMSSales_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC013_C_TMSSales_OEHierarchy"/>TC013_C_TMSSales_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC013_D_TMSSales_OEHierarchy"/>TC013_D_TMSSales_OEHierarchy<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC014_A_TMSSales_POE"/>TC014_A_TMSSales_POE<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC014_B_TMSSales_POE"/>TC014_B_TMSSales_POE<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC014_C_TMSSales_POE"/>TC014_C_TMSSales_POE<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC014_D_TMSSales_POE"/>TC014_D_TMSSales_POE<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC015_A_Enterprise_SKU1"/>TC015_A_Enterprise_SKU1<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC016_A_TMSSalesPOSEnrichment"/>TC016_A_TMSSalesPOSEnrichment<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC016_B_TMSSalesPOSEnrichment"/>TC016_B_TMSSalesPOSEnrichment<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC017_A_TMSSalesNew_Renew"/>TC017_A_TMSSalesNew_Renew<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC017_B_TMSSalesNew_Renew"/>TC017_B_TMSSalesNew_Renew<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC018_A_TMSSalesSubscriptionDetails"/>TC018_A_TMSSalesSubscriptionDetails<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC018_B_TMSSalesSubscriptionDetails"/>TC018_B_TMSSalesSubscriptionDetails<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC019_A_TMSSalesMLB"/>TC019_A_TMSSalesMLB<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC019_B_TMSSalesMLB"/>TC019_B_TMSSalesMLB<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC020_A_TMSSalesDistributors"/>TC020_A_TMSSalesDistributors<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC020_B_TMSSalesDistributors"/>TC020_B_TMSSalesDistributors<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC020_C_TMSSalesDistributors"/>TC020_C_TMSSalesDistributors<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC020_D_TMSSalesDistributors"/>TC020_D_TMSSalesDistributors<br />
<input type="checkbox" name="BookingsTMSSalesCompatibility" value="TC021_A_TMSSalesSBPAttributes"/>TC021_A_TMSSalesSBPAttributes<br />


</td>
	</tr>
	</table>
	</div><br><br><br>

	
	<b><h2>&nbsp;&nbsp;&nbsp;Revenue BO</h2></b> 
	<a class="hyperlinkblock" id="RevenueCAServiceReportingCompatibility" href="javascript:ExpandCollapaseRevenueCAServiceReportingCompatibility();" >CA Service Reporting</a> 
	<div class="container" id="RevenueCAServiceReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleRevenueCAServiceReportingCompatibility(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC001_A_CA_Service_Reporting"/>TC001_A_CA_Service_Reporting<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC001_B_CA_Service_Reporting"/>TC001_B_CA_Service_Reporting<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC002_A_CA_Service_INVOICE"/>TC002_A_CA_Service_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC002_B_CA_Service_INVOICE"/>TC002_B_CA_Service_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC003_Total_Cisco_CA_Service"/>TC003_Total_Cisco_CA_Service<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC004_A_Service_Acquisition_Details"/>TC004_A_Service_Acquisition_Details<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC005_EnableSO_Revenue"/>TC005_EnableSO_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC006_EnableSO_INVOICE"/>TC006_EnableSO_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC007_EnableSO_SOLineId_Revenue"/>TC007_EnableSO_SOLineId_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC008_EnableSO_SO_Line_id_INVOICE"/>TC008_EnableSO_SO_Line_id_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC009_CERussia_Localtrxndate_Revenue"/>TC009_CERussia_Localtrxndate_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC010_CERussia_Localtrxnnum_Revenue"/>TC010_CERussia_Localtrxnnum_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC011_CERussia_AOAIssuanceDate_Revenue"/>TC011_CERussia_AOAIssuanceDate_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC012_CERussia_AOANum_Revenue"/>TC012_CERussia_AOANum_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC013_CERussia_upfrontBillingflag_Revenue"/>TC013_CERussia_upfrontBillingflag_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC014_CERussia_LocalCorretionnum_Revenue"/>TC014_CERussia_LocalCorretionnum_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC015_CERussia_LocalSoNum_Revenue"/>TC015_CERussia_LocalSoNum_Revenue<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC016_CERussia_LocalTrxnDate_INVOICE"/>TC016_CERussia_LocalTrxnDate_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC017_CERussia_AOAIssuancedate_INVOICE"/>TC017_CERussia_AOAIssuancedate_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC018_CERussia_Localtrxnnumber_INVOICE"/>TC018_CERussia_Localtrxnnumber_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC019_CERussia_AOANum_INVOICE"/>TC019_CERussia_AOANum_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC020_CERussia_UpfrontBillingflag_INVOICE"/>TC020_CERussia_UpfrontBillingflag_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC021_CERussia_LocalCorrectionNum_INVOICE"/>TC021_CERussia_LocalCorrectionNum_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC022_CERussia_LocalSONum_INVOICE"/>TC022_CERussia_LocalSONum_INVOICE<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC023_A_OE_Hierarchy"/>TC023_A_OE_Hierarchy<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC024_A_CMS"/>TC024_A_CMS<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC024_B_CMS"/>TC024_B_CMS<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC024_C_CMS"/>TC024_C_CMS<br />
<input type="checkbox" name="RevenueCAServiceReportingCompatibility" value="TC025_A_New_Renew"/>TC025_A_New_Renew<br />


	</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	<a class="hyperlinkblock" id="RevenueForecastReportingCompatibility" href="javascript:ExpandCollapaseRevenueForecastReportingCompatibility();" >Revenue Forecast Reporting</a> 
	<div class="container" id="RevenueForecastReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleRevenueForecastReportingCompatibility(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="RevenueForecastReportingCompatibility" value="TC001_REVENUE_BUDGET"/>TC001_REVENUE_BUDGET<br />
	<input type="checkbox" name="RevenueForecastReportingCompatibility" value="TC002_REVENUE_COMMIT"/>TC002_REVENUE_COMMIT<br />
	<input type="checkbox" name="RevenueForecastReportingCompatibility" value="TC003_REVENUE_UPDATE"/>TC003_REVENUE_UPDATE<br />
	<input type="checkbox" name="RevenueForecastReportingCompatibility" value="TC004_REVENUE_OUTLOOK"/>TC004_REVENUE_OUTLOOK<br />
	<input type="checkbox" name="RevenueForecastReportingCompatibility" value="TC005_REVENUE_BUDGET_PREOWNED"/>TC005_REVENUE_BUDGET_PREOWNED<br />
	<input type="checkbox" name="RevenueForecastReportingCompatibility" value="TC006_REVENUEFORECAT_PREOWNED"/>TC006_REVENUEFORECAT_PREOWNED<br />
	</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	<a class="hyperlinkblock" id="RevenueReportingCompatibility" href="javascript:ExpandCollapaseRevenueReportingCompatibility();" >Revenue Reporting</a> 
	<div class="container" id="RevenueReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleRevenueReportingCompatibility(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="RevenueReportingCompatibility" value="TC001_A_CISCO_REVENUE"/>TC001_A_CISCO_REVENUE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC001_B_CISCO_REVENUE"/>TC001_B_CISCO_REVENUE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC002_TOTAL_CISCO_REVENUE"/>TC002_TOTAL_CISCO_REVENUE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC003_A_CISCO_PnL_GM"/>TC003_A_CISCO_PnL_GM<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC003_B_CISCO_PnL_GM"/>TC003_B_CISCO_PnL_GM<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC004_A_DEBIT_MEMO_GL"/>TC004_A_DEBIT_MEMO_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC004_B_DEBIT_MEMO_GL"/>TC004_B_DEBIT_MEMO_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC004_C_DEBIT_MEMO_GL"/>TC004_C_DEBIT_MEMO_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC005_A_DEBIT_MEMO_INVOICE"/>TC005_A_DEBIT_MEMO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC005_B_DEBIT_MEMO_INVOICE"/>TC005_B_DEBIT_MEMO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC005_C_DEBIT_MEMO_INVOICE"/>TC005_C_DEBIT_MEMO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC006_A_GROSS_MARGIN_GL"/>TC006_A_GROSS_MARGIN_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC006_B_GROSS_MARGIN_GL"/>TC006_B_GROSS_MARGIN_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC006_C_GROSS_MARGIN_GL"/>TC006_C_GROSS_MARGIN_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC007_A_GROSS_MARGIN_INVOICE"/>TC007_A_GROSS_MARGIN_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC007_B_GROSS_MARGIN_INVOICE"/>TC007_B_GROSS_MARGIN_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC007_C_GROSS_MARGIN_INVOICE"/>TC007_C_GROSS_MARGIN_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC008_ACQUISITION_DETAILS"/>TC008_ACQUISITION_DETAILS<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC009_CONTRIBUTION_MARGIN"/>TC009_CONTRIBUTION_MARGIN<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC010_CONTRIBUTION_MARGIN_BUDGET"/>TC010_CONTRIBUTION_MARGIN_BUDGET<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC011_A_CISCO_INVOICE"/>TC011_A_CISCO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC011_B_CISCO_INVOICE"/>TC011_B_CISCO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC011_C_CISCO_INVOICE"/>TC011_C_CISCO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC012_CONTRIBUTION_MARGIN_COMMIT"/>TC012_CONTRIBUTION_MARGIN_COMMIT<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC013_A_CREDIT_MEMO_GL"/>TC013_A_CREDIT_MEMO_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC013_B_CREDIT_MEMO_GL"/>TC013_B_CREDIT_MEMO_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC013_C_CREDIT_MEMO_GL"/>TC013_C_CREDIT_MEMO_GL<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC014_Total_Cisco_PnL_GM"/>TC014_Total_Cisco_PnL_GM<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC015_A_CREDIT_MEMO_INVOICE"/>TC015_A_CREDIT_MEMO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC015_B_CREDIT_MEMO_INVOICE"/>TC015_B_CREDIT_MEMO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC015_C_CREDIT_MEMO_INVOICE"/>TC015_C_CREDIT_MEMO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC016_A_OA_BunPID_Revenue"/>TC016_A_OA_BunPID_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC016_B_OA_BunPID_Revenue"/>TC016_B_OA_BunPID_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC017_OA_BunPID_Invoice"/>TC017_OA_BunPID_Invoice<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC018_A_Sub_Inv_Org_Code_Revenue"/>TC018_A_Sub_Inv_Org_Code_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC018_B_Sub_Inv_Org_Code_Invoice"/>TC018_B_Sub_Inv_Org_Code_Invoice<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC019_EnableSO_Revenue"/>TC019_EnableSO_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC020_EnableSO_INVOICE"/>TC020_EnableSO_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC021_EnableSo_SOLineId_Revenue"/>TC021_EnableSo_SOLineId_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC022_EnableSO_SO_Line_id_INVOICE"/>TC022_EnableSO_SO_Line_id_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC023_CERussia_LocalTrxDt_Revenue"/>TC023_CERussia_LocalTrxDt_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC024_CERussia_Localtrxnnum_Revenue"/>TC024_CERussia_Localtrxnnum_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC025_CERussia_AOAIssuanceDate_Revenue"/>TC025_CERussia_AOAIssuanceDate_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC026_CERussia_AOANumber_Revenue"/>TC026_CERussia_AOANumber_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC027_CERussia_UpforntBillingFlag_Revenue"/>TC027_CERussia_UpforntBillingFlag_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC028_CERussia_LocalCorrectionnum_Revenue"/>TC028_CERussia_LocalCorrectionnum_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC029_CERussia_LocalSONum_Revenue"/>TC029_CERussia_LocalSONum_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC030_CERussia_LocalTrxndate_INVOICE"/>TC030_CERussia_LocalTrxndate_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC031_CERussia_LocalTrxnnum_INVOICE"/>TC031_CERussia_LocalTrxnnum_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC032_CERussia_AOAIssuanceNum_INVOICE"/>TC032_CERussia_AOAIssuanceNum_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC033_CERussia_AOANum_INVOICE"/>TC033_CERussia_AOANum_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC034_CERussia_LocalCorrectionNum_INVOICE"/>TC034_CERussia_LocalCorrectionNum_INVOICE<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC035_CERussia_LocalSOnum_INVOICE"/>TC035_CERussia_LocalSOnum_INVOICE <br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC036_A_Addtional_SaaS_Attributes"/>TC036_A_Addtional_SaaS_Attributes<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC036_B_Additional_SaaS_Attributes"/>TC036_B_Additional_SaaS_Attributes<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC037_A_SaaS_Attributes"/>TC037_A_SaaS_Attributes<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC037_B_SaaS_Attributes"/>TC037_B_SaaS_Attributes<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC038_A_OE_Hierarchy_Revenue"/>TC038_A_OE_Hierarchy_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC038_B_OE_Hierarchy_Revenue"/>TC038_B_OE_Hierarchy_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC039_A_FCM_Revenue"/>TC039_A_FCM_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC039_B_FCM_Revenue"/>TC039_B_FCM_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC039_C_FCM_Revenue"/>TC039_C_FCM_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC039_D_FCM_Revenue"/>TC039_D_FCM_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC040_A_POE_Revenue"/>TC040_A_POE_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC041_A_POE_Revenue"/>TC041_A_POE_Revenue<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC042_CE_CHINA_CFN"/>TC042_CE_CHINA_CFN<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC043_A_Bundle_OA_Attributes"/>TC043_A_Bundle_OA_Attributes<br />
<input type="checkbox" name="RevenueReportingCompatibility" value="TC044_A_ENTERPRISE_SKU"/>TC044_A_ENTERPRISE_SKU<br />


	</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	<a class="hyperlinkblock" id="RevenueTMSReportingCompatibility" href="javascript:ExpandCollapaseRevenueTMSReportingCompatibility();" >TMS Reporting</a> 
	<div class="container" id="RevenueTMSReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleRevenueTMSReportingCompatibility(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC001_A_TMS_Corp_Allocated_Revenue"/>TC001_A_TMS_Corp_Allocated_Revenue<br />
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC001_B_TMS_Corp_Allocated_Revenue"/>TC001_B_TMS_Corp_Allocated_Revenue<br />
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC002_A_TMS_Corp_Allocated_Quantity"/>TC002_A_TMS_Corp_Allocated_Quantity<br />
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC003_A_TMS_Corp_Allocated_Revenue_Ports"/>TC003_A_TMS_Corp_Allocated_Revenue_Ports<br />
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC004_A_TMS_GROSS_MARGIN"/>TC004_A_TMS_GROSS_MARGIN<br />
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC005_A_TMS_SALES_ALLOCATED_INVOICE"/>TC005_A_TMS_SALES_ALLOCATED_INVOICE<br />
	<input type="checkbox" name="RevenueTMSReportingCompatibility" value="TC006_A_POE_TMSReporting"/>TC006_A_POE_TMSReporting<br />
	
	</td>
	</tr>
	</table>
	</div><br>
	<table>
	<tr></tr>
	</table>
	
	<a class="hyperlinkblock" id="RevenueDeferredReportingCompatibility" href="javascript:ExpandCollapaseRevenueDeferredReportingCompatibility();" >Deferred Revenue Reporting</a> 
	<div class="container" id="RevenueDeferredReportingCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
<input type="checkbox" onClick="toggleRevenueDeferredReportingCompatibility(this)" /><b> Toggle All </b><br/>
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC001_A_EnableSO_Deffered_Revenue"/>TC001_A_EnableSO_Deffered_Revenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC002_B_EnableSO_SOLineId_Deffered_Revenue"/>TC002_B_EnableSO_SOLineId_Deffered_Revenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC003_A_CERussia_LocalTrxnDate_DefferedRevenue"/>TC003_A_CERussia_LocalTrxnDate_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC004_A_CERussia_LocalTrxnNum_DefferedRevenue"/>TC004_A_CERussia_LocalTrxnNum_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC005_A_CERussia_AOAIssuanceDate_DefferedRevenue"/>TC005_A_CERussia_AOAIssuanceDate_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC006_A_CERussia_AOANum_DefferedRevenue"/>TC006_A_CERussia_AOANum_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC007_A_CERussia_LocalCorrectionNum_DefferedRevenue"/>TC007_A_CERussia_LocalCorrectionNum_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC008_A_CERussia_LocalSONum_DefferedRevenue"/>TC008_A_CERussia_LocalSONum_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC009_A_CERussia_UpfrontBookingflag_DefferedRevenue"/>TC009_A_CERussia_UpfrontBookingflag_DefferedRevenue<br />
<input type="checkbox" name="RevenueDeferredReportingCompatibility" value="TC010_A_POE_DeferredRevenue"/>TC010_A_POE_DeferredRevenue<br />

</td>
</tr>
</table>
</div><br>
<table>
<tr></tr>
</table>

<a class="hyperlinkblock" id="CommonObjectsCompatibility" href="javascript:ExpandCollapaseCommonObjectsCompatibility();" >Common Objects Revenue</a> 
	<div class="container" id="CommonObjectsCompatibilityTestcases" style="display: none" >
	<table>
	<tr>
	<td>
<input type="checkbox" onClick="toggleCommonObjectsCompatibility(this)" /><b> Toggle All </b><br/>
<input type="checkbox" name="CommonObjectsCompatibility" value="TC001_A_REVENUE_REPORTING_NEW_RENEW"/>TC001_A_REVENUE_REPORTING_NEW_RENEW<br />
<input type="checkbox" name="CommonObjectsCompatibility" value="TC001_B_REVENUE_REPORTING_NEW_RENEW"/>TC001_B_REVENUE_REPORTING_NEW_RENEW<br />

</td>
</tr>
</table>
</div><br>
<table>
<tr></tr>
</table>

<a class="hyperlinkblock" id="Demo" href="javascript:ExpandCollapaseDemoCompatibility();" >Demo Folder</a> 
	<div class="container" id="DemoTestcases" style="display: none" >
	<table>
	<tr>
	<td>
	<input type="checkbox" onClick="toggleDemoCompatibility(this)" /><b> Toggle All </b><br/>
	<input type="checkbox" name="DemoCompatibility" value="TC001_Pass Scenario"/>TC001_Pass Scenario<br />
	<input type="checkbox" name="DemoCompatibility" value="TC002_Fail Scenario"/>TC002_Fail Scenario<br />
	</td>
</tr>
</table>
</div><br><br>
<table>
<tr></tr>
</table>
	
	
	
	
</td>
</tr>
</table>
<div class="text">Enter email id for which execution report needs to be sent: <input type="text" name="emailid" size="25" maxlength="100"  required placeholder="Email Address" style="color: #000000;"></div> <br> <br>

<a><input type ="Submit" value="Submit" class="glossy" id="custommessage"></a>  
</form>
        </div>
        
        
 <!---------------------------------------------------- AE SAS Jobs --------------------------------------------------------------------------------------->        
         <div id="AESASJOBS" class="tab" >
         
        
         Please select from below options:<br><br>
 <table>
<tr>
<td>
</td>
<td>
</td>
<td>       
      <form name="AESASForm"    action="AESASJobRun"  method="post">   
       <select class="selectClass" name="AESASJOBRUNOPTION" id="AESASJOBRUNOPTION" >
		<option value="none">-- Select AE Track --</option>
		<option value="1">PROFITABILITY</option>
		<option value="2">SERVICE TRIANGULATION</option>
		<option value="3">BKGs-MISC</option>
		<option value="4">TSS-COGS</option>
		<option value="5">OPEX</option>
		<option value="6">AS-COGS</option>
		<option value="7">CIS-COGS</option>
	 </select>
	 <br>
	<!--  <span id="result1"></span> -->
	<br>
	<div class=""  id="result1" style="display: none"  ></div>
	<br><br>
Update Open Period to: &nbsp;<input type="text" name="AESASNewOpenPeriod" id="UpdateAESASNewOpenPeriod" size="25" maxlength="6" >&nbsp;(*** If this is left blank script will run for current open period)<br><br>

<input type ="Submit" value="Submit" class="glossy" id="UpdateAESASOpenPeriodSubmit" >
	</form>
	
	
	
     
        </table>
        
         </div>
         
 <!---------------------------------------------------- GM Walk ------------------------------------------------------------------------------------------->
         <div id="GMWalk" class="tab" >
  <br>
				<p align="right">
					<a class="hyperlinkblock3" href="ReportDownload?fileId=DV"
						target="_blank">Download Latest Execution report</a>
				</p>
				<!-- <table><tr height="100"><td height="100"></td></tr></table>		 -->
				<form name="GMWalkForm" action="GMWalkMapNRun" method="post">
					As Of Fiscal Quarter <input type="text" name="AsOfFiscalQuarter"
						size="25" maxlength="100" class="inputClass" required
						placeholder="As Of Fiscal Quarter"> Current Fiscal Quarter
					<input type="text" name="CurrentFiscalQuarter" size="25"
						maxlength="100" required placeholder="Current Fiscal Quarter" class="inputClass">
					Current Fiscal Year <input type="text" name="CurrentFiscalYear"
						size="25" maxlength="100" placeholder="Current Fiscal Year" class="inputClass">
					Product/Sales Anchor <select class="selectClass"
						name="ProductSalesAnchorOption" id="ProductSalesAnchorOption" >
						<option value="none">-- Select Product/Sales Anchor --</option>
						<option value="All Products / THEATER">All Products /
							THEATER</option>
						<option value="All Products/ E-GEO">All Products/ E-GEO</option>
						<option value="All Products/ I-GEO">All Products/ I-GEO</option>
						<option value="All Products/ WW TOTAL">All Products/ WW
							TOTAL</option>
						<option value="External BE/ E-GEO">External BE/ E-GEO</option>
						<option value="External BE/ I-GEO">External BE/ I-GEO</option>
						<option value="External BE/ THEATER">External BE/ THEATER</option>
						<option value="External BE/ WW TOTAL">External BE/ WW
							TOTAL</option>
						<option value="External SBE/ E-GEO">External SBE/ E-GEO</option>
						<option value="External SBE/ I-GEO">External SBE/ I-GEO</option>
						<option value="External SBE/ THEATER">External SBE/
							THEATER</option>
						<option value="External SBE/ WW TOTAL">External SBE/ WW
							TOTAL</option>
						<option value="Internal BE / I-GEO">Internal BE / I-GEO</option>
						<option value="Internal BE / THEATER">Internal BE /
							THEATER</option>
						<option value="Internal BE/ E-GEO">Internal BE/ E-GEO</option>
						<option value="Internal BE/ WW TOTAL">Internal BE/ WW
							TOTAL</option>
						<option value="Internal SBE / THEATER">Internal SBE /
							THEATER</option>
						<option value="Internal SBE/ E-GEO">Internal SBE/ E-GEO</option>
						<option value="Internal SBE/ I-GEO">Internal SBE/ I-GEO</option>
						<option value="Internal SBE/ WW TOTAL">Internal SBE/ WW
							TOTAL</option>
						<option value="PF/E-GEO">PF/E-GEO</option>
						<option value="PF/I-GEO">PF/I-GEO</option>
						<option value="PF/THEATER">PF/THEATER</option>
						<option value="PF/WW TOTAL">PF/WW TOTAL</option>
					</select> <br> <br> <br>

					<table>
						<tr>
							<td></td>
							<td></td>
							<td>
								<!--  Impact Validations --> <a class="hyperlinkblock"
								id="ImpactValidations"
								href="javascript:ExpandCollapaseImpactValidationsCV();">Impact
									Data Validation</a>
								<div class="container" id="ImpactValidationTestCases"
									style="display: none"><br>
									<table>
										<tr>
											<!-- Bookings Cube Fact -->
											<td><input type="checkbox"
												onClick="toggleGMWalk_ImpactData(this)" /><b> Toggle
													All </b><br /> <input type="checkbox"
												name="ImpactValidations_TC" value="TC_001_ASP_Combined_YTD" />TC_001_ASP_Combined_YTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_002_ASP_Defer_Rel_YTD" />TC_002_ASP_Defer_Rel_YTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_003_ASP_Standard_YTD" />TC_003_ASP_Standard_YTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_004_Other_Cost_YTD" />TC_004_Other_Cost_YTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_005_Pricing_YTD" />TC_005_Pricing_YTD<br /> <input
												type="checkbox" name="ImpactValidations_TC"
												value="TC_006_Rebates_YTD" />TC_006_Rebates_YTD<br /> <input
												type="checkbox" name="ImpactValidations_TC"
												value="TC_007_Total_Savings_Impact_YTD" />TC_007_Total_Savings_Impact_YTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_008_Unit_Cost_YTD" />TC_008_Unit_Cost_YTD<br /> <input
												type="checkbox" name="ImpactValidations_TC"
												value="TC_009_ASP_Combined_QTD" />TC_009_ASP_Combined_QTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_010_ASP_Defer_Rel_QTD" />TC_010_ASP_Defer_Rel_QTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_011_ASP_Standard_QTD" />TC_011_ASP_Standard_QTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_012_Other_Cost_QTD" />TC_012_Other_Cost_QTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_013_Pricing_QTD" />TC_013_Pricing_QTD<br /> <input
												type="checkbox" name="ImpactValidations_TC"
												value="TC_014_Rebates_QTD" />TC_014_Rebates_QTD<br /> <input
												type="checkbox" name="ImpactValidations_TC"
												value="TC_015_Total_Savings_Impact_QTD" />TC_015_Total_Savings_Impact_QTD<br />
												<input type="checkbox" name="ImpactValidations_TC"
												value="TC_016_Unit_Cost_QTD" />TC_016_Unit_Cost_QTD<br /></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</div>
								<br /> <!--  Raw Data Validations --> <a class="hyperlinkblock"
								id="RawDataValidations"
								href="javascript:ExpandCollapaseRawDataValidationsCV();">Raw
									Data Validation</a>
								<div class="container" id="RawDataValidationTestCases"
									style="display: none">
									<table>
										<tr>
											<!-- Bookings Cube Fact -->
											<td><input type="checkbox"
												onClick="toggleGMWalk_RawData(this)" /><b> Toggle All </b><br />
												<input type="checkbox" name="RawDataValidations_TC"
												value="TC_001_Rebates" />TC_001_Rebates<br /> <input
												type="checkbox" name="RawDataValidations_TC"
												value="TC_002_Other_Cost_Savings" />TC_002_Other_Cost_Savings<br />
												<input type="checkbox" name="RawDataValidations_TC"
												value="TC_003_Volume_Impact_Rev_Walk" />TC_003_Volume_Impact_Rev_Walk<br />
												<input type="checkbox" name="RawDataValidations_TC"
												value="TC_004_Volume_Impact_GM_Walk" />TC_004_Volume_Impact_GM_Walk<br />
												<input type="checkbox" name="RawDataValidations_TC"
												value="TC_005_VCP" />TC_005_VCP<br /> <input
												type="checkbox" name="RawDataValidations_TC"
												value="TC_006_Others" />TC_006_Others<br /></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</div>
								<br />
								<table>
									<tr></tr>
								</table>
							</td>
						</tr>
					</table>
					Enter email id (id's - comma separated) for which execution report
					needs to be sent: <input type="text" name="emailid" size="25"
						maxlength="100" required placeholder="Email Address" class="inputClass"> <br>
					<br> <input type="Submit" value="Submit" class="glossy"
						id="custommessage">
					<!-- <img id="loader" src="ajax-loader.gif" style="display: none;" /> -->
				</form>
			</div>


			<!---------------------------------------------------- AE Environment Validations ------------------------------------------------------------------------->
			<div id="AEEnvironmentValidations" class="tab"></div>
			<!---------------------------------------------------- CFA Validations ------------------------------------------------------------------------->
			<div id="CFAValidations" class="tab">				  
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">CFA tie-outs Dashboards</a>
				        </h4>
				      </div>
				      <div id="collapse1" class="panel-collapse collapse in">
				        <div class="panel-body">
				        	<div class="panel-group" id="accordionchild">
								<div class="panel panel-default">
							      <div class="panel-heading">
							        <h4 class="panel-title">
							          <a data-toggle="collapse" data-parent="#accordionchild" href="#collapse11">By Time</a>
							        </h4>
							      </div>
							      <div id="collapse11" class="panel-collapse collapse in">
							        <div class="panel-body">
							        <div class="row">
							        		filelist
										    <div class="col-sm-2">										    	
										      <a class="hyperlinkblockresponsive" href="https://wwwin-webapps-stage.cisco.com/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&Server=FESCFA-APP-STG-003&Project=Cisco+Financial+Analyzer&Port=0&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475"
													target="_blank" title="Open Product Bookings Dashboard">Product Bookings</a>
												<button type="button" class="btn btn-default btn-sm" onClick="window.open('DashboardFilter.jsp?type=CiscoProductBookings','popuppage','width=400,toolbar=1,resizable=1,scrollbars=yes,height=350,top=400,left=100');">
											          <span class="glyphicon glyphicon-refresh" aria-hidden="true" style="color:#000000"></span>
											   </button>											     														
										    </div>										    
										    <div class="col-sm-2">
										      <a class="hyperlinkblockresponsive" href="https://wwwin-webapps-stage.cisco.com/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&Server=FESCFA-APP-STG-003&Project=Cisco+Financial+Analyzer&Port=0&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475"
													target="_blank" title="Open Service Bookings Dashboard">Service Bookings</a>
											  <button type="button" class="btn btn-default btn-sm" onClick="window.open('DashboardFilter.jsp','popuppage','width=400,toolbar=1,resizable=1,scrollbars=yes,height=350,top=400,left=100');">
											          <span class="glyphicon glyphicon-refresh" aria-hidden="true" style="color:#000000"></span>
											  </button>						 
										    </div>	
										    <div class="col-sm-2">
										      <a class="hyperlinkblockresponsive" href="https://wwwin-webapps-stage.cisco.com/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&Server=FESCFA-APP-STG-003&Project=Cisco+Financial+Analyzer&Port=0&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475"
													target="_blank" title="Open Bookings Margin Dashboard">Bookings Margin</a>
											  <button type="button" class="btn btn-default btn-sm" onClick="window.open('DashboardFilter.jsp','popuppage','width=400,toolbar=1,resizable=1,scrollbars=yes,height=350,top=400,left=100');">
											          <span class="glyphicon glyphicon-refresh" aria-hidden="true" style="color:#000000"></span>
											  </button>						 
										    </div>
										    <div class="col-sm-2">
										      <a class="hyperlinkblockresponsive" href="https://wwwin-webapps-stage.cisco.com/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&Server=FESCFA-APP-STG-003&Project=Cisco+Financial+Analyzer&Port=0&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475"
													target="_blank" title="Open Product Revenue Dashboard">Product Revenue</a>
											  <button type="button" class="btn btn-default btn-sm" onClick="window.open('DashboardFilter.jsp','popuppage','width=400,toolbar=1,resizable=1,scrollbars=yes,height=350,top=400,left=100');">
											          <span class="glyphicon glyphicon-refresh" aria-hidden="true" style="color:#000000"></span>
											  </button>					 
										    </div>	
										    <!-- <div class="col-sm-2">
										      <a class="hyperlinkblockresponsive" href="https://wwwin-webapps-stage.cisco.com/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&Server=FESCFA-APP-STG-003&Project=Cisco+Financial+Analyzer&Port=0&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475"
													target="_blank" title="Open Service Revenue Dashboard">Service Revenue</a>
											  <button type="button" class="btn btn-default btn-sm" onClick="window.open('DashboardFilter.jsp','popuppage','width=400,toolbar=1,resizable=1,scrollbars=yes,height=350,top=400,left=100');">
											          <span class="glyphicon glyphicon-refresh" aria-hidden="true" style="color:#000000"></span>
											  </button>						 
										    </div> -->	
										    
										     <div class="col-sm-2">
										      <a class="hyperlinkblockresponsive" href="https://wwwin-webapps-stage.cisco.com/MicroStrategy10/servlet/mstrWeb?hiddensections=header%2Cpath&Server=FESCFA-APP-STG-003&Project=Cisco+Financial+Analyzer&Port=0&evt=3140&src=mstrWeb.3140&documentID=B95E404211E5F18713A10080EF454475"
													target="_blank" title="Open Profitability Dashboard">Profitability</a>
											  <button type="button" class="btn btn-default btn-sm" onClick="window.open('DashboardFilter.jsp','popuppage','width=400,toolbar=1,resizable=1,scrollbars=yes,height=350,top=400,left=100');">
											          <span class="glyphicon glyphicon-refresh" aria-hidden="true" style="color:#000000"></span>
											  </button>					 
										    </div>									    
									</div>							        	
							        </div>
								  </div>				      		
							  	</div>
							  	<div class="panel panel-default">
							      <div class="panel-heading">
							        <h4 class="panel-title">
							          <a data-toggle="collapse" data-parent="#accordionchild" href="#collapse12">By Internal BE</a>
							        </h4>
							      </div>
							      <div id="collapse12" class="panel-collapse collapse">
							        <div class="panel-body">
							        	
							        </div>
								  </div>				      		
							  	</div>
							  </div>
				        </div>
					  </div>				      		
				     </div>
				    
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Download Baselines</a>
				        </h4>
				      </div>
				      <div id="collapse2" class="panel-collapse collapse">
				        <div class="panel-body row">
				        <form name="CFABaselines" action="CFABaselineValidations" method="post" class="form-inline">
					        <div class="form-group col-sm-4">
	   							 <label for="ddCFABaseline" style="color:#000000">Select Baseline Report</label>
	    						 <select class="selectClass form-control" name="ddCFABaseline" id="ddCFABaseline" size="3"  multiple="multiple">
											<option value="none">-- Select one or more Baseline Reports --</option>
											<option value="ProductBookings_Baseline">Product Bookings</option>
											<option value="ServiceBookings_Baseline">Service Bookings</option>
											<option value="BookingsMargin-Product_Baseline">Bookings
												Margin - Product</option>
											<option value="BookingsMargin-Service_Baseline">Bookings
												Margin - Service</option>
								</select>
	  						</div>	
	  						<div class="form-group col-sm-4">
	  								<label for="ddCFAFiscalQtr" style="color:#000000">Select Fiscal Quarter</label>
	  								<select class="selectClass form-control" name="ddCFAFiscalQtr" id="ddCFAFiscalQtr" size="3"  multiple="multiple">
									<option value="none">-- Select one or more Fiscal Quarters --</option>
									<option value="Q1 2014">Q1 2014</option>
									<option value="Q2 2014">Q2 2014</option>
									<option value="Q3 2014">Q3 2014</option>
									<option value="Q4 2014">Q4 2014</option>
									<option value="Q1 2015">Q1 2015</option>
									<option value="Q2 2015">Q2 2015</option>
									<option value="Q3 2015">Q3 2015</option>
									<option value="Q4 2015">Q4 2015</option>
									<option value="Q1 2016">Q1 2016</option>
									<option value="Q2 2016">Q2 2016</option>
									<option value="Q3 2016">Q3 2016</option>
									<option value="Q4 2016">Q4 2016</option>
									<option value="Q1 2017">Q1 2017</option>
									<option value="Q2 2017">Q2 2017</option>
									<option value="Q3 2017">Q3 2017</option>
									<option value="Q4 2017">Q4 2017</option>
									<option value="Q1 2018">Q1 2018</option>
									<option value="Q2 2018">Q2 2018</option>
									<option value="Q3 2018">Q3 2018</option>
									<option value="Q4 2018">Q4 2018</option>
								</select>
	  						</div>
	  						<div class="form-group col-sm-2">
	   							 <label for="emailid" >Email ID : </label>
	    						 <input type="text" name="emailid" size="25" maxlength="100" required
										placeholder="Email Address" class="inputClass">
	  						</div>	
	  						<div class="col-sm-2">
	  						<button type="submit" class="btn btn-default glossy">Submit</button>
	  						</div>
				      	</form>				       						
						</div>
					  </div>				      		
				     </div>
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Compare Baseline Reports</a>
				        </h4>
				      </div>
				       <div id="collapse3" class="panel-collapse collapse">
				        <div class="panel-body row" >
				        <form name="CFAReportComparision" action="CFAReportComparision" method="post" class="form-inline">
				        	<%! List <String> filelist = POM_Lib.RetriveFileList(); %>				        	
					        <div class="form-group col-sm-4" >
	   							 <label for="ddCFAReport1" style="color:#000000">Select Report1</label>	   							 
	    						 <select class="selectClass form-control" name="ddCFAReport1" id="ddCFAReport1">
	    						 			<option value="none">-- Select Baseline Report --</option>
	    						 			 <%
	    						 			
	    						 			 for(int i=0; i<filelist.size();i++){%>
											        <option value="<%=filelist.get(i)%>"><%=filelist.get(i)%></option>
											        
											  <%}%>																		
										
								</select>
	  						</div>
	  						<div class="form-group col-sm-4" >
	  							<label for="ddCFAReport2" style="color:#000000">Select Report2</label>
	    						 <select class="selectClass form-control" name="ddCFAReport2" id="ddCFAReport2" >
											<option value="none">-- Select Report to be compared --</option>
											<%
											    for(int i=0; i<filelist.size();i++){%>
											        <option value="<%=filelist.get(i)%>"><%=filelist.get(i)%></option>
											 <%}%>
								</select>
	  						</div>
	  						<div class="form-group col-sm-2">
	   							 <label for="emailid" style="color:#000000">Email ID : </label>
	    						 <input type="text" name="emailid" size="25" maxlength="100" required
										placeholder="Email Address" class="inputClass">
	  						</div>	
	  						<div class="col-sm-2"> 
	  							<button type="submit" class="btn btn-default glossy">Submit</button>
	  						</div>
	  					 	</form>	
				        </div>
				      </div> 
				    </div>
				 <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Dashboard Validations</a>
				        </h4>
				      </div>
				      <div id="collapse4" class="panel-collapse collapse">
				        <div class="panel-body row">
				        <form name="CFADashboards" action="CFADashboardValidations" method="post" class="form-inline">
					        <div class="form-group col-sm-3">
	   							 <label for="ddCFADashboardType" style="color:#000000">Select Dashboard</label>
	    						 <select class="selectClass form-control" name="ddCFADashboardType" id="ddCFADashboard">
											<option value="none">-- Select Dashboard --</option>
											<option value="GSP">GSP Dashboard</option>											
								</select>
	  						</div>
	  						<div class="form-group col-sm-3">
	   							 <label for="ddCFADashboardScreenType" style="color:#000000">Select Dashboard Screen</label>
	    						 <select class="selectClass form-control" name="ddCFADashboardScreenType" id="ddCFADashboard">
											<option value="none">-- Select Dashboard Screen --</option>
											<option value="Bookings-Summary">Bookings-Summary</option>
											<option value="Bookings-Summary-iCube">Bookings-Summary-iCube</option>											
								</select>
	  						</div>	
	  						<div class="form-group col-sm-3">
	   							  <label for="ddCFAFiscalQtr" style="color:#000000">Select Fiscal Quarter</label>
	  								<select class="selectClass form-control" name="ddCFAFiscalQtr" id="ddCFAFiscalQtr" size="3"  multiple="multiple">
									<option value="none">-- Select one or more Fiscal Quarters --</option>
									<option value="Q1 2014">Q1 2014</option>
									<option value="Q2 2014">Q2 2014</option>
									<option value="Q3 2014">Q3 2014</option>
									<option value="Q4 2014">Q4 2014</option>
									<option value="Q1 2015">Q1 2015</option>
									<option value="Q2 2015">Q2 2015</option>
									<option value="Q3 2015">Q3 2015</option>
									<option value="Q4 2015">Q4 2015</option>
									<option value="Q1 2016">Q1 2016</option>
									<option value="Q2 2016">Q2 2016</option>
									<option value="Q3 2016">Q3 2016</option>
									<option value="Q4 2016">Q4 2016</option>
									<option value="Q1 2017">Q1 2017</option>
									<option value="Q2 2017">Q2 2017</option>
									<option value="Q3 2017">Q3 2017</option>
									<option value="Q4 2017">Q4 2017</option>										
								</select>
	  						</div>
	  						<div class="form-group col-sm-2">
	   							 <label for="emailid" style="color:#000000">Email ID : </label>
	    						 <input type="text" name="emailid" size="25" maxlength="100" required
										placeholder="Email Address" class="inputClass">
	  						</div>			  						
	  						<div class="col-sm-1">
	  						<button type="submit" class="btn btn-default glossy">Submit</button>
	  						</div>
				      	</form>				       						
						</div>
					  </div>				      		
				     </div>
				    </div>			

			</div>

</div>

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>    
<script type="text/javascript" src="js/finbiJavaScript.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

    

</body>

</html>