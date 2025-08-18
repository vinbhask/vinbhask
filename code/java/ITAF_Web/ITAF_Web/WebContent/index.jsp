<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function validatelogins()
{
	var un=document.forms["LoginForm"]["userName"].value
	var pass=document.forms["LoginForm"]["password"].value
	var illegalChars = /\W/; // allow letters, numbers, and underscores
	 
	  if(un=="" ){
		  document.getElementById('userName').style.background = 'Red';
		  alert("Please enter Username ");
	        return false;
	        }
	  else if ((un.length < 5) || (un.length > 15) /* ||(pass.length<5) || (pass.length>15) */) {
		  document.getElementById('userName').style.background = 'Red';
		  document.getElementById('password').style.background = 'Red';
	        alert("The username/password should be of minimum 5 characters and maximum 15 characters");
	        return false;
	  }
	  else if (/[^a-zA-Z0-9\-\/]/.test( un )) {
	 //else if (illegalChars.test(un.value)) {
		  document.getElementById('userName').style.background = 'Red';
		  alert("The username contains illegal characters");
	  		return false;
	  }
	 else if(pass==""){
		 document.getElementById('password').style.background = 'Red';
		 alert("Please enter Username ");
		 
	 }
	 
        else return true;
	}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="CSS/Index.css"/>
</head>
<body>

<div class='img'>
  <div class='blur'></div>
  <form name="LoginForm" action="Login" method="post" onsubmit ="return validatelogins()">
  <div class='container'>
    <h1>Credentials...</h1>
    <input placeholder='Username' name="userName" size='20' maxlength="15" id="userName" type='text'>
    <input placeholder='Password' name="password" size='20' maxlength="12" id="password" type='password'> <br><br><br>
    <input type ="Submit" value="Login" class="glossy-button"></input>
  </div>
  </form>
</div>


</body>
</html>