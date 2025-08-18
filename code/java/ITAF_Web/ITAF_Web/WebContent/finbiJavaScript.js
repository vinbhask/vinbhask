function myFunction() {
	var sfl=document.getElementById("userFilter").value; 
	alert("selected value is: "+sfl); 
}
$(document).ready(function() {
	$('.userFilter').change(function()
			{
			$.blockUI(
			{
				/*
					message displayed when blocking (use null for no message)
				*/
				message: '<h1><img src="images/please_wait.gif" /> </h1>'
			});
			setTimeout($.unblockUI, 5000);
			});
});

$(document).ready(function() {
$('#UpdateAESASNewOpenPeriod').attr('disabled','disabled');
$('#UpdateAESASOpenPeriodSubmit').attr('disabled','disabled');
});





function toggleBKMvsBKWCV(source) {
	  checkboxes = document.getElementsByName('BKMvsBKWCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
function toggleBKMvsGMCV(source) {
	  checkboxes = document.getElementsByName('BKMvsGMCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
function toggleBKMvsRevenueCV(source) {
	  checkboxes = document.getElementsByName('BKMvsRevenueCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
function toggleFINBIBKGvsBKMCV(source) {
	  checkboxes = document.getElementsByName('FINBIBKGvsBKMCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
function toggleFINBIBKGvsBKWCV(source) {
	  checkboxes = document.getElementsByName('FINBIBKGvsBKWCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
function toggleGMvsICPMCV(source) {
	  checkboxes = document.getElementsByName('GMvsICPMCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
function toggleGMvsRevenueCV(source) {
	  checkboxes = document.getElementsByName('GMvsRevenueCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}

/*function togglebookingCubevsBOCV(source) {
	  checkboxes = document.getElementsByName('BookingsCubevsBOCV');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
*/

function ExpandCollapaseBKMvsBKWCV() {
	var ele = document.getElementById("BKMvsBKWCVTestcases");
	var text = document.getElementById("BKMvsBKWCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "BKMvsBKW";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "BKMvsBKW Testcases";
	}
}
function ExpandCollapaseBKMvsGMCV() {
	var ele = document.getElementById("BKMvsGMCVTestcases");
	var text = document.getElementById("BKMvsGMCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "BKMvsGM";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "BKMvsGM Testcases";
	}
}
function ExpandCollapaseBKMvsRevenueCV() {
	var ele = document.getElementById("BKMvsRevenueCVTestcases");
	var text = document.getElementById("BKMvsRevenueCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "BKMvsRevenue";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "BKMvsRevenue Testcases";
	}
}
function ExpandCollapaseFINBIBKGvsBKMCV() {
	var ele = document.getElementById("FINBIBKGvsBKMCVTestcases");
	var text = document.getElementById("FINBIBKGvsBKMCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "FINBIBKGvsBKM";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "FINBIBKGvsBKM Testcases";
	}
}
function ExpandCollapaseFINBIBKGvsBKWCV() {
	var ele = document.getElementById("FINBIBKGvsBKWCVTestcases");
	var text = document.getElementById("FINBIBKGvsBKWCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "FINBIBKGvsBKW";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "FINBIBKGvsBKW Testcases";
	}
}
function ExpandCollapaseGMvsICPMCV() {
	var ele = document.getElementById("GMvsICPMCVTestcases");
	var text = document.getElementById("GMvsICPMCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "GMvsICPM";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "GMvsICPM Testcases";
	}
}
function ExpandCollapaseGMvsRevenueCV() {
	var ele = document.getElementById("GMvsRevenueCVTestcases");
	var text = document.getElementById("GMvsRevenueCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "GMvsRevenue";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "GMvsRevenue Testcases";
	}
}



/*function ExpandCollapaseBookingsCubeCV() {
	var ele = document.getElementById("BookingsCubeCVTestcases");
	var text = document.getElementById("BookingsCubeCV");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "Bookings Cube";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "Bookings Cube Testcases";
	}
}



function ExpandCollapaseAE() {
	var ele = document.getElementById("AETestcases");
	var text = document.getElementById("AE");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "AE";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "AE Testcases";
	}
	
	
}*/ 

function validateConfigForm()
{
var bookingsBOIP=document.forms["configForm"]["BookingsBOIP"].value;
var bookingsBODB=document.forms["configForm"]["BookingsBODB"].value;
/*
var bookingsCubeIP=document.forms["configForm"]["BookingsCubeIP"].value;
var bookingsCubeDB=document.forms["configForm"]["BookingsCubeBODB"].value;
/*
var cFAIP=document.forms["configForm"]["CFAIP"].value;
var cFADB=document.forms["configForm"]["CFADB"].value;

var pNLIP=document.forms["configForm"]["PNLIP"].value;
var pNLDB=document.forms["configForm"]["PNLDB"].value;

var revenueBOIP=document.forms["configForm"]["RevenueBOIP"].value;
var revenueBODB=document.forms["configForm"]["RevenueBODB"].value;*/
if (bookingsBOIP==null || bookingsBOIP==""||bookingsBODB==null || bookingsBODB=="")
  {
  alert("Please make sure both IP Address and Database is keyed in for a given stream");
  return false;
  }
/*
if (bookingsCubeIP==null || bookingsCubeIP=="",bookingsCubeDB==null || bookingsCubeDB=="")
{
alert("Please make sure both IP Address and Database is keyed in for a given stream");
return false;
}

if (cFAIP==null || cFAIP=="",cFADB==null || cFADB=="")
{
alert("Please make sure both IP Address and Database is keyed in for a given stream");
return false;
}

if (pNLIP==null || pNLIP=="",pNLDB==null || pNLDB=="")
{
alert("Please make sure both IP Address and Database is keyed in for a given stream");
return false;
}

if (revenueBOIP==null || revenueBOIP=="",revenueBODB==null || revenueBODB=="")
{
alert("Please make sure both IP Address and Database is keyed in for a given stream");
return false;
}*/
}

function validateemailid()
{
var emailid=document.forms["Form"]["emailid"].value;
if (emailid==null || emailid=="" ||emailid.length<10){
	alert("Please enter a valid email id");
	return false;
	
}

}

$(document).ready(function(){
    $(".tabbable").find(".tab").hide();
    $(".tabbable").find(".tab").first().show();
    $(".tabbable").find(".tabs li").first().find("a").addClass("active");
    $(".tabbable").find(".tabs").find("a").click(function(){
        tab = $(this).attr("href");
        $(".tabbable").find(".tab").hide();
        $(".tabbable").find(".tabs").find("a").removeClass("active");
        $(tab).show();
        $(this).addClass("active");
        return false;
    });
});

/*
adding custom block message
*/	
$('#custommessage').click(function()
{
$.blockUI(
{
	/*
		message displayed when blocking (use null for no message)
	*/
	message: '<h1><img src="images/please_wait.gif" /> </h1>'
});
setTimeout($.unblockUI, 3000);
});



$(document).ready(function() {
	$('#AESASJOBRUNOPTION').change(function()
			{
			$.blockUI(
			{
				/*
					message displayed when blocking (use null for no message)
				*/
				message: '<h1><img src="images/please_wait.gif" /> </h1>'
			});
			setTimeout($.unblockUI, 5000);
			});
});
$(document).ready(function() {
	$('#SourceServer').change(function()
			{
		alert("changed");
			});
});

$(document).ready(function() {
    $('#AESASJOBRUNOPTION').change(function() {
      var AESASJOBRUNOPTION = $('#AESASJOBRUNOPTION').val();
      $('#UpdateAESASNewOpenPeriod').removeAttr("disabled");
      $('#UpdateAESASOpenPeriodSubmit').removeAttr("disabled");
    $.ajax({
    type:'POST',	
    url: "AESASJobCurrentOpenPeriod",
    data: {AESASJOBRUNOPTION: AESASJOBRUNOPTION},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#result1").html(result);
    $("#result1").html(result).slideDown('fast');
     }
    });
});
});


$(document).ready(function() {
    $('#CubeValidationsStream').change(function() {
      var Stream = $('#CubeValidationsStream').val();
      
      var option = document.getElementById("CubeValidationsStream").value;
/*      if(option == "BookingsCube"){
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
      }
      if(option == "BookingsCubeVsBO"){
          document.getElementById("cubeValidationsServ1BO").style.display ="";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="none";
      }
      if(option == "PnlCube"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "PnlCubeVsBO"){
          document.getElementById("cubeValidationsServ1BO").style.display ="";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="none";
      }
      if(option == "L3Validation"){
          document.getElementById("cubeValidationsServ1Serv2").style.display ="none";
          document.getElementById("cubeValidationsServ1BO").style.display ="";
      }
      if(option == "ExpenseActual"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "ExpenseAllocated"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "Fetch"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "GLCube"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }*/
      if(option == "BKMvsBKW"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "BKMvsGM"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "BKMvsRevenue"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "FINBIBKGvsBKM"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "FINBIBKGvsBKW"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "GMvsICPM"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      if(option == "GMvsRevenue"){
          document.getElementById("cubeValidationsServ1BO").style.display ="none";
          document.getElementById("cubeValidationsServ1Serv2").style.display ="";
      }
      
    $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfig").html(result);
    $("#showCubeConfig").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigBookingsCube').click(function() {
      var Stream = "BookingsCube";
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigBookingsCube").html(result);
    $("#showCubeConfigBookingsCube").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigBookingsCubevsBO').click(function() {
      var Stream = "BookingsCubeVsBOTD";
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigBookingsCubevsBO").html(result);
    $("#showCubeConfigBookingsCubevsBO").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigPNLCubeCV').click(function() {
      var Stream = "RevenueCube";
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigPNLCubeCV").html(result);
    $("#showCubeConfigPNLCubeCV").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigPNLCubevsRevenueBOCV').click(function() {
      var Stream = "RevenueCubeVsBOTD";
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigPNLCubevsRevenueBOCV").html(result);
    $("#showCubeConfigPNLCubevsRevenueBOCV").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigExpenseActualCV').click(function() {
      var Stream = "ExpenseActual";
      /*alert("Expense Actual");*/
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigExpenseActualCV").html(result);
    $("#showCubeConfigExpenseActualCV").html(result).slideDown('fast');
     }
    });
});
});


$(document).ready(function() {
    $('#ViewCubeConfigExpenseAllocatedCV').click(function() {
      var Stream = "ExpenseAllocated";
      
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigExpenseAllocatedCV").html(result);
    $("#showCubeConfigExpenseAllocatedCV").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigFetchCV').click(function() {
      var Stream = "Fetch";
      
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigFetchCV").html(result);
    $("#showCubeConfigFetchCV").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigGLCV').click(function() {
      var Stream = "GLCube";
      
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigGLCV").html(result);
    $("#showCubeConfigGLCV").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
    $('#ViewCubeConfigL3ValidationsCV').click(function() {
      var Stream = "L3Validations";
      
       $.ajax({
    type:'POST',	
    url: "ViewCurrentCubeConfig",
    data: {Stream: Stream},
    cache: false,
    success: function(result) {
    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
    $("#showCubeConfigL3ValidationsCV").html(result);
    $("#showCubeConfigL3ValidationsCV").html(result).slideDown('fast');
     }
    });
});
});

$(document).ready(function() {
	$('#ViewCubeConfigBKMvsBKWCV').click(function() {
	      var Stream = "BKMvsBKW";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigBKMvsBKWCV").html(result);
	    $("#showCubeConfigBKMvsBKWCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
	$('#ViewCubeConfigBKMvsGMCV').click(function() {
	      var Stream = "BKMvsGM";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigBKMvsGMCV").html(result);
	    $("#showCubeConfigBKMvsGMCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
	$('#ViewCubeConfigBKMvsRevenueCV').click(function() {
	      var Stream = "BKMvsRevenue";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigBKMvsRevenueCV").html(result);
	    $("#showCubeConfigBKMvsRevenueCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
	$('#ViewCubeConfigFINBIBKGvsBKMCV').click(function() {
	      var Stream = "FINBIBKGvsBKM";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigFINBIBKGvsBKMCV").html(result);
	    $("#showCubeConfigFINBIBKGvsBKMCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
	$('#ViewCubeConfigFINBIBKGvsBKWCV').click(function() {
	      var Stream = "FINBIBKGvsBKW";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigFINBIBKGvsBKWCV").html(result);
	    $("#showCubeConfigFINBIBKGvsBKWCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
	$('#ViewCubeConfigGMvsICPMCV').click(function() {
	      var Stream = "GMvsICPM";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigGMvsICPMCV").html(result);
	    $("#showCubeConfigGMvsICPMCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
	$('#ViewCubeConfigGMvsRevenueCV').click(function() {
	      var Stream = "GMvsRevenue";
	      $.ajax({
	    type:'POST',	
	    url: "ViewCurrentCubeConfig",
	    data: {Stream: Stream},
	    cache: false,
	    success: function(result) {
	    /*result_without_path = result.replace("Served at: /FINBI_E2E ","");*/
	    $("#showCubeConfigGMvsRevenueCV").html(result);
	    $("#showCubeConfigGMvsRevenueCV").html(result).slideDown('fast');
	     }
	    });
	});
	});
$(document).ready(function() {
    $('#select').change(function() {
      var SourceServer = "select";
      alert("selected value: "+ SourceServer);

});
});





