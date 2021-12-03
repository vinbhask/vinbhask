$(document).ready(function() {
    $('#SourceServer').change(function() {
    	var SourceServer=document.getElementById("SourceServer").value; 
    	/*alert(SourceServer);*/
		$.blockUI(
				{
					message: '<h1><img src="images/please_wait.gif" /> </h1>'
				});
				setTimeout($.unblockUI, 3000);
				
				$.ajax({
				    type:'POST',	
				    url: "FetchDatabaseDetails",
				    data: {SourceServer: SourceServer},
				    cache: false,
				    success: function(responseJson) {
				    	var $select = $("#SourceSchema");                           // Locate HTML DOM element with ID "someselect".
				        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
				            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
				     }
				    });
});
});

$(document).ready(function() {
    $('#SourceSchema').change(function() {
    	var SourceSchema=document.getElementById("SourceSchema").value; 
    	/*alert(SourceSchema);*/
		$.blockUI(
				{
					message: '<h1><img src="images/please_wait.gif" /> </h1>'
				});
				setTimeout($.unblockUI, 3000);
				
				$.ajax({
				    type:'POST',	
				    url: "FetchDatabaseDetails",
				    data: {SourceSchema: SourceSchema,SourceServer: 'Oracle'},
				    cache: false,
				    success: function(responseJson) {
				    	/*alert(responseJson);*/
				    	var $select = $("#SourceTable");                           // Locate HTML DOM element with ID "someselect".
				        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
				            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
				     }
				    });
});
});
$(document).ready(function() {
    $('#SourceTable').change(function() {
    	var SourceTable=document.getElementById("SourceTable").value; 
    	/*alert(SourceTable);*/
		$.blockUI(
				{
					message: '<h1><img src="images/please_wait.gif" /> </h1>'
				});
				setTimeout($.unblockUI, 3000);
				
				$.ajax({
				    type:'POST',	
				    url: "FetchDatabaseDetails",
				    data: {SourceTable: SourceTable,SourceServer: 'Oracle'},
				    cache: false,
				    success: function(responseJson) {
				    	/*alert(responseJson);*/
				    	var $select = $("#SourceColumns");                           // Locate HTML DOM element with ID "someselect".
				        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
				            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
				     }
				    });
});
});

$(document).ready(function() {
    $('#TargetServer').change(function() {
    	var TargetServer=document.getElementById("TargetServer").value; 
    	/*alert(SourceServer);*/
		$.blockUI(
				{
					message: '<h1><img src="images/please_wait.gif" /> </h1>'
				});
				setTimeout($.unblockUI, 3000);
				
				$.ajax({
				    type:'POST',	
				    url: "FetchDatabaseDetails",
				    data: {TargetServer: TargetServer,TargetServer: 'Postgres'},
				    cache: false,
				    success: function(responseJson) {
				    	var $select = $("#TargetSchema");                           // Locate HTML DOM element with ID "someselect".
				        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
				            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
				     }
				    });
});
});

$(document).ready(function() {
    $('#TargetSchema').change(function() {
    	var TargetSchema=document.getElementById("TargetSchema").value; 
    	/*alert(SourceServer);*/
		$.blockUI(
				{
					message: '<h1><img src="images/please_wait.gif" /> </h1>'
				});
				setTimeout($.unblockUI, 3000);
				
				$.ajax({
				    type:'POST',	
				    url: "FetchDatabaseDetails",
				    data: {TargetSchema: TargetSchema,TargetServer: 'Postgres'},
				    cache: false,
				    success: function(responseJson) {
				    	var $select = $("#TargetTable");                           // Locate HTML DOM element with ID "someselect".
				        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
				            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
				     }
				    });
});
});
$(document).ready(function() {
    $('#TargetTable').change(function() {
    	var TargetTable=document.getElementById("TargetTable").value; 
    	/*alert(SourceServer);*/
		$.blockUI(
				{
					message: '<h1><img src="images/please_wait.gif" /> </h1>'
				});
				setTimeout($.unblockUI, 3000);
				
				$.ajax({
				    type:'POST',	
				    url: "FetchDatabaseDetails",
				    data: {TargetTable: TargetTable,TargetServer: 'Postgres'},
				    cache: false,
				    success: function(responseJson) {
				    	var $select = $("#TargetColumns");                           // Locate HTML DOM element with ID "someselect".
				        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
				            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
				     }
				    });
});
});

