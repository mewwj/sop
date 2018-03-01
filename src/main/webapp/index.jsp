<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>上传文件</title>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
</head>
<body>
<h1>HELLO WORLD!</h1>
springmvc上传文件
<table class='table'>
<tbody>
<tr>
<td>
<form name="uploadfileform" id="uploadfileform" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="text" name="buMen">
    <input type="text" name="xiTong">
    <input type="button" id="submit" value="上传" onclick="doUpload()"/>
</form>
</td>
</tr>
</tbody>
</table>
</body>
<script src="js/jquery.js" charset="utf-8"></script>
<script src="js/jquery.form.js" charset="utf-8"></script>
<script type="text/javascript">
	function doUpload(){  
	     var formData = new FormData($( "#uploadfileform" )[0]);  
	     $.ajax({  
	          url: '/sop/manage/upload_file.do' ,  
	          type: 'POST',  
	          data: formData,  
	          async: false,  
	          cache: false,  
	          contentType: false,  
	          processData: false,  
	          success: function (returndata) {  
	        	  item="<tr><td style=\"text-color:red\">上传成功！</td></tr>";
	            	$('.table').append(item);
	          },  
	          error: function (returndata) {  
	        	  item="<tr><td style=\"text-color:red\">上传失败！</td></tr>";
	            	$('.table').append(item);
	          }  
	     });  
	}  

</script>
</html>