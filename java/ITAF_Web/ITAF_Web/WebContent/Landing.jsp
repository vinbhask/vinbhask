<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.controllers.FetchDatabaseDetails"%>
<%@ page import="library.POM_Lib"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript">
$(document).ready(function() {
    $('#select').change(function() {
      var SourceServer = "select";
      alert("selected value: "+ SourceServer);

});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Landing</title>
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="CSS/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css" href="CSS/styleSheet.css" />
<%@ page isELIgnored="false"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
	if (session.getAttribute("User") == null) {
		response.sendRedirect("index.jsp");
	}
%>
</head>
<body onload="myFunction()">
<div id="set_cstext-title" class="handcursor" style="display:block; padding:0px; margin-bottom:1px; background-color:#274B7D; color:#FFFFFF; 
font-weight: bold; font: italic normal bold normal 50px helvetica, arial, sans-serif;">
<img src="images/logo-cisco.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</div>
<p align="right" style="color:black;" style="display:block;font-weight: bold;"> 
																				Welcome &nbsp;
																				<%=session.getAttribute("User")%>&nbsp;&nbsp;
																				|&nbsp;<a href="./ShowCurrentTests">Show Current Tests</a>
																				|&nbsp; <a class="hyperlinkblock2" href="logout">Logout</a></p>

<br>
<br>
<form name="Form1" action="MapNRun" method="post">
<div>
<table>

<tr><td>
<select  name="SourceServer" id="SourceServer" class="selectClass" >
		<option value="none">-- Select a source server --</option>
		<option value="Oracle">Source</option>
		<option value="Postgres">Target</option>
</select>
</td><td>
<select class="selectClass" name="SourceSchema" id="SourceSchema" >
		<option value="none">-- Select an schema --</option>
</select>
</td><td>
<select class="selectClass" name="SourceTable" id="SourceTable" >
		<option value="none">-- Select an table  --</option>
</select>
</td>
<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
<td>
<select  name="TargetServer" id="TargetServer" class="selectClass" >
		<option value="none">-- Select a target server --</option>
		<option value="Oracle">Source</option>
		<option value="Postgres">Target</option>
</select></td><td>
<select class="selectClass" name="TargetSchema" id="TargetSchema" >
		<option value="none">-- Select an target schema --</option>
</select></td><td>
<select class="selectClass" name="TargetTable" id="TargetTable" >
		<option value="none">-- Select an target table  --</option>
</select></td>
</tr>
</table>
<table>
<tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td>
</table></div>

<div id="Columnselector">
<input type="button" id="btAdd" value="Add Column" class="glossy-button" />
<input type ="Submit" value="Submit" class="glossy-button"></input>
</div>
<div id="KeysCols">
<br/>
<input type=text class="inputClass" id="SourcePK" name="SourcePK"   value="source primary key..." />
<input type=text class="inputClass" id="TargetPK" name="TargetPK"   value="target primary key..." />
<input type=text class="inputClass" id="NumOfCols" name="NumOfCols"   value="Enter num. of columns..." />
<input type=text class="inputClass" id="ScenarioType" name="ScenarioType"   value="Type of Scenario..." />
<input type=text class="inputClass" id="TestCaseName" name="TestCaseName"   value="TestCaseName..." />
<input type=text class="inputClass" id="TestCaseFilter" name="TestCaseFilter"   value="WhereClause..." />
</div>
</form>

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>    
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="javascripts.js"></script>



</body>
</html>