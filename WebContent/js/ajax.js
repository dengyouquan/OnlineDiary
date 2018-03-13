function createXMLHttpRequest(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
	    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	    xmlhttp=new XMLHttpRequest();
	}
	else
	{
	    // IE6, IE5 浏览器执行代码
	    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function ajaxReqGet(url,args,container){
	var xmlhttp = createXMLHttpRequest();
	alert(xmlhttp);
	xmlhttp.onreadystatechange=function()
	  {
	    if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	      document.getElementById(container).innerHTML=xmlhttp.responseText;
	    }
	  }
	  xmlhttp.open("GET",url+"?"+args,true);
	  xmlhttp.send();
}
function ajaxReqPost(url,args,container){
	var xmlhttp = createXMLHttpRequest();
	alert(xmlhttp);
	xmlhttp.onreadystatechange=function()
	  {
	    if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	      document.getElementById(container).innerHTML=xmlhttp.responseText;
	    }
	  }
	  xmlhttp.open("POST",url,true);
	  setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")  
	  xmlhttp.send(args);
}