$(document).ready(function() {

    var iCnt = 0;
    // CREATE A "DIV" ELEMENT AND DESIGN IT USING jQuery ".css()" CLASS.
    /*var container = $(document.createElement('div')).css({
        padding: '5px', margin: '20px', width: '170px', border: '1px dashed',
        borderTopColor: '#999', borderBottomColor: '#999',
        borderLeftColor: '#999', borderRightColor: '#999' //session.setAttribute("targetColumns", options);session.setAttribute("sourceColumns", options);
    });*/
    
    //var choices = '<%= session.getAttribute("sourceColumns") %>';
    var choices = ["one", "two"];
    $('#btAdd').click(function() {
    	/*alert('add button clicked');
    	alert(name);*/
    	//alert(choices);
    	var SourceServer=document.getElementById("SourceServer").value;
    	var SourceSchema=document.getElementById("SourceSchema").value;
    	var SourceTable=document.getElementById("SourceTable").value;
    	var TargetServer=document.getElementById("TargetServer").value;
    	var TargetSchema=document.getElementById("TargetSchema").value;
    	var TargetTable=document.getElementById("TargetTable").value;
    	iCnt=iCnt+1;
    	/*var selectend = $("<select/> <br>")
        var select = $("<select id=sosource" + iCnt +" name=sosource"+iCnt+" class="+"\"selectClass\""+">")
        $.each(choices, function(a, b) {
            select.append($("<option/>").attr("value", b).text(b));
        });
        $("#Columnselector").append(select);*/
    	/*alert(iCnt);*/
		$.ajax({
		    type:'POST',	
		    url: "FetchDatabaseDetails",
		    data: {Counter: iCnt,SourceServer:SourceServer,SourceTable:SourceTable,TargetServer:TargetServer,TargetTable:TargetTable},
		    cache: false,
		    success: function(responseJson) {
		    	var arr1 = responseJson[0]
		    	var arr2 = responseJson[1]
		    	var sselectend = $("<select/> <br>")
		    	var sselect = $("<select id=sosource" + iCnt +" name=sosource"+iCnt+" class="+"\"selectClass\""+">")
		    	var tselectend = $("<select/> <br/>")
		    	var linebreak = $("<br/>")
		    	var space = $(" ") 
		    	var tselect = $("<select id=sotarget" + iCnt +" name=sotarget"+iCnt+" class="+"\"selectClass\""+">")
		    	/*var $select = $("#TargetColumns"); */                          // Locate HTML DOM element with ID "someselect".
		       /* $select.find("option").remove();*/                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
		        /*$.each(arr, function(key, value) {               // Iterate over the JSON object.
		            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
		            select.append($("<option>").val(key).text(value));
		        });*/
		    	/*var container = $(document.createElement('div')).css({
            padding: '10px', margin: '30px', width: '300px', border: '1px dashed',
            borderTopColor: '#999', borderBottomColor: '#999',
            borderLeftColor: '#999', borderRightColor: '#999'
		    	});*/
		    	//var container = $( document.createElement('div') );
		    	$.each(arr1, function(key, val){
		    		 /*'<option value="' + val + '">' + val + '</option>';*/
		    		 sselect.append($("<option value=" + "\""+val+"\"" + '>' + val + '</option>'));
                });
		    	$.each(arr2, function(key, val){
		    		 /*'<option value="' + val + '">' + val + '</option>';*/
		    		 tselect.append($("<option value=" + "\""+val+"\"" + '>' + val + '</option>'));
               });
		    	  /*$("#Columnselector").append(sselect);
		    	  $("#Columnselector").append(tselect).append("<br><br>");*/
		    	  $("#Columnselector").after(linebreak,sselect,space,tselect,linebreak);
		    	  
		    	  
		    	/*$("#container").append(sselect).append(" ");
		    	  $("#container").append(tselect)
		    	  $("#container").append("abcdaa")
		    	$('#ColumnDisplay').append(container);*/
		     }
		    });
		
    });

    
    });