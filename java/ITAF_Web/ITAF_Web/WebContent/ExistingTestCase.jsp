<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose from Existing Testcase...</title>
</head>

<body onload="myFunction()">
<div id="set_cstext-title" class="handcursor" style="display:block; padding:0px; margin-bottom:1px; background-color:#274B7D; color:#FFFFFF; 
font-weight: bold; font: italic normal bold normal 50px helvetica, arial, sans-serif;">
<img src="images/logo-cisco.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Data Audit Framework 
</div>
<p align="right" style="display:block;font-weight: bold;"> 
																				Welcome &nbsp;
																				<%=session.getAttribute("User")%>&nbsp;&nbsp;&nbsp;&nbsp;
																				|<a class="hyperlinkblock2" href="logout">Logout</a></p>
<br>
<br>
<form name="Form1" action="RunTests" method="post">
<div>

<table border="3">
<tr>
 <th>TestCaseName</th>
 <th>SourceTableName</th>
 <th>TargetTableName</th>
 <th>SourceQuery</th>
 <th>TargetQuery</th>
 <th>Type</th>
 <th>Select</th>
 </tr>
  
 <c:forEach var="it" items="${sessionScope.TestCaseDetails}">
    <tr>
        <td>${it.testcasename}</td>
        <td>${it.sourcetablename}</td>
        <td>${it.targettablename}</td>
        <td>${it.sourcequery}</td>
        <td>${it.targetquery}</td>
        <td>${it.type}</td>
		<td><input type="checkbox" name="ExistingTestCases" value="${it.testcasename}" /></td>
	</tr>	
 </c:forEach>
</table>
</div>
<input type ="Submit" value="Submit" class="glossy-button"></input>
</form>
</body>
</html>