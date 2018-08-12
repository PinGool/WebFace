<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	
		<script type="text/javascript" src="Js/webcam.js"></script>
	</head>

	<body> 
		<!--  	  <div id="my_result" style="width:120px; height:150px;"></div>-->
		<form method="post" action="FaceUser_IdenFace.action" id="myform"  onsubmit="return validateForm( );">
			<div id="preview" style="width:260px; height:180px"></div>
			<br />
			<input type="button" value="拍照" onclick="takePhoto()" />
<%--			<input type="button" value="上传" onclick="upload()" />--%>
			<input id="mydata" type="hidden" name="mydata" value=""/>
			<input type="submit" value="上传">
<%--			<input type="file" onchange="uploadLocalPicture(this)" />--%>
		</form>

		<script language="JavaScript">
		var ret ;
		document.getElementById('preview').innerHTML = '<img style="width:260px; height:180px" src="Images/noimg.png"/>';
     	function takePhoto(){
			ret = window.open('takephoto.html', 'newwindow', 'height=300, width=320, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');   //该句写成一行
     	}
     	 function upload(){
        	 Webcam.upload(image_data, 'UploadImage', function(code, text) {
	            // Upload complete!-->
	            // 'code' will be the HTTP response code from the server, e.g. 200-->
	            // 'text' will be the raw response content-->
	            alert(code+"--"+text);
	         } );
        }
     	//兼容ie6,7,8
     	function validateForm(){  
			var image_data = ret.imageuri;
            
     		var raw_image_data = image_data.replace(/^data\:image\/\w+\;base64\,/, '');
            document.getElementById('mydata').value = raw_image_data;
            document.getElementById('myform').submit();
            
     	    return true;  
     	  }  
        
     	function uploadLocalPicture(file){
     	  var MAXWIDTH  = 260; 
          var MAXHEIGHT = 180;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])//object FileList  objec File
          {
              div.innerHTML ='<img id=showimg>';
              var img = document.getElementById('showimg');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}//evt.target.result:图像字符串数据
             document.write(evt.target.result);
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
        	alert("ie");
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=showimg>';
            var img = document.getElementById('showimg');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
           function clacImgZoomParam( maxWidth, maxHeight, width, height ){
	            var param = {top:0, left:0, width:width, height:height};
	            if( width>maxWidth || height>maxHeight )
	            {
	                rateWidth = width / maxWidth;
	                rateHeight = height / maxHeight;
	                 
	                if( rateWidth > rateHeight )
	                {
	                    param.width =  maxWidth;
	                    param.height = Math.round(height / rateWidth);
	                }else
	                {
	                    param.width = Math.round(width / rateHeight);
	                    param.height = maxHeight;
	                }
	            }
	            param.left = Math.round((maxWidth - param.width) / 2);
	            param.top = Math.round((maxHeight - param.height) / 2);
	            return param;
	        }
     	}
     </script>
	</body>
</html>
