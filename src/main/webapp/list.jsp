<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示页面</title>
</head>
<body>
<table style="border:1px solid" id="list" >
<tbody>
<tr>
<td colspan="10">
<form name="searchform" id="searchform"> 筛选条件：
<input id="select1" name="buMen" > +
<input id="select2" name="xiTong" ></form>
</td>
</tr>
<tr>
<td colspan="10">
	<a onclick='allaclick(this);doSearch();' href="#">所有</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">1</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">2</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">3</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">4</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">5</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">6</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='aclick(this);doSearch();' href="#">7</a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
<tr>
	<td colspan="10">
		<a onclick='allbclick(this);doSearch();' href="#">所有</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">1</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">2</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">3</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">4</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">5</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">2</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick='bclick(this);doSearch();' href="#">2</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
</tr>
<tr>
	<td>
		<div id="listsop">
			
		</div>
	</td>
</tr>

</tbody>
</table>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
function aclick(self){
	var a=self.innerHTML;
	document.getElementById("select1").value=a;
}
function bclick(self){
	var a=self.innerHTML;
	document.getElementById("select2").value=a;
}
function allaclick(self){
	var a=self.innerHTML;
	document.getElementById("select1").value=a;
}
function allbclick(self){
	var a=self.innerHTML;
	document.getElementById("select2").value=a;
}
function doSearch(){  
	str="";
    var formData = new FormData($( "#searchform" )[0]);  
    $.ajax({  
         url: '/sop/portal/search.do' ,  
         type: 'POST',  
         data: formData,  
         dataType:"json",
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (data) {  
        	 	console.log(data);
        	 	if(data.data.length!=0){
        	 	for(var i=0;i<data.data.length;i++){
        			str +="<a href=/sop/manage/download_file.do?filename="+data.data[i].fileName+">";
        			str += data.data[i].fileName;
        			str += "</a>";
        		}
        		document.getElementById("listsop").innerHTML=str;
        	 	}else{
        	 		document.getElementById("listsop").innerHTML="该条件下数据为空！";	
        	 	}
         	},  
        	 error: function (data) { 
         		str += "数据为空！";
         		document.getElementById("listsop").innerHTML=str;
         }  
   
    });  
}  
</script>




</html>