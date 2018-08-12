<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <center><h3>人脸识别信息</h3></center>
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
<form>
<table border="1" align="center" width="800px">
	<tr>
    	<th>用户的名字</th>
        <th>用户的身份证</th>
        <th>Yes or No</th>
        
    </tr>
    
   
    
     <tr>   	
    	<td>&nbsp;&nbsp;&nbsp;${uid }</td>
        <td>&nbsp;&nbsp;&nbsp;${user_info}</td>
        <td>&nbsp;&nbsp;&nbsp;${scores }</td>
        <td>&nbsp;&nbsp;&nbsp;<img src="<%=basePath%>${ FaceUser}" /></td>
       </tr>  
      
</table>
      ${error}
</form>
</html>