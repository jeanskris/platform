// JavaScript Document
$(document).ready(function(){
				
			var xmlHttp;
			var homejson;
			var monitorjson;
			//閫氳繃鍚戞湇鍔″櫒璇锋眰鏉ュ垵濮嬪寲椤甸潰淇℃伅		
			function createXMLHttpRequest() {
   				 if (window.ActiveXObject) {
      				  xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
   				 } 
   				 else if (window.XMLHttpRequest) {
        				xmlHttp = new XMLHttpRequest();
    				}
				}
				
						
			
			//閫氳繃post鏂规硶鍙戦?璇锋眰
			function ajax(string){	
    			var url = "WebMonitorDev?timeStamp=" + new Date().getTime();
   				
    			var Json = JSON.stringify(string);
				console.log(Json);
				//alert("0");
    			 createXMLHttpRequest();
   				//alert("1");
   				 xmlHttp.open("post", url, true);
  				 //alert("2");
  				 xmlHttp.onreadystatechange = handleStateChange;
				 
				 xmlHttp.setRequestHeader("Content-Type", "application/json"); 
  				 //alert("3");  
   				 xmlHttp.send(Json);//鍥犱负send()鍑芥暟鏃犲弬鏁帮紝鎵?互鐢╣et鏂规硶
  			 	//alert("4");
		    }
 		
			//鐘舵?鏀瑰彉澶勭悊鍑芥暟锛屽綋鐘舵?鏀瑰彉鏃惰皟鐢?
			function handleStateChange() {
   				 if(xmlHttp.readyState == 4) {
        				if(xmlHttp.status == 200) {
        					console.log("5");
           					 parseResults();
            
       					 }
    			}
				
			}
			
		//鍥炶皟鍑芥暟,鐢ㄤ簬鏄剧ず鏈嶅姟鍣ㄨ繑鍥炵殑淇℃伅
		function parseResults() {
				 
				 //alert("6");
 
  				 var responseJson = JSON.parse(xmlHttp.responseText);//灏嗘湇鍔″櫒鍙戝洖鐨勬暟鎹浆鎹负json鏍煎紡
   				//alert(responseJson);
   
  				 //瀵规湇鍔″櫒杩斿洖鐨勬暟鎹繘琛屾樉绀?
				 var action1 = responseJson.action;
				 
				 var data = responseJson.data; 
				 
				 var result = "";
				 
				 if(action1 == "homeInit"){
				 
				 	console.log(data);
    				$.each(data, function(index, json) { 
					$("#table11").append('<tr class ="homefur" id ="'+json.devid+'"></tr>');
					result += '<td><h3><a href="#">' + json.devid + '</a></h3></td>';
					result += "<td>" + json.devname + "</td>";
					result += "<td>" + json.status + "</td>";
					result += "<td>";
					for(var x in json.data)
					{
						result += x + ":" + json.data[x] + ";";
					}
					result += "</td>";
					result += "<td>" + json.pos + "</td>";
					result += "<td>" + json.devType + "</td>";
					result += '<td><a href="#" class="ico edit home1">Edit</a><a href="#" class="ico del">Delete</a></td>';
	 				$('#'+json.devid).html(result);
					result = "";
					//console.log("#" + json.week + ", period: " + json.start + " to " + json.end); 
					});
					
					
					//寮瑰嚭瀹跺叿璁惧缂栬緫妗?
					$(".home1").hover(function () {
							$(this).stop().animate({
								opacity: '1'
							}, 600);
					}, function () {
							$(this).stop().animate({
								opacity: '0.6'
					}, 1000);
					}).on('click', function () {
							var parent1 = $(this).parent(); 		
							var parent2 = parent1.parent();
							var id = parent2.attr("id");
							console.log(id);
							var change_home = changeHomeInitObject(id);
							ajax(change_home);
							$("body").append("<div id='mask'></div>");
							$("#mask").addClass("mask").fadeIn("slow");//fadeIn鐢ㄤ簬娣″叆宸茬粡闅愯棌鐨勫厓绱?
							$("#LoginBox").fadeIn("slow");//棣栧厛寮瑰嚭杈撳叆璐﹀彿鐨勭獥鍙?
						});
				
				}
				else if(action1 == "monitorInit"){
				    
					$.each(data, function(index, json) { 
					$("#table21").append('<tr class ="monitorfur" id ="'+json.devid+'"></tr>');
					result += '<td><h3><a href="#">' + json.devid + '</a></h3></td>';
					result += "<td>" + json.devname + "</td>";
					result += "<td>" + json.status + "</td>";
					result += "<td>";
					for(var x in json.data)
					{
						result += x + ":" + json.data[x] + ";";
					}
					result += "</td>";
					
					result += "<td>" + json.threshold + "</td>";
					result += "<td>" + json.pos + "</td>";
					result += "<td>" + json.devType + "</td>";
					result += '<td><a href="#" class="ico edit monitor1">Edit</a><a href="#" class="ico del">Delete</a></td>';
	 				$('#'+json.devid).html(result);
					result = "";
					});
					
					
					//寮瑰嚭鐩戞帶璁惧缂栬緫妗?
					$(".monitor1").hover(function () {
							$(this).stop().animate({
								opacity: '1'
							}, 600);
					}, function () {
							$(this).stop().animate({
								opacity: '0.6'
					}, 1000);
					}).on('click', function () {
							var parent1 = $(this).parent(); 		
							var parent2 = parent1.parent();
							var id = parent2.attr("id");
							console.log(id);
							var change_monitor = changeMonitorInitObject(id);
							ajax(change_monitor);
							$("body").append("<div id='mask'></div>");
							$("#mask").addClass("mask").fadeIn("slow");//fadeIn鐢ㄤ簬娣″叆宸茬粡闅愯棌鐨勫厓绱?
							$("#LoginBox_2").fadeIn("slow");//棣栧厛寮瑰嚭杈撳叆璐﹀彿鐨勭獥鍙?
					});
					
				}
				else if(action1 == "homechange"){
					console.log(data);
					var home_datahtml = "";
					$.each(data, function(index, json) { 
					homejson = json.data;
					$("#devid").text(json.devid);
					$("#name").text(json.devname);				
					$("#status").text(json.status);
					for(var x in json.data)
					{
						home_datahtml += "</br></br>";
						home_datahtml += x;
						home_datahtml += '<input type="text" class="input" id="'+x+'"value="'+json.data[x]+'" />';
					}
					home_datahtml += '<input type="button" id="home_datasave" value="save" style="float: right;" />'
					$("#home_data").html(home_datahtml);
					$("#pos").text(json.pos);
					$("#devType").text(json.devType);
					result += '<td><h3><a href="#">' + json.devid + '</a></h3></td>';
					result += "<td>" + json.devname + "</td>";
					result += "<td>" + json.status + "</td>";
					result += "<td>";
					for(var x in json.data)
					{
						result += x + ":" + json.data[x] + ";";
					}
					result += "</td>";
					result += "<td>" + json.pos + "</td>";
					result += "<td>" + json.devType + "</td>";
					result += '<td><a href="#" class="ico edit home1">Edit</a><a href="#" class="ico del">Delete</a></td>';
	 				$('#'+json.devid).html(result);
					result = "";
					console.log("devid"+json.devid);
					//console.log("#" + json.week + ", period: " + json.start + " to " + json.end); 
					});
					
					
					$(".home1").hover(function () {
							$(this).stop().animate({
								opacity: '1'
							}, 600);
					}, function () {
							$(this).stop().animate({
								opacity: '0.6'
					}, 1000);
					}).on('click', function () {
							var parent1 = $(this).parent(); 		
							var parent2 = parent1.parent();
							var id = parent2.attr("id");
							console.log(id);
							var change_home = changeHomeInitObject(id);
							ajax(change_home);
							$("body").append("<div id='mask'></div>");
							$("#mask").addClass("mask").fadeIn("slow");//fadeIn鐢ㄤ簬娣″叆宸茬粡闅愯棌鐨勫厓绱?
							$("#LoginBox").fadeIn("slow");//棣栧厛寮瑰嚭杈撳叆璐﹀彿鐨勭獥鍙?
						});
				
				}
				else if(action1  == "monitorchange"){
					var monitor_datahtml = "";
					$.each(data, function(index, json) { 
					monitorjson = json.data;
					$("#devid2").text(json.devid);
					$("#name2").text(json.devname);				
					$("#status2").text(json.status);
					for(var x in json.data)
					{
						monitor_datahtml += "</br></br>";
						monitor_datahtml += x;
						monitor_datahtml += '<input type="text" class="input" id="'+x+'"value="'+json.data[x]+'" />';
						
					}
					monitor_datahtml += '<input type="button" id="monitor_datasave" value="save" style="float: right;" />'
					$("#monitor_data").html(monitor_datahtml);
					$("#threshold2").text(json.threshold);
					$("#pos2").text(json.pos);
					$("#devType2").text(json.devType);
					result += '<td><h3><a href="#">' + json.devid + '</a></h3></td>';
					result += "<td>" + json.devname + "</td>";
					result += "<td>" + json.status + "</td>";
					result += "<td>";
					for(var x in json.data)
					{
						result += x + ":" + json.data[x] + ";";
					}
					result += "</td>";
					result += "<td>" + json.threshold + "</td>";
					result += "<td>" + json.pos + "</td>";
					result += "<td>" + json.devType + "</td>";
					result += '<td><a href="#" class="ico edit monitor1">Edit</a><a href="#" class="ico del">Delete</a></td>';
	 				$('#'+json.devid).html(result);
					result = "";
					//console.log("#" + json.week + ", period: " + json.start + " to " + json.end); 
					});
					
					
					$(".monitor1").hover(function () {
							$(this).stop().animate({
								opacity: '1'
							}, 600);
					}, function () {
							$(this).stop().animate({
								opacity: '0.6'
					}, 1000);
					}).on('click', function () {
							var parent1 = $(this).parent(); 		
							var parent2 = parent1.parent();
							var id = parent2.attr("id");
							console.log(id);
							var change_monitor = changeMonitorInitObject(id);
							ajax(change_monitor);
							$("body").append("<div id='mask'></div>");
							$("#mask").addClass("mask").fadeIn("slow");//fadeIn鐢ㄤ簬娣″叆宸茬粡闅愯棌鐨勫厓绱?
							$("#LoginBox_2").fadeIn("slow");//棣栧厛寮瑰嚭杈撳叆璐﹀彿鐨勭獥鍙?
					});
				}
     			
				//alert("7");
			}//parseResults


		$("#adddevice").click(function(){
			
			var device_new = getDeviceNewObject();
			ajax(device_new);
		});
		
		
		$("#conectdevice").click(function(){
			
			var device_new = getDeviceConObject();
			ajax(device_new);
		});
		//鐐瑰嚮瀹跺眳璁惧鏃跺彂鐢熺殑鎸夐挳缁戝畾鏃堕棿
		$("#box-head1").click(function(){
			//$("#table1").slideToggle("slow");
			
			$(".homefur").remove();
			var home_init = gethomeInitObject();
			//var homeInitAsJson = JSON.stringify(home_init);
			ajax(home_init);
		});
		
		$("#box-head2").click(function(){
			$(".monitorfur").remove();
			//$("#table1").slideToggle("slow");
			var monitor_init = getmonitorInitObject();
			//var monitorInitAsJson = JSON.stringify(monitor_init);
			ajax(monitor_init);
		});
		

		$("#id_save").click(function(){
			
			var txtTel= $("#newid").val();
			if (txtTel == "" || txtTel == undefined || txtTel == null) {
				alert("shu ru de bu neng wei kong");
				return false;
			}
			else{
				
				var r=confirm("Do you really want to save it?");
				if (r==true)
  				{
  				var new_name = homeNameObject();
				//var newTelAsJson = JSON.stringify(new_tel);
				ajax(new_name);
  				}
				else
  				{
  				alert("You pressed Cancel!");
  				}	
			}
    		
 		});
		
		$("#id_save2").click(function(){
			
			var txtTel= $("#newid2").val();
			if (txtTel == "" || txtTel == undefined || txtTel == null) {
		        alert("shu ru de bu neng wei kong");
				return false;
			}
			else{
				var r=confirm("Do you really want to save it?");
				if (r==true)
  				{
				var new_name = minitorNameObject();
				//var newTelAsJson = JSON.stringify(new_tel);
				ajax(new_name);
				}
				else
  				{
  				alert("You pressed Cancel!");
  				}	
			}
    		
 		});
	
		$("#name_edit").click(function(){
					
					var label = $("#name_edit").text();
					if( label == "Edit"){
						$("#newid").val("");
						$("#name_edit1").slideToggle("slow");
						$("#name_edit").text("Up");
					}
					else{
						$("#name_edit1").slideToggle("slow");
				 		$("#name_edit").text("Edit");
						}
 			 });
			 
		$("#status_edit").click(function(){
					var label = $("#status_edit").text();
					if( label == "Edit"){
						var middle = $("#status").text();
						if (middle == "on"){var status = true;}
						else{var status = false ;}
						$("#control").attr("checked",status);
						$("#status_edit1").slideToggle("slow");
						$("#onoff").slideToggle("slow");
						$("#status_edit").text("Up");
					}
					else{
						$("#onoff").slideToggle("slow");
						$("#status_edit1").slideToggle("slow");

				 		$("#status_edit").text("Edit");
						}
 			 });
			 
		$("#name_edit2").click(function(){
					
					var label = $("#name_edit2").text();
					if( label == "Edit"){
						$("#newid2").val("");
						$("#name_edit3").slideToggle("slow");
						$("#name_edit2").text("Up");
					}
					else{
						$("#name_edit3").slideToggle("slow");
				 		$("#name_edit2").text("Edit");
						}
 			 });
			 
		$("#status_edit2").click(function(){
					var label = $("#status_edit2").text();
					if( label == "Edit"){
						var middle = $("#status2").text();
						if (middle == "on"){var status = true;}
						else{var status = false ;}
						$("#control1").attr("checked",status);
						$("#status_edit3").slideToggle("slow");
						$("#onoff1").slideToggle("slow");
						$("#status_edit2").text("Up");
					}
					else{
						$("#onoff1").slideToggle("slow");
						$("#status_edit3").slideToggle("slow");

				 		$("#status_edit2").text("Edit");
						}
 			 });
	
		$("#onoff").click(function(){
		
			var middle = document.getElementById("control").checked;
			if (middle == true){status = "on";}
			else{status = "off" ;}
    		var new_status = homeStatusObject(status);
				//var newTelAsJson = JSON.stringify(new_tel);
			ajax(new_status);
		});
		
		$("#onoff1").click(function(){
		
			var middle = document.getElementById("control1").checked;
			if (middle == true){status = "on";}
			else{status = "off" ;}
    		var new_status = monitorStatusObject(status);
				//var newTelAsJson = JSON.stringify(new_tel);
			ajax(new_status);
		});

		$(document).on("click","#home_datasave",function(){
			for(var x in homejson)
			{
			 homejson[x] = $('#'+x).val();
			}
			var action = "editHomeData";
			var id = $("#devid").text();
			var r=confirm("Do you really want to save it?");
			if (r==true)
  			{
			var homedach = new homeDach(id,action,homejson);
			ajax(homedach);
			}
			else
  			{
  			alert("You pressed Cancel!");
  			}
		});
		
		$(document).on("click","#monitor_datasave",function(){
			for(var x in monitorjson)
			{
			 monitorjson[x] = $('#'+x).val();			
			}
			var action = "editMonitorData";
			var id = $("#devid2").text();
			var r=confirm("Do you really want to save it?");
			if (r==true)
  			{
			var monitordach = new homeDach(id,action,monitorjson);
			ajax(monitordach);
			}
			else
  			{
  			alert("You pressed Cancel!");
  			}
		});
		
		$(document).on("click",".del",function(){
							var parent1 = $(this).parent(); 		
							var parent2 = parent1.parent();
							var id = parent2.attr("id");
							console.log(id);
							var r=confirm("Do you really want to delete it?");
							if (r==true)
  							{
							var device_delete = devDelInitObject(id);
							ajax(device_delete);
							$("#"+id).remove();
							}
							else
  							{
  							alert("You pressed Cancel!");
  							}
		});

		
	function devDelInitObject(id){
		var id = id;
		var action = "deletedevice";
		var new_device = new deviceDel(id,action);
		ajax(new_device);
	}
	
	function deviceDel(id,action){
		this.id = id;
		this.action  = action;
	}
	function getDeviceConObject(){
		var name = $("#newdevicename").val();
		var action = "connectdevice";
		var new_device = new deviceCon(name,action);
		ajax(new_device);
	}
		
	
	function deviceCon(name,action)
	{
		this.name = name;
		this.action = action;
	}
	function getDeviceNewObject(){
		var name = $("#newdevicename").val();
		var first3 = $("#first3").val();
		var pos =	$("#selectposition").val();
		var type = $("#selecttype").val();
		var last4 = $("#last4").val();
		var action = "adddevice";
		var new_device = new deviceNew(name,first3,pos,type,last4,action);
		ajax(new_device);
	}
	
	function deviceNew(name,first3,pos,type,last4,action){
		this.name = name;
		this.first3 = first3;
		this.pos = pos;
		this.type = type;
		this.last4 = last4; 
		this.action = action;
	}
	
	
	function homeDach(id,action,monitorjson){
		this.id = id;
		this.action = action;
		this.data = monitorjson;
	}
	function homeDach(id,action,homejson){
		this.id = id;
		this.action = action;
		this.data = homejson;
	}
	
	function monitorStatusObject(status) {
	var id = $("#devid2").text();
    var new_status = status;
	var action = "monitorStatus";
	var tel = new newMonitorStatus(id,new_status,action);
	return tel;
}

	function newMonitorStatus(id,new_status,action) {
    this.id = id;
	this.status = new_status;
	this.action = action;
}	
	
	function homeStatusObject(status) {
	var id = $("#devid").text();
    var new_status = status;
	var action = "homeStatus";
	var tel = new newHomeStatus(id,new_status,action);
	return tel;
}

	function newHomeStatus(id,new_status,action) {
    this.id = id;
	this.status = new_status;
	this.action = action;
}	
	
	function monitorNameObject() {
	var id = $("#devid2").text();
    var new_name = $("#newid2").val();
	var action = "monitorName";
	var tel = new newMonitorName(id,new_name,action);
	return tel;
}

	function newMonitorName(id,new_name,action) {
    this.id = id;
	this.name = new_name;
	this.action = action;
}

	function homeNameObject() {
	var id = $("#devid").text();
    var new_name = $("#newid").val();
	var action = "homeName";
	var tel = new newHomeName(id,new_name,action);
	return tel;
}

	function newHomeName(id,new_name,action) {
    this.id = id;
	this.name = new_name;
	this.action = action;
}

	function gethomeInitObject(){
	var usernametop = $("#usernametop").val();
	var action = "homeInit";
	var home1 = new home(usernametop,action);
	return home1;
}
	
	function home(usernametop,action){
	this.username = usernametop;
	this.action = action;
}

	function getmonitorInitObject(){
	var usernametop = $("#usernametop").val();
	var action = "monitorInit";
	var monitor1 = new monitor(usernametop,action);
	return monitor1;
}
	
	function monitor(usernametop,action){
	this.username = usernametop;
	this.action = action;
}

	function changeHomeInitObject(id){
	var devid = id;
	var action = "changeHomeInit";
	var changehome1 = new changHome(devid,action);
	return changehome1;
}

	function changHome(devid,action){
	this.id = devid;
	this.action = action;
}

	function changeMonitorInitObject(id){
	var devid = id;
	var action = "changeMonitorInit";
	var changemonitor1 = new changMonitor(devid,action);
	return changemonitor1;
}

	function changMonitor(devid,action){
	this.id = devid;
	this.action = action;
}
	//璋冪敤ajax鍑芥暟鍒濆鍖栭〉闈?
	
	var a=gethomeInitObject();
	ajax(a);
	

});
