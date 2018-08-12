<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
	<script type="text/javascript" src="Js/jquery-1.8.3.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <table border="1">
    	<tr>
    		<td>图片名称</td>
    		<td>图片</td>
    	</tr>
    	<s:iterator value="#attr.imgList" var="im">
    		<script>
				$("#myImg").attr("src", "<%=basePath%>${im.file_path}");
			</script>
    		<tr>
	    		<td>${im.trueName}</td>
	    		<td><img src="<%=basePath%>${im.file_path}" /></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
